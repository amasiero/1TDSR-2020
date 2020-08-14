package br.com.fiap.concessionaria;

//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;

import br.com.fiap.concessionaria.model.Automovel;
import br.com.fiap.concessionaria.model.Concessionaria;

public class ConcessionariaApplication {

	public static void main(String[] args) {
		Concessionaria concessionaria = new Concessionaria();
		
		Automovel a = new Automovel("Ferrari", "F480", 15000.0);
		Automovel b = new Automovel("Lamborguini", "Aventador", 18000.0);
		Automovel c = new Automovel("Audi", "R8", 14000.0);
		
		
		concessionaria.adicionaVeiculo(a);
		concessionaria.adicionaVeiculo(b);
		concessionaria.adicionaVeiculo(c);
		
		//System.out.println(concessionaria.consultaEstoqueVeiculos());
		
		concessionaria.vendaVeiculo(a);
		
		System.out.println(concessionaria.consultaEstoqueVeiculos());
		System.out.println(concessionaria.somaEstoque());
		System.out.println(concessionaria.consultaVeiculo(new Automovel("Audi", "R8", 14000.0)));
		
//		List<Automovel> veiculos = concessionaria.consultaEstoqueVeiculos();
//		double[] precos = veiculos.stream()
//				.mapToDouble(veiculo -> veiculo.getPreco())
//				.toArray();
//		System.out.println(Arrays.toString(precos));
		
		Automovel x = new Automovel("Audi", "R8", 14000.0);
		Object o = x;
		
		c.equals(o);
		
		
		
	}

}
