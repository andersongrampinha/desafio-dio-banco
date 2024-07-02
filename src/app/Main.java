package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ContaException, InterruptedException {
		
		/* Criado banco padrão */
		Banco banco = new Banco();
        banco.setNome("Banco Brasileiro");
        List<Conta> listaDeContas = new ArrayList<>();
        
        /* Criado 2 clientes */
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        
        /* Criado contas corrente */
		Conta cc = new ContaCorrente(cliente1, TipoConta.CONTA_CORRENTE);
		        
        /* Criado contas poupança */
		Conta cp = new ContaPoupanca(cliente2, TipoConta.CONTA_POUPANÇA);
        
    	/* Adicionando as contas às lista s*/
		listaDeContas.add(cc);
    	listaDeContas.add(cp);
    	banco.setContas(listaDeContas);
    	
    	double valorDeposito = 0;
    	double valorSaque = 0;
    	double valorTransferencia = 0;
    	int tipoOperacao = 0;
    	
    	Scanner scan = new Scanner(System.in);
		
		int opcao = -1;
		while (opcao != 0) {
			
			System.out.println("Selecione uma opção no menu: \n " + 
			                   "-> 1: Fazer Depósito \n " + 
					           "-> 2: Fazer Saque \n " + 
			                   "-> 3: Fazer Transferencia \n " + 
					           "-> 4: Imprimir Saldo \n " + 
					           "-> 0: Sair");
			
			
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Informe qual o tipo da conta: \n --" + 
		                           "1: Conta Corrente \n --" + 
				                   "2: Conta Poupança ");
				tipoOperacao = scan.nextInt();
				
				if (tipoOperacao <= 2) {
					System.out.println("Informe o valor do deposito: ");
					valorDeposito = scan.nextDouble();
				}
				
				if (tipoOperacao == 1) {
					depositar(cc, valorDeposito);
				}
				else if (tipoOperacao == 2) {
					depositar(cp, valorDeposito);
				}
				else {
					System.out.println("Selecione uma opção válida!!!");
				}
				
				Thread.sleep(1000);
				break;
			case 2:
				System.out.println("Informe qual o tipo da conta: \n --" + 
                                   "1: Conta Corrente \n --" + 
		                           "2: Conta Poupança ");
				tipoOperacao = scan.nextInt();
				
				if (tipoOperacao <= 2) {
					System.out.println("Informe o valor do saque: ");
					valorSaque = scan.nextDouble();
				}
				
				if (tipoOperacao == 1) {
					try {
						sacar(cc, valorSaque);	
					} catch (ContaException e) {
						System.out.println("Saque não realizado. " + e.getMessage());
					}
				} 	
				else if (tipoOperacao == 2) {
					try {
						sacar(cp, valorSaque);	
					} catch (ContaException e) {
						System.out.println("Saque não realizado. " + e.getMessage());
					}
				}
				else {
					System.out.println("Selecione uma opção válida!!!");
				}
				
				Thread.sleep(1000);
				break;
			case 3:
				System.out.println("Informe como deseja transferir: \n --" + 
                                   "1: Conta Corrente para Poupança\n --" + 
                                   "2: Conta Poupança para Corrente");
				tipoOperacao = scan.nextInt();
				
				if (tipoOperacao <= 2) {
					System.out.println("Informe o valor a transferir: ");
					valorTransferencia = scan.nextDouble();
				}
				
				if (tipoOperacao == 1) {
					try {
						sacar(cc, valorTransferencia);
						depositar(cp, valorTransferencia);
					} catch (ContaException e) {
						System.out.println("Transferencia  não realizada. " + e.getMessage());	
					}
				} 
				else if (tipoOperacao == 2) {
					try {
						sacar(cp, valorTransferencia);
						depositar(cc, valorTransferencia);
					} catch (Exception e) {
						System.out.println("Transferencia  não realizada. " + e.getMessage());
					}
				}
				else {
					System.out.println("Selecione uma opção válida!!!");
				}	
				Thread.sleep(900);
				break;
			case 4:
				System.out.println("Informe qual conta deseja imprimir o saldo: \n --" + 
                        		   "1: Conta Corrente\n --" + 
                                   "2: Conta Poupança");
				tipoOperacao = scan.nextInt();
				
				if (tipoOperacao == 1) {
					imprimirSaldo(cc);
				} 
				else if (tipoOperacao == 2) {
					imprimirSaldo(cp);
				}
				else {
					System.out.println("Selecione uma opção válida!!!");
				}
				
				Thread.sleep(900);
				break;
			case 0:
				System.out.println("Saindo...");
				Thread.sleep(800);
				break;				
			default:
				System.out.println("Opção inválida. Insira um número de 0 a 4.");
				Thread.sleep(900);
			}
		}
		scan.close();		
	}
	
	public static void depositar(Conta conta, double valorDeposito) {
		conta.depositar(valorDeposito);
	}

	public static void sacar(Conta conta, double valorSaque) throws ContaException {
		conta.sacar(valorSaque);
	}

	public static void tranferenrir(Conta contaDebito, Conta contaCredito, double valorTransferencia) throws ContaException {
		contaDebito.transferir(valorTransferencia, contaCredito);
	}

	public static void imprimirSaldo(Conta conta) {
		System.out.println(conta.getTipoConta() + " do " + conta.cliente.getNome());
		System.out.println("======================================================");
		conta.imprimirExtrato();
	}	
}
