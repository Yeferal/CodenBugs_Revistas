
package com.revista;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuardarImagen extends Conexion{
    
    
    
    public void insertarImagen(Usuario usuario){
        
        try {
            insetar = conect.prepareStatement("UPDATE perfil SET foto=? WHERE nombre='"+usuario.getNombre()+"';");
            //insetar = conect.prepareStatement("UPDATE perfil SET foto=? WHERE nombre='pppp';");
            insetar.setBlob(1, usuario.getFoto());
            //insetar.setBlob(1, archivo);
            insetar.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("NO se agrego la imagen");
            ex.printStackTrace();
        }
    }
}
