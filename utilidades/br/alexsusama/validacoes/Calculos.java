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
	public Double formatDouble(double x) {
		DecimalFormat df = new DecimalFormat("#0.00");
		return Double.valueOf(df.format(x));
	}
	
	public static double log(double base, double valor) {
        return Math.log(valor) / Math.log(base);
    }	
	public static double calcularMortalidade(int unidadesTotal, int unidadesPerdidas) {
		double divisao = unidadesTotal/unidadesPerdidas;
		double mortalidade = divisao * log(10, 2.71828182846);
		return mortalidade;
	}
}
