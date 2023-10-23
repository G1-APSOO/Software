package classes;

public class OrcamentoLocacaoDeEspaco extends OrcamentoEvento {
	
	public OrcamentoLocacaoDeEspaco(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio) {
		super(numeroDeConvidados, numeroDeColaboradores, horaDeInicio);
	}
	
	public OrcamentoLocacaoDeEspaco(int numeroDeConvidados, String horaDeInicio) {
		super(numeroDeConvidados, horaDeInicio);
	}
}
