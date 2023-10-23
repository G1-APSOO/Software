package Classes;

public class DoceSelecionado {
	private int quantidade;
	private Doce doce;
	
	public DoceSelecionado(int quantidade, Doce doce) {
		setQuantidade(quantidade);
		this.doce = doce;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Double getValor() {
		Double valorDoce;
		
		valorDoce = doce.getValorUnitario() * quantidade;
		return valorDoce;
	}
	
}
