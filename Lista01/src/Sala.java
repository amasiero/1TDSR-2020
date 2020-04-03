
public class Sala {
	
	private int capacidade;
	private int lugaresOcupados;
	
	public Sala(int capacidade) {
		this.capacidade = capacidade;
		this.lugaresOcupados = 0;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	public int getLugaresOcupados() {
		return lugaresOcupados;
	}

	public void setLugaresOcupados(int lugaresOcupados) {
		this.lugaresOcupados = lugaresOcupados;
	}
	
	public boolean temLugar() {
		return this.lugaresOcupados < this.capacidade;
	}
	
	public void ocupaLugar() {
		// TODO mais para frente, fazer um novo metodo que receba mais do que um lugar
		if(this.temLugar()) {
			this.lugaresOcupados++;
		} else {
			System.err.println("Não existem mais lugares disponíveis.");
		}
	}
	
	public void esvazia() {
		this.lugaresOcupados = 0;
	}
}
