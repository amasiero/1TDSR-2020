package br.com.fiap.pousada;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.fiap.pousada.dao.QuartoDAO;
import br.com.fiap.pousada.domain.Categoria;
import br.com.fiap.pousada.domain.Pousada;
import br.com.fiap.pousada.domain.Quarto;

public class App {

	public static void main(String[] args) {
		Pousada pousada = new Pousada();
		
		try (Scanner scan = new Scanner(System.in)) {
			pousada.atualiza();
			int opcao = 0;
			do {
				menu();
				System.out.print("> ");
				opcao = scan.nextInt();
				
				switch (opcao) {
					case 1 -> cadastraQuarto(scan);
					case 2 -> System.out.println("Cadastrando reserva...");
					case 3 -> consultaQuartos();
				}
				
				System.out.println("\n\n");
			} while(opcao != 0);
			
			System.out.println("#--- Programa finalizado com sucesso ---#");
		
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}

	}
	
	private static void consultaQuartos() {
		System.out.println("\n#---> Consulta Quartos\n");
		
		try {
			List<Quarto> quartos = new QuartoDAO().consultaTodos();
			quartos.forEach(System.out::println);
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\nConsulta finalizada com sucesso #---> ");
	}

	private static void cadastraQuarto(Scanner scan) {
		System.out.println("\n#---> Cadastro de Quarto");
		
		System.out.print("\nInforme o número do quarto: > ");
		Integer numero = scan.nextInt();
		
		System.out.println("\nInforme a cartegoria do quarto.");
		System.out.print("Digite: 1 - VIP | 2 - Apartamento > ");
		Categoria categoria = scan.nextInt() == 1 ? Categoria.VIP : Categoria.APARTAMENTO;
		
		System.out.print("\nInforme a capacidade máxima do quarto: > ");
		Integer maxPessoas = scan.nextInt();
		
		System.out.print("\nInforme o valor da diária do quarto: > ");
		Double valorDiaria = scan.nextDouble();
		
		Quarto quarto = new Quarto(numero, categoria, maxPessoas, valorDiaria);

		try {
			new QuartoDAO().salva(quarto);
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\nQuarto cadastrado com sucesso #---> ");
	}

	private static void menu() {
		System.out.println("|-----------------------------|");
		System.out.println("|          POUSADA            |");
		System.out.println("|                             |");
		System.out.println("| Digite a opção desejada:    |");
		System.out.println("| 1 - Cadastrar quarto        |");
		System.out.println("| 2 - Cadastrar reserva       |");
		System.out.println("| 3 - Consultar quartos       |");
		System.out.println("| 0 - Sair do sistema         |");
		System.out.println("|-----------------------------|");
	}

}
