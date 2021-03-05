package br.com.LojaDeRoupas.Dao;


import br.com.LojaDeRoupas.Util.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import br.com.LojaDeRoupas.Model.Carrinho;
import br.com.LojaDeRoupas.Model.Venda;




public class vendaDAO{
	
	private static final String DELETAR_VENDA = "DELETE FROM VENDA WHERE ID_VENDA= ? ";
    private static final String CONSULTAR_VENDA = "\n"
    		+ "Select ID_VENDA,C.NOME, F.ESTADO,a.QUANTIDADE, VALOR_TOTAL,DATA_VENDA from VENDA a \n"
    		+ "inner join VENDA_HAS_PRODUTO b on a.ID_VENDA = b.COD_VENDA\n"
    		+ "INNER JOIN FILIAL F ON F.ID_FILIAL = a.COD_FILIAL\n"
    		+ "INNER JOIN PRODUTO P ON P.ID_PRODUTO = b.COD_PRODUTO\n"
    		+ "INNER JOIN CLIENTE C ON C.ID_CLIENTE = a.COD_CLIENTE\n"
    		+ "where 1 = 1\n"
    		+ "group by ID_VENDA\n"
    		+ "order by DATA_VENDA desc;";
    private static final String GET_VENDA = "SELECT * FROM VENDA WHERE  ID_VENDA= ? ";
    private static final String UPDATE_VENDA = "UPDATE VENDA SET DATA_VENDA = ?, COD_CLIENTE = ?, COD_PRODUTO = ?, COD_FILIAL = ?, QUANTIDADE = ?, DESCONTO = ?, VALOR_TOTAL = ? WHERE ID_VENDA = ? ";
    private static final String INSERIR_VENDA = "INSERT INTO VENDA (DATA_VENDA, COD_CLIENTE, COD_PRODUTO, COD_FILIAL, QUANTIDADE, DESCONTO, VALOR_TOTAL) VALUES (?, ?, ?, ?, ?, ?, ? ) ";
 
    public static List<Venda> consultarVenda() {
    	System.out.println("Entrei na CONSULTA");
    	List <Venda> listaVenda =  new ArrayList<Venda>();
    	
    	try {
    	
    	Connection con = ConexaoDB.getConnection();
    	String query = CONSULTAR_VENDA;
    	PreparedStatement ps = con.prepareStatement(query);
    	System.out.println(ps);
    	ResultSet rs = ps.executeQuery();
    	
    	
    	
    	while(rs.next()) {
    		Integer id_venda = rs.getInt("ID_VENDA");
    		String nome =  rs.getString("NOME");
			String estado = rs.getString("ESTADO");
			Integer quantidade = rs.getInt("QUANTIDADE");
			double valor_Total  = rs.getDouble("VALOR_TOTAL");
			String data_venda = rs.getString("DATA_VENDA");
			
			
			
		listaVenda.add(new Venda(id_venda, nome, estado,quantidade, valor_Total,data_venda));
			
    	}
    	
    	}catch (SQLException ex) {
    		  ex.getMessage();
		}
    	return listaVenda;
    }
    
    
    public static List<Venda> consultarVenda(String dataIni,String dataFim) {
    	System.out.println("Entrei na CONSULTA");
    	List <Venda> listaVenda =  new ArrayList<Venda>();
    	
    	try {
    	
    	Connection con = ConexaoDB.getConnection();
    	String query =  "Select ID_VENDA,C.NOME, F.ESTADO,a.QUANTIDADE, VALOR_TOTAL,DATA_VENDA from VENDA a inner join VENDA_HAS_PRODUTO b on a.ID_VENDA = b.COD_VENDA INNER JOIN FILIAL F ON F.ID_FILIAL = a.COD_FILIAL INNER JOIN PRODUTO P ON P.ID_PRODUTO = b.COD_PRODUTO INNER JOIN CLIENTE C ON C.ID_CLIENTE = a.COD_CLIENTE where 1 = 1 and DATA_VENDA between ? and ? group by ID_VENDA order by DATA_VENDA desc;";
    	PreparedStatement ps = con.prepareStatement(query);
    	ps.setString(1, dataIni);
    	ps.setString(2, dataFim);
    	System.out.println(ps);
    	ResultSet rs = ps.executeQuery();
    	
    	
    	
    	while(rs.next()) {
    		Integer id_venda = rs.getInt("ID_VENDA");
    		String nome =  rs.getString("NOME");
			String estado = rs.getString("ESTADO");
			Integer quantidade = rs.getInt("QUANTIDADE");
			double valor_Total  = rs.getDouble("VALOR_TOTAL");
			String data_venda = rs.getString("DATA_VENDA");
			
			
			
		listaVenda.add(new Venda(id_venda, nome, estado,quantidade, valor_Total,data_venda));
			
    	}
    	
    	}catch (SQLException ex) {
    		  System.out.println(ex.getMessage());
		}
    	return listaVenda;
    }
    
    
    
    
    public static Venda getVenda (int id_venda) {
    	
    	Venda venda = new Venda(id_venda);
    	try {
    		
    		Connection con = ConexaoDB.getConnection();
    		String query = GET_VENDA;
    		PreparedStatement ps = con.prepareStatement(query);
    		
    		ps.setInt(1, id_venda);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		if(rs.next()) {
    			String data_venda = rs.getString("DATA_VENDA");
    			Integer cod_cliente = rs.getInt("COD_CLIENTE");
    			Integer cod_produto = rs.getInt("COD_PRODUTO");
    			Integer cod_filial = rs.getInt("COD_FILIAL");
    			Integer quantidade = rs.getInt("QUANTIDADE");
    			double desconto = rs.getDouble("DESCONTO");
    			double valor_Total  = rs.getDouble("VALOR_TOTAL");
    			
    			 venda = new Venda(id_venda,data_venda, cod_cliente, cod_produto, cod_filial, quantidade, desconto, valor_Total);
    			
    		}
    		
    	}catch (SQLException e) {
    		e.printStackTrace();
		}
    	
    	return venda;
    }
    
