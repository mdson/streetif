<%-- 
    Document   : cadastrolutador
    Created on : 27 de abr de 2022, 06:17:50
    Author     : MaD
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.devcaotics.model.repositorios.RepositorioLutador"%>
<%@page import="com.devcaotics.model.negocios.Lutador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String stringId = request.getParameter("id");
    
    Lutador lut = null;
    
    if(stringId != null){
        
        int id = Integer.parseInt(stringId);
            
        lut = RepositorioLutador.getCurrentInstance().ler(id);
    
        session.removeAttribute("lut");
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Lutador</title>
        <style>
            h1{
                text-align: center;
                background-color: black;
                color: white;
            }
        </style>
    </head>
    <body>
        <h1>Formulário do Lutador</h1>
        
        
        <form class="form" method="post"  action="LutadorServletJsp">
            <%= (lut!=null)?"<input type='hidden' name='op' value='update'/>":""%> 
            <%= (lut!=null)?"<input type='hidden' name='id' value='"+lut.getId()+"'/>":""%>
 
            <table class="table">
                <tr>
                    <td>
                        Nome: 
                    </td>
                    <td>
                        <input type="text" name="nome" <%= (lut!=null)? "value=\""+lut.getNome()+"\"":"" %> /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Apelido: 
                    </td>
                    <td>
                        <input type="text" name="apelido" <%= (lut!=null)? "value=\""+lut.getApelido()+"\"":"" %> /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Senha: 
                    </td>
                    <td>
                        <input type="text" name="senha" <%= (lut!=null)? "value=\""+lut.getSenha()+"\"":"" %>  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Peso: 
                    </td>
                    <td>
                        <input type="text" name="peso" <%= (lut!=null)? "value=\""+lut.getPeso()+"\"":"" %>  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Altura: 
                    </td>
                    <td>
                        <input type="text" name="altura" <%= (lut!=null)? "value=\""+lut.getAltura()+"\"":"" %>  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Data de Nascimento: 
                    </td>
                    <td>
                        <input type="date" name="nascimento" <%= (lut!=null)? "value=\""+new SimpleDateFormat("yyyy-MM-dd").format(lut.getNascimento())+"\"":"" %>  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Mão Principal: 
                    </td>
                    <td>
                        <select name="maoprincipal">
                            <option value="destro">Destro</option>
                            <option value="canhoto">Canhoto</option>
                        </select> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Curso: 
                    </td>
                    <td>
                        <input type="text" name="curso" <%= (lut!=null)? "value=\""+lut.getCurso()+"\"":"" %>  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Estilo Marcial: 
                    </td>
                    <td>
                        <input type="text" name="estilomarcial" <%= (lut!=null)? "value=\""+lut.getArtMarcial()+"\"":"" %>  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Contato Emergencial: 
                    </td>
                    <td>
                        <input type="text" name="contatoemergencial" <%= (lut!=null)? "value=\""+lut.getContatoEmergencia()+"\"":"" %>  /> 
                    </td>
                </tr>                
                <tr>
                    <td rowspan="2"> 
                        <input type="submit" class="btn btn-primary" value= <%= (lut!=null)? "Alterar": "Cadastrar"%> />
                    </td>
                </tr>
            </table> 
        </form>
        
    </body>
</html>
