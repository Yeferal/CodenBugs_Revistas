
package com.revista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistroSuscripcion extends Conexion{
    
    
    
    public void insertarSuscripcion(Usuario usuario, Revista revista, double pagoSuscripcion, String fecha){
        
        try {
            conectar();
            insetar = conect.prepareStatement(INSERT+suscripciones+"(id_suscriptor, nombre_suscriptor, id_revista, titulo_revista, porcentaje, pago, fecha_suscripcion, costo)"+VALUES+"(?,?,?,?,?,?,?,?)");
            insetar.setInt(1, getIdSuscriptor(usuario.getNombre()));
            insetar.setString(2, usuario.getNombre());
            insetar.setInt(3, revista.getID());
            insetar.setString(4, revista.getTitulo());
            insetar.setDouble(5, 0.30);
            insetar.setDouble(6, pagoSuscripcion);
            insetar.setString(7, fecha);
            insetar.setDouble(8, revista.getCostoDia());
            
            insetar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
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
