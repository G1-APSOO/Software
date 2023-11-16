package controladoras;

import excecoes.ExcecaoDDDInvalido;
import excecoes.ExcecaoDiaInvalido;
import excecoes.ExcecaoMesInvalido;
import negocio.Bolo;
import negocio.Cliente;
import negocio.Data;
import negocio.Doce;
import negocio.OrcamentoBuffetCompleto;
import negocio.Salgado;
import utilitaria.Utilitaria;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControladoraOrcamentoDeBuffetCompleto {

	private ControladoraOrcamentoDeBuffetCompleto() {
		throw new IllegalAccessError("Controladora Orcamento de BuffetCompleto é estática");
	} 

	public static double consultarValorDoOrcamento(OrcamentoBuffetCompleto orcamento) {
		return orcamento.calcularValorTotal();
	}

	public static void cadastrarOrcamento(OrcamentoBuffetCompleto orcamentoBuffetCompleto) {
		 orcamentoBuffetCompleto.cadastrarOrcamento();
	}

	public static OrcamentoBuffetCompleto criarOrcamento(int numeroDeConvidados, int numeroDeColaboradores, Data dataDoEvento,
			Cliente cliente, String horaDeInicio, boolean teraCerveja, ArrayList<Salgado> opcoesDeSalgado,
			ArrayList<Doce> opcoesDeDoces, Bolo opcaoDeBolo) {
		// necessario incluir Pagamento nos parametros
		return new OrcamentoBuffetCompleto(numeroDeConvidados, numeroDeColaboradores, horaDeInicio, dataDoEvento, null,
				cliente, -1, teraCerveja, opcoesDeSalgado, opcoesDeDoces, opcaoDeBolo);
	}

	public static boolean verificarNumeroDeConvidados(int numeroDeConvidados) {
		return Utilitaria.verificarNumeroConvidados(numeroDeConvidados);
	}

	public static boolean verificarData(String dataString) {
		
		String[] aux = dataString.split("/");
		
		int dia = Integer.parseInt(aux[0]);
		int mes = Integer.parseInt(aux[1]);
		int ano = Integer.parseInt(aux[2]);
		
		Data data = null;
		
		try {
			data = new Data(dia, mes, ano);
			
		} catch (ExcecaoDiaInvalido e) {
			JOptionPane.showMessageDialog(null, "Dia inválido"); // TODO Chamar PopUp
			return false;
		} catch (ExcecaoMesInvalido e) {
			JOptionPane.showMessageDialog(null, "Mes inválido"); // TODO Chamar PopUp
			return false;
		}
		
		return OrcamentoBuffetCompleto.verificarData(data);
	}

	public static boolean verificarValidezHorario(String horaDeInicio) {
		return Utilitaria.verificarValidezHorario(horaDeInicio);
	}
	
	public static boolean verificarNomeCompleto(String nome) {
		return Utilitaria.verificarNome(nome);
	}
	
	public static boolean verificarCPF(String cpf) {
		return Utilitaria.verificarCPF(cpf);
	}
	
	public static boolean verificarEmail(String email) {
		return Utilitaria.verificarEmail(email);
	}
	
	public static boolean verificarCEP(String cep) {
		return Utilitaria.verificarCEP(cep);
	}
	
	public static boolean verificarCelular(String celular) throws ExcecaoDDDInvalido {
		return Utilitaria.verificarCelular(celular);
	}

	public static boolean verificarOpcoesSalgados(int qtdSalgados) {
		return Utilitaria.verificarOpcoesSalgados(qtdSalgados);
	}

	public static boolean verificarOpcoesDoces(int qtdDoces) {
		return Utilitaria.verificarOpcoesDoces(qtdDoces);
	}

	public void cancelarOrcamento(OrcamentoBuffetCompleto orcamentoBuffet) {
		OrcamentoBuffetCompleto.deletarOrcamento(orcamentoBuffet);
	}

	public static ArrayList<Salgado> getAllSalgados() {
		return OrcamentoBuffetCompleto.getAllSalgados();
	}

	public static ArrayList<Doce> getAllDoces() {
		return OrcamentoBuffetCompleto.getAllDoces();
	}

	public static ArrayList<Bolo> getAllBolos() {
		return OrcamentoBuffetCompleto.getAllBolos();
	}
}
