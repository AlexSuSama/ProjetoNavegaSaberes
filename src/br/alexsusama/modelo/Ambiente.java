package br.alexsusama.modelo;

public class Ambiente {
	private int temperatura;
	private int salinidade;

	public Ambiente(int temperatura, int salinidade) {
		if (!(temperatura == 0 || salinidade == 0)) {
			if (temperatura <= 100) {
				if (salinidade >= 0) {
					this.temperatura = temperatura;
					this.salinidade = salinidade;
				} else {
					throw new IllegalArgumentException("valor da salinidade invalido");
				}
			} else {
				throw new IllegalArgumentException("valor da temperatura invalido");
			}
		} else {
			throw new IllegalArgumentException("valores invalidos");
		}
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getSalinidade() {
		return salinidade;
	}

	public void setSalinidade(int salinidade) {
		this.salinidade = salinidade;
	}

	public void printAmbiente() {
		System.out.println("print ambiente");
		System.out.println("temperatura: " + temperatura);
		System.out.println("salinidade: " + salinidade);
	}
}
