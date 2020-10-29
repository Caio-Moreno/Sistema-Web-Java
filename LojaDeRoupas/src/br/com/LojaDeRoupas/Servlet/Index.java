package br.com.LojaDeRoupas.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.LojaDeRoupas.Dao.indexDAO;


/**
 * Servlet implementation class VendaGrafico
 */

public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Buscar para o gráfico NO SERVLETTTTTTT");
		
		String listaDeData = "";
		String listaQtd = "";
	
		List<br.com.LojaDeRoupas.Model.Index> lista = indexDAO.consultarVenda();
		
		
		for (br.com.LojaDeRoupas.Model.Index index : lista) {
			listaDeData += index.get_data() + ",";
			listaQtd += index.get_qtd() + ",";
		}
		
		int tamanho = listaDeData.length();
		listaDeData = listaDeData.substring(0, tamanho-1);
		
		int tamanho2 = listaQtd.length();
		listaQtd = listaQtd.substring(0, tamanho2-1);
		
		
		request.setAttribute("data", listaDeData);
		request.setAttribute("qtd", listaQtd);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		rd.forward(request, response);
		
	}
}
