/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huffman;


import java.io.DataOutputStream;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Escritor {
    public static void escrever (Map<Character, String> m, Scanner s, File f) throws IOException{
        DataOutputStream out = new DataOutputStream(new FileOutputStream(f.getPath()));
        while (s.hasNextLine()){
            String linha = s.nextLine();
            for(char c : linha.toCharArray()){
                if(c=='\n'){c='-';} // \n
                if(c==(char) 32){c='_';} // espaco
                out.write(Integer.parseInt(m.get(c),2));
            }  
        }
    }
}
