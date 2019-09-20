/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "RegistroNuevoUsuario", urlPatterns = {"/RegistroNuevoUsuario"})
public class RegistroNuevoUsuario extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        //processRequest(request, response);
        
        System.out.println("Nombre: "+request.getParameter("nombreUser"));
        System.out.println("Contrasenia 1: "+request.getParameter("passwrd1"));
        System.out.println("Contrasenia 2: "+request.getParameter("passwrd2"));
        System.out.println("Tipo: "+request.getParameter("tipoUser"));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("PagePerfilNuevo.jsp");
        dispatcher.forward(request, response);
    }


}
