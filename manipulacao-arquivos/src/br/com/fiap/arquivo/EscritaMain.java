package br.com.fiap.arquivo;

import java.io.*;

public class EscritaMain {

    public static void main(String[] args) {
        try {
            File arquivo = new File("arquivo.txt");
            FileWriter fw = new FileWriter(arquivo);
            PrintWriter writer = new PrintWriter(fw);

            writer.println("#--- Arquivo escrito com Java 15 ---#");
            writer.println("- Hello Arquivo! -");

            writer.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
