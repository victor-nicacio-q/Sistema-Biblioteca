import db_ep.*;
import models.*;
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
	
	public static void main(String[] args) throws SQLException {
		int op;
		Scanner entrada = new Scanner(System.in);
		
		do {
			imprimeMenu();
			op = entrada.nextInt();
			
			//Menu principal
			switch(op) {
			
			case 0: break;
				
			case 1:
				System.out.println("Selecione a tabela em que deseja consultar tuplas:");
				imprimeTabelas();
				op = entrada.nextInt();
				
				//Menu interno case 1
				switch(op){
				
				case 0: break;
				
				case 1:
					BdLivro.listarLivros();
					break;
				
				case 2:
					BdAnalDeConferencia.listaAnaisDeConferencia();
					break;
					
				case 3:
					BdArtigoDeAnaisDeConferencias.listarArtigosDeAnaisDeConferencia();
					break;
					
				case 4:
					BdArtigoDeLivro.listarArtigoDeLivro();
					break;
					
				case 5:
					// Construir classe de Periodico
					break;
					
				case 6:
					BdArtigoDePeriodico.listarArtigosDePeriodicos();
					break;
					
				case 7:
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
				
				//Menu interno case 2
				switch(op){
				
				case 0: break;
				
				case 1:
					BdLivro.postLivro();
					break;
				
				case 2:
					BdAnalDeConferencia.postAnalDeConferencia();
					break;
					
				case 3:
					BdArtigoDeAnaisDeConferencias.postArtigoDeAnalDeConferencia();
					break;
					
				case 4:
					BdArtigoDeLivro.postArtigoDeLivro();
					break;
					
				case 5:
					// Construir classe de Periodico
					break;
					
				case 6:
					BdArtigoDePeriodico.postArtigoDePeriodico();
					break;
					
				case 7:
					// Construir classe de Monografia
					break;
					
				default:
					System.out.println("Entrada Inválida - tente novamente");
				}
				
				break;
				
			case 3:
				System.out.println("Selecione a tabela em que deseja remover tuplas:");
				imprimeTabelas();
				op = entrada.nextInt();
				
				//Menu interno case 3
				switch(op){
				
				case 0: break;
				
				case 1:
					BdLivro.removeLivro();
					break;
				
				case 2:
					BdAnalDeConferencia.removeAnalDeConferencia();
					break;
					
				case 3:
					BdArtigoDeAnaisDeConferencias.removeArtigoDeAnalDeConferencia();
					break;
					
				case 4:
					BdArtigoDeLivro.removeArtigoDeLivro();
					break;
					
				case 5:
					// Construir classe de Periodico
					break;
					
				case 6:
					BdArtigoDePeriodico.removeArtigoDePeriodico();
					break;
					
				case 7:
					// Construir classe de Monografia
					break;
					
				default:
					System.out.println("Entrada Inválida - tente novamente");
				}
				
				break;
				
			case 4:
				System.out.println("Selecione a tabela em que deseja alterar tuplas:");
				imprimeTabelas();
				op = entrada.nextInt();
				
				//Menu interno case 4
				switch(op){
				
				case 0: break;
				
				case 1:
					BdLivro.alterarLivro();
					break;
				
				case 2:
					BdAnalDeConferencia.alterarAnalDeConferencia();
					break;
					
				case 3:
					BdArtigoDeAnaisDeConferencias.alterarArtigoDeAnaisDeConferencia();
					break;
					
				case 4:
					BdArtigoDeLivro.alterarArtigoDeLivro();
					break;
					
				case 5:
					// Construir classe de Periodico
					break;
					
				case 6:
					BdArtigoDePeriodico.alterarArtigoDePeriodico();
					break;
					
				case 7:
					// Construir classe de Monografia
					break;
					
				default:
					System.out.println("Entrada Inválida - tente novamente");
				}
				
				break;
			
			case 5: 
				System.out.println("Selecione a consulta específica que deseja realizar:");
				imprimeOpcoesConsultasEspecificas();
				op = entrada.nextInt();
				
				//Menu interno case 5
				switch(op){
				
				case 0: break;
				
				case 1:
					CallQueryEspecifica.listaPublicacoesPorAutor();
					break;
				
				case 2:
					CallQueryEspecifica.listaPublicacoesPorTema();
					break;
					
				case 3:
					CallQueryEspecifica.listaPublicacoesPorTitulo();
					break;
					
				case 4:
					CallQueryEspecifica.listaArtigosDeAnalDeConferencia();
					break;
					
				case 5:
					CallQueryEspecifica.listaCronologicaArtigosDePeriodicos();
					break;
					
				case 6:
					CallQueryEspecifica.listaCronologicaDePublicacoesPorAutor();
					break;
					
				case 7:
					CallQueryEspecifica.listaPublicacoesDeUmTemaPorAutor();
					break;
				
				case 8:
					CallQueryEspecifica.obtemNomeDoLocatario();
					break;
					
				case 9:
					CallQueryEspecifica.obtemLocalizacao();
					break;

				default:
					System.out.println("Entrada Inválida - tente novamente");
				}
				
				break;
				
			case 6: 
				imprimeSubMenuEmprestimos();
				op = entrada.nextInt();
				
				//Menu interno case 6
				switch(op){
				
				case 0: break;
				
				case 1:
					BdLivro.alterarLivro();
					break;
				
				case 2:
					BdAnalDeConferencia.alterarAnalDeConferencia();
					break;
					
				default:
					System.out.println("Entrada Inválida - tente novamente");
				}
				
				break;
				
			default:
				System.out.println("Entrada Inválida - tente novamente");
			}
			
		}while(op != 0);
		entrada.close();
	}

}
