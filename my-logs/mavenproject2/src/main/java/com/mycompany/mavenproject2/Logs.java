/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author phaap
 */
public class Logs {

    public void pastaLog() {
        String nome = "C:\\log_dev_mob\\arq_01.txt";

        File objFile = new File(nome);
        if (objFile.exists()) {
            if (objFile.isFile()) {
                System.out.printf("\nArquivo (%s) existe - tamanho: %d bytes\n",
                        objFile.getName(), objFile.length());
            } else {
                System.out.printf("\nConteúdo do diretório:\n");
                String diretorio[] = objFile.list();
                for (String item : diretorio) {
                    System.out.printf("%s\n", item);
                }
            }
        } else {
            java.io.File diretorioc = new java.io.File("C:\\log_dev_mob");
            // criando pasta
            boolean statusDir = diretorioc.mkdir();
            System.out.print(statusDir);
            // criando arquivo
            java.io.File arquivo = new java.io.File(diretorioc, "arq_01.txt");
            try {
                boolean statusArq = arquivo.createNewFile();
                System.out.print(statusArq);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public void escrevendoLog() throws IOException{
        Scanner ler = new Scanner(System.in);
        Scanner ler2 = new Scanner(System.in);
        Scanner ler3 = new Scanner(System.in);


    System.out.printf("Infome texte:\n");
    String palavra = ler.nextLine();
        String palavra2 = ler.nextLine();

            String palavra3 = ler.nextLine();


    FileWriter arq = new FileWriter("C:\\log_dev_mob\\arq_01.txt");
    PrintWriter gravarArq = new PrintWriter(arq);

    gravarArq.printf(palavra);
    gravarArq.printf(palavra2);
    gravarArq.printf(palavra3);
    arq.close();

    System.out.printf("gravou");

    }
private static final String newLine = System.getProperty("line.separator");

public synchronized void sobreEscrver(String msg)  {
    String fileName = "C:\\log_dev_mob\\arq_01.txt";
    PrintWriter printWriter = null;
    File file = new File(fileName);
    try {
        if (!file.exists()) file.createNewFile();
        printWriter = new PrintWriter(new FileOutputStream(fileName,true));
        printWriter.write(newLine + msg);
    } catch (IOException ioex) {
        ioex.printStackTrace();
    } finally {
        if (printWriter != null) {
            printWriter.flush();
            printWriter.close();
        }
    }
}
}
