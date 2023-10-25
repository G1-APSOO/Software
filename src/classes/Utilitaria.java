package classes;

import java.util.ArrayList;

public class Utilitaria {
	
	private static final OrcamentoBuffetCompletoDAO OrcBuffetCompletoDAO = new OrcamentoBuffetCompletoDAO();
	
	private Utilitaria() {
		throw new IllegalAccessError();
	}
	
	public static boolean verificarValidezDaData(Data dataDoEvento){
		return OrcBuffetCompletoDAO.verificarData(dataDoEvento);
	}
	
	public static boolean verificarNumeroConvidados(int numeroDeConvidados) {
		return 50 <= numeroDeConvidados && numeroDeConvidados <= 180;
	}
	
	public static boolean verificarValidezDoHorario(String horaDeInicio) {
		String[] horario = horaDeInicio.split(":");
		
		int horaOk = Integer.parseInt(horario[0]);
		
		return (11 <= horaOk && horaOk <= 20);
	}
	
	public static boolean verificarOpcoesSalgados (int qtdDeSalgados) {
		return qtdDeSalgados >= 7;
	}
	
	public static boolean verificarOpcoesDoces (int qtdDeDoces){
		return qtdDeDoces == 3;
	}

}
