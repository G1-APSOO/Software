package main;

import controladoras.ControladoraJanela;
import telas.Painel;
import telas.PopUpErroGenerico;

public class Principal {

	public static void main(String[] args) {
		
//		System.out.println("Bem vindo, testando conexão!");
//		ConexaoBanco.getConexao();
//		System.out.println(ConexaoBanco.statusConection());
		ControladoraJanela.voltarPainelInicial();
		PopUpErroGenerico popup = new PopUpErroGenerico(null, "Hora de inicio do evento não está preenchida", "Para continuar, preencha o campo hora de inicio do evento","Preencher Hora de Inicio");
		ControladoraJanela.trocaPainel(popup.getPainel());

		
	}

}
