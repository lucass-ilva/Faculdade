<%-- 
    Document   : erro
    Created on : 11/11/2020, 15:28:05
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    </head>
    <body>
        <h1>Erro:</h1><br>
        <%
            Exception erro = (Exception) request.getAttribute("erro");
        %>
        <%=erro.getMessage()%>
    </body>
</html>
