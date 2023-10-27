import bancoDeDados.ConexaoBanco;
import classes.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(ConexaoBanco.getConexao());
		System.out.print(ConexaoBanco.status);
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario u = new Usuario("pedro","senha1234","Pedro Paulo","admin");
		
		dao.get
	}

}
