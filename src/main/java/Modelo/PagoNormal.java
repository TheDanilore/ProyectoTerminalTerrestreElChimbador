/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class PagoNormal extends Pago{
    private int id_pago_normal;
    private String lugar_destino;

    public PagoNormal() {
    }

    public PagoNormal(int id_pago_normal, String lugar_destino) {
        this.id_pago_normal = id_pago_normal;
        this.lugar_destino = lugar_destino;
    }

    public int getId_pago_normal() {
        return id_pago_normal;
    }

    public void setId_pago_normal(int id_pago_normal) {
        this.id_pago_normal = id_pago_normal;
    }

    public String getLugar_destino() {
        return lugar_destino;
    }

    public void setLugar_destino(String lugar_destino) {
        this.lugar_destino = lugar_destino;
    }
    
    
}
