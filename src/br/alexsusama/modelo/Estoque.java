package br.alexsusama.modelo;

import java.util.Calendar;

import javax.swing.JOptionPane;

import br.alexsusama.persisntencia.SaidaEntradaEstoque;

public class Estoque extends ListaEstoque {
	private Calendar data;
	private int idEstoque;
	// ostras em estoque
	private int ostraBaby;
	

	private int ostraSemente;
	private int ostraJuvenil;
	private int ostraMaster;
	private int ostraMedia;
	// apetrechos / malhas
	private int malha69;
	private int malha12;
	private int malha14;
	private int malha21;

	// sistema usados
	private int longLine;
	private int mesaMadeira;
	private int mesaTelada;
	private int mesaPVC;
	private int coletores;
	private int varal;

	public Estoque() {
	}

	public Estoque(Calendar data, int ostraBaby, int ostraSemente, int ostraMedia, int ostraMaster, int ostraJuvenil,
			int malha69, int malha12, int malha14, int malha21, int longLine, int varal, int mesaTelada, int mesaPVC,
			int mesaMadeira, int coletores) {
		if (data != null) {
			this.data = data;
			// ostras
			if (!(ostraBaby < 0 || ostraSemente < 0 || ostraMaster < 0 || ostraMedia < 0 || ostraJuvenil < 0)) {
				this.ostraBaby = ostraBaby;
				this.ostraSemente = ostraSemente;
				this.ostraMedia = ostraMedia;
				this.ostraMaster = ostraMaster;
				this.ostraJuvenil = ostraJuvenil;

			} else {
				throw new IllegalArgumentException("valores negativos para ostras são inválidos");
			}

			// apetrechos
			if (!(malha12 < 0 || malha14 < 0 || malha21 < 0 || malha69 < 0)) {
				this.malha12 = malha12;
				this.malha14 = malha14;
				this.malha21 = malha21;
				this.malha69 = malha69;
			} else {
				throw new IllegalArgumentException("valores negativos para apetrechos são inválidos");
			}
			// sistemas de producao;
			if (!(mesaMadeira < 0 || mesaPVC < 0 || mesaTelada < 0 || coletores < 0 || varal < 0 || longLine < 0)) {
				this.mesaMadeira = mesaMadeira;
				this.mesaPVC = mesaPVC;
				this.mesaTelada = mesaTelada;
				this.coletores = coletores;
				this.varal = varal;
				this.longLine = longLine;
			} else {
				throw new IllegalArgumentException("valores negativos para os sistemas de produção são inválidos");
			}
		} else {
			JOptionPane.showMessageDialog(null, "data inválida");
		}
	}

	public int getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(int idEstoque) {
		this.idEstoque = idEstoque;
	}

	public int getOstraBaby() {
		return ostraBaby;
	}

	public void setOstraBaby(int ostraBaby) {
		this.ostraBaby = ostraBaby;
	}

	public int getOstraSemente() {
		return ostraSemente;
	}

	public void setOstraSemente(int ostraSemente) {
		this.ostraSemente = ostraSemente;
	}

	public int getOstraJuvenil() {
		return ostraJuvenil;
	}

	public void setOstraJuvenil(int ostraJuvenil) {
		this.ostraJuvenil = ostraJuvenil;
	}

	public int getOstraMaster() {
		return ostraMaster;
	}

	public void setOstraMaster(int ostraMaster) {
		this.ostraMaster = ostraMaster;
	}

	public int getOstraMedia() {
		return ostraMedia;
	}

	public void setOstraMedia(int ostraMedia) {
		this.ostraMedia = ostraMedia;
	}

	public int getMalha69() {
		return malha69;
	}

	public void setMalha69(int malha69) {
		this.malha69 = malha69;
	}

	public int getMalha12() {
		return malha12;
	}

	public void setMalha12(int malha12) {
		this.malha12 = malha12;
	}

	public int getMalha14() {
		return malha14;
	}

	public void setMalha14(int malha14) {
		this.malha14 = malha14;
	}

	public int getMalha21() {
		return malha21;
	}

	public void setMalha21(int malha21) {
		this.malha21 = malha21;
	}

	public int getLongLine() {
		return longLine;
	}

	public void setLongLine(int longLine) {
		this.longLine = longLine;
	}

	public int getMesaMadeira() {
		return mesaMadeira;
	}

	public void setMesaMadeira(int mesaMadeira) {
		this.mesaMadeira = mesaMadeira;
	}

	public int getMesaTelada() {
		return mesaTelada;
	}

	public void setMesaTelada(int mesaTelada) {
		this.mesaTelada = mesaTelada;
	}

	public int getMesaPVC() {
		return mesaPVC;
	}

	public void setMesaPVC(int mesaPVC) {
		this.mesaPVC = mesaPVC;
	}

	public int getColetores() {
		return coletores;
	}

	public void setColetores(int coletores) {
		this.coletores = coletores;
	}

	public int getVaral() {
		return varal;
	}

	public void setVaral(int varal) {
		this.varal = varal;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	// metodos de criacao,edicao e exclusao de estoque;
	public void criarEstoque(String idParent) {
		if (this.data != null) {
			SaidaEntradaEstoque saida = new SaidaEntradaEstoque();
			
			if (this.getData() != null) {
				saida.salvarEstoque(this, idParent);
			} else {System.out.println("falha ao repassar os dados");}

		}
	}

	public void atualizarEstoque(String id) {
		if (this.getData() != null) {
			SaidaEntradaEstoque entrada = new SaidaEntradaEstoque();
			entrada.editarEstoque(this, id);
		}
	}

	public void excluirEstoque(String id) {
		SaidaEntradaEstoque entrada = new SaidaEntradaEstoque();
		entrada.excluirEstoque(id);
	}

}
