
package com.revista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReporteComentariosEditor extends Conexion{
    
    
    String consultaQuery;
    String campos = "c.nombre_suscriptor, c.opinion, r.titulo, c.fecha ";
    
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
}
