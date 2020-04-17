import javax.swing.JOptionPane;

public class TesteOperadores {

	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
		
		String operacao = JOptionPane.showInputDialog("Digite:\n" +
				"* para multiplicacao\n" +
				"+ para adicao\n" +
				"- para subtracao\n" +
				"/ para divisao\n");
		
		double a = Double.parseDouble(JOptionPane.showInputDialog("Informe um numero"));
		double b = Double.parseDouble(JOptionPane.showInputDialog("Informe um novo numero"));
		
		switch(operacao) {
			case "*":
				JOptionPane.showMessageDialog(null, calc.multiplicacao(a, b));
				break;
			case "+":
				JOptionPane.showMessageDialog(null, calc.soma(a, b));
				break;
			case "-":
				JOptionPane.showMessageDialog(null, calc.subtracao(a, b));
				break;
			case "/":
				JOptionPane.showMessageDialog(null, calc.divisao(a, b));
				break;
		}
	}
}
