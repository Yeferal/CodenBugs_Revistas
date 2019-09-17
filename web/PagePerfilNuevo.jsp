<%-- 
    Document   : PagePerfilNuevo
    Created on : 16/09/2019, 10:57:41 PM
    Author     : yefer
--%>

<%@page import="com.revista.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id= "usuario" class="com.revista.Conexion"></jsp:useBean>
<jsp:setProperty name="usuario" property="*" ></jsp:setProperty>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Code n' Bugs</title>
    <link rel="stylesheet" href="css/stiloPerfilNuevo.css">
    
    </head>
    <body>
        
        <% 
                String nombre=request.getParameter("nombreUser");
                String tipo=request.getParameter("tipoUser");
            %>
            
            <% usuario.conectar();
            
                 %>
                 
        <div class="foto">
            <div class="fotoPerfil">

        
            </div>
            <button type="button" class="botonSubir">Subir Foto</button>
      </div>
      <div class="dataBasic">
          
            
            
            
          <h1>Nombre: <%=nombre%></h1>
          <h2>Tipo: <%=tipo%> </h2>
      </div>
      <div class="dataDescript">
            <form action="">
                    <label for="areaGustos">Gustos</label>
                    <textarea id="areaGustos" name="textarea" rows="10" cols="50" placeholder="Escribe tu Gustos"></textarea>
                    <br>
                    <label for="areaHobbies">Hobbies</label>
                    <textarea id="areaHobbies" name="textarea" rows="10" cols="50" placeholder="Escribe tus Hobbies"></textarea>
                    <br>
                    <label for="areaIntereses">Intereses</label>
        
                    <div class="seleciones">
                        <label for="">Gustos</label>
                        <input type="checkbox" id="1"><br>
                    <textarea id="areaIntereses" name="textarea" rows="10" cols="50" placeholder="Escribe tus Intereses"></textarea><br>
                    </div>
        
                    <br>
                    <label for="areaDescripcion">Descripcion o Biografia</label>
                    <textarea id="areaDescripcion" name="textarea" rows="10" cols="50" placeholder="Escribe tu Descripcion"></textarea><br>
        
                    <input type="submit" value="Actualizar Datos">
              </form>
      </div>
    </body>
</html>
