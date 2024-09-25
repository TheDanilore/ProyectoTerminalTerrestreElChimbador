/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Danilore
 */
public class TipoDocumentoIdentidad {
    private String id_tipo_documento_identidad;
    private String descripcion;
    private String abreviatura;

    public TipoDocumentoIdentidad() {
    }

    public TipoDocumentoIdentidad(String id_tipo_documento_identidad, String descripcion, String abreviatura) {
        this.id_tipo_documento_identidad = id_tipo_documento_identidad;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
    }

    public String getId_tipo_documento_identidad() {
        return id_tipo_documento_identidad;
    }

    public void setId_tipo_documento_identidad(String id_tipo_documento_identidad) {
        this.id_tipo_documento_identidad = id_tipo_documento_identidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    
    
}
