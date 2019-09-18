
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
            if(conect != null && !conect.isClosed()){
            conect.close();
            System.out.println("Se cierrar conexion");
            }
        } catch (SQLException ex) {
            System.out.println("Fallo al cerrar conexion");
        }
    }
    
    public void insertarUsuario(String nombre, String pass, String tipo){
            try {
                conect.setAutoCommit(false);
                insetar = conect.prepareStatement("INSERT INTO usuario VALUES (?,?,?)");
                insetar.setString(2, nombre);
                insetar.setString(3, pass);
                insetar.setString(4, tipo);
                insetar.executeUpdate();
                conect.commit();

                PreparedStatement insetarPerfil = conect.prepareStatement("INSERT INTO perfil VALUES (?,?,?)");
                insetarPerfil.setString(1, mostrarUltimoUsuarioId());
                insetarPerfil.setString(2, nombre);
                insetarPerfil.setString(3, tipo);
                insetarPerfil.executeUpdate();
                conect.commit();
                conect.setAutoCommit(true);
                
                } catch (SQLException ex) {
                    System.out.println("Fallo");
                    ex.printStackTrace();
            }
        
    }
    
    public boolean verificarPassword(String nombreUsuario,String passwrdUsuario){
        
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT password_usuario FROM usuario WHERE nombre='"+nombreUsuario+"';");
            //resultado.next();
            System.out.println(resultado.next());
            
        } catch (SQLException ex) {
            
        }
        return true;
    }
    
    public boolean  verificarExistenciaUsuario(){
        
        
        return true;
    }
    public String mostrarUltimoUsuarioId(){
        try {
            stmt = conect.createStatement();
            resultado = stmt.executeQuery("SELECT * FROM usuario ORDER by id DESC LIMIT 1;");
            resultado.next();
            return resultado.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "0";
    }
    
}
