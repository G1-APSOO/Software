package controladoras;

import javax.swing.JPanel;

import classes.Usuario;
import telas.JanelaPrincipal;
import telas.Painel;
import telas.PainelEscolhaDeOrcamento;

public class ControladoraJanela {
	private static Usuario usuario = null;
	private static Painel painelInicial = new PainelEscolhaDeOrcamento(); // Atualmente o inicio é em EscolhaOrcamento
	private static JanelaPrincipal janela = new JanelaPrincipal();
	
	private ControladoraJanela() {} // Controladora vazia, pois é uma classe estatica
	
	public static void trocaPainel(JPanel painel) {
		janela.setContentPane(painel);
	}
	
	public static void voltarPainelInicial() {
		janela.setContentPane(painelInicial.getPainel());
	}
	
	public static void setUsuario(Usuario novoUsuario) {
		if (usuario != null)
			throw new IllegalAccessError("Acesso negado: Usuário já definido");
		
		usuario = novoUsuario;
	}
	
}
