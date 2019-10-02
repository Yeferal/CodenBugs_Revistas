/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.BuscaImagenPerfil;
import com.revista.SesionUsuario;
import com.revista.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ImagenEncuentra", urlPatterns = {"/ImagenEncuentra"})
public class ImagenEncuentra extends HttpServlet {

    SesionUsuario sesion = new SesionUsuario();
    Usuario usuario;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        
        HttpSession sesionUser = request.getSession();
        
        SesionUsuario.usuario.setNombre(sesionUser.getAttribute("Usuario").toString());
        sesion.setInformacion(SesionUsuario.usuario.getNombre());
        
        //usuario = sesion.usuario;
        
        BuscaImagenPerfil imgFoto = new BuscaImagenPerfil();
        try {
            response.setContentType("imge/*");
            
            byte[] imagen = imgFoto.escribirFoto();
            if(imagen!=null){
                ServletOutputStream stream1 = response.getOutputStream();
                stream1.write(imagen);
            }else{
                ServletOutputStream stream2 = response.getOutputStream();
                stream2.print("src=\"css/img/perfilVacio.jpg\"");
            }
        } catch (IOException | SQLException | ClassCastException e) {
            System.out.println("Fallo algo");
        }
        
        
    }



}
