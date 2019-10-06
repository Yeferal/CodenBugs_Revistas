/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.RegistroRevista;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "Restriccion", urlPatterns = {"/Restriccion"})
public class Restriccion extends HttpServlet {

    RegistroRevista registroRevista = new RegistroRevista();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("id restir: "+request.getParameter("idRevsita"));
        request.getRequestDispatcher("HomeResultado").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        int id =  Integer.parseInt(request.getParameter("idR"));
        if(tipo==1){
            
        
        if(registroRevista.isGratis(id)){
            request.setAttribute("esgratis",1);
        }else{
            request.setAttribute("esgratis",0);
        }
        
        if(registroRevista.isLikes(id)){
            request.setAttribute("eslike",1);
        }else{
            request.setAttribute("eslike",0);
        }
        
        if(registroRevista.isComentar(id)){
            request.setAttribute("escomen",1);
        }else{
            request.setAttribute("escomen",0);
        }
        
        request.setAttribute("idRevista", id);
        
        request.getRequestDispatcher("page-restriccion-revista.jsp").forward(request, response);
        
        }else{
            
            try {
                registroRevista.modificarRestriccion(request, id);
            } catch (SQLException ex) {
                
            }
            request.getRequestDispatcher("HomeResultado").forward(request, response);
        }
        
        
        
    }



}
