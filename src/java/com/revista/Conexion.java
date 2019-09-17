
package com.revista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion {
    
    Connection conect = null;
    PreparedStatement insetar;
    Statement stmt;
    ResultSet resultado;
    private String user = "root";
    private String password = "";
    private String servidor = "jdbc:mysql://localhost:3306/codenbugs_revistas";
    
    
    public Conexion(){
        try {
            conect = DriverManager.getConnection(servidor, user, password);
            System.out.println("Se conecto XD");
        } catch (Exception e) {
            System.out.println("No se COnectro");
            e.printStackTrace();
        }
    }
    public void ConexionU(){
        
    }
    
}
