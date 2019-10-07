
package com.revista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReporteComentariosEditor extends Conexion{
    
    
    String consultaQuery;
    String campos = "c.nombre_suscriptor, c.opinion, r.titulo, c.fecha ";
    
    String consulta1, consulta2, consulta3;
    
    //Verifica el tipo de consulta para la base de datos
    public void verificarTipoReporte(int tipo, String titulo, String fecha1, String fecha2, String autor){
        
        switch(tipo){
            case 1:
                //por revista
                consultaQuery = SELECT+campos+FROM+"comentarios c left join revista r on (r.id_revista=c.id_revista and r.titulo='"+titulo+"') where r.autor='"+autor+"' ORDER by c.fecha ASC;";
                break;
            case 2:
                //INtervalo de tiempo
                consultaQuery = SELECT+campos+FROM+"comentarios c left join revista r on (r.id_revista=c.id_revista) where r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',c.fecha)>=0 AND TIMESTAMPDIFF(DAY,c.fecha,'"+fecha2+"')>=0 ORDER by c.fecha ASC;";
                break;
            case 3:
                //ambos
                consultaQuery = SELECT+campos+FROM+"comentarios c left join revista r on (r.id_revista=c.id_revista) where r.autor='"+autor+"' and r.titulo='"+titulo+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',c.fecha)>=0 AND TIMESTAMPDIFF(DAY,c.fecha,'"+fecha2+"')>=0 ORDER by c.fecha ASC;";
                break;
                default:
                consultaQuery = SELECT+campos+FROM+"comentarios c left join revista r on (r.id_revista=c.id_revista) where r.autor='"+autor+"' ORDER by c.fecha ASC;";
        }
        
    }
    //lista los comentarios y los retorna
    public List listarComentarios(){
        List<Comentario> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consultaQuery);
            while (resultado.next()) {                
             
                Comentario comentario = new Comentario();
                comentario.setUsuario(resultado.getString(1));
                comentario.setFecha(resultado.getString(4));
                comentario.setComentario(resultado.getString(2));
                comentario.setTitulo(resultado.getString(3));
                
                            
                lista.add(comentario);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    
    
   //Verifica el tipo de consulta para la base de datos
    public void verificarTipoReporteAdministrador(int tipo, String fecha1, String fecha2){
        
        switch(tipo){
            case 2:
                //INtervalo de tiempo
                consulta1 = "SELECT r.titulo, r.autor, (SELECT count(id_comentario) from comentarios WHERE titulo_revista=r.titulo AND TIMESTAMPDIFF(DAY,'"+fecha1+"',fecha)>=0 AND TIMESTAMPDIFF(DAY,fecha,'"+fecha2+"')>=0) cantidad FROM revista r ORDER BY cantidad DESC;";
                consulta2 = "SELECT c.opinion, c.titulo_revista FROM (SELECT r.titulo, (SELECT count(id_comentario) from comentarios WHERE titulo_revista=r.titulo) cantidad FROM revista r ORDER BY cantidad DESC) h join comentarios c on (c.titulo_revista=h.titulo AND TIMESTAMPDIFF(DAY,'"+fecha1+"',c.fecha)>=0 AND TIMESTAMPDIFF(DAY,c.fecha,'"+fecha2+"')>=0) ORDER BY h.cantidad desc;";
                break;

                default:
                consulta1 = "SELECT r.titulo, r.autor, (SELECT count(id_comentario) from comentarios WHERE titulo_revista=r.titulo) cantidad FROM revista r ORDER BY cantidad DESC;";
                consulta2 = "SELECT c.opinion, c.titulo_revista FROM (SELECT r.titulo, (SELECT count(id_comentario) from comentarios WHERE titulo_revista=r.titulo) cantidad FROM revista r ORDER BY cantidad DESC) h join comentarios c on (c.titulo_revista=h.titulo) ORDER BY h.cantidad desc;";
         }
        
    }
    //listas la cantidad de comentario y los retorna
    public List listarCantidadComentarios(){
        List<Comentario> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consulta1);
            while (resultado.next()) {                
             
                Comentario comentario = new Comentario();
                comentario.setUsuario(resultado.getString(2));
                comentario.setTitulo(resultado.getString(1));
                comentario.setCantidad(resultado.getInt(3));
                
                            
                lista.add(comentario);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    //lista los comentarios
    public List listarCincoComentarios(){
        List<Comentario> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consulta2);
            while (resultado.next()) {                
             
                Comentario comentario = new Comentario();
                comentario.setComentario(resultado.getString(1));
                comentario.setTitulo(resultado.getString(2));
                
                            
                lista.add(comentario);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    
}
