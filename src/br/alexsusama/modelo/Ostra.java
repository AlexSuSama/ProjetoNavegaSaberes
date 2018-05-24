package br.alexsusama.modelo;

public class Ostra {
	private String estagioCrescimento;
	private int quantidadeTotal;
	private int quantidadeMorta;

	public Ostra(String estagioCrescimento, int quantidadeTotal, int quantidadeMorta) {
		if (!(estagioCrescimento == null || quantidadeTotal == 0 || quantidadeMorta == 0)) {
			if (quantidadeTotal >= 0 && quantidadeMorta >= 0) {
				if (quantidadeMorta <= quantidadeTotal) {
					this.estagioCrescimento = estagioCrescimento;
					this.quantidadeTotal = quantidadeTotal;
					this.quantidadeMorta = quantidadeMorta;
				} else {
					throw new IllegalArgumentException("número de ostras mortas é maior que a quantidade total");
				}
			} else {
				throw new IllegalArgumentException("quantidades total e morta invalidas");
			}
		} else {
			throw new IllegalArgumentException("valores invalidos");
		}
	}

	public String getEstagioCrescimento() {
		return estagioCrescimento;
	}

	public void setEstagioCrescimento(String estagioCrescimento) {
		this.estagioCrescimento = estagioCrescimento;
	}

	public int getQuantidadeTotal() {
		return quantidadeTotal;
	}

	public void setQuantidadeTotal(int quantidadeTotal) {
		this.quantidadeTotal = quantidadeTotal;
	}

	public int getQuantidadeMorta() {
		return quantidadeMorta;
	}

	public void setQuantidadeMorta(int quantidadeMorta) {
		this.quantidadeMorta = quantidadeMorta;
	}

	public void printarOstra() {
		System.out.println("print ostra");
		System.out.println("estagio de crescimento: " + estagioCrescimento);
		System.out.println("quantidade total: " + quantidadeTotal);
		System.out.println("quantidade morta: " + quantidadeMorta);
	}
}
