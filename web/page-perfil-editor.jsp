<%-- 
    Document   : PagePerfilEditor
    Created on : 22/09/2019, 06:35:18 PM
    Author     : yefer
--%>

<%@page import="com.revista.DatoUsuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id= "usuario" class="com.revista.SesionUsuario"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
        <link rel="stylesheet" href="css/stiloMenu.css">
    
    </head>
    <body>
        <% 
            usuario.usuario.setNombre(session.getAttribute("Usuario").toString());
            usuario.setInformacion(usuario.usuario.getNombre());
            
        %>
        <% 
           String nombre=usuario.usuario.getNombre();
           String tipo=usuario.usuario.getTipoUsuario();
        %>
        <%@include file="navegacion-editor.html" %>
        <%--<%=perfil.buscarNombreImagen()%>--%>
        <div class="contenedorPerfil">
            <div>
                <div class="imgPerfil">
                    <img src="ImagenEncuentra" width="200" height="200" />
                </div>

                <div class="datosPrincipales">
                    <h1>Nombre: <%=nombre%></h1>
                    <h2>Tipo: <%=tipo%> </h2>
                </div> 
            </div>
                
                    <%  DatoUsuario datos = new DatoUsuario(usuario.usuario);
                    datos.encadenarDatos();
            %>
            <%=datos.getCadena()%>
            
                    
        </div>
        
    </body>
</html>
