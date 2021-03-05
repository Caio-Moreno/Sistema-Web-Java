package br.com.LojaDeRoupas.Acao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.LojaDeRoupas.Dao.vendaDAO;
import br.com.LojaDeRoupas.Model.Carrinho;
import br.com.LojaDeRoupas.Model.Venda;
import br.com.LojaDeRoupas.Util.Utils;

public class VendaCadastrar implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("VENDA CADASTRAR");
		int qtdProdutos = 0;
		HttpSession sessao = request.getSession();
		List<Carrinho> listaCarrinho = (List<Carrinho>) sessao.getAttribute("carrinho");
		
		for(Carrinho c : listaCarrinho) {
			qtdProdutos += c.get_qtd();
		}
		
		System.out.println("VENDA CADASTRAR");
		
		String data_venda = request.getParameter("data_venda");
		System.out.println("VENDA CADASTRAR");   
        Integer cod_cliente = Integer.parseInt(request.getParameter("cod_cliente"));
        System.out.println("VENDA CADASTRAR"+cod_cliente);
       Integer cod_filial = Integer.parseInt(request.getParameter("codFilial"));
       System.out.println("VENDA CADASTRAR");
        Integer quantidade = qtdProdutos;
        System.out.println("VENDA CADASTRAR");
        Double desconto = Double.parseDouble(request.getParameter("desconto").replace("R$", ""));
        System.out.println("VENDA CADASTRAR");
        Double valor_Total = Double.parseDouble(request.getParameter("valor_Total").replace("R$", ""));
        System.out.println("VENDA CADASTRAR");
        Venda venda = new Venda(data_venda, cod_cliente, cod_filial, quantidade, desconto, valor_Total);
        System.out.println("VENDA CADASTRAR");
           try {
        	   System.out.println("VENDA CADASTRAR");
            vendaDAO.inserirVenda(venda,listaCarrinho);
            System.out.println("VENDA CADASTRAR");
            sessao.removeAttribute("carrinho");
            return "redirect:entrada?acao=VendaConsultar";
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(VendaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
            Utils.mostrarTelaErro(ex, request, response);
        }
           
           
		return null;
           
	}

}
