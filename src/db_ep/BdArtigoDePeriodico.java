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
import models.*;

// INTO TO 
public class BdArtigoDePeriodico {
	static connBd bd = new connBd();
	static Connection conn;

	public BdArtigoDePeriodico() throws SQLException {
		this.conn = connBd.getConnection();
	}

	public static void postArtigoDePeriodico() {
		System.out.println("INSERCAO DE ARTIGOS DE PERIODICO\n\n");

		Scanner key = new Scanner(System.in);

		System.out.println("Inserção de Artigo\n >");

		System.out.println("Digite o Titulo do Artigo\n >");
		String tituloDoArtigo = key.nextLine();

		System.out.println("Digite o Titulo da Publicacao\n >");
		String tituloPub = key.nextLine();
		
		System.out.println("Digite o Titulo do Periodico\n >");
		String tituloDoPeriodico = key.nextLine();

		System.out.println("Digite a pagina inicial \n >");
		int paginaInicial = key.nextInt();

		System.out.println("Digite a pagina final\n >");
		int paginaFinal = key.nextInt();

		System.out.println("Digite o numero do volume\n >");
		int volume = key.nextInt();

		System.out.println("Digite a editora\n >");
		String editora = key.nextLine();

		System.out.println("Digite o ano de publicacao\n >");
		int anoPublicacao = key.nextInt();

		System.out.println("Digite o mes de publicacao\n >");
		int mesPublicacao = key.nextInt();

		System.out.println("Digite o nome dos autores do Artigo\n >");
		String autoresArtigo = key.nextLine();

		System.out.println("Digite o nome dos editores do Artigo\n >");
		String editoresArtigo = key.nextLine();

		System.out.println("Digite o ID de Localizacao da Publicacao\n >");
		int idLocPub = key.nextInt();

		key.close();
	
		String sql = "INSERT INTO artigo_de_periodico (titulo_do_artigo, titulo_pub, titulo_do_periodico, pagina_inicial, pagina_final, numero_do_volume, editora, ano_de_publicacao, mes_de_publicacao, autores_do_artigo, editores_do_artigo, IdLocPub)"
				+ "VALUES (" + tituloDoArtigo + ", " 
				+ tituloPub + ", " 
				+ tituloDoPeriodico + ", " 
				+ paginaInicial + ", " 
				+ paginaFinal + ", " 
				+ volume + ", " 
				+ editora + ", " 
				+ anoPublicacao + ", " 
				+ mesPublicacao + ", "
				+ autoresArtigo + ", "
				+ editoresArtigo + ", "
				+ idLocPub + "); ";

		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			// arrumar aqui
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

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// SELECT ARTIGOS DE LIVRO
	public static void listarArtigosDePeriodicos() throws SQLException {
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
				a.setTituloPeriodico(rs.getString("titulo_do_periodico"));
				a.setPaginaInicial(rs.getInt("pagina_inicial"));
				a.setPaginaFinal(rs.getInt("pagina_final"));
				a.setnVolume(rs.getInt("numero_do_volume"));
				a.setEditora(rs.getString("editora"));
				a.setAno(rs.getInt("ano"));
				a.setMes(rs.getInt("mes"));
				a.setAutores(rs.getString("autores_do_artigo"));
				a.setEditores(rs.getString("editores_do_artigo"));
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
			System.out.println("Título do Periodico: " + next.getTituloPeriodico());
			System.out.println("Página inicial: " + next.getPaginaInicial());
			System.out.println("Página Final: " + next.getPaginaFinal());
			System.out.println("Numero do volume: " + next.getnVolume());
			System.out.println("Editora: " + next.getEditora());
			System.out.println("Mes : " + next.getMes());
			System.out.println("Ano : " + next.getAno());
			System.out.println("Autores: " + next.getAutores());
			System.out.println("Editores: " + next.getEditores());
			System.out.println("Id Local de publicação: " + next.getIdLocPub());
			System.out.println("Título de publicação: " + next.getTituloPub() + "\n \n");

		}
	}

