<%-- 
    Document   : page-reporte-likes
    Created on : 4/10/2019, 06:47:54 PM
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
        <%@include file="navegacion-reporte-editor.html" %>
        <div>
            <div>
                Por Intervalo de tiempo
                <form action="ReporteLIkesEditor?tipo=2" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/>
                    <input type="submit" value="Buscar"/>
                </form>
                
            </div><br>
            <div>
                Por Revista
                <form action="ReporteLIkesEditor?tipo=1" method="post">
                    <input type="text" name="nombreRevista" placeholder="Titulo Revista" required/>
                    
                    <input type="submit" value="Buscar"/>
                </form>
            </div><br>
            <div>
                Filtrar por Intervalo y Revista
                <form action="ReporteLIkesEditor?tipo=3" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/><br>
                    <input type="text" name="nombreRevista" placeholder="Titulo Revista" required/><br>                    
                    <input type="submit" value="Buscar"/>
                </form>
            </div>
        </div>
        
        <div>
            <h1>Tabla de likes</h1>
            <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Suscriptor</th>
                    <th>Revista</th>
                    <th>Fecha</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="megustainfos" items="${megustainfo}"> 
                <tr>
                    <td>${megustainfos.getnombreSuscriptor()}</td>
                    <td>${megustainfos.gettituloRevista()}</td>
                    <td>${megustainfos.getfechaLike()}</td>
                    
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div><br>
              <br>  
                <div>
                    <h1>Tabla de Cantidad likes</h1>
            <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Revista</th>
                    <th>Cantidad Likes</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cantidadmegustas" items="${cantidadmegusta}"> 
                <tr>
                    <td>${cantidadmegustas.gettituloRevista()}</td>
                    <td>${cantidadmegustas.getNoLikes()}</td>
                    
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </body>
</html>
