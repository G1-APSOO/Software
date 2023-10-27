package telas;

import java.awt.Color;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public abstract class Painel {
	
	private Color corDeFundo;
	private Color corJanelaInterna;
	private Color corTitulo;
	private Color corTexto;
	private Color corInputs;
	
	private ImageIcon iconeRetornaTudo;
	private ImageIcon iconeProximaPagina;
	private ImageIcon iconeVoltarPagina;
	
	protected Painel() {
		setCores();
		iconeRetornaTudo = new ImageIcon("imgs/retornaTudo.png");
		iconeProximaPagina = new ImageIcon("imgs/proximaPagina.png");
		iconeVoltarPagina = new ImageIcon("imgs/voltarPagina.png");
	}
	
	public abstract JPanel getPainel();
	public abstract void limparCampos();
	
	private void setCores() {
		Path pathfile = Path.of("config.txt");
		Properties properties = new Properties();
		
		try {
			String aux;
			String[] auxArray;
			int[] auxInt = new int[3];
			
			properties.load(Files.newBufferedReader(pathfile));
			
			aux = properties.getProperty("COR_DE_FUNDO");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corDeFundo = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
			aux = properties.getProperty("COR_DE_FUNDO_JANELA_INTERNA");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corJanelaInterna = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
			aux = properties.getProperty("COR_LETRA_TITULO");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corTitulo = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
			aux = properties.getProperty("COR_LETRA_JANELA_INTERNA");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corTexto = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
			aux = properties.getProperty("COR_LETRA_INPUTS");
			auxArray = aux.split(",");
			for (int i = 0; i < auxArray.length; i++) auxInt[i] = Integer.valueOf(auxArray[i]);
			corInputs = new Color(auxInt[0], auxInt[1], auxInt[2]);
			
		} catch (Exception e) {
			System.out.println("Erro: Ao tentar abrir o arquivo configs.txt");
		} 
		//Abaixo começa debug, retirar trecho de codigo na versao final
		corDeFundo = new Color(100, 183, 206);
		corTexto = new Color(240,240,240);
		corTitulo = new Color(34,45,48);
		corJanelaInterna = new Color(25,25,25);
		corInputs = new Color(0,0,0);
		// Fim debug
	}
	
	protected ImageIcon getIconeRetornaTudo() {
		return iconeRetornaTudo;
	}
	
	protected ImageIcon getIconeProximaPagina() {
		return iconeProximaPagina;
	}
	
	protected ImageIcon getIconeVoltarPagina() {
		return iconeVoltarPagina;
	}
	
	protected Color getCorDeFundo() {
		return corDeFundo;
	}
	
	protected Color getCorDeJanelaInterna() {
		return corJanelaInterna;
	}
	
	protected Color getCorTitulo() {
		return corTitulo;
	}
	
	protected Color getCorTexto() {
		return corTexto;
	}
	
	protected Color getCorInputs() {
		return corInputs;
	}
}
