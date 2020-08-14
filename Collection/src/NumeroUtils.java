//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumeroUtils {
	
	public static List<Integer> filtra(List<Integer> numeros, Predicado regra) {
		return numeros.stream()
				.filter(regra::valida)
				.collect(Collectors.toList());
		
//		return numeros.stream()
//				.filter(numero -> regra.valida(numero))
//				.collect(Collectors.toList());
		
//		List<Integer> filtrado = new ArrayList<>();
//		numeros.forEach(numero -> {
//			if(regra.valida(numero)) {
//				filtrado.add(numero);
//			}
//		});
//		return filtrado;
	}
	
}
