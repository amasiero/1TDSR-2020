package br.com.fiap.arquivo;

import java.io.*;
import java.util.Random;

public class Exercicio03 {

    public static void main(String[] args) {

        try {
           FileReader fileReader = new FileReader("numeros.txt");
           BufferedReader reader = new BufferedReader(fileReader);

           double maximo = 0.0;
           String linha;
           while ((linha = reader.readLine()) != null) {
               double numero = Double.parseDouble(linha);
               if(numero > maximo) maximo = numero;
           }

           System.out.println(maximo);

           reader.close();
           fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
