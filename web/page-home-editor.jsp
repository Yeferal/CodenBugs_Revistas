

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.revista.Revista"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.revista.ListaRevistaEditor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
    </head>
    <body>
            <%@include file="navegacion-editor.html" %>
            
            <div> 
                <!--<img src="HomeResultado"/>-->
                <form action="HomeResultado" method="GET">
                    <input type="submit" value="Actualizar"/>
                </form>
                <div class="contenedorBuscar">
                    <form action="BuscarRevistaEditor" method="GET">
                    <input type="text" name="cajaBuscar" class="buscar"/>
                    <input type="submit" value="Buscar" name="botonBuscar"/>
                </form>
                </div>
                
            </div>
            <div>
                <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Titulo</th>
                        <th>Informacion</th>
                    </tr>
                    </thead>
                    <tbody>
                        <%int numero = 0;%>
                        <c:forEach var="dato" items="${lista}">
                            <%numero++;%>
                            
                            <tr>
                                <%--<c:out value="${dato}"></c:out>--%>
                                
                            <td><%=numero%></td>
                            <td><a href="VerRevista?id=${dato.getID()}" target="_Blank">${dato.getTitulo()}</a></td>
                            <td>${dato.getDescripcion()}</td>
                            </tr>
                        </c:forEach>
     
                        
                    </tbody>
                    
                </table>
                
                
            </div>
    </body>
</html>
