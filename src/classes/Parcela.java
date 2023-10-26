package classes;

public class Parcela {
	private double valorPago;
	private Data dataVencimento;
	private Data dataPagamento;
	
	public Parcela(double valorPago, Data dataVencimento, Data dataPagamento) {
		setValorPago(valorPago);
		setDataVencimento(dataVencimento);
		setDataPagamento(dataPagamento);
	}
	
	private void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	private void setDataVencimento(Data dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	private void setDataPagamento(Data dataPagamento) {
		this.dataPagamento= dataPagamento;
	}
	
	public double getValorPago() {
		return valorPago;
	}
	
	public Data getDataVencimento() {
		return dataVencimento;
	}
	
	public Data getDataPagamento() {
		return dataPagamento;
	}
}
