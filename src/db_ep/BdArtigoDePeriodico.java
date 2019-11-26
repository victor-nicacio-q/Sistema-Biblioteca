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
		System.out.println("INSERCAO DE ARTIGOS DE PERIODICO\n\n");
		
		Scanner key = new Scanner(System.in);
		 
		System.out.println("Inserção de Artigo\n >");
		
		System.out.println("Digite o Titulo do Artigo\n >");
        String tituloDoArtigo = key.nextLine();

        System.out.println("Digite o Titulo do Artigo\n >");
		String tituloDoPeriodico = key.nextLine();
			
		System.out.println("Digite a pagina inicial \n >");
		int paginaInicial = key.nextInt();
		
		System.out.println("Digite a pagina final\n >");
		int paginaFinal = key.nextInt();
		
		System.out.println("Digite o numero do volume\n >");
		int volume = key.nextInt();
		
		System.out.println("Digite a editora\n >");
		String editora = key.nextLine();
		
		System.out.println("Digite o ano de publicação\n >");
        int anoPublicacao = key.nextInt();

        System.out.println("Digite o mes de publicação\n >");
        int mesPublicacao = key.nextInt();
		
		System.out.println("Digite o nome dos autores do Artigo\n >");
		String autoresArtigo = key.nextLine();
		
		System.out.println("Digite o nome dos editores do Artigo\n >");
        String editoresArtigo = key.nextLine();
        
        System.out.println("Digite o ID de Localização da Publicação\n >");
		int idLocPub = key.nextInt();
		
		System.out.println("Digite o Titulo da Publicação\n >");
		String tituloPub = key.nextLine();
		
        key.close();
        //FALTA DAQUI PRA BAIXO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
        String sql = "INSERT INTO artigo_de_periodico (titulo_do_artigo, titulo_pub, titulo_do_periodico, pagina_inicial, pagina_final, numero_do_volume, editora, ano_de_publicacao, autores_do_artigo, editores_do_artigo, IdLocPub)" +"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try{
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			//arrumar aqui
            stmt.setString(1, tituloDoArtigo);
			stmt.setString(2, tituloPub);            
			stmt.setString(3, tituloDoPeriodico);
			stmt.setInt(4, paginaInicial);
			stmt.setInt(5, paginaFinal);
			stmt.setInt(6, volume);
			stmt.setString(7, editora);
			stmt.setInt(8, anoPublicacao);
			stmt.setString(9, autoresArtigo);
			stmt.setString(10, editoresArtigo);
			stmt.setInt(11, idLocPub);
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// SELECT ARTIGOS DE LIVRO
	public static List<livro> listarARTIGOS() throws SQLException {
		System.out.println("LISTA DE ARTIGOS DE PERIODICO\n");
		
		String sql = "SELECT * FROM artigo_de_periodico;";
		
		List<livro> lista = new ArrayList<>();
		
		try {
			conn = bd.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				artigoLivro a = new artigoDeLivro();
                //ARRUMAR AQUI >>>>>>>>>>>>>>>>>>>>>>
				a.setTituloArtigo((rs.getString("titulo_do_artigo")));
				a.setTituloPeriodico(rs.getString("titulo_do_periodico"));
				a.setPaginaInicial(rs.getInt("pagina_inicial"));
				a.setPaginaFinal(rs.getInt("pagina_final"));
				a.setCapitulo(rs.getInt("capitulo"));
				a.setEditora(rs.getString("editora"));
				a.setAnoPublicacao(rs.getInt("ano_de_publicacao"));
				a.setTituloOriginal(rs.getString("titulo_original"));
				a.setAutoresArtigo(rs.getString("autores_do_artigo"));
				a.setEditoresArtigo(rs.getString("editores_do_artigo"));
				a.setIdLocPub(rs.getInt("IdLocPub"));
				a.setTituloPub(rs.getInt("titulo_pub"));
								
				lista.add(l);
				
				rs.close();
				stmt.close();
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		while(lista.next()){// LISTAR OS REGISTROS DE LIVRO
			System.out.println("Título do Artigo: " + next.getTituloArtigo());
			System.out.println("Título do Livro: " + next.getTituloLivro());
			System.out.println("Página inicial: " + next.getPaginaInicial());			
			System.out.println("Página Final: " + next.getPaginaFinal());	
			System.out.println("capítulo: " + next.getCapitulo());			
			System.out.println("Editora: " + next.getEditora());
			System.out.println("Ano de publicação: " + next.getAnoPublicacao());
			System.out.println("Autores: " + next.getAutoresArtigo());
			System.out.println("Editores: " + next.getEditoresArtigo());			
			System.out.println("Título original: " + next.getTituloOriginal());
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
		
		System.out.println("Digite o Titulo do Artigo\n >");
		String remocaotituloDoLivro = key.nextLine();
		
		String sql = "DELETE FROM artigo_de_livro WHERE titulo_do_artigo = " + remocaotituloDoLivro + ";";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.execute();
		stmt.close();
		key.close();
	}
}
