package db_ep;

import java.sql.*;

public class connBd {
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost/db_ep", "root", "root");
		}catch(ClassNotFoundException exc) {
			throw new SQLException(exc.getMessage());
		}
		
	}
	
}
