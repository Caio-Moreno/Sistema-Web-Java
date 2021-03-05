package br.com.LojaDeRoupas.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.LojaDeRoupas.Dao.produtoDAO;
import br.com.LojaDeRoupas.Model.Carrinho;
import br.com.LojaDeRoupas.Model.produto;

/**
 * Servlet implementation class CarrinhoServlet
 */
@WebServlet("/Carrinho")
public class CarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CARRINHO");
		boolean jaTem = false;
		boolean jaFez = false;
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println("MEU ID CARRINHO-->"+id);
		String action = request.getParameter("action");
		
		produto produto = produtoDAO.buscaProdutoPorId(id);
		System.out.println("ACHEI O PRODUTO"+produto);
		
		Carrinho carrinho = new  Carrinho(produto.get_codProduto(), produto.get_nome(), produto.get_valorVenda(),1);
		
		
		HttpSession sessao = request.getSession();
		
		List<Carrinho> listaCarrinho;
		if(sessao.getAttribute("carrinho") == null) {
			listaCarrinho = new ArrayList<Carrinho>();
		}else {
			listaCarrinho = (List<Carrinho>) sessao.getAttribute("carrinho");
		}
		
		
		
		for (int i = 0; i < listaCarrinho.size(); i++) {
			if(action.equals("adicionar")) {
				
				if (listaCarrinho.get(i).get_id() == carrinho.get_id()) {  	
					listaCarrinho.get(i).set_preco(listaCarrinho.get(i).get_preco() + carrinho.get_preco());
					listaCarrinho.get(i).set_qtd(listaCarrinho.get(i).get_qtd() + carrinho.get_qtd());
					
					System.out.println("Ja tem");
					jaTem = true;
					//listaCarrinho.remove(i);
				}
				
			}else {
				if(!jaFez) {
					
					if (listaCarrinho.get(i).get_id() == carrinho.get_id()) {
						listaCarrinho.get(i).set_preco(listaCarrinho.get(i).get_preco() - carrinho.get_preco());
						listaCarrinho.get(i).set_qtd(listaCarrinho.get(i).get_qtd() - carrinho.get_qtd());
					
						if(listaCarrinho.get(i).get_qtd() <= 0) { System.out.println("vou remover"); listaCarrinho.remove(i);  } //se zerar os produtos remover da lista
						
					}
					jaTem = true;
				}
			}
		  }
		
		if(!jaTem) {
			
			listaCarrinho.add(carrinho);
		}
		
		for (int i = 0; i < listaCarrinho.size(); i++) {
			System.out.println("Meu carrinho-->"+listaCarrinho.get(i).get_id() + " - " + listaCarrinho.get(i).get_nome()+" - "+ listaCarrinho.get(i).get_preco()+" - "+listaCarrinho.get(i).get_qtd());
			
		  }
		
		sessao.setAttribute("carrinho", listaCarrinho);
		
		
	}
}
