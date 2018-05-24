package br.alexsusama.testes;

import org.junit.Assert;
import org.junit.Test;

import br.alexsusama.modelo.Ambiente;
import br.alexsusama.modelo.Biometria;
import br.alexsusama.modelo.Ostra;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class TesteBiometria {

	@Test
	public void biometriaNormal() {
		String dataRecebida = "21/12/2013";
		String sistemaProducao = "Long line";
		double mediaCrescimento = 0.1;
		double mortalidade = 0.3;
		double sobrevivencia = 0.5;

		String estagioCrescimento = "Baby";
		int quantidadeTotal = 100;
		int quantidadeMorta = 100;

		int temperatura = 32;
		int salinidade = 21;

		Ostra ostra = new Ostra(estagioCrescimento, quantidadeTotal, quantidadeMorta);
		Ambiente ambiente = new Ambiente(temperatura, salinidade);
		Biometria biometria01 = new Biometria(ValidacaoDeDatas.ordenarData(dataRecebida), sistemaProducao,
				mediaCrescimento, mortalidade, sobrevivencia, ostra, ambiente);
		
		Assert.assertEquals(0.1,biometria01.getMediaCrescimento() , 0.00001);
		Assert.assertEquals(0.3,biometria01.getMortalidade() , 0.00001);
		Assert.assertEquals(0.5,biometria01.getSobrevivencia() , 0.00001);
		Assert.assertEquals(100,biometria01.getOstraBiometria().getQuantidadeMorta() , 0.00001);
		Assert.assertEquals(100,biometria01.getOstraBiometria().getQuantidadeTotal() , 0.00001);
		Assert.assertEquals(32,biometria01.getAmbienteBiometria().getTemperatura() , 0.00001);
		Assert.assertEquals(21,biometria01.getAmbienteBiometria().getSalinidade() , 0.00001);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void biometriaAbsurdo() {
		String dataRecebida = "21/12/2013";
		String sistemaProducao = "Long line";
		double mediaCrescimento = -3;
		double mortalidade = 0.3;
		double sobrevivencia = 0.5;

		String estagioCrescimento = "Baby";
		int quantidadeTotal =12;
		int quantidadeMorta = 2; 

		int temperatura = 32;
		int salinidade = 21;

		Ostra ostra = new Ostra(estagioCrescimento, quantidadeTotal, quantidadeMorta);
		Ambiente ambiente = new Ambiente(temperatura, salinidade);
		Biometria biometria01 = new Biometria(ValidacaoDeDatas.ordenarData(dataRecebida), sistemaProducao,
				mediaCrescimento, mortalidade, sobrevivencia, ostra, ambiente);
		
		Assert.assertEquals(0.1,biometria01.getMediaCrescimento() , 0.00001);
		Assert.assertEquals(0.3,biometria01.getMortalidade() , 0.00001);
		Assert.assertEquals(0.5,biometria01.getSobrevivencia() , 0.00001);
		
	}
	
}







