
package com.revista;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
    
    /**Buscar si la foto del usuario existe si si retorna el nombre de la imagen
     * de lo contrario retorna el nombre de la foto sin perfil
     * @return 
     */
    public String buscarNombreImagen(){
        
        if(usuario.getFoto()!=null){
            
            return "perfil"+usuario.getNombre()+".png";
        }
        
       return "css/img/perfilVacio.jpg";
    }
    
    /**Busca la foto de perfil en la base de datos
     * luego lo comvierte en bytes y estos son agregados al buffer
     * y pot ultimo son escritos en una ruta con el nombre de usuario del perfil
     * @throws SQLException 
     */
    public void escribirFoto() throws SQLException{
        conectar();
        stmt = conect.createStatement();
        resultado = stmt.executeQuery("SELECT foto FROM perfil WHERE nombre='"+usuario.getNombre()+"';");
        
        BufferedImage foto = null;

        try {
            resultado.next();
            Blob blob = resultado.getBlob(1);
            
            byte[] data = blob.getBytes(1, (int)blob.length());
            
            foto = ImageIO.read(new ByteArrayInputStream(data));
            File archivo = new File("perfil"+usuario.getNombre()+".png");
            
            ImageIO.write(foto, "png", archivo);
            System.out.println("SI se guardo");
        } catch (IOException ex) {
            System.out.println("No se guardo");
            ex.printStackTrace();
        }
        desconectar();
    }
    
}
