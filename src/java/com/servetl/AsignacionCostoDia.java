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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AsignacionCostoDia", urlPatterns = {"/AsignacionCostoDia"})
public class AsignacionCostoDia extends HttpServlet {


    int idRevista;
    ListaRevistaEditor listaRevistas;
    SesionUsuario sesion = new SesionUsuario();
    Usuario usuario;
    String nombre;
    Revista revistaTmp=null;
    RegistroRevista registro = new RegistroRevista();
   

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        
            listaRevistas = new ListaRevistaEditor(sesion.usuario.getNombre());
            
            idRevista = Integer.parseInt(request.getParameter("numeroCosto"));
            System.out.println("IDR: "+idRevista);
            listaRevistas.setRevista(1);
            revistaTmp = listaRevistas.setRevista(idRevista);
            
            System.out.println("titulo: "+revistaTmp.getTitulo());
            request.setAttribute("revistaCosto", revistaTmp);
            
            request.getRequestDispatcher("page-asignar-costo-dia.jsp").forward(request, response);
            
        
    }
    
    private void enviarNuevoCosto(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        
        
        
        
        
    }
    private void enviarPageCosto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
    }

    

}
