package br.com.LojaDeRoupas.Model;

import java.util.Date;

public class Vendedor extends funcionario implements IAutenticavel {

	
	


	

	public Vendedor(int codfuncionario, String nome, String cpf, String sexo, String datanascimento, String telefone,
			String email, String cep, String endereco, String bairro, int numero, String complemento,String cidade, String estado,
			String login, String senha, String tipo) {
		super(codfuncionario, nome, cpf, sexo, datanascimento, telefone, email, cep, endereco, bairro, numero, complemento,cidade, estado,
				login, senha, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Logout() {
		// TODO Auto-generated method stub
		
	}

	
	
}
