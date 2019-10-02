<%-- 
    Document   : asignar-costo-dia
    Created on : 29/09/2019, 05:13:21 PM
    Author     : yefer
--%>

<%@page import="com.revista.Revista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id= "revistaMont" class="com.revista.Revista"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
    </head>
    <body>
    <% revistaMont =(Revista) request.getAttribute("revistaCosto");
        
    %>
    
        <h1>Asignar Primer Costo por dia</h1>
        <a><%=revistaMont.getTitulo()%></a>
        <div>
            <form action="ActualizarCostoDia?idRevista=<%=revistaMont.getID()%>" method="POST">
                <input type="number" name="costoDia" value="0" required/><br>
                <input type="submit" name="botonAsignar" value="Asignar"/>
                
            </form>
            <form action="RecientesAdministrador">
                <input type="submit" name="botonAsignar" value="Cancelar"/>
            </form>
        </div>
    </body>
</html>
