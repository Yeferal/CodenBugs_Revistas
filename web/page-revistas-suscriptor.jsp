<%-- 
    Document   : page-revistas-suscriptor
    Created on : 1/10/2019, 12:11:25 AM
    Author     : yefer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
    </head>
    <body>
        <%@include file="navegacion-suscriptor.html" %>
        
        
        <table border="1">
            <thead>
                <tr>
                    <th>Titulo</th>
                    <th>Fecha</th>
                    <th>Categoria</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dato" items="${listaNosuscritas}">
                    <tr>
                        <td><a href="RevistaPreVisual?idRevistaVista=${dato.getID()}">${dato.getTitulo()}</a></td>
                        <td>${dato.getFecha()}</td>
                        <td>${dato.getCategoria()}</td>
                    </tr>
                    
                </c:forEach>
                
                
            </tbody>
        </table>

    </body>
</html>
