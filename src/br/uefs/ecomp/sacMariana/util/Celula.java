/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.sacMariana.util;

/**
 *
 * @author VAGNER
 */

//Codigo que define a lista duplamente encadeada
public class Celula {
    private Celula next;  //Referência para a proxima célula da lista
    private Celula previous; // Referencia pra celua anterior da lista
    private Object objeto; //Referência genérica para um objeto
    
//Construtores e getters e Sets
    
    
    public Celula(Celula next, Celula previous, Object objeto) {
        this.next = next;
        this.previous = previous;
        this.objeto = objeto;
    }

    Celula(Celula primeira, Object objeto) {
        this.next = primeira;
        this.objeto =objeto;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Celula(Object objeto){
        this.objeto = objeto;
    }
    
    
    

    public Celula getNext() {
        return next;
    }

    public void setNext(Celula next) {
        this.next = next;
    }

    public Celula getPrevious() {
        return previous;
    }

    public void setPrevious(Celula previous) {
        this.previous = previous;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    
}
