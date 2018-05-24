package br.alexsusama.atributos;

public class AtributosPersistencia {
	// comando de pesquisa sql para o povoamento
	private String ID_POVOAMENTO = "idpovoamento";
	private String OSTRICULTOR = "ostricultor";
	private String LOCALIDADE = "localidade";
	private String MUNICIPIO = "municipio";
	private String tabelaPovoamento = "povoamento";
	private String DATA_INICIAL = "data_inicial";
	private String LONGITUDE_GRAUS = "longitude_graus";
	private String LONGITUDE_MINUTOS = "longitude_minutos";
	private String LONGITUDE_SEGUNDOS = "longitude_segundos";
	private String LATITUDE_GRAUS = "latitude_graus";
	private String LATITUDE_MINUTOS = "latitude_minutos";
	private String LATITUDE_SEGUNDOS = "latitude_segundos";
	private String QT_SEMENTES = "quantidade_sementes";
	// private Stirng DATA_ULTIMA_BIOMETRIA=

	public String getID_POVOAMENTO() {
		return ID_POVOAMENTO;
	}

	public String getQT_SEMENTES() {
		return QT_SEMENTES;
	}

	public String getDATA_INICIAL() {
		return DATA_INICIAL;
	}

	public String getLONGITUDE_GRAUS() {
		return LONGITUDE_GRAUS;
	}

	public String getLONGITUDE_MINUTOS() {
		return LONGITUDE_MINUTOS;
	}

	public String getLONGITUDE_SEGUNDOS() {
		return LONGITUDE_SEGUNDOS;
	}

	public String getLATITUDE_GRAUS() {
		return LATITUDE_GRAUS;
	}

	public String getLATITUDE_MINUTOS() {
		return LATITUDE_MINUTOS;
	}

	public String getLATITUDE_SEGUNDOS() {
		return LATITUDE_SEGUNDOS;
	}

	public String getOSTRICULTOR() {
		return OSTRICULTOR;
	}

	public String getLOCALIDADE() {
		return LOCALIDADE;
	}

	public String getMUNICIPIO() {
		return MUNICIPIO;
	}

	public String getTabelaPovoamento() {
		return tabelaPovoamento;
	}

	// comandos de pesquisa sql para a biometria
	private String QUANTIDADEMORTA = "quantidademorta", QUANTIDADETOTAL = "qauntidadetotal",
			idParentPovoamento = "\"id-dos-povoamentos\"", ESTAGIO_CRESCIMENTO = "estagio_crescimento",
			TEMPERATURA = "temperatura", SALINIDADE = "salinidade", MEDIA_CRESCIMENTO = "media_crescimento",
			MORTALIDADE = "mortalidade", SOBREVIVENCIA = "sobrevivencia", DATA_COLETA = "data_coleta",
			SISTEMA_PRODUCAO = "sistema_producao";
	private String ID_BIOMETRIA = "idbiometria";

	private String tabelaBiometria = "biometria";
	
	public String getID_BIOMETRIA() {
		return ID_BIOMETRIA;
	}

	public String getESTAGIO_CRESCIMENTO() {
		return ESTAGIO_CRESCIMENTO;
	}

	public String getTEMPERATURA() {
		return TEMPERATURA;
	}

	public String getSALINIDADE() {
		return SALINIDADE;
	}

	public String getMEDIA_CRESCIMENTO() {
		return MEDIA_CRESCIMENTO;
	}

	public String getMORTALIDADE() {
		return MORTALIDADE;
	}

	public String getSOBREVIVENCIA() {
		return SOBREVIVENCIA;
	}

	public String getDATA_COLETA() {
		return DATA_COLETA;
	}

	public String getSISTEMA_PRODUCAO() {
		return SISTEMA_PRODUCAO;
	}

	public String getQUANTIDADEMORTA() {
		return QUANTIDADEMORTA;
	}

	public String getQUANTIDADETOTAL() {
		return QUANTIDADETOTAL;
	}

	public String getIdParentPovoamento() {
		return idParentPovoamento;
	}

	public String getTabelaBiometria() {
		return tabelaBiometria;
	}

