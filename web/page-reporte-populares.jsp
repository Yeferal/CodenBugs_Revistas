<%-- 
    Document   : page-reporte-populares
    Created on : 5/10/2019, 03:01:02 AM
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
        <%@include file="navegacion-reporte-administrador.html" %>
        
        <div>
            <div>
                Por Intervalo de tiempo
                <form action="ReportePopulares?tipo=2" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/>
                    <input type="submit" value="Buscar"/>
                </form>
                
            </div><br>   
        
        <table border="1">
            <thead>
                <tr>
                    <th>Revista</th>
                    <th>Autor</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="canti" items="${cantidad}" begin="0" end="4">
                <tr>
                    <td>${canti.gettituloRevista()}</td>
                    <td>${canti.getnombreSuscriptor()}</td>
                    <td>${canti.getNoLikes()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        <br>
        <table border="1">
            <thead>
                
                <tr>
                    <th>Suscriptor</th>
                    <th>Revista</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="megu" items="${megustas}">
                <tr>
                    <td>${megu.getnombreSuscriptor()}</td>
                    <td>${megu.gettituloRevista()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
