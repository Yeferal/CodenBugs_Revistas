
package com.revista;

import java.io.InputStream;


public class Revista {
    
    
    private int id, numeroMeGUstas,ganacias, costoPorDia, cuotaSuscripcion, numeroSuscriptores,likes,comentar,gratis;
    private String titulo, descripcion,autor,fecha, categoria, etiqueta;
    
    private InputStream pdf;
    
    
    public void setDatosPrincipales(String titulo,String Descripcion, String autor,String categoria, String fecha,InputStream pdf){
        this.titulo = titulo;
        this.descripcion = Descripcion;
        this.autor = autor;
        this.fecha = fecha;
        this.categoria = categoria;
        this.pdf = pdf;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setGratis(int estado){
        if(estado==1){
            gratis=1;
        }else{
            gratis=0;
        }
    }
    public void setLikes(int estado){
        if(estado==1){
            likes = 1;
        }else{
            likes = 0;
        }
    }
    public void setComentar(int estado){
        if(estado==1){
            comentar = 1;
        }else{
            comentar = 0;
        }
    }
    public void setID(int id){
        this.id = id;
        
    }
    public void setCostoPorDia(int costoPorDia){
        this.costoPorDia = costoPorDia;
    }
    public void setCuotaSuscripcion(int cuotaSuscripcion){
        this.cuotaSuscripcion = cuotaSuscripcion;
    }
    public void setTags(String etiqueta){
        this.etiqueta = etiqueta;
    }
//    public void set
    
    
    public int getID(){
       return id;
    }
    public String getAutor(){
        return autor;
    }
    public String getTitulo(){
        return titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getFecha(){
        return fecha;
    }
    public String getCategoria(){
        return categoria;
    }
    public int getCuotaSuscripcion(){
        return cuotaSuscripcion;
    }
    public int getCostoDia(){
        return costoPorDia;
    }
    public String getTags(){
        return etiqueta;
    }
    public int getCometar(){
        return comentar;
    }
    public int getGratis(){
        return gratis;
    }
    public int getLikes(){
        return likes;
    }

}
