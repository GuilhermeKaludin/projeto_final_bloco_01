package menu;

import java.io.IOException;
import java.util.Scanner;

import fruta.controller.FrutaController;
import fruta.model.Fruta;
import fruta.model.FrutaExotica;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		FrutaController controller = new FrutaController();

		int opcao, quantidade;
		String nome, origem;
		float preco;

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

				System.out.print("Digite o nome da fruta: ");
				nome = leia.next();
				leia.skip("\\R?");
				System.out.print("Digite a quantidade: ");
				quantidade = leia.nextInt();

				System.out.print("Digite o preço: ");
				preco = leia.nextFloat();
				leia.nextLine(); // Consumir o '\n' restante

				System.out.print("A fruta é exótica? (sim/não): ");
				String resposta = leia.nextLine().toLowerCase();
				if (resposta.equals("sim")) {
					System.out.print("Digite a origem da fruta exótica: ");
					origem = leia.nextLine();
					Fruta frutaExotica = new FrutaExotica(nome, quantidade, preco, origem);
					controller.cadastrar(frutaExotica);
				} else {
					Fruta fruta = new Fruta(nome, quantidade, preco) {
						@Override
						public void mostrarDetalhes() {
							System.out.println("\nNome: " + getNome());
							System.out.println("Quantidade: " + getQuantidade());
							System.out.println("Preço: R$" + getPreco());
						}
					};
					controller.cadastrar(fruta);
				}
				keyPress();
				break;

			case 2:
				System.out.println("Listar todas as frutas\n\n");
				controller.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println("Atualizar frutas\n\n");

				System.out.print("Digite o nome da fruta que deseja atualizar: ");
				nome = leia.next();

				System.out.print("Digite a nova quantidade: ");
				quantidade = leia.nextInt();

				System.out.print("Digite o novo preço: ");
				preco = leia.nextFloat();
				leia.nextLine(); // Consumir o '\n' restante

				Fruta frutaAtualizada = new Fruta(nome, quantidade, preco) {
					public void mostrarDetalhes() {
						System.out.println("Nome: " + getNome());
						System.out.println("Quantidade: " + getQuantidade());
						System.out.println("Preço: R$" + getPreco());
					}
				};
				controller.atualizar(nome, frutaAtualizada);
				keyPress();
				break;

			case 4:
				System.out.println("Apagar frutas\n\n");

				System.out.print("Digite o nome da fruta que deseja apagar: ");
				nome = leia.next();
				controller.deletar(nome);
				keyPress();
				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}
}
