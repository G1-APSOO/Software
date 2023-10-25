package classes;

public class ServicoAdicional {
	private int id;
	private String descricao;
	private Double valor;
	
	public ServicoAdicional(int id, String descricao, Double valor) {
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
	
	private void setValor(Double valor) {
		this.valor = valor;
	}
	
	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getValor() {
		return valor;
	}
}
