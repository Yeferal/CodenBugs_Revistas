<%-- 
    Document   : PageLogin
    Created on : 16/09/2019, 10:47:41 PM
    Author     : yefer
--%>

<%@page import="com.revista.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.revista.*" %>
<jsp:useBean id= "usuarios" class="com.revista.Usuario"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stilo.css">
        
    </head>
    <body>
    <%
        
        %>
        <div class="login-box">
            <h1>Inicio</h1>
            <form action="">
                <!-- USERNAME INPUT -->
                <label for="username">Nombre Usuario</label>
                <input type="text" placeholder="Ingresar Nombre" required>
                <!-- PASSWORD INPUT -->
                <label for="password">Constraseña</label>
                <input type="password" placeholder="Ingresar Constraseña" required>
                <input type="submit" value="Iniciar Sesion">
                <br>
                <a href="PageNewAccout.jsp">¿No tienes una cuenta?</a>
            </form>
        </div>
    </body>
</html>
