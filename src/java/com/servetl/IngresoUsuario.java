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
@WebServlet(name = "IngresoUsuario", urlPatterns = {"/IngresoUsuario"})
public class IngresoUsuario extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo= request.getParameter("tipo");
        switch(tipo){
            case "Administrador":
                RequestDispatcher dispatcher = request.getRequestDispatcher("RecientesAdministrador");
                dispatcher.forward(request, response);
                break;
            case "Editor":
                RequestDispatcher dispatcher2 = request.getRequestDispatcher("HomeResultado");
                dispatcher2.forward(request, response);
                break;
            default:
                RequestDispatcher dispatcher3 = request.getRequestDispatcher("SuscriptorRevista");
                dispatcher3.forward(request, response);
                
        }
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
