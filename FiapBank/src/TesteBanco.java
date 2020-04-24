
public class TesteBanco {

	public static void main(String[] args) {
	
		
		Cliente cliente = new Cliente("Valentina", 1234, "1TDSR");
		Conta conta = new Conta(1, 1562, cliente);
		System.out.println(Conta.getTotalContas());
		Conta conta2 = new Conta(1, 1562, cliente);
		System.out.println(Conta.getTotalContas());
		Conta conta3 = new Conta(1, 1562, cliente);
		System.out.println(Conta.getTotalContas());
		
		
		conta.setTitular(cliente);
		conta.deposita(400);
		
		System.out.println(conta.getTitular().getNome());
		System.out.println(conta.getTitular().getRm());
		System.out.println(conta.getTitular().getTurma());
		System.out.println(conta.getAgencia());
		System.out.println(conta.getNumero());
		System.out.println(conta.getSaldo());
		
	}
	
}
