
public class Cinema {
	// ATRIBUTOS
	private double precoIngresso;
	private Sala sala; // TODO transforma em uma lista posteriormente
	
	// CONSTRUTORES
	public Cinema(Sala sala, double precoIngresso) {
		this.sala = sala;
		this.precoIngresso = precoIngresso;
	}

	// GETTERS E SETTERS
	public double getPrecoIngresso() {
		return precoIngresso;
	}

	public void setPrecoIngresso(double precoIngresso) {
		this.precoIngresso = precoIngresso;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	// DEMAIS METODOS
	public void vendeIngresso() {
		this.sala.ocupaLugar();
	}
	
	public double calculaFaturamento() {
		return this.sala.getLugaresOcupados() * this.precoIngresso;
	}
	
	public void finalizaSessao() {
		this.sala.esvazia();
	}
}
