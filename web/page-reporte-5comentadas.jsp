


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
        <% %>
        <div>
            <div>
                Por Intervalo de tiempo
                <form action="ReporteCincoComentadas?tipo=2" method="post">
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
                <c:forEach var="come" items="${cantidad}" begin="0" end="4">
                <tr>
                    <td>${come.getTitulo()}</td>
                    <td>${come.getUsuario()}</td>
                    <td>${come.getCantidad()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        <br>
        <table border="1">
            <thead>
                <tr>
                    <th>Comentario</th>
                    <th>Revista</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="canti" items="${comentarios}">
                <tr>
                    <td>${canti.getComentario()}</td>
                    <td>${canti.getTitulo()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
