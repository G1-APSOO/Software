package classes;

import excecoes.ExcecaoDDDInvalido;
import excecoes.ExcecaoNaoPreenchido;
import excecoes.ExcecaoParametroPreenchidoErrado;
import excecoes.ExcecaoSomenteLetras;
import excecoes.ExcecaoSomenteNumeros;

public class Cliente {
	
	private String nome; 				// OBRIGATORIO
	private String cpf;					// OBRIGATORIO
	private String rg;					// OPCIONAL
	private String endereco;			// OBRIGATORIO
	private String cep;					// OBRIGATORIO
	private String celular;				// OBRIGATORIO
	private String telefoneResidencial; // OPCIONAL
	private String telefoneComercial; 	// OPCIONAL
	private String email;				// OBRIGATORIO
	
	/* Construtor minimo */
	public Cliente(String nome, String cpf, String endereco, String cep, String celular, String email)
		throws  ExcecaoSomenteLetras,
		ExcecaoSomenteNumeros,
		ExcecaoParametroPreenchidoErrado,
		ExcecaoDDDInvalido
	{	
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setCep(cep);
		setCelular(celular);
		setEmail(email);

	}
	
	// Construtor Completo
	public Cliente(String nome, String cpf, String endereco, String cep, String celular, String email, String rg, String telefoneResidencial, String telefoneComercial) 
		throws  ExcecaoSomenteLetras,
				ExcecaoSomenteNumeros,
				ExcecaoParametroPreenchidoErrado,
				ExcecaoDDDInvalido
	{
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setEndereco(endereco);
		setCep(cep);
		setCelular(celular);
		setTelefoneResidencial(telefoneResidencial);
		setTelefoneComercial(telefoneComercial);
		setEmail(email);
	}
	
	private void setNome(String nome) throws ExcecaoSomenteLetras {
		if (nome.matches("[a-zA-Z]([ a-zA-Zçãõ])*+") == false) throw new ExcecaoSomenteLetras("Nome");
		this.nome = nome;
	}
	
	private void setCpf (String cpf) throws ExcecaoParametroPreenchidoErrado {
		cpf = cpf.replace(".", "");
		cpf = cpf.replace("-", "");
		
		if (Utilitaria.verificarCPF(cpf) == false) throw new ExcecaoParametroPreenchidoErrado("CPF");
		this.cpf = cpf;
	}
	
	public void setRg (String rg) throws ExcecaoParametroPreenchidoErrado {
		boolean isRGOk = Utilitaria.verificarRG(rg);
		
		if (isRGOk)
			this.rg = rg;

		else 
			throw new ExcecaoParametroPreenchidoErrado("RG");
		
	}
	
	private void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	private void setCep(String cep) throws ExcecaoParametroPreenchidoErrado {
		if (cep.matches("\\d{5}-\\d{3}") == false) throw new ExcecaoParametroPreenchidoErrado("CEP");
		
		this.cep = cep;
	}
	
	private void setCelular(String celular) throws ExcecaoDDDInvalido, ExcecaoParametroPreenchidoErrado {
		
		boolean isCelularOk = Utilitaria.verificarCelular(celular);
		
		if (isCelularOk)
			this.celular = celular;
		
		else 
			throw new ExcecaoParametroPreenchidoErrado("Celular");
		
	}

	public void setTelefoneResidencial(String telefoneResidencial) throws ExcecaoDDDInvalido, ExcecaoParametroPreenchidoErrado {
		
		boolean isTelefoneResidencialOk = Utilitaria.verificarTelefoneFixo(telefoneResidencial);
		
		if (isTelefoneResidencialOk)
			this.telefoneResidencial = telefoneResidencial;
		
		else 
			throw new ExcecaoParametroPreenchidoErrado("Telefone Residencial");
	}
	
	public void setTelefoneComercial(String telefoneComercial) throws ExcecaoDDDInvalido, ExcecaoParametroPreenchidoErrado {
		
		boolean telefoneComercialECelular = Utilitaria.verificarCelular(telefoneComercial);
		boolean telefoneComercialETelefoneFixo = Utilitaria.verificarTelefoneFixo(telefoneComercial);
		
		if (telefoneComercialECelular || telefoneComercialETelefoneFixo) 
			this.telefoneComercial = telefoneComercial;
		else
			throw new ExcecaoParametroPreenchidoErrado("Telefone comercial");
	}
	
	private void setEmail(String email) {
		if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]+") == false) throw new ExcecaoParametroPreenchidoErrado("Email");
		
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getCep() {
		return cep;
	}
	
	public String getCelular() {
		return celular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public String getEmail() {
		return email;
	}

}
