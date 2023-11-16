package controladoras;

import javax.swing.JPanel;

import interface_usuario.JanelaPrincipal;
import interface_usuario.Painel;
import interface_usuario.PainelEscolhaDeOrcamento;
import interface_usuario.PopUpErroGenerico;

public class ControladoraJanela {
	private static Painel painelInicial = new PainelEscolhaDeOrcamento(); // Atualmente o inicio é em EscolhaOrcamento
	private static JanelaPrincipal janela = new JanelaPrincipal();
	
	private ControladoraJanela() {} // Controladora vazia, pois é uma classe estatica
	
	public static void trocaPainel(JPanel painel) {
		janela.trocaPainel(painel);
		
	}
	
	public static void voltarPainelInicial() {
		janela.trocaPainel(painelInicial.getPainel());

	}
	
	public static void ativarPopUp(Painel painelDeRetorno, String mensagemPrincipal, String mensagemInstrucao, String mensagemDoBotao) {
		PopUpErroGenerico popUp = new PopUpErroGenerico(painelDeRetorno, mensagemPrincipal, mensagemInstrucao, mensagemDoBotao);
		trocaPainel(popUp.getPainel());
	}
	
}
