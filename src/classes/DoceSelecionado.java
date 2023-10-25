package classes;

import java.util.ArrayList;

public class DoceSelecionado {
	private int quantidade;
	private Doce doce;
	
	public DoceSelecionado(int quantidade, Doce doce) {
		setQuantidade(quantidade);
		setDoce(doce);
	}
	
	public static ArrayList<Doce> getAllDoces() {
		DoceSelecionadoDAO DoceSelecionadoDAO = new DoceSelecionadoDAO();
		return DoceSelecionadoDAO.getAllDoces();
	}
	
	private void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	private void setDoce(Doce doce) {
		this.doce = doce;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Doce getDoce() {
		return doce;
	}
	public Double getValor() {
		Double valorDoce;
		
		valorDoce = doce.getValorUnitario() * quantidade;
		return valorDoce;
	}
	
}
