
package com.revista;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class BuscaImagenPerfil extends Conexion{
    
    SesionUsuario sesion = new SesionUsuario();
    Usuario usuario;
    
    
    public BuscaImagenPerfil(){
        this.usuario = sesion.usuario;
    }
    
    
    
    /**Busca la foto de perfil en la base de datos
     * luego lo comvierte en bytes y estos son agregados al buffer
     * y pot ultimo son escritos en una ruta con el nombre de usuario del perfil
     * @throws SQLException 
     */
    public byte[] escribirFoto() throws SQLException{
        byte[] data = null;
        conectar();
        stmt = conect.createStatement();
        resultado = stmt.executeQuery("SELECT foto FROM perfil WHERE nombre='"+usuario.getNombre()+"';");
        

        try {
            resultado.next();

            if(resultado.getBlob(1)!=null){
                Blob blob = resultado.getBlob(1);

            data = blob.getBytes(1, (int)blob.length());
            }

            System.out.println("SI se guardo");
        } catch (SQLException ex) {
            System.out.println("No se guardo");
            ex.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("No se guardo 2");
        }
        desconectar();
        return data;
    }
    
}
