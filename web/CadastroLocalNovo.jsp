<%-- 
    Document   : CadastroLocalNovo
    Created on : 20/04/2022, 18:59:53
    Author     : ALUNO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de local</h1>
        
        <form class="form" method="post"  action="LocalServletNovo">
            
            <table class="table">
                <tr>
                    <td>
                        Apelidio: 
                    </td>
                    <td>
                        <input type="text" name="apelido"  /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Endereço: 
                    </td>
                    <td>
                        <input type="text" name="endereco" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        Capacidade: 
                    </td>
                    <td>
                        <input type="text" name="capacidade"  /> 
                    </td>
                </tr>
                <tr>
                    <td rowspan="2"> 
                        <input type="submit" class="btn btn-primary" value="cadastrar"/>
                    </td>
                </tr>
            </table> 
        </form>
        
    </body>
</html>
