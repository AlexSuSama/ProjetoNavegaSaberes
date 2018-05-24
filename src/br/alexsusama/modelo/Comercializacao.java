package br.alexsusama.modelo;

import java.util.Calendar;

import br.alexsusama.persisntencia.SaidaEntradaComercializacao;

public class Comercializacao extends ListaComercializacao {
	private String nomeComprador;
	private String municipio;
	private String localidade;
	private String tipoComercializado;
	private String tipoDeComprador;
	private int qtVendidas;
	private int valorVenda;
	private Calendar dataVenda;
	private int idComercializacao;
	
	public Comercializacao() {}

	public void setValorVenda(int valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Comercializacao(String nomeComprador, String tipoDeComprador, String municipio, String localidade,
			String tipoComercializado, int qtVendidas, Calendar dataVenda, int valorVenda) {
		if (!(nomeComprador == null || tipoDeComprador == null || municipio == null || localidade == null
				|| tipoComercializado == null || qtVendidas == 0 || dataVenda == null || valorVenda == 0)) {
			if (!(qtVendidas <= 0 || valorVenda <= 0)) {
				this.nomeComprador = nomeComprador;
				this.municipio = municipio;
				this.localidade = localidade;
				this.tipoComercializado = tipoComercializado;
				this.tipoDeComprador = tipoDeComprador;
				this.qtVendidas = qtVendidas;
				this.dataVenda = dataVenda;
				this.valorVenda = valorVenda;
			} else {
				throw new IllegalArgumentException("valor da venda e quantidade vendida não podem ser negativos");
			}
		} else {
			throw new IllegalArgumentException("valores invalidos");
		}
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

	public int getQtVendidas() {
		return qtVendidas;
	}

	public void setQtVendidas(int qtVendidas) {
		this.qtVendidas = qtVendidas;
	}

	public Calendar getDataVenda() {
		return (Calendar) this.dataVenda.clone();
	}

	public void setDataVenda(Calendar dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public void criarComercializacao() {
		if(this.getDataVenda() != null) {
			SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
			entrada.criarNovaComercializacao(this);
		}
	}
	public void excluirComercializacao(String id) {
		SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
		entrada.excluirComercializacao(id);
	}
	public void editarComercializacao(String id) {
		if(this.getDataVenda() != null) {
			SaidaEntradaComercializacao entrada = new SaidaEntradaComercializacao();
			entrada.editarComercializacao(this, id);
		}
	}
}
