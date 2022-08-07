/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.controllers.tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class Tag2 extends SimpleTagSupport{

    private List lista;
    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
    
        StringWriter writer = new StringWriter();
        getJspBody().invoke(writer);
        
        getJspContext().getOut().write("<h2>"+writer.toString()+
                " O tamanho da lista é: "+this.lista.size()+"</h2>");
    
    
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }
    
    
    
}
