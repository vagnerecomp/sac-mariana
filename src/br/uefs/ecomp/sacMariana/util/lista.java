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

//lista generica implementada a partir da interface Iliste.
public class lista implements ILista{
    
    private Celula primeira;
    private Celula ultima;
    private int contObjetos = 0; //Conta quantas celulas uma lista possui.
   
    
// Checa se a lista está varia e retorna um valor booleano
    @Override
    public boolean estaVazia() {
        //if(this.contObjetos != 0){
        //} else {
          //  return true;
        //}
        return primeira == null;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public int obterTamanho() {
        int tamanho = 0;
        Iterador x = new MyIterador();
        while (x.temProximo()){
            tamanho++;
            x.obterProximo();
        }
        return tamanho;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirInicio(Object objeto) {
        if(this.contObjetos == 0){ //Quando o atributo contObjetos vale 0, significa que a lista está vazia
          Celula nova = new Celula(objeto);
          this.primeira = nova;
          this.ultima = nova;
        } else {
          Celula nova = new Celula(this.primeira, objeto);
          this.primeira.setPrevious(nova);
          this.primeira = nova;
        }
        this.contObjetos++;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserirFinal(Object objeto) {
        
        if (this.contObjetos == 0) {
          this.inserirInicio(objeto); //Quano a lista duplamente ligada está vazia, inserir no inicio e no fim tem o mesmo efeito.
        } else {
          Celula nova = new Celula(objeto);
          this.ultima.setNext(nova);
          nova.setPrevious(this.ultima);
          this.ultima = nova;
          this.contObjetos++;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object removerInicio() {
        if(this.primeira==null){
            return null;
        }else if(this.primeira.getNext() == null){
            Celula aux = this.primeira;
            this.primeira = this.primeira.getNext();
            return aux.getObjeto();
        }
        this.primeira = this.primeira.getNext();
        this.contObjetos--; //O contador de objetos é decrementado na remoçaõ
        return this.primeira.getPrevious();
         
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object removerFinal() {
        if (this.contObjetos==0){
            return null;
        }else if(this.ultima.getPrevious() == null){
            this.removerInicio();
        }
        this.ultima = this.ultima.getPrevious();
        this.contObjetos--;
        return this.ultima.getNext();
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Remove celulas da posição referencia
    @Override
    public Object remover(int index) {
        //Trata o problema da lista vazia.
        if(!(index >= 0 && index < this.contObjetos)){
            throw new IllegalArgumentException("Posição não existe"); 
        }
          if (index == 0) {
            this.removerInicio();
          } else if (index == this.contObjetos - 1) {
            this.removerFinal();
          } else {
            Celula anterior = this.pegaCelula(index - 1);
            Celula atual = anterior.getNext();
            Celula proxima = atual.getNext();

            anterior.setNext(proxima);
            proxima.setPrevious(anterior);

            this.contObjetos--;
            return atual;
          }
        return null;
    }

  //retorna o objeto da posição informada na celula.
    @Override
    public Object recuperar(int index) {
        if(!(index >= 0 && index < this.contObjetos)){
            throw new IllegalArgumentException("Posição não existe");
        }
            Celula atual = primeira;
            for (int i = 0; i < index; i++) {
              atual = atual.getNext();
            }
            return atual.getObjeto();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Retorna o bom e velho iterador.
    @Override
    public Iterador iterador() {
        Iterador it = new MyIterador(primeira);
        return it;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Metodo adicional a interface.
    public Celula pegaCelula(int index){
        if(!(index >= 0 && index < this.contObjetos)){
        throw new IllegalArgumentException("Posição não existe");
        }
            Celula atual = primeira;
            for (int i = 0; i < index; i++) {
              atual = atual.getNext();
            }
            return atual;
        
    }
    
}
