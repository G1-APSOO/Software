package persistencia;

import java.util.ArrayList;
import negocio.ServicoContratado;

public class ServicoContratadoDAO implements DAO<ServicoContratado, String>{

	@Override
	public ServicoContratado get(String chavePrimaria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existeEssaChavePrimaria(String chavePrimaria) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<ServicoContratado> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean criar(ServicoContratado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(ServicoContratado objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletar(String chavePrimaria) {
		// TODO Auto-generated method stub
		return false;
	}

}
