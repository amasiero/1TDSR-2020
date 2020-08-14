package br.com.fiap.concessionaria.model;

import java.util.Objects;

public class Automovel {
	
	private String marca;
	private String modelo;
	private Double preco;
	
	public Automovel(String marca, String modelo, Double preco) {
		this.marca = marca;
		this.modelo = modelo;
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public Double getPreco() {
		return preco;
	}

	@Override
	public String toString() {
		return String.format("Automovel{marca='%s', modelo='%s', preco=%.2f}",
				marca, modelo, preco);
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Automovel) {
			Automovel auto = (Automovel) o;
			return this.marca.equals(auto.getMarca()) &&
					this.modelo.equals(auto.getModelo()) &&
					this.preco.equals(auto.getPreco());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(marca, modelo, preco);
	}
}
