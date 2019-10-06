/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.RegistroRevista;
import com.revista.SesionLogin;
import com.revista.SesionUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RegistroNuevaRevista", urlPatterns = {"/RegistroNuevaRevista"})
@MultipartConfig
public class RegistroNuevaRevista extends HttpServlet {

    
    SesionLogin con = new SesionLogin();
    SesionUsuario sesion = new SesionUsuario();
    RegistroRevista registroRevsita;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        con.conectar();
        HttpSession sesionUser = request.getSession();
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        sesion.setInformacion(SesionUsuario.usuario.getNombre());
        con.desconectar();
        
        registroRevsita = new RegistroRevista();
        registroRevsita.insertarRevista(request, sesion.usuario);
        
        System.out.println("Check 1: "+request.getParameter("gratisRevista"));
        System.out.println("Check 2: "+request.getParameter("bloquearComentarios"));
        System.out.println("Check 3: "+request.getParameter("bloquearLikes"));
        
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("page-nueva-revista-editor.jsp");
        dispatcher.forward(request, response);
    }


}
