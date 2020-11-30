package br.com.LojaDeRoupas.Acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.LojaDeRoupas.Dao.produtoDAO;
import br.com.LojaDeRoupas.Model.Usuario;
import br.com.LojaDeRoupas.Model.produto;

public class ProdutoCadastrar implements Acao  {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!Usuario.estaLogado(request, response)) {
			System.out.println("Não está logado!");
			response.sendRedirect("login.jsp");
			return;
			 
		}
		
		System.out.println("Cadastrando novoProduto");
		try {
			System.out.println("vou 1");
			System.out.println("CODFILIAL =================>"+request.getParameter("codFilial"));
		Integer codFilial = Integer.valueOf(request.getParameter("codFilial"));
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipoProduto");
		Integer quantidade = Integer.valueOf(request.getParameter("quantidade"));
		double valorCompra = Double.parseDouble(request.getParameter("valorCompra"));
		double valorVenda = Double.parseDouble( request.getParameter("valorVenda"));
		System.out.println("vou 2"+codFilial+" "+nome+" "+tipo+" "+quantidade+" "+valorCompra+" "+valorVenda);
		produto produto = new produto(codFilial, nome,tipo,quantidade,valorCompra, valorVenda);
		System.out.println(produto);
		produtoDAO.inserirProduto(produto);
		} catch (SQLException e) {
			
			throw new ServletException(e.getMessage());
		}catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		
		response.sendRedirect("entrada?acao=ProdutoConsultar");

		
	}
	
		
}
