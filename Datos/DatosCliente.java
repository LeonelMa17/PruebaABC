/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Entidades.cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Leonel
 */
public class DatosCliente {
    Conectar c = new Conectar();
    
    public boolean InsertarClientes(cliente client) throws SQLException {
        Statement st;
        Connection con;
        try {
            String sql = "INSERT INTO clientes VALUES(null, " + "'" + client.getNombre()
                        + "'" + "," + "'" + client.getApellidos() + "'" + "," + 
                        "'" + client.getDireccion() + "'" + "," +
                        client.getTelefono() + ")";
        con = c.AbreConexión();
        st = con.createStatement();
        st.executeUpdate(sql);
        c.cierraBD(con);
        return true;
        } catch (Exception e) {
            Logger.getLogger(DatosCliente.class.getName()).log(Level.SEVERE, null, e);    
            return false;
        }
    }
    
    public boolean Actualizar(cliente client) throws SQLException {
        Statement st;
        Connection con;
        try {
            String sql = "UPDATE clientes set nombre = '" + client.getNombre() + 
                    "', apellidos = '" + client.getApellidos() + "', direccion = '" +
                    client.getDireccion() + "', telefono = '" + client.getTelefono() + "' "
                    + "WHERE id_cliente = " + client.getId_cliente();
        con = c.AbreConexión();
        st = con.createStatement();
        st.executeUpdate(sql);
        c.cierraBD(con);
        return true;
        } catch (Exception e) {
            Logger.getLogger(DatosCliente.class.getName()).log(Level.SEVERE, null, e);    
            return false;
        }   
    }
    
    public ArrayList<cliente> ConsultarClientes() throws SQLException {
        ArrayList<cliente> clientes = new ArrayList<cliente>();
        Statement st;
        ResultSet rs;
        Connection con;
        cliente user = null;
        String sql = "SELECT * FROM clientes";
        con = c.AbreConexión();
        st = con.createStatement();
        rs = st.executeQuery(sql);
        
        while(rs.next()){
           user = new cliente();
           user.setId_cliente(rs.getInt("id_cliente"));
           user.setNombre(rs.getString("nombre"));
           user.setApellidos(rs.getString("apellidos"));
           user.setDireccion(rs.getString("direccion"));
           user.setTelefono(rs.getString("telefono"));
           clientes.add(user);
        }
        c.cierraBD(con);
        return clientes; 
    }
    
    public ArrayList<cliente> BuscarCliente(String valor) throws SQLException {
        ArrayList<cliente> clientes = new ArrayList<cliente>();
        Statement st;
        ResultSet rs;
        Connection con;
        cliente user = null;
        String sql="SELECT * FROM clientes WHERE CONCAT(nombre,'',apellidos) like '%"+valor+"%'";
        con = c.AbreConexión();
        st = con.createStatement();
        rs = st.executeQuery(sql);
        
        while(rs.next()){
           user = new cliente();
           user.setId_cliente(rs.getInt("id_cliente"));
           user.setNombre(rs.getString("nombre"));
           user.setApellidos(rs.getString("apellidos"));
           user.setDireccion(rs.getString("direccion"));
           user.setTelefono(rs.getString("telefono"));
           clientes.add(user);
        }
        c.cierraBD(con);
        return clientes; 
    }
    
    public boolean EliminarUsuario(int id_cliente) throws SQLException {
        Statement st;
        Connection con;
        try {
            String sql = "DELETE FROM clientes WHERE id_cliente = " + id_cliente;
            con = c.AbreConexión();
            st = con.createStatement();
            st.executeUpdate(sql);
            c.cierraBD(con);
            return true;
        } catch (Exception e) {
            Logger.getLogger(DatosCliente.class.getName()).log(Level.SEVERE, null, e);    
            return false;
        }
    }
    
    
    
    
}
