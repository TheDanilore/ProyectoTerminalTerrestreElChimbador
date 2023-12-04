/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class Departamento {
    private int id;
    private String nombre;
    private long poblacion_estimada;

    public Departamento(int id, String nombre, long poblacion_estimada) {
        this.id = id;
        this.nombre = nombre;
        this.poblacion_estimada = poblacion_estimada;
    }

    public Departamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getPoblacion_estimada() {
        return poblacion_estimada;
    }

    public void setPoblacion_estimada(long poblacion_estimada) {
        this.poblacion_estimada = poblacion_estimada;
    }
    
    
}
