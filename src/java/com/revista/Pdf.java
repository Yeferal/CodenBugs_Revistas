/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revista;

import java.sql.Blob;
import java.sql.SQLException;

/**
 *
 * @author yefer
 */
public class Pdf extends Conexion{
    
    
    //escribe el pdf en un byte para usarlo en la page
    public byte[] escribirPDF(int id) throws SQLException{
        byte[] data = null;
        conectar();
        stmt = conect.createStatement();
        resultado = stmt.executeQuery("SELECT pdf FROM revista WHERE id_revista="+id+";");
        

        try {
            resultado.next();

            if(resultado.getBlob(1)!=null){
                Blob blob = resultado.getBlob(1);

            data = blob.getBytes(1, (int)blob.length());
            }
            return resultado.getBytes(1);
        } catch (SQLException ex) {
            System.out.println("No se guardo");
            ex.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("No se guardo 2");
        }
        desconectar();
        return data;
    }
}
