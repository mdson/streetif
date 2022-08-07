/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devcaotics.controllers.tags;

import com.devcaotics.model.negocios.Local;
import com.devcaotics.model.repositorios.RepositorioLocalMemo;
import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author ALUNO
 */
public class CarregaListaLocais extends SimpleTagSupport{

    @Override
    public void doTag() throws JspException, IOException {
        
        List<Local> locais = RepositorioLocalMemo
                .getCurrentInstance().lerTudo();
        
        getJspContext().setAttribute("ls", locais, PageContext.PAGE_SCOPE);
        
    }
    
    
    
}
