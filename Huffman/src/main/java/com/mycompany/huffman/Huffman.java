/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.huffman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Huffman {

    public static void main(String[] args) throws IOException{
        
        System.out.print("Escreva o arquivo de entrada: ");
        Scanner in = new Scanner(System.in);
        String caminhoArquivoEntrada = in.nextLine();

        File arquivoEntrada = new File(caminhoArquivoEntrada);
        Scanner leitorEntrada = new Scanner(arquivoEntrada);
        File arquivoSaida = new File("compactado.txt");
        FileWriter writer = new FileWriter(arquivoSaida);

        

        while(leitorEntrada.hasNext()) { // lê as linha do arquivo
            char c = leitorEntrada.next().charAt(0);
            ContaCaracteres.contaFrequencia(c);
            
        }
        
        Map<Character, Integer> mapa = ContaCaracteres.getFrequencia();
        
        for (char key : mapa.keySet()) {
            System.out.println(key + ":" + mapa.get(key));
        }
    
        
    }
}
