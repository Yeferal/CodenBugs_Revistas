
package com.revista;

import java.sql.SQLException;


public class ListaCategorias extends Conexion{
    
    String cadenaHTML;
    String cadenaTags;
    
    public ListaCategorias(){
        cadenaHTML = "";
    }
    
    public String getCadena(){
        
        genearaCadena();
        return cadenaHTML;
    }
    public String getEtiquetas(){
        generarCadenaTags();
        return cadenaTags;
    }
    
    private void genearaCadena(){
        conectar();
        cadenaHTML = "<select name=\"categoria\" id=\"categoria\">\n";
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM categoria_revista;");
            
            while (resultado.next()) {                
                cadenaHTML+= "<option>";
                cadenaHTML+= resultado.getString(2);
                cadenaHTML+= "</option>\n";
            }
            cadenaHTML += "</select>";
            desconectar();
        } catch (SQLException e) {
        }
    }
    
    private String generarCadenaTags(){
        conectar();
        cadenaTags = "<select name=\"tags\" id=\"tags\">\n";
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM tags_revista;");
            
            while (resultado.next()) {                
                cadenaTags+= "<option>";
                cadenaTags+= resultado.getString(2);
                cadenaTags+= "</option>\n";
            }
            cadenaTags += "</select>";
            
            desconectar();
        } catch (SQLException e) {
            
        }
        return cadenaTags;
    }
}
