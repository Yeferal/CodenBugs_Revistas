
package com.revista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioSuscriptor extends Conexion{
    
    
    //inserta un nuevo comnetarioo a la base de datos
    public void insertaComentario(Usuario usuario, Comentario comentario, Revista revista){
        
        try {
            conectar();
            
            insetar = conect.prepareStatement(INSERT+comentarios+"(id_suscriptor, nombre_suscriptor, id_revista, titulo_revista, opinion, fecha)"+VALUES+"(?,?,?,?,?,?);");
            insetar.setInt(1, getIdSuscriptor(usuario.getNombre()));
            insetar.setString(2, usuario.getNombre());
            insetar.setInt(3, revista.getID());
            insetar.setString(4, revista.getTitulo());
            insetar.setString(5, comentario.getComentario());            
            insetar.setString(6, getFechaActual());
            
            insetar.executeUpdate();
            
            desconectar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //retorna la fecha  actual segun la base de datos
    public String getFechaActual(){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+" CURDATE();");
            resultado.next();
            return resultado.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }
    //retorna el ud del suscriptor en busca de su nombre
    public int getIdSuscriptor(String nombre){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+usuarioTabla+WHERE+"nombre='"+nombre+"';");
            resultado.next();
            
            return resultado.getInt(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
