package db_ep;

import java.sql.*;

public class teste_bd {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/db_ep", "root", "root");
			Statement meuState = conn.createStatement();
			System.out.print(meuState);
			ResultSet meuResult = meuState.executeQuery("select * from `teste`.`user`");
		}catch(Exception exc) {
			exc.printStackTrace();
		}
		
	}
	
}
