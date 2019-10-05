
package com.revista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Suscripcion extends Conexion{
    
    private int idSuscripcion, idSuscriptor, idRevista, expiro, cancelo;
    private String nombreSuscriptor, tituloRevista, fechaSuscripcion;
    private double costo, ganancia, porcentaje;
    
    public void actualizarDatosRevista(String nombre, String titulo){
        
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+suscripciones+WHERE+"(id_suscriptor='"+nombre+"') AND (titulo_revista='"+titulo+"') AND (expiro=0) AND (cancelado=0);");                                       
            if(resultado.next()){
                setidSuscripcion(resultado.getInt(1));
                setidSuscriptor(resultado.getInt(2));
                setidRevista(resultado.getInt(4));
                setexpiro(resultado.getInt(11));
                setcancelo(resultado.getInt(12));
            
                setnombreSuscriptor(resultado.getString(3));
                settituloRevista(resultado.getString(5));
                setfechaSuscripcion(resultado.getString(8));
            }else{
                
            }
            
            
            desconectar();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public boolean isSuscrito(String nombre, String titulo){
        try {
            conectar();
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"* "+FROM+suscripciones+WHERE+"(id_suscriptor='"+nombre+"') AND (titulo_revista='"+titulo+"') AND (expiro=0) AND (cancelado=0);");                                       
            if(resultado.next()){
                return true;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void setidSuscripcion(int idSuscripcion){
        this.idSuscripcion = idSuscripcion;
    }
    public void setidSuscriptor(int idSuscriptor){
        this.idSuscriptor = idSuscriptor;
    }
    public void setidRevista(int idRevista){
        this.idRevista = idRevista;
    }
    public void setexpiro(int expiro){
        this.expiro = expiro;
    }
    public void setcancelo(int cancelo){
        this.cancelo = cancelo;
    }
    
    public void setnombreSuscriptor(String nombreSuscriptor){
        this.nombreSuscriptor = nombreSuscriptor;
    }
    public void settituloRevista(String tituloRevista){
        this.tituloRevista = tituloRevista;
    }
    public void setfechaSuscripcion(String fechaSuscripcion){
        this.fechaSuscripcion = fechaSuscripcion;
    }
    public void setCosto(double costo){
        this.costo = costo;
    }
    public void setGanancia(double ganancia){
        this.ganancia = ganancia;
    }
    public void setPorcentaje(double porcentaje){
        this.porcentaje = porcentaje;
    }
    
    
    public int getidSuscripcion(){
        return idSuscripcion;
    }
    public int getidSuscriptor(){
        return idSuscriptor;
    }
    public int getidRevista(){
        return idRevista;
    }
    public int getexpiro(int expiro){
        return expiro;
    }
    public int getcancelo(int cancelo){
        return cancelo;
    }
    
    public String getnombreSuscriptor(){
        return nombreSuscriptor;
    }
    public String gettituloRevista(){
        return tituloRevista;
    }
    public String getfechaSuscripcion(){
        return fechaSuscripcion;
    }
    public Suscripcion getSuscripcion(){
        return this;
    }
    
    public double getCosto(){
        return costo;
    }
    public double getGanacia(){
        return ganancia;
    }
    public double getPorcentaje(){
        return porcentaje;
    }
    
}
