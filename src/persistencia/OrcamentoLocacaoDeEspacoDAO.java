package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import classes.Bolo;
import classes.Cliente;
import classes.Data;
import classes.Doce;
import classes.OrcamentoBuffetCompleto;
import classes.OrcamentoLocacaoDeEspaco;
import classes.Pagamento;
import classes.Salgado;
import classes.ServicoContratado;
import excecoes.ExcecaoValorNaoSetado;

public class OrcamentoLocacaoDeEspacoDAO implements DAO<OrcamentoLocacaoDeEspaco, Integer> {

	@Override
	public OrcamentoLocacaoDeEspaco get(Integer chavePrimaria) {
		int id = chavePrimaria.intValue();

		String sql = "SELECT * FROM OrcamentoLocacaoDeEspaco WHERE id = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					String cpfCliente = rs.getString("fk_cpfCliente");
					String dataString = rs.getString("data");
					int dia = Integer.parseInt(dataString.split("/")[0]);
					int mes = Integer.parseInt(dataString.split("/")[1]);
					int ano = Integer.parseInt(dataString.split("/")[2]);
					Data dataOrcamento = new Data(dia, mes, ano);

					ClienteDAO clienteDAO = new ClienteDAO();
					ServicoContratadoDAO servicoContratadoDAO = new ServicoContratadoDAO();
					ArrayList<ServicoContratado> servicosContratados = servicoContratadoDAO.getAllBuffet(id);

					OrcamentoLocacaoDeEspaco orcamentoLocacaoDeEspacoEncontrado = new OrcamentoLocacaoDeEspaco(
							rs.getInt("numeroDeConvidados"), rs.getInt("numeroDeColaboradores"),
							rs.getString("horaDeInicio"), dataOrcamento, null, clienteDAO.get(cpfCliente),
							servicosContratados);
					return orcamentoLocacaoDeEspacoEncontrado;
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
	public boolean existeEssaChavePrimaria(Integer chavePrimaria) {
		int chavePrimariaInt = chavePrimaria.intValue();
		String sql = "SELECT * FROM OrcamentoLocacaoDeEspaco WHERE id = ?";
		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, chavePrimariaInt);

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
			return true;
		} catch (ExcecaoValorNaoSetado e) {
			System.out.println(e);
			return true;
		}
	}

	@Override
	public ArrayList<OrcamentoLocacaoDeEspaco> getAll() {
		String sql = "SELECT * FROM OrcamentoLocacaoDeEspaco";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<OrcamentoLocacaoDeEspaco> orcamentoLocacaoDeEspacoEncontrados = new ArrayList<OrcamentoLocacaoDeEspaco>();
				ClienteDAO clienteDao = new ClienteDAO();
				ServicoContratadoDAO servicoContratadoDAO = new ServicoContratadoDAO();
//				PagamentoDAO pagamentoDao = new PagamentoDAO();
				while (rs.next()) {
					String cpfCliente = rs.getString("fk_cpfCliente");

					String dataString = rs.getString("data");
					int dia = Integer.parseInt(dataString.split("/")[0]);
					int mes = Integer.parseInt(dataString.split("/")[1]);
					int ano = Integer.parseInt(dataString.split("/")[2]);
					Data dataOrcamento = new Data(dia, mes, ano);

					ArrayList<ServicoContratado> servicosContratados = servicoContratadoDAO
							.getAllBuffet(rs.getInt("id"));

					OrcamentoLocacaoDeEspaco orcamentoLocacaoDeEspacoEncontrado = new OrcamentoLocacaoDeEspaco(
							rs.getInt("numeroDeConvidados"), rs.getInt("numeroDeColaboradores"),
							rs.getString("horaDeInicio"), dataOrcamento, null, clienteDao.get(cpfCliente),
							servicosContratados);
					orcamentoLocacaoDeEspacoEncontrados.add(orcamentoLocacaoDeEspacoEncontrado);
				}
				return orcamentoLocacaoDeEspacoEncontrados;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean criar(OrcamentoLocacaoDeEspaco orcamentoLocacaoDeEspaco) {
		String sql = "INSERT INTO OrcamentoLocacaoDeEspaco VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
//			rs.getInt("numeroDeConvidados"), rs.getInt("numeroDeColaboradores"),
//			rs.getString("horaDeInicio"), dataOrcamento, null, clienteDao.get(cpfCliente),
//			servicosContratados);
			Random random = new Random();
			int id = random.nextInt(2147483646);
			while (existeEssaChavePrimaria(id)) {
				id = random.nextInt(2147483646);
			}

			orcamentoLocacaoDeEspaco.setId(id);

			statement.setInt(1, id);
			statement.setInt(2, orcamentoLocacaoDeEspaco.getNumeroDeConvidados());
			statement.setInt(3, orcamentoLocacaoDeEspaco.getNumeroDeColaboradores());
			statement.setString(4, orcamentoLocacaoDeEspaco.getHoraDeInicio());
			statement.setString(5, orcamentoLocacaoDeEspaco.getData().getData());
			statement.setInt(6, -1);
			statement.setString(7, orcamentoLocacaoDeEspaco.getCliente().getCpf());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("OrcamentoLocacaoDeEspaco inserido com sucesso!");
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
	public boolean atualizar(OrcamentoLocacaoDeEspaco orcamentoLocacaoDeEspaco) {
		String sql = "UPDATE OrcamentoLocacaoDeEspaco SET numeroDeConvidados = ?, numeroDeColaboradores = ?, horaDeInicio = ?, data = ?, fk_cpfCliente = ?, fk_idPagamento = ? WHERE id = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			
			statement.setInt(1, orcamentoLocacaoDeEspaco.getNumeroDeConvidados());
			statement.setInt(2, orcamentoLocacaoDeEspaco.getNumeroDeColaboradores());
			statement.setString(3, orcamentoLocacaoDeEspaco.getHoraDeInicio());
			statement.setString(4, orcamentoLocacaoDeEspaco.getData().getData());
			statement.setString(5, orcamentoLocacaoDeEspaco.getCliente().getCpf());
			statement.setInt(6, -1);
			statement.setInt(7, orcamentoLocacaoDeEspaco.getId());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("OrcamentoLocacaoDeEspaco atualizado com sucesso!");
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
	public boolean deletar(Integer chavePrimaria) {
		int id = chavePrimaria.intValue();

		ServicoContratadoDAO servicoContratadoDAO = new ServicoContratadoDAO();

		servicoContratadoDAO.deletar(Integer.toString(chavePrimaria));

		String sql = "DELETE FROM OrcamentoLocacaoDeEspaco WHERE id = ?";
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("OrcamentoLocacaoDeEspaco deletado com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public boolean verificarData(Data data) {
		String dataString = data.getData();

		String sql = "SELECT * FROM OrcamentoLocacaoDeEspaco WHERE data = ?";
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setString(1, dataString);
			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					return false;
				} else {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

}
