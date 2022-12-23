package br.com.mesttra.cidadeBD; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getconnection() {
		
		try {
			return DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/CidadeBD","postgres","123456");
		} catch (SQLException e) {
			System.err.println("Erro na conexão!");
			return null;
		}
	}

}
