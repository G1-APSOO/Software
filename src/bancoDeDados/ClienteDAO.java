package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Cliente;
import excecoes.ExcecaoValorNaoSetado;

public class ClienteDAO implements DAO<Cliente, String>{
    @Override
    public Cliente get(String cpf) {
		String sql = "SELECT * FROM Cliente WHERE cpf = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setString(1, cpf);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					Cliente clienteEncontrado = new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getString("CEP"), rs.getString("celular"), rs.getString("email"), rs.getString("RG"), rs.getString("telefoneResidencial"), rs.getString("telefoneComercial"));
					return clienteEncontrado;
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
    public ArrayList<Cliente> getAll() {
        String sql = "SELECT * FROM Cliente";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<Cliente> clientesEncontrados = new ArrayList<Cliente>();
				while (rs.next()) {
					Cliente clienteEncontrado =  new Cliente(rs.getString("nome"), rs.getString("cpf"), rs.getString("endereco"), rs.getString("CEP"), rs.getString("celular"), rs.getString("email"), rs.getString("RG"), rs.getString("telefoneResidencial"), rs.getString("telefoneComercial"));
					clientesEncontrados.add(clienteEncontrado);
				}
				return clientesEncontrados;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
    }

    @Override
    public boolean criar(Cliente cliente) {
        String sql = "INSERT INTO Cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setString(1, cliente.getCpf());
			statement.setString(2, cliente.getNome());
			statement.setString(3, cliente.getRg());
			statement.setString(4, cliente.getEndereco());
			statement.setString(5, cliente.getCep());
			statement.setString(6, cliente.getCelular());
			statement.setString(7, cliente.getTelefoneResidencial());
			statement.setString(8, cliente.getTelefoneComercial());
			statement.setString(9, cliente.getEmail());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Cliente inserido com sucesso!");
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
    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, RG = ?, endereco = ?, CEP = ?, celular = ?, telefoneResidencial = ?, telefoneComercial = ?, email = ? WHERE CPF = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setString(1, cliente.getNome());
			statement.setString(2, cliente.getRg());
			statement.setString(3, cliente.getEndereco());
			statement.setString(4, cliente.getCep());
			statement.setString(5, cliente.getCelular());
			statement.setString(6, cliente.getTelefoneResidencial());
			statement.setString(7, cliente.getTelefoneComercial());
			statement.setString(8, cliente.getEmail());
			statement.setString(9, cliente.getCpf());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Cliente atualizado com sucesso!");
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
    public boolean deletar(String cpf) {
        String sql = "DELETE FROM Cliente WHERE cpf = ?";
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setString(1, cpf);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Cliente deletado com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
    }
}
