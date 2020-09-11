package br.com.fiap.banco;

import br.com.fiap.banco.domain.Conta;

public class ReferenceVSValue {

	public static void main(String[] args) {
		// Referencia
		Conta conta = new Conta(1, "Z", "123"); // Classe -> referencia
		System.out.println(conta);
		alteraReferencia(conta);
		System.out.println(conta);
		
		// Valor
		int i = 10; // tipo primitivo -> Valor
		System.out.println(i);
		alteraValor(i);
		System.out.println(i);
		
		Integer numeroPorReferencia = 10;
		System.out.println(numeroPorReferencia);
		alteraValor(numeroPorReferencia);
		System.out.println(numeroPorReferencia);
		
		char x = 97;
		System.out.println(x);
	}
	
	private static void alteraValor(Integer i) {
		i = 20;
	}

	public static void alteraReferencia(Conta conta) {
		conta.deposita(15000);
	}
	
	// Classe

}
