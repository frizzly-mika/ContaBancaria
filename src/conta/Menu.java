package conta;

import java.util.Scanner;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Conta c1 = new Conta(1, 123, 1, "Adriana", 13000.0f);
		c1.visualizar();
		c1.sacar(1200.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();

		ContaCorrente cc1 = new ContaCorrente(2, 123, 1, "Mariana", 15000.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(1200.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca(3, 123, 2, "Vicktor", 11000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
		
		
		Scanner leia = new Scanner(System.in);
		int opcao;
				
		while(true) { 

			System.out.println(Cores.TEXT_BLACK + Cores.ANSI_BLUE_BACKGROUND
			                 + "                                                      ");
			System.out.println("       ________________________________________       ");
			System.out.println(Cores.TEXT_BLUE_BRIGHT + Cores.ANSI_BLUE_BACKGROUND +
							   "     ♦                  " 
			+ Cores.TEXT_RED_BRIGHT + Cores.ANSI_BLUE_BACKGROUND +
													   "                        ♦     ");
			System.out.println(Cores.TEXT_BLACK + "    |" + Cores.TEXT_YELLOW_BOLD +
					           "               MICHAEL" + Cores.TEXT_PURPLE_BOLD + " ♦ " 
			+ Cores.TEXT_YELLOW_BOLD + "BANK               " + Cores.TEXT_BLACK + "|    "
			+ Cores.TEXT_RESET + Cores.TEXT_BLACK + Cores.ANSI_BLUE_BACKGROUND);
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
			opcao = leia.nextInt();
			System.out.println("                                                      ");			
				
			if (opcao == 9) {
				System.out.println(Cores.TEXT_YELLOW_BOLD + "     Obrigado por fazer parte!                        ");
				System.out.println(Cores.TEXT_WHITE_BOLD + "     Michael Bank - Nosso maior cuidado é você!       ");
				leia.close();
				System.exit(0);
			}
				
			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "     Criar conta                                      ");
				
                    break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "     Listar todas as contas                           ");
					
                    break;
				case 3:
					System.out.println(Cores.TEXT_WHITE + "     Consultar dados da conta - Por número            ");
	
                    break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "     Atualizar dados da conta                         ");
					
                    break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "     Apagar a conta                                   ");
		
                    break;
				case 6:
					System.out.println(Cores.TEXT_WHITE + "     Saque                                            ");

                    break;
				case 7:
					System.out.println(Cores.TEXT_WHITE + "     Depósito                                         ");
					
                    break;
				case 8:
					System.out.println(Cores.TEXT_WHITE + "     Transferência entre contas                       ");
					
                    break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\n     Opção inválida.                             " + Cores.TEXT_RESET);
                    break;
			}
			
		}	
		
	}

}
