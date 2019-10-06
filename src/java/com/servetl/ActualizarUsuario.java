
package com.servetl;

import com.revista.RegistroUsuario;
import com.revista.SesionUsuario;
import com.revista.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ActualizarUsuario", urlPatterns = {"/ActualizarUsuario"})
public class ActualizarUsuario extends HttpServlet {

    Usuario usuario;
    RegistroUsuario con = new RegistroUsuario();
    SesionUsuario sesion = new SesionUsuario();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        con.conectar();
        
        
        
        HttpSession sesionUser = request.getSession();
        System.out.println("ola soy: "+sesionUser.getAttribute("Usuario").toString());
        sesion.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        
        
        sesion.usuario.setGustos(request.getParameter("textareaGustos"));
        sesion.usuario.setHobbies(request.getParameter("textareaHobi"));
        sesion.usuario.setIntereses(request.getParameter("textareaInteres"));
        sesion.usuario.setDescripcion(request.getParameter("textareaBio"));
        
        con.actualizarDatosUsuario(sesion.usuario);
        con.desconectar();
        
                
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-perfil-nuevo.jsp");
                dispatcher.forward(request, response);
    }

}
