/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class RegistroEntradaConPaga {
    private int id_registro_entrada;
    private String tipo_documento;
    private long numero_documento;
    private String conductor;
    private String fecha_hora_entrada;
    private String vehiculo;
    private String tipo_vehiculo;
    private String destino;
    private String usuario;
    private double pago;

    public RegistroEntradaConPaga() {
    }

    public RegistroEntradaConPaga(int id_registro_entrada, String tipo_documento, long numero_documento, String conductor, String fecha_hora_entrada, String vehiculo, String tipo_vehiculo, String destino, String usuario, double pago) {
        this.id_registro_entrada = id_registro_entrada;
        this.tipo_documento = tipo_documento;
        this.numero_documento = numero_documento;
        this.conductor = conductor;
        this.fecha_hora_entrada = fecha_hora_entrada;
        this.vehiculo = vehiculo;
        this.tipo_vehiculo = tipo_vehiculo;
        this.destino = destino;
        this.usuario = usuario;
        this.pago = pago;
    }

    public int getId_registro_entrada() {
        return id_registro_entrada;
    }

    public void setId_registro_entrada(int id_registro_entrada) {
        this.id_registro_entrada = id_registro_entrada;
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

    public String getFecha_hora_entrada() {
        return fecha_hora_entrada;
    }

    public void setFecha_hora_entrada(String fecha_hora_entrada) {
        this.fecha_hora_entrada = fecha_hora_entrada;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    
    
}
