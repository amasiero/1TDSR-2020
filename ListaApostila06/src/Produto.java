
public class Produto {
	private int quantidade;
	private double preco;
	private double desconto;
	
	public Produto(int quantidade, double preco, double desconto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}
	
	public double calculaTotal() {
		return quantidade * preco * (1 - (desconto / 100));
	}
}
