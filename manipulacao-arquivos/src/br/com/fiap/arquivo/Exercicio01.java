package br.com.fiap.arquivo;

import java.io.*;

public class Exercicio01 {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("arquivo.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            FileWriter fileWriter = new FileWriter("arquivo-destino.txt");
            PrintWriter writer = new PrintWriter(fileWriter);

            String linha;
            while ((linha = reader.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                for(char letra : linha.toCharArray()) {
                    if (letra == 32 ||
                            (letra >= 65 && letra <= 90) ||
                            (letra >= 97 && letra <= 122)) {
                        sb.append(letra);
                    }
                }
                writer.println(sb.toString().trim());
            }

            writer.close();
            fileWriter.close();

            reader.close();
            fileReader.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

}
