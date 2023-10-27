package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Salgado;
import classes.SalgadoSelecionado;
import excecoes.ExcecaoValorNaoSetado;

public class SalgadoSelecionadoDAO implements DAO<SalgadoSelecionado, String> {

	@Override
	public SalgadoSelecionado get(String salgadoBuffet) {
		// A string doceBuffet tem o seguinte formato: 'idSalgado idBuffetCompleto'
		int idSalgado = Integer.parseInt(salgadoBuffet.split(" ")[0]);
		int idBuffet = Integer.parseInt(salgadoBuffet.split(" ")[1]);

		String sql = "SELECT * FROM SalgadoSelecionado WHERE fk_idSalg = ? AND fk_idOrcamentoBuffetCompleto = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, idSalgado);
			statement.setInt(2, idBuffet);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					SalgadoDAO salgadoDAO = new SalgadoDAO();
					Salgado salgadoEncontrado = salgadoDAO.get(rs.getInt("fk_idSalg"));
					SalgadoSelecionado salgadoSelecionadoEncontrado = new SalgadoSelecionado(rs.getInt("quantidade"),
							salgadoEncontrado);
					return salgadoSelecionadoEncontrado;
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
	public ArrayList<SalgadoSelecionado> getAll() {
		String sql = "SELECT * FROM SalgadoSelecionado";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<SalgadoSelecionado> salgadosSelecionadosEncontrados = new ArrayList<SalgadoSelecionado>();
				SalgadoDAO salgadoDao = new SalgadoDAO();
				while (rs.next()) {
					Salgado salgadoEncontrado = salgadoDao.get(rs.getInt("fk_idSalg"));
					SalgadoSelecionado salgadoSelecionadoEncontrado = new SalgadoSelecionado(rs.getInt("quantidade"),
							salgadoEncontrado);
					salgadosSelecionadosEncontrados.add(salgadoSelecionadoEncontrado);
				}
				return salgadosSelecionadosEncontrados;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	public ArrayList<SalgadoSelecionado> getAllBuffet(int idBuffet) {
		String sql = "SELECT * FROM SalgadoSelecionado WHERE fk_idOrcamentoBuffetCompleto = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, idBuffet);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<SalgadoSelecionado> salgadosSelecionadosEncontrados = new ArrayList<SalgadoSelecionado>();
				SalgadoDAO salgadoDAO = new SalgadoDAO();
				while (rs.next()) {
					Salgado salgadoEncontrado = salgadoDAO.get(rs.getInt("fk_idSalg"));
					SalgadoSelecionado salgadoSelecionadoEncontrado = new SalgadoSelecionado(rs.getInt("quantidade"),
							salgadoEncontrado);
					salgadosSelecionadosEncontrados.add(salgadoSelecionadoEncontrado);
				}
				return salgadosSelecionadosEncontrados;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean criar(SalgadoSelecionado objeto) {
		throw new IllegalAccessError();
	}

	public boolean criarBuffet(SalgadoSelecionado salgadoSelecionado, int idBuffet) {
		String sql = "INSERT INTO SalgadoSelecionado VALUES (?, ?, ?)";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, salgadoSelecionado.getQuantidade());
			statement.setInt(2, salgadoSelecionado.getSalgado().getId());
			statement.setInt(3, idBuffet);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("SalgadoSelecionado inserido com sucesso!");
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
	public boolean atualizar(SalgadoSelecionado objeto) {
		throw new IllegalAccessError();
	}

	public boolean atualizarBuffet(SalgadoSelecionado salgadoSelecionado, int idBuffet) {
		String sql = "UPDATE SalgadoSelecionado SET quantidade = ? WHERE fk_idSalg = ? AND fk_idOrcamentoBuffetCompleto = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, salgadoSelecionado.getQuantidade());
			statement.setInt(2, salgadoSelecionado.getSalgado().getId());
			statement.setInt(3, idBuffet);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("SalgadoSelecionado atualizado com sucesso!");
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
		String sql = "DELETE FROM SalgadoSelecionado WHERE fk_idOrcamentoBuffetCompleto = ?";
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, idBuffet);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("SalgadoSelecionado(s) deletado(s) com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

}
