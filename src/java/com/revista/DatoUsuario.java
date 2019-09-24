
package com.revista;


public class DatoUsuario {
    
    private String cadena;
    private Usuario usuario;
    
    public DatoUsuario(Usuario usuario){
        cadena = "";
        this.usuario = usuario;
    }
    
    public String getCadena(){
        return cadena;
    }
    
    public void encadenarDatos(){
        if(usuario.getGustos()!=null){
            setGustos();
        }
        if(usuario.getHobbies()!=null){
            setHobbies();
        }
        if(usuario.getIntereses()!=null){
            setIntereses();
        }
        if(usuario.getDescripcion()!=null){
            setDescripcion();
        }
        
    }
    
    private void setGustos(){
        cadena += "<div class=\"\">\n" +
"                    <label>Gustos: </label>\n" +usuario.getGustos()+
"                </div>";
    }
    private void setHobbies(){
        cadena += "<div class=\"\">\n" +
"                    <label>Hobbies: </label>\n" +usuario.getHobbies()+
"                </div>";
    }
    private void setIntereses(){
        cadena += "<div class=\"\">\n" +
"                    <label>Intereses: </label>\n" +usuario.getIntereses()+
"                </div>";
    }
    private void setDescripcion(){
        cadena += "<div class=\"\">\n" +
"                    <label>Descripcion: </label>\n" +usuario.getDescripcion()+
"                </div>";
    }
    
}
