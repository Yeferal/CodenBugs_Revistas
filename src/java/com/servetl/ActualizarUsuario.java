
package com.servetl;

import com.revista.RegistroUsuario;
import com.revista.SesionUsuario;
import com.revista.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ActualizarUsuario", urlPatterns = {"/ActualizarUsuario"})
public class ActualizarUsuario extends HttpServlet {

    Usuario usuario;
    RegistroUsuario con = new RegistroUsuario();
    SesionUsuario userSetion = new SesionUsuario();
    
    public ActualizarUsuario(){
//        this.usuario = userSetion.usuario;
          
          
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        con.conectar();
        
        
        
        System.out.println(usuario.getNombre()+" "+usuario.getTipoUsuario());
        
        usuario.setGustos(request.getParameter("textareaGustos"));
        usuario.setHobbies(request.getParameter("textareaHobi"));
        usuario.setIntereses(request.getParameter("textareaInteres"));
        usuario.setDescripcion(request.getParameter("textareaBio"));
        
        con.actualizarDatosUsuario(usuario);
        con.desconectar();
    }

}
