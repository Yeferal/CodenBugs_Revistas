<%-- 
    Document   : page-etiquetas-administrador
    Created on : 30/09/2019, 12:06:26 AM
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
        <%@include file="navegacion-administrador.html" %>
        
        <div> 
                <!--<img src="HomeResultado"/>-->
                <form action="EtiquetaAdministrador" method="GET">
                    <input type="submit" value="Actualizar"/>
                </form>
                <div class="contenedorBuscar">
                    <form action="#" method="GET">
                    <input type="text" name="cajaBuscar" class="buscar"/>
                    <input type="submit" value="Buscar" name="botonBuscar"/>
                </form>
                </div>
                
                <table border="1" cellpadding="1">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Titulo</th>
                            <th>Etiquetas</th>
                            <th>---------</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <%int numero = 0;%>

                    <c:forEach var="dato" items="${listaEtiquetados}">
                        <%numero++;%>
                        <tr>
                            <td><%=numero%></td>
                            <td><a href="VerRevista?id=${dato.getID()}">${dato.getTitulo()}</a></td>
                            <td>${dato.getTags()}</td>
                            <td>
                                <form action="AsignacionEtiqueta?idrevistaEtiqueta=${dato.getID()}" method="POST">
                                    <input type="submit" value="Asignar"/>
                                </form>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>

                
        </div>
    </body>
</html>
