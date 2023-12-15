/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class VehiculoEnTerminal {
    private int id;
    private String placa;
    private int id_estado;

    public VehiculoEnTerminal(int id, String placa, int id_estado) {
        this.id = id;
        this.placa = placa;
        this.id_estado = id_estado;
    }

    public VehiculoEnTerminal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }
    
    
    
}
