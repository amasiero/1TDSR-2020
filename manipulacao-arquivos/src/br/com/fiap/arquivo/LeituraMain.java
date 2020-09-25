package br.com.fiap.arquivo;

import java.io.*;

public class LeituraMain {

    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        if(arquivo.exists() && arquivo.canRead()) {
            try {
                FileReader fr = new FileReader(arquivo);
                BufferedReader reader = new BufferedReader(fr);

                String linha;
                while ((linha = reader.readLine()) != null) {
                    System.out.println(linha);
                }

                reader.close();
                fr.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
