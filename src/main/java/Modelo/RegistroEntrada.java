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
    private Vehiculo vehiculo;
    private Conductor conductor;
    private String destino;
    private Usuario usuario;
    private Pago pago;

    public RegistroEntrada() {
    }

    public RegistroEntrada(int id_registro_entrada, String fecha_hora_entrada, Vehiculo vehiculo, Conductor conductor, String destino, Usuario usuario, Pago pago) {
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

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    
    
}
