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
@WebServlet(name = "Suscribirse", urlPatterns = {"/Suscribirse"})
public class Suscribirse extends HttpServlet {

    ListaRevistaEditor listaRevistas;
    ConsultaSuscriptor consulta = new ConsultaSuscriptor();
    SesionUsuario sesion = new SesionUsuario();
    Revista rev = new Revista();
    Suscripcion suscripcion = new Suscripcion();
    ComentarioSuscriptor comentarioSus= new ComentarioSuscriptor();
    Comentario come = new Comentario();
    RegistroSuscripcion registro = new RegistroSuscripcion();
    
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
        
                
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("ver: "+request.getParameter("datoo")); 
        
        int idR = Integer.parseInt(request.getParameter("datoo"));
        
        
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        
        sesion.setInformacion(SesionUsuario.usuario.getNombre());
        listaRevistas = new ListaRevistaEditor(sesion.usuario.getNombre());
        
        System.out.println("id: "+idR);
        rev = listaRevistas.setRevista(idR);
        
        request.setAttribute("revistaCon", rev);
        request.setAttribute("suscriptorUsuario", sesion.usuario);
        
        
        
        //request.setAttribute("listaNosuscritas", listaNosuscritas);
        request.getRequestDispatcher("page-pago.jsp").forward(request, response);
    }



}
