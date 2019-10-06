
package com.revista;


public class Ganancia {
    
    private String titulo,suscriptor,fecha;
    private double pago,costo,ganancia,ingreso;
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setSuscriptor(String suscriptor){
        this.suscriptor = suscriptor;
    }
    public void setfecha(String fecha){
        this.fecha = fecha;
    }
    public void setCosto(double costo){
        this.costo = costo;
    }
    public void setGanancia(double ganancia){
        this.ganancia = ganancia;
    }
    public void setIngreso(double ingreso){
        this.ingreso = ingreso;
    }
    public void setPago(double pago){
        this.pago = pago;
    }
    
    
    
    public String getFecha(){
        return fecha;
    }
    public double getCosto(){
        return costo;
    }
    public double getGanacia(){
        return ganancia;
    }public String getSuscriptor(){
        return suscriptor;
    }
    public String gettitulo(){
        return titulo;
    }
    public String getfecha(){
        return fecha;
    }
    public double getIngreso(){
        return ingreso;
    }
    public double getPago(){
        return pago;
    }
    
}
