/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.huffman;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
        Scanner leitorAlternativo = new Scanner(arquivoEntrada); // leitor usado no final
        File arquivoSaida = new File("compactado.txt");
        FileWriter writer = new FileWriter(arquivoSaida);

        while(leitorEntrada.hasNextLine()) { // lê as linhas do arquivo e conta as frequencias
            
            String s = leitorEntrada.nextLine();
            for(char c : s.toCharArray()) {    
                ContaCaracteres.contaFrequencia(c);
            }
            ContaCaracteres.contaFrequencia('\n');
        }
        
        Map<Character, Integer> mapa = ContaCaracteres.getFrequencia(); // mapa de frequencias
        ArrayList<Arvore> arvores = new ArrayList(); // arvores, inicialmente de cada caractere
        
        for (char key : mapa.keySet()) { // cria as primeiras arvores
            System.out.println(key + ":" + mapa.get(key));
            
            Arvore t = new Arvore();
            t.novaArvoreUnitaria(mapa.get(key), key);
            arvores.add(t);
        }
        
        while(arvores.size()>1){ // junta arvores ate que sobre apenas uma
            Arvore t1 = arvores.remove(arvores.indexOf(Collections.min(arvores)));
            Arvore t2 = arvores.remove(arvores.indexOf(Collections.min(arvores)));
            Arvore resultado  = t1.fundirArvore(t2);
            arvores.add(resultado); 
        }

        Map<Character, String> tabelaSimbolos = new HashMap<Character, String>();
        // preencher tabela final de simbolos
        arvores.getFirst().preencheTabelaSimbolos(arvores.getFirst().getRaiz(), tabelaSimbolos, "");
         
        for (char key : tabelaSimbolos.keySet()) {
            System.out.println(key + "  :  " +tabelaSimbolos.get(key));    
        }
        // escreve resultado no output
        Escritor.escrever(tabelaSimbolos,leitorAlternativo, arquivoSaida);
    }
}
