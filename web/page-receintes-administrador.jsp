

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
                <form action="RecientesAdministrador" method="GET">
                    <input type="submit" value="Actualizar"/>
                </form>
            </div>
        
        <table>
            <thead>
                <tr>
                    <th>No.</th>
                    <th>Titulo</th>
                    <th>Fecha</th>
                    <th>Categoria</th>
                    <th>Cuota de Suscripcion</th>
                    <th>Costo por dia</th>
                    <th>Asignar Costo</th>
                </tr>
            <thead>
                <tbody>
                    <%int numero = 0;%>

                    <c:forEach var="dato" items="${listaSinMonto}">
                        <%numero++;%>
                        <tr>
                            <td><%=numero%></td>
                            <td><a href="VerRevista?id=${dato.getID()}">${dato.getTitulo()}</a></td>
                            <td>${dato.getFecha()}</td>
                            <td>${dato.getCategoria()}</td>
                            <td>${dato.getCuotaSuscripcion()}</td>
                            <td>${dato.getCostoDia()}</td>
                            <td>
                                <form action="AsignacionCostoDia?numeroCosto=${dato.getID()}" method="POST">
                                    <input type="submit" value="Asignar"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </thead>
            </thead>
        </table>
    </body>
</html>
