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
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author MaD
 */
public class TabelaClasse extends SimpleTagSupport{
    
    private String classe;

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
    

    @Override
    public void doTag() throws JspException, IOException {
        super.doTag(); //To change body of generated methods, choose Tools | Templates.
        
        String inicioTabela = "<table border=\"1\">";
        String finalTabela = "</table>";
        String cabecalhoTabela = "";
        String linhasTabelaSomatorio = "";
        //esta variavel ira incrementar cada linha da tabela com quebra automatica por conta do <tr> e retornar como uma string só
        
        if(classe.equals("Lutador")){
            cabecalhoTabela = "<tr>" +
"                <th><center>ID</center></th><th><center>Nome</center></th><th><center>Apelido</center></th><th><center>Senha</center></th><th><center>Peso</center></th><th><center>Altura</center></th><th><center>IMC</center></th><th><center>Nascimento</center></th>" +
"                <th><center>Mão Principal</center></th><th><center>Curso</center></th><th><center>Estilo Marcial</center></th><th><center>Contato Emergencial</center></th>" +
"            </tr>";
            
            List<Lutador> lutadores = RepositorioLutador.getCurrentInstance().lerTudo();
            for(Lutador lutador : lutadores){
                linhasTabelaSomatorio += "<tr>" +
"                    <td><center>" + lutador.getId()+ "</center></td>" +
"                    <td><center>" + lutador.getNome()+ "</td>" +
"                    <td><center>" + lutador.getApelido()+ "</td>" +
"                    <td><center>" + lutador.getSenha()+ "</center></td>" +
"                    <td><center>" + lutador.getPeso()+ "</center></td>" +
"                    <td><center>" + lutador.getAltura()+ "</center></td>" +
"                    <td><center>" + lutador.getImc()+ "</center></td>" +
"                    <td><center>" + new SimpleDateFormat("dd-MM-yyyy").format(lutador.getNascimento()) + "</center></td>" +
"                    <td><center>" + (lutador.isDestro() ? "Destro" : "Canhoto") + "</center></td>" +
"                    <td><center>" + lutador.getCurso()+ "</center></td>" +
"                    <td><center>" + lutador.getArtMarcial()+ "</center></td>" +
"                    <td><center>" + lutador.getContatoEmergencia()+ "</center></td>" +                        
"                </tr>";
            }
        }else if(classe.equals("Local")){
            cabecalhoTabela = "<tr><th>Apelidio</th><th>Endereço</th><th>Capacidade</th></tr>";
            
            List<Local> locais = RepositorioLocalMemo.getCurrentInstance().lerTudo();
            for(Local local : locais){
                linhasTabelaSomatorio += "<tr><td>" + local.getApelido() + "</td>" + 
                            "<td>" + local.getEndereco()+ "</td>" + 
                            "<td>" + local.getCapacidade()+ "</td></tr>";
            }
        }
        getJspContext().setAttribute("tabela", inicioTabela+cabecalhoTabela+linhasTabelaSomatorio+finalTabela, PageContext.PAGE_SCOPE);
    }
    
}
