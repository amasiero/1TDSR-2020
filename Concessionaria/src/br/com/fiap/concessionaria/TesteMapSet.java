package br.com.fiap.concessionaria;

import java.util.*;

public class TesteMapSet {

	public static void main(String[] args) {
		Map<String, String> contatos = new HashMap<>();
		contatos.put("Andrey", "profandrey.masiero@fiap.com.br");
		
		System.out.println(contatos.get("Andrey"));
		
		contatos.forEach((chave, valor) -> {
			System.out.println(chave + " - " + valor);
		});
		
		contatos.remove("Andrey");
		
		Set<Integer> numeros = new HashSet<>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(2);
		numeros.add(3);
		numeros.add(1);
		numeros.add(4);
		numeros.add(5);
		
		numeros.forEach(System.out::println);
		
		numeros.remove(2);
		numeros.forEach(System.out::println);
		
	}

}
