package classes;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private String cep;
	private String celular;
	private String telefoneResidencial;
	private String telefoneComercial;
	private String email;
	
	public Cliente(String nome, String cpf, String rg, String endereco, String cep, String celular, String telefoneResidencial, String telefoneComercial, String email) {
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
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	private void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	private void setRg(String rg) {
		this.rg = rg;
	}
	
	private void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	private void setCep(String cep) {
		this.cep = cep;
	}
	
	private void setCelular(String celular) {
		this.celular = celular;
	}

	private void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	
	private void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	
	private void setEmail(String email) {
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
