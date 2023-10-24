package classes;

import java.util.ArrayList;

public class Pagamento {
	private Double valorTotal;
	private String formaDePagamento;
	private ArrayList<Parcela> parcelas = new ArrayList<>();
	
	public Pagamento(Double valorTotal, String formaDePagamento, int quantidadeDeParcelas) {
		setValorTotal(valorTotal);
		setFormaDePagamento(formaDePagamento);
		criaParcelas(quantidadeDeParcelas);
	}
	
	private void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	private void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	
	private void criaParcelas(int quantidadeDeParcelas) {
		// TODO Fazer um for para criar parcelas equivalentes a quantidadeDeParcelas
		// TODO As datas de vencimento são olhando o dia atual e colocando ele nos proximos meses
		//* Cuidados: Se o dia em questão existe no mes seguinte, e se o mes seguinte existe, exemplo:
		// 	Estamos em dezembro o "proximo" seria mes 13, mas não existe mes 13, ent voltar para janeiro
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public ArrayList<Parcela> getParcelas() {
		return parcelas;
	}
}
