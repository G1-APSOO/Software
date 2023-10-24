package classes;


public class Utilitaria {
	public static boolean verificarValidezDaData(Data dataDoEvento){
		OrcamentoBuffetCompletoDAO instance = new OrcamentoBuffetCompletoDAO();
		return instance.verificarData(dataDoEvento);
	}
	
	public static boolean verificarNumeroConvidados(int numeroDeConvidados) {
		
		return 50 <= numeroDeConvidados && numeroDeConvidados <= 180;
		
	}

}
