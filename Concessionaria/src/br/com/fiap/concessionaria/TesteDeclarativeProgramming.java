package br.com.fiap.concessionaria;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.fiap.concessionaria.model.Automovel;

public class TesteDeclarativeProgramming {

	public static void main(String[] args) {
		List<Automovel> automoveis = getAutomoveis();
		// Declarative programming -> Strem API -> a partir Java 8
		// Filter
		List<Automovel> filtrado = automoveis.stream()
				.filter(automovel -> automovel.getPreco() < 15000.0)
				.collect(Collectors.toList());
		
		filtrado.forEach(System.out::println);
		// Sort
		List<Automovel> ordenado = automoveis.stream()
				.sorted(Comparator
						.comparing(Automovel::getMarca)
						.thenComparing(Automovel::getPreco)
				)
				.collect(Collectors.toList());
		
		ordenado.forEach(System.out::println);
		
		// All match
		boolean allMatch = automoveis.stream()
				.allMatch(auto -> auto.getPreco() > 10000);
		System.out.println(allMatch);
		
		// Any match
		boolean anyMatch = automoveis.stream()
				.anyMatch(auto -> auto.getPreco() < 13000);
		System.out.println(anyMatch);
		
		// None match
		boolean noneMatch = automoveis.stream()
				.noneMatch(auto -> auto.getPreco() < 12000);
		System.out.println(noneMatch);
		
		// Max
		automoveis.stream()
			.max(Comparator.comparing(Automovel::getPreco))
			.ifPresent(System.out::println);
		
		// Min
		automoveis.stream()
			.min(Comparator.comparing(Automovel::getPreco))
			.ifPresent(System.out::println);

		// Group
		Map<String, List<Automovel>> agrupados = automoveis.stream()
				.collect(Collectors.groupingBy(Automovel::getMarca));
		
		agrupados.forEach((marca, autos) -> {
			System.out.println(marca);
			autos.forEach(System.out::println);
			System.out.println("-----------------------------------");
		});
		
		automoveis.stream()
			.filter(automovel -> automovel.getMarca().equals("Mitsubishi"))
			.max(Comparator.comparing(Automovel::getPreco))
			.map(Automovel::getModelo)
			.ifPresent(System.out::println);
			

	}
	
	public static List<Automovel> getAutomoveis() {
		return List.of(
				new Automovel("Ferrari", "F480", 15000.0),
				new Automovel("Lamborguini", "Aventador", 18000.0),
				new Automovel("Audi", "R8", 14000.0),
				new Automovel("BMW", "i8", 16500.0),
				new Automovel("Mitsubishi", "Lancer Evo", 13000.0),
				new Automovel("Audi", "TT", 12000.0),
				new Automovel("Subaru", "WRX", 14500.0),
				new Automovel("Mitsubishi", "Eclipse", 12000.0),
				new Automovel("Mitsubishi", "3000GT", 10000.0)
				);
	}

}
