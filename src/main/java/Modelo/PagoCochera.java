/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class PagoCochera extends Pago{
    private int id_pago_cochera;
    private int dias_estancia;

    public PagoCochera() {
    }

    public PagoCochera(int id_pago_cochera, int dias_estancia) {
        this.id_pago_cochera = id_pago_cochera;
        this.dias_estancia = dias_estancia;
    }

    public int getId_pago_cochera() {
        return id_pago_cochera;
    }

    public void setId_pago_cochera(int id_pago_cochera) {
        this.id_pago_cochera = id_pago_cochera;
    }

    public int getDias_estancia() {
        return dias_estancia;
    }

    public void setDias_estancia(int dias_estancia) {
        this.dias_estancia = dias_estancia;
    }
    
    
}
