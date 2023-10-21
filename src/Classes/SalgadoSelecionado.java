package Classes;

public class SalgadoSelecionado {
	private int quantidade;
	private Doce doce;
	
	public SalgadoSelecionado(int quantidade, Doce doce) {
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
		Double valorSalgado;
		
		valorSalgado = doce.getValorUnitario() * quantidade;
		return valorSalgado;
	}
}
