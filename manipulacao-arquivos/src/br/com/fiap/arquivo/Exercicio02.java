package br.com.fiap.arquivo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Exercicio02 {

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Informe a quantidade de linhas: > ");
            int linhas = scan.nextInt();
            System.out.print("Informe a quantidade de colunas: > ");
            int colunas = scan.nextInt();

            FileWriter fileWriter = new FileWriter("matriz.txt");
            PrintWriter writer = new PrintWriter(fileWriter);

            for(int i = 0; i < linhas; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < colunas; j++) {
                    sb.append(String.format("%d\t", new Random().nextInt(1000)));
                }
                writer.println(sb.toString());
            }

            writer.close();
            fileWriter.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
