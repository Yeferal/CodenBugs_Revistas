/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yefer
 */
public class ConsultaSuscriptor extends Conexion{
    
    
    
    public List listarRevistasNoSuscritas(String nombre){
        List<Revista> lista = new ArrayList<>();
        conectar();
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(SELECT+"r.id_revista, r.titulo, r.descripcion, r.autor, (select categoria from categorias WHERE id_revista=r.id_revista) categoria,r.fecha, r.pdf "+FROM+"revista r left join suscripciones s on ((r.id_revista=s.id_revista) and (s.nombre_suscriptor='"+nombre+"')) WHERE (s.id_suscripcion is null);");
            while (resultado.next()) {                
                Revista rev = new Revista();
            rev.setDatosPrincipales(resultado.getString(2),resultado.getString(3) , resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getBinaryStream(7));
            rev.setID(1);
            lista.add(rev);
            
            }
            desconectar();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return lista;
    }
    
}