package br.com.LojaDeRoupas.Acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.LojaDeRoupas.Dao.produtoDAO;
import br.com.LojaDeRoupas.Model.Usuario;
import br.com.LojaDeRoupas.Model.produto;

public class ProdutoConsultar implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		List<produto> lista = null;
		try {
			lista = produtoDAO.consultarProduto();
		} catch (SQLException e) {
			throw new ServletException(e.getMessage());
		}




		request.setAttribute("produtos", lista);

		return "forward:listaProdutos.jsp";
	
	}
	
	
	
}
