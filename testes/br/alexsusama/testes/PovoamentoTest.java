package br.alexsusama.testes;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import br.alexsusama.modelo.Povoamento;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class PovoamentoTest {

	@Test
	public void povoamnetoNormal() {
		int quantidadeSementes = 2000;
		String dataInicial = "12/12/2003";
		String nomeOstricultor = "Aleksandro da Silva Oliveira";
		String localidade = "julia quadros";
		String municipio = "bragança";
		
		int grausLa = 21, minutosLa = 34;
		double segundosLa = 2.2;
		
		int grausLo = 7, minutosLo = 9;
		double segundosLo = 2.2;
		
		Povoamento povoamento01 = new Povoamento(quantidadeSementes, ValidacaoDeDatas.ordenarData(dataInicial),
				nomeOstricultor, localidade, municipio, grausLa, minutosLa, segundosLa, grausLo, minutosLo, segundosLo);
	
	Assert.assertEquals(2000, povoamento01.getQuantidadeSementes(),0.00001);
	//para latitude
	Assert.assertEquals(21, povoamento01.getGrausLat(),0.00001);
	Assert.assertEquals(34, povoamento01.getMinutosLat(),0.00001);
	Assert.assertEquals(2.2, povoamento01.getSegundosLat(),0.00001);
	// para longitude
	Assert.assertEquals(7, povoamento01.getGrausLong(),0.00001);
	Assert.assertEquals(9, povoamento01.getMinutosLong(),0.00001);
	Assert.assertEquals(2.2, povoamento01.getSegundosLong(),0.00001);
	
	}
	@Test(expected=IllegalArgumentException.class)
	public void povoamnetoAbsurdo() {
		int quantidadeSementes = 2000;
		String dataInicial = "12/12/2003";
		String nomeOstricultor = "Aleksandro da Silva Oliveira";
		String localidade = "julia quadros";
		String municipio = "bragança";
		
		int grausLa =34, minutosLa = 34;
		double segundosLa = 2.2;
		
		int grausLo = 17, minutosLo = 9;
		double segundosLo = 2.2;
		
		Povoamento povoamento01 = new Povoamento(quantidadeSementes, ValidacaoDeDatas.ordenarData(dataInicial),
				nomeOstricultor, localidade, municipio, grausLa, minutosLa, segundosLa, grausLo, minutosLo, segundosLo);
	
		povoamento01.printarPovoamento();
	
	Assert.assertEquals(2000, povoamento01.getQuantidadeSementes(),0.00001);
	//para latitude
	Assert.assertEquals(134, povoamento01.getGrausLat(),0.00001);
	Assert.assertEquals(34, povoamento01.getMinutosLat(),0.00001);
	Assert.assertEquals(2.2, povoamento01.getSegundosLat(),0.00001);
	// para longitude
	Assert.assertEquals(17, povoamento01.getGrausLong(),0.00001);
	Assert.assertEquals(9, povoamento01.getMinutosLong(),0.00001);
	Assert.assertEquals(2.2, povoamento01.getSegundosLong(),0.00001);
	
	}

}




