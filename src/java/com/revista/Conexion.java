
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
    
    public Connection conect = null;
    PreparedStatement insetar;
    Statement stmt;
    ResultSet resultado;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "usuario";
    private String password = "123456";
    private String servidor = "jdbc:mysql://localhost:3306/codenbugs_revistas";
    
    
    public Conexion(){
        
    }
    
    public void conectar(){
        try {
            Class.forName(driver);
            conect = DriverManager.getConnection(servidor, user, password);
            System.out.println("Se conecto XD: "+conect.getCatalog());
        } catch (SQLException e) {
            System.out.println("No se Conecto");
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Fallo de class");
        }
    }
    
    public void desconectar(){
        try {
             //&& !conect.isClosed()
            if(conect != null){
            conect.close();
            System.out.println("Se cierrar conexion");
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al cerrar conexion");
        }
    }
    
}
