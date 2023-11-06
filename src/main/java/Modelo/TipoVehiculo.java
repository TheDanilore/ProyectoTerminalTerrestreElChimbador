/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class TipoVehiculo {
    private int id_tipo_vehiculo;
    private String descripcion;

    public TipoVehiculo() {
    }

    public TipoVehiculo(int id_tipo_vehiculo, String descripcion) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
        this.descripcion = descripcion;
    }

    public int getId_tipo_vehiculo() {
        return id_tipo_vehiculo;
    }

    public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
