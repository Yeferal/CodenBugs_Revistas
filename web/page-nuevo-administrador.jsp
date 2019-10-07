<%-- 
    Document   : page-nuevo-administrador
    Created on : 6/10/2019, 05:35:52 PM
    Author     : yefer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Agregar Administrador</p>
        <form action="NuevoAdministrador" method="POST">
             <label for="nombre">Nombre</label><br>
                <input type="text" class="nuevaR" name="nombre" id="nombre" required><br>
                 <label for="codigo">Codigo</label><br>
                <input type="text" class="nuevaR" name="codigo" id="codigo" required><br>
                 <label for="passwr">Contraseña</label><br>
                <input type="text" class="nuevaR" name="passwr" id="passwr" required><br>
                <br>
                <input type="submit" value="Comfirmar Admin" name="submit" id="btn1" class="btn1"/>
        </form>
    </body>
</html>
