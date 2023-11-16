package interface_usuario;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 7430438618817551574L;
	
	private JPanel jPanelAtual;
	private PainelConfirmarOuCancelarOrcamento painelConfirmarOuCancelarOrcamento;
	private PainelCriarOuAtualizarCliente painelCriarOuAtualizarCliente;
	private PainelEscolhaDeOrcamento painelEscolhaDeOrcamento;
	private PainelInicialOrcamento painelInicialOrcamento;
	private PainelOpcoesOrcamentoDeBuffetCompleto painelOpcoesOrcamentoDeBuffetCompleto;
	private PainelOrganizadorOrcamentoDeBuffetCompleto painelOrganizadorOrcamentoDeBuffetCompleto;
	
	public JanelaPrincipal() {
		setSize(new Dimension(1280, 720));
		setResizable(false);
		getContentPane().setMinimumSize(new Dimension(1280, 720));
		getContentPane().setMaximumSize(new Dimension(1280, 720));
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		//painelInicialOrcamento = new PainelInicialOrcamentoDeBuffetCompleto();
		
		setVisible(true);
	}

	public void trocaPainel(JPanel painel) {
		if (jPanelAtual != null) getContentPane().remove(jPanelAtual);
		
		getContentPane().add(painel, BorderLayout.CENTER);
		getContentPane().repaint();
		
		jPanelAtual = painel;
		setVisible(true);
	}
	
}
