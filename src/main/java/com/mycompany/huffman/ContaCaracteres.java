/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aluno
 */
public  class ContaCaracteres {
    private static Map<Character, Integer> frequencia = new HashMap<Character, Integer>();

    public ContaCaracteres() {

    }
    
    public static void contaFrequencia(char c){
        if (c=='\n'){c='-';} // \n equivale a -         -> ha apenas numeros no arquivo de entrada
        if (c==(char) 32){c='_';} // espaço equivale a _
        int count = frequencia.containsKey(c) ? frequencia.get(c) : 0;
        frequencia.put(c, count + 1);
    }

    public static Map<Character, Integer> getFrequencia() {
        return frequencia;
    }
}
