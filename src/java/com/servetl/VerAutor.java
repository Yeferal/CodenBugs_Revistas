/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.ConsultaSuscriptor;
import com.revista.Usuario;
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
@WebServlet(name = "VerAutor", urlPatterns = {"/VerAutor"})
public class VerAutor extends HttpServlet {

    ConsultaSuscriptor consulta =  new ConsultaSuscriptor();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("autor");
        
        Usuario usuario = new Usuario();
        
        usuario = consulta.getAutor(nombre);
        
        request.setAttribute("autor", usuario);
        
        request.getRequestDispatcher("page-perfil-editor-ver.jsp").forward(request, response);
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nombre = request.getParameter("autor");
        
        Usuario usuario = new Usuario();
        
        usuario = consulta.getAutor(nombre);
        
        request.setAttribute("autor", usuario);
        
        request.getRequestDispatcher("page-perfil-editor-ver.jsp").forward(request, response);
        
    }

    

}
