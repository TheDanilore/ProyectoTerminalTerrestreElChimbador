/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author ASUS
 */
public class UsuarioModelo {
    private int id_usuarios;
    private String nombres;
    private String usuario;
    private String contra_usuarios;
    private int cargo;
    //private String last_session;
    private int estado;

    public UsuarioModelo() {
    }

    public UsuarioModelo(int id_usuarios, String nombres, String usuario, String contra_usuarios, int cargo, int estado) {
        this.id_usuarios = id_usuarios;
        this.nombres = nombres;
        this.usuario = usuario;
        this.contra_usuarios = contra_usuarios;
        this.cargo = cargo;
        this.estado = estado;
    }

    public int getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(int id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra_usuarios() {
        return contra_usuarios;
    }

    public void setContra_usuarios(String contra_usuarios) {
        this.contra_usuarios = contra_usuarios;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    
    
}
