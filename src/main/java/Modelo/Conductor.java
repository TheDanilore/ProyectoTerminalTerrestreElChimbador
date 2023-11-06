/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class Conductor {
    private int id_conductor;
    private String primer_nombre;
    private String segundo_nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private TipoDocumentoIdentidad tipo_documento_identidad;
    private long numero_documento;
    private int telefono;
    private String direccion;
    private EmpresasModelo empresa;
    private EstadoConductor estado;

    public Conductor() {
    }

    public Conductor(int id_conductor, String primer_nombre, String segundo_nombre, String apellido_paterno, String apellido_materno, TipoDocumentoIdentidad tipo_documento_identidad, long numero_documento, int telefono, String direccion, EmpresasModelo empresa, EstadoConductor estado) {
        this.id_conductor = id_conductor;
        this.primer_nombre = primer_nombre;
        this.segundo_nombre = segundo_nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.tipo_documento_identidad = tipo_documento_identidad;
        this.numero_documento = numero_documento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.empresa = empresa;
        this.estado = estado;
    }

    public int getId_conductor() {
        return id_conductor;
    }

    public void setId_conductor(int id_conductor) {
        this.id_conductor = id_conductor;
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public TipoDocumentoIdentidad getTipo_documento_identidad() {
        return tipo_documento_identidad;
    }

    public void setTipo_documento_identidad(TipoDocumentoIdentidad tipo_documento_identidad) {
        this.tipo_documento_identidad = tipo_documento_identidad;
    }

    public long getNumero_documento() {
        return numero_documento;
    }

    public void setNumero_documento(long numero_documento) {
        this.numero_documento = numero_documento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EmpresasModelo getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresasModelo empresa) {
        this.empresa = empresa;
    }

    public EstadoConductor getEstado() {
        return estado;
    }

    public void setEstado(EstadoConductor estado) {
        this.estado = estado;
    }
    
    
}
