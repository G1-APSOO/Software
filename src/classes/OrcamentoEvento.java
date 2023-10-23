package classes;

public class OrcamentoEvento {
	private Data data;
	private int id;
	private int numeroDeConvidados;
	private int numeroDeColaboradores;
	private String horaDeInicio;
	
	public OrcamentoEvento(Data data, int id, int numeroDeConvidados, String horaDeInicio) {
		setData(data);
		setId(id);
		setNumeroDeConvidados(numeroDeConvidados);
		setHoraDeInicio(horaDeInicio);
	}
	
	public OrcamentoEvento(Data data, int id, int numeroDeConvidados, int numeroDeColaboradores, String horaDeInicio) {
		setData(data);
		setId(id);
		setNumeroDeConvidados(numeroDeConvidados);
		setNumeroDeColaboradores(numeroDeColaboradores);
		setHoraDeInicio(horaDeInicio);
	}
	
	private void setData(Data data) {
		this.data = data;
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
	
	public Data getData() {
		return data;
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
}
