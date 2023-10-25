package classes;

import java.util.ArrayList;

public class Bolo extends Alimento {
	private Double peso;
	
	public Bolo(int id, String descricao, double valorUnitario) {
		super(id, descricao, valorUnitario);
	}

	public Double getValor() {
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
