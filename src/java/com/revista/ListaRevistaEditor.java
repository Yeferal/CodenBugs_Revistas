
package com.revista;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ListaRevistaEditor extends Conexion{
    
    String nombre;
    String cadenaHTML;
    
    public ListaRevistaEditor(String nombre){
        this.nombre = nombre;
        cadenaHTML = "";
    }
    
    
    public String getCadena(){
        return cadenaHTML;
    }
    
    public List listarRevistas(){
        List<Revista> lista = new ArrayList<>();
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM revista WHERE autor='"+nombre+"';");
            
            while (resultado.next()) {    
                String categoriasLista = "";
                Statement statem = conect.createStatement();
                ResultSet resul = statem.executeQuery("SELECT categoria FROM categorias WHERE id_revista="+resultado.getInt(1)+";");
                while (resul.next()) {                    
                    categoriasLista+= resul.getString(1)+", ";
                }
                
                
                Revista revista = new Revista();
                
                
                revista.setDatosPrincipales(resultado.getString(2), resultado.getString(3), resultado.getString(4), categoriasLista,resultado.getString(14) , resultado.getBinaryStream(10));
                revista.setID(resultado.getInt(1));
                
                lista.add(revista);
            }
        } catch (SQLException e) {
            
        }
    return lista;
    }
    
}
