package br.com.LojaDeRoupas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import br.com.LojaDeRoupas.Model.filial;
import br.com.LojaDeRoupas.Model.produto;
import br.com.LojaDeRoupas.Util.ConexaoDB;

public class produtoDAO {

	public static List<produto> consultarProduto() throws SQLException, ServletException{
    	List <produto> listaProdutos =  new ArrayList<>();
    	
    	System.out.println("Estou na consulta");
    	
    	String sqlConsulta = "SELECT ID_PRODUTO,NOME, TIPO,QUANTIDADE, VALOR_COMPRA,VALOR_VENDA,ESTADO,PATH FROM PRODUTO a INNER JOIN  ESTOQUE b  ON ID_PRODUTO = b.COD_PRODUTO_FK INNER JOIN FILIAL c ON c.ID_FILIAL = a.COD_FILIAL;";
    	
    	try {
    		
    		Connection con = ConexaoDB.getConnection();
    		PreparedStatement ps = con.prepareStatement(sqlConsulta);
    		ResultSet rs = ps.executeQuery();
    		
    		System.out.println(ps);
    	
    	while(rs.next()) {
    		int codProduto = rs.getInt("ID_PRODUTO");
    		String nome = rs.getString("NOME");
    		String tipo = rs.getString("TIPO");
    		int quantidade = rs.getInt("QUANTIDADE");
    		double valorCompra = rs.getDouble("VALOR_COMPRA");
    		double valorVenda = rs.getDouble("VALOR_VENDA");
    		String filial = rs.getString("ESTADO");
    		String path = rs.getString("PATH");
			System.out.println(nome);
		listaProdutos.add(new produto(codProduto,nome,tipo,quantidade,valorCompra,valorVenda,filial,path));
			
    	}
    	
    	}catch (SQLException e) {
    		throw new ServletException(e.getMessage());
		}
    	return listaProdutos;
    }
    
    public static void inserirProduto(produto produto) throws SQLException, ServletException{
    	System.out.println("inserirProduto");
    	String sqlInsert = "insert into PRODUTO(ID_PRODUTO,COD_FILIAL,NOME,TIPO,VALOR_COMPRA,VALOR_VENDA,PATH) values(DEFAULT,?,?,?,?,?,?)";
    	String sqlInsertEstoque = "insert into ESTOQUE(ID_ESTOQUE,COD_PRODUTO_FK,QUANTIDADE) values(DEFAULT,LAST_INSERT_ID(),?)";
    	
    	try {
    		Connection con = ConexaoDB.getConnection();
    		PreparedStatement insertProduto = con.prepareStatement(sqlInsert);
    		PreparedStatement insertEstoque = con.prepareStatement(sqlInsertEstoque);
    		insertProduto.setInt(1, produto.get_codFilial());
    		insertProduto.setString(2, produto.get_nome());
    		insertProduto.setString(3, produto.get_tipo());
    		insertProduto.setDouble(4, produto.get_valorCompra());
    		insertProduto.setDouble(5, produto.get_valorVenda());
    		insertProduto.setString(6, produto.get_path());
    		System.out.println("INSERT DO PRODUTO---->"+insertProduto);
    		/*        Insert do estoque                        */
    		insertEstoque.setInt(1, produto.get_quantidade());
    		System.out.println("INSERT DO ESTOQUE---->"+insertEstoque);
    		
    		insertProduto.execute();
    		insertEstoque.execute();
    		
    	}catch (SQLException e) {
    		throw new ServletException(e.getMessage());
		}
    	System.out.println("executei");
    }
    
