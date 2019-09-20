
package com.revista;

public class Usuario {
    
    private String nombre;
    private String contrasenia;
    private String tipoUsuario;
    private String gustos;
    private String hobbies;
    private String intereses;
    private String descripcion;
    private String foto;
    
    
    public Usuario(String nombre, String contrasenia, String tipoUsuario){
        this.nombre=nombre;
        this.contrasenia=contrasenia;
        this.tipoUsuario=tipoUsuario;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setContrasenia(String contrasenia){
        this.contrasenia=contrasenia;
    }
    public void setTipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }
    public void setGustos(String gustos){
        this.gustos = gustos;
    }
    public void setHobbies(String hobbies){
        this.hobbies = hobbies;
    }
    public void setIntereses(String intereses){
        this.intereses = intereses;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    
    
    public String getNombre(){
        return nombre;
    }
    public String getContrasenia(){
        return contrasenia;
    }
    public String getTipoUsuario(){
        return tipoUsuario;
    }
    public String getGustos(){
        return gustos;
    }
    public String getHobbies(){
        return hobbies;
    }
    public String getIntereses(){
        return intereses;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    
    
    
}

