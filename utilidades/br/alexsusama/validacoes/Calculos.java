package br.alexsusama.validacoes;

import java.text.DecimalFormat;

public class Calculos {
	public double calculoDaMedia(double amostra, int contador) {
		double valor = amostra;
		double calculoMedia = valor / contador;

		return calculoMedia;
	}
	public String format(double x) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return df.format(x);
	}
}
