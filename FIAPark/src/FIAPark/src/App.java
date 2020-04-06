import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Informe a placa do veiculo: ");
		String placa = scan.nextLine();
		
		System.out.print("Informe a marca do veiculo: ");
		String marca = scan.nextLine();
		
		System.out.print("Informe o modelo do veiculo: ");
		String modelo = scan.nextLine();
		
		Veiculo veiculo = new Veiculo(placa, marca, modelo);
		Ticket ticket = new Ticket(veiculo);
		
		System.err.println(ticket);
		
		System.out.printf("Veiculo %s %s com placa %s, estacionado na data %s com sucesso.\n", 
				ticket.getVeiculo().getMarca(), ticket.getVeiculo().getModelo(), ticket.getVeiculo().getPlaca(), ticket.entradaParaTexto());
		
		try {
			Thread.sleep(60000);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		ticket.registraSaida();
		
		System.err.println(ticket);
		
		System.out.printf("Veiculo %s %s com placa %s, saiu na data %s.\nO valor recebido foi de R$ %.2f.\n", 
				ticket.getVeiculo().getMarca(), ticket.getVeiculo().getModelo(), ticket.getVeiculo().getPlaca(), ticket.saidaParaTexto(),
				ticket.getValor());
		
		scan.close();
	}

}
