/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.negocios;

/**
 *
 * @author ALUNO
 */
public class Aposta {
    
    private int id;
    private double valor;
    private boolean lutador1;
    
    private Usuario apostador;
    private Luta briga;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isLutador1() {
        return lutador1;
    }

    public void setLutador1(boolean lutador1) {
        this.lutador1 = lutador1;
    }

    public Usuario getApostador() {
        return apostador;
    }

    public void setApostador(Usuario apostador) {
        this.apostador = apostador;
    }

    public Luta getBriga() {
        return briga;
    }

    public void setBriga(Luta briga) {
        this.briga = briga;
    }
    
    
    
}
