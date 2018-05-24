package br.alexsusama.testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.alexsusama.modelo.Ostra;

public class OstraTest {

	@Test
	public void ostraNormal() {
		int quantidadeTotal = 2000;
		int quantidadeMorta = 200;
		String estagioCrescimento = "Juvenil";
		Ostra ostra01 = new Ostra(estagioCrescimento, quantidadeTotal, quantidadeMorta);
	
	Assert.assertEquals(2000, ostra01.getQuantidadeTotal(), 0.00001);
	Assert.assertEquals(200, ostra01.getQuantidadeMorta(),0.00001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ostraComValoresNegativos() {
		int quantidadeTotal = -2000;
		int quantidadeMorta = 5;
		String estagioCrescimento = "Juvenil";
		Ostra ostra01 = new Ostra(estagioCrescimento, quantidadeTotal, quantidadeMorta);
	
	Assert.assertEquals(-200, ostra01.getQuantidadeTotal(), 0.00001);
	Assert.assertEquals(-2, ostra01.getQuantidadeMorta(),0.00001);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ostraMortasMaiorQueOstrasTotal() {
		int quantidadeTotal = 499;
		int quantidadeMorta = 500;
		String estagioCrescimento = "Juvenil";
		Ostra ostra01 = new Ostra(estagioCrescimento, quantidadeTotal, quantidadeMorta);
	
	Assert.assertEquals(300, ostra01.getQuantidadeTotal(), 0.00001);
	Assert.assertEquals(500, ostra01.getQuantidadeMorta(),0.00001);
	}

}
