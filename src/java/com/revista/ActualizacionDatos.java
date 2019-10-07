/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revista;

import java.sql.SQLException;


public class ActualizacionDatos extends Conexion{
 
    Usuario usuario = new Usuario();
    SesionUsuario sesion = new SesionUsuario();
    public ActualizacionDatos(){
        sesion.usuario = usuario;
    }
    
    //Actualiza la informacion del usuario que esta en sesion
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
