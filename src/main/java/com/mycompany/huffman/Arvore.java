/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.huffman;

import java.util.Stack;

/**
 *
 * @author Thiago
 */
public class Arvore {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thiago
 */

    // TODO: Refazer arvore de acordo com o algoritmo de huffman
    
    // definir arvore de acordo com 
    static class Nodo{
        int dado;
        Nodo pai;
        Nodo esq;
        Nodo dir;

        public Nodo (int dado, Nodo pai){
            this.dado = dado;
            this.pai = pai;
            this.esq = null;
            this.dir = null;   
        }

    }
    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    // despois criar métodos

    public void inserir(int dado){
        if (this.raiz==null){
            raiz = new Nodo(dado, null);
        }else{
            inserir(dado, raiz);
        }


    }

    // redefinir de acordo com huffman
    private void inserir(int dado, Nodo pai){

        Nodo atual = pai;

        if (dado < atual.dado){
            if(atual.esq == null){
                atual.esq = new Nodo(dado, atual);
            }else{
                atual = atual.esq;
                inserir(dado, atual);
            }
        }else if(dado > atual.dado){
            if(atual.dir == null){
                atual.dir = new Nodo(dado, atual);
            }else{
                atual = atual.dir;
                inserir(dado, atual);
            }  
        }

    }

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
    public void printPreOrder(Nodo no){ //raiz->esquerda->direita

        if (no==null){return;}

        System.out.print(" "+no.dado);
        
        printPreOrder(no.esq);  
        

    
        printPreOrder(no.dir);

    

    }



    // Post Order:
    // A lógica é esquerda->direita->raiz
    public void printPostOrder(Nodo no){ // esquerda->direita->raiz

        if (no==null){return;}


        
        printPostOrder(no.esq);  
        

        
        printPostOrder(no.dir);

        

        System.out.print(" "+no.dado);

    }
    
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
    
}



