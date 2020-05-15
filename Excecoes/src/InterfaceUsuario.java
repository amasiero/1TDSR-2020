import javax.swing.JOptionPane;

public class InterfaceUsuario {

	public static int recebeNumero(String mensagem) {
		try {
			int numero = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			return numero;
		} catch (NumberFormatException e) {
			System.err.println("Verifique se você não digitou um texto ao invés de um número.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Ele executa sempre, com sucesso ou não do nosso código");
		}
		return recebeNumero(mensagem);
	}
	
	public static void main(String[] args) {
		System.out.println(recebeNumero("Digite um numero"));
	}
}
