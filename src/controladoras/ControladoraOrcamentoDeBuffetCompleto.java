package controladoras;

import classes.Cliente;
import classes.Salgado;
import classes.Doce;
import classes.OrcamentoBuffetCompleto;
import classes.Pagamento;
import classes.Data;

import java.util.ArrayList;
import java.util.Random;

import bancoDeDados.OrcamentoBuffetCompletoDAO;
import classes.Bolo;

public class ControladoraOrcamentoDeBuffetCompleto {

	public double consultarValorDoOrcamento(OrcamentoBuffetCompleto orcamento) {
		return orcamento.calcularValorTotal();
	}

	public void cadastrarOrcamento(OrcamentoBuffetCompleto orcamentoBuffetCompleto) {
		 OrcamentoBuffetCompleto.cadastrarOrcamento(orcamentoBuffetCompleto);
	}

	public OrcamentoBuffetCompleto criarOrcamento(int numeroDeConvidados, int numeroDeColaboradores, Data dataDoEvento,
			Cliente cliente, String horaDeInicio, boolean teraCerveja, ArrayList<Salgado> opcoesDeSalgado,
			ArrayList<Doce> opcoesDeDoces, Bolo opcaoDeBolo) {
		// necessario incluir Pagamento nos parametros
		return new OrcamentoBuffetCompleto(numeroDeConvidados, numeroDeColaboradores, horaDeInicio, dataDoEvento, null,
				cliente, -1, teraCerveja, opcoesDeSalgado, opcoesDeDoces, opcaoDeBolo);
	}

	public int verificarNumeroDeConvidados(int numeroDeConvidados) {
		return -1;
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

	public void cancelarOrcamento(OrcamentoBuffetCompleto orcamentoBuffet) {
		OrcamentoBuffetCompleto.deletarOrcamento(orcamentoBuffet);
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
