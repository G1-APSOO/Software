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
	
	public PainelOrganizadorOrcamentoDeBuffetCompleto() {
		// Sem o servidor não funciona
		ArrayList<Salgado> salgados = ControladoraOrcamentoDeBuffetCompleto.getAllSalgados();
		ArrayList<Doce> doces = ControladoraOrcamentoDeBuffetCompleto.getAllDoces();
		ArrayList<Bolo> bolos = ControladoraOrcamentoDeBuffetCompleto.getAllBolos();
		
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

			try {
				orcamento = ControladoraOrcamentoDeBuffetCompleto.criarOrcamento(painelEtapa1.getInputNumeroDeConvidados(), painelEtapa1.getInputNumeroDeColaboradores(), painelEtapa1.getData(), painelEtapa3.getCliente(), painelEtapa1.getInputHoraDeInicio(), painelEtapa2.getTeraCerveja(), painelEtapa2.getSalgadosEscolhidos(), painelEtapa2.getDocesEscolhidos(), painelEtapa2.getBoloEscolhido());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
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
			ControladoraOrcamentoDeBuffetCompleto.cadastrarOrcamento((OrcamentoBuffetCompleto) painelEtapa4.getOrcamento());
			
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
		etapaOrcamento = 1;
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
