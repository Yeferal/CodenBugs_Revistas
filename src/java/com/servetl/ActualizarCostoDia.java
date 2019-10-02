/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.RegistroRevista;
import com.revista.Revista;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "ActualizarCostoDia", urlPatterns = {"/ActualizarCostoDia"})
public class ActualizarCostoDia extends HttpServlet {


    RegistroRevista registro = new RegistroRevista();

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idR = Integer.parseInt(request.getParameter("idRevista"));
        
        int costo = Integer.parseInt(request.getParameter("costoDia"));
        registro.actualizarCostoDia(costo, idR);
        
        ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('Se agrego el nuevo Costo'); window.location='RecientesAdministrador' \"></body></html>");
             stream1.close();
             
        request.getRequestDispatcher("page-receintes-administrador.jsp").forward(request, response);
    }

    

}
