import javax.swing.JOptionPane;

public class TesteProduto {

	public static void main(String[] args) {
		double valorTotal = 0;
		int item = 1;

		while(item <= 3) {
			int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade"));
			double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preco"));
			double desconto = Double.parseDouble(JOptionPane.showInputDialog("Informe o desconto"));
			Produto produto =  new Produto(quantidade, preco, desconto);
			valorTotal += produto.calculaTotal();
			item += 1;
		}
		
		JOptionPane.showMessageDialog(null, "O valor total eh R$ " + valorTotal);
	}
	
}
