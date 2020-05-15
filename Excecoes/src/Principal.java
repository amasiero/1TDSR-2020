public class Principal {

	public static void metodo2() {
		System.out.println("Entrando no método 2");
		
		try {
			int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			for(int i = 0; i <= 10; i++) {
				System.out.println(numeros[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		
		System.out.println("Saindo do método 2");
	}

	public static void metodo1() {
		System.out.println("Entrando no método 1");
		metodo2();
		System.out.println("Saindo do método 1");
	}

	public static void main(String[] args) {

		System.out.println("Entrando no método MAIN");
		metodo1();
		System.out.println("Saindo do método MAIN");

	}

}
