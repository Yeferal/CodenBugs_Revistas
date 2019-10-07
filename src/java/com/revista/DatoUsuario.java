
package com.revista;


public class DatoUsuario {
    
    private String cadena;
    private Usuario usuario;
    
    public DatoUsuario(Usuario usuario){
        cadena = "";
        this.usuario = usuario;
    }
    
    //muestra la cadena
    public String getCadena(){
        return cadena;
    }
    //encadena los dtos de los gustos de un usuario
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
    //agrega los gustos del usuario
    private void setGustos(){
        cadena += "<div class=\"\">\n" +
"                    <label>Gustos: </label>\n" +usuario.getGustos()+
"                </div>";
    }
    //agrega los hibbies del usuruoa
    private void setHobbies(){
        cadena += "<div class=\"\">\n" +
"                    <label>Hobbies: </label>\n" +usuario.getHobbies()+
"                </div>";
    }
    //agrega los interes del usuario
    private void setIntereses(){
        cadena += "<div class=\"\">\n" +
"                    <label>Intereses: </label>\n" +usuario.getIntereses()+
"                </div>";
    }
    //agrega la descricpcion del usuraio
    private void setDescripcion(){
        cadena += "<div class=\"\">\n" +
"                    <label>Descripcion: </label>\n" +usuario.getDescripcion()+
"                </div>";
    }
    
}
