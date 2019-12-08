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
public class BdArtigoDeAnaisDeConferencias {
	static connBd bd = new connBd();
	static Connection conn;

	public BdArtigoDeAnaisDeConferencias() throws SQLException {
		this.conn = connBd.getConnection();
	}

	public void postLivro() {
		System.out.println("INSERCAO DE ANAIS DE CONFERENCIA\n\n");

		Scanner key = new Scanner(System.in);

		System.out.println("Inserção de Anais de Conferencia\n >");

		System.out.println("Digite o Titulo do Congresso\n >");
		String tituloDoCongresso = key.nextLine();

		System.out.println("Digite o numero do volume\n >");
        int volume = key.nextInt();
        
        System.out.println("Digite o numero \n >");
		int numero = key.nextInt();

		System.out.println("Digite a editora\n >");
		String editora = key.nextLine();

		System.out.println("Digite o mes de publicação\n >");
		int mesPublicacao = key.nextInt();

		System.out.println("Digite o ID de Localização da Publicação\n >");
		int idLocPub = key.nextInt();

		System.out.println("Digite o Titulo da Publicação\n >");
		String tituloPub = key.nextLine();

		key.close();
		String sql = "INSERT INTO artigo_de_periodico (titulo_do_congresso, editora, ano_de_publicacao, mes, volume, numero, idLocPub, tituloPub)"
				+ "VALUES (" + tituloDoCongresso + ", " 
				+ editora + ", " 
				+ anoPublicacao + ", " 
				+ mesPublicacao + ", " 
				+ volume + ", " 
				+ numero + ", " 
				+ idLocPub + ", "
				+ tituloPub + "); ";

		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, tituloDoCongresso);
            stmt.setString(2, editora);
            stmt.setInt(3, mesPublicacao);
            stmt.setInt(4, volume);
            stmt.setInt(5, numero);
            stmt.setInt(6, idLocPub);
			stmt.setString(7, tituloPub);            

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// SELECT ANAIS DE CONFERENCIA
	public static List<analDeConferencia> listaAnaisDeConferencia() throws SQLException {
		System.out.println("LISTA DE ANAIS DE CONFERENCIA\n");

		String sql = "SELECT * FROM anal_de_conferencia;";

		List<analDeConferencia> lista = new ArrayList<>();

		try {
			conn = bd.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				analDeConferencia a = new analDeConferencia();
				a.setTituloCongresso(rs.getTituloCongresso("titulo_do_congresso"));
				a.setEditora(rs.getString("editora"));
				a.setAno(rs.getAno("ano_de_publicacao"));
				a.setMes(rs.getMes("mes"));
				a.setVolume(rs.getVolume("volume"));                
				a.setNumero(rs.getNumero("numero"));                
				a.setIdLocPub(rs.getIdLocPub("IdLocPub"));
				a.setTituloPub(rs.getTituloPub("titulo_pub"));			

				lista.add(a);

				rs.close();
				stmt.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		// LISTAR OS OBJETOS DO LIST<LIST>
		while (lista.next()) {
			System.out.println("Título do Congresso: " + next.getTituloCongresso());
			System.out.println("Editora: " + next.getEditora());
			System.out.println("Ano : " + next.getAno());
			System.out.println("Mes : " + next.getMes());
            System.out.println("Numero do volume: " + next.getVolume());
            System.out.println("Numero: " + next.getNumero());
			System.out.println("IdLocPub: " + next.getIdLocPub());
            System.out.println("Título da Publicação: " + next.getTituloPub());
		}
	}

	// UPDATE
	public void alterarAnalDeConferencia() {
		Scanner key = new Scanner(System.in);
		String tituloDoCongresso;
		String colunasEscolhidas;
		String[] colunas;
		String atributo;
		String sql = "UPDATE FROM anal_de_conferencia";
		analDeConferencia a;
		boolean[] opcoes = new boolean[8];
		int contaVirgulas;
		
		System.out.println("ALTERACAO DE ANAIS DE CONFERENCIA\n");	
		System.out.println("Insira a chave da tupla que deseja alterar: ");
		System.out.println("titulo_do_congresso");
		tituloDoCongresso = key.nextLine();
		
		a = selectAnalDeConferenciaChave(tituloDoCongresso);
		
		exibirAnalDeConferencia(a);
		
		System.out.println("Qual(is) dos seguintes atributos sera(o) alterado(s)? (entrar apenas com o(s) numero(s) da(s) coluna(s) separado(s) por virgula");
		System.out.println();
		System.out.println("#1 titulo_do_congresso");
		System.out.println("#2 editora");
		System.out.println("#3 ano");
		System.out.println("#4 mes");
		System.out.println("#5 numero_do_volume");
		System.out.println("#6 numero");
		System.out.println("#7 idLocPub");
		System.out.println("#8 tituloPub");
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
					case 0: sql = sql + " SET titulo_do_congresso = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 1: sql = sql + " SET editora = " + atributo;
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 2: sql = sql + " SET ano = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 3: sql = sql + " SET mes = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 4: sql = sql + " SET numero_do_volume = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 5: sql = sql + " SET numero = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					case 6: sql = sql + " SET idLocPub = " + Integer.parseInt(atributo);
							controlaVirgulas(contaVirgulas, sql);
							break;
					default: sql = sql + " SET tituloPub = " + atributo;
				}
			}
		}
		
		sql = sql + " WHERE titulo_do_congresso = " + a.getTituloCongresso() + ";";
					
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
	public static analDeConferencia selectAnalDeConferenciaChave(String tituloDoCongresso){
		String sql = "SELECT * FROM anal_de_conferencia"
					+ "WHERE titulo_do_congresso = tituloDoCongresso" + ";";

		analDeConferencia a = new analDeConferencia();

		try {
			conn = bd.getConnection();

			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			a.setTituloCongresso(rs.getTituloCongresso("titulo_do_congresso"));
			a.setEditora(rs.getString("editora"));
			a.setAno(rs.getAno("ano_de_publicacao"));
			a.setMes(rs.getMes("mes"));
			a.setVolume(rs.getVolume("volume"));                
			a.setNumero(rs.getNumero("numero"));                
			a.setIdLocPub(rs.getIdLocPub("IdLocPub"));
			a.setTituloPub(rs.getTituloPub("titulo_pub"));	

			rs.close();
			stmt.close();

			return a;
		} 
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//EXIBE TODAS AS TUPLAS DE UM DETERMINADO ARTIGO DE PERIODICO
	public static void exibirAnalDeConferencia(analDeConferencia a){
		System.out.println("Título do Congresso: " + a.getTituloCongresso());
		System.out.println("Editora: " + a.getEditora());
		System.out.println("Ano : " + a.getAno());
		System.out.println("Mes : " + a.getMes());
		System.out.println("Numero do volume: " + a.getVolume());
		System.out.println("Numero: " + a.getNumero());
		System.out.println("IdLocPub: " + a.getIdLocPub());
		System.out.println("Título da Publicação: " + a.getTituloPub());
		System.out.println();
	}
	
	//CONTROLA A QUANTIDADE DE VIRGULAS DOS ARGUMENTOS DO UPDATE
	public static void controlaVirgulas(int contaVirgulas, String argumentos){
		contaVirgulas--;
		if (contaVirgulas > 0)
			argumentos = argumentos + ",";
	}
}
