/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huffman;


import java.util.Map;


/**
 *
 * @author aluno
 */
public class Arvore implements Comparable<Arvore>{
    // TODO: Refazer arvore de acordo com o algoritmo de huffman
    
    // definir arvore de acordo com huffman
    class Nodo{
        int frequencia;
        char letra;
        Nodo pai;
        Nodo esq;
        Nodo dir;
        boolean folha;

        
        // getters do nodo
        public int getFrequencia() {
            return frequencia;
        }

        public char getLetra() {
            return letra;
        }

        public Nodo getPai() {
            return pai;
        }

        public Nodo getEsq() {
            return esq;
        }

        public Nodo getDir() {
            return dir;
        }

        public boolean isFolha() {
            return folha;
        }

        // setters do nodo
        public void setFrequencia(int frequencia) {
            this.frequencia = frequencia;
        }

        public void setLetra(char letra) {
            this.letra = letra;
        }

        public void setPai(Nodo pai) {
            this.pai = pai;
        }

        public void setEsq(Nodo esq) {
            this.esq = esq;
        }

        public void setDir(Nodo dir) {
            this.dir = dir;
        }

        public void setFolha(boolean folha) {
            this.folha = folha;
        }

        public Nodo (int freq, Nodo pai, char ch, boolean tipoFolha){
            this.frequencia = freq;
            this.pai = pai;
            this.esq = null;
            this.dir = null;   
            this.letra = ch;
            folha = tipoFolha;
        }

    }
    private Nodo raiz;
    private int freq_arvore;
    
    
    // getters e setters da arvore
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void setFreq_arvore(int freq_arvore) {
        this.freq_arvore = freq_arvore;
    }

    public int getFreq_arvore() {
        return freq_arvore;
    }

    public Nodo getRaiz() {
        return raiz;
    }
    
    public void novaArvoreUnitaria(int f, char ch){
        Nodo n = new Nodo(f, null, ch, true);
        this.raiz = n;
        this.freq_arvore = f;
    }
    
    public Arvore fundirArvore(Arvore tree){
        Nodo novaRaiz = new Nodo(0,null,(char)0,false);
        return fundirArvore(tree, novaRaiz);
        
    }

    private Arvore fundirArvore(Arvore arvore, Nodo novaRaiz){
        Arvore tree = new Arvore();
        if(arvore.getFreq_arvore()>this.freq_arvore){ // criterio para organizar a arvore
            novaRaiz.setDir(arvore.getRaiz());
            novaRaiz.setEsq(raiz);
        }else{
            novaRaiz.setDir(raiz);
            novaRaiz.setEsq(arvore.getRaiz());
        }
        arvore.getRaiz().setPai(novaRaiz);
        this.raiz.pai = novaRaiz;
        
        novaRaiz.setFrequencia(freq_arvore+arvore.getFreq_arvore());
        tree.setRaiz(novaRaiz);
        tree.setFreq_arvore(freq_arvore+arvore.getFreq_arvore());
        
        return tree;
    }

    public void preencheTabelaSimbolos(Nodo no, Map tb, String caminho){ // esquerda->direita->raiz
        if (no.isFolha()){
            
            tb.put(no.getLetra(), caminho);
        }else{
        
            preencheTabelaSimbolos(no.esq,tb, caminho+"0");  

            preencheTabelaSimbolos(no.dir,tb,caminho+"1");
        }
    }
    
    
    @Override
    public int compareTo(Arvore arvoreDois) {
        if (this.freq_arvore < arvoreDois.getFreq_arvore()) {
            return -1;
        }
        if (this.freq_arvore >= arvoreDois.getFreq_arvore()) {
            return 1;
        }
        return 0;
    }
    
    
}