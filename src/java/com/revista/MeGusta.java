
package com.revista;

import java.sql.SQLException;


public class MeGusta extends Conexion{
    
    
    
    
    public int verLikes(int idRevista){
        int numero = 0;
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("select count(id_gusta) from me_gusta where id_revista="+idRevista+";");
            resultado.next();
            numero = resultado.getInt(1);
            
            desconectar();
        } catch (SQLException e) {
        }
        
        return numero;
    }
    public void insertarMeGusta(String nombre, Revista revista){
        
        try {
            conectar();
            insetar = conect.prepareStatement(INSERT+meGusta+"(id_suscriptor, nombre_suscriptor, id_revista, titulo_revista, fecha) "+VALUES+"(?,?,?,?,?);");
            insetar.setInt(1, getIdSuscriptor(nombre));
            insetar.setString(2, nombre);
            insetar.setInt(3, revista.getID());
            insetar.setString(4, revista.getTitulo());
            insetar.setString(5, getFechaActual());
            insetar.executeUpdate();
            
            desconectar();
        } catch (SQLException e) {
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
    public boolean isMeGustasSuscriptor(String nombre){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"nombre_suscriptor "+FROM+meGusta+WHERE+"nombre_suscriptor='"+nombre+"';");
            if(resultado.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}
