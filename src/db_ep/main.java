package db_ep;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int entrada;
		do {
			System.out.println("0 - Inserir livro");
			System.out.println("1");
			
			Scanner op = new Scanner(System.in);
			entrada = op.nextInt();
			
			if(entrada==0) {
				System.out.println("Opcao zero");
				
			}
			else if (entrada == 1) {
				System.out.println("Opcao um");
			}
			else if(entrada != 1 || entrada != 0) {
				System.out.println("Comando inválido");
			}
		} while (entrada!=1 || entrada !=0);

	}

}
