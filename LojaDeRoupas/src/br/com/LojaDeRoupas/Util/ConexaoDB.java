package br.com.LojaDeRoupas.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoDB {

	private static Connection connection = null;
        private String url;
	private String user;
	private String password;
	
	
	public ConexaoDB(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
        
            protected void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            connection = DriverManager.getConnection(
                                        url, user, password);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				Properties prop = new Properties();

				String user = "root";
                String password = "root";
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LOJADEROUPAS?useTimezone=true&serverTimezone=UTC&useSSL=false", user, password);
				
			} catch (ClassNotFoundException e) {
				System.out.println("estou aqui");
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

}
