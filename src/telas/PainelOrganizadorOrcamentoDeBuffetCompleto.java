package telas;

import java.util.ArrayList;

import javax.swing.JPanel;
import classes.Salgado;
import classes.Doce;
import classes.Bolo;
import classes.OrcamentoBuffetCompleto;
import controladoras.ControladoraJanela;
import controladoras.ControladoraOrcamentoDeBuffetCompleto;

public class PainelOrganizadorOrcamentoDeBuffetCompleto extends Painel {

	private int etapaOrcamento;

	private Painel painelAtual;
	
	private PainelInicialOrcamentoDeBuffetCompleto  painelEtapa1;
	private PainelOpcoesOrcamentoDeBuffetCompleto   painelEtapa2;
	private PainelCriarOuAtualizarCliente 			painelEtapa3;
	private PainelConfirmarOuCancelarOrcamento      painelEtapa4;
	
	private ControladoraOrcamentoDeBuffetCompleto controladoraOrcamentoBuffetCompleto;
		
	public PainelOrganizadorOrcamentoDeBuffetCompleto() {
		controladoraOrcamentoBuffetCompleto = new ControladoraOrcamentoDeBuffetCompleto();
		
		// Sem o servidor não funciona
//		ArrayList<Salgado> salgados = controladoraOrcamentoBuffetCompleto.getAllSalgados();
//		ArrayList<Doce> doces = controladoraOrcamentoBuffetCompleto.getAllDoces();
//		ArrayList<Bolo> bolos = controladoraOrcamentoBuffetCompleto.getAllBolos();
		
		//! Debug
		ArrayList<Salgado> salgados = new ArrayList<>();
		ArrayList<Doce> doces = new ArrayList<>();
		ArrayList<Bolo> bolos = new ArrayList<>();
		//! Fim Debug
		
		painelEtapa1 = new PainelInicialOrcamentoDeBuffetCompleto(this);
		painelEtapa2 = new PainelOpcoesOrcamentoDeBuffetCompleto(this, salgados, doces, bolos);
		painelEtapa3 = new PainelCriarOuAtualizarCliente(this);
		painelEtapa4 = new PainelConfirmarOuCancelarOrcamento(this);

		etapaOrcamento = 1;
		painelAtual = painelEtapa1;
	}
	
	// Antes de chamar essas funções as classes tem que fazer verificações locais para ver se podem chamar
	public void proximaPagina() {
		if (etapaOrcamento == 1) {
			ControladoraJanela.trocaPainel(painelEtapa2.getPainel());
			
		} else if (etapaOrcamento == 2) {
			ControladoraJanela.trocaPainel(painelEtapa3.getPainel());
			
		} else if (etapaOrcamento == 3) {
			OrcamentoBuffetCompleto orcamento = null;

			// TODO Pegar as infos e passar na linha abaixo, (além de tirar o comentario)
			// orcamento = controladoraOrcamentoBuffetCompleto.criarOrcamento(numeroDeConvidados, numeroDeColaboradores, dataDoEvento, cliente, horaDeInicio, teraCerveja, opcoesDeSalgado, opcoesDeDoces, opcaoDeBolo)
			
			painelEtapa4.setOrcamento(orcamento);
			ControladoraJanela.trocaPainel(painelEtapa4.getPainel());
			
		} else {
			throw new IllegalAccessError("Erro: Etapa orçamento não tem etapa: " + etapaOrcamento);
		}
		
		etapaOrcamento += 1;
		
	}
	
	// Antes de chamar esse metodo as classes tem que fazer verificações locais para ver se podem chamar
	public void paginaAnterior() {
		if (etapaOrcamento == 2) {
			ControladoraJanela.trocaPainel(painelEtapa1.getPainel());
			
		} else if (etapaOrcamento == 3) {
			ControladoraJanela.trocaPainel(painelEtapa2.getPainel());
			
		} else if (etapaOrcamento == 4) {
			painelEtapa4.setOrcamento(null);
			
			ControladoraJanela.trocaPainel(painelEtapa3.getPainel());
			
		} else if (etapaOrcamento == 5) {
			controladoraOrcamentoBuffetCompleto.cadastrarOrcamento((OrcamentoBuffetCompleto) painelEtapa4.getOrcamento());
			
			limparCampos();
			ControladoraJanela.voltarPainelInicial();
			
		} else {
			throw new IllegalAccessError("Erro: Etapa orçamento não tem etapa: " + etapaOrcamento);			
		}
		
		etapaOrcamento -= 1;
	}
	
	@Override
	public JPanel getPainel() {
		return painelAtual.getPainel();
	}

	@Override
	public void limparCampos() {
		painelEtapa1.limparCampos();
		painelEtapa2.limparCampos();
		painelEtapa3.limparCampos();
		painelEtapa4.limparCampos();
		
	}

	@Override
	protected void configurarBotoes() {
		// Este painel somente gerencia outros paineis, não tendo um JPanel próprio
		
	}

}
