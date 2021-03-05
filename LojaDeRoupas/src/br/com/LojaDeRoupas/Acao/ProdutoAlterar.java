package br.com.LojaDeRoupas.Acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.LojaDeRoupas.Dao.produtoDAO;
import br.com.LojaDeRoupas.Model.Usuario;
import br.com.LojaDeRoupas.Model.filial;
import br.com.LojaDeRoupas.Model.produto;

public class ProdutoAlterar implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String metodo = request.getParameter("metodo");
		
		if(metodo.equals("get")) {
			System.out.println("GET!!!!");
		
		
		
			String status = request.getParameter("action");
			Integer id = Integer.valueOf(request.getParameter("id"));
			List<filial> lista = produtoDAO.listarFiliais();

			if(status.equals("create")) {
			produto produto = null;	
				
			
			request.setAttribute("action", produto);
			request.setAttribute("filial", lista);
			
			return "forward:cadastrarProduto.jsp";		
			
			
			}else if(status.equals("update")) {
			System.out.println("MEU ID"+id);
			produto produto = new produto(id,status);
			
			produto dadosProduto = produtoDAO.buscaProdutoPorId(id);
			
			request.setAttribute("action", produto);
			request.setAttribute("produto", dadosProduto);
			request.setAttribute("filial", lista);
			return "forward:cadastrarProduto.jsp";			
					
			}
		
		}else if(metodo.equals("post")) {
			System.out.println("POST!!!!");
			System.out.println("Atualizando produto");
			try {
			Integer codFilial = Integer.valueOf(request.getParameter("codFilial"));
			System.out.println("Atualizando produto"+codFilial);
			Integer codProduto = Integer.valueOf(request.getParameter("ID_PRODUTO"));
			System.out.println("Atualizando produto"+codProduto);
			String nome = request.getParameter("nome");
			System.out.println("Atualizando produto"+nome);
			String tipo = request.getParameter("tipoProduto");
			System.out.println("Atualizando produto"+tipo);
			Integer quantidade = Integer.valueOf(request.getParameter("quantidade"));
			System.out.println("Atualizando produto");
			double valorCompra = Double.parseDouble(request.getParameter("valorCompra"));
			System.out.println("Atualizando produto");
			double valorVenda = Double.parseDouble(request.getParameter("valorVenda"));
			System.out.println("Atualizando produto");
			String path = "Imagens/" + tipo + ".jpg";
			System.out.println(codFilial+" "+codProduto+" "+nome+" "+tipo+" "+quantidade+" "+valorCompra+" "+valorVenda+ "" + path);
			
			produto produto = new produto(codFilial,codProduto, nome,tipo,quantidade,valorCompra, valorVenda,path);
			
			System.out.println("O produto é esse"+produto);
			
			produtoDAO.atualizarProduto(produto);
			
			
			
			} catch (Exception e) {
				throw new ServletException(e.getMessage());
			}
			
			return "redirect:entrada?acao=ProdutoConsultar";
			
		}
		
		return null;
	}

}
