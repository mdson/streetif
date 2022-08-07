<%-- 
    Document   : visualizarLutador
    Created on : 27 de abr de 2022, 23:15:44
    Author     : MaD
--%>

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.devcaotics.model.negocios.Lutador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Info Detalhada Lutador</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
        <h1>Todas as Informações do Lutador:</h1>
        
        <%
           Lutador lAux2 = (Lutador)request.getAttribute("lutador");
            if(lAux2 != null){
        %>
        
        <table border="1" class="table table-striped table-dark">
            
            <tr><td>ID</td><td><center><%= lAux2.getId() %></center></td></tr>
            <tr><td>Nome</td><td><center><%= lAux2.getNome() %></center></td></tr>
            <tr><td>Apelido</td><td><center><%= lAux2.getApelido() %></center></td></tr>
            <tr><td>Senha</td><td><center><%= lAux2.getSenha() %></center></td></tr>
            <tr><td>Peso</td><td><center><%= lAux2.getPeso() %></center></td></tr>
            <tr><td>Altura</td><td><center><%= lAux2.getAltura() %></center></td></tr>
            <tr><td>IMC</td><td><center><%= lAux2.getImc() %></center></td></tr>
            <tr><td>Nascimento</td><td><center><%= new SimpleDateFormat("dd-MM-yyyy").format(lAux2.getNascimento()) %></center></td>
            <tr><td>Mão Principal</td><td><center>
                <%          
                    if(lAux2.isDestro() == true){
                %>
                Destro
                <%          
                    }else{
                %>
                Canhoto
                <%          
                    }
                %>
            </center></td></tr>
            <tr><td>Curso</td><td><center><%= lAux2.getCurso() %></center></td></tr>
            <tr><td>Estilo Marcial</td><td><center><%= lAux2.getArtMarcial() %></center></td></tr>
            <tr><td>Contato Emergencial</td><td><center><%= lAux2.getContatoEmergencia() %></center></td></tr>
        
        </table>
            <% 
                }
            %>
    </body>
</html>
