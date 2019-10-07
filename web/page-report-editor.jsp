

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
        <%@include file="navegacion-reporte-editor.html" %>
        
        <div>
            <div>
                Por Intervalo de tiempo
                <form action="ReporteComentarios?tipo=2" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/>
                    <input type="submit" value="Buscar"/>
                </form>
                
            </div><br>
            <div>
                Por Revista
                <form action="ReporteComentarios?tipo=1" method="post">
                    <input type="text" name="nombreRevista" placeholder="Titulo Revista" required/>
                    
                    <input type="submit" value="Buscar"/>
                </form>
            </div><br>
            <div>
                Filtrar por Intervalo y Revista
                <form action="ReporteComentarios?tipo=3" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/><br>
                    <input type="text" name="nombreRevista" placeholder="Titulo Revista" required/><br>                    
                    <input type="submit" value="Buscar"/>
                </form>
            </div>
        </div>
        <p>Lista de Comentarios</p>
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Suscriptor</th>
                    <th>Revista</th>
                    <th>Comentario</th>
                    <th>Fecha</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="comentarios" items="${comentario}"> 
                <tr>
                    <td>${comentarios.getUsuario()}</td>
                    <td>${comentarios.getTitulo()}</td>
                    <td>${comentarios.getComentario()}</td>
                    <td>${comentarios.getFecha()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
