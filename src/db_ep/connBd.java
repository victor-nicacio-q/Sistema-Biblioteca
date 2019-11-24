package db_ep;

import java.sql.*;

public class connBd {
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:8889/db_ep", "root", "root");
		}catch(ClassNotFoundException exc) {
			throw new SQLException(exc.getMessage());
		}
		
	}
	
}
