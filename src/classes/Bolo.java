package classes;

import java.util.ArrayList;

import excecoes.ExcecaoValorNaoSetado;

public class Bolo extends Alimento {
	private double peso;
	
	public Bolo(int id, String descricao, double valorUnitario) {
		super(id, descricao, valorUnitario);
		setPeso(0.0);
	}

	public double getValor() throws ExcecaoValorNaoSetado {
		if (peso == 0.0) throw new ExcecaoValorNaoSetado("Bolo", "peso");
		
		return getValorUnitario() * peso;
	}
	
	public static ArrayList<Bolo> getAllBolos() {
		BoloDAO BoloDAO = new BoloDAO();
		return BoloDAO.getAll();
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public double getPeso() {
		return peso;
	}

}
