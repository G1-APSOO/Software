package classes;

public class ServicoContratado {
	
	private int quantidade;
	private ServicoAdicional servicoAdicional;
	
	public ServicoContratado(int quantidade, ServicoAdicional servicoAdicional) {
		setQuantidade(quantidade);
		this.servicoAdicional = servicoAdicional;
	}
	
	private void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}
}
