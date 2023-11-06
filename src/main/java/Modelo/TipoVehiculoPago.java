/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class TipoVehiculoPago {
    private int id_tipo_vehiculo_pago;
    private String descripcion;

    public TipoVehiculoPago() {
    }

    public TipoVehiculoPago(int id_tipo_vehiculo_pago, String descripcion) {
        this.id_tipo_vehiculo_pago = id_tipo_vehiculo_pago;
        this.descripcion = descripcion;
    }

    public int getId_tipo_vehiculo_pago() {
        return id_tipo_vehiculo_pago;
    }

    public void setId_tipo_vehiculo_pago(int id_tipo_vehiculo_pago) {
        this.id_tipo_vehiculo_pago = id_tipo_vehiculo_pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
}
