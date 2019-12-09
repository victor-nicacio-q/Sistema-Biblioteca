package db_ep;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
	
	public static void imprimeMenu(){
		System.out.println("Biblioteca");
		System.out.println("1 - Consultas");
		System.out.println("2 - Inserções");
		System.out.println("3 - Remoções");
		System.out.println("4 - Alterações");
		System.out.println("5 - Consultas Específicas - itens 3.1 a 3.9");
		System.out.println("6 - Empréstimos e Devoluções");
		System.out.println("0 - Sair");
		System.out.println();
	}
	
	public static void imprimeTabelas(){
		System.out.println("1 - Livros");
		System.out.println("2 - Anais de Conferência");
		System.out.println("3 - Artigos de Anais de Conferência");
		System.out.println("4 - Artigos de Livros");
		System.out.println("5 - Periódicos");
		System.out.println("6 - Artigos de Periódicos");
		System.out.println("7 - Monografias");
		System.out.println("0 - Voltar");
		System.out.println();
	}
	
	public static void imprimeOpcoesConsultasEspecificas(){
		System.out.println("1 - Query 3.1 - Listar publicações ordenadas por autor");
		System.out.println("2 - Query 3.2 - Listar publicações ordenadas por tema");
		System.out.println("3 - Query 3.3 - Listar publicações ordenadas por título");
		System.out.println("4 - Query 3.4 - Listar artigos relacionados a um anal de conferência ordenados por título");
		System.out.println("5 - Query 3.5 - Listar cronologicamente artigos de periódicos relacionados a um periódico");
		System.out.println("6 - Query 3.6 - Listar cronologicamente publicações ordenadas por autor");
		System.out.println("7 - Query 3.7 - Listar publicações de um tema ordenadas por autor");
		System.out.println("8 - Query 3.8 - Obter nome do locatário que está em posse de determinada publicação");
		System.out.println("9 - Query 3.9 - Obter localização de uma determinada publicação");
		System.out.println("0 - Voltar");
		System.out.println();
	}
	
	public static void imprimeSubMenuEmprestimos(){
		System.out.println("1 - Emprestar uma publicação a um locatário");
		System.out.println("2 - Retornar uma publicação locada");
		System.out.println("0 - Voltar");
	}
	
	public static void rotinaMenu(){
		
	}
	
	public static void main(String[] args) throws SQLException {
		int op;
		Scanner entrada = new Scanner(System.in);
		
		do {
			imprimeMenu();
			op = entrada.nextInt();
			
			switch(op) {
			
			case 0: break;
				
			case 1:
				System.out.println("Selecione a tabela em que deseja consultar tuplas:");
				imprimeTabelas();
				op = entrada.nextInt();
				
				switch(op){
				
				case: 0 break;
				
				case: 1
					BdLivro.listarLivros();
					break;
				
				case: 2
					BdAnalDeConferencia.listaAnaisDeConferencia();
					break;
					
				case: 3
					BdArtigoDeAnaisDeConferencia.listarArtigosDeAnaisDeConferencia();
					break;
					
				case: 4
					// Construir classe de Artigo de Livro
					break;
					
				case: 5
					// Construir classe de Periodico
					break;
					
				case: 6
					BdArtigoDePeriodico.listarArtigosDePeriodicos();
					break;
					
				case: 7
					// Construir classe de Monografia
					break;
					
				default:
					System.out.println("Entrada Inválida - tente novamente");
				}
				break;
			
			case 2:
				System.out.println("Selecione a tabela em que deseja inserir tuplas:");
				imprimeTabelas();
				op = entrada.nextInt();
				break;
				
			case 3:
				System.out.println("Selecione a tabela em que deseja remover tuplas:");
				imprimeTabelas();
				op = entrada.nextInt();
				break;
				
			case 4:
				System.out.println("Selecione a tabela em que deseja alterar tuplas:");
				imprimeTabelas();
				op = entrada.nextInt();
				break;
			
			case 5: 
				System.out.println("Selecione a consulta específica que deseja realizar:");
				imprimeOpcoesConsultasEspecificas();
				op = entrada.nextInt();
				break;
				
			case 6: 
				imprimeSubMenuEmprestimos();
				
			default:
				System.out.println("Entrada Inválida - tente novamente");
			}
			
		}while(op != 0);
		entrada.close();
	}

}
