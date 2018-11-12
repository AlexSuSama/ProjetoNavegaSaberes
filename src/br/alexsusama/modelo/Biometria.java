package br.alexsusama.modelo;

import java.util.Calendar;

import br.alexsusama.persisntencia.SaidaEntradaBiometria;

public class Biometria extends ListaBiometria{
	private int IDBiometria;
	private Calendar data;
	private String sistemaProducao;
	private double mediaCrescimento;
	private double mortalidade;
	private double sobrevivencia;

	private Ostra ostraBiometria;
	private Ambiente ambienteBiometria;
	// construtor
	public Biometria() {
		
	}
	
	public Biometria(Calendar date, String sistemaProducao, double mediaCrescimento, double mortalidade,
			double sobrevivencia, Ostra ostra, Ambiente ambiente) {
		if (!(date == null || sistemaProducao == null || mediaCrescimento == 0.0 || mortalidade == 0.0
				|| sobrevivencia == 0.0 || ostra == null || ambiente == null)) {
			if (mediaCrescimento > 0.0) {
				if (mortalidade > 0.0) {
					if (sobrevivencia > 0.0) {
						this.ostraBiometria = ostra;
						this.ambienteBiometria = ambiente;
						this.data = date;
						this.sistemaProducao = sistemaProducao;
						this.mediaCrescimento = mediaCrescimento;
						this.mortalidade = mortalidade;
						this.sobrevivencia = sobrevivencia;
					} else {
						throw new IllegalArgumentException("sobrevivencia invalida");
					}
				} else {
					throw new IllegalArgumentException("mortalidade invalida");
				}
			} else {
				throw new IllegalArgumentException("media de crescimento invalida");
			}
		} else {
			throw new IllegalArgumentException("valores invalidos");
		}
	}

	public int getIDBiometria() {
		return IDBiometria;
	}

	public void setIDBiometria(int iDBiometria) {
		IDBiometria = iDBiometria;
	}

	public Calendar getDate() {
		return (Calendar) this.data.clone();
	}

	public void setDate(Calendar date) {
		this.data = date;
	}

	public String getSistemaProducao() {
		return sistemaProducao;
	}

	public void setSistemaProducao(String sistemaProducao) {
		this.sistemaProducao = sistemaProducao;
	}

	public double getMediaCrescimento() {
		return mediaCrescimento;
	}

	public void setMediaCrescimento(double mediaCrescimento) {
		this.mediaCrescimento = mediaCrescimento;
	}

	public double getMortalidade() {
		return mortalidade;
	}

	public void setMortalidade(double mortalidade) {
		this.mortalidade = mortalidade;
	}

	public double getSobrevivencia() {
		return sobrevivencia;
	}

	public void setSobrevivencia(double sobrevivencia) {
		this.sobrevivencia = sobrevivencia;
	}

	public Ostra getOstraBiometria() {
		return ostraBiometria;
	}

	public void setOstraBiometria(Ostra ostraBiometria) {
		this.ostraBiometria = ostraBiometria;
	}

	public Ambiente getAmbienteBiometria() {
		return ambienteBiometria;
	}

	public void setAmbienteBiometria(Ambiente ambienteBiometria) {
		this.ambienteBiometria = ambienteBiometria;
	}

	public void criarBiometria(String idParent) {
		SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
		//calcularMortalidade();
		calcularSobrevivencia();
		//Calculos calculos = new Calculos();
		//double mortality = Calculos.calcularMortalidade(this.ostraBiometria.getQuantidadeTotal(), this.ostraBiometria.getQuantidadeMorta());
		
		//this.mortalidade = calculos.formatDouble(mortality);
		
		System.out.println(this.mortalidade);
		if (this.getDate() != null) {
			saida.criarNovoBiometria(this, idParent);
		} else {System.out.println("falha ao repassar os dados");}

	}
	public static void excluirBiometria(String idbiometria) {
		SaidaEntradaBiometria saida = new SaidaEntradaBiometria();	 
			saida.excluirBiometria(idbiometria);
	}
	public void editarBiometria(String idbiometria) {
SaidaEntradaBiometria saida = new SaidaEntradaBiometria();
		
		if (this.getDate() != null) {
			saida.editarBiometria(this,idbiometria);
		} else {System.out.println("falha ao repassar os dados");}

	}

	public void printarBiometria() {
		System.out.println("print biometria");
		System.out.println("ID biometria: " + IDBiometria);
		System.out.println("Data Biometria: " + (data.get(Calendar.MONTH) + 1));
		System.out.println("sistema de Produção: " + sistemaProducao);
		System.out.println("Média de crescimento: " + mediaCrescimento);
		System.out.println("taxa de mortalidade: " + mortalidade);
		System.out.println("taxa de sobrevivencia: " + sobrevivencia);

		ostraBiometria.printarOstra();
		ambienteBiometria.printAmbiente();

	}

	public void calcularMortalidade() {
		mortalidade += 1.0;
	}

	public void calcularSobrevivencia() {
		sobrevivencia += 2.0;
	}
}
