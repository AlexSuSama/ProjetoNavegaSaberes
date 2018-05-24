package br.alexsusama.persisntencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.alexsusama.atributos.AtributosPersistencia;
import br.alexsusama.modelo.Estoque;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class SaidaEntradaEstoque {
	public void salvarEstoque(Estoque estoque) {
		String sql = "INSERT INTO estoque (data_estoque,semente_estoque,juvenil_estoque,media_estoque,baby_estoque,master_estoque,malha69,malha12,malha14,malha21,long_line,coletores,varal,mesa_madeira,mesa_pvc,mesa_telada)values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement statement = con.getConection().prepareStatement(sql);
			statement.setString(1, ValidacaoDeDatas.padronizarDatas(estoque.getData()));
			statement.setInt(2, estoque.getOstraSemente());
			statement.setInt(3, estoque.getOstraJuvenil());
			statement.setInt(4, estoque.getOstraMedia());
			statement.setInt(5, estoque.getOstraBaby());
			statement.setInt(6, estoque.getOstraMaster());
			statement.setInt(7, estoque.getMalha69());
			statement.setInt(8, estoque.getMalha12());
			statement.setInt(9, estoque.getMalha14());
			statement.setInt(10, estoque.getMalha21());
			statement.setInt(11, estoque.getLongLine());
			statement.setInt(12, estoque.getColetores());
			statement.setInt(13, estoque.getVaral());
			statement.setInt(14, estoque.getMesaMadeira());
			statement.setInt(15, estoque.getMesaPVC());
			statement.setInt(16, estoque.getMesaTelada());
			int confirmacao = statement.executeUpdate();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "O estoque foi salvo");
			} else {
				JOptionPane.showMessageDialog(null, "erro ao salvar o estoque");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error" + e.getMessage());
		}
	}

	public void editarEstoque(Estoque estoque, String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "UPDATE estoque set " + a.getDATA_ESTOQUE() + " =?, " + a.getSEMENTE_ESTOQUE() + " = ?,"
				+ a.getJUVENIL_ESTOQUE() + " =? ," + a.getMEDIA_ESTOQUE() + "=? ," + a.getBABY_ESTOQUE() + "=?,"
				+ a.getMASTER_ESTOQUE() + " = ?, " + a.getMALHA69() + " = ?, " + a.getMALHA12() + " = ?, "
				+ a.getMALHA14() + " = ?, " + a.getMALHA21() + " = ?, " + a.getLONG_LINE() + " = ?," + a.getCOLETORES()
				+ " = ?, " + a.getVARAL() + " = ?, " + a.getMESA_MADEIRA() + " = ?," + a.getMESA_PVC() + " = ?, "
				+ a.getMESA_TELADA() + " = ? where idestoque = " + id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement statement = con.getConection().prepareStatement(sql);
			statement.setString(1, ValidacaoDeDatas.padronizarDatas(estoque.getData()));
			statement.setInt(2, estoque.getOstraSemente());
			statement.setInt(3, estoque.getOstraJuvenil());
			statement.setInt(4, estoque.getOstraMedia());
			statement.setInt(5, estoque.getOstraBaby());
			statement.setInt(6, estoque.getOstraMaster());
			statement.setInt(7, estoque.getMalha69());
			statement.setInt(8, estoque.getMalha12());
			statement.setInt(9, estoque.getMalha14());
			statement.setInt(10, estoque.getMalha21());
			statement.setInt(11, estoque.getLongLine());
			statement.setInt(12, estoque.getColetores());
			statement.setInt(13, estoque.getVaral());
			statement.setInt(14, estoque.getMesaMadeira());
			statement.setInt(15, estoque.getMesaPVC());
			statement.setInt(16, estoque.getMesaTelada());
			int confirmacao = statement.executeUpdate();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "O estoque foi atualizado");
			} else {
				JOptionPane.showMessageDialog(null, "erro ao editar o estoque");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error" + e.getMessage());
		}
	}

	public void excluirEstoque(String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "DELETE FROM " + a.getTabela_estoque() + " WHERE idestoque = " + id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement statement = con.getConection().prepareStatement(sql);
			int confirmacao = statement.executeUpdate();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "O estoque foi excluido");
			} else {
				JOptionPane.showMessageDialog(null, "erro ao excluir o estoque");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error" + e.getMessage());
		}

	}

	public Estoque resgatarEstoque() {
		String sql = "SELECT * FROM estoque where idestoque = (SELECT max(idestoque) FROM estoque)";
		ConnectionDB connectionDB;
		PreparedStatement statement;
		AtributosPersistencia a = new AtributosPersistencia();
		try {
			connectionDB = new ConnectionDB();
			statement = connectionDB.getConection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			Estoque estoque = new Estoque();

			if (rs != null) {

				estoque.setDataEstoque(rs.getString(a.getDATA_ESTOQUE()));
				estoque.setOstraSemente(rs.getInt(a.getSEMENTE_ESTOQUE()));
				estoque.setOstraJuvenil(rs.getInt(a.getJUVENIL_ESTOQUE()));
				estoque.setOstraBaby(rs.getInt(a.getBABY_ESTOQUE()));
				estoque.setOstraMedia(rs.getInt(a.getMEDIA_ESTOQUE()));
				estoque.setOstraMaster(rs.getInt(a.getMASTER_ESTOQUE()));

				estoque.setMalha69(rs.getInt(a.getMALHA69()));
				estoque.setMalha12(rs.getInt(a.getMALHA12()));
				estoque.setMalha14(rs.getInt(a.getMALHA14()));
				estoque.setMalha21(rs.getInt(a.getMALHA21()));

				estoque.setLongLine(rs.getInt(a.getLONG_LINE()));
				estoque.setVaral(rs.getInt(a.getVARAL()));
				estoque.setColetores(rs.getInt(a.getCOLETORES()));
				estoque.setMesaTelada(rs.getInt(a.getMESA_TELADA()));
				estoque.setMesaPVC(rs.getInt(a.getMESA_PVC()));
				estoque.setMesaMadeira(rs.getInt(a.getMESA_MADEIRA()));
			} else {
				System.out.println("reslutado da busca esta vazio");
			}
			return estoque;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao fazer a busca no banco de dados");
		}
		return null;
	}
}
