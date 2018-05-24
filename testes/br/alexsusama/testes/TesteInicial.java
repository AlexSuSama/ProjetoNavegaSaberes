package br.alexsusama.testes;

import java.sql.SQLException;

import br.alexsusama.modelo.Ambiente;
import br.alexsusama.modelo.Biometria;
import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.modelo.Estoque;
import br.alexsusama.modelo.Ostra;
import br.alexsusama.modelo.Povoamento;
import br.alexsusama.persisntencia.SaidaEntradaEstoque;
import br.alexsusama.persisntencia.SaidaEntradaPovoamento;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class TesteInicial {
	public static void main(String[] args) throws SQLException {
		TesteInicial teste = new TesteInicial();
		// teste.testarPovoamentos();
		//teste.testarBiometria();
		// teste.testarComercializacao();
		//teste.testarEstoque();
		
		//SaidaEntradaPovoamento saida = new SaidaEntradaPovoamento();
		
		
		//for(Povoamento a: saida.resgatarPovoamentos()) {
			//System.out.print("ostricultor: "+ a.getNomeOstricultor());
			//System.out.print(" ID: "+a.getIDPovoamentos());
			//System.out.println(" Data ultima biometria: "+a.getMaxData());
			
	//}
		 teste.resgatarEstoque();
	}

	public void testarPovoamentos() {
		int quantidadeSementes = 1000;
		String dataInicial = "13/11/2016";
		String nomeOstricultor = "geraldo cris da silva";
		String localidade = "algum lugar qualquer";
		String municipio = "braganciado";

		Povoamento povoamento01 = new Povoamento(quantidadeSementes, ValidacaoDeDatas.ordenarData(dataInicial),
				nomeOstricultor, localidade, municipio);
		povoamento01.printarPovoamento(); 
		// povoamento01.criarPovoamento();
		// povoamento01.excluirPovoamento("18");
		povoamento01.editarPovoamentos("25");

	}

	public void testarBiometria() { 
		Ostra ostra = new Ostra("juvenil", 3000, 2250);
		Ambiente ambiente = new Ambiente(23, 22);
		String data = "13/12/2016";
		String sistemaProducao = "long line";
		double mediaCrescimento = 65.4;
		double mortalidade = 1.4;
		double sobrevivencia = 2.4;

		Biometria biometria = new Biometria(ValidacaoDeDatas.ordenarData(data), sistemaProducao, mediaCrescimento,
				mortalidade, sobrevivencia, ostra, ambiente);
		 biometria.criarBiometria("21");
		// biometria.excluirBiometria("10");
		//biometria.editarBiometria("8");
	}

	public void testarComercializacao() {
		String nomeComprador = "Vingador do infinito céu azul";
		String tipoDeComprador = "pessoa fisica";
		String municipio = "bragacity";
		String localidade = "minha house";
		String tipoComercializado = "media";
		int valorVenda = 3000;
		int qtVendidas = 2500;
		String dataVenda = "21/02/2015";
		Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoDeComprador, municipio, localidade,
				tipoComercializado, qtVendidas, ValidacaoDeDatas.ordenarData(dataVenda), valorVenda);
		// comercializacao.criarComercializacao();
		// comercializacao.editarComercializacao("2");
		comercializacao.excluirComercializacao("1");
	}

	public void testarEstoque() {
		String data_estoque = "21/02/2003";
		int semente = 29000;
		int juvenil = 300;
		int baby = 400;
		int media = 500;
		int master = 600;

		int malha12 = 12;
		int malha14 = 14;
		int malha21 = 21;
		int malha69 = 69;

		int coletores = 1;
		int mesaMadeira = 2;
		int mesaPVC = 3;
		int mesaTelada = 4;
		int longLine = 5;
		int varal = 10;

		Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data_estoque), baby, semente, media, master, juvenil,
				malha69, malha12, malha14, malha21, longLine, varal, mesaTelada, mesaPVC, mesaMadeira, coletores);
		// estoque.criarEstoque();
		//estoque.atualizarEstoque("2");
		estoque.excluirEstoque("1");
	}
	public void resgatarEstoque(){
		SaidaEntradaEstoque saida = new SaidaEntradaEstoque();
		Estoque estoque = saida.resgatarEstoque();
		System.out.println(estoque.getColetores());
		System.out.println(estoque.getMalha12());
		System.out.println(estoque.getMalha14());
		System.out.println(estoque.getMalha21());
		System.out.println(estoque.getDataEstoque());
		
	}
}
