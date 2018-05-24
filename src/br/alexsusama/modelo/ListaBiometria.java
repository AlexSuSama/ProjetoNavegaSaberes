package br.alexsusama.modelo;

public class ListaBiometria {
	private String dataInicial;
	private int salinidade;
	private int temperatura;
	private int qtMorta;
	private int qtTotal;
	private String estagioCrescimento;
	
	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public int getSalinidade() {
		return salinidade;
	}

	public void setSalinidade(int salinidade) {
		this.salinidade = salinidade;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public int getQtMorta() {
		return qtMorta;
	}

	public void setQtMorta(int qtMorta) {
		this.qtMorta = qtMorta;
	}

	public int getQtTotal() {
		return qtTotal;
	}

	public void setQtTotal(int qtTotal) {
		this.qtTotal = qtTotal;
	}

	public String getEstagioCrescimento() {
		return estagioCrescimento;
	}

	public void setEstagioCrescimento(String estagioCrescimento) {
		this.estagioCrescimento = estagioCrescimento;
	}

}
