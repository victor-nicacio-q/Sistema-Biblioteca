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
public class BdLivro {
	static connBd bd = new connBd();
	static Connection conn;
	
	public BdLivro() throws SQLException{
		this.conn = connBd.getConnection();
	}
	
	public static void postLivro() {		
		System.out.println("INSERCAO DE LIVRO\n\n");
		
		Scanner key = new Scanner(System.in);
		
		System.out.println("Digite o titulo do livro\n >");
		String tituloLivro = key.nextLine();
		
		System.out.println("Digite o titulo da publicacao\n >");
		String tituloPub = key.nextLine();
		
		System.out.println("Digite o tipo do livro\n >");
		String tipo = key.nextLine();
		
		System.out.println("Digite o nome da editora\n >");
		String editora = key.nextLine();
		
		System.out.println("Digite o numero da edicao do livro\n >");
		int numeroEdicao = key.nextInt();
		
		System.out.println("Digite o ano de publicacao do livro\n >");
		int anoPublicacao = key.nextInt();
		
		System.out.println("Digite o nomes dos autores/editores\n >");
		String autoresEditores = key.nextLine();
		
		System.out.println("Digite o titulo original do livro\n >");
		String tituloOriginal = key.nextLine();
		
		System.out.println("Digite o numero de paginas do livro\n >");
		int nPaginas = key.nextInt();
		
		System.out.println("Digite o id de localizacao do livro\n >");
		int idLocPub = key.nextInt();
		
		key.close();
		
		String sql = "INSERT INTO livro (titulo_do_livro, titulo_pub, tipo, editora, n_edicao, ano_publicacao, autores_editores, titulo_orig, n_pags, IdLocPub) " 
					+ "VALUES (" + tituloDoLivro + ", " 
					+ tituloPub + ", " 
					+ tipo + ", " 
					+ editora + ", " 
					+ numeroEdicao + ", " 
					+ anoPublicacao + ", " 
					+ autoresEditores + ", " 
					+ tituloOriginal + ", " 
					+ nPaginas + ", "
					+ idLocPub + "); ";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, tituloDoLivro);
			stmt.setString(2, tipo);
			stmt.setString(3, editora);
			stmt.setInt(4, numeroEdicao);
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
	
