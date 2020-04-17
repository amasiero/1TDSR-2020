
public class Salario {

	private double valorHora;
	private double horasTrabalhadas;
	
	public Salario(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getValorHora() {
		return valorHora;
	}

	public void setValorHora(double valorHora) {
		this.valorHora = valorHora;
	}

	public double getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(double horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public double calculaSalario() {
		return this.horasTrabalhadas * this.valorHora;
	}
}
