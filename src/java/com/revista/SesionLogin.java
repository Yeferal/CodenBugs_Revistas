
package com.revista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SesionLogin extends Conexion{
 
    Usuario usuario = new Usuario();
    
    public boolean buscarUsuario(String Nombre, String pass){
        if(verificarExistenciaAdministrador(Nombre)){
            if(verificarPassword(Nombre, pass, "administrador")){
                //Usuario admin
                usuario.setDatosPrincipales(Nombre, pass, "Administrado");
                return true;
            }else{
                return false;
                //no es la contrasenia
            }
            
        }else if(verificarExistenciaUsuario(Nombre)){
            if(verificarPassword(Nombre, pass, "usuario")){
                //Usuario usuario
                usuario.setDatosPrincipales(Nombre, pass, getTipoUsuario(Nombre));
                return true;
            }else{
                //no es la contrasenia
                return false;
            }
        }
        return false;
    }
    
    
    public boolean  verificarExistenciaAdministrador(String nombreUsuario){
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT nombre FROM administrador WHERE nombre='"+nombreUsuario+"';");
            if(!resultado.next()){
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }
    
    public boolean  verificarExistenciaUsuario(String nombreUsuario){
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT nombre FROM usuario WHERE nombre='"+nombreUsuario+"';");
            //resultado.next();
            if(!resultado.next()){
                return false;
            }
            
            
        } catch (SQLException ex) {
            
        }
        
        return true;
    }
    
    
    private boolean isExisteUsuario(String nombre, String pass, String tipo){
        if(verificarExistenciaAdministrador(nombre)){
            
        }else if(verificarExistenciaUsuario(nombre)){

            return true;
        }
        
        return false;
    }
    
    public boolean verificarPassword(String nombreUsuario,String passwrdUsuario, String tipoUsuario){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT password_usuario FROM "+tipoUsuario+" WHERE nombre='"+nombreUsuario+"';");
            resultado.next();
            if(!passwrdUsuario.equals(resultado.getString(1))){
                return false;
            }
            
        } catch (SQLException ex) {
            
        }
        return true;
    }
    
    public void logearUsuario(String nombre, String contrasenia, String tipoUsuario){
        usuario.setDatosPrincipales(nombre, contrasenia, tipoUsuario);
    }
    private String getTipoUsuario(String nombre){
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT tipo_usuario FROM usuario WHERE nombre='"+nombre+"';");
            resultado.next();
            return resultado.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
