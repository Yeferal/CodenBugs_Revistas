/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultaSuscriptor extends Conexion{
    
    
    //lista la revistas en las que el usuario no esta susrito
    public List listarRevistasNoSuscritas(String nombre){
        List<Revista> lista = new ArrayList<>();
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"r.id_revista, r.titulo, r.descripcion, r.autor, (select categoria from categorias WHERE id_revista=r.id_revista) categoria,r.fecha, r.pdf "+FROM+"revista r left join suscripciones s on ((r.id_revista=s.id_revista) and (s.nombre_suscriptor='"+nombre+"') and (s.expiro<>1) and (s.cancelado<>1)) WHERE (s.id_suscripcion is null ) and (r.costo_por_dia<>0);");
            while (resultado.next()) {                
                Revista rev = new Revista();
            rev.setDatosPrincipales(resultado.getString(2),resultado.getString(3) , resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getBinaryStream(7));
            rev.setID(resultado.getInt(1));
            lista.add(rev);
            
            }
            desconectar();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(SELECT+"r.id_revista, r.titulo, r.descripcion, r.autor, (select categoria from categorias WHERE id_revista=r.id_revista) categoria,r.fecha, r.pdf "+FROM+"revista r left join suscripciones s on ((r.id_revista=s.id_revista) and (s.nombre_suscriptor='"+nombre+"')) WHERE (s.id_suscripcion is null )and (r.costo_por_dia<>0);");
        return lista;
    }
    
    //lista los comentarios de la revista
    public List listarComentarios(int idRevista){
        List<Comentario> lista = new ArrayList<>();
        
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+comentarios+WHERE+"id_revista="+idRevista+";");
            while (resultado.next()) {                
                Comentario comentario = new Comentario();
                comentario.setUsuario(resultado.getString(3));
                comentario.setFecha(resultado.getString(7));
                comentario.setComentario(resultado.getString(6));
                System.out.println(comentario.getUsuario());
            lista.add(comentario);
            
            }
            desconectar();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return lista;
        
    }
    //lista las revistas a las que el usuario esta suscrito
    public List listarRevistasSiSuscritas(String nombre){
        List<Revista> lista = new ArrayList<>();
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"r.id_revista, r.titulo, r.descripcion, r.autor, (select categoria from categorias WHERE id_revista=r.id_revista) categoria,r.fecha, r.pdf "+FROM+"revista r left join suscripciones s on ((r.id_revista=s.id_revista) and (s.nombre_suscriptor='"+nombre+"')) WHERE (s.expiro=0);");
            while (resultado.next()) {                
                Revista rev = new Revista();
            rev.setDatosPrincipales(resultado.getString(2),resultado.getString(3) , resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getBinaryStream(7));
            rev.setID(resultado.getInt(1));
            lista.add(rev);
            
            }
            desconectar();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }
    
    //retorna dato de un autor en especifico de la base de datos
    public Usuario getAutor(String nombre){
        Usuario usuario = new Usuario();
        
        try {
            conectar();
            
            stmt = conect.createStatement();
            resultado =  stmt.executeQuery(SELECT+"* "+FROM+"perfil "+WHERE+"nombre='"+nombre+"';");
            resultado.next();
            usuario.setNombre(resultado.getString(2));
            usuario.setGustos(resultado.getString(4));
            usuario.setHobbies(resultado.getString(6));
            usuario.setIntereses(resultado.getString(7));
            usuario.setDescripcion(resultado.getString(8));
            
            desconectar();
        } catch (SQLException e) {
        }
        
        
        return usuario;
        
        
    }
    
    
}
