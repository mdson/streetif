/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.repositorios;

import com.devcaotics.model.negocios.Lutador;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MaD
 */
public class RepositorioLutador {
    
    private static RepositorioLutador myself = null;   
    private List<Lutador> lutadores = null;
    private static int lastId = 1;
    
    private RepositorioLutador(){
        this.lutadores = new ArrayList<>();
    }
    
    public static RepositorioLutador getCurrentInstance(){    
        if(myself == null)
            myself = new RepositorioLutador();
        
        return myself;   
    }
    
    public void inserir(Lutador l){
        l.setId(lastId++);
        this.lutadores.add(l);
    }
    
    public void alterar(Lutador l){
        for(Lutador lAux : this.lutadores){
            
            if(lAux.getId() == l.getId()){
                lAux.setNome(l.getNome());
                lAux.setApelido(l.getApelido());
                lAux.setSenha(l.getSenha());
                lAux.setPeso(l.getPeso());
                lAux.setAltura(l.getAltura());
                lAux.setNascimento(l.getNascimento());
                lAux.setDestro(l.isDestro());
                lAux.setCurso(l.getCurso());
                lAux.setArtMarcial(l.getArtMarcial());
                lAux.setContatoEmergencia(l.getContatoEmergencia());
                return;
            }
            
        }
    }
    
    public Lutador ler(int id){
        for(Lutador lAux : this.lutadores){
            if(lAux.getId() == id){
                return lAux;
            }
        }
        return null;
    }
    
    public void remover(int id){
        Lutador l = null;
        for(Lutador lAux : this.lutadores){
            if(lAux.getId() == id){
                l = lAux;
                break;
            }
        }
        
        this.lutadores.remove(l);
    }
    
        public List<Lutador> lerTudo(){
        return this.lutadores;
    }
}
