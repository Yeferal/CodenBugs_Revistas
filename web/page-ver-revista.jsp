<%-- 
    Document   : page-ver-revista
    Created on : 1/10/2019, 09:49:42 PM
    Author     : yefer
--%>

<%@page import="com.revista.MeGusta"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/stiloMenu.css">
        <link rel="stylesheet" href="css/stiloRevista.css">
    </head>
    <body>
        <%@include file="navegacion-suscriptor.html" %>
        
        
        
        <div class="contenedorVerRevista">
            
            <div class="conetenedorInformacion">
                <c:set var="revista" value="${revistaVista}"></c:set>
                <c:set var="likes" value="${megusta}"></c:set>
                <c:set var="nombre" value="${nombresus}"></c:set>
                <% MeGusta megus = new MeGusta();%>
                <p>Titulo: ${revista.getTitulo()}</p>
                <p><a href="#">Autor: ${revista.getAutor()}</a></p>
                <p>Categoria: ${revista.getCategoria()}</p>
                <p>Precio: ${revista.getCuotaSuscripcion()}</p>
                <p>Fecha: ${revista.getFecha()}</p>
                
                
                    <form action="">
                    <input type="submit" value="no me gusta" name="botonMegusta" class="botonMegusta"/>
                    : ${likes.verLikes(revista.getID())}
                </form>
               
                    <form action="RegistroLike?idR=${revista.getID()}" method="post">
                        <input type="submit" value="me gusta" name="botonMegusta" class="botonMegusta"/>
                        : ${likes.verLikes(revista.getID())}
                    </form>
                
                
            </div>
            
            <div class="contenedorDescripcion">
                <p>Descripcion: </p>
                ${revista.getDescripcion()}
            </div>
            <div>
                <c:if test="${requestScope['suscripcion'] == 0}">
                    <form action="Suscribirse?datoo=${revista.getID()}" method="post">
                        <input type="submit" value="Suscribirse"/>
                    </form>
                </c:if>
                
                <c:if test="${requestScope['suscripcion'] != 0}">
                    <form action="" >
                        <input type="submit" value="Desuscribirse"/>
                    </form>
                    <form action="" >
                        <input type="submit" value="Pagar Mes"/>
                    </form>
                </c:if>
                
            </div>
            
            
            <div>
                <c:set var="comen" value="comentariosRev"></c:set>
                <c:if test="${requestScope['comentariosRev.size()'] != 0}">
                    <p>Comentarios:</p>
                    <c:forEach var="dato" items="${comentariosRev}">
                        ${dato.getUsuario()}
                        Susucriptor: ${dato.usuario} -------Fecha: ${dato.fecha}
                        <div class="cajaComentario">
                            ${dato.comentario}
                        </div>
                        <br>
                    </c:forEach>
                </c:if>
                
                                
            </div>
            <br>
            <div>
                <c:if test="${revistaVista.getCometar() == 1}">
                    <form action="Comentar?idRevistaComentar=${revista.getID()}" method="POST">
                        <textarea name="nuevoComentario" class="newComentario" required></textarea>
                        <input type="submit" value="Comentar"/>
                    </form>
                </c:if>
                                
            </div>
            
            <div></div>
            <div></div>
        </div>
    </body>
</html>
