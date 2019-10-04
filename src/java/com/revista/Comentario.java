
package com.revista;


public class Comentario extends Conexion{
    
    
    private String titulo;
    String usuario,fecha,comentario;
    
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setComentario(String comentario){
        this.comentario = comentario;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    
    public String getUsuario(){
        return usuario;
    }
    public String getFecha(){
        return fecha;
    }
    public String getComentario(){
        return comentario;
    }
    
    public String getTitulo(){
        return titulo;
    }
}
