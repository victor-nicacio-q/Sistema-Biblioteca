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
public class CallQueryEspecifica {
	static connBd bd = new connBd();
	static Connection conn;
	
	public CallQueryEspecifica() throws SQLException{
		this.conn = connBd.getConnection();
	}
	
	public static void listaPublicacoesPorAutor() {		
		System.out.println("LISTAGEM DE TODAS AS PUBLICACOES ORDENADAS POR AUTOR\n\n");
		
		String sql = "SELECT tituloPub, nome_autor FROM Publicacoes	NATURAL JOIN Autores ORDER BY nome_autor;";
		
		List<Query1> lista = new ArrayList<>();
		Query1 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query1();
				
				q.setTituloPub(rs.getString("tituloPub"));
				q.setNomeDoAutor(rs.getString("nome_autor"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Título da Publicação\t |\t Nome do Autor");
		Iterator<Query1> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getTituloPub() + " | " + q.getNomeDoAutor());
	    }
	}
	
	public static void listaPublicacoesPorTema() {		
		System.out.println("LISTAGEM DE TODAS AS PUBLICACOES ORDENADAS POR TEMA\n\n");
		
		String sql = "SELECT tituloPub, temaPub FROM Publicacoes ORDER BY temaPub;";
		
		List<Query2> lista = new ArrayList<>();
		Query2 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query2();
				
				q.setTituloPub(rs.getString("tituloPub"));
				q.setNomeDoAutor(rs.getString("temaPub"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Título da Publicação\t |\t Tema");
		Iterator<Query2> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getTituloPub() + " | " + q.getTema());
	    }
	}
	
	public static void listaPublicacoesPorTitulo() {		
		System.out.println("LISTAGEM DE TODAS AS PUBLICACOES ORDENADAS POR TITULO\n\n");
		
		String sql = "SELECT tituloPub FROM Publicacoes	ORDER BY tituloPub;";
		
		List<Query3> lista = new ArrayList<>();
		Query3 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query3();
				
				q.setTituloPub(rs.getString("tituloPub"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Título da Publicação");
		Iterator<Query3> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getTituloPub());
	    }
	}
	
	public static void listaArtigosDeAnalDeConferencia() {		
		System.out.println("LISTAGEM DOS ARTIGOS QUE CONSTITUEM UM ANAL DE CONFERENCIA\n\n");
		System.out.println("Entre com o titulo do anal de conferencia desejado: ");
		
		Scanner key = new Scanner(System.in);
		String tituloDoCongresso = key.nextLine();
		
		String sql = "SELECT titulo_do_artigo FROM artigos_de_anais_de_conferencia WHERE titulo_do_congresso = " + tituloDoCongresso + "ORDER BY titulo_do_artigo;";
		
		List<Query4> lista = new ArrayList<>();
		Query4 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query4();
				
				q.setTituloDoArtigo(rs.getString("titulo_do_artigo"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Títulos dos Artigos que constituem o anal de conferencia: " + tituloDoCongresso);
		Iterator<Query4> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getTituloDoArtigo());
	    }
	}
	
	public static void listaCronologicaArtigosDePeriodicos() {		
		System.out.println("LISTAGEM CRONOLOGICA DOS ARTIGOS DE PERIODICOS REFERENTES A UM DETERMINADO PERIODICO, DADO UM ANO DE INICIO E UM DE FIM\n\n");
		System.out.println("Entre com o titulo do periodico desejado: ");
		
		Scanner key = new Scanner(System.in);
		String tituloDoPeriodico = key.nextLine();
		
		System.out.println("Entre com o ano de inicio: ");
		String anoInicio = key.nextInt();
		System.out.println("Entre com o ano de fim: ");
		String anoFim = key.nextInt();
		
		String sql = "SELECT titulo_do_artigo, titulo_do_periodico, ano_de_publicacao, mes_de_publicacao FROM artigos_de_periodicos	WHERE titulo_do_periodico = " 
					+ tituloDoPeriodico + "AND ano_de_publicacao BETWEEN " + anoInicio 
					+ " AND " + anoFim + " ORDER BY ano_de_publicacao, mes_de_publicacao, titulo_do_artigo;";
		
		List<Query5> lista = new ArrayList<>();
		Query5 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query5();
				
				q.setTituloDoArtigo(rs.getString("titulo_do_artigo"));
				q.setTituloDoPeriodico(rs.getString("titulo_do_periodico"));
				q.setAnoPublicacao(rs.getInt("ano_de_publicacao"));
				q.setMesPublicacao(rs.getInt("mes_de_publicacao"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Titulos dos Artigos que constituem o periodico: " + tituloDoPeriodico);
		System.out.println("Titulo do Artigo \t|\t Ano de Publicacao \t|\t Mes de Publicacao");
		Iterator<Query5> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getTituloDoArtigo() + " | " + q.getAnoPublicacao() + " | " + q.getMesPublicacao());
	    }
	}
	