    public static void updateVenda (Venda venda) throws SQLException, ClassNotFoundException{
    	
    	
    		Connection con = ConexaoDB.getConnection();
    		String query = UPDATE_VENDA;
    		PreparedStatement ps = con.prepareStatement(query);
    		ps.setString(1, venda.getData_venda());
        	ps.setInt(2, venda.getCod_cliente());
        	ps.setInt(3, venda.getCod_produto());
        	ps.setInt(4, venda.getCod_filial());
        	ps.setInt(5, venda.getQuantidade());
        	ps.setDouble(6, venda.getDesconto());
        	ps.setDouble(7, venda.getValor_Total());
        	ps.setInt(8, venda.getId_venda());
        	ps.execute();
        	
    		
    	    
    	
    }
    
    public static void inserirVenda (Venda venda, List<Carrinho> listaVenda) throws SQLException, ClassNotFoundException{
    	System.out.println("INSERIR VENDA");
    	 String INSERIR_VENDA = "INSERT INTO VENDA (DATA_VENDA, COD_CLIENTE, COD_FILIAL, QUANTIDADE, DESCONTO, VALOR_TOTAL) VALUES (?, ?, ?, ?, ?, ? ) ";
    	 int id = 0;
    	 String BuscaId = "select LAST_INSERT_ID() as id";
    	 String sqlInsertProdutos = "INSERT INTO VENDA_HAS_PRODUTO(COD_VENDA,COD_PRODUTO,VALOR,QUANTIDADE) VALUES(?,?,?,?); ";
    	 System.out.println("INSERIR VENDA");
    	
    	
    	try {
    	Connection con = ConexaoDB.getConnection();
    	String query= INSERIR_VENDA;
    	PreparedStatement ps = con.prepareStatement(query);
    	ps.setString(1, venda.getData_venda());
    	ps.setInt(2, venda.getCod_cliente());
    	ps.setInt(3, venda.getCod_filial());
    	ps.setInt(4, venda.getQuantidade());
    	ps.setDouble(5, venda.getDesconto());
    	ps.setDouble(6, venda.getValor_Total());
    	System.out.println("INSERT VENDA----->" + ps);
    	
    	ps.execute();
    	
    
    	
    	}catch (SQLException e) {
			System.out.print(e.getMessage());
		}
    	
    	System.out.println("INSERIR VENDA");
    	//inserir a venda agora vou buscar o id da venda para inserir os produtos 	
    	try {
        	Connection con = ConexaoDB.getConnection();
        	PreparedStatement ps = con.prepareStatement(BuscaId);
		
        	ResultSet rs = ps.executeQuery();
		
        	if(rs.next()) {
        		
        		id = rs.getInt("id");
        		
        		
        		
        	}
		}catch (Exception e) {
			System.out.print(e.getMessage());
		}
    	
    	
    	System.out.println("INSERIR VENDA");
    	//vou inserir os produtos
    	
    	try {
        	Connection con = ConexaoDB.getConnection();
        	PreparedStatement ps = con.prepareStatement(sqlInsertProdutos);
        	for(Carrinho c : listaVenda) {
        		System.out.println("INSERIR VENDA");
        		ps.setInt(1, id);
        		ps.setInt(2,2);
        		ps.setDouble(3, c.get_preco());
        		ps.setInt(4, c.get_qtd());
        		System.out.println("INSERT VENDA_HAS_PRODUTO----->" + ps);
        		ps.execute();
        	}
        }catch (SQLException e) {
    			System.out.print(e.getMessage());
    	}
    	
    	
		
		
    	
    	
    	
    }
	
    
    
    
    
    
    
      public static void deletarVenda(int id_venda) throws ClassNotFoundException, SQLException {
    
    	  
    	  
    	  
    	try {  
    	Connection con = ConexaoDB.getConnection();
        String query = DELETAR_VENDA;
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id_venda);
        
        System.out.println(ps);
        
        ps.execute();
    	}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    }
    
}
