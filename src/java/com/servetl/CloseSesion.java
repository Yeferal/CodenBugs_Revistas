
package com.servetl;

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


@WebServlet(name = "CloseSesion", urlPatterns = {"/CloseSesion"})
public class CloseSesion extends HttpServlet {


   SesionUsuario sesion = new SesionUsuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //HttpSession sesionUser = request.getSession(true);
        //sesionUser.setAttribute("Usuario",true );
        request.setAttribute("Usuario",true);
        
        sesion.usuario.setNombre("");
        sesion.usuario.setTipoUsuario("");
        sesion.usuario.setInformacionaExtra("","","","");
        request.getSession().invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-login.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    

}
