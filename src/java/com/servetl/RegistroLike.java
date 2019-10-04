/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.Comentario;
import com.revista.ConsultaSuscriptor;
import com.revista.ListaRevistaEditor;
import com.revista.MeGusta;
import com.revista.Revista;
import com.revista.SesionUsuario;
import com.revista.Suscripcion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "RegistroLike", urlPatterns = {"/RegistroLike"})
public class RegistroLike extends HttpServlet {

    
    ListaRevistaEditor listaRevistas;
    ConsultaSuscriptor consulta = new ConsultaSuscriptor();
    SesionUsuario sesion = new SesionUsuario();
    Revista rev = new Revista();
    Suscripcion suscripcion = new Suscripcion();
    ArrayList<Comentario> comentariosRevistas = null;
    MeGusta megusta = new MeGusta();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idR = Integer.parseInt(request.getParameter("idR"));
        System.out.println("id: "+idR);
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        
        sesion.setInformacion(SesionUsuario.usuario.getNombre());
        
        listaRevistas = new ListaRevistaEditor(sesion.usuario.getNombre());
        
        rev = listaRevistas.setRevista(idR);
        
        
        comentariosRevistas = (ArrayList<Comentario>) consulta.listarComentarios(idR);
        System.out.println("tamanio: "+comentariosRevistas.size());
        
        megusta.insertarMeGusta(sesion.usuario.getNombre(), rev);
        
        if(suscripcion.isSuscrito(sesion.usuario.getNombre(), rev.getTitulo())){
            suscripcion.actualizarDatosRevista(sesion.usuario.getNombre(), rev.getTitulo());
            request.setAttribute("suscripcion", suscripcion);
        }else{
            request.setAttribute("suscripcion", 0);
        }
        
        request.setAttribute("nombresus", sesion.usuario.getNombre());
                
        request.setAttribute("megusta", megusta);
        
        request.setAttribute("revistaVista", rev);
        
        request.setAttribute("comentariosRev", (ArrayList<Comentario>)comentariosRevistas);
        
        request.getRequestDispatcher("page-ver-revista.jsp").forward(request, response);
        
    }

    

}
