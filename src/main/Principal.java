package main;
import bancoDeDados.ConexaoBanco;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Bem vindo, testando conexão!");
		ConexaoBanco.getConexao();
		System.out.println(ConexaoBanco.statusConection());
	}

}
