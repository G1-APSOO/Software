package bancoDeDados;

import java.util.ArrayList;

public interface DAO {
	
	public <T> T get(T chavePrimaria);
	public <T> ArrayList<T> getAll();
	public <T> void criar(T objeto);
	public <T> void atualizar(T objeto);
	public <T> void deletar(T chavePrimaria);
	
}
