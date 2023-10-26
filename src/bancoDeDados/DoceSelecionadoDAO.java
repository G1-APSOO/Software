package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Doce;
import classes.DoceSelecionado;
import excecoes.ExcecaoValorNaoSetado;

public class DoceSelecionadoDAO implements DAO<DoceSelecionado, String> {

	@Override
	public DoceSelecionado get(String doceBuffet) {
		// A string doceBuffet tem o seguinte formato: 'idDoce idBuffetCompleto'
		int idDoce = Integer.parseInt(doceBuffet.split(" ")[0]);
		int idBuffet = Integer.parseInt(doceBuffet.split(" ")[1]);

		String sql = "SELECT * FROM DoceSelecionado WHERE fk_idDoce = ? AND fk_idOrcamentoBuffetCompleto = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, idDoce);
			statement.setInt(2, idBuffet);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					DoceDAO doceDao = new DoceDAO();
					Doce doceEncontrado = doceDao.get(rs.getInt("fk_idDoce"));
					DoceSelecionado doceSelecionadoEncontrado = new DoceSelecionado(rs.getInt("quantidade"),
							doceEncontrado);
					return doceSelecionadoEncontrado;
				}
			}
			return null;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} catch (ExcecaoValorNaoSetado e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<DoceSelecionado> getAll() {
		String sql = "SELECT * FROM DoceSelecionado";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<DoceSelecionado> docesSelecionadosEncontrados = new ArrayList<DoceSelecionado>();
				DoceDAO doceDao = new DoceDAO();
				while (rs.next()) {
					Doce doceEncontrado = doceDao.get(rs.getInt("fk_idDoce"));
					DoceSelecionado doceSelecionadoEncontrado = new DoceSelecionado(rs.getInt("quantidade"),
							doceEncontrado);
					docesSelecionadosEncontrados.add(doceSelecionadoEncontrado);
				}
				return docesSelecionadosEncontrados;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<DoceSelecionado> getAllBuffet(int idBuffet) {
		String sql = "SELECT * FROM DoceSelecionado WHERE fk_idOrcamentoBuffetCompleto = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, idBuffet);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<DoceSelecionado> docesSelecionadosEncontrados = new ArrayList<DoceSelecionado>();
				DoceDAO doceDao = new DoceDAO();
				while (rs.next()) {
					Doce doceEncontrado = doceDao.get(rs.getInt("fk_idDoce"));
					DoceSelecionado doceSelecionadoEncontrado = new DoceSelecionado(rs.getInt("quantidade"),
							doceEncontrado);
					docesSelecionadosEncontrados.add(doceSelecionadoEncontrado);
				}
				return docesSelecionadosEncontrados;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean criar(DoceSelecionado doceSelecionado) {
		throw new IllegalAccessError();
	}

	public boolean criarBuffet(DoceSelecionado doceSelecionado, int idBuffet) {
		String sql = "INSERT INTO DoceSelecionado VALUES (?, ?, ?)";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, doceSelecionado.getQuantidade());
			statement.setInt(2, doceSelecionado.getDoce().getId());
			statement.setInt(3, idBuffet);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("DoceSelecionado inserido com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		} catch (ExcecaoValorNaoSetado e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean atualizar(DoceSelecionado objeto) {
		throw new IllegalAccessError();
	}

	public boolean atualizarBuffet(DoceSelecionado doceSelecionado, int idBuffet) {
		String sql = "UPDATE DoceSelecionado SET quantidade = ? WHERE fk_idDoce = ? AND fk_idOrcamentoBuffetCompleto = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, doceSelecionado.getQuantidade());
			statement.setInt(2, doceSelecionado.getDoce().getId());
			statement.setInt(3, idBuffet);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("DoceSelecionado atualizado com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		} catch (ExcecaoValorNaoSetado e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deletar(String idBuffetParam) {
		int idBuffet = Integer.parseInt(idBuffetParam);
		String sql = "DELETE FROM DoceSelecionado WHERE fk_idOrcamentoBuffetCompleto = ?";
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, idBuffet);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("DoceSelecionado(s) deletado(s) com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

}
