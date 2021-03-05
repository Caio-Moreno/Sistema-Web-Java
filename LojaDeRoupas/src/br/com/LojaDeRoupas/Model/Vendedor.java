package br.com.LojaDeRoupas.Model;

import java.util.Date;

public class Vendedor extends funcionario {

	
	


	

	public Vendedor(int codfuncionario, String nome, String cpf, String sexo, String datanascimento, String telefone,
			String email, String cep, String endereco, String bairro, int numero, String complemento,String cidade, String estado,
			String login, String senha, String tipo) {
		super(codfuncionario, nome, cpf, sexo, datanascimento, telefone, email, cep, endereco, bairro, numero, complemento,cidade, estado,
				login, senha, tipo);
		// TODO Auto-generated constructor stub
	}
	
	public Vendedor(String nome, String cpf, String sexo, String datanascimento, String telefone,
			String email, String cep, String endereco, String bairro, int numero, String complemento,String cidade, String estado,
			String login, String senha, String tipo) {
		super(nome, cpf, sexo, datanascimento, telefone, email, cep, endereco, bairro, numero, complemento,cidade, estado,
				login, senha, tipo);
		// TODO Auto-generated constructor stub
	}


	
	
}
