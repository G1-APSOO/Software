package telas;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import controladoras.ControladoraJanela;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 7430438618817551574L;
		
	public JanelaPrincipal() {
		setSize(new Dimension(1280, 720));
		setResizable(false);
		getContentPane().setMinimumSize(new Dimension(1280, 720));
		getContentPane().setMaximumSize(new Dimension(1280, 720));
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
				
		setVisible(true);
	}

}
