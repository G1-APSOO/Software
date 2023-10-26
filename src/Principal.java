import bancoDeDados.ClienteDAO;
import bancoDeDados.ConexaoBanco;
import classes.Cliente;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(ConexaoBanco.getConexao());
		System.out.print(ConexaoBanco.status);
		
		Cliente c = new Cliente("Pedro Paulo",  "08010842109", "Rua Gumercindo Annes", "79190000", "67999881718",  "pedroapsilva22@gmail.com", "2675842", "6799984444","256484956");
	
		ClienteDAO cDao = new ClienteDAO();
		
		cDao.criar(c);
	}

}
