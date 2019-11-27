package db_ep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import models.artigoDeAnaisDeConferencias;

// INTO TO 
public class BdArtigoDeAnaisDeConferencias {
	static connBd bd = new connBd();
	static Connection conn;

	public BdArtigoDeAnaisDeConferencias() throws SQLException {
		this.conn = connBd.getConnection();
	}

	public void postLivro() {
		System.out.println("INSERCAO DE ARTIGOS DE ANAIS DE CONFERENCIA\n\n");

		Scanner key = new Scanner(System.in);

		System.out.println("Inserção de Artigo de Anais de Conferencia\n >");

		System.out.println("Digite o Titulo do Artigo\n >");
		String tituloDoArtigo = key.nextLine();

		System.out.println("Digite o Titulo do Livro\n >");
        String tituloDoLivro = key.nextLine();
        
		System.out.println("Digite o Titulo do Congresso\n >");
		String tituloDoCongresso = key.nextLine();

		System.out.println("Digite a pagina inicial \n >");
		int paginaInicial = key.nextInt();

		System.out.println("Digite a pagina final\n >");
		int paginaFinal = key.nextInt();

		System.out.println("Digite o numero do volume\n >");
        int volume = key.nextInt();
        
        System.out.println("Digite o numero \n >");
		int numero = key.nextInt();

		System.out.println("Digite a editora\n >");
		String editora = key.nextLine();

		System.out.println("Digite o ano de publicação\n >");
		int anoPublicacao = key.nextInt();

		System.out.println("Digite o mes de publicação\n >");
		int mesPublicacao = key.nextInt();

		System.out.println("Digite o nome dos autores do Artigo\n >");
		String autoresArtigo = key.nextLine();

		System.out.println("Digite o ID de Localização da Publicação\n >");
		int idLocPub = key.nextInt();

		System.out.println("Digite o Titulo da Publicação\n >");
		String tituloPub = key.nextLine();

		key.close();
		// FALTA DAQUI PRA BAIXO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		String sql = "INSERT INTO artigo_de_periodico (titulo_do_artigo, titulo_pub, titulo_do_periodico, pagina_inicial, pagina_final, numero_do_volume, editora, ano_de_publicacao, autores_do_artigo, editores_do_artigo, IdLocPub)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			// arrumar aqui
            stmt.setString(1, tituloDoArtigo);
            stmt.setString(2, tituloDoLivro);
            stmt.setString(3, tituloDoCongresso);
            stmt.setString(4, editora);
            stmt.setString(5, autores);
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

		} catch (SQLException e) {
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

			while (rs.next()) {
				artigoLivro a = new artigoDeLivro();
				a.setTituloArtigo((rs.getString("titulo_do_artigo")));
                a.setTituloLivro(rs.getString("titulo_do_livro"));
				a.setTituloCongresso(rs.getString("titulo_do_congresso"));                
				a.setPaginaInicial(rs.getInt("pagina_inicial"));
				a.setPaginaFinal(rs.getInt("pagina_final"));
                a.setVolume(rs.getInt("numero_do_volume"));
				a.setNumero(rs.getInt("numero"));                
				a.setEditora(rs.getString("editora"));
				a.setAno(rs.getInt("ano"));
				a.setMes(rs.getInt("mes"));
				a.setAutores(rs.getString("autores_do_artigo"));
				a.setIdLocPub(rs.getInt("IdLocPub"));
				a.setTituloPub(rs.getInt("titulo_pub"));

				lista.add(l);

				rs.close();
				stmt.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// LISTAR OS OBJETOS DO LIST<LIST>
		while (lista.next()) {// LISTAR OS REGISTROS DE LIVRO
			System.out.println("Título do Artigo: " + next.getTituloArtigo());
            System.out.println("Título do Livro: " + next.getTituloPeriodico());
            System.out.println("Título do Congresso: " + next.getTituloCongresso());
			System.out.println("Página inicial: " + next.getPaginaInicial());
			System.out.println("Página Final: " + next.getPaginaFinal());
            System.out.println("Numero do volume: " + next.getVolume());
            System.out.println("Numero: " + next.getNumero());
			System.out.println("Editora: " + next.getEditora());
			System.out.println("Mes : " + next.getMes());
			System.out.println("Ano : " + next.getAno());
			System.out.println("Autores: " + next.getAutores());
			System.out.println("Id Local de publicação: " + next.getIdLocPub());
			System.out.println("Título de publicação: " + next.getTituloPub() + "\n \n");

		}
	}

	// UPDATE
	public void alterarLivro() {
		// PENSAR A FUNCAO DE ALTERACAO //
	}

	// DELETE
	public void removeLivro() throws SQLException {
		Scanner key = new Scanner(System.in);
		System.out.println("REMOCAO DE ARTIGOS DE ANAIS DE CONFERENCIA\n");

		System.out.println("Digite o Titulo do Artigo\n >");
		String remocaotituloDoLivro = key.nextLine();

		String sql = "DELETE FROM artigo_de_anais_de_conferencia WHERE artigo_de_anais_de_conferencia = " + remocaotituloDoLivro + ";";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.execute();
		stmt.close();
		key.close();
	}
}
