import javax.swing.JOptionPane;

public class TesteCliente {

	public static void main(String[] args) {
		int cep = Integer.parseInt(JOptionPane.showInputDialog("Informe o cep"));
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero da residencia"));
		Endereco endereco = new Endereco(cep, numero);
		
		int ddd = Integer.parseInt(JOptionPane.showInputDialog("Informe o seu ddd"));
		int operadora = Integer.parseInt(JOptionPane.showInputDialog("Informe sua operadora"));
		numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o seu numero de telefone"));
		Telefone telefone = new Telefone(numero, operadora, ddd);
		
		String nome = JOptionPane.showInputDialog("Informe seu nome");
		String email = JOptionPane.showInputDialog("Informe seu email");
		Cliente cliente = new Cliente(nome, email, telefone, endereco);
		
		JOptionPane.showMessageDialog(null, "O cliente informado é " + cliente.getNome());
	}
}
