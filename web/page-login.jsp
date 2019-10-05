<%-- 
    Document   : PageLogin
    Created on : 16/09/2019, 10:47:41 PM
    Author     : yefer
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.revista.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.revista.*" %>
<jsp:useBean id= "usuariosSesion" class="com.revista.SesionUsuario"></jsp:useBean>
<jsp:useBean id= "usuarios" class="com.revista.Usuario"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stilo.css">
    
        <% session.setAttribute("Usuario", ""); %>
    </head>
    <body>
    <%
        
        %>
        
        <c:if test="${requestScope['error'] != null}">
            <script type="text/javascript">
                alert("Contraseña o Usuario INCORRECTOS");
            </script>
        </c:if>
        
        <div class="login-box">
            <h1>Inicio</h1>
            <form action="IniciarSesion" method="POST">
                <!-- USERNAME INPUT -->
                <label for="username">Nombre Usuario</label>
                <input type="text" name="nombre" placeholder="Ingresar Nombre" required>
                <!-- PASSWORD INPUT -->
                <label for="password">Constraseña</label>
                <input type="password" name="passwrd" placeholder="Ingresar Constraseña" required>
                <input type="submit" value="Iniciar Sesion">
                <br>
                <a href="page-new-accout.jsp">¿No tienes una cuenta?</a>
                
            </form>
        </div>
    </body>
</html>
