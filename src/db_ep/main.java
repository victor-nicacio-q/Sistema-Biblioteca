package db_ep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
	
	public static void menu(){
		System.out.println("Biblioteca");
		System.out.println("1 - Inserir Livros");
		System.out.println("2 - Inserir Artigos");
		System.out.println("3 - Inserir Monografias");
		System.out.println("4 - Listar Livros");
		System.out.println("5 - Listar Artigos");
		System.out.println("6 - Listar Monografias");
		System.out.println("0 - Sair");
	}
	
	public static void main(String[] args) throws SQLException {
		int op;
		Scanner entrada = new Scanner(System.in);
		
		do {
			menu();
			op = entrada.nextInt();
			
			switch(op) {
			case 1:
				//BdLivro.postLivro();
				break;
			
			case 2:
				//BdArtigo.postArtigo();
				break;
				
			case 3:
				//BdMonografia.postMonografia();
				break;
				
			case 4:
				BdLivro.listarLivros();
				break;
				
			default:
				System.out.println("Entrada Inválida");
			}
			
		}while(op != 0);
		entrada.close();
	}

}
