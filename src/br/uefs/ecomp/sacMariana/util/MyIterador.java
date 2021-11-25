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

//Implementação do codigo do iterador
public class MyIterador implements Iterador{
    
    private Celula atual;
    
    public MyIterador(Celula atual){
        this.atual = atual;
    }

    MyIterador() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean temProximo() {
        return (atual != null);        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object obterProximo() { //O metodo obter proximo retorna o Objeto da celula em que referencia no momento.
        Celula aux = atual;
        while (temProximo()){ // temProximo retorna valores booleandos do estado da lista.
            atual = atual.getNext();
            return aux.getObjeto();
        }
        return null;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
