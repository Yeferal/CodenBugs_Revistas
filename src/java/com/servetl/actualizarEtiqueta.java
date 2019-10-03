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
@WebServlet(name = "actualizarEtiqueta", urlPatterns = {"/actualizarEtiqueta"})
public class actualizarEtiqueta extends HttpServlet {

    Revista revistaTmp=null;
    RegistroRevista registro = new RegistroRevista();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idR = request.getParameter("idRevista");
        String etiqueta = request.getParameter("tags");
        
        
       //registro.actualizarCostoDia(costo, idR);
       registro.agregarEtiquetaRevista(idR, etiqueta);
        
       ServletOutputStream stream1 = response.getOutputStream();
             stream1.print("<html><head></head><body onload=\"alert('Se agrego la etiqueta'); window.location='RecientesAdministrador' \"></body></html>");
             stream1.close();
    }

    

}
