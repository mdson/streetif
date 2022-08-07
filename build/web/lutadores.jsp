<%-- 
    Document   : lutadores
    Created on : 27 de abr de 2022, 16:30:21
    Author     : MaD
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.devcaotics.model.negocios.Lutador"%>
<%@page import="java.util.List"%>
<%@taglib prefix="ifpe" uri="https://devcaotics.org/tagsIfpe"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Lutadores Cadastrados</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <style>
            h2{
            text-align: center;
            background-color: black;
            color: white;
        }
            #modal{
            background-color: aquamarine;
        }
            #modal2{
            background-color: aquamarine;
        }
        #divCarregaUm{
            background-color: aquamarine;
        }
        #divCarregaTabela{
            background-color: yellow;
        }
        #modal3{
            background-color: yellow;
        }
        </style>
    </head>
    <body>
        <h2>Verifique o nosso cartel de lutadores:</h2>
        
        <%
            Lutador l = (Lutador) request.getAttribute("l");
        %>

        <h3>${sessionScope.msg}</h3>
        <%
            session.removeAttribute("msg");  
        %>
        
        <br/>
        
<!--        Esta tag irá carregar a lista de todos os lutadores do repositorio lutador-->
        <h3>Tag CarregaTodos:</h3>
        <ifpe:carregaLutadores classe="Lutador" var="lutadores"/>
        
        <% List<Lutador> lutadores = (List)pageContext.getAttribute("lutadores"); %>
        <p>Total de lutadores cadastrados: ${pageScope.lutadores.size()} </p>
        
<!--        Esta tag irá carregar um lutador o qual o indice seja igual ao id do mesmo; ex: indice "1" irá buscar o lutador de id = "1"-->
        <h3>Tag CarregaUm:</h3>
        <ifpe:carregaUm classe="Lutador" var="lutador" indice="${1}" />
        <div id="divCarregaUm">
            <p>${lutador.toString()}</p>
        </div>
        
        <br/>
        
<!--        Esta tag desenha a tabela referente a pagina a qual esta inserida e traz todos os objetos cadastrados referente a essa página-->
        <h3>Tag carregaTabela:</h3>
        <ifpe:carregaTabela classe="Lutador" />
        <a href="#" onclick="modalopen3()"><button>Exibit Tag Tabela</button></a>
        <div id="modal3" style="position: absolute; top: 200px; left: 200px; border: 1px black solid">
            <br/>
            ${pageScope.tabela}
            <a href="LutadorServletJsp?op=fechamento"><button onclick="modalclose3()">Fechar</button></a>
        </div>
        
        <br/>
        <br/>
        
        <div id="modal" style="position: absolute; top: 200px; left: 200px; border: 1px black solid">
            <br/>
            <jsp:include page="visualizarLutador.jsp?id=${requestScope.l.id}" />
            <a href="LutadorServletJsp?op=fechamento"><button onclick="modalclose()">Fechar</button></a>
        </div>
            
        <div id="modal2" style="position: absolute; top: 200px; left: 200px; border: 1px black solid">
            <br/>
            <jsp:include page="cadastrolutador.jsp" />
            <a href="LutadorServletJsp?op=fechamento"><button onclick="modalclose2()">Fechar</button></a>
        </div>
        
            
        <%
            if(lutadores != null){
        %>
        
        <table border="1" class="table table-striped table-dark">
            <tr>
                <th><center>ID</center></th><th><center>Nome</center></th><th><center>Apelido</center></th><th><center>Senha</center></th><th><center>Peso</center></th><th><center>Altura</center></th><th><center>IMC</center></th><th><center>Nascimento</center></th>
                <th><center>Mão Principal</center></th><th><center>Curso</center></th><th><center>Estilo Marcial</center></th><th><center>Contato Emergencial</center></th><th><center>Operações</center></th>
            </tr>
            
            <%      
                for(Lutador lAux: lutadores){
                pageContext.setAttribute("lutadorAux", lAux);
            %>
            
                <tr>
                    <td><center>${lutadorAux.id}</center></td>
                    <td><center>${lutadorAux.nome}</center></td>
                    <td><center>${lutadorAux.apelido}</center></td>
                    <td><center>${lutadorAux.senha}</center></td>
                    <td><center>${lutadorAux.peso}</center></td>
                    <td><center>${lutadorAux.altura}</center></td>
                    <td><center>${lutadorAux.imc}</center></td>
                    <td><center><%= new SimpleDateFormat("dd-MM-yyyy").format(lAux.getNascimento()) %></center></td>
                    <td><center>${lutadorAux.destro ? "Destro" : "Canhoto"}</center></td>
                    <td><center>${lutadorAux.curso}</center></td>
                    <td><center>${lutadorAux.artMarcial}</center></td>
                    <td><center>${lutadorAux.contatoEmergencia}</center></td>
                    <td><a href="LutadorServletJsp?id=${lutadorAux.id}&op=update"><button>Alterar Cadastro</button></a>
                        <a href="#" onclick="deletar(${lutadorAux.id})"><button>Deletar Cadastro</button></a>
                        <a href="LutadorServletJsp?id=${lutadorAux.id}&op=visualizar"><button>Visualizar Lutador</button></a></td>   
                </tr>            
            
            <% 
                }
            %>            

        </table>
            
        <%
            }    
        %>
        
        <table>
            <tr> 
                <td id="criarfunc"><button onclick="modalopen2()">Novo Lutador</button></td>
            </tr>
        </table>
        
        <script>
            var modal = document.getElementById("modal");
            var modal2 = document.getElementById("modal2");
            var modal3 = document.getElementById("modal3");
            
            <%
                String operacao = request.getParameter("op");
                if(operacao == null) {
            %>
                
            document.body.removeChild(modal);
            document.body.removeChild(modal2);
            document.body.removeChild(modal3);
            
            <% } else if(operacao.equals("visualizar")) { %>
            document.body.removeChild(modal2);
            document.body.removeChild(modal3);
            <% } else { %>
            document.body.removeChild(modal);
            document.body.removeChild(modal3);
            <% }%>
                
             function modalclose2() {
                document.body.removeChild(modal2);
            }    

            function modalclose() {
                document.body.removeChild(modal);
            }
            
            function modalopen2() {
                document.body.appendChild(modal2);
            }
            
            function modalopen3() {
                document.body.appendChild(modal3);
            }
            
            function modalclose3() {
                document.body.removeChild(modal3);
            }
            
            function deletar(id){
                
                fetch('LutadorServletJsp?id='+id,{ method: 'delete' })
                        .then(function(response){
                            location.reload();
                });  
            };
        </script>
        
    </body>
</html>
