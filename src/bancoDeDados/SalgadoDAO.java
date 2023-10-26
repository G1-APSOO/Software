package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Doce;
import classes.Salgado;
import excecoes.ExcecaoValorNaoSetado;

public class SalgadoDAO implements DAO<Salgado, Integer>{

	@Override
	public Salgado get(Integer objetoInteger) {
		int id = objetoInteger.intValue();

		String sql = "SELECT * FROM Salgado WHERE id = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Salgado salgadoEncontrado = new Salgado(rs.getInt("id"), rs.getString("descricao"),
							rs.getDouble("valorUnitario"));
					return salgadoEncontrado;
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
	public ArrayList<Salgado> getAll() {
		String sql = "SELECT * FROM Salgado";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<Salgado> salgadosEncontrados = new ArrayList<Salgados>();
				while (rs.next()) {
					Salgado salgadoEncontrado = new Salgado(rs.getInt("id"), rs.getString("descricao"),
							rs.getDouble("valorUnitario"));
					salgadosEncontrados.add(salgadoEncontrado);
				}
				return salgadosEncontrados;
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
	public boolean criar(Salgado salgado) {
		String sql = "INSERT INTO Salgado VALUES (?, ?, ?)";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, salgado.getId());
			statement.setString(2, salgado.getDescricao());
			statement.setDouble(3, salgado.getValorUnitario());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Salgado inserido com sucesso!");
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
	public boolean atualizar(Salgado salgado) {
		String sql = "UPDATE Salgado SET descricao = ?, valorUnitario = ? WHERE id = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setString(1, salgado.getDescricao());
			statement.setDouble(2, salgado.getValorUnitario());
			statement.setInt(3, salgado.getId());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Salgado atualizado com sucesso!");
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
	public boolean deletar(Integer objetoInteger) {
		String sql = "DELETE FROM Salgado WHERE id = ?";
		int id = objetoInteger.intValue();
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Doce deletado com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}
	
}
