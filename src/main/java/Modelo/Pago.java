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
    private String tipo_documento;
    private long numero_documento;
    private String conductor;
    private String placa;
    private String tipo_vehiculo;
    private String destino;
    private String fecha_pago;
    private double monto;
    private int id_metodo_pago;

    public Pago() {
    }

    public Pago(int id_pago, String tipo_documento, long numero_documento, String conductor, String placa, String tipo_vehiculo, String destino, String fecha_pago, double monto, int id_metodo_pago) {
        this.id_pago = id_pago;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
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

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public long getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(long numero_documento) {
        this.numero_documento = numero_documento;
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
