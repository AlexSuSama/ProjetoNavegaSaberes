package br.alexsusama.testes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import br.alexsusama.modelo.GeradorDeGraficosBiometria;
import br.alexsusama.modelo.GeradorDeGraficosComercializacao;
import br.alexsusama.persisntencia.SaidaEntradaBiometria;
import br.alexsusama.persisntencia.SaidaEntradaComercializacao;


public class TesteGrafico {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		TesteGrafico teste = new TesteGrafico();
		//teste.criarGrafico();
		//teste.criarGraficoSalinidade();
		//teste.criarGraficoMortalidadeSobrevivencia();
		//teste.criarGraficoTotal();
		//teste.criarGraficoComercializacao();
		teste.gerarPieGrafico();
	}
	public void gerarPieGrafico() {
		GeradorDeGraficosComercializacao grafico= new GeradorDeGraficosComercializacao();
		try {
			SaidaEntradaComercializacao saidaEntrada = new SaidaEntradaComercializacao();
			grafico.gerarGraficoDePizzaComercializacao(saidaEntrada.valoresComercializacaoMunicipio("'2000-03-06'", "'2016-05-05'"),"titulo","parametro a","parametro b");
			grafico.salvarGrafico(new FileOutputStream("pie grafico.png"));
		}catch(SQLException e) {
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void criarGraficoComercializacao() throws FileNotFoundException, IOException {
		GeradorDeGraficosComercializacao grafico= new GeradorDeGraficosComercializacao();
		try {
			SaidaEntradaComercializacao saidaEntrada = new SaidaEntradaComercializacao();
			grafico.graficoDuziasVendidas(saidaEntrada.valoresComercializacaoMunicipio("'2000-03-06'", "'2016-05-05'"),"titulo","parametro a","parametro b");
			grafico.salvarGrafico(new FileOutputStream("comercializacao.png"));
		}catch(SQLException e) {
			
		}
	}
	/*public void criarGraficoTotal() throws FileNotFoundException, IOException {
		GeradorDeGraficosBiometria geradorDeGraficosBiometria = new GeradorDeGraficosBiometria();
		try {
			SaidaEntradaBiometria saidaEntrada = new SaidaEntradaBiometria();
		//geradorDeGraficosBiometria.totalDeOstras(saidaEntrada.biometriasPorPeriodo("'2000-03-06'", "'2016-05-05'", "25"),"aqui","agora","total");
		geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("total.png"));
		}catch(SQLException e) {
			
		}
	}*/
	public void criarGraficoMortalidadeSobrevivencia() throws FileNotFoundException, IOException {
		GeradorDeGraficosBiometria geradorDeGraficosBiometria = new GeradorDeGraficosBiometria();
		try {
			SaidaEntradaBiometria saidaEntrada = new SaidaEntradaBiometria();
		geradorDeGraficosBiometria.graficoPeriodoMortalidadeSobrevivencia(saidaEntrada.biometriasPorPeriodo("'2000-03-06'", "'2016-05-05'", "25"),"aqui","agora","mortalidade X sobrevivência");
		geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("periodoComposto.png"));
		}catch(SQLException e) {
			
		}
	}
	public void criarGrafico() throws FileNotFoundException, IOException {
		GeradorDeGraficosBiometria geradorDeGraficosBiometria = new GeradorDeGraficosBiometria();
		try {
			SaidaEntradaBiometria saidaEntrada = new SaidaEntradaBiometria();
		geradorDeGraficosBiometria.graficoPeriodoDeCrescimento(saidaEntrada.biometriasPorPeriodo("'2000-03-06'", "'2016-05-05'", "25"),"aqui","agora","vai");
		geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("periodoSimples.png"));
		}catch(SQLException e) {
			
		}
	} 
	public void criarGraficoSalinidade() throws FileNotFoundException, IOException {
		GeradorDeGraficosBiometria geradorDeGraficosBiometria = new GeradorDeGraficosBiometria();
		try {
			SaidaEntradaBiometria saidaEntrada = new SaidaEntradaBiometria();
		geradorDeGraficosBiometria.graficoPeriodoSalinidadeTemperatura(saidaEntrada.biometriasPorPeriodo("'2000-03-06'", "'2016-05-05'", "25"),"aqui","agora","Salinidade");
		geradorDeGraficosBiometria.salvarGrafico(new FileOutputStream("periodoSimples.png"));
		}catch(SQLException e) {
			
		}
	}
}
