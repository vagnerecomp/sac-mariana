/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uefs.ecomp.sacMariana.model;

import java.util.Date;
/**
 *
 * @author VAGNER
 */
//Definição da classe Doacao
public class Doacao {
    private int id;
    private Date data;
    private Number qtd;
    private Doador doador;
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Number getQtd() {
        return qtd;
    }

    public void setQtd(Number qtd) {
        this.qtd = qtd;
    }
    
}
