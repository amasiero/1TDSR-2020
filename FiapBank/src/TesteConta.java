
public class TesteConta {
	
	public static void main(String[] args) {
		
		Conta primeiraConta = new Conta(1, 1562);
		primeiraConta.deposita(5500);
		
		System.out.println(primeiraConta.getSaldo());
		
		Conta segundaConta = new Conta(1, 1563);
		segundaConta.deposita(3000);
		boolean sacou = segundaConta.saca(150);
		
		if(sacou) {
			System.out.println("Saque efetuado com sucesso.");
		} else {
			System.err.println("Saldo insuficiente.");
		}
		System.out.println(segundaConta.getSaldo());
		
		if(primeiraConta.transfere(2300, segundaConta)) {
			System.out.println("Transferência efetuada com sucesso.");
		} else {
			System.err.println("Saldo insuficiente.");
		}
		System.out.println(primeiraConta.getSaldo());
		System.out.println(segundaConta.getSaldo());
		
	}
}
