
package com.revista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    Connection conect = null;
    PreparedStatement insetar;
    Statement stmt;
    ResultSet resultado;
    private String user = "usuario";
    private String password = "123456";
    private String servidor = "jdbc:mysql://localhost:3306/codenbugs_revistas";
    
    
    public Conexion(){
        try {
            conect = DriverManager.getConnection(servidor, user, password);
            System.out.println("Se conecto XD: "+conect.getCatalog());
        } catch (SQLException e) {
            System.out.println("No se COnectro");
            e.printStackTrace();
        }
    }
    public String conectar(){
        try {
            //conect = DriverManager.getConnection(servidor, user, password);
            return "Se conecto XD: "+conect.getCatalog();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Se conecto XD: ";
    }
    
    public void nuevoUsuario(String nombre, String pass, String tipo){
            //conect = DriverManager.getConnection(servidor, user, password);
            try {
                System.out.println("entro");
                if(tipo.equalsIgnoreCase("Editor")){
                    insetar = conect.prepareStatement("INSERT INTO editor (nombre,password) VALUES ("+nombre+","+pass+");");
                }else{
                    insetar = conect.prepareStatement("INSERT INTO suscriptor (nombre,password) VALUES ("+nombre+","+pass+");");
        
                }
                insetar.executeUpdate();
                } catch (SQLException ex) {
                    System.out.println("Fallo");
                    ex.printStackTrace();
            }
        
    }
    
}
