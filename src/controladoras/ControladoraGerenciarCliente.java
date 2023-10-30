package controladoras;

import java.util.ArrayList;

import classes.Cliente;

public class ControladoraGerenciarCliente {
	public Cliente getCliente(String cpf) {
		return Cliente.getCliente(cpf);
	}

	public void cadastrarCliente(Cliente cliente) {
		Cliente.cadastrarCliente(cliente);
	}

	public Cliente criar(String nome, String cpf, String rg, String endereco, String cep, String celular,
			String telefoneResidencial, String telefoneComercial, String email) {
		return new Cliente(nome, cpf, endereco, cep, celular, email, rg, telefoneResidencial, telefoneComercial);
	}

	public void atualizar(String nome, String cpf, String rg, String endereco, String cep, String celular,
			String telefoneResidencial, String telefoneComercial, String email) {
		Cliente cliente = new Cliente(nome, cpf, endereco, cep, celular, email, rg, telefoneResidencial,
				telefoneComercial);
		Cliente.atualizarCliente(cliente);
	}

	public void deletar(String cpf) {
		Cliente.deletarCliente(cpf);
	}

	public ArrayList<Cliente> getAllClientes() {
		return Cliente.getAllCliente();
	}
}
