package db_ep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.livro;

public class BdLivro {
	private connBd bd = new connBd();
	private Connection conn;
	
	public BdLivro() throws SQLException{
		this.conn = connBd.getConnection();
	}
	
	public void postLivro() {		
		Scanner key = new Scanner(System.in);
		 
		System.out.println("Inserção de Livro\n >");
		
		System.out.println("Digite o Titulo do Livro\n >");
		String tituloDoLivro = key.nextLine();
		
		System.out.println("Digite o Tipo do Livro\n >");
		String tipo = key.nextLine();
		
		System.out.println("Digite a Editora do Livro\n >");
		String editora = key.nextLine();
		
		System.out.println("Digite a Edicao do Livro\n >");
		int edicao = key.nextInt();
		
		System.out.println("Digite o Ano de Publicacao do Livro\n >");
		int anoPublicacao = key.nextInt();
		
		System.out.println("Digite os Autores/Editores do Livro\n >");
		String autoresEditores = key.nextLine();
		
		System.out.println("Digite o Titulo Original do Livro\n >");
		String tituloOriginal = key.nextLine();
		
		System.out.println("Digite o Numero de Paginas do Livro\n >");
		int nPaginas = key.nextInt();
		
		System.out.println("Digite o ID de Localização da Publicação\n >");
		int idLocPub = key.nextInt();
		
		System.out.println("Digite o Titulo da Publicação\n >");
		int tituloPub = key.nextInt();
		
		key.close();
		
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
	
	public List<livro> listarLivros() throws SQLException {
		String sql = "SELECT * FROM livro;";
		
		List<livro> lista = new ArrayList<>();
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
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
		return lista;
	}
}
