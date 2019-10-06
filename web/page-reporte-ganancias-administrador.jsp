<%-- 
    Document   : page-reporte-ganancias-administrador
    Created on : 5/10/2019, 03:00:13 AM
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
                <form action="ReporteGananciaAdministrador?tipo=2" method="post">
                    <input type="date" name="fecha1" required/>
                    <label>Entre</label>
                    <input type="date" name="fecha2" required/>
                    <input type="submit" value="Buscar"/>
                </form>
                
            </div><br>
            <div>
                Por Revista
                <form action="ReporteGananciaAdministrador?tipo=1" method="post">
                    <input type="text" name="nombreRevista" placeholder="Titulo Revista" required/>
                    
                    <input type="submit" value="Buscar"/>
                </form>
            </div><br>

        </div><br><br>
        <h1>Listado de Suscripciones</h1>
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Revista</th>
                    <th>Suscriptor</th>
                    <th>Pago</th>
                    <th>Ganancia</th>
                    <th>Fecha</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="suscripcion" items="${suscripcion}"> 
                <tr>
                    <td>${suscripcion.gettitulo()}</td>
                    <td>${suscripcion.getSuscriptor()}</td>
                    <td>${suscripcion.getPago()}</td>
                    <td>${suscripcion.getGanacia()}</td>
                    <td>${suscripcion.getfecha()}</td>                    
                </tr>
                </c:forEach>
            </tbody>
        </table>
                <br><br>
                
        <h1>Listado Ingresos por Suscripcion</h1>        
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Revista</th>
                    <th>Costo</th>
                    <th>Ingreso</th>
                    <th>Ganancia</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="numero" items="${ingreso}"> 
                <tr>
                    <td>${numero.gettitulo()}</td>
                    <td>${numero.getCosto()}</td>
                    <td>${numero.getIngreso()}</td>
                    <td>${numero.getGanacia()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
                <br><br>
                
        <h1>Total Suscripciones</h1>        
        <table border="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Costo</th>
                    <th>Ingreso</th>
                    <th>Ganancia</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="totales" items="${total}"> 
                <tr>
                    <td>${totales.getCosto()}</td>
                    <td>${totales.getIngreso()}</td>
                    <td>${totales.getGanacia()}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
                
    </body>
</html>
