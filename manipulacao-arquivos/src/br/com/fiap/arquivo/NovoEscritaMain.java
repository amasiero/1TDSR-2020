package br.com.fiap.arquivo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NovoEscritaMain {

    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        if(arquivo.canWrite()) {
            try ( // Java 8
                    FileWriter fw = new FileWriter(arquivo);
                    PrintWriter writer = new PrintWriter(fw)
            ) {
                writer.println("#--- Arquivo escrito com Java 15 ---#");
                writer.println("- Hello Arquivo! Sem close agora -");

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