    public static void atualizarProduto(produto produto) throws SQLException {
    	System.out.println("atualizarPrdoutoDAO");
    	String sqlUpdate = "UPDATE PRODUTO a inner join ESTOQUE b on a.ID_PRODUTO = b.COD_PRODUTO_FK set a.COD_FILIAL = ?, a.NOME = ?, a.TIPO = ?, a.VALOR_COMPRA = ?, a.VALOR_VENDA =?, b.QUANTIDADE = ? WHERE ID_PRODUTO= ?";
    	
    	try{
    		Connection con = ConexaoDB.getConnection();
        	PreparedStatement ps = con.prepareStatement(sqlUpdate);
    		System.out.println("atualizarPrdoutoDAO2");
    		ps.setInt(1, produto.get_codFilial());
    		System.out.println("atualizarPrdoutoDAO3");
    		ps.setString(2, produto.get_nome());
    		System.out.println("atualizarPrdoutoDAO4");
    		ps.setString(3, produto.get_tipo());
    		ps.setDouble(4, produto.get_valorCompra());
    		ps.setDouble(5, produto.get_valorVenda());
    		ps.setInt(6, produto.get_quantidade());
    		ps.setInt(7, produto.get_codProduto());
    		
    		System.out.println("UPDATE AQUI ---->"+ ps);
    		
    		ps.executeUpdate();
    		
		} catch (Exception e) {
			String erro = e.getMessage();
			System.out.println(erro);
		}
    }
    
    public static produto buscaProdutoPorId(Integer id) throws ServletException {
    	System.out.println("Estou na consulta");
		
		produto produto = null;

    	String sqlConsulta = "SELECT ID_PRODUTO,NOME, TIPO,QUANTIDADE, VALOR_COMPRA,VALOR_VENDA,ESTADO FROM PRODUTO a INNER JOIN  ESTOQUE b  ON ID_PRODUTO = b.COD_PRODUTO_FK INNER JOIN FILIAL c ON c.ID_FILIAL = a.COD_FILIAL WHERE ID_PRODUTO = ?;";
    	
    	try {
    		
    		Connection con = ConexaoDB.getConnection();
    		PreparedStatement ps = con.prepareStatement(sqlConsulta);
    		
    		ps.setInt(1, id);
    		
    		System.out.println("QUERY DE CONSULTA---->"+ps);
    		
    		ResultSet rs = ps.executeQuery();
    	
    	while(rs.next()) {
    		int codProduto = id;
    		System.out.println(id+"estamos aq");
    		String nome = rs.getString("NOME");
    		String tipo = rs.getString("TIPO");
    		int quantidade = rs.getInt("QUANTIDADE");
    		double valorCompra = rs.getDouble("VALOR_COMPRA");
    		double valorVenda = rs.getDouble("VALOR_VENDA");
    		String filial = rs.getString("ESTADO");
    		
    		System.out.println("MINHA QUANTIDADE------->"+quantidade);
			
		produto = new produto(nome,codProduto,tipo,quantidade,valorCompra,valorVenda,filial);
			System.out.println(produto+" novo");
    	}
    	
    	}catch (SQLException e) {
    		throw new ServletException(e.getMessage());
		}
    	
    	return produto;
    }
    
    public static void deleteProduto(Integer id) throws ServletException {
    	System.out.println("Estou no delete");
    	
    	String SqlDelete = "DELETE FROM PRODUTO WHERE ID_PRODUTO= ?";
    	
    	try {
    		Connection con = ConexaoDB.getConnection();
    		PreparedStatement ps = con.prepareStatement(SqlDelete);
    		ps.setInt(1, id);
    		
    		System.out.println("MEU DELETE --->"+ps);
    		
    		ps.execute();
    		
    	} catch(Exception e) {
    		throw new ServletException(e.getMessage());
    	}
    }
    
    public static List<filial> listarFiliais() throws ServletException {
    	System.out.println("BUSCAR FILIAIS");
    	List <filial> lista = new ArrayList<filial>();
    	String sqlConsulta = "SELECT * FROM FILIAL;";
    	System.out.println("BUSCAR FILIAIS");
    	try {
    		Connection con = ConexaoDB.getConnection();
    		PreparedStatement ps = con.prepareStatement(sqlConsulta);
    		ResultSet rs = ps.executeQuery();
    		System.out.println("BUSCAR FILIAIS");
    		while(rs.next()) {
    			int idFilial = rs.getInt("ID_FILIAL");
    			String estado = rs.getString("ESTADO");
    			lista.add(new filial(idFilial, estado));
    			System.out.println("BUSCAR FILIAIS"+idFilial+estado);
    		}	
    	}catch (Exception e) {
    		
    		throw new ServletException(e.getMessage());
		}
    	System.out.println("BUSCAR FILIAIS!");
    	return lista;
    }
    
    
      
}
