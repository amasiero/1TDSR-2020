import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteScannerJava8 {

	public static void main(String[] args) {

		try (Scanner scan = new Scanner(System.in)) {
			int numero = scan.nextInt();
			System.out.println(numero);
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} 

	}

}
