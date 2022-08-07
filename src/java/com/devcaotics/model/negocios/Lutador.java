/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.negocios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ALUNO
 */
public class Lutador {
    
    private int id;
    private String nome;
    private String apelido;
    private String senha;
    private double peso;
    private double altura;
    private Date nascimento;
    private boolean destro;
    private String curso;
    private String artMarcial;
    private String contatoEmergencia;

    public Lutador(int id, String nome, String apelido, double peso, double altura, Date nascimento, boolean destro, String curso, String artMarcial, String contatoEmergencia) {
        this.id = id;
        this.nome = nome;
        this.apelido = apelido;
        this.peso = peso;
        this.altura = altura;
        this.nascimento = nascimento;
        this.destro = destro;
        this.curso = curso;
        this.artMarcial = artMarcial;
        this.contatoEmergencia = contatoEmergencia;
    }

    public Lutador() {
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public boolean isDestro() {
        return destro;
    }

    public void setDestro(boolean destro) {
        this.destro = destro;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getArtMarcial() {
        return artMarcial;
    }

    public void setArtMarcial(String artMarcial) {
        this.artMarcial = artMarcial;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public double getImc(){
        return this.peso/(this.altura*this.altura);
    }
    
    @Override
    public String toString() {
        
        String maoprincipal = null;
        
        String data = new SimpleDateFormat("dd-MM-yyyy").format(nascimento);
        
        if(destro == true){
            maoprincipal = "Destro";
        }else{
            maoprincipal = "Canhoto";
        }
        
        return "Lutador = " + "id=" + id + ", nome=" + nome + ", apelido=" + apelido + ", senha=" + senha + ", peso=" + peso + ", altura=" + altura + ", nascimento=" + data + ", mao principal=" + maoprincipal + ", curso=" + curso + ", artMarcial=" + artMarcial + ", contatoEmergencia=" + contatoEmergencia + ";";
    }
    
}
