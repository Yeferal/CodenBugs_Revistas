/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.ListaRevistaEditor;
import com.revista.Revista;
import com.revista.SesionUsuario;
import com.revista.Usuario;
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


@WebServlet(name = "HomeResultado", urlPatterns = {"/HomeResultado"})
public class HomeResultado extends HttpServlet {

    ListaRevistaEditor listaRevistas;
    SesionUsuario sesion = new SesionUsuario();
    Usuario usuario;
    String nombre;
    
    public HomeResultado() {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = this.nombre;
        
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        sesion.setInformacion(SesionUsuario.usuario.getNombre());
        System.out.println("NOmbreRR: "+sesion.usuario.getNombre());
        
        listaRevistas = new ListaRevistaEditor(sesion.usuario.getNombre());
        listaRevistas.listarRevistas();
        
        
        
        request.setAttribute("lista", listaRevistas.listarRevistas());
        ArrayList<Revista> dato = (ArrayList<Revista>) request.getAttribute("lista");
        //System.out.println("tamanio: "+ dato.size());
        
//        ArrayList<Revista> dato = (ArrayList<Revista>) request.getAttribute("lista");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        
    }


}
