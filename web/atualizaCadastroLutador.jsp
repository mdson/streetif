<%-- 
    Document   : atualizaCadastroLutador
    Created on : 27/04/2022, 20:37:48
    Author     : ALUNO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.devcaotics.model.negocios.Lutador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atualize o Cadastro do Lutador</title>
    </head>
    <body>
        <h1>Atualização de Cadastro:</h1>
        
        <% 
            Lutador lutador = (Lutador)request.getAttribute("lutador");
        %>
        
        <form class="form" method="post"  action="LutadorServletJsp">
            <input type="hidden" name="id" value="<%= lutador.getId() %>"/>
            <input type="hidden" name="op" value="update"/>
            
            <table class="table">
                <tr>
                    <td>
                        Nome: 
                    </td>
                    <td>
                        <input type="text" name="nome" value="<%= lutador.getNome() %>"  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Apelido: 
                    </td>
                    <td>
                        <input type="text" name="apelido" value="<%= lutador.getApelido() %>" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Senha: 
                    </td>
                    <td>
                        <input type="text" name="senha" value="<%= lutador.getSenha() %>"  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Peso: 
                    </td>
                    <td>
                        <input type="text" name="peso" value="<%= lutador.getPeso() %>"  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Altura: 
                    </td>
                    <td>
                        <input type="text" name="altura" value="<%= lutador.getAltura() %>"  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Data de Nascimento: 
                    </td>
                    <td>
                        <input type="date" name="nascimento" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(lutador.getNascimento()) %>"  /> 
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
                        <input type="text" name="curso" value="<%= lutador.getCurso() %>"  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Estilo Marcial: 
                    </td>
                    <td>
                        <input type="text" name="estilomarcial" value="<%= lutador.getArtMarcial() %>"  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Contato Emergencial: 
                    </td>
                    <td>
                        <input type="text" name="contatoemergencial" value="<%= lutador.getContatoEmergencia() %>"  /> 
                    </td>
                </tr>
                <tr>
                    <td rowspan="2"> 
                        <input type="submit" class="btn btn-primary" value="Atualizar Cadastro"/>
                    </td>
                </tr>
            </table> 
        </form>
        
    </body>
</html>
