package db_ep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.*;
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
		String sql = "INSERT INTO artigo_de_periodico (titulo_do_artigo, titulo_do_livro, titulo_do_congresso, editora, autores, ano_de_publicacao, mes, volume, numero, pagina_inicial, pagina_final, idLocPub, tituloPub)"
				+ "VALUES (" + tituloDoArtigo + ", " 
				+ tituloDoLivro + ", " 
				+ tituloDoCongresso + ", " 
				+ editora + ", " 
				+ autores + ", "
				+ anoPublicacao + ", " 
				+ mes + ", "
				+ volume + ", "
				+ numero + ", "
				+ paginaInicial + ", "
				+ paginaFinal + ", "
				+ editoresArtigo + ", "
				+ idLocPub + ", "
				+ tituloPub + "); ";

		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, tituloDoArtigo);
            stmt.setString(2, tituloDoLivro);
            stmt.setString(3, tituloDoCongresso);
            stmt.setString(4, editora);
            stmt.setString(5, autores);
            stmt.setInt(6, anoPublicacao);
            stmt.setInt(7, mesPublicacao);
            stmt.setInt(8, volume);
            stmt.setInt(9, numero);
            stmt.setInt(10, paginaInicial);
            stmt.setInt(11, paginaFinal);
            stmt.setInt(12, idLocPub);
			stmt.setString(13, tituloPub);            

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// SELECT ARTIGOS DE LIVRO
	public static List<livro> listarARTIGOS() throws SQLException {
		System.out.println("LISTA DE ARTIGOS DE ANAL DE CONFERENCIA\n");

		String sql = "SELECT * FROM artigo_de_anal_de_conferencia;";

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
				a.setEditora(rs.getString("editora"));
				a.setAutores(rs.getString("autores"));
				a.setAno(rs.getInt("ano_de_publicacao"));
                a.setMes(rs.getInt("mes"));
                a.setVolume(rs.getInt("volume"));                
				a.setNumero(rs.getInt("numero"));                
				a.setPaginaInicial(rs.getInt("pagina_inicial"));
				a.setPaginaFinal(rs.getInt("pagina_final"));
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
	public void alterarArtigoDeAnaisDeConferencia() {
		Scanner key = new Scanner(System.in);
		String tituloDoArtigo;
		String tituloDoLivro;
		String tituloDoCongresso;
		String colunasEscolhidas;
		String[] colunas;
		String atributo;
		String sql = "UPDATE FROM artigo_de_anal_de_conferencia";
		artigoDeAnalDeConferencia a;
		boolean[] opcoes = new boolean[13];
		int contaVirgulas;
		
		System.out.println("ALTERACAO DE ARTIGOS DE ANAIS DE CONFERENCIA\n");	
		System.out.println("Insira a chave da tupla que deseja alterar: ");
		System.out.println("titulo_do_artigo");
		tituloDoArtigo = key.nextLine();
		System.out.println("titulo_do_livro");
		tituloDoLivro = key.nextLine();
		System.out.println("titulo_do_congresso");
		tituloDoCongresso = key.nextLine();
		
		a = selectArtigoChave(tituloDoArtigo, tituloDoLivro, tituloDoCongresso);
		
		exibirArtigoDeAnalDeConferencia(a);
	
		System.out.println("Qual(is) dos seguintes atributos sera(o) alterado(s)? (entrar apenas com o(s) numero(s) da(s) coluna(s) separado(s) por virgula");
		System.out.println();
		System.out.println("#1 titulo_do_artigo");
		System.out.println("#2 titulo_do_livro");
		System.out.println("#3 titulo_do_congresso");
		System.out.println("#4 editora");
		System.out.println("#5 autores");
		System.out.println("#6 pagina_inicial");
		System.out.println("#7 pagina_final");
		System.out.println("#8 volume");
		System.out.println("#9 numero");
		System.out.println("#10 pagina_inicial");
		System.out.println("#11 pagina_final");
		System.out.println("#12 idLocPub");
		System.out.println("#13 tituloPub");
		System.out.println();
		
		colunasEscolhidas = key.nextLine();
		colunas = colunasEscolhidas.split(",[ ]*");
		contaVirgulas = colunas.length;

		for (String atributo : colunas)
			opcoes[Integer.parseInt(atributo) - 1] = true;
		
		for (int i = 0; i < opcoes.length; i++){
			if (opcoes[i] == true){
				System.out.println("Qual o conteudo a ser alterado na coluna " + (i + 1) + "?");
				
				atributo = key.nextLine();
	
				switch(i){
					case 0: sql = sql + " SET titulo_do_artigo = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 1: sql = sql + " SET titulo_do_livro = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 2: sql = sql + " SET titulo_do_congresso = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 3: sql = sql + " SET editora = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 4: sql = sql + " SET autores = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 5: sql = sql + " pagina_inicial = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 6: sql = sql + " SET pagina_final = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 7: sql = sql + " SET volume = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 8: sql = sql + " SET numero = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 9: sql = sql + " SET mes = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 10: sql = sql + " SET ano = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 11: sql = sql + " SET idLocPub = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case default: sql = sql + " SET tituloPub = " + atributo;
				}
			}
		}
		
		sql = sql + " WHERE titulo_do_artigo = " + a.getTituloArtigo()
					+ "AND titulo_do_livro = " + a.getTituloPub()
					+ "AND titulo_do_congresso = " + a.getTituloPeriodico() + "; ";
					
		try {
			conn = bd.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.executeQuery();
			stmt.close();
			System.out.println("Atualizacao realizada com sucesso");
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
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
	
	//SELECT TUPLA ESPECIFICA PELA CHAVE
	public static artigoDeAnaisDeConferencia selectArtigoChave(String tituloDoArtigo, String tituloDoLivro, String tituloDoCongresso){
		String sql = "SELECT * FROM artigo_de_anais_de_conferencia"
					+ "WHERE titulo_do_artigo = tituloDoArtigo"
					+ "AND titulo_do_livro = tituloDoLivro"
					+ "AND titulo_do_congresso = tituloDoCongresso;";

		artigoDeAnaisDeConferencia a = new artigoDeAnaisDeConferencia();

		try {
			conn = bd.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			a.setTituloArtigo((rs.getString("titulo_do_artigo")));
			a.setTituloLivro(rs.getString("titulo_do_livro"));
			a.setTituloCongresso(rs.getString("titulo_do_congresso"));                
			a.setEditora(rs.getString("editora"));
			a.setAutores(rs.getString("autores"));
			a.setAno(rs.getInt("ano_de_publicacao"));
			a.setMes(rs.getInt("mes"));
			a.setVolume(rs.getInt("volume"));                
			a.setNumero(rs.getInt("numero"));                
			a.setPaginaInicial(rs.getInt("pagina_inicial"));
			a.setPaginaFinal(rs.getInt("pagina_final"));
			a.setIdLocPub(rs.getInt("IdLocPub"));
			a.setTituloPub(rs.getInt("titulo_pub"));

			rs.close();
			stmt.close();

			return a;
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//EXIBE TODAS AS TUPLAS DE UM DETERMINADO ARTIGO DE PERIODICO
	public static void exibirArtigoDeAnalDeConferencia(artigoDeAnalDeConferencia a){
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
	
	//CONTROLA A QUANTIDADE DE VIRGULAS DOS ARGUMENTOS DO UPDATE
	public static void controlaVirgulas(int contaVirgulas, String argumentos){
		contaVirgulas--;
		if (contaVirgulas > 0)
			argumentos = argumentos + ",";
	}
}
