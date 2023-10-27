package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Doce;
import classes.DoceSelecionado;
import classes.Bolo;
import classes.Cliente;
import classes.Data;
import classes.OrcamentoBuffetCompleto;
import classes.Pagamento;
import classes.Salgado;
import classes.SalgadoSelecionado;
import excecoes.ExcecaoValorNaoSetado;

public class OrcamentoBuffetCompletoDAO implements DAO<OrcamentoBuffetCompleto, Integer> {

	@Override
	public OrcamentoBuffetCompleto get(Integer objetoInteger) {
		int id = objetoInteger.intValue();
		String sql = "SELECT * FROM OrcamentoBuffetCompleto WHERE id = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					String cpfCliente = rs.getString("fk_cpfCliente");
					int idBolo = rs.getInt("fk_idBolo");
					int idPagamento = rs.getInt("fk_idBolo");
					// atributos OrcamentoBuffetCompleto no banco
					// id numeroDeConvidados numeroDeColaboradores horaDeInicio data teraCerveja
					// fk_cpfCliente fk_idBolo fk_idPagamento

					// formato data: dd/mm/aaaa
					String dataString = rs.getString("data");
					int dia = Integer.parseInt(dataString.split("/")[0]);
					int mes = Integer.parseInt(dataString.split("/")[1]);
					int ano = Integer.parseInt(dataString.split("/")[2]);
					Data dataOrcamento = new Data(dia, mes, ano);

					boolean teraCerveja = rs.getInt("teraCerveja") == 1;

					SalgadoSelecionadoDAO salgadoSelecionadoDao = new SalgadoSelecionadoDAO();
					ArrayList<SalgadoSelecionado> salgadosSelecionados = salgadoSelecionadoDao
							.getAllBuffet(rs.getInt("id"));
					ArrayList<Salgado> salgados = new ArrayList<Salgado>();

					for (int i = 0; i < salgadosSelecionados.size(); i++)
						salgados.add(salgadosSelecionados.get(i).getSalgado());

					DoceSelecionadoDAO doceSelecionadoDao = new DoceSelecionadoDAO();
					ArrayList<DoceSelecionado> docesSelecionados = doceSelecionadoDao.getAllBuffet(rs.getInt("id"));
					ArrayList<Doce> doces = new ArrayList<Doce>();

					for (int i = 0; i < docesSelecionados.size(); i++)
						doces.add(docesSelecionados.get(i).getDoce());

					BoloDAO boloDao = new BoloDAO();
					Bolo bolo = boloDao.get(idBolo);

//					Quando houver cliente:
//					ClienteDAO clienteDao = new ClienteDAO();
//					Cliente cliente = clienteDao.get(cpfCliente);

//					Quando houver pagamento:
//					PagamentoDAO pagamentoDao = new PagamentoDAO();
//					Pagamento pagamento = pagamentoDao.get(idPagamento);

					OrcamentoBuffetCompleto orcamentoBuffetCompletoEncontrado = new OrcamentoBuffetCompleto(
							rs.getInt("numeroDeConvidados"), rs.getInt("numeroDeColaboradores"),
							rs.getString("horaDeInicio"), dataOrcamento, null, rs.getInt("id"), teraCerveja, salgados,
							doces, bolo);
					return orcamentoBuffetCompletoEncontrado;
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
	public ArrayList<OrcamentoBuffetCompleto> getAll() {
		String sql = "SELECT * FROM OrcamentoBuffetCompleto";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);

			try (ResultSet rs = statement.executeQuery()) {
				ArrayList<OrcamentoBuffetCompleto> orcamentoBuffetCompletoEncontrados = new ArrayList<OrcamentoBuffetCompleto>();
				BoloDAO boloDao = new BoloDAO();
				SalgadoSelecionadoDAO salgadoSelecionadoDao = new SalgadoSelecionadoDAO();
				DoceSelecionadoDAO doceSelecionadoDao = new DoceSelecionadoDAO();
//				ClienteDAO clienteDao = new ClienteDAO();
//				PagamentoDAO pagamentoDao = new PagamentoDAO();
				while (rs.next()) {
					String cpfCliente = rs.getString("fk_cpfCliente");
					int idBolo = rs.getInt("fk_idBolo");
					int idPagamento = rs.getInt("fk_idBolo");

					String dataString = rs.getString("data");
					int dia = Integer.parseInt(dataString.split("/")[0]);
					int mes = Integer.parseInt(dataString.split("/")[1]);
					int ano = Integer.parseInt(dataString.split("/")[2]);
					Data dataOrcamento = new Data(dia, mes, ano);

					boolean teraCerveja = rs.getInt("teraCerveja") == 1;

					ArrayList<SalgadoSelecionado> salgadosSelecionados = salgadoSelecionadoDao
							.getAllBuffet(rs.getInt("id"));
					ArrayList<Salgado> salgados = new ArrayList<Salgado>();

					for (int i = 0; i < salgadosSelecionados.size(); i++)
						salgados.add(salgadosSelecionados.get(i).getSalgado());

					ArrayList<DoceSelecionado> docesSelecionados = doceSelecionadoDao.getAllBuffet(rs.getInt("id"));
					ArrayList<Doce> doces = new ArrayList<Doce>();

					for (int i = 0; i < docesSelecionados.size(); i++)
						doces.add(docesSelecionados.get(i).getDoce());

					Bolo bolo = boloDao.get(idBolo);

//					Quando houver cliente:
//					Cliente cliente = clienteDao.get(cpfCliente);

//					Quando houver pagamento:
//					Pagamento pagamento = pagamentoDao.get(idPagamento);

					OrcamentoBuffetCompleto orcamentoBuffetCompletoEncontrado = new OrcamentoBuffetCompleto(
							rs.getInt("numeroDeConvidados"), rs.getInt("numeroDeColaboradores"),
							rs.getString("horaDeInicio"), dataOrcamento, null, rs.getInt("id"), teraCerveja, salgados,
							doces, bolo);
					orcamentoBuffetCompletoEncontrados.add(orcamentoBuffetCompletoEncontrado);
				}
				return orcamentoBuffetCompletoEncontrados;
			}
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public boolean criar(OrcamentoBuffetCompleto orcamentoBuffet) {
		String sql = "INSERT INTO OrcamentoBuffetCompleto VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			// atributos OrcamentoBuffetCompleto no banco
			// id numeroDeConvidados numeroDeColaboradores horaDeInicio data teraCerveja
			// fk_cpfCliente fk_idBolo fk_idPagamento
			int teraCervejaInt;
			if (orcamentoBuffet.getTeraCerveja()) {
				teraCervejaInt = 1;
			} else {
				teraCervejaInt = 0;
			}
			statement.setInt(1, orcamentoBuffet.getId());
			statement.setInt(2, orcamentoBuffet.getNumeroDeConvidados());
			statement.setInt(3, orcamentoBuffet.getNumeroDeColaboradores());
			statement.setString(4, orcamentoBuffet.getHoraDeInicio());
			statement.setString(5, orcamentoBuffet.getData().getData());
			statement.setInt(6, teraCervejaInt);
//			statement.setString(7, orcamentoBuffet.getCliente().getCpf());
			statement.setString(7, "");
			statement.setInt(8, orcamentoBuffet.getBolo().getId());
//			statement.setInt(9, orcamentoBuffet.getPagamento().getId());
			statement.setInt(9, -1);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("OrcamentoBuffetCompleto inserido com sucesso!");
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
	public boolean atualizar(OrcamentoBuffetCompleto orcamentoBuffet) {
		String sql = "UPDATE OrcamentoBuffetCompleto SET numeroDeConvidados = ?, numeroDeColaboradores = ?, horaDeInicio = ?, data = ?, teraCerveja = ?, fk_cpfCliente = ?, fk_idBolo = ?, fk_idPagamento = ? WHERE id = ?";

		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			// atributos OrcamentoBuffetCompleto no banco
			// id numeroDeConvidados numeroDeColaboradores horaDeInicio data teraCerveja
			// fk_cpfCliente fk_idBolo fk_idPagamento
			int teraCervejaInt;
			if (orcamentoBuffet.getTeraCerveja()) {
				teraCervejaInt = 1;
			} else {
				teraCervejaInt = 0;
			}
			statement.setInt(1, orcamentoBuffet.getNumeroDeConvidados());
			statement.setInt(2, orcamentoBuffet.getNumeroDeColaboradores());
			statement.setString(3, orcamentoBuffet.getHoraDeInicio());
			statement.setString(4, orcamentoBuffet.getData().getData());
			statement.setInt(5, teraCervejaInt);
//			statement.setString(6, orcamentoBuffet.getCliente().getCpf());
			statement.setString(6, "");
			statement.setInt(7, orcamentoBuffet.getBolo().getId());
//			statement.setInt(8, orcamentoBuffet.getPagamento().getId());
			statement.setInt(8, -1);
			statement.setInt(9, orcamentoBuffet.getId());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("OrcamentoBuffetCompleto atualizado com sucesso!");
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
		int id = objetoInteger.intValue();
		String sql = "DELETE FROM OrcamentoBuffetCompleto WHERE id = ?";
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("OrcamentoBuffetCompleto deletado com sucesso!");
			}
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

	public Boolean verificarData(Data data) {
		String dataString = data.getData();
		String sql = "SELECT * FROM OrcamentoBuffetCompleto WHERE data = ?";
		try {
			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			try (ResultSet rs = statement.executeQuery()) {
				statement.setString(1, dataString);
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
