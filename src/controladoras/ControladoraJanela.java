package controladoras;

import javax.swing.JPanel;

import telas.JanelaPrincipal;
import telas.Painel;
import telas.PainelEscolhaDeOrcamento;

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
	
}
