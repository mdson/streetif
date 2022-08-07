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
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author MaD
 */
public class CarregaListaLutadores extends SimpleTagSupport{
    
    private String classe;
    private String var;

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        if(classe.equals("Lutador")){
            List<Lutador> lutadores = RepositorioLutador.getCurrentInstance().lerTudo();
            getJspContext().setAttribute("lutadores", lutadores, PageContext.PAGE_SCOPE);
        }else if(classe.equals("Local")){
            List<Local> locais = RepositorioLocalMemo.getCurrentInstance().lerTudo();
            getJspContext().setAttribute("locais", locais, PageContext.PAGE_SCOPE);
        }
    }

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
    
}
