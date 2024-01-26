/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huffman;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thiago
 */
public  class ContaCaracteres {
    private static Map<Character, Integer> frequencia = new HashMap<Character, Integer>();

    public ContaCaracteres() {

    }
    
    public static void contaFrequencia(char c){
        var count = frequencia.containsKey(c) ? frequencia.get(c) : 0;
        frequencia.put(c, count + 1);
    }

    public static Map<Character, Integer> getFrequencia() {
        return frequencia;
    }
}
