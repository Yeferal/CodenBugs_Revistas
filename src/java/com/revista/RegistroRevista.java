
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
    
    
    //inserta una revista
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
            
            insertarRestriccion(request);
            insertarCategoria(request);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    //inserta un retriccion
    public void insertarRestriccion(HttpServletRequest request) throws SQLException{
        conectar();
        if(request.getParameter("gratisRevista").equals("0")){
            
            insetar = conect.prepareStatement(UPDATE+revista+SET+"gratis=1 "+WHERE+"id_revista="+getUltimaRevista()+";");
            insetar.executeUpdate();
        }
        if(request.getParameter("bloquearComentarios").equals("0")){
            insetar = conect.prepareStatement(UPDATE+revista+SET+"comentar=0 "+WHERE+"id_revista="+getUltimaRevista()+";");
            insetar.executeUpdate();
        }
        if(request.getParameter("bloquearLikes").equals("0")){
            insetar = conect.prepareStatement(UPDATE+revista+SET+"likes=0 "+WHERE+"id_revista="+getUltimaRevista()+";");
            insetar.executeUpdate();
        }
        desconectar();
        
    }
    //modifica la restriccion
    public void modificarRestriccion(HttpServletRequest request,int id) throws SQLException{
        conectar();
        if(request.getParameter("gratisRevista")==null){
            
            insetar = conect.prepareStatement(UPDATE+revista+SET+"gratis=0 "+WHERE+"id_revista="+id+";");
            insetar.executeUpdate();
        }else{
            insetar = conect.prepareStatement(UPDATE+revista+SET+"gratis=1 "+WHERE+"id_revista="+id+";");
            insetar.executeUpdate();
        }
        
        if(request.getParameter("bloquearComentarios")==null){
            insetar = conect.prepareStatement(UPDATE+revista+SET+"comentar=1 "+WHERE+"id_revista="+id+";");
            insetar.executeUpdate();
        }else{
            insetar = conect.prepareStatement(UPDATE+revista+SET+"comentar=0 "+WHERE+"id_revista="+id+";");
            insetar.executeUpdate();
        }
        
        if(request.getParameter("bloquearLikes")==null){
            insetar = conect.prepareStatement(UPDATE+revista+SET+"likes=1 "+WHERE+"id_revista="+id+";");
            insetar.executeUpdate();
        }else{
            insetar = conect.prepareStatement(UPDATE+revista+SET+"likes=0 "+WHERE+"id_revista="+id+";");
            insetar.executeUpdate();
        }
        desconectar();
        
    }
    
    
    //inserta una categoria
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
    //muestra si una revista es gratis
    public boolean isGratis(int id){
        
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"gratis "+FROM+"revista "+WHERE+"id_revista="+id+";");
            resultado.next();
            if(resultado.getInt(1)==0){
                return false;
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        return true;
    }
    //muestra su a una revista se le puede dar likes
    public boolean isLikes(int id){
        
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"likes "+FROM+"revista "+WHERE+"id_revista="+id+";");
            resultado.next();
            if(resultado.getInt(1)==0){
                return false;
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        return true;
    }
    // muestra si a una revista se le puede hacer comentar
    public boolean isComentar(int id){
        
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"comentar "+FROM+"revista "+WHERE+"id_revista="+id+";");
            resultado.next();
            if(resultado.getInt(1)==0){
                return false;
            }
            
            desconectar();
        } catch (SQLException e) {
        }
        
        return true;
    }
    
    
    //inserta una ficero el cual lo retorna
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
    //retorna el id de la ultima revista
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
    //actualiza el costo por dia de una revista
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
    //agrega una etiqueta a una revista
    public void agregarEtiquetaRevista(String id, String etiqueta){
        
        try {
            conectar();
            insetar = conect.prepareStatement(INSERT+"etiquetas "+VALUES+"(?,?,?);");
            //insetar = conect.prepareStatement("INSERT INTO categorias VALUES (?,?,?);");
            insetar.setString(1, id);
            insetar.setString(2, getTituloRevista(id));
            
            insetar.setString(3, etiqueta);
            
            insetar.executeUpdate();
            
            desconectar();
        } catch (SQLException ex) {
            System.out.println("Fallo en isertar categoria");
            ex.printStackTrace();
        }
        
    }
    //muestra el titulo de una revista con la busqueda de su id
    private String getTituloRevista(String id){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"titulo "+FROM+"revista "+WHERE+"id_revista="+id+";");
            resultado.next();
            
            
            return resultado.getString(1);
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return "";
    }
}
