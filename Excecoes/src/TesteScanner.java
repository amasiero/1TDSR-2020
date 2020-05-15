import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteScanner {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		try {
			int numero = scan.nextInt();
			System.out.println(numero);
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}
}
