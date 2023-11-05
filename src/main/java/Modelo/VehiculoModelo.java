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
    private int id_tipo_vehiculo;
    private String ruta_destino;
    private int id_estado;

    public VehiculoModelo() {
    }

    public VehiculoModelo(int id_vehiculo, String placa_vehiculo, int id_tipo_vehiculo, String ruta_destino, int id_estado) {
        this.id_vehiculo = id_vehiculo;
        this.placa_vehiculo = placa_vehiculo;
        this.id_tipo_vehiculo = id_tipo_vehiculo;
        this.ruta_destino = ruta_destino;
        this.id_estado = id_estado;
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

    public int getId_tipo_vehiculo() {
        return id_tipo_vehiculo;
    }

    public void setId_tipo_vehiculo(int id_tipo_vehiculo) {
        this.id_tipo_vehiculo = id_tipo_vehiculo;
    }

    public String getRuta_destino() {
        return ruta_destino;
    }

    public void setRuta_destino(String ruta_destino) {
        this.ruta_destino = ruta_destino;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    
}
