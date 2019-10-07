
package com.revista;

import java.sql.SQLException;

public final class SesionUsuario extends Conexion{
 
    public static Usuario usuario = new Usuario();
    
    public SesionUsuario(){
        
    }
    
    //actualiza la informacion del usurioa principal
    public void setInformacion(String nombre){
        conectar();
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
        desconectar();
    }
}
