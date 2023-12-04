/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class Distrito {
    private String id;
    private String nombre;
    private String provincia_id;
    private String departamento_id;

    public Distrito() {
    }

    public Distrito(String id, String nombre, String provincia_id, String departamento_id) {
        this.id = id;
        this.nombre = nombre;
        this.provincia_id = provincia_id;
        this.departamento_id = departamento_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia_id() {
        return provincia_id;
    }

    public void setProvincia_id(String provincia_id) {
        this.provincia_id = provincia_id;
    }

    public String getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(String departamento_id) {
        this.departamento_id = departamento_id;
    }
    
    
}
