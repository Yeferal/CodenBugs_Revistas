
package com.revista;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ListaRevistaEditor extends Conexion{
    
    String nombre;
    String cadenaHTML;
    
    public ListaRevistaEditor(String nombre){
        this.nombre = nombre;
        cadenaHTML = "";
    }
    
    //muestra la cadena
    public String getCadena(){
        return cadenaHTML;
    }
    //lista las revistas con el nombre de una autor
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
    
    //lista las revsitas que no tienen monto
    public List listarRevistasSinMonto(){
        List<Revista> lista = new ArrayList<>();
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+revista+WHERE+"costo_por_dia=0;");
            
            while (resultado.next()) {    
                String categoriasLista = "";
                Statement statem = conect.createStatement();
                ResultSet resul = statem.executeQuery("SELECT categoria FROM categorias WHERE id_revista="+resultado.getInt(1)+";");
                while (resul.next()) {                    
                    categoriasLista+= resul.getString(1)+"\n";
                }
                
                
                Revista revista = new Revista();
                
                
                revista.setDatosPrincipales(resultado.getString(2), resultado.getString(3), resultado.getString(4), categoriasLista,resultado.getString(14) , resultado.getBinaryStream(10));
                revista.setID(resultado.getInt(1));
                revista.setCostoPorDia(resultado.getInt(9));
                revista.setCuotaSuscripcion(resultado.getInt(12));
                
                lista.add(revista);
            }
        } catch (SQLException e) {
            
        }
    return lista;
    }
    //lista las revsitas buscada
    public List listarRevistasBuscada(String nombre){
        List<Revista> lista = new ArrayList<>();
        Revista revista = null;
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+this.revista+WHERE+"titulo='"+nombre+"';");
            
            while (resultado.next()) {    
                String categoriasLista = "";
                Statement statem = conect.createStatement();
                ResultSet resul = statem.executeQuery("SELECT categoria FROM categorias WHERE id_revista="+resultado.getInt(1)+";");
                while (resul.next()) {                    
                    categoriasLista+= resul.getString(1);
                }
                
                
                revista = new Revista();
                
                
                revista.setDatosPrincipales(resultado.getString(2), resultado.getString(3), resultado.getString(4), categoriasLista,resultado.getString(14) , resultado.getBinaryStream(10));
                revista.setID(resultado.getInt(1));
                revista.setCostoPorDia(resultado.getInt(9));
                revista.setCuotaSuscripcion(resultado.getInt(12));
                
                lista.add(revista);
            }
        } catch (SQLException e) {
            
        }
    return lista;
    }
    //agrega una revista para ser retornada
    public Revista setRevista(int id) {
        Revista revistaR = null;
        try {
            
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+revista+WHERE+"id_revista="+id+";");

            resultado.next();
            String categoriasLista = "";
            Statement statem = conect.createStatement();
            ResultSet resul = statem.executeQuery("SELECT categoria FROM categorias WHERE id_revista="+resultado.getInt(1)+";");
            resul.next();
            categoriasLista+= resul.getString(1);
            
            String etiquetas = "";
            
            Statement statem1 = conect.createStatement();
            ResultSet resul1 = statem1.executeQuery("SELECT etiqueta FROM etiquetas WHERE id_revista="+resultado.getInt(1)+";");
            while (resul1.next()) {                
                etiquetas += resul1.getString(1)+"\n";
            }
            
            

            revistaR = new Revista();
            revistaR.setDatosPrincipales(resultado.getString(2), resultado.getString(3), resultado.getString(4), categoriasLista,resultado.getString(14) , resultado.getBinaryStream(10));
            revistaR.setID(resultado.getInt(1));
            revistaR.setCostoPorDia(resultado.getInt(9));
            revistaR.setCuotaSuscripcion(resultado.getInt(12));
            revistaR.setTags(etiquetas);
            
            revistaR.setComentar(resultado.getInt(7));
            revistaR.setLikes(resultado.getInt(8));
            revistaR.setGratis(resultado.getInt(11));
            
            desconectar();
            
            return revistaR;
        } catch (SQLException ex) {

            ex.printStackTrace();
        }
        return revistaR;
    }
    //lista todas las revsitas
    public List listarTodasRevistas(){
        List<Revista> lista = new ArrayList<>();
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM revista;");
            
            while (resultado.next()) {    
                String categoriasLista = getCategorias(resultado.getInt(1));
                String etiquetas = getEtiquetas(resultado.getInt(1));
                
                
                Revista revista = new Revista();
                
                
                revista.setDatosPrincipales(resultado.getString(2), resultado.getString(3), resultado.getString(4), categoriasLista,resultado.getString(14) , resultado.getBinaryStream(10));
                revista.setID(resultado.getInt(1));
                revista.setCostoPorDia(resultado.getInt(9));
                revista.setCuotaSuscripcion(resultado.getInt(12));
                revista.setTags(etiquetas);
            
                lista.add(revista);
            }
        } catch (SQLException e) {
            
        }
        return lista;
    }
    //muestra la categoria de la revista
    private String getCategorias(int id){
        String categoriasLista = "";
        try {
            
            Statement statem = conect.createStatement();
            ResultSet resul = statem.executeQuery("SELECT categoria FROM categorias WHERE id_revista="+id+";");
            while (resul.next()) {
                categoriasLista+= resul.getString(1)+"\n";
            }
            resul.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categoriasLista;
    }
    //muestra la etiqueta de la revsita
    private String getEtiquetas(int id){
        String etiquetas = "";
        try {
            
            
            Statement statem2 = conect.createStatement();
            ResultSet resul2 = statem2.executeQuery("SELECT etiqueta FROM etiquetas WHERE id_revista="+id+";");
            while(resul2.next()) {
                
                etiquetas += resul2.getString(1)+"\n";
            }
            resul2.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return etiquetas;
    }
}
