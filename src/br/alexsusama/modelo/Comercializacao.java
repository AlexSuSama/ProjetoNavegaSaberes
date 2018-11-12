package br.alexsusama.modelo;

import java.util.Calendar;

import br.alexsusama.persisntencia.SaidaEntradaComercializacao;

public class Comercializacao extends ListaComercializacao {
	private String nomeComprador;
	private String municipio;
	private String localidade;
	//retirar esse tipo comercializado
	//acrescentar as variaveis do tipo inteiro que conteram as duzias
	
	private int duziasTotal;
	
	private int duziasMedias;
	private int duziasBaby;
	private int duziasMaster;
	
	
	private String tipoComercializado;
	private String tipoDeComprador;
	//private int qtVendidas;
	private int valorVenda;
	private Calendar dataVenda;
	private int idComercializacao;
	private int valorFrete;

	public Comercializacao() {
	}

	public void setValorVenda(int valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Comercializacao(String nomeComprador, String tipoDeComprador, String municipio, String localidade,
			String tipoComercializado, Calendar dataVenda, int valorVenda, int valorFrete, int duziasBaby,int duziasMedia, int duziasMaster) {
		if (!(nomeComprador == null || tipoDeComprador == null || municipio == null || localidade == null
				|| tipoComercializado == null || duziasBaby == 0 || dataVenda == null || valorVenda == 0 ||valorFrete == 0)) {
			if (!((duziasBaby+duziasMaster+duziasMedia) <= 0 || valorVenda <= 0)) {
				
				this.nomeComprador = nomeComprador;
				this.municipio = municipio;
				this.localidade = localidade;
				//retirar esse tipo comercializado
				//adicionar condição para que o valor das duzias n estejam todos nulos
				
				//deixar por enquanto apenas para o teste
				this.tipoComercializado = tipoComercializado;
				this.tipoDeComprador = tipoDeComprador;
				
				this.duziasBaby = duziasBaby;
				this.duziasMedias = duziasMedia;
				this.duziasMaster = duziasMaster;
				
				this.dataVenda = dataVenda;
				this.valorVenda = valorVenda;
				this.valorFrete = valorFrete;
			} else {
				throw new IllegalArgumentException("valor da venda e quantidade vendida não podem ser negativos");
			}
		} else {
			throw new IllegalArgumentException("valores invalidos");
		}
	}

	
	public int getDuziasTotal() {
		return duziasTotal;
	}

	public void setDuziasTotal(int duziasTotal) {
		this.duziasTotal = duziasTotal;
	}

	public int getDuziasMedias() {
		return duziasMedias;
	}

	public void setDuziasMedias(int duziasMedias) {
		this.duziasMedias = duziasMedias;
	}

	public int getDuziasBaby() {
		return duziasBaby;
	}

	public void setDuziasBaby(int duziasBaby) {
		this.duziasBaby = duziasBaby;
	}

	public int getDuziasMaster() {
		return duziasMaster;
	}

	public void setDuziasMaster(int duziasMaster) {
		this.duziasMaster = duziasMaster;
	}

	public int getValorVenda() {
		return valorVenda;
	}

	public int getIdComercializacao() {
		return idComercializacao;
	}

	public void setIdComercializacao(int idComercializacao) {
		this.idComercializacao = idComercializacao;
	}

	public String getNomeComprador() {
		return nomeComprador;
	}

	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTipoComercializado() {
		return tipoComercializado;
	}

	public void setTipoComercializado(String tipoComercializado) {
		this.tipoComercializado = tipoComercializado;
	}

	public String getTipoDeComprador() {
		return tipoDeComprador;
	}

	public void setTipoDeComprador(String tipoDeComprador) {
		this.tipoDeComprador = tipoDeComprador;
	}

	public Calendar getDataVenda() {
		return (Calendar) this.dataVenda.clone();
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public int getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(int valorFrete) {
		this.valorFrete = valorFrete;
	}

	public void criarComercializacao(String idParent) {
		if (this.getDataVenda() != null) {
			SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
			entrada.criarNovaComercializacao(this, idParent);
		} else {
			System.out.println("falha ao criar a comercialização naquele povoamento");
		}
	}

	public void excluirComercializacao(String id) {
		SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
		entrada.excluirComercializacao(id);
	}

	public void editarComercializacao(String id) {
		if (this.getDataVenda() != null) {
			SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
			entrada.editarComercializacao(this, id);
		}
	}
}
