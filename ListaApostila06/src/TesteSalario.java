import javax.swing.JOptionPane;

public class TesteSalario {
	
	public static void main(String[] args) {
		double valorHora = Double.parseDouble(JOptionPane.showInputDialog("Informe seu valor hora"));
		Salario salario = new Salario(valorHora);
		double horasTrabalhadas = Double.parseDouble(JOptionPane.showInputDialog("Informe a quantidade de horas trabalhadas"));
		salario.setHorasTrabalhadas(horasTrabalhadas);
		JOptionPane.showMessageDialog(null, "Seu salario será de R$ " + salario.calculaSalario());
	}
	
}
