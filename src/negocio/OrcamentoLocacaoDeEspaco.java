package negocio;

import java.util.ArrayList;

public class OrcamentoLocacaoDeEspaco extends OrcamentoEvento {
	private ArrayList<ServicoContratado> arrayServicosContratados = new ArrayList<>();
	
	public OrcamentoLocacaoDeEspaco(int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento, Cliente cliente, ArrayList<ServicoContratado> arrayServicosContratados) {
		super(-1, numeroDeConvidados, horaDeInicio, data, pagamento, cliente);
		setArrayServicosContratados(arrayServicosContratados);
	}
	
	public OrcamentoLocacaoDeEspaco(int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data, Pagamento pagamento, Cliente cliente, ArrayList<ServicoContratado> arrayServicosContratados) {
		super(-1, numeroDeConvidados, numeroDeColaboradores, horaDeInicio, data, pagamento, cliente);
		setArrayServicosContratados(arrayServicosContratados);
	}
	
	private void setArrayServicosContratados(ArrayList<ServicoContratado> arrayServicosContratados) {
		this.arrayServicosContratados.clear();
		this.arrayServicosContratados.addAll(arrayServicosContratados);
	}

	public ArrayList<ServicoContratado> getArrayServicosContratados() {
		return arrayServicosContratados;
	}
	@Override
	public double calcularValorTotal() {
		double valorTotal = 0.0;
		
		//TODO calcular para o orcamento de locacao de espaco
		
		return valorTotal;
	}
}
