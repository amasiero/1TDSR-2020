package br.com.fiap.arquivo;

import java.io.*;
import java.util.Random;

public class Exercicio04 {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("somas.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            File arquivo = new File("somas-resultado.txt");
            FileWriter fw = new FileWriter(arquivo);
            PrintWriter writer = new PrintWriter(fw);

            String linha;
            while ((linha = reader.readLine()) != null) {
                int numero1 = Integer.parseInt(linha.split(",")[0]);
                int numero2 = Integer.parseInt(linha.split(",")[1]);
                writer.println(String.format("%s,%s,%s", numero1, numero2, (numero1 + numero2)));
            }

            reader.close();
            fileReader.close();
            writer.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
