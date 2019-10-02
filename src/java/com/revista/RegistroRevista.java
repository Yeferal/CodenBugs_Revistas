
package com.revista;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;


public class RegistroRevista extends Conexion{
    
    
    
    public void insertarRevista(HttpServletRequest request, Usuario usuario){
        try {
            conectar();
            insetar = conect.prepareStatement("INSERT INTO revista (titulo,descripcion,autor,pdf,cuota_suscripcion,fecha) VALUES (?,?,?,?,?,?);");
            insetar.setString(1, request.getParameter("tituloRevista"));
            insetar.setString(2, request.getParameter("descripcionRevista"));
            insetar.setString(3, usuario.getNombre());
            //insetar.setString(6, "bloquearComentarios");
            //insetar.setString(7, "bloquearLikes");
            insetar.setBlob(4, archivo(request));
            //insetar.setString(11, "gratisRevista");
            insetar.setString(5, request.getParameter("cuota"));
            insetar.setString(6, request.getParameter("fecha"));
            insetar.executeUpdate();
            desconectar();
            insetar = null;
            
            insertarCategoria(request);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    private void insertarCategoria(HttpServletRequest request){
        
        try {
            conectar();
            insetar = conect.prepareStatement(INSERT+"categorias "+VALUES+"(?,?,?);");
            //insetar = conect.prepareStatement("INSERT INTO categorias VALUES (?,?,?);");
            insetar.setInt(1, getUltimaRevista());
            insetar.setString(2, request.getParameter("tituloRevista"));
            System.out.println("Categoria: "+request.getParameter("categoria"));
            insetar.setString(3, request.getParameter("categoria"));
            insetar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en isertar categoria");
            ex.printStackTrace();
        }
        
    }  
    
    
    
    private InputStream archivo(HttpServletRequest request){
       InputStream inputStream = null;
        try {
           
           Part filePart = request.getPart("fichero");
           
           inputStream = filePart.getInputStream();
           
       } catch (IOException | ServletException ex) {
           ex.printStackTrace();
       }
       return inputStream;
    }
    
    private int getUltimaRevista(){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"id_revista "+FROM+"revista ORDER by id_revista DESC LIMIT 1;");
            resultado.next();
            System.out.println("I revista: "+resultado.getInt(1));
            return resultado.getInt(1);
            
            
        } catch (SQLException ex) {
            
        }
        return 0;
    }
    
    public void actualizarCostoDia(int costo, int id){
        
        try {
            conectar();
            insetar = conect.prepareStatement(UPDATE+revista+SET+"costo_por_dia="+costo+" "+WHERE+"id_revista="+id+";");
            insetar.executeUpdate();
            desconectar();;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    public void agregarEtiquetaRevista(int id, String etiqueta){
        
        try {
            conectar();
            insetar = conect.prepareStatement(INSERT+"etiquetas "+VALUES+"(?,?,?);");
            //insetar = conect.prepareStatement("INSERT INTO categorias VALUES (?,?,?);");
            insetar.setInt(1, id);
            insetar.setString(2, getTituloRevista(id));
            
            insetar.setString(3, etiqueta);
            insetar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en isertar categoria");
            ex.printStackTrace();
        }
        
    }
    private String getTituloRevista(int id){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"titulo "+FROM+"revista "+WHERE+"id_revista="+id+";");
            resultado.next();
            System.out.println("Id revista: "+resultado.getInt(1));
            return resultado.getString(1);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "";
    }
}
