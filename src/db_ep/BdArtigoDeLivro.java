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
public class BdArtigoDeLivro {
	static connBd bd = new connBd();
	static Connection conn;
	
	public BdArtigoDeLivro() throws SQLException{
		this.conn = connBd.getConnection();
	}
	
	public static void postArtigoDeLivro() {		
		System.out.println("INSERCAO DE ARTIGO DE LIVRO\n\n");
		
		Scanner key = new Scanner(System.in);
		 
		System.out.println("Inserção de Artigo\n >");
		
		System.out.println("Digite o Titulo do Artigo\n >");
		String tituloDoArtigo = key.nextLine();
		
		System.out.println("Digite o Titulo do Livro\n >");
		String tituloDoLivro = key.nextLine();
		
		System.out.println("Digite a pagina inicial \n >");
		int paginaInicial = key.nextInt();
		
		System.out.println("Digite a pagina final\n >");
		int paginaFinal = key.nextInt();
		
		System.out.println("Digite o capitulo do Artigo no Livro\n >");
		int capitulo = key.nextInt();
		
		System.out.println("Digite a editora\n >");
		String editora = key.nextLine();
		
		System.out.println("Digite o ano de publicação\n >");
        int anoPublicacao = key.nextInt();
        
        System.out.println("Digite o Titulo Original do Artigo\n >");
		String tituloOriginal = key.nextLine();
		
		System.out.println("Digite o nome dos autores do Artigo\n >");
		String autoresArtigo = key.nextLine();
		
		System.out.println("Digite o nome dos editores do Artigo\n >");
        String editoresArtigo = key.nextLine();
        
        System.out.println("Digite o ID de Localização da Publicação\n >");
		int idLocPub = key.nextInt();
		
		System.out.println("Digite o Titulo da Publicação\n >");
		String tituloPub = key.nextLine();
		
        key.close();
		
		String sql = "INSERT INTO artigo_de_livro (titulo_do_artigo, titulo_pub, titulo_do_livro, pagina_inicial, pagina_final, capitulo, editora, ano_de_publicacao, titulo_original, autores_do_artigo, editores_do_artigo, IdLocPub)"
					+ "VALUES (" + tituloDoArtigo + ", " 
					+ tituloPub + ", " 
					+ tituloDoLivro + ", " 
					+ paginaInicial + ", " 
					+ paginaFinal + ", " 
					+ capitulo + ", " 
					+ editora + ", " 
					+ anoPublicacao + ", " 
					+ tituloOriginal + ", "
					+ autoresArtigo + ", "
					+ editoresArtigo + ", "
					+ idLocPub + "); ";
		
		try{
			PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, tituloDoArtigo);
			stmt.setString(2, tituloPub);            
			stmt.setString(3, tituloDoLivro);
			stmt.setInt(4, paginaInicial);
			stmt.setInt(5, paginaFinal);
			stmt.setInt(6, capitulo);
			stmt.setString(7, editora);
			stmt.setInt(8, anoPublicacao);
			stmt.setString(9, tituloOriginal);
			stmt.setString(10, autoresArtigo);
			stmt.setString(11, editoresArtigo);
			stmt.setInt(12, idLocPub);
			
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// SELECT ARTIGOS DE LIVRO
	public static void listarArtigoDeLivro() throws SQLException {
		System.out.println("LISTA DE ARTIGOS DE LIVRO\n");
		
		String sql = "SELECT * FROM artigo_de_livro;";
		
		List<artigoDeLivro> lista = new ArrayList<>();
		artigoDeLivro a;
		
		try {
			conn = bd.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				a = new artigoDeLivro();
				
				a.setTituloDoArtigo((rs.getString("titulo_do_artigo")));
				a.setTituloDoLivro(rs.getString("titulo_do_livro"));
				a.setPaginaInicial(rs.getInt("pagina_inicial"));
				a.setPaginaFinal(rs.getInt("pagina_final"));
				a.setCapitulo(rs.getInt("capitulo"));
				a.setEditora(rs.getString("editora"));
				a.setAnoPublicacao(rs.getInt("ano_de_publicacao"));
				a.setTituloOriginal(rs.getString("titulo_original"));
				a.setAutoresArtigo(rs.getString("autores_do_artigo"));
				a.setEditoresArtigo(rs.getString("editores_do_artigo"));
				a.setIdLocPub(rs.getInt("IdLocPub"));
				a.setTituloPub(rs.getString("titulo_pub"));
								
				lista.add(l);
				
				rs.close();
				stmt.close();
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		
		Iterator<artigoDeLivro> it = lista.iterator();
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		while(it.hasNext()){
			a = it.next();
			System.out.println("Título do Artigo: " + a.getTituloArtigo());
			System.out.println("Título do Livro: " + a.getTituloLivro());
			System.out.println("Página inicial: " + a.getPaginaInicial());			
			System.out.println("Página Final: " + a.getPaginaFinal());	
			System.out.println("capítulo: " + a.getCapitulo());			
			System.out.println("Editora: " + a.getEditora());
			System.out.println("Ano de publicação: " + a.getAnoPublicacao());
			System.out.println("Autores: " + a.getAutoresArtigo());
			System.out.println("Editores: " + a.getEditoresArtigo());			
			System.out.println("Título original: " + a.getTituloOriginal());
			System.out.println("Id Local de publicação: " + a.getIdLocPub());
			System.out.println("Título de publicação: " + a.getTituloPub() + "\n \n");

		}
	}

	// UPDATE
	public static void alterarArtigoDeLivro() {
		Scanner key = new Scanner(System.in);
		String tituloDoArtigo;
		String tituloPub;
		String tituloDoLivro;
		String colunasEscolhidas;
		String[] colunas;
		String atributo;
		String sql = "UPDATE FROM artigo_de_livro";
		artigoDeLivro a;
		boolean[] opcoes = new boolean[12];
		int contaVirgulas;
		
		System.out.println("ALTERACAO DE ARTIGOS DE LIVRO\n");	
		System.out.println("Insira a chave da tupla que deseja alterar: ");
		System.out.println("titulo_do_artigo");
		tituloDoArtigo = key.nextLine();
		System.out.println("titulo_pub");
		tituloPub = key.nextLine();
		System.out.println("titulo_do_livro");
		tituloDoLivro = key.nextLine();
		
		a = selectArtigoChave(tituloDoArtigo, tituloPub, tituloDoLivro);
		
		exibirArtigoDeLivro(a);
		
		System.out.println("Qual(is) dos seguintes atributos sera(o) alterado(s)? (entrar apenas com o(s) numero(s) da(s) coluna(s) separado(s) por virgula");
		System.out.println();
		System.out.println("#1 titulo_do_artigo");
		System.out.println("#2 titulo_pub");
		System.out.println("#3 titulo_do_livro");
		System.out.println("#4 pagina_inicial");
		System.out.println("#5 pagina_final");
		System.out.println("#6 capitulo");
		System.out.println("#7 editora");
		System.out.println("#8 ano_de_publicacao");
		System.out.println("#9 titulo_original");
		System.out.println("#10 autores_do_artigo");
		System.out.println("#11 editores_do_artigo");
		System.out.println("#12 idLocPub");
		System.out.println();
		
		colunasEscolhidas = key.nextLine();
		colunas = colunasEscolhidas.split(",[ ]*");
		contaVirgulas = colunas.length;

		for (String conteudo : colunas)
			opcoes[Integer.parseInt(conteudo) - 1] = true;
		
		for (int i = 0; i < opcoes.length; i++){
			if (opcoes[i] == true){
				System.out.println("Qual o conteudo a ser alterado na coluna " + (i + 1) + "?");
				
				atributo = key.nextLine();
				
				switch(i){
					case 0: sql = sql + " SET titulo_do_artigo = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 1: sql = sql + " SET titulo_pub = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 2: sql = sql + " SET titulo_do_livro = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 3: sql = sql + " SET pagina_inicial = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 4: sql = sql + " SET pagina_final = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 5: sql = sql + " SET capitulo = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 6: sql = sql + " SET editora = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 7: sql = sql + " SET ano_de_publicacao = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 8: sql = sql + " SET titulo_original = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 9: sql = sql + " SET autores_do_artigo = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 10: sql = sql + " SET editores_do_artigo = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					default: sql = sql + " SET idLocPub = " + Integer.parseInt(atributo);
				}
			}
		}
		
		sql = sql + " WHERE titulo_do_artigo = " + a.getTituloArtigo()
					+ "AND titulo_pub = " + a.getTituloPub()
					+ "AND titulo_do_livro = " + a.getTituloLivro() + "; ";
					
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
	
	//DELETE
	public static void removeArtigoDeLivro() throws SQLException{
		Scanner key = new Scanner(System.in);
		System.out.println("REMOCAO DE ARTIGO DE LIVRO\n");
		
		System.out.println("Digite o Titulo do Artigo\n >");
		String remocaotituloDoLivro = key.nextLine();
		
		String sql = "DELETE FROM artigo_de_livro WHERE titulo_do_artigo = " + remocaotituloDoLivro + ";";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.execute();
		stmt.close();
		key.close();
	}
	
	//SELECT TUPLA ESPECIFICA PELA CHAVE
	public static artigoDeLivro selectArtigoChave(String tituloDoArtigo, String tituloPub, String tituloDoLivro){
		String sql = "SELECT * FROM artigo_de_livro"
					+ "WHERE titulo_do_artigo = tituloDoArtigo"
					+ "AND titulo_pub = tituloPub"
					+ "AND titulo_do_livro = tituloDoLivro;";

		artigoDeLivro a = new artigoDeLivro();

		try {
			conn = bd.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			a.setTituloArtigo((rs.getString("titulo_do_artigo")));
			a.setTituloLivro(rs.getString("titulo_do_livro"));
			a.setPaginaInicial(rs.getInt("pagina_inicial"));
			a.setPaginaFinal(rs.getInt("pagina_final"));
			a.setnVolume(rs.getInt("capitulo"));
			a.setEditora(rs.getString("editora"));
			a.setAnoPublicacao(rs.getInt("ano"));
			a.setAutoresArtigo(rs.getString("autores_do_artigo"));
			a.setEditoresArtigo(rs.getString("editores_do_artigo"));
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
	
	//EXIBE TODAS AS TUPLAS DE UM DETERMINADO ARTIGO DE LIVRO
	public static void exibirArtigoDeLivro(artigoDeLivro a){
		System.out.println("Título do Artigo: " + a.getTituloArtigo());
		System.out.println("Título de publicação: " + a.getTituloPub());
		System.out.println("Título do Livro: " + a.getTituloLivro());
		System.out.println("Página inicial: " + a.getPaginaInicial());
		System.out.println("Página Final: " + a.getPaginaFinal());
		System.out.println("Capitulo: " + a.getCapitulo());
		System.out.println("Editora: " + a.getEditora());
		System.out.println("Ano : " + a.getAno());
		System.out.println("Título original: " + a.getTituloOriginal());
		System.out.println("Autores: " + a.getAutores());
		System.out.println("Editores: " + a.getEditores());
		System.out.println("Id Local de publicação: " + a.getIdLocPub());
		System.out.println();
	}
	
	//CONTROLA A QUANTIDADE DE VIRGULAS DOS ARGUMENTOS DO UPDATE
	public static void controlaVirgulas(int contaVirgulas, String argumentos){
		contaVirgulas--;
		if (contaVirgulas > 0)
			argumentos = argumentos + ",";
	}
}
