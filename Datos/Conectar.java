/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonel
 */
public class Conectar {
    private String url = "jdbc:mysql://localhost/clientes";
    private String usuarioBD = "root";
    private String contrasenaBD = "";
    
    
    public Connection AbreConexión() throws SQLException {
        Connection conexion = null;
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            Class.forName(myDriver);
            conexion = DriverManager.getConnection(url, usuarioBD, contrasenaBD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
     public void cierraBD(Connection conexion) throws SQLException{
        conexion.close();
    }
    
}
