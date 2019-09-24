
package com.revista;

import java.sql.SQLException;


public class ListaCategorias extends Conexion{
    
    String cadenaHTML;
    
    public ListaCategorias(){
        cadenaHTML = "";
    }
    
    public String getCadena(){
        
        genearaCadena();
        return cadenaHTML;
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
}
