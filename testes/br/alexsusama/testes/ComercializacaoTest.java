package br.alexsusama.testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class ComercializacaoTest {

	@Test
	public void testComercializacaoNormal() {
		String nomeComprador = "Alex Su Sama";
		String tipoDeComprador = "pessoa fisica";
		String municipio = "braganca";
		String localidade = "minha roal";
		String tipoComercializado = "pessoa fisica";
		String dataVenda = "12/04/2004";
		int qtVendidas = 2300;
		int valorVenda = 2345;

		Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoDeComprador, municipio, localidade,
				tipoComercializado, qtVendidas, ValidacaoDeDatas.ordenarData(dataVenda), valorVenda);

		Assert.assertEquals(2300, comercializacao.getQtVendidas(), 0.00001);
		Assert.assertEquals(2345, comercializacao.getValorVenda(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testComercializacaoValorNegativo() {
		String nomeComprador = "Alex Su Sama";
		String tipoDeComprador = "pessoa fisica";
		String municipio = "braganca";
		String localidade = "minha roal";
		String tipoComercializado = "pessoa fisica";
		String dataVenda = "12/04/2004";
		int qtVendidas = 2300;
		int valorVenda = -2345;

		Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoDeComprador, municipio, localidade,
				tipoComercializado, qtVendidas, ValidacaoDeDatas.ordenarData(dataVenda), valorVenda);

		Assert.assertEquals(2300, comercializacao.getQtVendidas(), 0.00001);
		Assert.assertEquals(2345, comercializacao.getValorVenda(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testComercializacaoQuantidadeNegativa() {
		String nomeComprador = "Alex Su Sama";
		String tipoDeComprador = "pessoa fisica";
		String municipio = "braganca";
		String localidade = "minha roal";
		String tipoComercializado = "pessoa fisica";
		String dataVenda = "12/04/2004";
		int qtVendidas = -2300;
		int valorVenda = 2345;

		Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoDeComprador, municipio, localidade,
				tipoComercializado, qtVendidas, ValidacaoDeDatas.ordenarData(dataVenda), valorVenda);

		Assert.assertEquals(2300, comercializacao.getQtVendidas(), 0.00001);
		Assert.assertEquals(2345, comercializacao.getValorVenda(), 0.00001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testComercializacaoValoresNulos() {
		String nomeComprador = null;
		String tipoDeComprador = "pessoa fisica";
		String municipio = null;
		String localidade = "minha roal";
		String tipoComercializado = "pessoa fisica";
		String dataVenda = "12/04/2004";
		int qtVendidas = 2300;
		int valorVenda = 2345;

		Comercializacao comercializacao = new Comercializacao(nomeComprador, tipoDeComprador, municipio, localidade,
				tipoComercializado, qtVendidas, ValidacaoDeDatas.ordenarData(dataVenda), valorVenda);

		Assert.assertEquals(2300, comercializacao.getQtVendidas(), 0.00001);
		Assert.assertEquals(2345, comercializacao.getValorVenda(), 0.00001);
	}
}