	// UPDATE
	public static void alterarArtigoDePeriodico() {
		Scanner key = new Scanner(System.in);
		String tituloDoArtigo;
		String tituloPub;
		String tituloDoPeriodico;
		String colunasEscolhidas;
		String[] colunas;
		String atributo;
		String sql = "UPDATE FROM artigo_de_periodico";
		artigoDePeriodico a;
		boolean[] opcoes = new boolean[12];
		int contaVirgulas;
		
		System.out.println("ALTERACAO DE ARTIGOS DE PERIODICO\n");	
		System.out.println("Insira a chave da tupla que deseja alterar: ");
		System.out.println("titulo_do_artigo");
		tituloDoArtigo = key.nextLine();
		System.out.println("titulo_pub");
		tituloPub = key.nextLine();
		System.out.println("titulo_do_periodico");
		tituloDoPeriodico = key.nextLine();
		
		a = selectArtigoChave(tituloDoArtigo, tituloPub, tituloDoPeriodico);
		
		exibirArtigoDePeriodico(a);
		
		System.out.println("Qual(is) dos seguintes atributos sera(o) alterado(s)? (entrar apenas com o(s) numero(s) da(s) coluna(s) separado(s) por virgula");
		System.out.println();
		System.out.println("#1 titulo_do_artigo");
		System.out.println("#2 titulo_pub");
		System.out.println("#3 titulo_do_periodico");
		System.out.println("#4 pagina_inicial");
		System.out.println("#5 pagina_final");
		System.out.println("#6 numero_do_volume");
		System.out.println("#7 editora");
		System.out.println("#8 ano_de_publicacao");
		System.out.println("#9 mes_de_publicacao");
		System.out.println("#10 autores_do_artigo");
		System.out.println("#11 editores_do_artigo");
		System.out.println("#12 idLocPub");
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
							break;
					case 1: sql = sql + " SET titulo_pub = " + atributo;
							break;
					case 2: sql = sql + " SET titulo_do_periodico = " + atributo;
							break;
					case 3: sql = sql + " SET pagina_inicial = " + Integer.parseInt(atributo);
							break;
					case 4: sql = sql + " SET pagina_final = " + Integer.parseInt(atributo);
							break;
					case 5: sql = sql + " SET numero_do_volume = " + Integer.parseInt(atributo);
							break;
					case 6: sql = sql + " SET editora = " + atributo;
							break;
					case 7: sql = sql + " SET ano_de_publicacao = " + Integer.parseInt(atributo);
							break;
					case 8: sql = sql + " SET mes_de_publicacao = " + Integer.parseInt(atributo);
							break;
					case 9: sql = sql + " SET autores_do_artigo = " + atributo;
							break;
					case 10: sql = sql + " SET editores_do_artigo = " + atributo;
							break;
					default: sql = sql + " SET idLocPub = " + Integer.parseInt(atributo);
				}
				contaVirgulas = controlaVirgulas(contaVirgulas, sql);
			}
		}
		
		sql = sql + " WHERE titulo_do_artigo = " + a.getTituloArtigo()
					+ "AND titulo_pub = " + a.getTituloPub()
					+ "AND titulo_do_periodico = " + a.getTituloPeriodico() + "; ";
					
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
	public static void removeArtigoDePeriodico() throws SQLException {
		Scanner key = new Scanner(System.in);
		System.out.println("REMOCAO DE ARTIGOS\n");

		System.out.println("Digite o Titulo do Artigo\n >");
		String remocaotituloDoLivro = key.nextLine();

		String sql = "DELETE FROM artigo_de_periodico WHERE titulo_do_artigo = " + remocaotituloDoLivro + ";";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.execute();
		stmt.close();
		key.close();
	}
	
	//SELECT TUPLA ESPECIFICA PELA CHAVE
	public static artigoDePeriodico selectArtigoChave(String tituloDoArtigo, String tituloPub, String tituloDoPeriodico){
		String sql = "SELECT * FROM artigo_de_periodico"
					+ "WHERE titulo_do_artigo = tituloDoArtigo"
					+ "AND titulo_pub = tituloPub"
					+ "AND titulo_do_periodico = tituloDoPeriodico;";

		artigoDePeriodico a = new artigoDePeriodico();

		try {
			conn = bd.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			a.setTituloArtigo((rs.getString("titulo_do_artigo")));
			a.setTituloPeriodico(rs.getString("titulo_do_periodico"));
			a.setPaginaInicial(rs.getInt("pagina_inicial"));
			a.setPaginaFinal(rs.getInt("pagina_final"));
			a.setnVolume(rs.getInt("numero_do_volume"));
			a.setEditora(rs.getString("editora"));
			a.setAno(rs.getInt("ano"));
			a.setMes(rs.getInt("mes"));
			a.setAutores(rs.getString("autores_do_artigo"));
			a.setEditores(rs.getString("editores_do_artigo"));
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
	public static void exibirArtigoDePeriodico(artigoDePeriodico a){
		System.out.println("Título do Artigo: " + a.getTituloArtigo());
		System.out.println("Título de publicação: " + a.getTituloPub());
		System.out.println("Título do Periodico: " + a.getTituloPeriodico());
		System.out.println("Página inicial: " + a.getPaginaInicial());
		System.out.println("Página Final: " + a.getPaginaFinal());
		System.out.println("Numero do volume: " + a.getnVolume());
		System.out.println("Editora: " + a.getEditora());
		System.out.println("Mes : " + a.getMes());
		System.out.println("Ano : " + a.getAno());
		System.out.println("Autores: " + a.getAutores());
		System.out.println("Editores: " + a.getEditores());
		System.out.println("Id Local de publicação: " + a.getIdLocPub());
		System.out.println();
	}
	
	//CONTROLA A QUANTIDADE DE VIRGULAS DOS ARGUMENTOS DO UPDATE
	public static int controlaVirgulas(int contaVirgulas, String argumentos){
		contaVirgulas--;
		if (contaVirgulas > 0)
			argumentos = argumentos + ",";
		
		return contaVirgulas;
	}
}
