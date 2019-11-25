package db_ep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import models.artigoDeLivro;


// INTO TO 
public class BdArtigoDeLivro {
	static connBd bd = new connBd();
	static Connection conn;
	
	public BdArtigoDeLivro() throws SQLException{
		this.conn = connBd.getConnection();
	}
	
	public void postLivro() {		
		System.out.println("INSERCAO DE ARTIGOS\n\n");
		
		Scanner key = new Scanner(System.in);
		 
		System.out.println("Inserção de Artigo\n >");
		
		System.out.println("Digite o Titulo do Artigo\n >");
		String tituloDoArtigo = key.nextLine();
		
		System.out.println("Digite o Titulo do Livro\n >");
		String tituloDoLivro = key.nextLine();
		
		System.out.println("Digite a pagina inicial \n >");
		String paginaInicial = key.nextInt();
		
		System.out.println("Digite a pagina final\n >");
		int paginaFinal = key.nextInt();
		
		System.out.println("Digite o capitulo do Artigo no Livro\n >");
		int capitulo = key.nextInt();
		
		System.out.println("Digite a editora\n >");
		String editora = key.nextLine();
		
		System.out.println("Digite o ano de publicação\n >");
        String anoPublicacao = key.nextInt();
        
        System.out.println("Digite o Titulo Original do Artigo\n >");
		String tituloOriginal = key.nextLine();
		
		System.out.println("Digite o nome dos autores do Artigo\n >");
		int autoresArtigo = key.nextLine();
		
		System.out.println("Digite o nome dos editores do Artigo\n >");
        int editoresArtigo = key.nextLine();
        
        System.out.println("Digite o ID de Localização da Publicação\n >");
		int idLocPub = key.nextInt();
		
		System.out.println("Digite o Titulo da Publicação\n >");
		int tituloPub = key.nextLine();
		
        key.close();
        //FALTA DAQUI PRA BAIXO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		String sql = "INSERT INTO livro (titulo_do_livro, titulo_pub, tipo, editora, n_edicao, ano_publicacao, autores_editores, titulo_orig, n_pags, IdLocPu" +
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,)";
		
		try{
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			stmt.setString(1, tituloDoLivro);
			stmt.setString(2, tipo);
			stmt.setString(3, editora);
			stmt.setInt(4, edicao);
			stmt.setInt(5, anoPublicacao);
			stmt.setString(6, autoresEditores);
			stmt.setString(7, tituloOriginal);
			stmt.setInt(8, nPaginas);
			stmt.setInt(9, idLocPub);
			stmt.setInt(10, tituloPub);
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// SELECT ARTIGOS
	public static List<livro> listarARTIGOS() throws SQLException {
		System.out.println("LISTA DE ARTIGOS\n");
		
		String sql = "SELECT * FROM livro;";
		
		List<livro> lista = new ArrayList<>();
		
		try {
			conn = bd.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				livro l = new livro();
				
				l.setTituloDoLivro(rs.getString("titulo_do_livro"));
				l.setTipo(rs.getString("tipo"));
				l.setEditora(rs.getString("editora"));
				l.setEdicao(rs.getInt("editora"));
				l.setAnoPublicacao(rs.getInt("ano_publicacao"));
				l.setAutoresEditores(rs.getString("autores_editores"));
				l.setTituloOriginal(rs.getString("titulo_original"));
				l.setnPaginas(rs.getInt("n_pags"));
				l.setIdLocPub(rs.getInt("IdLocPub"));
				l.setTituloPub(rs.getInt("titulo_pub"));
								
				lista.add(l);
				
				rs.close();
				stmt.close();
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		while(lista.next()){// LISTAR OS REGISTROS DE LIVRO
			System.out.println("Título do livro: " + next.getTituloDoLivro());
			System.out.println("Tipo: " + next.getTipo());
			System.out.println("Editora: " + next.getEditora());
			System.out.println("Edição: " + next.getEdicao());
			System.out.println("Ano de Publicação: " + next.getAnoPublicacao());
			System.out.println("Autores/Editores: " + next.getAutoresEditores());
			System.out.println("Título original: " + next.getTituloOriginal());
			System.out.println("Número de páginas: " + next.getnPags());
			System.out.println("Id Local de publicação: " + next.getIdLocPub());
			System.out.println("Título de publicação: " + next.getTituloPub() + "\n \n");

		}
	}

	// UPDATE
	public void alterarLivro() {
		// PENSAR A FUNCAO DE ALTERACAO //
	}
	
	//DELETE
	public void removeLivro() throws SQLException{
		Scanner key = new Scanner(System.in);
		System.out.println("REMOCAO DE ARTIGOS\n");
		
		System.out.println("Digite o Titulo do Livro\n >");
		String remocaotituloDoLivro = key.nextLine();
		
		String sql = "DELETE FROM livro WHERE titulo_do_livro = " + remocaotituloDoLivro + ";";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.execute();
		stmt.close();
		key.close();
	}
}