	// SELECT LIVROS
	public static void listarLivros() throws SQLException {
		System.out.println("LISTA DE LIVROS\n");
		
		String sql = "SELECT * FROM livro;";
		
		List<livro> lista = new ArrayList<>();
		livro l;
		
		try {
			conn = bd.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				l = new livro();
				
				l.setTituloDoLivro(rs.getString("titulo_do_livro"));
				l.setTipo(rs.getString("tipo"));
				l.setEditora(rs.getString("editora"));
				l.setEdicao(rs.getInt("edicao"));
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
		
		Iterator<livro> it = lista.iterator();
		
		while(it.hasNext()){
	        l = it.next();
	        System.out.println("Título do livro: " + l.getTituloDoLivro());
			System.out.println("Tipo: " + l.getTipo());
			System.out.println("Editora: " + l.getEditora());
			System.out.println("Edição: " + l.getEdicao());
			System.out.println("Ano de Publicação: " + l.getAnoPublicacao());
			System.out.println("Autores/Editores: " + l.getAutoresEditores());
			System.out.println("Título original: " + l.getTituloOriginal());
			System.out.println("Número de páginas: " + l.getnPags());
			System.out.println("Id Local de publicação: " + l.getIdLocPub());
			System.out.println("Título de publicação: " + l.getTituloPub() + "\n \n");	
	    }
	}

	// UPDATE
	public static void alterarLivro() {
		Scanner key = new Scanner(System.in);
		String tituloDoLivro;
		String colunasEscolhidas;
		String[] colunas;
		String atributo;
		String sql = "UPDATE FROM livro";
		livro l;
		boolean[] opcoes = new boolean[10];
		int contaVirgulas;
		
		System.out.println("ALTERACAO DE LIVROS\n");	
		System.out.println("Insira a chave da tupla que deseja alterar: ");
		System.out.println("titulo_do_livro");
		tituloDoLivro = key.nextLine();
		
		l = selectLivroChave(tituloDoLivro);
		
		exibirLivro(l);
		
		System.out.println("Qual(is) dos seguintes atributos sera(o) alterado(s)? (entrar apenas com o(s) numero(s) da(s) coluna(s) separado(s) por virgula");
		System.out.println();
		System.out.println("#1 titulo_do_livro");
		System.out.println("#2 titulo_pub");
		System.out.println("#3 tipo");
		System.out.println("#4 editora");
		System.out.println("#5 n_edicao");
		System.out.println("#6 ano_publicacao");
		System.out.println("#7 autores_editores");
		System.out.println("#8 titulo_orig");
		System.out.println("#9 n_pags");
		System.out.println("#10 idLocPub");
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
					case 0: sql = sql + " SET titulo_do_livro = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 1: sql = sql + " SET titulo_pub = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 2: sql = sql + " SET tipo = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 3: sql = sql + " SET editora = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 4: sql = sql + " SET n_edicao = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 5: sql = sql + " SET ano_publicacao = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 6: sql = sql + " SET autores_editores = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 7: sql = sql + " SET titulo_orig = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 8: sql = sql + " SET n_pags = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					default: sql = sql + " SET idLocPub = " + Integer.parseInt(atributo);
				}
			}
		}
		
		sql = sql + " WHERE titulo_do_livro = " + a.getTituloDoLivro() + ";";
	
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
	public static void removeLivro() throws SQLException{
		Scanner key = new Scanner(System.in);
		System.out.println("REMOCAO DE LIVROS\n");
		
		System.out.println("Digite o Titulo do Livro\n >");
		String remocaotituloDoLivro = key.nextLine();
		
		String sql = "DELETE FROM livro WHERE titulo_do_livro = " + remocaotituloDoLivro + ";";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		stmt.execute();
		stmt.close();
		key.close();
	}
	
	//SELECT TUPLA ESPECIFICA PELA CHAVE
	public static livro selectLivroChave(String tituloDoLivro){
		String sql = "SELECT * FROM livro WHERE titulo_do_livro = " + tituloDoLivro + ";";

		livro l = new livro();

		try {
			conn = bd.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			l.setTituloDoLivro(rs.getString("titulo_do_livro"));
			l.setTipo(rs.getString("tipo"));
			l.setEditora(rs.getString("editora"));
			l.setEdicao(rs.getInt("edicao"));
			l.setAnoPublicacao(rs.getInt("ano_publicacao"));
			l.setAutoresEditores(rs.getString("autores_editores"));
			l.setTituloOriginal(rs.getString("titulo_original"));
			l.setnPaginas(rs.getInt("n_pags"));
			l.setIdLocPub(rs.getInt("IdLocPub"));
			l.setTituloPub(rs.getString("titulo_pub"));

			rs.close();
			stmt.close();

			return l;
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//EXIBE TODAS OS ATRIBUTOS DE UM DETERMINADO LIVRO
	public static void exibirLivro(livro l){
		System.out.println("Título do livro: " + l.getTituloDoLivro());
		System.out.println("Título de publicação: " + l.getTituloPub());
		System.out.println("Tipo: " + l.getTipo());
		System.out.println("Editora: " + l.getEditora());
		System.out.println("Edição: " + l.getEdicao());
		System.out.println("Ano de Publicação: " + l.getAnoPublicacao());
		System.out.println("Autores/Editores: " + l.getAutoresEditores());
		System.out.println("Título original: " + l.getTituloOriginal());
		System.out.println("Número de páginas: " + l.getnPaginas());
		System.out.println("Id Local de publicação: " + l.getIdLocPub());
		System.out.println();
	}
	
	//CONTROLA A QUANTIDADE DE VIRGULAS DOS ARGUMENTOS DO UPDATE
	public static void controlaVirgulas(int contaVirgulas, String argumentos){
		contaVirgulas--;
		if (contaVirgulas > 0)
			argumentos = argumentos + ",";
	}
}
