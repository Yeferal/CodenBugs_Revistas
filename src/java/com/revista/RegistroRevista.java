
package com.revista;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


public class RegistroRevista extends Conexion{
    
    
    
    public void insertarRevista(HttpServletRequest request, Usuario usuario){
        try {
            conectar();
            insetar = conect.prepareStatement("INSERT INTO revista (titulo,descripcion,autor,pdf,cuota_suscripcion,fecha) VALUES (?,?,?,?,?,?);");
            insetar.setString(1, request.getParameter("tituloRevista"));
            insetar.setString(2, request.getParameter("descripcionRevista"));
            insetar.setString(3, usuario.getNombre());
            //insetar.setString(6, "bloquearComentarios");
            //insetar.setString(7, "bloquearLikes");
            insetar.setBlob(4, archivo(request));
            //insetar.setString(11, "gratisRevista");
            insetar.setString(5, request.getParameter("cuota"));
            insetar.setString(6, request.getParameter("fecha"));
            insetar.executeUpdate();
            
            PreparedStatement insetarCategoriaRevista = conect.prepareStatement("INSERT INTO categorias VALUES (?,?,?)");
            insetarCategoriaRevista.setInt(1, getUltimaRevista());
            insetarCategoriaRevista.setString(2, request.getParameter("tituloRevista"));
            insetarCategoriaRevista.setString(3, request.getParameter("categoria"));
            insetarCategoriaRevista.executeUpdate();
            
            desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    private InputStream archivo(HttpServletRequest request){
       InputStream inputStream = null;
        try {
           
           Part filePart = request.getPart("fichero");
           
           inputStream = filePart.getInputStream();
           
       } catch (IOException | ServletException ex) {
           ex.printStackTrace();
       }
       return inputStream;
    }
    
    private int getUltimaRevista(){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT id_revista FROM revista ORDER by id DESC LIMIT 1;");
            resultado.next();
            return resultado.getInt(1);
            
            
        } catch (SQLException ex) {
            
        }
        return 0;
    }
}
