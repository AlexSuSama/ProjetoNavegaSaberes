package br.alexsusama.modelo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.alexsusama.persisntencia.SaidaEntradaBiometria;
import br.alexsusama.persisntencia.SaidaEntradaComercializacao;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class GeradorDePDF {
	String povoamento;
	String nomeProdutor;

	String grausLat;
	String minutosLat;
	String segundosLat;

	String grausLong;
	String minutosLong;
	String segundosLong;

	String totalOstrasFinal;
	String totalOstrasInicial;
	String totalMorta;
	String estagioCrescimento;

	String semente;
	String baby;
	String media;
	String juvenil;
	String master;

	public void criarPDFCompleto(String path, String dataInicial, String dataFinal, String idPovoamento,
			int tipoRelatorio, int titulo) throws DocumentException, MalformedURLException, IOException {
		Povoamento povoamento = new Povoamento();
		SaidaEntradaPovoamento saidaEntradaPovoamento = new SaidaEntradaPovoamento();

		SaidaEntradaBiometria saidaEntradaBiometria = new SaidaEntradaBiometria();
		GeradorDeGraficosBiometria geradorDeGraficosBiometria = new GeradorDeGraficosBiometria();

		SaidaEntradaComercializacao saidaEntradaComercializacao = new SaidaEntradaComercializacao();
		GeradorDeGraficosComercializacao geradorDeGraficosComercializacao = new GeradorDeGraficosComercializacao();

		Biometria biometriaFinal = new Biometria();
		Biometria biometriaInicial = new Biometria();

		try {
			povoamento = saidaEntradaPovoamento.resgatarPovoamento(idPovoamento);
			biometriaFinal = saidaEntradaBiometria.resgatarUltimaBiometria(idPovoamento,
					ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial),
					ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal));

			biometriaInicial = saidaEntradaBiometria.resgatarPrimeiraBiometria(idPovoamento,
					ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial),
					ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal));

			this.povoamento = String.valueOf(povoamento.getIDPovoamentos());
			this.nomeProdutor = povoamento.getNomeOstricultor();
			this.grausLat = String.valueOf(povoamento.getGrausLat());
			this.minutosLat = String.valueOf(povoamento.getMinutosLat());
			this.segundosLat = String.valueOf(povoamento.getSegundosLat());

			this.grausLong = String.valueOf(povoamento.getGrausLong());
			this.minutosLong = String.valueOf(povoamento.getMinutosLong());
			this.segundosLong = String.valueOf(povoamento.getSegundosLong());

			this.totalOstrasFinal = String.valueOf(biometriaFinal.getQtTotal());
			this.totalMorta = String.valueOf(biometriaFinal.getQtMorta());

			this.totalOstrasInicial = String.valueOf(biometriaInicial.getQtTotal());

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			geradorDeGraficosBiometria.graficoTotalDeOstras(
					saidaEntradaBiometria.biometriasPorPeriodo(
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento),
					"Total de unidades", "Período", "Quantidade");

			geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("Report_total_ostras.png"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}
		try {
			geradorDeGraficosBiometria.graficoPeriodoDeCrescimento(
					saidaEntradaBiometria.biometriasPorPeriodo(
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento),
					"Médias de crescimento", "Período", "mm");

			geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("Report_media_crescimento.png"));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}
		try {
			geradorDeGraficosBiometria.graficoPeriodoMortalidadeSobrevivencia(
					saidaEntradaBiometria.biometriasPorPeriodo(
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento),
					"Mortalidade", "Período", "taxa");
			geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("Report_mortalidade_sobrevivencia.png"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}
		// imagem grafico mortalidade
		Image imgGraficoMortalidadeSobrevivencia = Image.getInstance("Report_mortalidade_sobrevivencia.png");
		imgGraficoMortalidadeSobrevivencia.scalePercent(65);

		// imagem grafico média crescimeto
		Image imgGraficoMediaCrescimento = Image.getInstance("Report_media_crescimento.png");
		imgGraficoMediaCrescimento.scalePercent(65);

		// imagem total de ostras
		Image imgGraficoTotalOstras = Image.getInstance("Report_total_ostras.png");
		imgGraficoTotalOstras.scalePercent(65);

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
		document.open();

		// fontes
		Font negritoItalicoTitulo = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, BaseColor.BLACK);
		//Font negritoTexto = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLDITALIC, BaseColor.BLACK);

		//Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

		// biometria
		Chunk biometriaChunk = new Chunk("Biometria");

		biometriaChunk.setFont(negritoItalicoTitulo);
		// ambiente
		Chunk ambienteChunk = new Chunk("Ambiente");
		ambienteChunk.setFont(negritoItalicoTitulo);

		// comercializacao
		Chunk comercializacaoChunk = new Chunk("Comercialização");
		comercializacaoChunk.setFont(negritoItalicoTitulo);

		Chapter chapterRelatorio = new Chapter(new Paragraph(biometriaChunk), 1);

		if (titulo == 1) {
			chapterRelatorio.add(new Paragraph(
					"Povoamento: " + this.povoamento + "                        Produtor: " + this.nomeProdutor + ""));
			chapterRelatorio.add(new Paragraph("Coordenadas do povoamento latitude: " + this.grausLat + "° "
					+ this.minutosLat + " e " + this.segundosLat + ""));
			chapterRelatorio.add(new Paragraph("Coordenadas do povoamento longitude: " + this.grausLong + "° "
					+ this.minutosLong + " e " + this.segundosLong + ""));
			Paragraph paragrafoBiometria = new Paragraph(
					"Relatório biométrico referente ao período: " + dataInicial + " a " + dataFinal + "");
			chapterRelatorio.add(paragrafoBiometria);
		}

		// imagem referente a quantidade de ostras
		Paragraph paragrafoBiometriaTotalOstras = new Paragraph("Quantidade total de ostras: " + this.totalOstrasFinal);
		paragrafoBiometriaTotalOstras.setFont(new Font(negritoItalicoTitulo));
		chapterRelatorio.add(paragrafoBiometriaTotalOstras);
		chapterRelatorio.add(imgGraficoTotalOstras);
		chapterRelatorio.add(new Paragraph("a quantidade de ostras no inicio do período era " + this.totalOstrasInicial
				+ " e foi para " + totalOstrasFinal));

		chapterRelatorio.add(new Paragraph("Médias de Crescimento:"));
		chapterRelatorio.add(imgGraficoMediaCrescimento);

		// imagem referente a taxa de mortalidade
		chapterRelatorio.add(new Paragraph("Variação da taxa de mortalidade no periodo"));
		chapterRelatorio.add(imgGraficoMortalidadeSobrevivencia);
		chapterRelatorio.add(new Paragraph("O número de ostras mortas nesse periodo foi: " + this.totalMorta));

		Paragraph paragraphAmbiente = new Paragraph(ambienteChunk);
		paragraphAmbiente.setFont(negritoItalicoTitulo);

		Chapter chapterAmbiente = new Chapter(paragraphAmbiente, 2);
		if (titulo == 2) {
			chapterAmbiente.add(new Paragraph(
					"Povoamento: " + this.povoamento + "                        Produtor: " + this.nomeProdutor + ""));
			chapterAmbiente.add(new Paragraph("Coordenadas do povoamento latitude: " + this.grausLat + "° "
					+ this.minutosLat + " e " + this.segundosLat + ""));
			chapterAmbiente.add(new Paragraph("Coordenadas do povoamento longitude: " + this.grausLong + "° "
					+ this.minutosLong + " e " + this.segundosLong + ""));
			Paragraph paragrafoAmbiente = new Paragraph(
					"Relatório biométrico referente ao período: " + dataInicial + " a " + dataFinal + "");
			chapterAmbiente.add(paragrafoAmbiente);
		}

		Paragraph paragrafoVariacaoTemperatura = new Paragraph("Variação de temperatura");
		chapterAmbiente.add(paragrafoVariacaoTemperatura);
		// gerar imagem da variação de temperatura
		try {
			geradorDeGraficosBiometria.graficoPeriodoTemperatura(
					saidaEntradaBiometria.biometriasPorPeriodo(
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento),
					"Temperatura", "Período", "Graus (C°)");
			geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("Report_temperatura.png"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}
		// imagem de variação da temperatura
		Image imgGraficoTemperatura = Image.getInstance("Report_temperatura.png");
		imgGraficoTemperatura.scalePercent(65);

		chapterAmbiente.add(imgGraficoTemperatura);

		Paragraph paragrafoVariacaoSalinidade = new Paragraph("Variação de salinidade");
		chapterAmbiente.add(paragrafoVariacaoSalinidade);

		// gerar imagem da variação de salinidade
		try {
			geradorDeGraficosBiometria.graficoPeriodoSalinidade(
					saidaEntradaBiometria.biometriasPorPeriodo(
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento),
					"Salinidade", "Período", "ppm");
			geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("Report_salinidade.png"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}
		// imagem de variação da temperatura
		Image imgGraficoSalinidade = Image.getInstance("Report_salinidade.png");
		imgGraficoSalinidade.scalePercent(65);

		chapterAmbiente.add(imgGraficoSalinidade);
		// comercialização
		Paragraph paragrafoComercializacao = new Paragraph(comercializacaoChunk);
		paragrafoComercializacao.setFont(negritoItalicoTitulo);
		Chapter chapterComercializacao = new Chapter(paragrafoComercializacao, 3);
		if (titulo == 3) {
			chapterComercializacao.add(new Paragraph(
					"Povoamento: " + this.povoamento + "                        Produtor: " + this.nomeProdutor + ""));
			chapterComercializacao.add(new Paragraph("Coordenadas do povoamento latitude: " + this.grausLat + "° "
					+ this.minutosLat + " e " + this.segundosLat + ""));
			chapterComercializacao.add(new Paragraph("Coordenadas do povoamento longitude: " + this.grausLong + "° "
					+ this.minutosLong + " e " + this.segundosLong + ""));
			Paragraph comercializacaoParagrafo = new Paragraph(
					"Relatório biométrico referente ao período: " + dataInicial + " a " + dataFinal + "");
			chapterAmbiente.add(comercializacaoParagrafo);
		}
		Paragraph paragrafoAreasComercilizcao = new Paragraph(
				"Áreas de comercialização no período " + dataInicial + " até " + dataFinal);
		chapterComercializacao.add(paragrafoAreasComercilizcao);

		try {
			geradorDeGraficosComercializacao.gerarGraficoDePizzaComercializacao(
					saidaEntradaComercializacao.valoresComercializacaoMunicipio(
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento),
					"Áreas de comercilização", "Período", "agora");
			geradorDeGraficosComercializacao.salvarGrafico(new FileOutputStream("Report_areasDeVenda.png"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}

		Image imgGraficoAreasComercializacao = Image.getInstance("Report_areasDeVenda.png");
		imgGraficoAreasComercializacao.scalePercent(65);
		chapterComercializacao.add(imgGraficoAreasComercializacao);

		Paragraph paragrafoDuziasVendidas = new Paragraph("Quantidade de duzias vendida por município:");
		chapterComercializacao.add(paragrafoDuziasVendidas);
		try {
			geradorDeGraficosComercializacao.graficoDuziasVendidas(
					saidaEntradaComercializacao.valoresComercializacaoMunicipio(
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
							"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento),
					"Quantidade de duzias vendidas", "Período", "Duzias");
			geradorDeGraficosComercializacao.salvarGrafico(new FileOutputStream("Report_duziasVendidas.png"));

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}
		Image imgGraficoDuziasVendidas = Image.getInstance("Report_duziasVendidas.png");
		imgGraficoDuziasVendidas.scalePercent(65);
		chapterComercializacao.add(imgGraficoDuziasVendidas);

		Paragraph paragrafoValorDoFrete = new Paragraph("Valor do frete para cada município");
		paragrafoValorDoFrete.setSpacingAfter(30.0f);
		chapterComercializacao.add(paragrafoValorDoFrete);
		chapterComercializacao.add(new Paragraph(""));
		try {

			List<Comercializacao> listaComercializacao = saidaEntradaComercializacao.valoresComercializacaoMunicipio(
					"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataInicial) + "'",
					"'" + ValidacaoDeDatas.padronizarDatasParaBusca(dataFinal) + "'", idPovoamento);

			for (Comercializacao comercializacao : listaComercializacao) {

				Paragraph paragraph = new Paragraph(
						"         " + comercializacao.getMunicipio() + ": " + comercializacao.getValorFrete());
				chapterComercializacao.add(paragraph);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau na hora de gerar o relatório");
			e.printStackTrace();
		}

		// aparentemente cada capitulo fica em uma determinada pagina
		switch (tipoRelatorio) {
		case 1:
			document.add(chapterRelatorio);
			document.add(chapterAmbiente);
			document.add(chapterComercializacao);
			System.out.println("relatório completo");
			break;
		case 2:
			document.add(chapterRelatorio);
			document.add(chapterAmbiente);
			// document.add(chapterComercializacao);
			System.out.println("relatório parcial biometria e ambiente");
			break;
		case 3:
			document.add(chapterRelatorio);
			// document.add(chapterAmbiente);
			document.add(chapterComercializacao);
			System.out.println("relatório parcial biometria e comercializacao");
			break;
		case 4:
			// document.add(chapterRelatorio);
			document.add(chapterAmbiente);
			document.add(chapterComercializacao);
			System.out.println("relatório parcial ambiente e comercializacao");
			break;
		case 5:
			// document.add(chapterRelatorio);
			// document.add(chapterAmbiente);
			document.add(chapterComercializacao);
			System.out.println("relatório comercilizacao");
			break;
		case 6:
			// document.add(chapterRelatorio);
			document.add(chapterAmbiente);
			// document.add(chapterComercializacao);
			System.out.println("relatório ambiente");
			break;
		case 7:
			document.add(chapterRelatorio);
			// document.add(chapterAmbiente);
			// document.add(chapterComercializacao);
			System.out.println("relatório biometria");
			break;
		default:
			break;
		}
		document.close();
		JOptionPane.showMessageDialog(null, "Relatório gerado!");
		System.out.println("done");
	}
}