	// valores de atributos sql para a comercializacao
	private String ID_COMERCIALIZACAO = "id_comercializacao";
	private String DATA_VENDA = "data_venda";
	private String NOME_COMPRADOR = "nome_comprador";
	private String TIPO_COMPRADOR = "tipo_comprador";
	private String VALOR_COMERCIALIZACAO = "valor";
	private String TIPO_COMERCIALIZADO = "tipo_comercializado";
	private String DUZIAS_VENDIDA = "duzias_vendida";
	private String MUNICIPIO_COMERCIALIZADO = "municipio";
	private String LOCALIDADE_COMERCIALIZADA = "local";
	private String tabela_comercializacao = "comercializacao";

	public String getTabela_comercializacao() {
		return tabela_comercializacao;
	}

	public String getID_COMERCIALIZACAO() {
		return ID_COMERCIALIZACAO;
	}

	public String getDATA_VENDA() {
		return DATA_VENDA;
	}

	public String getNOME_COMPRADOR() {
		return NOME_COMPRADOR;
	}

	public String getTIPO_COMPRADOR() {
		return TIPO_COMPRADOR;
	}

	public String getVALOR_COMERCILIZADO() {
		return VALOR_COMERCIALIZACAO;
	}

	public String getTIPO_COMERCIALIZADO() {
		return TIPO_COMERCIALIZADO;
	}

	public String getDUZIAS_VENDIDA() {
		return DUZIAS_VENDIDA;
	}

	public String getMUNICIPIO_COMERCIALIZADO() {
		return MUNICIPIO_COMERCIALIZADO;
	}

	public String getLOCALIDADE_COMERCIALIZADA() {
		return LOCALIDADE_COMERCIALIZADA;
	}

	// atributos sql para o estoque
	private String MESA_TELADA = "mesa_telada";
	private String MESA_PVC = "mesa_pvc";
	private String MESA_MADEIRA = "mesa_madeira";
	private String COLETORES = "coletores";
	private String VARAL = "varal";
	private String LONG_LINE = "long_line";
	private String MALHA21 = "malha21";
	private String MALHA69 = "malha69";
	private String MALHA14 = "malha14";
	private String MALHA12 = "malha12";
	private String SEMENTE_ESTOQUE = "semente_estoque";
	private String JUVENIL_ESTOQUE = "juvenil_estoque";
	private String BABY_ESTOQUE = "baby_estoque";
	private String MASTER_ESTOQUE = "master_estoque";
	private String MEDIA_ESTOQUE = "media_estoque";
	private String DATA_ESTOQUE = "data_estoque";
	private String tabela_estoque = "estoque";
	private String IDESTOQUE = "idestoque";

	public String getVALOR_COMERCIALIZACAO() {
		return VALOR_COMERCIALIZACAO;
	}

	public String getMESA_TELADA() {
		return MESA_TELADA;
	}

	public String getMESA_PVC() {
		return MESA_PVC;
	}

	public String getMESA_MADEIRA() {
		return MESA_MADEIRA;
	}

	public String getCOLETORES() {
		return COLETORES;
	}

	public String getVARAL() {
		return VARAL;
	}

	public String getLONG_LINE() {
		return LONG_LINE;
	}

	public String getMALHA21() {
		return MALHA21;
	}

	public String getMALHA69() {
		return MALHA69;
	}

	public String getMALHA14() {
		return MALHA14;
	}

	public String getMALHA12() {
		return MALHA12;
	}

	public String getSEMENTE_ESTOQUE() {
		return SEMENTE_ESTOQUE;
	}

	public String getJUVENIL_ESTOQUE() {
		return JUVENIL_ESTOQUE;
	}

	public String getBABY_ESTOQUE() {
		return BABY_ESTOQUE;
	}

	public String getMASTER_ESTOQUE() {
		return MASTER_ESTOQUE;
	}

	public String getMEDIA_ESTOQUE() {
		return MEDIA_ESTOQUE;
	}

	public String getDATA_ESTOQUE() {
		return DATA_ESTOQUE;
	}

	public String getTabela_estoque() {
		return tabela_estoque;
	}

	public String getIDESTOQUE() {
		return IDESTOQUE;
	}

}
