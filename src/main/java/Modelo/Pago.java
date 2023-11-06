/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class Pago {
    private int id_pago;
    private TipoVehiculoPago tipo_vehiculo_pago;
    private MetodoPago metodo_pago;
    private String fecha_pago;
    private double tarifa;
    private double monto;

    public Pago() {
    }

    public Pago(int id_pago, TipoVehiculoPago tipo_vehiculo_pago, MetodoPago metodo_pago, String fecha_pago, double tarifa, double monto) {
        this.id_pago = id_pago;
        this.tipo_vehiculo_pago = tipo_vehiculo_pago;
        this.metodo_pago = metodo_pago;
        this.fecha_pago = fecha_pago;
        this.tarifa = tarifa;
        this.monto = monto;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public TipoVehiculoPago getTipo_vehiculo_pago() {
        return tipo_vehiculo_pago;
    }

    public void setTipo_vehiculo_pago(TipoVehiculoPago tipo_vehiculo_pago) {
        this.tipo_vehiculo_pago = tipo_vehiculo_pago;
    }

    public MetodoPago getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(MetodoPago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    
}
