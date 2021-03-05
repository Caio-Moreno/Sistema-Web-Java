package br.com.LojaDeRoupas.Acao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.LojaDeRoupas.Dao.produtoDAO;
import br.com.LojaDeRoupas.Model.Usuario;
import br.com.LojaDeRoupas.Model.produto;

public class ProdutoCadastrar implements Acao  {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		
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
		
		String path = "Imagens/" + tipo + ".jpg";
		
		System.out.println("vou 2"+codFilial+" "+nome+" "+tipo+" "+quantidade+" "+valorCompra+" "+valorVenda);
		produto produto = new produto(codFilial, nome,tipo,quantidade,valorCompra, valorVenda,path);
		System.out.println(produto);
		produtoDAO.inserirProduto(produto);
		} catch (SQLException e) {
			
			throw new ServletException(e.getMessage());
		}catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		
		
		
		return "redirect:entrada?acao=ProdutoConsultar";

		
	}
	
}
