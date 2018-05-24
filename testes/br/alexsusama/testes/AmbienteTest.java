package br.alexsusama.testes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import br.alexsusama.modelo.Ambiente;

public class AmbienteTest {

	@Test
	public void ambienteNormal() {
		int temperatura = 22;
		int salinidade = 24;
		Ambiente ambiente = new Ambiente(temperatura, salinidade);
	
		Assert.assertEquals(22, ambiente.getTemperatura(),0.00001);
		Assert.assertEquals(24, ambiente.getSalinidade(),0.00001);
	}
	@Test(expected = IllegalArgumentException.class)
	public void ambienteTemperaturaAcimaCemGraus() {
		int temperatura = 104;
		int salinidade = 24;
		Ambiente ambiente = new Ambiente(temperatura, salinidade);
	
		Assert.assertEquals(104, ambiente.getTemperatura(),0.00001);
		Assert.assertEquals(24, ambiente.getSalinidade(),0.00001);
	}
	@Test(expected = IllegalArgumentException.class)
	public void ambienteSalinidadeAbaixoDeZero() {
		int temperatura = 104;
		int salinidade = -7;
		Ambiente ambiente = new Ambiente(temperatura, salinidade);
	
		Assert.assertEquals(104, ambiente.getTemperatura(),0.00001);
		Assert.assertEquals(-7, ambiente.getSalinidade(),0.00001);
	}
	@Test(expected = IllegalArgumentException.class)
	public void ambienteValoresInvalidos() {
		int temperatura = 5;
		int salinidade = 0;
		Ambiente ambiente = new Ambiente(temperatura, salinidade);
	
		Assert.assertEquals(-5, ambiente.getTemperatura(),0.00001);
		Assert.assertEquals(22, ambiente.getSalinidade(),0.00001);
	}

}
