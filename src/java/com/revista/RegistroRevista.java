
package com.revista;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;


public class RegistroRevista extends Conexion{
    
   SesionUsuario sesion = new SesionUsuario();
    
    
    public void insertarRevista(HttpServletRequest request){
        conectar();
        try {
            
            insetar = conect.prepareStatement("INSERT INTO revista VALUES (?,?,?,?,?,?);");
            insetar.setString(1, request.getParameter("tituloRevista"));
            insetar.setString(2, "descripcionRevista");
            insetar.setString(3, sesion.usuario.getNombre());
            insetar.setString(6, "bloquearComentarios");
            insetar.setString(7, "bloquearLikes");
//            insetar.setBlob(10, );
            insetar.setString(11, "gratisRevista");
            insetar.setString(12, "cuota");
            insetar.setString(14, "fecha");
            
            
            insetar.executeUpdate();
            
        } catch (SQLException e) {
        }
        
    }
}
