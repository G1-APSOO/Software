package excecoes;

public class ExcecaoParametroPreenchidoErrado extends RuntimeException {
	
	
	public ExcecaoParametroPreenchidoErrado(String msg){
		super("O atributo "+ msg + " está preenchido incorretamente.");
	}
}
