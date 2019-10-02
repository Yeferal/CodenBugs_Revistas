<%-- 
    Document   : asignar-etiqueta
    Created on : 30/09/2019, 12:57:49 AM
    Author     : yefer
--%>

<%@page import="com.revista.Revista"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id= "categoria" class="com.revista.ListaCategorias"></jsp:useBean>
<jsp:useBean id= "revistaMont" class="com.revista.Revista"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
    </head>
    <body>
        <% revistaMont =(Revista) request.getAttribute("revistaEtiqueta");
           request.setAttribute("titulo", revistaMont.getTitulo());
        %>
    
        <div class="nuevaRevista">
            <p>Agregar Etiquta a Revista</p>
            <a><%=revistaMont.getTitulo()%></a>
            <form action="actualizarEtiqueta?idRevista=<%=revistaMont.getID()%>" method="POST">
                <label for="tagss">Etiquetas</label><br>
                <%=categoria.getEtiquetas()%><br>
                
                <input type="submit" value="Comfirmar Etiqueta" name="submit" id="btn1" class="btn1"/>
            </form>
    </body>
</html>
