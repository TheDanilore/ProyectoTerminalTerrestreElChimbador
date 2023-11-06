/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class PagoPorHora {
    private int id_pago_por_hora;
    private int horas_estadia;
    private double tarifa_por_hora;
    private MetodoPago metodo_pago;
    private double monto;

    public PagoPorHora() {
    }

    public PagoPorHora(int id_pago_por_hora, int horas_estadia, double tarifa_por_hora, MetodoPago metodo_pago, double monto) {
        this.id_pago_por_hora = id_pago_por_hora;
        this.horas_estadia = horas_estadia;
        this.tarifa_por_hora = tarifa_por_hora;
        this.metodo_pago = metodo_pago;
        this.monto = monto;
    }

    public int getId_pago_por_hora() {
        return id_pago_por_hora;
    }

    public void setId_pago_por_hora(int id_pago_por_hora) {
        this.id_pago_por_hora = id_pago_por_hora;
    }

    public int getHoras_estadia() {
        return horas_estadia;
    }

    public void setHoras_estadia(int horas_estadia) {
        this.horas_estadia = horas_estadia;
    }

    public double getTarifa_por_hora() {
        return tarifa_por_hora;
    }

    public void setTarifa_por_hora(double tarifa_por_hora) {
        this.tarifa_por_hora = tarifa_por_hora;
    }

    public MetodoPago getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(MetodoPago metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
}
