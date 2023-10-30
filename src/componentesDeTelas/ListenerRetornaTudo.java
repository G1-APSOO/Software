package componentesDeTelas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controladoras.ControladoraJanela;
import telas.Painel;

public class ListenerRetornaTudo implements MouseListener {

	private Painel painelAtual;
	
	public ListenerRetornaTudo(Painel painel) {
		this.painelAtual = painel;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		painelAtual.limparCampos();
		ControladoraJanela.voltarPainelInicial();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {/* Não faz nada */}
	@Override
	public void mouseReleased(MouseEvent e) { /* Não faz nada */ }
	
	@Override
	public void mouseExited(MouseEvent e) { /* Não faz nada */ }
	
	@Override
	public void mouseEntered(MouseEvent e) { /* Não faz nada */ }
	
}
