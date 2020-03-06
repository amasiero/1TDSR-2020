class Calculadora {
    int a;
    int b;

    void soma() {
        int soma = a + b;
        System.out.println("A soma foi " + soma);
    }

    int multiplicacao() {
        int multiplicacao = a * b;
        return multiplicacao;
    }

    void subtracao(int x, int y) {
        int subtracao = x - y;
        System.out.println("A subtracao foi " + subtracao);
    }

    int divisao(int tico, int teco) {
        int resultado = tico / teco;
        return resultado;
    }
}