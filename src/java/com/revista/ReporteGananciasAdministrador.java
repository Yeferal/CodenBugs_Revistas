
package com.revista;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReporteGananciasAdministrador extends Conexion{
    
    private String consulta1, consulta2, consulta3;
    
    //Verifica el tipo de consulta para la base de datos
    public void verificarTipo(int tipo, String titulo, String fecha1, String fecha2){
        
        switch(tipo){
            case 1:
                //por revista
                consulta1 = "";
                consulta2 = "";
                consulta3 = "";
                break;
            case 2:
                //INtervalo de tiempo
                consulta1 = "";
                consulta2 = "";
                consulta3 = "";
                break;
                default:
                consulta1 = "SELECT r.titulo, s.nombre_suscriptor, s.pago, (s.pago*s.porcentaje-s.costo), s.fecha_suscripcion FROM revista r join suscripciones s on (r.titulo=s.titulo_revista) order by r.titulo desc;";
                consulta2 = "SELECT r.titulo,((r.costo_por_dia)*TIMESTAMPDIFF(DAY,r.fecha,now())) costo, (Select sum(pago) from suscripciones where titulo_revista=r.titulo) ingreso, (Select sum(pago*porcentaje)-((r.costo_por_dia)*TIMESTAMPDIFF(DAY,r.fecha,now())) from suscripciones where titulo_revista=r.titulo) ganancia FROM revista r ORDER BY ganancia desc;";
                consulta3 = "SELECT sum(total.costo) costo,sum(total.ingreso) ingreso, sum(total.ganancia) ganancia FROM ((SELECT ((r.costo_por_dia)*TIMESTAMPDIFF(DAY,r.fecha,now())) costo, (Select sum(pago) from suscripciones where titulo_revista=r.titulo) ingreso, (Select sum(pago*porcentaje)-((r.costo_por_dia)*TIMESTAMPDIFF(DAY,r.fecha,now())) from suscripciones where titulo_revista=r.titulo) ganancia FROM revista r ORDER BY ganancia desc)) total;";
                    
        }
    }
    
    //lista ls suscripciones y las retorna
    public List listarSuscripcion(){
        List<Ganancia> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consulta1);
            while (resultado.next()) {                
             
                Ganancia ganancia = new Ganancia();
                ganancia.setTitulo(resultado.getString(1));
                ganancia.setSuscriptor(resultado.getString(2));
                ganancia.setPago(resultado.getDouble(3));
                ganancia.setGanancia(resultado.getDouble(4));
                ganancia.setfecha(resultado.getString(5));
                                            
                lista.add(ganancia);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    //lisra los ingresos y los retorna
    public List listarIngresos(){
        List<Ganancia> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consulta2);
            while (resultado.next()) {                
             
                Ganancia ganancia = new Ganancia();
                ganancia.setTitulo(resultado.getString(1));
                ganancia.setCosto(resultado.getDouble(2));
                ganancia.setIngreso(resultado.getDouble(3));
                ganancia.setGanancia(resultado.getDouble(4));
                                                            
                lista.add(ganancia);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    //lista los totales y los retorna
    public List listarTotal(){
        List<Ganancia> lista = new ArrayList<>();
        
        conectar();
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery(consulta3);
            while (resultado.next()) {                
             
                Ganancia ganancia = new Ganancia();
                ganancia.setCosto(resultado.getDouble(1));
                ganancia.setIngreso(resultado.getDouble(2));
                ganancia.setGanancia(resultado.getDouble(3));
                                            
                lista.add(ganancia);
                
            }
            desconectar();
        } catch (SQLException e) {
        }
        
        return lista;
    }
    
    
    
}
