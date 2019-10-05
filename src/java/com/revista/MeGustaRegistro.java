
package com.revista;

import java.sql.SQLException;


public class MeGustaRegistro {
    
    private int nolikes;
    private String nombreSuscriptor, tituloRevista, fechalike;  
    
    
    public void setNoLikes(int nolikes){
        this.nolikes = nolikes;
    }
       
    
    public void setnombreSuscriptor(String nombreSuscriptor){
        this.nombreSuscriptor = nombreSuscriptor;
    }
    public void settituloRevista(String tituloRevista){
        this.tituloRevista = tituloRevista;
    }
    public void setfechaLike(String fechalike){
        this.fechalike = fechalike;
    }
     
    
    public String getnombreSuscriptor(){
        return nombreSuscriptor;
    }
    public String gettituloRevista(){
        return tituloRevista;
    }
    public String getfechaLike(){
        return fechalike;
    }
        
    public int getNoLikes(){
        return nolikes;
    }
    
    
}
