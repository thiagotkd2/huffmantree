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
        Scanner leitorAlternativo = new Scanner(arquivoEntrada);
        File arquivoSaida = new File("compactado.txt");
        FileWriter writer = new FileWriter(arquivoSaida);

        while(leitorEntrada.hasNextLine()) { // lê as linha do arquivo
            
            String s = leitorEntrada.nextLine();
            for(char c : s.toCharArray()) {
                System.out.println(c);    
                ContaCaracteres.contaFrequencia(c);
            }
            ContaCaracteres.contaFrequencia('\n');
        }
        
        Map<Character, Integer> mapa = ContaCaracteres.getFrequencia();
        ArrayList<Arvore> arvores = new ArrayList();
        int valor_freq_total= 0;
        for (char key : mapa.keySet()) {
            System.out.println(key + ":" + mapa.get(key));
            valor_freq_total += mapa.get(key);
            Arvore t = new Arvore();
            t.novaArvoreUnitaria(mapa.get(key), key);
            System.out.println("Arvore: "+t.getRaiz().getLetra() + " " + t.getRaiz().getFrequencia() + " " + t.getFreq_arvore());
            System.out.println(t.getRaiz().isIsFolha() + " "+ t.getRaiz().getLetra());
            arvores.add(t);
        }
        
        while(arvores.size()>1){
            Arvore t1 = arvores.remove(arvores.indexOf(Collections.min(arvores)));
            Arvore t2 = arvores.remove(arvores.indexOf(Collections.min(arvores)));
            System.out.println("Freq arvore 1 : "+t1.getFreq_arvore());
            System.out.println("Freq arvore 2 : "+t2.getFreq_arvore());
            
            Arvore resultado  = t1.fundirArvore(t2);
            System.out.println(resultado.getFreq_arvore());
            arvores.add(resultado); 
        }
        
        System.out.println(arvores.get(0).getFreq_arvore());
        System.out.println(arvores.get(0).getRaiz().getEsq().getFrequencia() +" "+arvores.get(0).getRaiz().getEsq().getLetra());
        System.out.println(valor_freq_total);
        System.out.println(arvores.get(0).getFreq_arvore()==valor_freq_total);
        
        Map<Character, String> tabelaSimbolos = new HashMap<Character, String>();
        arvores.getFirst().preencheTabelaSimbolos(arvores.getFirst().getRaiz(), tabelaSimbolos, "");
         
        for (char key : tabelaSimbolos.keySet()) {
            System.out.println(key + "  :  " +tabelaSimbolos.get(key));    
        }
        Escritor.escrever(writer, tabelaSimbolos,leitorAlternativo, arquivoSaida);
    }
}
