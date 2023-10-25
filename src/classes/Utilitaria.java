package classes;


public class Utilitaria {
	public static boolean verificarValidezDaData(Data dataDoEvento){
		OrcamentoBuffetCompletoDAO instance = new OrcamentoBuffetCompletoDAO();
		return instance.verificarData(dataDoEvento);
	}
	
	public static boolean verificarNumeroConvidados(int numeroDeConvidados) {
		
		return 50 <= numeroDeConvidados && numeroDeConvidados <= 180;
		
	}
	
	public static boolean verificarValidezDoHorario(String horaDeInicio) {
		String [] horario = horaDeInicio.split(".");
		String hora = horario[0];
		String min = horario[1];
		int horaok = Integer.valueOf(hora);
		
		return 11 <= horaok && horaok <= 20;
	}
	
	public static boolean verificarOpcoesSalgados (<ArrayList>Salgado opcoesDeSalgado){
		salgadoqtdarray = opcoesDeSalgado.size();
		
		return salgadoqtdarray 
	}
	
	public static boolean verificarOpcoesDoces (<ArrayList>Doce opcoesDeDoce){
		return 
	}

}
