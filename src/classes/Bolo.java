package classes;

import java.util.ArrayList;

import excecoes.ExcecaoValorNaoSetado;

public class Bolo extends Alimento {
	private Double peso;
	
	public Bolo(int id, String descricao, double valorUnitario) {
		super(id, descricao, valorUnitario);
		setPeso(0.0);
	}

	public Double getValor() throws ExcecaoValorNaoSetado {
		if (peso == 0.0) throw new ExcecaoValorNaoSetado("Bolo", "peso");
		
		return getValorUnitario() * peso;
	}
	
	public static ArrayList<Bolo> getAllBolos() {
		BoloDAO BoloDAO = new BoloDAO();
		return BoloDAO.getAll();
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double getPeso() {
		return peso;
	}

}
