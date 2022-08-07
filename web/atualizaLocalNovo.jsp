<%-- 
    Document   : atualizaLocalNovo
    Created on : 20/04/2022, 19:37:43
    Author     : ALUNO
--%>

<%@page import="com.devcaotics.model.negocios.Local"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Atualizar um Local</h1>
        
        <% 
            Local local = (Local)request.getAttribute("local");
        %>
        
        <form class="form" method="post"  action="LocalServletNovo">
            
            <input type="hidden" name="id" value="<%= local.getId() %>"/>
            <input type="hidden" name="op" value="update"/>
            
            
            <table class="table">
                <tr>
                    <td>
                        Apelidio: 
                    </td>
                    <td>
                        <input type="text" name="apelido" value="<%= local.getApelido()%>" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Endereço: 
                    </td>
                    <td>
                        <input type="text" name="endereco" value="<%= local.getEndereco()%>"/> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Capacidade: 
                    </td>
                    <td>
                        <input type="text" name="capacidade" value="<%= local.getCapacidade() %>" /> 
                    </td>
                </tr>
                <tr>
                    <td rowspan="2"> 
                        <input type="submit" class="btn btn-primary" value="atualizar"/>
                    </td>
                </tr>
            </table> 
    </body>
</html>
