
package com.revista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReporteSuscripcionEditor extends Conexion{
    
    
    
    String consultaQuery;
    String campos = "nombre_suscriptor, titulo_revista, fecha_suscripcion,pago,(pago-porcentaje*pago) ganancia ";
    
    public void verificarTipoReporte(int tipo, String titulo, String fecha1, String fecha2, String autor){
        
        switch(tipo){
            case 1:
                //por revista
                consultaQuery = SELECT+campos+FROM+"suscripciones s left join revista r on (r.id_revista=s.id_revista and r.titulo='"+titulo+"') WHERE r.autor='"+autor+"' ORDER by s.fecha_suscripcion ASC;";
                break;
            case 2:
                //INtervalo de tiempo
                consultaQuery = SELECT+campos+FROM+"suscripciones s left join revista r on (r.id_revista=s.id_revista) WHERE r.autor='"+autor+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',c.fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,c.fecha_suscripcion,'"+fecha2+"')>=0 ORDER by s.fecha_suscripcion ASC;";
                break;
            case 3:
                //ambos
                consultaQuery = SELECT+campos+FROM+"suscripciones s left join revista r on (r.id_revista=s.id_revista) WHERE r.autor='"+autor+"' AND r.titulo='"+titulo+"' AND TIMESTAMPDIFF(DAY,'"+fecha1+"',s.fecha_suscripcion)>=0 AND TIMESTAMPDIFF(DAY,c.fecha_suscripcion,'"+fecha2+"')>=0 ORDER by s.fecha_suscripcion ASC;";
                break;
                default:
                    System.out.println("Entroooooooooooooooo");
                consultaQuery = SELECT+campos+FROM+"suscripciones s left join revista r on (r.id_revista=s.id_revista) WHERE r.autor='"+autor+"' ORDER by s.fecha_suscripcion ASC;";
                    System.out.println(consultaQuery);
        }
        
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
                suscripcion.setCosto(resultado.getDouble(4));
                suscripcion.settituloRevista(resultado.getString(2));
                suscripcion.setfechaSuscripcion(resultado.getString(3));
                suscripcion.setGanancia(resultado.getDouble(5));
                            
                lista.add(suscripcion);
            
            }
            desconectar();
        } catch (SQLException e) {
        }
        return lista;
    }
}
