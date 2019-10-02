<%-- 
    Document   : PageNuevaRevistaEditor
    Created on : 22/09/2019, 05:27:19 PM
    Author     : yefer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id= "categoria" class="com.revista.ListaCategorias"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
        <link rel="stylesheet" href="css/stiloFomRevista.css">
    </head>
    <body>
        <%@include file="navegacion-editor.html" %>
        <div class="nuevaRevista">
            <p>Publicar Nueva Revista</p>
            <form action="RegistroNuevaRevista" method="POST" enctype="multipart/form-data">
                <label for="tituloRevista">Titulo</label><br>
                <input type="text" class="nuevaR" name="tituloRevista" id="tituloRevista" required><br>

                <label for="">Descripcion</label><br>
                <textarea type="text" rows="5" cols="60" name="descripcionRevista" class="nuevaR" id="descripcionRevista" required></textarea><br>
                
                <label for="categoria">Categoria</label><br>
                <%=categoria.getCadena()%><br>
                
                <label for="cuota">Cuota de Suscripcion</label><br>
                <input type="number" class="nuevaR" name="cuota" id="couta" required><br>

                <label for="fichero">Revista</label><br>
                <input type="file" name="fichero" value="Selecionar" id="btn" class="btn" required /><br>

                <label for="fecha">Fecha</label><br>
                <input type="date" name="fecha" id="fecha" required><br>
                
                <label for="gratis">Gratis</label>
                <input type="checkbox" name="gratisRevista" value="0" id="gratisRevista"><br>
                
                <label for="comentar">Bloquear Comentarios</label>
                <input type="checkbox" name="bloquearComentarios" value="0" id="bloquearComentarios"><br>
                
                <label for="likes">Bloquear Likes</label>
                <input type="checkbox" name="bloquearLikes" value="0" id="bloquearLikes"><br>
                
                <input type="submit" value="Comfirmar Revista" name="submit" id="btn1" class="btn1"/>

            </form>
        </div>
        
    </body>
</html>
