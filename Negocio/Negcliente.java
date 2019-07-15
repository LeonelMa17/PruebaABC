/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Datos.DatosCliente;
import Entidades.cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonel
 */
public class Negcliente {
    DatosCliente datosc = new DatosCliente();
    
    public boolean AgregarCliente(cliente client) {
        try {
            datosc.InsertarClientes(client);
            return true;
        } catch (Exception e) {
            Logger.getLogger(Negcliente.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public ArrayList<cliente> ConsultarClientes() {
        ArrayList<cliente> clientes = new ArrayList<cliente>();
        try {
            clientes = datosc.ConsultarClientes();
           return clientes;
        } catch (Exception e) {
            Logger.getLogger(Negcliente.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }  
    }
    
    public ArrayList<cliente> Buscar(String valor) {
       ArrayList<cliente> clientes = new ArrayList<cliente>();
        try {
            clientes = datosc.BuscarCliente(valor);
           return clientes;
        } catch (Exception e) {
            Logger.getLogger(Negcliente.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }   
    }
    
    public boolean EliminarCliente(int id) {
        try {
            datosc.EliminarUsuario(id);
            return true;
        } catch (Exception e) {
            Logger.getLogger(Negcliente.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    public boolean ActualizarCliente(cliente client) {
        try {
            datosc.Actualizar(client);
            return true;
        } catch (Exception e) {
            Logger.getLogger(Negcliente.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    

    
}
