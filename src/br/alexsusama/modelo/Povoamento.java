package br.alexsusama.modelo;

import java.util.Calendar;

import br.alexsusama.persisntencia.SaidaEntradaPovoamento;

public class Povoamento extends ListaDePovoamentos {
	private int IDPovoamentos;
	private Calendar dataInicial;
	private String nomeOstricultor;
	private String localidade;
	private String municipio;
	private int quantidadeSementes;
	// variaveis que é possivel não ter
	private int grausLong, minutosLong;
	private double segundosLong;
	private int grausLat, minutosLat;
	private double segundosLat;

	public Povoamento() {
	}

	public Povoamento(int quantidadeSementes, Calendar dataInicial, String nomeOstricultor, String localidade,
			String municipio) {
		if (!(quantidadeSementes == 0 || dataInicial == null || nomeOstricultor == null || localidade == null
				|| municipio == null)) {
			if (quantidadeSementes >= 0) {
				this.dataInicial = dataInicial;
				this.quantidadeSementes = quantidadeSementes;
				this.nomeOstricultor = nomeOstricultor;
				this.localidade = localidade;
				this.municipio = municipio;
			} else {
				System.out.println("valor repassado para quantidade de sementes invalido");
			}
		} else {
			System.out.println("algum valor não foi repassado corretamente");
		}
	}

	public Povoamento(int quantidadeSementes, Calendar dataInicial, String nomeOstricultor, String localidade,
			String municipio, int grausLa, int minutosLa, double segundosLa, int grausLo, int minutosLo,
			double segundosLo) {
		// verifica se os valores passados são diferentes de nulo
		if (!(quantidadeSementes <= 0 || dataInicial == null || nomeOstricultor == null || localidade == null
				|| municipio == null || grausLa == 0 || minutosLa == 0 || segundosLa == 0.0 || grausLo == 0
				|| minutosLo == 0 || segundosLo == 0.0)) {
			// verifica se os valores das coordenadas são validos
			if ((grausLa >= -90 && grausLa <= 90) && (grausLo >= -180 && grausLo <= 180)) {
				if ((minutosLa >= 0 && minutosLa <= 60) && (minutosLo >= 0 && minutosLo <= 60)) {
					if ((segundosLa >= 0 && segundosLa <= 60) && (segundosLo >= 0 && segundosLo <= 60)) {
						this.dataInicial = dataInicial;
						this.quantidadeSementes = quantidadeSementes;
						this.nomeOstricultor = nomeOstricultor;
						this.localidade = localidade;
						this.municipio = municipio;
						this.grausLat = grausLa;
						this.minutosLat = minutosLa;
						this.segundosLat = segundosLa;
						this.grausLong = grausLo;
						this.minutosLong = minutosLo;
						this.segundosLong = segundosLo;
					} else {
						throw new IllegalArgumentException("valores para segundos Invalidos");
					}
				} else {
					throw new IllegalArgumentException("valores para minutos Invalidos");
				}
			} else {
				throw new IllegalArgumentException("valores para graus Invalidos");
			}
		} else {
			System.out.println("algum valor invalido foi repassado");
		}
	}

	public int getIDPovoamentos() {
		return IDPovoamentos;
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

	public int getQuantidadeSementes() {
		return quantidadeSementes;
	}

	public void setQuantidadeSementes(int quantidadeSementes) {
		this.quantidadeSementes = quantidadeSementes;
	}

	public int getGrausLong() {
		return grausLong;
	}

	public void setGrausLong(int grausLong) {
		this.grausLong = grausLong;
	}

	public int getMinutosLong() {
		return minutosLong;
	}

	public void setMinutosLong(int minutosLong) {
		this.minutosLong = minutosLong;
	}

	public double getSegundosLong() {
		return segundosLong;
	}

	public void setSegundosLong(double segundosLong) {
		this.segundosLong = segundosLong;
	}

	public int getGrausLat() {
		return grausLat;
	}

	public void setGrausLat(int grausLat) {
		this.grausLat = grausLat;
	}

	public int getMinutosLat() {
		return minutosLat;
	}

	public void setMinutosLat(int minutosLat) {
		this.minutosLat = minutosLat;
	}

	public double getSegundosLat() {
		return segundosLat;
	}

	public void setSegundosLat(double segundosLat) {
		this.segundosLat = segundosLat;
	}

	public void setIDPovoamentos(int iDPovoamentos) {
		IDPovoamentos = iDPovoamentos;
	}

	public Calendar getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Calendar dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getNomeOstricultor() {
		return nomeOstricultor;
	}

	public void setNomeOstricultor(String nomeOstricultor) {
		this.nomeOstricultor = nomeOstricultor;
	}

	// metodos de criar, excluir e editar
	public void criarPovoamento() {

		SaidaEntradaPovoamento entrada = new SaidaEntradaPovoamento();
		if (this.getDataInicial() != null) {
			entrada.criarNovoPovoamento(this);
			System.out.println("povoamento criado");
		} else {
			System.out.println("falha ao criar povoamento");
		}
	}

	public static void excluirPovoamento(String id) {
		SaidaEntradaPovoamento saidaEntradaPovoamento = new SaidaEntradaPovoamento();
		saidaEntradaPovoamento.excluirPovoamento(id);
	}

	public void editarPovoamentos(String id) {
		SaidaEntradaPovoamento entrada = new SaidaEntradaPovoamento();
		if (this.getDataInicial() != null) {
			entrada.editarPovoamento(this, id);

		} else {
			System.out.println("falha ao editar povoamento");
		}
	}

	// adiciona uma nova biometria
	public void adicionarBiometria(Biometria biometria) {
		System.out.println("biometria foi adicionada ");
		biometria.printarBiometria();
	}

	// printa as informaçções do povoamento
	public void printarPovoamento() {
		System.out.println("print povoamentos");
		System.out.println("id: " + IDPovoamentos);
		System.out.println("nome: " + nomeOstricultor);
		System.out.println("ano: " + dataInicial.get(Calendar.YEAR) + " mes: " + (dataInicial.get(Calendar.MONTH) + 1)
				+ " dia: " + dataInicial.get(Calendar.DAY_OF_MONTH));
		System.out.println("localidade: " + localidade);
		System.out.println("municipio: " + municipio);
		System.out.println("quantidade de sementes: " + quantidadeSementes);
		System.out.println("graus latitude: " + this.grausLat);
		System.out.println("minutos latitude: " + this.minutosLat);
		System.out.println("segundos latitude: " + this.segundosLat);
		System.out.println("graus logintude: " + this.grausLong);
		System.out.println("minutos logintude: " + this.minutosLong);
		System.out.println("segundos logintude: " + this.segundosLong);
		
	}
}
