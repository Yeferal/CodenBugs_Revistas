
package com.revista;

import java.sql.SQLException;


public class Main {
    
    public static void main(String[] args) throws SQLException {
        Conexion con = new Conexion();
        con.conectar();
        con.verificarPassword("Yefer", "123456");
        con.desconectar();
    }
}
