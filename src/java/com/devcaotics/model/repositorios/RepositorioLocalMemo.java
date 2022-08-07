/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.model.repositorios;

import com.devcaotics.model.negocios.Local;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALUNO
 */
public class RepositorioLocalMemo {
    
    private static RepositorioLocalMemo myself = null;
    
    private List<Local> locais = null;
    private static int lastId = 1;
    
    private RepositorioLocalMemo(){
        this.locais = new ArrayList<>();
    }
    
    public static RepositorioLocalMemo getCurrentInstance(){
        
        if(myself == null)
            myself = new RepositorioLocalMemo();
        
        return myself;
        
    }
    
    public void inserir(Local l){
        l.setId(lastId++);
        this.locais.add(l);
    }
    
    public void alterar(Local l){
        
        for(Local lAux : this.locais){
            
            if(lAux.getId() == l.getId()){
                lAux.setApelido(l.getApelido());
                lAux.setCapacidade(l.getCapacidade());
                lAux.setEndereco(l.getEndereco());
                return;
            }
            
        }
    }
    
    public Local ler(int id){
        for(Local lAux : this.locais){
            if(lAux.getId() == id){
                return lAux;
            }
        }
        return null;
    }
    
    public void remover(int id){
        Local l = null;
        for(Local lAux : this.locais){
            if(lAux.getId() == id){
                l = lAux;
                break;
            }
        }
        
        this.locais.remove(l);
    }
    
    public List<Local> lerTudo(){
        return this.locais;
    }
    
}
