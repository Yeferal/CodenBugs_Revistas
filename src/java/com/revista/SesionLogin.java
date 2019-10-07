
package com.revista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SesionLogin extends Conexion{
 
    Usuario usuario = new Usuario();
    SesionUsuario sesion = new SesionUsuario();
    
    public SesionLogin(){
        sesion.usuario = this.usuario;
    }
    //busca a un usuario
    public boolean buscarUsuario(String Nombre, String pass){
        if(verificarExistenciaAdministrador(Nombre)){
            if(verificarPassword(Nombre, pass, "administrador")){
                //Usuario admin
                usuario.setDatosPrincipales(Nombre, pass, "Administrador");
                return true;
            }else{
                return false;
                //no es la contrasenia
            }
            
        }else if(verificarExistenciaUsuario(Nombre)){
            if(verificarPassword(Nombre, pass, "usuario")){
                //Usuario usuario
                usuario.setDatosPrincipales(Nombre, pass, getTipoUsuario(Nombre));
                setInformacion(Nombre);
                return true;
            }else{
                //no es la contrasenia
                return false;
            }
        }
        return false;
    }
    
    //verifica la eistencia de un adminsitrador
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
    //verifica la existencia d eun usuario
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
    
    //verifica la contrasenia
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
    //logea al usuario de la session
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
    //setea la informacion del usuario
    private void setInformacion(String nombre){
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM perfil WHERE nombre='"+nombre+"';");
            resultado.next();
            
            usuario.setGustos(resultado.getString(4));
            usuario.setHobbies(resultado.getString(6));
            usuario.setIntereses(resultado.getString(7));
            usuario.setDescripcion(resultado.getString(8));
        } catch (SQLException ex) {
            
        }
    }
    
    
}
