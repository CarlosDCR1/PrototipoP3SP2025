/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.seguridad;

import Controlador.seguridad.Aplicacion;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class AplicacionDAO {

    private static final String SQL_SELECT = "SELECT idClientes, Nombre, Nit FROM clientes";
    private static final String SQL_INSERT = "INSERT INTO clientes(Nombre, Nit) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET  Nombre=?, Nit=? WHERE idClientes = ?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE idClientes=?";
    private static final String SQL_QUERY = "SELECT idClientes, Nombre, Nit FROM clientes WHERE idClientes = ?";

    public List<Aplicacion> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Aplicacion aplicacion = null;
        List<Aplicacion> list_aplicaciones = new ArrayList<Aplicacion>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_aplicacion = rs.getInt("idClientes");
                String nombre_aplicacion = rs.getString("Nombre");
                String estatus_aplicacion = rs.getString("Nit");
                
                aplicacion = new Aplicacion();
                aplicacion.setId_aplicacion(id_aplicacion);
                aplicacion.setNombre_aplicacion(nombre_aplicacion);
                aplicacion.setEstatus_aplicacion(estatus_aplicacion);
              
                
                list_aplicaciones.add(aplicacion);
              
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return list_aplicaciones;
    }

    public int insert(Aplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            //stmt.setInt(1, aplicacion.getId_aplicacion());
            stmt.setString(1, aplicacion.getNombre_aplicacion());
            stmt.setString(2, aplicacion.getEstatus_aplicacion());
         


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Aplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, aplicacion.getNombre_aplicacion());
            stmt.setString(2, aplicacion.getEstatus_aplicacion());
            //comodin del where
            stmt.setInt(3,aplicacion.getId_aplicacion());
           

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(Aplicacion aplicacion) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, aplicacion.getId_aplicacion());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public Aplicacion query(Aplicacion aplicacion) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aplicacion> list_aplicacion = new ArrayList<Aplicacion>();
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, aplicacion.getId_aplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
             int id_aplicacion = rs.getInt("idClientes");
                String nombre_aplicacion = rs.getString("Nombre");
                String estatus_aplicacion = rs.getString("Nit");
                
                aplicacion = new Aplicacion();
                aplicacion.setId_aplicacion(id_aplicacion);
                aplicacion.setNombre_aplicacion(nombre_aplicacion);
                aplicacion.setEstatus_aplicacion(estatus_aplicacion);
              
                
               
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return aplicacion;
    }
            
}