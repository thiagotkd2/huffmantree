/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huffman;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Thiago
 */
public class Escritor {
    public static void escrever (FileWriter w, Map m, Scanner s, File f) throws IOException{
        while (s.hasNextLine()){
            String linha = s.nextLine();
            String saida = "";
            for(char c : linha.toCharArray()){
                if(c=='\n'){c='-';}
                if(c==(char) 32){c='_';}
                System.out.println(m.get(c));
                saida+=m.get(c); 
            }
                
                Files.write(f.toPath(), saida.getBytes(), StandardOpenOption.APPEND);
            
        }
    }
}