	public static void listaCronologicaDePublicacoesPorAutor() {		
		System.out.println("LISTAGEM CRONOLOGICA DAS PUBLICACOES DE UM DETERMINADO AUTOR\n\n");
		System.out.println("Entre com o nome do autor: ");
		
		Scanner key = new Scanner(System.in);
		String nomeDoAutor = key.nextLine();
		
		String sql = "SELECT tituloPub, ano_de_publicacao, mes_de_publicacao FROM Publicacoes NATURAL JOIN Autores_Publicacoes WHERE nome_autor = " + nomeDoAutor + "ORDER BY ano_de_publicacao, mes_de_publicacao, tituloPub;";
		
		List<Query6> lista = new ArrayList<>();
		Query6 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query6();
				
				q.setTituloPub(rs.getString("tituloPub"));
				q.setNomeDoAutor(rs.getString("nome_autor"));
				q.setAnoPublicacao(rs.getInt("ano_de_publicacao"));
				q.setMesPublicacao(rs.getInt("mes_de_publicacao"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Titulos das publicacoes referentes ao autor: " + nomeDoAutor);
		System.out.println("Titulo da Publicacao \t|\t Ano de Publicacao \t|\t Mes de Publicacao");
		Iterator<Query6> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getTituloPub() + " | " + q.getAnoPublicacao() + " | " + q.getMesPublicacao());
	    }
	}
	
	public static void listaPublicacoesDeUmTemaPorAutor() {		
		System.out.println("LISTAGEM DAS PUBLICACOES DE UM DETERMINADO TEMA ORDENADAS POR AUTOR\n\n");
		System.out.println("Entre com o tema desejado: ");
		
		Scanner key = new Scanner(System.in);
		String tema = key.nextLine();
		
		String sql = "SELECT tituloPub, nomeAutor FROM Publicacoes NATURAL JOIN Autores_Publicacoes	WHERE temaPub = " + tema + " ORDER BY nome_autor;";
		
		List<Query7> lista = new ArrayList<>();
		Query7 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query7();
				
				q.setTituloPub(rs.getString("tituloPub"));
				q.setNomeDoAutor(rs.getString("nome_autor"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Titulos das publicacoes referentes ao tema: " + tema);
		System.out.println("Titulo da Publicacao \t|\t Nome do Autor");
		Iterator<Query7> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getTituloPub() + " | " + q.getNomeDoAutor());
	    }
	}
	
	public static void obtemNomeDoLocatario() {		
		System.out.println("NOME DO LOCATARIO ATUAL A QUEM SE EMPRESTOU UAM DETERMINADA PUBLICACAO\n\n");
		System.out.println("Entre com o titulo da publicacao: ");
		
		Scanner key = new Scanner(System.in);
		String titulo = key.nextLine();
		
		String sql = "SELECT nome_locatario FROM Emprestimos WHERE tituloPub = " + titulo + " AND data_devolucao = NULL;";
		
		List<Query8> lista = new ArrayList<>();
		Query8 q;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				q = new Query8();
				
				q.setNomeDoLocatario(rs.getString("nomeDoLocatario"));
				
				lista.add(q);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Nome do Locatario");
		Iterator<Query8> it = lista.iterator();
		
		while(it.hasNext()){
	        q = it.next();
	        System.out.println(q.getNomeDoLocatario());
	    }
	}
	
	public static void obtemLocalizacao() {		
		System.out.println("LOCALIZACAO DE UMA DETERMINADA PUBLICACAO\n\n");
		System.out.println("Entre com o titulo da publicacao: ");
		
		Scanner key = new Scanner(System.in);
		String titulo = key.nextLine();
		
		String sql = "SELECT * FROM Localizacao NATURAL JOIN Publicacoes WHERE tituloPub = " + titulo + ";";
		
		List<localizacao> lista = new ArrayList<>();
		localizacao l;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				l = new localizacao();
				
				l.setIdLocalizacao(rs.getInt("idLocPub"));
				l.setNumeroFolder(rs.getInt("numero_folder"));
				l.setNumeroUsp(rs.getInt("numero_usp"));
				l.setNomeResponsavel(rs.getString("nome_responsavel"));
				l.setIdComputador(rs.getInt("id_computador"));
				l.setUrl(rs.getString("url"));
				l.setDiretorio(rs.getString("diretorio"));
				l.setDisco(rs.getString("disco"));
			
				lista.add(l);
			}
			
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		// LISTAR OS OBJETOS DO LIST<LIST>
		System.out.println("Localizacao da publicacao: " + titulo);
		Iterator<localizacao> it = lista.iterator();
		
		while(it.hasNext()){
	        l = it.next();
	        System.out.println("Id Localizacao: " + l.getIdLocalizacao());
	        System.out.println("Numero do Folder: " + l.getNumeroFolder());
	        System.out.println("Numero USP: " + l.getNumeroUsp());
	        System.out.println("Nome do Responsavel: " + l.getNomeResponsavel());
	        System.out.println("Id Computador: " + l.getIdComputador());
	        System.out.println("URL: " + l.getUrl());
	        System.out.println("Diretorio: " + l.getDiretorio());
	        System.out.println("Disco: " + l.getDisco());
			System.out.println();
	    }
	}
}