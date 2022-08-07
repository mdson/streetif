/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.controllers.tags;

import com.devcaotics.model.negocios.Local;
import com.devcaotics.model.negocios.Lutador;
import com.devcaotics.model.repositorios.RepositorioLocalMemo;
import com.devcaotics.model.repositorios.RepositorioLutador;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author MaD
 */
public class CarregaUm extends SimpleTagSupport{
    
    private String classe;
    private String var;
    private int indice;

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        if(classe.equalsIgnoreCase("Lutador")){ 
            Lutador lutador = RepositorioLutador.getCurrentInstance().ler(indice);
            if(lutador == null){
                String msg = "<tr><td colspan='6'>Lutador de ID "+ this.indice + " não existe</td></tr>";
                getJspContext().setAttribute(var, msg, PageContext.PAGE_SCOPE);
            }else{
                getJspContext().setAttribute(var, lutador, PageContext.PAGE_SCOPE);
            }
        }else if(classe.equalsIgnoreCase("Local")){
            Local local = RepositorioLocalMemo.getCurrentInstance().ler(indice);
            if(local == null){
                String msg = "<tr><td colspan='6'>Local de ID"+ this.indice + " não existe</td></tr>";
                getJspContext().setAttribute(var, msg, PageContext.PAGE_SCOPE);
            }else{
                getJspContext().setAttribute(var, local, PageContext.PAGE_SCOPE);
            } 
        }
    }
}
