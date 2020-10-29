/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.LojaDeRoupas.Servlet;

import br.com.LojaDeRoupas.Dao.ClienteDAO;
import br.com.LojaDeRoupas.Model.Cliente;
import br.com.LojaDeRoupas.Util.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AlterarCliente extends HttpServlet {

  
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        Cliente cliente = ClienteDAO.getCliente(cpf);
        request.setAttribute("cliente", cliente);
         RequestDispatcher rd = 
                 getServletContext().getRequestDispatcher("/alterarCliente.jsp");
         rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String nome = request.getParameter("nome");
    	String cpf = request.getParameter("cpf");
    	String sexo = request.getParameter("sexo");
    	String dataNascimento = request.getParameter("dataNascimento");
    	String telefone = request.getParameter("telefone");
		telefone = telefone.replaceAll("[^0-9]", "");
    	String email = request.getParameter("email");
    	String cep = request.getParameter("cep");
    	String endereco = request.getParameter("endereco");
    	String bairro = request.getParameter("bairro");
    	Integer numero = Integer.parseInt(request.getParameter("numero"));
    	String complemento = request.getParameter("complemento");
    	String cidade = request.getParameter("cidade");
    	String estado = request.getParameter("estado");
    	
         Cliente cliente = ClienteDAO.getCliente(cpf);
         cliente.setNome(nome);
         cliente.setSexo(sexo);
         cliente.setDataNascimento(dataNascimento);
         cliente.setTelefone(telefone);
         cliente.setEmail(email);
         cliente.setCep(cep);
         cliente.setEndereco(endereco);
         cliente.setBairro(bairro);
         cliente.setNumero(numero);
         cliente.setComplemento(complemento);
         cliente.setCidade(cidade);
         cliente.setEstado(estado);
        
         
         try {
             ClienteDAO.updateCliente(cliente);
             response.sendRedirect("sucesso.jsp");
         } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(AlterarCliente.class.getName()).log(Level.SEVERE, null, ex);
             Utils.mostrarTelaErro(ex, request, response);
         } 
        
    }

    

}
