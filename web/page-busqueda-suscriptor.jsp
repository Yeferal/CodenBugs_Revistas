<%-- 
    Document   : page-busqueda-suscriptor
    Created on : 6/10/2019, 02:35:14 AM
    Author     : yefer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id= "categoria" class="com.revista.ListaCategorias"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
    </head>
    <body>
        <%@include file="navegacion-suscriptor.html" %>
        
        <form action="BuscaInformacion?tipo=1" method="post">
            <label for="categoria">Categoria</label><br>
            <%=categoria.getCadena()%><a>  </a>
            <input type="submit" value="Buscar Categoria" name="submit" id="btn1" class="btn1"/>
        </form><br>
            
            <form action="BuscaInformacion?tipo=2" method="post">
            <label for="categoria">Etiqueta</label><br>
            <%=categoria.getEtiquetas()%><a>  </a>
            <input type="submit" value="Buscar Etiqueta" name="submit" id="btn1" class="btn1"/>
        </form>
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Autor</th>
                        <th>Titulo</th>
                        <th>${tipoBusqueda}</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dato" items="${lista}">
                    <tr>
                        <td>${dato.getAutor()}</td>
                        <td><a href="RevistaPreVisual?idRevistaVista=${dato.getID()}">${dato.getTitulo()}</a></td>
                        <td>${dato.getTags()}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

    </body>
</html>
