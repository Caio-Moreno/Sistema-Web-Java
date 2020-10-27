package br.com.LojaDeRoupas.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    
	private Integer codcliente;
	private String nome;
	private String cpf;
	private String sexo;
	private String dataNascimento;
	private Integer telefone;
	private String email;
	private String cep;
	private String endereco;
	private String bairro;
	private Integer numero;
	private String complemento;
	private String cidade;
	private String estado;
	
	
 

    public Cliente(String nomeCliente, String cpfCliente, String sexoCliente, String dataNascimento, Integer telefone,
			String email, String cep, String endereco, String bairro, Integer numero, String complemento, String cidade,
			String estado) {
		this.nome = nomeCliente;
		this.cpf = cpfCliente;
		this.sexo = sexoCliente;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}
    
    

public Cliente(Integer codcliente, String nome, String cpf, String sexo, String dataNascimento, Integer telefone,
			String email, String cep, String endereco, String bairro, Integer numero, String complemento, String cidade,
			String estado) {
		this.codcliente = codcliente;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.email = email;
		this.cep = cep;
		this.endereco = endereco;
		this.bairro = bairro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
	}



@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}

public String getNomeCliente() {
	return nome;
}

public void setNomeCliente(String nomeCliente) {
	this.nome = nomeCliente;
}

public String getCpfCliente() {
	return cpf;
}

public void setCpfCliente(String cpfCliente) {
	this.cpf = cpfCliente;
}

public String getSexoCliente() {
	return sexo;
}

public void setSexoCliente(String sexoCliente) {
	this.sexo = sexoCliente;
}

public String getDataNascimento() {
	return dataNascimento;
}

public void setDataNascimento(String dataNascimento) {
	this.dataNascimento = dataNascimento;
}

public Integer getTelefone() {
	return telefone;
}

public void setTelefone(Integer telefone) {
	this.telefone = telefone;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCep() {
	return cep;
}

public void setCep(String cep) {
	this.cep = cep;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}

public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public String getComplemento() {
	return complemento;
}

public void setComplemento(String complemento) {
	this.complemento = complemento;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}



public Integer getCodcliente() {
	return codcliente;
}



public void setCodcliente(Integer codcliente) {
	this.codcliente = codcliente;
}



public String getNome() {
	return nome;
}



public void setNome(String nome) {
	this.nome = nome;
}



public String getCpf() {
	return cpf;
}



public void setCpf(String cpf) {
	this.cpf = cpf;
}



public String getSexo() {
	return sexo;
}



public void setSexo(String sexo) {
	this.sexo = sexo;
}


    

    
    
}
