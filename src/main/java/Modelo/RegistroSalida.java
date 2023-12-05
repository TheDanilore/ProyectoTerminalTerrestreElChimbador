/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class RegistroSalida {
    private int id_registro_salida;
    private int registro_entrada;
    private double pago_por_hora;
    private String usuario;
    private String fecha_hora_salida;

    public RegistroSalida() {
    }

    public RegistroSalida(int id_registro_salida, int registro_entrada, double pago_por_hora, String usuario, String fecha_hora_salida) {
        this.id_registro_salida = id_registro_salida;
        this.registro_entrada = registro_entrada;
        this.pago_por_hora = pago_por_hora;
        this.usuario = usuario;
        this.fecha_hora_salida = fecha_hora_salida;
    }

    public int getId_registro_salida() {
        return id_registro_salida;
    }

    public void setId_registro_salida(int id_registro_salida) {
        this.id_registro_salida = id_registro_salida;
    }

    public int getRegistro_entrada() {
        return registro_entrada;
    }

    public void setRegistro_entrada(int registro_entrada) {
        this.registro_entrada = registro_entrada;
    }

    public double getPago_por_hora() {
        return pago_por_hora;
    }

    public void setPago_por_hora(double pago_por_hora) {
        this.pago_por_hora = pago_por_hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha_hora_salida() {
        return fecha_hora_salida;
    }

    public void setFecha_hora_salida(String fecha_hora_salida) {
        this.fecha_hora_salida = fecha_hora_salida;
    }
    
    

    
}
