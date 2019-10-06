/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.Busqueda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "BuscaInformacion", urlPatterns = {"/BuscaInformacion"})
public class BuscaInformacion extends HttpServlet {


    Busqueda busqueda =  new Busqueda();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        System.out.println(tipo);
        String nombre = null;
        switch(tipo){
            case 1:
                 nombre = request.getParameter("categoria");
                break;
            case 2:
                nombre = request.getParameter("tags");
                break;
        }
        busqueda.verificarConsulta(nombre, tipo);
        
        request.setAttribute("lista", busqueda.listarRevistas());
        
        
        request.getRequestDispatcher("page-busqueda-suscriptor.jsp").forward(request, response);
    }



}
