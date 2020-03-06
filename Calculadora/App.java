import java.util.Scanner;

class App {
    public static void main(String[] args) {
        // Criando o objeto Calculadora
        Calculadora calc = new Calculadora();
        Scanner entrada = new Scanner(System.in);
        // Atribuindo valores a Calculadora
        System.out.print("Digite um numero: ");
        calc.a = entrada.nextInt();
        System.out.print("Digite outro numero: ");
        calc.b = entrada.nextInt();
        // Executar a soma
        calc.soma();
        // Executar a multiplicacao
        int resultado = calc.multiplicacao();
        System.out.println("A multiplicacao foi " + resultado);
        // Executar a subtracao
        calc.subtracao(84, 42);
        // Executar a divisao
        resultado = calc.divisao(14, 7);
        System.out.println("A divisao foi " + resultado);
    }
}