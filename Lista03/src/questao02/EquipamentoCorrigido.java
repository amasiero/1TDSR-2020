package questao02;

public class EquipamentoCorrigido extends Equipamento {
	
	private int mesCorrente;
	private int[] mesCompra;
	
	public EquipamentoCorrigido(int numeroEquipamentos) {
		super(numeroEquipamentos);
		this.mesCorrente = 1;
		this.mesCompra = new int[numeroEquipamentos];
	}
	
	public int getMesCompra(int numero) {
		return this.mesCompra[numero];
	}
	
	public void setMesCompra(int numero, int mesCompra) {
		this.mesCompra[numero] = mesCompra;
	}
	
	public void corrige(int percentual) {
		for(int i = 0; i < this.mesCompra.length; i++) {
			if(this.mesCompra[i] == this.mesCorrente) {
				this.setValor(i, this.getValor(i) * (percentual/100));
			}
		}
		
		if(this.mesCorrente == 12) {
			this.mesCorrente = 1;
		} else {
			this.mesCorrente++;
		}
	}
	
	public void substitui(EquipamentoCorrigido outro) {
		if(this.getNumeroEquipamentos() == outro.getNumeroEquipamentos()) {
			for(int i = 0; i < this.getNumeroEquipamentos(); i++) {
				this.setValor(i, outro.getValor(i));
				this.setMesCompra(i, outro.getMesCompra(i));
			}
		}
	}

}
