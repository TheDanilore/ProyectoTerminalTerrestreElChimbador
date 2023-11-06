/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class VehiculoModelo {
    private int id_vehiculo;
    private String placa_vehiculo;
    private TipoVehiculo tipo_vehiculo;
    private EstadoUsuario estado;

    public VehiculoModelo() {
    }

    public VehiculoModelo(int id_vehiculo, String placa_vehiculo, TipoVehiculo tipo_vehiculo, EstadoUsuario estado) {
        this.id_vehiculo = id_vehiculo;
        this.placa_vehiculo = placa_vehiculo;
        this.tipo_vehiculo = tipo_vehiculo;
        this.estado = estado;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public TipoVehiculo getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(TipoVehiculo tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }
    
    

}
