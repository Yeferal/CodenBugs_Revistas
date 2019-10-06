<%-- 
    Document   : page-perfil-editor-ver
    Created on : 6/10/2019, 04:55:27 PM
    Author     : yefer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nombre: ${autor.getNombre()}</h1>
        <p>Gustos:</p>
        <a>${autor.getGustos()}</a>
        <br><br>
        <p>Hobbies:</p>
        <a>${autor.getHobbies()}</a>
        <br><br>
        <p>Intereses:</p>
        <a>${autor.getIntereses()}</a>
        <br><br>
        <p>Descripcion:</p>
        <a>${autor.getDescripcion()}</a>
    </body>
</html>
