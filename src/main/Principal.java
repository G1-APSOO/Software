package main;

import controladoras.ControladoraJanela;
import interface_usuario.Painel;
import interface_usuario.PopUpErroGenerico;
import persistencia.ConexaoBanco;

public class Principal {

	public static void main(String[] args) {
		
//		System.out.println("Bem vindo, testando conexão!");
		ConexaoBanco.getConexao();
//		System.out.println(ConexaoBanco.statusConection());
		
		ControladoraJanela.voltarPainelInicial();
		
	}

}
