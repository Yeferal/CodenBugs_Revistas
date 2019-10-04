/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servle.reporte;

import com.revista.ReporteComentariosEditor;
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
@WebServlet(name = "ReporteComentarios", urlPatterns = {"/ReporteComentarios"})
public class ReporteComentarios extends HttpServlet {

    SesionUsuario sesion = new SesionUsuario();
    ReporteComentariosEditor reporte = new ReporteComentariosEditor();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        int tipo = Integer.parseInt(request.getParameter("tipo"));
        String titulo = request.getParameter("nombreRevista");
        String fecha1 = request.getParameter("fecha1");
        String fecha2 = request.getParameter("fecha2");
        
        
        
        System.out.println("tipo: "+tipo);
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        
        sesion.setInformacion(SesionUsuario.usuario.getNombre());
        
        reporte.verificarTipoReporte(tipo, titulo, fecha1, fecha2, sesion.usuario.getNombre());
        
        request.setAttribute("comentario", reporte.listarComentarios());
        
        request.getRequestDispatcher("page-report-editor.jsp").forward(request, response);
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
