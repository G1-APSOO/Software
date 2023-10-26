package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import classes.Doce;
import classes.OrcamentoBuffetCompleto;
import excecoes.ExcecaoValorNaoSetado;

public class OrcamentoBuffetCompletoDAO implements DAO<OrcamentoBuffetCompleto, Integer>{

	@Override
	public OrcamentoBuffetCompleto get(Integer objetoInteger) {
		int id = objetoInteger.intValue();
		String sql = "SELECT * FROM OrcamentoBuffetCompleto WHERE id = ?";

		try {

			PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement(sql);
			statement.setInt(1, id);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					int idCliente = rs.getInt("fk_cpfCliente");
					int idBolo = rs.getInt("fk_idBolo");
					int idPagamento = rs.getInt("fk_idBolo");
					// atributos OrcamentoBuffetCompleto no banco
					// id numeroDeConvidados numeroDeColaboradores horaDeInicio data teraCerveja fk_cpfCliente fk_idBolo fk_idBolo
					OrcamentoBuffetCompleto orcamentoBuffetCompletoEncontrado = null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean criar(OrcamentoBuffetCompleto objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(OrcamentoBuffetCompleto objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(Integer chavePrimaria) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
