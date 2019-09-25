/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servetl;

import com.revista.Conexion;
import com.revista.Pdf;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yefer
 */
@WebServlet(name = "VerRevista", urlPatterns = {"/VerRevista"})
public class VerRevista extends HttpServlet {

    Pdf pdf = new Pdf();
    Conexion con = new Conexion();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/pdf");
        byte[] b = null;
        Statement ps = null;
        ResultSet rs = null;
        con.conectar();
        try {

            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("\nid: "+id);
            ps = con.conect.createStatement();
            rs = ps.executeQuery("SELECT pdf FROM revista WHERE id_revista="+id+";");
            System.out.println("bbbbbb");
            while (rs.next()) {
                b = rs.getBytes(1);
                System.out.println("bbbbbb"+b);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            System.out.println("bytes: "+tamanoInput);
            bos.read(datosPDF, 0, tamanoInput);

            response.getOutputStream().write(datosPDF);
            bos.close();
            ps.close();
            rs.close();
            con.desconectar();

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
