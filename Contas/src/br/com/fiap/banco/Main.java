package br.com.fiap.banco;

import java.util.Scanner;

import br.com.fiap.banco.domain.Banco;
import br.com.fiap.banco.domain.Conta;
import br.com.fiap.banco.exception.AtualizaSaldoException;
import br.com.fiap.banco.exception.CadastroContaException;

public class Main {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			Banco banco = new Banco();
			int opcao = 0;
			do {
				menu();
				System.out.print("> ");
				opcao = scan.nextInt();

				switch (opcao) {
				case 1 -> cadastraConta(scan, banco);
				case 2 -> transfereDindin(scan, banco);
				case 3 -> consultaContasCadastradas(banco);
				}

				System.out.println("\n\n");
			} while (opcao != 0);

			System.out.println("Programa finalizado");
		} catch (CadastroContaException | AtualizaSaldoException e) {
			System.err.println(e.getMessage());
		}

	}

	private static void transfereDindin(Scanner scan, Banco banco) throws AtualizaSaldoException {
		
		System.out.println("Transferência entre Contas\n");
		
		System.out.print("Informe o número da conta de origem: > ");
		int numero = scan.nextInt();
		
		Conta origem = banco.buscaConta(numero);
		if(origem == null) {
			System.err.println("Conta de origem inexistente.");
			return;
		}
		
		System.out.print("Informe o número da conta de destino: > ");
		numero = scan.nextInt();
		
		Conta destino = banco.buscaConta(numero);
		if(destino == null) {
			System.err.println("Conta de destino inexistente.");
			return;
		}
		
		System.out.print("Informe o valor da transferencia: > ");
		double valor = scan.nextDouble();
		
		if(banco.transferencia(origem, destino, valor)) {
			System.out.println("Transferencia executada com sucesso.");
		} else {
			System.err.println("Saldo insulficiente para a transferencia.");
		}

	}

	private static void consultaContasCadastradas(Banco banco) {
		banco.getContas().forEach(System.out::println);
	}

	private static void cadastraConta(Scanner scan, Banco banco) throws CadastroContaException {
		System.out.println("Cadastro de Conta\n");
		
		System.out.print("Informe o número da conta: > ");
		int numero = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Informe o nome do titular: > ");
		String nome = scan.nextLine();
		
		System.out.print("Informe o cpf do titular: > ");
		String cpf = scan.nextLine();
		
		System.out.print("Informe o saldo inicial: > ");
		double saldo = scan.nextDouble();
		
		Conta conta = new Conta(numero, nome, cpf, true, saldo);
		banco.adicionaConta(conta);
		
	}

	private static void menu() {
		System.out.println("Banco Tabajara");
		System.out.println("Digite a opção desejada:");
		System.out.println("1 - Cadastrar conta");
		System.out.println("2 - Efetuar transferência");
		System.out.println("3 - Consulta contas");
		System.out.println("0 - Sair do sistema");
	}

}
