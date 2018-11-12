package br.alexsusama.persisntencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import br.alexsusama.atributos.AtributosPersistencia;
import br.alexsusama.modelo.Povoamento;
import br.alexsusama.validacoes.ValidacaoDeDatas;

//navega saberes
public class SaidaEntradaPovoamento {
	public void criarNovoPovoamento(Povoamento povoamento) {
		if (povoamento != null) {
			PreparedStatement pStatement;
			AtributosPersistencia a = new AtributosPersistencia();
			String sql = "INSERT INTO " + a.getTabelaPovoamento() + " (" + a.getOSTRICULTOR() + "," + a.getLOCALIDADE()
					+ "," + a.getMUNICIPIO() + "," + a.getDATA_INICIAL() + "," + a.getLONGITUDE_GRAUS() + ","
					+ a.getLONGITUDE_MINUTOS() + "," + a.getLONGITUDE_SEGUNDOS() + "," + a.getLATITUDE_GRAUS() + ","
					+ a.getLATITUDE_MINUTOS() + "," + a.getLATITUDE_SEGUNDOS() + "," + a.getQT_SEMENTES()
					+ ") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			try {
				ConnectionDB con = new ConnectionDB();
				pStatement = con.getConection().prepareStatement(sql);
				pStatement.setString(1, povoamento.getNomeOstricultor());
				pStatement.setString(2, povoamento.getLocalidade());
				pStatement.setString(3, povoamento.getMunicipio());
				pStatement.setString(4, ValidacaoDeDatas.padronizarDatas(povoamento.getDataInicial()));
				pStatement.setInt(5, povoamento.getGrausLong());
				pStatement.setInt(6, povoamento.getMinutosLong());
				pStatement.setDouble(7, povoamento.getSegundosLong()); 
				pStatement.setInt(8, povoamento.getGrausLat());
				pStatement.setInt(9, povoamento.getMinutosLat());
				pStatement.setDouble(10, povoamento.getSegundosLat());
				pStatement.setInt(11, povoamento.getQuantidadeSementes());
				int confirmacao = pStatement.executeUpdate();
				pStatement.close();

				if (confirmacao == 1) {
					JOptionPane.showMessageDialog(null, "O povoamento foi criado com sucesso!");
				} else {
					System.out.println("os valotes não foram salvos");
				}
				pStatement.close();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "deu pau no execel " + e.getMessage());
			}
		}
	}

	public void excluirPovoamento(String idPovoamento) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "DELETE FROM " + a.getTabelaPovoamento() + " WHERE idpovoamento = ?";
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement pStatement = con.getConection().prepareStatement(sql);
			pStatement.setString(1, idPovoamento);
			
			int confirmcao = pStatement.executeUpdate();
			pStatement.close();
			if (confirmcao == 1) {
				JOptionPane.showMessageDialog(null, "povoamento excluido");
			} else {
				JOptionPane.showMessageDialog(null, "erro ao excluir povoamento");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao excluir o povoamento" +e);
		}
	}

	public void editarPovoamento(Povoamento povoamento, String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "UPDATE " + a.getTabelaPovoamento() + " set " + a.getOSTRICULTOR() + " = ?," + a.getLOCALIDADE()
				+ " = ?," + a.getMUNICIPIO() + " = ?," + a.getDATA_INICIAL() + " = ?," + a.getLONGITUDE_GRAUS()
				+ " = ?," + a.getLONGITUDE_MINUTOS() + " = ?," + a.getLONGITUDE_SEGUNDOS() + " = ?,"
				+ a.getLATITUDE_GRAUS() + " = ?," + a.getLATITUDE_MINUTOS() + " = ?," + a.getLATITUDE_SEGUNDOS()
				+ " = ?," + a.getQT_SEMENTES() + " = ? where idpovoamento =" + id;
		
		povoamento.printarPovoamento();
		System.out.println("id edição: "+id);
		
		try { 
			ConnectionDB con = new ConnectionDB();
			PreparedStatement pStatement = con.getConection().prepareStatement(sql);
			pStatement.setString(1, povoamento.getNomeOstricultor());
			pStatement.setString(2, povoamento.getLocalidade());
			pStatement.setString(3, povoamento.getMunicipio());
			pStatement.setString(4, ValidacaoDeDatas.padronizarDatas(povoamento.getDataInicial()));
			pStatement.setInt(5, povoamento.getGrausLong());
			pStatement.setInt(6, povoamento.getMinutosLong());
			pStatement.setDouble(7, povoamento.getSegundosLong());
			pStatement.setInt(8, povoamento.getGrausLat());
			pStatement.setInt(9, povoamento.getMinutosLat());
			pStatement.setDouble(10, povoamento.getSegundosLat());
			pStatement.setInt(11, povoamento.getQuantidadeSementes());
			int confirmacao = pStatement.executeUpdate();
			pStatement.close();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "Povoamento editado");
			} else {
				JOptionPane.showMessageDialog(null, "Falha de update");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public java.util.List<Povoamento> resgatarPovoamentos() throws SQLException {
		ConnectionDB con = new ConnectionDB();
		PreparedStatement pstm;

		String sql = "SELECT p.idpovoamento,p.ostricultor,p.municipio,p.localidade,p.data_inicial, b.data_coleta,b.sistema_producao,b.qauntidadetotal,b.estagio_crescimento,MAX(data_coleta) FROM povoamento as p LEFT JOIN biometria AS b ON idpovoamento = \"id-dos-povoamentos\" GROUP BY idpovoamento;\r\n";
		java.util.List<Povoamento> povoamentos = new ArrayList<>();
		try {

			pstm = con.getConection().prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				AtributosPersistencia a = new AtributosPersistencia();
				Povoamento povoamento = new Povoamento();

				// apenas um teste para ver os valores chaves
				povoamento.setIDPovoamentos(rs.getInt(a.getID_POVOAMENTO()));
				povoamento.setNomeOstricultor(rs.getString(a.getOSTRICULTOR()));
				povoamento.setMunicipio(rs.getString(a.getMUNICIPIO()));
				povoamento.setLocalidade(rs.getString(a.getLOCALIDADE()));
				povoamento.setDataInicialPovoamento(rs.getString(a.getDATA_INICIAL()));
				povoamento.setDataUltimaBiometria(rs.getString(a.getDATA_COLETA()));
				povoamento.setSistema(rs.getString(a.getSISTEMA_PRODUCAO()));
				povoamento.setQtTotal(rs.getInt(a.getQUANTIDADETOTAL()));
				povoamento.setEstagioCrescimento(rs.getString(a.getESTAGIO_CRESCIMENTO()));
				povoamento.setMaxData(rs.getString("MAX(data_coleta)"));
				povoamentos.add(povoamento);
			}
			pstm.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return povoamentos;

	}

	public Povoamento resgatarPovoamento(String id) throws SQLException {
		ConnectionDB con = new ConnectionDB();
		PreparedStatement pstm;

		String sql = "SELECT * FROM povoamento WHERE idpovoamento = " + id;

		Povoamento povoamento = new Povoamento();
		try {

			pstm = con.getConection().prepareStatement(sql);

			ResultSet rs = pstm.executeQuery();
 
			AtributosPersistencia a = new AtributosPersistencia();

			// apenas um teste para ver os valores chaves
			povoamento.setIDPovoamentos(rs.getInt(a.getID_POVOAMENTO()));
			povoamento.setNomeOstricultor(rs.getString(a.getOSTRICULTOR()));
			povoamento.setMunicipio(rs.getString(a.getMUNICIPIO()));
			povoamento.setLocalidade(rs.getString(a.getLOCALIDADE()));
			povoamento.setDataInicialPovoamento(rs.getString(a.getDATA_INICIAL()));
			povoamento.setGrausLong(rs.getInt(a.getLONGITUDE_GRAUS()));
			povoamento.setMinutosLong(rs.getInt(a.getLONGITUDE_MINUTOS()));
			povoamento.setSegundosLong(rs.getInt(a.getLONGITUDE_SEGUNDOS()));
			
			povoamento.setGrausLat(rs.getInt(a.getLATITUDE_GRAUS()));
			povoamento.setMinutosLat(rs.getInt(a.getLATITUDE_MINUTOS()));
			povoamento.setSegundosLat(rs.getInt(a.getLATITUDE_SEGUNDOS()));
			povoamento.setQuantidadeSementes(rs.getInt(a.getQT_SEMENTES()));
			
			pstm.close();
		}

		catch (SQLException e) {
			// TODO: handle exception
		}
		return povoamento;
	}
}
