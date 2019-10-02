/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.ListaRevistaEditor;
import com.revista.RegistroRevista;
import com.revista.Revista;
import com.revista.SesionUsuario;
import com.revista.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AsignacionEtiqueta", urlPatterns = {"/AsignacionEtiqueta"})
public class AsignacionEtiqueta extends HttpServlet {

    int idRevista;
    ListaRevistaEditor listaRevistas;
    SesionUsuario sesion = new SesionUsuario();
    Usuario usuario;
    String nombre;
    Revista revistaTmp=null;
    RegistroRevista registro = new RegistroRevista();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        
            listaRevistas = new ListaRevistaEditor(sesion.usuario.getNombre());
            
            idRevista = Integer.parseInt(request.getParameter("idrevistaEtiqueta"));
            System.out.println("IDR: "+idRevista);
            
            revistaTmp = listaRevistas.setRevista(idRevista);
            
            System.out.println("titulo: "+revistaTmp.getTitulo());
            request.setAttribute("revistaEtiqueta", revistaTmp);
            
            request.getRequestDispatcher("page-nueva-etiqueta.jsp").forward(request, response);
    }

    

}
