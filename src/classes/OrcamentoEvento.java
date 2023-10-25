package classes;

public class OrcamentoEvento {
	private int id;
	private int numeroDeConvidados;
	private int numeroDeColaboradores;
	private String horaDeInicio;
	private Data data;
	private Pagamento pagamento;
	
	public OrcamentoEvento(int id, int numeroDeConvidados, String horaDeInicio, Data data, Pagamento pagamento) {
		setId(id);
		setNumeroDeConvidados(numeroDeConvidados);
		setHoraDeInicio(horaDeInicio);
		setData(data);
		setPagamento(pagamento);
	}
	
	public OrcamentoEvento(int id, int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio, Data data, Pagamento pagamento) {
		setId(id);
		setNumeroDeConvidados(numeroDeConvidados);
		setNumeroDeColaboradores(numeroDeColaboradores);
		setHoraDeInicio(horaDeInicio);
		setData(data);
		setPagamento(pagamento);
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	private void setNumeroDeConvidados(int numeroDeConvidados) {
		this.numeroDeConvidados = numeroDeConvidados;
	}
	
	private void setHoraDeInicio(String horaDeInicio) {
		this.horaDeInicio = horaDeInicio;
	}
	
	protected void setNumeroDeColaboradores(int numeroDeColaboradores) {
		this.numeroDeColaboradores = numeroDeColaboradores;
	}
	
	private void setData(Data data) {
		this.data = data;
	}
	
	private void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public int getId() {
		return id;
	}
	
	public int getNumeroDeConvidados() {
		return numeroDeConvidados;
	}
	
	public int getNumeroDeColaboradores() {
		return numeroDeColaboradores;
	}
	
	public String getHoraDeInicio() {
		return horaDeInicio;
	}
	
	public Data getData() {
		return data;
	}
	
	public Pagamento getPagamento() {
		return pagamento;
	}
}
