/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.GuardarImagen;
import com.revista.SesionUsuario;
import com.revista.Usuario;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name = "RegistroImagen", urlPatterns = {"/RegistroImagen"})
@MultipartConfig
public class RegistroImagen extends HttpServlet {
    
    Usuario usuario;
    SesionUsuario userSetion = new SesionUsuario();
    GuardarImagen guardar = new GuardarImagen();
    
    public RegistroImagen(){
        this.usuario = userSetion.usuario;
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        guardar.conectar();
        
        InputStream inputStream = null;
        try {
            Part filePart = request.getPart("fichero");
            if (filePart.getSize() > 0) {
                System.out.println("img: ");
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                inputStream = filePart.getInputStream();
                usuario.setFoto(inputStream);
                System.out.println(usuario.getNombre());
                
                guardar.insertarImagen(usuario);
                //guardar.insertarImagen(inputStream);
            }
        } catch (Exception ex) {
            
            System.out.println("fichero: "+ex.getMessage());
        }
        
        guardar.desconectar();
        
    }


}
