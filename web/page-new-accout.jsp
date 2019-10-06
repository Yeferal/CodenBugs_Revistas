<%-- 
    Document   : PageNewAccout
    Created on : 16/09/2019, 10:54:45 PM
    Author     : yefer
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.revista.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:useBean id= "usuario" class="com.revista.Conexion"></jsp:useBean>--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/style.css">
        
    </head>
    <body>
        <c:if test="${requestScope['error1'] != null}">
            <script type="text/javascript">
                alert("El usuario ya existe");
            </script>
        </c:if>
        <c:if test="${requestScope['error2'] != null}">
            <script type="text/javascript">
                alert("Las contrasenas no son iguales");
            </script>
        </c:if>
            
        <div class="container">
          <div>
                <h2>Datos de Registro</h2>
          </div>
            <form action="RegistroNuevoUsuario" method="POST">
            <label for="nombreUser">Nombre Usuario</label>
            <input class="input" type="text" name="nombreUser" placeholder="&#128100;Nombre" required>
            
            <label for="passwrd1">Contraseña</label>
            <input class="input" type="password" name="passwrd1" placeholder="&#128100;Contraseña" required>
            
            <label for="passwrd2">Verificar Contraseña</label>
            <input class="input" type="password" name="passwrd2" placeholder="&#128100;Contraseña" required>
            <label for="tipoUsuario">Tipo de Usuario</label>
            
            <div class="radio" name="tipoUser">
                <input type="radio" name="tipoUser" value="Suscriptor" id="Suscriptor" required>
                <label for="Suscriptor">Suscriptor</label>
                <input type="radio" name="tipoUser" value="Editor" id="Editor" required>
                <label for="Editor">Editor</label>
            </div>
            <input type="submit" value="Registrarse">
        </form>

      </div>
    </body>
</html>
