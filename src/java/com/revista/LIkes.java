
package com.revista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class LIkes extends Conexion{
    
    private String consultaQuery;
    private String consultaQuery1;
    private String campos = "m.nombre_suscriptor,m.titulo_revista, r.autor,m.fecha ";
    
    public void verificarTipoReporte(int tipo, String titulo, String fecha1, String fecha2, String autor){
        
        switch(tipo){
            case 1:
                //por revista
                consultaQuery = SELECT+campos+FROM+"me_gusta m join revista r on (m.id_revista=r.id_revista AND m.titulo_revista='"+titulo+"') WHERE r.autor='"+autor+"' ORDER BY m.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo,(SELECT count(id_gusta) from me_gusta WHERE titulo_revista=r.titulo) likes "+FROM+"revista r WHERE r.autor='"+autor+"' AND r.titulo='"+titulo+"' ORDER BY likes DESC;";
                break;
            case 2:
                //INtervalo de tiempo
                consultaQuery = SELECT+campos+FROM+"me_gusta m join revista r on (m.id_revista=r.id_revista) WHERE r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',m.fecha)>=0 AND TIMESTAMPDIFF(DAY,m.fecha,'"+fecha2+"')>=0 ORDER BY m.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo,(SELECT count(id_gusta) from me_gusta WHERE titulo_revista=r.titulo AND TIMESTAMPDIFF(DAY,'"+fecha1+"',fecha)>=0 AND TIMESTAMPDIFF(DAY,fecha,'"+fecha2+"')>=0) likes "+FROM+"revista r WHERE r.autor='"+autor+"' ORDER BY likes DESC;";
                break;
            case 3:
                //ambos
                consultaQuery = SELECT+campos+FROM+"me_gusta m join revista r on (m.id_revista=r.id_revista AND m.titulo_revista='"+titulo+"') WHERE r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',m.fecha)>=0 AND TIMESTAMPDIFF(DAY,m.fecha,'"+fecha2+"')>=0 ORDER BY m.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo,(SELECT count(id_gusta) from me_gusta WHERE titulo_revista=r.titulo AND TIMESTAMPDIFF(DAY,'"+fecha1+"',fecha)>=0 AND TIMESTAMPDIFF(DAY,fecha,'"+fecha2+"')>=0) likes "+FROM+"revista r WHERE r.autor='"+autor+"' AND r.titulo='"+titulo+"' ORDER BY likes DESC;";
                break;
                default:
                    System.out.println("Entroooooooooooooooo");
                consultaQuery = SELECT+campos+FROM+"me_gusta m join revista r on (m.id_revista=r.id_revista) WHERE r.autor='"+autor+"' ORDER BY m.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo,(SELECT count(id_gusta) "+FROM+"me_gusta WHERE titulo_revista=r.titulo) likes FROM revista r WHERE r.autor='"+autor+"' ORDER BY likes DESC;";
                    
        }
        System.out.println(consultaQuery);
        
    }
    
     public List listarLIkes(){
        List<MeGustaRegistro> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consultaQuery);
            while (resultado.next()) {                
             
                MeGustaRegistro megusta = new MeGustaRegistro();
                megusta.setnombreSuscriptor(resultado.getString(1));
                megusta.settituloRevista(resultado.getString(2));
                megusta.setfechaLike(resultado.getString(4));
                                            
                lista.add(megusta);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
         System.out.println("Tamnio 1 "+lista.size());
        return lista;
    }
    
    public List listarCantidadLikes(){
        List<MeGustaRegistro> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consultaQuery1);
            while (resultado.next()) {                
             
                MeGustaRegistro megusta = new MeGustaRegistro();
                megusta.settituloRevista(resultado.getString(1));
                megusta.setNoLikes(resultado.getInt(2));
                                            
                lista.add(megusta);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        System.out.println("Tamnio 2 "+lista.size());
        return lista;
    }
}
