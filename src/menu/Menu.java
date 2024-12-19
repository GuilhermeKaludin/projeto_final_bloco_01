package menu;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    Feira do Zé                      ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Adicionar fruta                      ");
			System.out.println("            2 - Listar todas as frutas               ");
			System.out.println("            3 - Atualizar frutas                     ");
			System.out.println("            4 - Apagar frutas                        ");
			System.out.println("            5 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			opcao = leia.nextInt();

			if (opcao == 5) {
				System.out.println("Sistema finalizado");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Adicionar fruta\n\n");

				break;
			case 2:
				System.out.println("Listar todas as frutas\n\n");

				break;
			case 3:
				System.out.println("Atualizar frutas\n\n");

				break;
			case 4:
				System.out.println("Apagar frutas\n\n");

				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

}
