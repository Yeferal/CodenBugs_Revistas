<%-- 
    Document   : page-pago
    Created on : 3/10/2019, 02:36:57 AM
    Author     : yefer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/stiloMenu.css">
        <link rel="stylesheet" href="css/stiloRevista.css">
        
    </head>
    <body>
        <c:set var="revista" value="${revistaCon}"></c:set>
        <p>Revista: ${revista.getAutor()}</p>
        <a>Cantidad a Pagar: ${revista.getCuotaSuscripcion()}</a>
        
        
        <form action="PagoSuscripcion?datoo=${revista.getID()}" method="POST">
            <label for="fecha">Fecha</label><br>
            <input type="date" name="fecha" id="fecha" required><br>
                
            <label for="codigo">Codigo Tarjeta</label>
            <input type="number" name="codigo" required/>
            <input type="submit" value="Pagar"/>
        </form>
    </body>
</html>
