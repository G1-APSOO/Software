package classes;

import java.util.ArrayList;

import bancoDeDados.SalgadoSelecionadoDAO;

public class SalgadoSelecionado {
	private int quantidade;
	private Salgado salgado;

	public SalgadoSelecionado(int quantidade, Salgado salgado) {
		setQuantidade(quantidade);
		setSalgado(salgado);
	}

	public static ArrayList<Salgado> getAllSalgados() {
		SalgadoSelecionadoDAO SalgadoSelecionadoDAO = new SalgadoSelecionadoDAO();
		return SalgadoSelecionadoDAO.getAll();
	}

	private void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	private void setSalgado(Salgado salgado) {
		this.salgado = salgado;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Salgado getSalgado() {
		return salgado;
	}

	public double getValor() {
		return salgado.getValorUnitario() * quantidade;
	}

}
