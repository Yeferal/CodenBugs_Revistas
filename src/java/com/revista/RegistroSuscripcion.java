
package com.revista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RegistroSuscripcion extends Conexion{
    
    
    //inserta una nueva suscripcion dependiendo si es gratis o no
    public void insertarSuscripcion(Usuario usuario, Revista revista, double pagoSuscripcion, String fecha){
        desuscribirse(usuario.getNombre(),revista.getID());
        try {
            if(!isGratis(revista.getID())){
                conectar();
            insetar = conect.prepareStatement(INSERT+suscripciones+"(id_suscriptor, nombre_suscriptor, id_revista, titulo_revista, porcentaje, pago, fecha_suscripcion, costo)"+VALUES+"(?,?,?,?,?,?,?,?)");
            insetar.setInt(1, getIdSuscriptor(usuario.getNombre()));
            insetar.setString(2, usuario.getNombre());
            insetar.setInt(3, revista.getID());
            insetar.setString(4, revista.getTitulo());
            insetar.setDouble(5, getCostoGlobal());
            insetar.setDouble(6, pagoSuscripcion);
            insetar.setString(7, fecha);
            insetar.setDouble(8, revista.getCostoDia());
            
            insetar.executeUpdate();
            }else{
            conectar();
            insetar = conect.prepareStatement(INSERT+suscripciones+"(id_suscriptor, nombre_suscriptor, id_revista, titulo_revista, porcentaje, pago, fecha_suscripcion, costo)"+VALUES+"(?,?,?,?,?,?,?,?)");
            insetar.setInt(1, getIdSuscriptor(usuario.getNombre()));
            insetar.setString(2, usuario.getNombre());
            insetar.setInt(3, revista.getID());
            insetar.setString(4, revista.getTitulo());
            insetar.setDouble(5, getCostoGlobal());
            insetar.setDouble(6, 0);
            insetar.setString(7, fecha);
            insetar.setDouble(8, revista.getCostoDia());
            
            insetar.executeUpdate();
            }
            
            
            desconectar();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //muestra la fecha actual
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
    //muestra el id del suscriptor
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
    //quita una suscripcion
    public void desuscribirse(String usuario, int idR){
        
        try {
            conectar();
            insetar = conect.prepareStatement("update suscripciones SET expiro=1, cancelado=1 WHERE nombre_suscriptor='"+usuario+"' AND id_revista="+idR+";");
            
            insetar.executeUpdate();
            desconectar();
        } catch (SQLException ex) {
            
            ex.printStackTrace();
        }
    }
    //reetorna la si es gratis o no
    public boolean isGratis(int id){
        
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"gratis "+FROM+"revista "+WHERE+"id_revista="+id+";");
            resultado.next();
            if(resultado.getInt(1)==0){
                return false;
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        return true;
    }
    //retorna la cuaota global
    public double getCostoGlobal(){
        
        double porcentaje = 0;
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+registro+";");
            resultado.next();
            
            porcentaje = resultado.getDouble(1);
            
            
            desconectar();
        } catch (SQLException e) {
        }
        
        return porcentaje;
        
    }
    
    
}
