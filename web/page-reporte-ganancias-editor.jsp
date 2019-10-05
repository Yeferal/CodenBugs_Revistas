<%-- 
    Document   : page-reporte-ganancias-editor
    Created on : 5/10/2019, 12:04:01 AM
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
        <c:set var="cantidad" value="${ganancia}"></c:set>
        <div>
            <div>
                Por Intervalo de tiempo
                <form action="ReporteGananciasEditor?tipo=2" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/>
                    <input type="submit" value="Buscar"/>
                </form>
                
            </div><br>
            <div>
                Por Revista
                <form action="ReporteGananciasEditor?tipo=1" method="post">
                    <input type="text" name="nombreRevista" placeholder="Titulo Revista" required/>
                    
                    <input type="submit" value="Buscar"/>
                </form>
            </div><br>
            <div>
                Filtrar por Intervalo y Revista
                <form action="ReporteGananciasEditor?tipo=3" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/><br>
                    <input type="text" name="nombreRevista" placeholder="Titulo Revista" required/><br>                    
                    <input type="submit" value="Buscar"/>
                </form>
            </div>
        </div><br><br><br>
        <p>Total de Ganacias: ${cantidad}</p>
        
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Suscriptor</th>
                    <th>Revista</th>
                    <th>Fecha</th>
                    <th>Porcentaje</th>
                    <th>Pago</th>
                    <th>Ganancia</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="suscripcion" items="${suscripcion}"> 
                <tr>
                    <td>${suscripcion.getnombreSuscriptor()}</td>
                    <td>${suscripcion.gettituloRevista()}</td>
                    <td>${suscripcion.getfechaSuscripcion()}</td>
                    <td>${suscripcion.getPorcentaje()}</td>
                    <td>${suscripcion.getCosto()}</td>
                    <td>${suscripcion.getGanacia()}</td>
                    
                </tr>
                </c:forEach>
            </tbody>
        </table>
                <br><br>
                
                
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Revista</th>
                    <th>Cantidad de Suscripciones</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="numero" items="${cantidadsuscripcion}"> 
                <tr>
                    <td>${numero.gettituloRevista()}</td>
                    <td>${numero.getidSuscripcion()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
            
    </body>
</html>
