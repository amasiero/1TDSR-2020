
public class Voo {
	private int numero;
	private Data data;
	private boolean[] lugaresOcupados;
	
	public Voo(int numero, Data data) {
		this.numero = numero;
		this.data = data;
		this.lugaresOcupados = new boolean[100];
	}
	
	public Voo(int numero, Data data, boolean[] lugaresOcupados) {
		this(numero, data);
		this.lugaresOcupados = lugaresOcupados;
	}

	public int getNumero() {
		return numero;
	}

	public Data getData() {
		return data;
	}
	
	public int proximoLivre() {
		for(int i = 0; i < this.lugaresOcupados.length; i++) {
			if(!this.lugaresOcupados[i]) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public boolean verifica(int numero) {
		return this.lugaresOcupados[numero - 1];
	}
	
	public boolean ocupa(int numero) {
		if(this.verifica(numero)) { return false; }
		this.lugaresOcupados[numero - 1] = true;
		return true;
	}
	
	public int vagas() {
		int contador = 0;
		for(int i = 1; i <= this.lugaresOcupados.length; i++) {
			if(!this.verifica(i)) {
				contador++;
			}
		}
		return contador;
	}
	
	public Voo clone() {
		return new Voo(this.numero, this.data, this.lugaresOcupados);
	}
	
}
