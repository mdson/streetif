<%-- 
    Document   : locaisNovo
    Created on : 20/04/2022, 19:08:43
    Author     : ALUNO
--%>

<%@page import="com.devcaotics.model.negocios.Local"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LocaisCadastrados</h1>
        
        <%
            String mensagem = request.getParameter("msg");
            
            if(mensagem != null){
        %>
        <h3><%= mensagem %></h3>
        <%
            }    
        %>
        
        <%
            List<Local> locais = (List)request.getAttribute("locais");
        %>
        
        <table border="1">
            <tr>
                <th>id</th><th>Apelido</th><th>Endereço</th><th>Capacidade</th><th>operações</th>
            </tr>
            
            <% 
                for(Local lAux: locais){
            %>
            
                <tr>
                    <td><%= lAux.getId() %></td>
                    <td><%= lAux.getApelido() %></td>
                    <td><%= lAux.getEndereco() %></td>
                    <td><%= lAux.getCapacidade() %></td>
                    <td><a href="LocalServletNovo?id=<%= lAux.getId() %>&op=update">alterar </a>
                        <a href="LocalServletNovo?id=<%= lAux.getId() %>&op=delete">deletar</a></td>
                </tr>
            
            
            <% 
                }
            %>
        </table>
    </body>
</html>
