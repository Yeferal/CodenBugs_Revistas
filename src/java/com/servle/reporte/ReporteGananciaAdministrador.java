/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servle.reporte;

import com.revista.ReporteGananciasAdministrador;
import com.revista.SesionUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yefer
 */
@WebServlet(name = "ReporteGananciaAdministrador", urlPatterns = {"/ReporteGananciaAdministrador"})
public class ReporteGananciaAdministrador extends HttpServlet {

    ReporteGananciasAdministrador reporte = new ReporteGananciasAdministrador();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        String titulo = request.getParameter("nombreRevista");
        String fecha1 = request.getParameter("fecha1");
        String fecha2 = request.getParameter("fecha2");
        
        
        
              
        reporte.verificarTipo(tipo, titulo, fecha1, fecha2);
        
        request.setAttribute("suscripcion", reporte.listarSuscripcion());
        request.setAttribute("ingreso", reporte.listarIngresos());
        request.setAttribute("total", reporte.listarTotal());
        
        request.getRequestDispatcher("page-reporte-ganancias-administrador.jsp").forward(request, response);
        
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
