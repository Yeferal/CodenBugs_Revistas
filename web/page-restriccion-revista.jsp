<%-- 
    Document   : page-restriccion-revista
    Created on : 6/10/2019, 02:54:26 PM
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
        
        <form action="Restriccion?idR=${idRevista}&tipo=0" method="post">
            <label for="gratis">Gratis</label>
            
            <c:if test="${requestScope['esgratis']== 1}">
                <input type="checkbox" name="gratisRevista" value="0" id="gratisRevista" checked><br>
            </c:if>
            <c:if test="${requestScope['esgratis'] == 0}">
                <input type="checkbox" name="gratisRevista" value="0" id="gratisRevista"><br>
            </c:if>
                
                <label for="comentar">Bloquear Comentarios</label>
            <c:if test="${requestScope['escomen'] == 0}">
                <input type="checkbox" name="bloquearComentarios" value="0" id="bloquearComentarios" checked><br>
            </c:if>
                
            <c:if test="${requestScope['escomen'] == 1}">
                <input type="checkbox" name="bloquearComentarios" value="0" id="bloquearComentarios"><br>
            </c:if>
                
                <label for="likes">Bloquear Likes</label>
            <c:if test="${requestScope['eslike'] == 0}">
                <input type="checkbox" name="bloquearLikes" value="0" id="bloquearLikes" checked><br>
            </c:if>
            <c:if test="${requestScope['eslike'] == 1}">
                <input type="checkbox" name="bloquearLikes" value="0" id="bloquearLikes"><br>
            </c:if>    
                
                
                
                
                
                <input type="submit" value="Comfirmar Revista" name="submit" id="btn1" class="btn1"/>
        </form>
    </body>
</html>
