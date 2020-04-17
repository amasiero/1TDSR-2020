
public class ContaCorrente {
	private double saldo;
	private Cliente cliente;
	
	public ContaCorrente(double saldo, Cliente cliente) {
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
