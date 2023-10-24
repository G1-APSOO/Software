package classes;


public class Utilitaria {
	public boolean verificarValidezDaData(Data dataDoEvento){
		OrcamentoBuffetCompletoDAO instance = new OrcamentoBuffetCompletoDAO();
		return instance.verificarData(dataDoEvento);
	}
	
	

}
