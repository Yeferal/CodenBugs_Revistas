
package com.revista;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class Busqueda extends Conexion{
    
    String consulta;
    
    //define el tipo de consilta que se hara para la base de datos
    public void verificarConsulta(String nombre, int tipo){
        
        switch(tipo){
            case 1:
                consulta = "SELECT r.id_revista,r.autor, r.titulo, c.categoria FROM revista r join categorias c on (r.titulo=c.titulo_revista AND c.categoria='"+nombre+"');";
                break;
            case 2:
                consulta = "SELECT r.id_revista,r.autor, r.titulo, e.etiqueta FROM revista r join etiquetas e on (r.titulo=e.titulo_revista AND e.etiqueta='"+nombre+"');";
                break;
                
        }
        
    }
    //enlista las revistas que se encuentran en la base de datos
    public List listarRevistas(){
        List<Revista> lista = new ArrayList<>();
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consulta);
            
            while (resultado.next()) {                   
                
                Revista revista = new Revista();
                revista.setID(resultado.getInt(1));
                revista.setAutor(resultado.getString(2));
                revista.setTitulo(resultado.getString(3));
                revista.setTags(resultado.getString(4));
                
                lista.add(revista);
            }
        } catch (SQLException e) {
            
        }
    return lista;
    }
}
