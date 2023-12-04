/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class RegistroEntrada {
    private int id_registro_entrada;
    private String fecha_hora_entrada;
    private String vehiculo;
    private String conductor;
    private String destino;
    private String usuario;
    private String pago;

    public RegistroEntrada() {
    }

    public RegistroEntrada(int id_registro_entrada, String fecha_hora_entrada, String vehiculo, String conductor, String destino, String usuario, String pago) {
        this.id_registro_entrada = id_registro_entrada;
        this.fecha_hora_entrada = fecha_hora_entrada;
        this.vehiculo = vehiculo;
        this.conductor = conductor;
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

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
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

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

   
    
    
}
