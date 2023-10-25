package bancoDeDados;

import java.sql.ResultSet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import execoes.ExcecaoValorNaoSetado;
import classes.Bolo;

public class BoloDAO implements DAO{

	public static Bolo get(int id) {

		String sql = "SELECT * FROM Bolo WHERE id = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Bolo boloEncontrado = new Bolo(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("valorUnitario"));
					boloEncontrado.setPeso(rs.getDouble("peso"));
					return boloEncontrado;
				}
			}
			return null;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		} catch(ExcecaoValorNaoSetado e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static ArrayList<Bolo> getAll(){
		String sql = "SELECT * FROM Bolo";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			
			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<Bolo> bolosEncontrados = new ArrayList<Bolo>;
				while (rs.next()) {
					Bolo boloEncontrado = new Bolo(rs.getInt("id"), rs.getString("descricao"), rs.getDouble("valorUnitario"));
					boloEncontrado.setPeso(rs.getDouble("peso"));
					bolosEncontrados.add(boloEncontrado);
				}
				return bolosEncontrados;
			}
			return null;

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}
	public static boolean criar(Bolo bolo) {
			String sql = "INSERT INTO Cliente VALUES (?, ?, ?, ?)";

			try {

				PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
				statement.setInt(1, bolo.getId());
				statement.setString(1, bolo.getDescricao());
				statement.setDouble(1, bolo.valorUnitario());
				statement.setDouble(1, bolo.getPeso());

				int rowsInserted = statement.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("Cliente inserido com sucesso!");
				}
				return true;
			} catch (SQLException e) {
				System.out.println(e);
				return false;
			} catch(ExcecaoValorNaoSetado e) {
				System.out.println(e);
				return false;
			}
		return true;
	}
	public static boolean atualizar(Bolo bolo) {return true;}
	public static boolean deletar(int id) {return true;}
}
