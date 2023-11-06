/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class EmpresasModelo {
    private int id_empresa;
    private long ruc;
    private String razon_social;
    private String nombre_comercial;
    private EstadoEmpresa estado;

    public EmpresasModelo() {
    }

    public EmpresasModelo(int id_empresa, long ruc, String razon_social, String nombre_comercial, EstadoEmpresa estado) {
        this.id_empresa = id_empresa;
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.estado = estado;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public long getRuc() {
        return ruc;
    }

    public void setRuc(long ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public EstadoEmpresa getEstado() {
        return estado;
    }

    public void setEstado(EstadoEmpresa estado) {
        this.estado = estado;
    }

}
