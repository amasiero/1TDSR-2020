package questao01;

import java.time.LocalDate;

public class VooFumantes extends Voo {
	
	private int cadeirasFumantes;
	private int maxVagas;
	
	public VooFumantes(int numero, LocalDate data, int maxVagas, int cadeirasFumantes) {
		super(numero, data, new boolean[maxVagas]);
		this.cadeirasFumantes = cadeirasFumantes;
		this.maxVagas = maxVagas;
	}
	
	public int maxVagas() {
		return this.maxVagas;
	}
	
	public int cadeirasFumantes() {
		return this.cadeirasFumantes;
	}
	
	public char tipo(int lugar) {
		int posicaoFumante = this.maxVagas - this.cadeirasFumantes;
		int posicaoLugar = lugar - 1;
		return posicaoLugar >= posicaoFumante ? 'F' : 'N';
	}

}
