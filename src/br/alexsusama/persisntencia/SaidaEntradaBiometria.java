package br.alexsusama.persisntencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.alexsusama.atributos.AtributosPersistencia;
import br.alexsusama.modelo.Biometria;
//import br.alexsusama.modelo.Povoamento;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class SaidaEntradaBiometria {
	public void criarNovoBiometria(Biometria biometria, String idParent) {
		if (biometria != null) { 
			PreparedStatement pStatement;
			AtributosPersistencia a = new AtributosPersistencia();
			String sql = "INSERT INTO " + a.getTabelaBiometria() + " (" + a.getQUANTIDADETOTAL() + ","
					+ a.getQUANTIDADEMORTA() + "," + a.getIdParentPovoamento() + "," + a.getESTAGIO_CRESCIMENTO() + ","
					+ a.getTEMPERATURA() + "," + a.getSALINIDADE() + "," + a.getMEDIA_CRESCIMENTO() + ","
					+ a.getMORTALIDADE() + "," + a.getSOBREVIVENCIA() + "," + a.getDATA_COLETA() + ","
					+ a.getSISTEMA_PRODUCAO() + ") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			try {
				ConnectionDB con = new ConnectionDB();
				pStatement = con.getConection().prepareStatement(sql);
				pStatement.setInt(1, biometria.getOstraBiometria().getQuantidadeTotal());
				pStatement.setInt(2, biometria.getOstraBiometria().getQuantidadeMorta());
				pStatement.setString(3, idParent);
				pStatement.setString(4, biometria.getOstraBiometria().getEstagioCrescimento());
				pStatement.setInt(5, biometria.getAmbienteBiometria().getTemperatura());
				pStatement.setInt(6, biometria.getAmbienteBiometria().getSalinidade());
				pStatement.setDouble(7, biometria.getMediaCrescimento());
				pStatement.setDouble(8, biometria.getMortalidade());
				pStatement.setDouble(9, biometria.getSobrevivencia());
				pStatement.setString(10, ValidacaoDeDatas.padronizarDatas(biometria.getDate()));
				pStatement.setString(11, biometria.getSistemaProducao());
				int confirmacao = pStatement.executeUpdate();
				pStatement.close();

				if (confirmacao == 1) {
					System.out.println("os valores foram salvos no banco de dados");
				} else {
					System.out.println("os valotes não foram salvos");
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "deu pau no execel " + e.getMessage());
			}
		}
	}

	public void excluirBiometria(String idBiometria) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "DELETE FROM " + a.getTabelaBiometria() + " WHERE idbiometria = ?";
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement pStatement = con.getConection().prepareStatement(sql);
			pStatement.setString(1, idBiometria);
			int confirmacao = pStatement.executeUpdate();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "Biometria excluida");
			} else {
				JOptionPane.showMessageDialog(null, "falha ao excluir a biometria");
			}
			pStatement.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir o biometria" + e.getMessage());
		}
	}

	public void editarBiometria(Biometria biometria, String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "UPDATE " + a.getTabelaBiometria() + " set " + a.getQUANTIDADEMORTA() + " = ?,"
				+ a.getQUANTIDADETOTAL() + " = ?," + a.getESTAGIO_CRESCIMENTO() + " = ?," + a.getTEMPERATURA() + " = ?,"
				+ a.getSALINIDADE() + " = ?," + a.getMEDIA_CRESCIMENTO() + " = ?," + a.getMORTALIDADE() + " = ?,"
				+ a.getSOBREVIVENCIA() + " = ?," + a.getDATA_COLETA() + " = ?," + a.getSISTEMA_PRODUCAO()
				+ " = ? where idbiometria =" + id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement pStatement = con.getConection().prepareStatement(sql);
			pStatement = con.getConection().prepareStatement(sql);
			pStatement.setInt(1, biometria.getOstraBiometria().getQuantidadeMorta());
			pStatement.setInt(2, biometria.getOstraBiometria().getQuantidadeTotal());
			pStatement.setString(3, biometria.getOstraBiometria().getEstagioCrescimento());
			pStatement.setInt(4, biometria.getAmbienteBiometria().getTemperatura());
			pStatement.setInt(5, biometria.getAmbienteBiometria().getSalinidade());
			pStatement.setDouble(6, biometria.getMediaCrescimento());
			pStatement.setDouble(7, biometria.getMortalidade());
			pStatement.setDouble(8, biometria.getSobrevivencia());
			pStatement.setString(9, ValidacaoDeDatas.padronizarDatas(biometria.getDate()));
			pStatement.setString(10, biometria.getSistemaProducao());
			int confirmacao = pStatement.executeUpdate();
			pStatement.close();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "Biometria editada");
			} else {
				JOptionPane.showMessageDialog(null, "Falha de update");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "erro de sql ao editar a biometria" + e.getMessage());
		}
	}

	public java.util.List<Biometria> resgatarBiometrias(String id) throws SQLException {
		ConnectionDB con = new ConnectionDB();
		PreparedStatement pstm;

		String sql = "select * from biometria where \"id-dos-povoamentos\" =" + id + " order by data_coleta DESC";
		java.util.List<Biometria> biometrias = new ArrayList<>();
		try {

			pstm = con.getConection().prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				AtributosPersistencia a = new AtributosPersistencia();
				Biometria biometria = new Biometria();

				biometria.setIDBiometria(rs.getInt(a.getID_BIOMETRIA()));
				biometria.setQtMorta(rs.getInt(a.getQUANTIDADEMORTA()));
				biometria.setQtTotal(rs.getInt(a.getQUANTIDADETOTAL()));
				biometria.setEstagioCrescimento(rs.getString(a.getESTAGIO_CRESCIMENTO()));
				biometria.setTemperatura(rs.getInt(a.getTEMPERATURA()));
				biometria.setSalinidade(rs.getInt(a.getSALINIDADE()));
				biometria.setMediaCrescimento(rs.getDouble(a.getMEDIA_CRESCIMENTO()));
				biometria.setMortalidade(rs.getDouble(a.getMORTALIDADE()));
				biometria.setSobrevivencia(rs.getDouble(a.getSOBREVIVENCIA()));
				biometria.setDataInicial(rs.getString(a.getDATA_COLETA()));
				biometria.setSistemaProducao(rs.getString(a.getSISTEMA_PRODUCAO()));

				biometrias.add(biometria);

			}
			pstm.close();

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return biometrias;

	}

	public Biometria resgatarBiometria(String id) {

		String sql = "select * from biometria where idbiometria = " + id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement pstm;
			pstm = con.getConection().prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			AtributosPersistencia a = new AtributosPersistencia();
			Biometria biometria = new Biometria();

			biometria.setIDBiometria(rs.getInt(a.getID_BIOMETRIA()));
			biometria.setQtMorta(rs.getInt(a.getQUANTIDADEMORTA()));
			biometria.setQtTotal(rs.getInt(a.getQUANTIDADETOTAL()));
			biometria.setEstagioCrescimento(rs.getString(a.getESTAGIO_CRESCIMENTO()));
			biometria.setTemperatura(rs.getInt(a.getTEMPERATURA()));
			biometria.setSalinidade(rs.getInt(a.getSALINIDADE()));
			biometria.setMediaCrescimento(rs.getDouble(a.getMEDIA_CRESCIMENTO()));
			biometria.setMortalidade(rs.getDouble(a.getMORTALIDADE()));
			biometria.setSobrevivencia(rs.getDouble(a.getSOBREVIVENCIA()));
			biometria.setDataInicial(rs.getString(a.getDATA_COLETA()));
			biometria.setSistemaProducao(rs.getString(a.getSISTEMA_PRODUCAO()));
			
			pstm.close();
			
			return biometria;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau");
		}
		return null;

	}
	public Biometria resgatarUltimaBiometria(String idPovoamento, String dataInicial, String dataFinal) {

		String sql = "SELECT * FROM biometria where data_coleta BETWEEN '"+dataInicial+"' AND '"+dataFinal+"' AND \"id-dos-povoamentos\" = "+idPovoamento+" ORDER BY data_coleta DESC LIMIT 1";
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement pstm;
			pstm = con.getConection().prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			AtributosPersistencia a = new AtributosPersistencia();
			Biometria biometria = new Biometria();

			biometria.setIDBiometria(rs.getInt(a.getID_BIOMETRIA()));
			biometria.setQtMorta(rs.getInt(a.getQUANTIDADEMORTA()));
			biometria.setQtTotal(rs.getInt(a.getQUANTIDADETOTAL()));
			biometria.setEstagioCrescimento(rs.getString(a.getESTAGIO_CRESCIMENTO()));
			biometria.setTemperatura(rs.getInt(a.getTEMPERATURA()));
			biometria.setSalinidade(rs.getInt(a.getSALINIDADE()));
			biometria.setMediaCrescimento(rs.getDouble(a.getMEDIA_CRESCIMENTO()));
			biometria.setMortalidade(rs.getDouble(a.getMORTALIDADE()));
			biometria.setSobrevivencia(rs.getDouble(a.getSOBREVIVENCIA()));
			biometria.setDataInicial(rs.getString(a.getDATA_COLETA()));
			biometria.setSistemaProducao(rs.getString(a.getSISTEMA_PRODUCAO()));
			
			pstm.close();
			
			return biometria;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau");
		}
		return null;

	}
	public Biometria resgatarPrimeiraBiometria(String idPovoamento, String dataInicial, String dataFinal) {

		String sql = "SELECT * FROM biometria where data_coleta BETWEEN '"+dataInicial+"' AND '"+dataFinal+"' AND \"id-dos-povoamentos\" = "+idPovoamento+" ORDER BY data_coleta ASC LIMIT 1";

		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement pstm;
			pstm = con.getConection().prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			AtributosPersistencia a = new AtributosPersistencia();
			Biometria biometria = new Biometria();

			biometria.setIDBiometria(rs.getInt(a.getID_BIOMETRIA()));
			biometria.setQtMorta(rs.getInt(a.getQUANTIDADEMORTA()));
			biometria.setQtTotal(rs.getInt(a.getQUANTIDADETOTAL()));
			biometria.setEstagioCrescimento(rs.getString(a.getESTAGIO_CRESCIMENTO()));
			biometria.setTemperatura(rs.getInt(a.getTEMPERATURA()));
			biometria.setSalinidade(rs.getInt(a.getSALINIDADE()));
			biometria.setMediaCrescimento(rs.getDouble(a.getMEDIA_CRESCIMENTO()));
			biometria.setMortalidade(rs.getDouble(a.getMORTALIDADE()));
			biometria.setSobrevivencia(rs.getDouble(a.getSOBREVIVENCIA()));
			biometria.setDataInicial(rs.getString(a.getDATA_COLETA()));
			biometria.setSistemaProducao(rs.getString(a.getSISTEMA_PRODUCAO()));
			
			pstm.close();
			
			return biometria;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau");
		}
		return null;

	}

	public java.util.List<Biometria> biometriasPorPeriodo(String dataInicial, String dataFinal, String idPovoamento)
			throws SQLException {
		ConnectionDB con = new ConnectionDB();
		PreparedStatement pstm;
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "SELECT * FROM biometria WHERE data_coleta BETWEEN " + dataInicial + " AND " + dataFinal
				+ " AND \"id-dos-povoamentos\" = " + idPovoamento + " ORDER BY data_coleta ASC";
		java.util.List<Biometria> biometrias = new ArrayList<>();
		try {
			pstm = con.getConection().prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Biometria bio = new Biometria();
				bio.setDataInicial(rs.getString(a.getDATA_COLETA()));
				bio.setMediaCrescimento(rs.getDouble(a.getMEDIA_CRESCIMENTO()));
				bio.setSalinidade(rs.getInt(a.getSALINIDADE()));
				bio.setTemperatura(rs.getInt(a.getTEMPERATURA()));
				bio.setMortalidade(rs.getDouble(a.getMORTALIDADE()));
				bio.setSobrevivencia(rs.getDouble(a.getSOBREVIVENCIA()));
				bio.setQtTotal(rs.getInt(a.getQUANTIDADETOTAL()));
				biometrias.add(bio);
			}
			pstm.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "não foi possivel recuperar o valor");
		}
		return biometrias;
	}
	public java.util.List<Biometria> resgatarUltimasBiometrias(String id) throws SQLException {
		ConnectionDB con = new ConnectionDB();
		PreparedStatement pstm;

		String sql = "select * from biometria where \"id-dos-povoamentos\" =" + id + " order by data_coleta ASC LIMIT 12";
		java.util.List<Biometria> biometrias = new ArrayList<>();
		try {

			pstm = con.getConection().prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				AtributosPersistencia a = new AtributosPersistencia();
				Biometria biometria = new Biometria();

				biometria.setIDBiometria(rs.getInt(a.getID_BIOMETRIA()));
				biometria.setQtMorta(rs.getInt(a.getQUANTIDADEMORTA()));
				biometria.setQtTotal(rs.getInt(a.getQUANTIDADETOTAL()));
				biometria.setEstagioCrescimento(rs.getString(a.getESTAGIO_CRESCIMENTO()));
				biometria.setTemperatura(rs.getInt(a.getTEMPERATURA()));
				biometria.setSalinidade(rs.getInt(a.getSALINIDADE()));
				biometria.setMediaCrescimento(rs.getDouble(a.getMEDIA_CRESCIMENTO()));
				biometria.setMortalidade(rs.getDouble(a.getMORTALIDADE()));
				biometria.setSobrevivencia(rs.getDouble(a.getSOBREVIVENCIA()));
				biometria.setDataInicial(rs.getString(a.getDATA_COLETA()));
				biometria.setSistemaProducao(rs.getString(a.getSISTEMA_PRODUCAO()));

				biometrias.add(biometria);

			}
			pstm.close();

		} catch (SQLException e) {
			// TODO: handle exception
		}
		return biometrias;

	}
}
