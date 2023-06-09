package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner leia = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\nCriar contas\n");

		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(cp2);

		contas.listarTodas();

		while (true) {
			System.out.println("");
			System.out.println(Cores.TEXT_BLACK + Cores.ANSI_BLUE_BACKGROUND
					+ "                                                      ");
			System.out.println("       ________________________________________       ");
			System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLUE_BACKGROUND + "     ♦                  "
					+ Cores.TEXT_RED_BRIGHT + Cores.ANSI_BLUE_BACKGROUND + "                        ♦     ");
			System.out.println(Cores.TEXT_BLACK + "    |" + Cores.TEXT_YELLOW_BOLD + "               MICHAEL"
					+ Cores.TEXT_PURPLE_BOLD + " ♦ " + Cores.TEXT_YELLOW_BOLD + "BANK               " + Cores.TEXT_BLACK
					+ "|    " + Cores.TEXT_RESET + Cores.TEXT_BLACK + Cores.ANSI_BLUE_BACKGROUND);
			System.out.println("    |         Nosso maior cuidado é você!        |    ");
			System.out.println("    |____________________________________________|    ");
			System.out.println("    |                                            |    ");
			System.out.println("    |     1 - Criar conta                        |    ");
			System.out.println("    |     2 - Listar todas as contas             |    ");
			System.out.println("    |     3 - Buscar conta por número            |    ");
			System.out.println("    |     4 - Atualizar dados da conta           |    ");
			System.out.println("    |     5 - Apagar conta                       |    ");
			System.out.println("    |     6 - Sacar                              |    ");
			System.out.println("    |     7 - Depositar                          |    ");
			System.out.println("    |     8 - Transferir valores entre contas    |    ");
			System.out.println("    |     9 - Sair                               |    ");
			System.out.println("    |____________________________________________|    ");
			System.out.println("                                                      ");
			System.out.println("                                                      ");
			System.out.printf("     Entre com a opção desejada:                     ");
			try {
				opcao = leia.nextInt();
				System.out.println("                                                      ");
			} catch (InputMismatchException e) {
				System.out.println("                                                      ");
				System.out.println("     Digite valores inteiros!                         ");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "     Obrigado por fazer parte!                        ");
				System.out.println(Cores.TEXT_WHITE_BOLD + "     Michael Bank - Nosso maior cuidado é você!       ");
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Criar conta");

				System.out.printf("Digite o número da agência: ");
				agencia = leia.nextInt();
				System.out.printf("Digite o nome do Titular: ");
				leia.skip("\\R?");
				titular = leia.nextLine();

				do {
					System.out.printf("Digite o tipo da conta (1 - CC ou 2 - CP):   ");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.printf("Digite o saldo da conta (R$): ");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1:
					System.out.printf("Digite o limite de crédito (R$): ");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					break;
				case 2:
					System.out.printf("Digite o dia do aniversario da conta: ");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					break;
				}

				keyPress();
				break;
			case 2:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Listar todas as contas");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Consultar dados da conta - Por número");

				System.out.printf("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta");

				System.out.printf("Digite o número da conta: ");
				numero = leia.nextInt();

				if (contas.buscarNaCollection(numero) != null) {
					System.out.printf("Digite o número da agência: ");
					agencia = leia.nextInt();
					System.out.printf("Digite o nome do titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();

					System.out.printf("Digite o saldo da conta (R$): ");
					saldo = leia.nextFloat();

					tipo = contas.retornaTipo(numero);

					switch (tipo) {
					case 1:
						System.out.printf("Digite o limite de crédito (R$): ");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
						break;
					case 2:
						System.out.printf("Digite o dia do aniversário da conta: ");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
						break;
					default:
						System.out.println("\nTipo de conta inválido.");
					}
				} else
					System.out.println("\nConta não encontrada.");

				keyPress();
				break;
			case 5:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Apagar a conta");

				System.out.printf("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Saque");

				System.out.printf(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Digite o número da conta: ");
				numero = leia.nextInt();

				do {
					System.out.printf("Digite o valor do saque (R$): ");
					valor = leia.nextFloat();
				} while (valor < 0);

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Depósito");

				System.out.printf("Digite o número da conta: ");
				numero = leia.nextInt();

				do {
					System.out.printf("Digite o valor do depósito (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println("");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_WHITE_BOLD + "Transferência entre contas");

				System.out.printf("Digite o número da conta de origem: ");
				numero = leia.nextInt();
				System.out.printf("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();

				do {
					System.out.printf("Digite o valor da transferência (R$): ");
					valor = leia.nextFloat();
				} while (valor <= 0);

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println(Cores.ANSI_BLUE_BACKGROUND + Cores.TEXT_RED_BOLD
						+ "     Opção inválida.                                  " + Cores.TEXT_RESET);

				keyPress();
				break;
			}

		}

	}

	public static void keyPress() {
		try {
			System.out.println("                                                      ");
			System.out.println(Cores.ANSI_BLUE_BACKGROUND + Cores.TEXT_WHITE_BOLD
					+ "     Pressione Enter para continuar.                  ");
			System.in.read();

		} catch (IOException e) {
			System.out.println("                                                      ");
			System.out.println("Você pressionou uma tecla diferente de Enter.         " + Cores.TEXT_RESET);
		}
	}
}
