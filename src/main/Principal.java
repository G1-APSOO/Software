package main;

import bancoDeDados.ConexaoBanco;
import componentesDeTelas.PopUpErroGenerico;
import controladoras.ControladoraJanela;
import telas.Painel;

public class Principal {

	public static void main(String[] args) {
		
//		System.out.println("Bem vindo, testando conexão!");
		ConexaoBanco.getConexao();
//		System.out.println(ConexaoBanco.statusConection());
		
		ControladoraJanela.voltarPainelInicial();
		
	}

}
