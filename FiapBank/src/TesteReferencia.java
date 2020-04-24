
public class TesteReferencia {

	public static void main(String[] args) {
		Conta conta = new Conta(1, 1562);
		conta.deposita(500);
		System.out.println(conta.getSaldo());
		
		Conta novaConta = conta;
		System.out.println(novaConta.getSaldo());
		
		novaConta.deposita(400);
		System.out.println(conta.getSaldo());
		System.out.println(novaConta.getSaldo());
		
		System.out.println(conta);
		System.out.println(novaConta);
	}
}
