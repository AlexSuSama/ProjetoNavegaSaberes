package br.alexsusama.persisntencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import javax.swing.JOptionPane;
//import javax.swing.plaf.ComponentInputMapUIResource;

import br.alexsusama.atributos.AtributosPersistencia;
import br.alexsusama.modelo.Comercializacao;
import br.alexsusama.validacoes.ValidacaoDeDatas;

public class SaidaEntradaComercializacao {
	public void criarNovaComercializacao(Comercializacao comercializacao, String idParent) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "INSERT INTO " + a.getTabela_comercializacao() + " (" + a.getDATA_VENDA() + ","
				+ a.getNOME_COMPRADOR() + "," + a.getTIPO_COMPRADOR() + "," + a.getVALOR_COMERCILIZADO() + ","
				+ a.getTIPO_COMERCIALIZADO() + "," + a.getMUNICIPIO_COMERCIALIZADO() + ","
				+ a.getLOCALIDADE_COMERCIALIZADA() + "," + a.getID_POV_COMERCIALIZACAO() + "," + a.getVALOR_FRETE()
				+ "," + a.getDUZIAS_BABY() + "," + a.getDUZIAS_MEDIA() + "," + a.getDUZIAS_MASTER()
				+ ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement psStatement = con.getConection().prepareStatement(sql);
			psStatement.setString(1, ValidacaoDeDatas.padronizarDatas(comercializacao.getDataVenda()));
			psStatement.setString(2, comercializacao.getNomeComprador());
			psStatement.setString(3, comercializacao.getTipoDeComprador());
			psStatement.setInt(4, comercializacao.getValorVenda());
			psStatement.setString(5, comercializacao.getTipoComercializado());
			psStatement.setString(6, comercializacao.getMunicipio());
			psStatement.setString(7, comercializacao.getLocalidade());
			psStatement.setString(8, idParent);
			psStatement.setInt(9, comercializacao.getValorFrete());
			psStatement.setInt(10, comercializacao.getDuziasBaby());
			psStatement.setInt(11, comercializacao.getDuziasMedias());
			psStatement.setInt(12, comercializacao.getDuziasMaster());

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

	public List<Comercializacao> resgatarComercializacoes(String id) {
		AtributosPersistencia a = new AtributosPersistencia();

		String sql = "SELECT * FROM comercializacao WHERE id_povoamento = " + id;
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

				comercializacao.setDuziasBaby(rs.getInt(a.getDUZIAS_BABY()));
				comercializacao.setDuziasMedias(rs.getInt(a.getDUZIAS_MEDIA()));
				comercializacao.setDuziasMaster(rs.getInt(a.getDUZIAS_MASTER()));

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
	/*
	 * preciso colocar todos os valores das variaveis que correspondem as duzias
	 * vendidas em todas as incerções
	 */

	public void editarComercializacao(Comercializacao comercializacao, String id) {
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "UPDATE " + a.getTabela_comercializacao() + " SET " + a.getDATA_VENDA() + " = ?,"
				+ a.getNOME_COMPRADOR() + "= ?," + a.getTIPO_COMPRADOR() + "= ?," + a.getVALOR_COMERCILIZADO() + "= ?,"
				+ a.getTIPO_COMERCIALIZADO() + "= ?," + a.getMUNICIPIO_COMERCIALIZADO() + "= ?,"
				+ a.getLOCALIDADE_COMERCIALIZADA() + " = ?," + a.getDUZIAS_BABY() + "=?," + a.getDUZIAS_MEDIA() + "=?,"
				+ a.getDUZIAS_MASTER() + " = ? WHERE id_comercializacao = " + id;
		try {
			ConnectionDB con = new ConnectionDB();
			PreparedStatement psStatement = con.getConection().prepareStatement(sql);
			psStatement.setString(1, ValidacaoDeDatas.padronizarDatas(comercializacao.getDataVenda()));
			psStatement.setString(2, comercializacao.getNomeComprador());
			psStatement.setString(3, comercializacao.getTipoDeComprador());
			psStatement.setInt(4, comercializacao.getValorVenda());
			psStatement.setString(5, comercializacao.getTipoComercializado());
			psStatement.setString(6, comercializacao.getMunicipio());
			psStatement.setString(7, comercializacao.getLocalidade());
			
			psStatement.setInt(8, comercializacao.getDuziasBaby());
			psStatement.setInt(9, comercializacao.getDuziasMedias());
			psStatement.setInt(10, comercializacao.getDuziasMaster());
			
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
			// comercializacao.setQtVendidas(rs.getInt(a.getDUZIAS_VENDIDA()));
			
			comercializacao.setDuziasBaby(rs.getInt(a.getDUZIAS_BABY()));
			comercializacao.setDuziasMedias(rs.getInt(a.getDUZIAS_MEDIA()));
			comercializacao.setDuziasMaster(rs.getInt(a.getDUZIAS_MASTER()));
			
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

	public java.util.List<Comercializacao> valoresComercializacaoMunicipio(String dataInicial, String dataFinal,
			String idPovoamento) throws SQLException {
		ConnectionDB conexaoDB = new ConnectionDB();
		PreparedStatement pstm;
		AtributosPersistencia a = new AtributosPersistencia();
		String sql = "SELECT data_venda, municipio,sum(duzias_baby+duzias_medias+duzias_master), sum(duzias_baby),sum(duzias_master),sum(duzias_medias), valor_frete from comercializacao  where id_povoamento = "+idPovoamento+" GROUP BY municipio";

		java.util.List<Comercializacao> comercializacaos = new ArrayList<>();
		try {
			pstm = conexaoDB.getConection().prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				Comercializacao comercializacao = new Comercializacao();
				comercializacao.setDataComercializacao(rs.getString(a.getDATA_VENDA()));
				comercializacao.setMunicipio(rs.getString(a.getMUNICIPIO_COMERCIALIZADO()));
				//tenho que colocar para somar todas as formas de comercializacao
				
				comercializacao.setDuziasBaby(rs.getInt("sum(duzias_baby)"));
				comercializacao.setDuziasMedias(rs.getInt("sum(duzias_medias)"));
				comercializacao.setDuziasMaster(rs.getInt("sum(duzias_master)"));
				
				comercializacao.setDuziasTotal(rs.getInt( "sum(duzias_baby+duzias_medias+duzias_master)"));
				
				comercializacao.setValorFrete(rs.getInt(a.getVALOR_FRETE()));
				comercializacaos.add(comercializacao);
			}
			pstm.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL RESGATAR OS VALORES REFERENTES AS COMERCIALIZAÇÕES");
		}
		return comercializacaos;
	}
}
