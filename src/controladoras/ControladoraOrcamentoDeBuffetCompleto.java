package controladoras;

import classes.Cliente;
import classes.Salgado;
import classes.Doce;
import classes.OrcamentoBuffetCompleto;
import classes.Data;

import java.util.ArrayList;
import java.util.Random;

import classes.Bolo;

public class ControladoraOrcamentoDeBuffetCompleto {
	
	// necessario aprimorar para verificar se id ja foi utilizado
	public int criaId() {
		Random rand = new Random();
		return rand.nextInt(2147483646);
	}
	
	public double consultarValorDoOrcamento(OrcamentoBuffetCompleto orcamento) {
		return orcamento.calcularValorTotal();
	}

	public OrcamentoBuffetCompleto criarOrcamento(int numeroDeConvidados, int numeroDeColaboradores, Data dataDoEvento,
			Cliente cliente, String horaDeInicio, boolean teraCerveja, ArrayList<Salgado> opcoesDeSalgado,
			ArrayList<Doce> opcoesDeDoces, Bolo opcaoDeBolo) {
		// necessario incluir Pagamento nos parametros
			OrcamentoBuffetCompleto orcamentoBuffetCompleto = new OrcamentoBuffetCompleto(numeroDeConvidados, numeroDeColaboradores, horaDeInicio, dataDoEvento, null, cliente, -1, teraCerveja, opcoesDeSalgado, opcoesDeDoces, opcaoDeBolo);
			return orcamentoBuffetCompleto;
	}
	
	public void cadastrarOrcamento(OrcamentoBuffetCompleto orcamentoBuffetCompleto) {
		//OrcamentoBuffetCompleto.cadastrarOrcamento(orcamentoBuffetCompleto);
	}

	public boolean verificarNumeroDeConvidados(int numeroDeConvidados) {
		return numeroDeConvidados >= 50 && numeroDeConvidados <= 180;
	}

	public boolean verificarData(Data data) {
		return OrcamentoBuffetCompleto.verificarData(data);
	}

	public boolean verificarValidezHorario(String horaDeInicio) {
		return false;
	}

	public boolean verificarOpcoesSalgados(ArrayList<Salgado> opcoesDeSalgado) {
		return false;
	}

	public boolean verificarOpcoesDoces(ArrayList<Doce> opcoesDeDoces) {
		return false;
	}

	public void cancelarOrcamento() {
	
	}

	public ArrayList<Salgado> getAllSalgados() {
		return OrcamentoBuffetCompleto.getAllSalgados();
	}

	public ArrayList<Doce> getAllDoces() {
		return OrcamentoBuffetCompleto.getAllDoces();
	}

	public ArrayList<Bolo> getAllBolos() {
		return OrcamentoBuffetCompleto.getAllBolos();
	}
}
