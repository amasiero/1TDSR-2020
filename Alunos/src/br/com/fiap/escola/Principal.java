package br.com.fiap.escola;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.escola.bd.AlunoBD;
import br.com.fiap.escola.model.Aluno;

public class Principal {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int opcao = 0;
			do {
				menu();
				System.out.print("> ");
				opcao = scan.nextInt();
				scan.nextLine();
				
//				até Java 13
//				switch(opcao) {
//					case 1:
//						cadastrarAluno();
//						break;
//					case 2:
//						consultarTurma();
//						break;
//				}
				
				// Java 14
				switch(opcao) {
					case 1 -> cadastrarAluno(scan);
					case 2 -> consultarTurma();
				}
				
				System.out.println("\n\n");
			} while(opcao != 0);
			
			System.out.println("Sistema finalizado com sucesso.");
		}

	}

	private static void menu() {
		System.out.println("|-----------------------------|");
		System.out.println("|       ESCOLA D.O.S          |");
		System.out.println("|                             |");
		System.out.println("| Digite a opção desejada:    |");
		System.out.println("| 1 - Cadastrar aluno         |");
		System.out.println("| 2 - Consultar turma         |");
		System.out.println("| 0 - Sair do sistema         |");
		System.out.println("|-----------------------------|");
	}

	private static void consultarTurma() {
		System.out.println("|----- Consulta da Turma -----|");
		List<Aluno> alunos = new AlunoBD().consultaTodos();
		System.out.println("Listando os alunos...");
		alunos.forEach(System.out::println);
		System.out.println("|------ Fim do Consulta ------|");
	}

	private static void cadastrarAluno(Scanner scan) {
		System.out.println("|----- Cadastro do Aluno -----|");
		
		System.out.print("Digite o RM do aluno: ");
		int rm = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Digite o nome do aluno: ");
		String nome = scan.nextLine();
		
		System.out.print("Digite o nota 1 do aluno: ");
		double nota1 = scan.nextDouble();
		scan.nextLine();
		
		System.out.print("Digite o nota 2 do aluno: ");
		double nota2 = scan.nextDouble();
		scan.nextLine();
		
		Aluno aluno = new Aluno(rm, nome);
		aluno.setAtivo(true);
		aluno.setNota1(nota1);
		aluno.setNota2(nota2);
		
		new AlunoBD().salva(aluno);
		System.out.println("|------ Fim do Cadastro ------|");
	}

}
