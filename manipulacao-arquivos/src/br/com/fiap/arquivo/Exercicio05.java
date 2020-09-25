package br.com.fiap.arquivo;

import java.io.*;

public class Exercicio05 {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("exercicio5.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            int soma = 0;
            reader.readLine();

            String linha;
            while ((linha = reader.readLine()) != null) {
                soma += Integer.parseInt(linha.split(",")[1]);
            }

            System.out.println(soma);
            reader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
