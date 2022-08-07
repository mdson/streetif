/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.negocios;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO
 */
public class Usuario {
    
    private int id;
    private String nome;
    private String apelido;
    private String senha;
    private String pix;
    private double saldo;
    
    private List<Aposta> apostas;
    
    public Usuario() {
        
        this.apostas = new ArrayList<>();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Aposta> getApostas() {
        return apostas;
    }

    public void setApostas(List<Aposta> apostas) {
        this.apostas = apostas;
    }
    
    public void addAposta(Aposta a){
        this.apostas.add(a);
    }
    
}
