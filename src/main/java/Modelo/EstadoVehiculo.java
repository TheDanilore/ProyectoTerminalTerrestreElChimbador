/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class EstadoVehiculo {
    private int id_estado_vehiculo;
    private String descripcion;

    public EstadoVehiculo() {
    }

    public EstadoVehiculo(int id_estado_vehiculo, String descripcion) {
        this.id_estado_vehiculo = id_estado_vehiculo;
        this.descripcion = descripcion;
    }

    public int getId_estado_vehiculo() {
        return id_estado_vehiculo;
    }

    public void setId_estado_vehiculo(int id_estado_vehiculo) {
        this.id_estado_vehiculo = id_estado_vehiculo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
