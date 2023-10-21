package Classes;

public class Bolo extends Alimento {
	private Double peso;
	
	public Bolo(Double peso, int id, String descricao, double valorUnitario) {
		super(id, descricao, valorUnitario);
		setPeso(peso);
	}

	private void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public Double getValor(int id) {
		Double valorBolo;
		
		valorBolo = getValorUnitario() * peso;
		return valorBolo;
	}
	
}
