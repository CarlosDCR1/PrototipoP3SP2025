/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

/**
 *
 * @author Diana
 */
public class Clientes {

    public Clientes() {
    }
    int idClientes;
    String nombre;
    String Nit;

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + idClientes + ", nombre_cliente=" + nombre +  ", Nit=" + Nit + '}';
    }

    public int getId_cliente() {
        return idClientes;
    }

    public void setId_cliente(int id_cliente) {
        this.idClientes = idClientes;
    }

    public String getNombre_cliente() {
        return nombre;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre = nombre;
    }

    

    public String getDpi_cliente() {
        return Nit;
    }

    public void setDpi_cliente(String dpi_cliente) {
        this.Nit = Nit;
    }

    public Clientes(int idClientes, String nombre,  String Nit) {
        this.idClientes = idClientes;
        this.nombre = nombre;
        this.Nit = Nit;
    }

            
            
}
