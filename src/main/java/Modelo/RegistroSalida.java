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
    private String fecha_hora_salida;
    private RegistroEntrada registro_entrada;
    private UsuarioModelo usuario;
    private PagoPorHora pago_por_hora;

    public RegistroSalida() {
    }

    public RegistroSalida(int id_registro_salida, String fecha_hora_salida, RegistroEntrada registro_entrada, UsuarioModelo usuario, PagoPorHora pago_por_hora) {
        this.id_registro_salida = id_registro_salida;
        this.fecha_hora_salida = fecha_hora_salida;
        this.registro_entrada = registro_entrada;
        this.usuario = usuario;
        this.pago_por_hora = pago_por_hora;
    }

    public int getId_registro_salida() {
        return id_registro_salida;
    }

    public void setId_registro_salida(int id_registro_salida) {
        this.id_registro_salida = id_registro_salida;
    }

    public String getFecha_hora_salida() {
        return fecha_hora_salida;
    }

    public void setFecha_hora_salida(String fecha_hora_salida) {
        this.fecha_hora_salida = fecha_hora_salida;
    }

    public RegistroEntrada getRegistro_entrada() {
        return registro_entrada;
    }

    public void setRegistro_entrada(RegistroEntrada registro_entrada) {
        this.registro_entrada = registro_entrada;
    }

    public UsuarioModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }

    public PagoPorHora getPago_por_hora() {
        return pago_por_hora;
    }

    public void setPago_por_hora(PagoPorHora pago_por_hora) {
        this.pago_por_hora = pago_por_hora;
    }
    
    
    
}
