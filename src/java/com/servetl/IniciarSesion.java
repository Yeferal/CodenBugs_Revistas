/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.SesionLogin;
import com.revista.SesionUsuario;
import com.revista.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

    SesionLogin con = new SesionLogin();
    SesionUsuario sesion = new SesionUsuario();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        con.conectar();
        if(con.buscarUsuario(request.getParameter("nombre"), request.getParameter("passwrd"))){
            HttpSession sesionUser = request.getSession(true);
            String nombre = sesion.usuario.getNombre();
            
            sesionUser.setAttribute("Usuario",nombre );
            Usuario usuario = new Usuario();
            usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
            con.desconectar();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(encontrartipoPagina());
            dispatcher.forward(request, response);
        }else{
            con.desconectar();


            request.setAttribute("error", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("page-login.jsp");
            dispatcher.forward(request, response);
            
            
        }
        con.desconectar();
        
    }
    
    
    private String encontrartipoPagina(){
        if(sesion.usuario.getTipoUsuario().equals("Administrador")){
            return "RecientesAdministrador";
        }else if(sesion.usuario.getTipoUsuario().equals("Editor")){
            return "HomeResultado";
            //return "PageHomeEditor.jsp";
        }else{
            
        }
        
        return "";
    }


}
