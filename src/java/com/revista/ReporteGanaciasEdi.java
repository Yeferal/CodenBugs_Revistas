package com.revista;




import com.revista.Conexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReporteGanaciasEdi extends Conexion{
    
    private String consultaQuery;
    private String consultaQuery1,consultaQuery2;
    private String campos = "s.nombre_suscriptor,s.titulo_revista,s.fecha_suscripcion,s.porcentaje,s.pago, (s.pago-s.pago*s.porcentaje) ganacia ";
    
     public void verificarTipoReporte(int tipo, String titulo, String fecha1, String fecha2, String autor){
        
        switch(tipo){
            case 1:
                //por revista
                consultaQuery = SELECT+campos+FROM+"suscripciones s join revista r on (s.id_revista=r.id_revista AND s.titulo_revista='"+titulo+"') WHERE r.autor='"+autor+"' ORDER BY s.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo, r.autor,(SELECT count(id_suscripcion) from suscripciones WHERE titulo_revista=r.titulo) suscripciones "+FROM+"revista r WHERE r.autor='"+autor+"' AND r.titulo='"+titulo+"' ORDER BY suscripciones DESC;";
                consultaQuery2 = "SELECT sum(ganancias.ganacia) FROM (SELECT (s.pago-s.pago*s.porcentaje) ganacia FROM suscripciones s join revista r on (s.id_revista=r.id_revista AND s.titulo_revista='"+titulo+"') WHERE r.autor='"+autor+"') ganancias;";
                break;
            case 2:
                //INtervalo de tiempo
                consultaQuery = SELECT+campos+FROM+"suscripciones s join revista r on (s.id_revista=r.id_revista) WHERE r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',s.fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,s.fecha_suscripcion,'"+fecha2+"')>=0 ORDER BY s.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo, r.autor,(SELECT count(id_suscripcion) from suscripciones WHERE titulo_revista=r.titulo AND TIMESTAMPDIFF(DAY,'"+fecha1+"',fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,fecha_suscripcion,'"+fecha2+"')>=0) suscripciones "+FROM+"revista r WHERE r.autor='"+autor+"' ORDER BY suscripciones DESC;";
                consultaQuery2 = "SELECT sum(ganancias.ganacia) FROM (SELECT (s.pago-s.pago*s.porcentaje) ganacia FROM suscripciones s join revista r on (s.id_revista=r.id_revista) WHERE r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',s.fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,s.fecha_suscripcion,'"+fecha2+"')>=0) ganancias;";
                break;
            case 3:
                //ambos
                consultaQuery = SELECT+campos+FROM+"suscripciones s join revista r on (s.id_revista=r.id_revista AND s.titulo_revista='"+titulo+"') WHERE r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',s.fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,s.fecha_suscripcion,'"+fecha2+"')>=0 ORDER BY s.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo, r.autor,(SELECT count(id_suscripcion) from suscripciones WHERE titulo_revista=r.titulo  AND TIMESTAMPDIFF(DAY,'"+fecha1+"',fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,fecha_suscripcion,'"+fecha2+"')>=0) suscripciones FROM revista r WHERE r.autor='"+autor+"' AND r.titulo='"+titulo+"' ORDER BY suscripciones DESC;";
                consultaQuery2 = "SELECT sum(ganancias.ganacia) FROM (SELECT (s.pago-s.pago*s.porcentaje) ganacia FROM suscripciones s join revista r on (s.id_revista=r.id_revista AND s.titulo_revista='"+titulo+"') WHERE r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',s.fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,s.fecha_suscripcion,'"+fecha2+"')>=0) ganancias;";
                break;
                default:
                consultaQuery = SELECT+campos+FROM+"suscripciones s join revista r on (s.id_revista=r.id_revista) WHERE r.autor='"+autor+"' ORDER BY s.titulo_revista  ASC;";
                consultaQuery1 = SELECT+"r.titulo, r.autor,(SELECT count(id_suscripcion) from suscripciones WHERE titulo_revista=r.titulo) suscripciones FROM revista r WHERE r.autor='"+autor+"' ORDER BY suscripciones DESC;";
                consultaQuery2 = "SELECT sum(ganancias.ganacia) FROM (SELECT (s.pago-s.pago*s.porcentaje) ganacia FROM suscripciones s join revista r on (s.id_revista=r.id_revista) WHERE r.autor='"+autor+"') ganancias;";
                    
        }
        System.out.println(consultaQuery);
        
    }
    
     public List listarSuscripciones(){
        List<Suscripcion> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consultaQuery);
            while (resultado.next()) {                
             
                Suscripcion suscripcion = new Suscripcion();
                suscripcion.setnombreSuscriptor(resultado.getString(1));
                suscripcion.setCosto(resultado.getDouble(5));
                suscripcion.settituloRevista(resultado.getString(2));
                suscripcion.setfechaSuscripcion(resultado.getString(3));
                suscripcion.setGanancia(resultado.getDouble(6));
                suscripcion.setPorcentaje(resultado.getDouble(4));
                
                lista.add(suscripcion);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public List listarCantidadSuscripciones(){
        List<Suscripcion> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consultaQuery1);
            while (resultado.next()) {                
             
                Suscripcion suscripcion = new Suscripcion();
                suscripcion.settituloRevista(resultado.getString(1));
                suscripcion.setidSuscripcion(resultado.getInt(3));
                                            
                lista.add(suscripcion);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
    
    public double getCantidadGanancia(){
        double cantidad = 0;
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consultaQuery2);
            while (resultado.next()) {                
             
                cantidad= resultado.getDouble(1);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        return cantidad;
    }
}
