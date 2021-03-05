/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LojaDeRoupas.Model;

import java.util.Date;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter

public class gerente extends funcionario {
    
    

    
    public gerente(int codfuncionario, String nome, String cpf, String sexo, String datanascimento, String telefone,
			String email, String cep, String endereco, String bairro, int numero, String complemento,String cidade, String estado,
			String login, String senha, String tipo) {
		super(codfuncionario, nome, cpf, sexo, datanascimento, telefone, email, cep, endereco, bairro, numero, complemento,cidade, estado,
				login, senha, tipo);
	}
    
    
    public gerente(String nome, String cpf, String sexo, String datanascimento, String telefone,
			String email, String cep, String endereco, String bairro, int numero, String complemento,String cidade, String estado,
			String login, String senha, String tipo) {
		super( nome, cpf, sexo, datanascimento, telefone, email, cep, endereco, bairro, numero, complemento,cidade, estado,
				login, senha, tipo);
	}
    
    






	@Override
    public String toString() {
        return super.toString();
    }










	
  
    
    
    
}
