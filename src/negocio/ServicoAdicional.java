package negocio;

public class ServicoAdicional {
	private int id;
	private String descricao;
	private double valor;
	
	public ServicoAdicional(int id, String descricao, double valor) {
		setId(id);
		setDescricao(descricao);
		setValor(valor);
	}
	
	private void setId(int id) {
		this.id = id;
	}

	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	private void setValor(double valor) {
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getValor() {
		return valor;
	}
}
