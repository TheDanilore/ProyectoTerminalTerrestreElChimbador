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
    private String nombres_usuario;
    private String username;
    private String password;
    private int id_rol;
    private int id_estado;

    public UsuarioModelo() {
    }

    public UsuarioModelo(int id_usuarios, String nombres_usuario, String username, String password, int id_rol, int id_estado) {
        this.id_usuarios = id_usuarios;
        this.nombres_usuario = nombres_usuario;
        this.username = username;
        this.password = password;
        this.id_rol = id_rol;
        this.id_estado = id_estado;
    }

    public int getId_usuarios() {
        return id_usuarios;
    }

    public void setId_usuarios(int id_usuarios) {
        this.id_usuarios = id_usuarios;
    }

    public String getNombres_usuario() {
        return nombres_usuario;
    }

    public void setNombres_usuario(String nombres_usuario) {
        this.nombres_usuario = nombres_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }


    
}
