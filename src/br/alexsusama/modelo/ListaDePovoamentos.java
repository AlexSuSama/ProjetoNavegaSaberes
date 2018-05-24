package br.alexsusama.modelo;

public class ListaDePovoamentos {
	//private int id;
	//private String nomeOstricultor;
	private String dataInicialPovoamento;
	private String dataUltimaBiometria;
	private String sistema;
	private String estagioCrescimento;
	private int qtTotal;
	
	private String maxData;
	//public ListaDePovoamentos(int id, String ostricultor,String dataInicial,String ultimaBiometria,String sistema,int total,String estagio) {
		//this.dataUltimaBiometria = 
		
	//}
	
	public String getDataUltimaBiometria() {
		return dataUltimaBiometria;
	}
	public String getMaxData() {
		return maxData;
	}
	public void setMaxData(String maxData) {
		this.maxData = maxData;
	}
	public String getDataInicialPovoamento() {
		return dataInicialPovoamento;
	}
	public void setDataInicialPovoamento(String dataInicialPovoamento) {
		this.dataInicialPovoamento = dataInicialPovoamento;
	}
	public void setDataUltimaBiometria(String dataUltimaBiometria) {
		this.dataUltimaBiometria = dataUltimaBiometria;
	}
	public String getSistema() {
		return sistema;
	}
	public void setSistema(String sistema) {
		this.sistema = sistema;
	}
	public String getEstagioCrescimento() {
		return estagioCrescimento;
	}
	public void setEstagioCrescimento(String estagioCrescimento) {
		this.estagioCrescimento = estagioCrescimento;
	}
	public int getQtTotal() {
		return qtTotal;
	}
	public void setQtTotal(int qtTotal) {
		this.qtTotal = qtTotal;
	}
	
}
