
package com.revista;

import java.io.InputStream;


public class Revista {
    
    
    private int id, numeroMeGUstas,ganacias, costoPorDia, cuotaSuscripcion, numeroSuscriptores;
    private String titulo, descripcion,autor,fecha, categoria, etiqueta;
    private boolean likes,comentar,gratis;
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
            gratis=true;
        }else{
            gratis=false;
        }
    }
    public void setLikes(int estado){
        if(estado==1){
            likes = true;
        }else{
            likes = false;
        }
    }
    public void setComentar(int estado){
        if(estado==1){
            comentar = true;
        }else{
            comentar = false;
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

}
