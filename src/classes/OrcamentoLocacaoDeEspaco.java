package classes;

import java.util.ArrayList;

public class OrcamentoLocacaoDeEspaco extends OrcamentoEvento {
	private ArrayList<ServicoContratado> arrayServicosContratados = new ArrayList<>();
	
	public OrcamentoLocacaoDeEspaco(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento, ArrayList<ServicoContratado> arrayServicosContratados) {
		super(-1, numeroDeConvidados, horaDeInicio, data, pagamento);
		setArrayServicosContratados(arrayServicosContratados);
	}
	
	public OrcamentoLocacaoDeEspaco(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data, Pagamento pagamento, ArrayList<ServicoContratado> arrayServicosContratados) {
		super(-1, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento);
		setArrayServicosContratados(arrayServicosContratados);
	}
	
	private void setArrayServicosContratados(ArrayList<ServicoContratado> arrayServicosContratados) {
		this.arrayServicosContratados.clear();
		this.arrayServicosContratados.addAll(arrayServicosContratados);
	}

	public ArrayList<ServicoContratado> getArrayServicosContratados() {
		return arrayServicosContratados;
	}
}
