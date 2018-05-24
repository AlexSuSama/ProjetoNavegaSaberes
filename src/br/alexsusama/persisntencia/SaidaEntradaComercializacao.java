package br.alexsusama.persisntencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.plaf.ComponentInputMapUIResource;

import br.alexsusama.atributos.AtributosPersistencia;
import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class SaidaEntradaComercializacao {
	public void criarNovaComercializacao(Comercializacao comercializacao) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "INSERT INTO " + a.getTabela_comercializacao() + " (" + a.getDATA_VENDA() + ","
				+ a.getNOME_COMPRADOR() + "," + a.getTIPO_COMPRADOR() + "," + a.getVALOR_COMERCILIZADO() + ","
				+ a.getTIPO_COMERCIALIZADO() + "," + a.getDUZIAS_VENDIDA() + "," + a.getMUNICIPIO_COMERCIALIZADO() + ","
				+ a.getLOCALIDADE_COMERCIALIZADA() + ") VALUES(?,?,?,?,?,?,?,?)";
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement psStatement = con.getConection().prepareStatement(sql);
			psStatement.setString(1, ValidacaoDeDatas.padronizarDatas(comercializacao.getDataVenda()));
			psStatement.setString(2, comercializacao.getNomeComprador());
			psStatement.setString(3, comercializacao.getTipoDeComprador());
			psStatement.setInt(4, comercializacao.getValorVenda());
			psStatement.setString(5, comercializacao.getTipoComercializado());
			psStatement.setInt(6, comercializacao.getQtVendidas());
			psStatement.setString(7, comercializacao.getMunicipio());
			psStatement.setString(8, comercializacao.getLocalidade());
			int confirmacao = psStatement.executeUpdate();
			psStatement.close();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "comercialização salvada!");
			} else {
				JOptionPane.showMessageDialog(null, "falha ao salvar a comercialização!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao criar a nova comercialização " + e.getMessage());
		}
	}

	public List<Comercializacao> resgatarComercializacoes() {
		AtributosPersistencia a = new AtributosPersistencia();

		String sql = "SELECT * FROM comercializacao";
		ConnectionDB con;
		List<Comercializacao> listaComercializacao = new ArrayList<Comercializacao>();
		try {
			con = new ConnectionDB();
			PreparedStatement statement = con.getConection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				Comercializacao comercializacao = new Comercializacao();

				comercializacao.setDataComercializacao(rs.getString(a.getDATA_VENDA()));

				comercializacao.setNomeComprador(rs.getString(a.getNOME_COMPRADOR()));
				comercializacao.setLocalidade(rs.getString(a.getLOCALIDADE_COMERCIALIZADA()));
				comercializacao.setMunicipio(rs.getString(a.getMUNICIPIO_COMERCIALIZADO()));
				comercializacao.setTipoDeComprador(rs.getString(a.getTIPO_COMPRADOR()));
				comercializacao.setQtVendidas(rs.getInt(a.getDUZIAS_VENDIDA()));
				comercializacao.setValorVenda(rs.getInt(a.getVALOR_COMERCIALIZACAO()));
				comercializacao.setIdComercializacao(rs.getInt(a.getID_COMERCIALIZACAO()));
				comercializacao.setTipoComercializado(rs.getString(a.getTIPO_COMERCIALIZADO()));

				listaComercializacao.add(comercializacao);
			}
			return listaComercializacao;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaComercializacao;

	}

	public void editarComercializacao(Comercializacao comercializacao, String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "UPDATE " + a.getTabela_comercializacao() + " SET " + a.getDATA_VENDA() + " = ?,"
				+ a.getNOME_COMPRADOR() + "= ?," + a.getTIPO_COMPRADOR() + "= ?," + a.getVALOR_COMERCILIZADO() + "= ?,"
				+ a.getTIPO_COMERCIALIZADO() + "= ?," + a.getDUZIAS_VENDIDA() + "= ?," + a.getMUNICIPIO_COMERCIALIZADO()
				+ "= ?," + a.getLOCALIDADE_COMERCIALIZADA() + " = ? WHERE id_comercializacao = " + id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement psStatement = con.getConection().prepareStatement(sql);
			psStatement.setString(1, ValidacaoDeDatas.padronizarDatas(comercializacao.getDataVenda()));
			psStatement.setString(2, comercializacao.getNomeComprador());
			psStatement.setString(3, comercializacao.getTipoDeComprador());
			psStatement.setInt(4, comercializacao.getValorVenda());
			psStatement.setString(5, comercializacao.getTipoComercializado());
			psStatement.setInt(6, comercializacao.getQtVendidas());
			psStatement.setString(7, comercializacao.getMunicipio());
			psStatement.setString(8, comercializacao.getLocalidade());
			int confirmacao = psStatement.executeUpdate();

			psStatement.close();
			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "comercialização editada!");
			} else {
				JOptionPane.showMessageDialog(null, "falha ao editar a comercialização!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro ao salvar edição comercialização " + e.getMessage());
		}
	}

	public void excluirComercializacao(String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "DELETE FROM " + a.getTabela_comercializacao() + " WHERE " + a.getID_COMERCIALIZACAO() + " = "
				+ id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement statement = con.getConection().prepareStatement(sql);
			int confirmacao = statement.executeUpdate();

			if (confirmacao == 1) {
				JOptionPane.showMessageDialog(null, "comercialização excluida!");
			} else {
				JOptionPane.showMessageDialog(null, "falha de exclusão!");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "erro de sql ao excluir o banco");
		}
	}

	public Comercializacao resgatarComercializacao(String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "Select * from comercializacao where id_comercializacao = " + id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement statement = con.getConection().prepareStatement(sql);
			ResultSet rs = statement.executeQuery();

			Comercializacao comercializacao = new Comercializacao();

			comercializacao.setDataComercializacao(rs.getString(a.getDATA_VENDA()));

			comercializacao.setNomeComprador(rs.getString(a.getNOME_COMPRADOR()));
			comercializacao.setLocalidade(rs.getString(a.getLOCALIDADE_COMERCIALIZADA()));
			comercializacao.setMunicipio(rs.getString(a.getMUNICIPIO_COMERCIALIZADO()));
			comercializacao.setTipoDeComprador(rs.getString(a.getTIPO_COMPRADOR()));
			comercializacao.setQtVendidas(rs.getInt(a.getDUZIAS_VENDIDA()));
			comercializacao.setValorVenda(rs.getInt(a.getVALOR_COMERCIALIZACAO()));
			comercializacao.setIdComercializacao(rs.getInt(a.getID_COMERCIALIZACAO()));
			comercializacao.setTipoComercializado(rs.getString(a.getTIPO_COMERCIALIZADO()));

			statement.close();

			return comercializacao;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "deu pau no excel!");
		}
		return null;
	}

	public java.util.List<Comercializacao> valoresComercializacaoMunicipio(String dataInicial, String dataFinal)
			throws SQLException {
		ConnectionDB conexaoDB = new ConnectionDB();
		PreparedStatement pstm;
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "SELECT data_venda,municipio, sum(duzias_vendida) from comercializacao GROUP BY municipio;";

		java.util.List<Comercializacao> comercializacaos = new ArrayList<>();
		try {
			pstm = conexaoDB.getConection().prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Comercializacao comercializacao = new Comercializacao();
				comercializacao.setDataComercializacao(rs.getString(a.getDATA_VENDA()));
				comercializacao.setMunicipio(rs.getString(a.getMUNICIPIO_COMERCIALIZADO()));
				comercializacao.setQtVendidas(rs.getInt("sum(duzias_vendida)"));
				comercializacaos.add(comercializacao);
			}
			pstm.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL RESGATAR OS VALORES REFERENTES AS COMERCIALIZAÇÕES");
		}
		return comercializacaos;
	}
}
