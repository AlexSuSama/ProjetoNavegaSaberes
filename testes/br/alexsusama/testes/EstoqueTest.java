package br.alexsusama.testes;

import static org.junit.Assert.*;

import org.junit.Test;

import br.alexsusama.modelo.Estoque;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class EstoqueTest {

	@Test
	public void criarEstoqueOstraNormal() {
		String data = "12/05/2013";
		int idEstoque;
		// ostras em estoque
		int ostraBaby = 1000;
		int ostraSemente = 10000;
		int ostraJuvenil = 300;
		int ostraMaster = 400;
		int ostraMedia = 450;
		// apetrechos / malhas
		int malha69 = 13;
		int malha12 = 20;
		int malha14 = 30;
		int malha21 = 12;

		// sistema usados
		int longLine = 10;
		int mesaMadeira = 13;
		int mesaTelada = 15;
		int mesaPVC = 20;
		int coletores = 1;
		int varal = 10;

		Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data),ostraBaby, ostraSemente, ostraMedia, ostraMaster, ostraJuvenil, malha69, malha12,
				malha14, malha21, longLine, varal, mesaTelada, mesaPVC, mesaMadeira, coletores);
		assertEquals(1000,estoque.getOstraBaby(),0.00001);
		assertEquals(10000,estoque.getOstraSemente(),0.00001);
		assertEquals(300,estoque.getOstraJuvenil(),0.00001);
		assertEquals(450,estoque.getOstraMedia(),0.00001);
		assertEquals(400,estoque.getOstraMaster(),0.00001);
	}
	@Test(expected = IllegalArgumentException.class)
	public void criarEstoqueOstraNegativa() {
		int idEstoque;
		// ostras em estoque
		int ostraBaby = 1000;
		int ostraSemente = -10000;
		int ostraJuvenil = 300;
		int ostraMaster = 400;
		int ostraMedia = 450;
		// apetrechos / malhas
		int malha69 = 13;
		int malha12 = 20;
		int malha14 = 30;
		int malha21 = 12;

		// sistema usados
		int longLine = 10;
		int mesaMadeira = 13;
		int mesaTelada = 15;
		int mesaPVC = 20;
		int coletores = 1;
		int varal = 10;
		String data = "09/09/2007";
		Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data),ostraBaby, ostraSemente, ostraMedia, ostraMaster, ostraJuvenil, malha69, malha12,
				malha14, malha21, longLine, varal, mesaTelada, mesaPVC, mesaMadeira, coletores);
		assertEquals(1000,estoque.getOstraBaby(),0.00001);
		assertEquals(10000,estoque.getOstraSemente(),0.00001);
		assertEquals(300,estoque.getOstraJuvenil(),0.00001);
		assertEquals(450,estoque.getOstraMedia(),0.00001);
		assertEquals(400,estoque.getOstraMaster(),0.00001);
	}
	@Test
	public void criarEstoqueSistemaProducaoNormal() {
		String data = "13/01/2001";
		int idEstoque;
		// ostras em estoque
		int ostraBaby = 1000;
		int ostraSemente = 10000;
		int ostraJuvenil = 300;
		int ostraMaster = 400;
		int ostraMedia = 450;
		// apetrechos / malhas
		int malha69 = 13;
		int malha12 = 20;
		int malha14 = 30;
		int malha21 = 12;

		// sistema usados
		int longLine = 10;
		int mesaMadeira = 13;
		int mesaTelada = 15;
		int mesaPVC = 20;
		int coletores = 1;
		int varal = 10;

		Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data),ostraBaby, ostraSemente, ostraMedia, ostraMaster, ostraJuvenil, malha69, malha12,
				malha14, malha21, longLine, varal, mesaTelada, mesaPVC, mesaMadeira, coletores);
		assertEquals(10,estoque.getLongLine(),0.00001);
		assertEquals(13,estoque.getMesaMadeira(),0.00001);
		assertEquals(20,estoque.getMesaPVC(),0.00001);
		assertEquals(15,estoque.getMesaTelada(),0.00001);
		assertEquals(1,estoque.getColetores(),0.00001);
		assertEquals(10,estoque.getVaral(),0.00001);
	}
	@Test(expected = IllegalArgumentException.class)
	public void criarEstoqueSistemaProducaoNegativo() {
		int idEstoque;
		// ostras em estoque
		int ostraBaby = 1000;
		int ostraSemente = 10000;
		int ostraJuvenil = 300;
		int ostraMaster = 400;
		int ostraMedia = 450;
		// apetrechos / malhas
		int malha69 = 13;
		int malha12 = 20;
		int malha14 = 30;
		int malha21 = 12;

		// sistema usados
		int longLine = 10;
		int mesaMadeira = 13;
		int mesaTelada = 15;
		int mesaPVC = -20;
		int coletores = 1;
		int varal = 10;
		String data = "12/09/2002";
		Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data),ostraBaby, ostraSemente, ostraMedia, ostraMaster, ostraJuvenil, malha69, malha12,
				malha14, malha21, longLine, varal, mesaTelada, mesaPVC, mesaMadeira, coletores);
		assertEquals(10,estoque.getLongLine(),0.00001);
		assertEquals(13,estoque.getMesaMadeira(),0.00001);
		assertEquals(20,estoque.getMesaPVC(),0.00001);
		assertEquals(15,estoque.getMesaTelada(),0.00001);
		assertEquals(1,estoque.getColetores(),0.00001);
		assertEquals(10,estoque.getVaral(),0.00001);
	}
	@Test
	public void criarEstoqueApetrechosNormal() {
		int idEstoque;
		// ostras em estoque
		int ostraBaby = 1000;
		int ostraSemente = 10000;
		int ostraJuvenil = 300;
		int ostraMaster = 400;
		int ostraMedia = 450;
		// apetrechos / malhas
		int malha69 = 13;
		int malha12 = 20;
		int malha14 = 30;
		int malha21 = 12;

		// sistema usados
		int longLine = 10;
		int mesaMadeira = 13;
		int mesaTelada = 15;
		int mesaPVC = 20;
		int coletores = 1;
		int varal = 10;
		String data = "09/09/2009";
		Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data),ostraBaby, ostraSemente, ostraMedia, ostraMaster, ostraJuvenil, malha69, malha12,
				malha14, malha21, longLine, varal, mesaTelada, mesaPVC, mesaMadeira, coletores);
		assertEquals(13,estoque.getMalha69(),0.00001);
		assertEquals(20,estoque.getMalha12(),0.00001);
		assertEquals(30,estoque.getMalha14(),0.00001);
		assertEquals(12,estoque.getMalha21(),0.00001);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void criarEstoqueApetrechosNegativo() {
		int idEstoque;
		// ostras em estoque
		int ostraBaby = 1000;
		int ostraSemente = 10000;
		int ostraJuvenil = 300;
		int ostraMaster = 400;
		int ostraMedia = 450;
		// apetrechos / malhas
		int malha69 = -13;
		int malha12 = 20;
		int malha14 = 30;
		int malha21 = 12;

		// sistema usados
		int longLine = 10;
		int mesaMadeira = 13;
		int mesaTelada = 15;
		int mesaPVC = 20;
		int coletores = 1;
		int varal = 10;
		String data = "09/08/2007";
		Estoque estoque = new Estoque(ValidacaoDeDatas.ordenarData(data),ostraBaby, ostraSemente, ostraMedia, ostraMaster, ostraJuvenil, malha69, malha12,
				malha14, malha21, longLine, varal, mesaTelada, mesaPVC, mesaMadeira, coletores);
		assertEquals(-13,estoque.getMalha69(),0.00001);
		assertEquals(20,estoque.getMalha12(),0.00001);
		assertEquals(30,estoque.getMalha14(),0.00001);
		assertEquals(12,estoque.getMalha21(),0.00001);
		
	}
}
