/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huffman;

import java.io.FileWriter;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Thiago
 */
public class Arvore implements Comparable<Arvore>{

    

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
    
    
    /*
 * @author Thiago
 */

    // TODO: Refazer arvore de acordo com o algoritmo de huffman
    
    // definir arvore de acordo com 
    class Nodo{
        int frequencia;
        char letra;
        Nodo pai;
        Nodo esq;
        Nodo dir;
        boolean isFolha;

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

        public boolean isIsFolha() {
            return isFolha;
        }

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

        public void setIsFolha(boolean isFolha) {
            this.isFolha = isFolha;
        }
        
        

        public Nodo (int freq, Nodo pai, char ch, boolean tipoFolha){
            this.frequencia = freq;
            this.pai = pai;
            this.esq = null;
            this.dir = null;   
            this.letra = ch;
            isFolha = tipoFolha;
        }

    }
    private Nodo raiz;
    private int freq_arvore;
    
    public void novaArvoreUnitaria(int f, char ch){
        Nodo n = new Nodo(f, null, ch, true);
        this.raiz = n;
        this.freq_arvore = f;
    }

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

    // despois criar métodos
    public Arvore fundirArvore(Arvore tree){
        Nodo novaRaiz = new Nodo(0,null,(char)0,false);
        return fundirArvore(tree, novaRaiz);
        
    }

    // redefinir de acordo com huffman
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

    /*
    public void printInOrder(Nodo no){ // esquerda->raiz->direita

        if (no==null){return;}

        Stack<Nodo> pilha = new Stack<>();
        pilha.push(no);
        while(!pilha.isEmpty()){
            Nodo no_impressao = pilha.pop();
            if(no_impressao.esq!=null){
                pilha.push(no_impressao.esq);
            }
                

            System.out.print(" "+no_impressao.dado);

            if(no_impressao.dir!=null){
                pilha.push(no_impressao.dir);
            }
        }
        

    }

    // Pre Order : 
    // A lógica é raiz->esquerda->direita
    public void printPreOrder(Nodo no, FileWriter w){ //raiz->esquerda->direita

        if (no==null){return;}

        // 
        System.out.print(" "+no.dado);
        
        printPreOrder(no.esq, w);  
        

    
        printPreOrder(no.dir, w);

    

    }


/*
    */
    // Post Order:
    // A lógica é esquerda->direita->raiz
    public void preencheTabelaSimbolos(Nodo no, Map tb, String caminho){ // esquerda->direita->raiz
        if (no.isIsFolha()){
            tb.put(no.getLetra(), caminho);
        }else{
        
            preencheTabelaSimbolos(no.esq,tb, caminho+"0");  

            preencheTabelaSimbolos(no.dir,tb,caminho+"1");
        }
    }
    
    
    
    
   /* 
    public Byte acharCaminho(char c){
        Nodo n = PostOrderBusca(this.raiz,c);
        String
        while(!(n.equals(this.raiz))){
            if(n.getPai().getEsq().equals(n)){
                
            }
        }
        
    }*/
   /*
    public void printOutput(){
         // preorder
        System.out.print("Pre.:");
        printPreOrder(raiz);
        System.out.println();
      
        // inorder
        System.out.print("In..:");
        printInOrder(raiz);
        System.out.println();
        
        // postorder
        System.out.print("Post:");
        printPostOrder(raiz);
        System.out.println("\n");
    }

    public void buscar(int dado){
        buscar(dado);
    }
    // todo private void buscar(int dado){
        
    //}
    */
    
}


  

