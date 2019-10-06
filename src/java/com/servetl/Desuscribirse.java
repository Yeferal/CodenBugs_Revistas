/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.Comentario;
import com.revista.ComentarioSuscriptor;
import com.revista.ConsultaSuscriptor;
import com.revista.ListaRevistaEditor;
import com.revista.RegistroSuscripcion;
import com.revista.Revista;
import com.revista.SesionUsuario;
import com.revista.Suscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author yefer
 */
@WebServlet(name = "Desuscribirse", urlPatterns = {"/Desuscribirse"})
public class Desuscribirse extends HttpServlet {

    ListaRevistaEditor listaRevistas;
    ConsultaSuscriptor consulta = new ConsultaSuscriptor();
    SesionUsuario sesion = new SesionUsuario();
    Revista rev = new Revista();
    Suscripcion suscripcion = new Suscripcion();
    ComentarioSuscriptor comentarioSus= new ComentarioSuscriptor();
    Comentario come = new Comentario();
    RegistroSuscripcion registro = new RegistroSuscripcion();
    ArrayList<Comentario> comentariosRevistas = null;
    
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
        
        int idR = Integer.parseInt(request.getParameter("datoo"));
        
        
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        
        sesion.setInformacion(SesionUsuario.usuario.getNombre());
        listaRevistas = new ListaRevistaEditor(sesion.usuario.getNombre());

        rev = listaRevistas.setRevista(idR);
        double pago = rev.getCuotaSuscripcion();
        
        System.out.println("id: aara"+sesion.usuario.getNombre()+" "+idR);
        
        registro.desuscribirse(sesion.usuario.getNombre(), idR);
        
        suscripcion.actualizarDatosRevista(sesion.usuario.getNombre(), rev.getTitulo());
        comentariosRevistas = (ArrayList<Comentario>) consulta.listarComentarios(idR);
        
        request.setAttribute("suscripcion", 0);
        
        request.setAttribute("revistaVista", rev);
        
        request.setAttribute("comentariosRev", (ArrayList<Comentario>)comentariosRevistas);
    
        ServletOutputStream stream1 = response.getOutputStream();
        stream1.print("<html><head></head><body onload=\"alert('Se Desuscribio Exitosamente'); window.location='page-ver-revista.jsp' \"></body></html>");
        stream1.close();    }


}
