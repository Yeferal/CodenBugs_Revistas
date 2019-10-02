
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


@WebServlet(name = "RegistroNuevoUsuario", urlPatterns = {"/RegistroNuevoUsuario"})
public class RegistroNuevoUsuario extends HttpServlet {

    RegistroUsuario con = new RegistroUsuario();
    SesionUsuario userSetion = new SesionUsuario();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        con.conectar();
        if(!con.verificarExistenciaUsuario(request.getParameter("nombreUser"))){
            if(con.verificarPasswordIguales(request.getParameter("passwrd1"), request.getParameter("passwrd2"))){
               
                userSetion.usuario = new Usuario();
                userSetion.usuario.setDatosPrincipales(request.getParameter("nombreUser"), request.getParameter("passwrd1"), request.getParameter("tipoUser"));
                
                con.insertarUsuario(request.getParameter("nombreUser"), request.getParameter("passwrd1"), request.getParameter("tipoUser"));
                con.desconectar();
                RequestDispatcher dispatcher = request.getRequestDispatcher("page-perfil-nuevo.jsp");
                dispatcher.forward(request, response);
                
            }else{
                request.setAttribute("error", true);
                RequestDispatcher dispatcher1 = request.getRequestDispatcher("page-new-accout.jsp");
                dispatcher1.forward(request, response);
            }
        }else{
            request.setAttribute("error", true);
            RequestDispatcher dispatcher2 = request.getRequestDispatcher("page-new-accout.jsp");
            dispatcher2.forward(request, response);
        }
        
        
        
    }


}
