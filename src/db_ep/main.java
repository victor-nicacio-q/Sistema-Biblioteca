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
	
	public static void inserirLivro() {
		Scanner key = new Scanner(System.in);
		
		System.out.println("Inserção de Livro\n");
		
		System.out.println("Digite o Titulo do Livro\n");
		String tituloDoLivro = key.nextLine();
		
		System.out.println("Digite o Tipo do Livro\n");
		String tipo = key.nextLine();
		
		System.out.println("Digite a Editora do Livro\n");
		String editora = key.nextLine();
		
		System.out.println("Digite a Edicao do Livro\n");
		int edicao = key.nextInt();
		
		System.out.println("Digite o Ano de Publicacao do Livro\n");
		int anoPublicacao = key.nextInt();
		
		System.out.println("Digite os Autores/Editores do Livro\n");
		String autoresEditores = key.nextLine();
		
		System.out.println("Digite o Titulo Original do Livro\n");
		String tituloOriginal = key.nextLine();
		
		System.out.println("Digite o Numero de Paginas do Livro\n");
		int nPaginas = key.nextInt();
		
		key.close();
		//post();
	}
	
	public static void inserirArtigo() {
		System.out.println("Inserção de Artigo");
		// REPLICAR DE LIVRO //
	}
	public static void inserirMonografia() {
		System.out.println("Inserção de Monografia");
		// REPLICAR DE LIVRO //
	}
	
	public static void listarLivros() throws SQLException {
		String sql = "SELECT * FROM livros;";
		
		connBd bd = new connBd();
		Connection conn = bd.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			stmt.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void post(Object ob) {
		//FAZER O POST NO BANCO
	}

	public static void main(String[] args) throws SQLException {
		int op;
		Scanner entrada = new Scanner(System.in);
		
		do {
			menu();
			op = entrada.nextInt();
			
			switch(op) {
			case 1:
				inserirLivro();
				break;
			
			case 2:
				inserirArtigo();
				break;
				
			case 3:
				inserirMonografia();
				break;
				
			case 4:
				listarLivros();
				break;
				
			default:
				System.out.println("Entrada Inválida");
			}
			
		}while(op != 0);
		entrada.close();
	}

}
