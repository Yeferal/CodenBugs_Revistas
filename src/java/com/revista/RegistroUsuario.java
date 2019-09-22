
package com.revista;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroUsuario extends Conexion{
    
    
    
    public boolean crearUsuario(String nombre, String pass1, String pass2, String tipo){
        
        if(verificarExistenciaUsuario(nombre)){
            if(verificarPasswordIguales(pass1, pass2)){
                insertarUsuario(nombre, pass1, tipo);
            }
        }
        return true;
    }
    
    public void insertarUsuario(String nombre, String pass, String tipo){
            try {
                conect.setAutoCommit(false);
                insetar = conect.prepareStatement("INSERT INTO usuario (nombre,password_usuario, tipo_usuario) VALUES (?,?,?)");
                insetar.setString(1, nombre);
                insetar.setString(2, pass);
                insetar.setString(3, tipo);
                insetar.executeUpdate();
                conect.commit();
                conect.setAutoCommit(true);
                conect.setAutoCommit(false);
                PreparedStatement insetarPerfil = conect.prepareStatement("INSERT INTO perfil (id_perfil, nombre, tipo_user) VALUES (?,?,?)");
                insetarPerfil.setString(1, mostrarUltimoUsuarioId());
                insetarPerfil.setString(2, nombre);
                insetarPerfil.setString(3, tipo);
                insetarPerfil.executeUpdate();
                conect.commit();
                conect.setAutoCommit(true);
                
                } catch (SQLException ex) {
                    System.out.println("Fallo");
                    ex.printStackTrace();
            }
        
    }
    
    public void insertarAdministrador(String nombre, String pass, String codigo){
            try {
                conect.setAutoCommit(false);
                insetar = conect.prepareStatement("INSERT INTO administrador VALUES (?,?,?)");
                insetar.setString(3, nombre);
                insetar.setString(4, pass);
                insetar.setString(2, codigo);
                insetar.executeUpdate();
                conect.commit();
                conect.setAutoCommit(true);
                
                } catch (SQLException ex) {
                    System.out.println("Fallo");
                    ex.printStackTrace();
            }
        
    }
    public boolean verificarPasswordIguales(String passwrd1,String passwrd2){
         if(passwrd1.equals(passwrd2)){
             return true;
         }
        
        return false;
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

    
    
    public String mostrarUltimoUsuarioId(){
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM usuario ORDER by id DESC LIMIT 1;");
            resultado.next();
            return resultado.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "0";
    }
    
    
    public void actualizarDatosUsuario(Usuario usuario){
        try {
            insetar = conect.prepareStatement("UPDATE perfil SET gustos='"+usuario.getGustos()+"', hobbies='"+usuario.getHobbies()+"', intereses='"+usuario.getIntereses()+"', descripcion='"+usuario.getDescripcion()+"' WHERE nombre='"+usuario.getNombre()+"';");
            insetar.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("No actualizo");
            ex.printStackTrace();
        }
    }
}
