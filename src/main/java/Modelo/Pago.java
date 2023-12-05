/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Danilore
 */
public class Pago {
    private int id_pago;
    private long dni_conductor;
    private String conductor;
    private String placa;
    private String tipo_vehiculo;
    private String destino;
    private String fecha_pago;
    private double monto;
    private int id_metodo_pago;

    public Pago() {
    }

    public Pago(int id_pago, long dni_conductor, String conductor, String placa, String tipo_vehiculo, String destino, String fecha_pago, double monto, int id_metodo_pago) {
        this.id_pago = id_pago;
        this.dni_conductor = dni_conductor;
        this.conductor = conductor;
        this.placa = placa;
        this.tipo_vehiculo = tipo_vehiculo;
        this.destino = destino;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
        this.id_metodo_pago = id_metodo_pago;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public long getDni_conductor() {
        return dni_conductor;
    }

    public void setDni_conductor(long dni_conductor) {
        this.dni_conductor = dni_conductor;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_vehiculo() {
        return tipo_vehiculo;
    }

    public void setTipo_vehiculo(String tipo_vehiculo) {
        this.tipo_vehiculo = tipo_vehiculo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getId_metodo_pago() {
        return id_metodo_pago;
    }

    public void setId_metodo_pago(int id_metodo_pago) {
        this.id_metodo_pago = id_metodo_pago;
    }

    
    
    
}
