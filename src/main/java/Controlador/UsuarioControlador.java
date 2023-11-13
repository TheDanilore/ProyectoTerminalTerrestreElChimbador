/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.mysql.MySQLUsuarioDAO;
import Modelo.Usuario;
import Vista.LoginUser;

/**
 *
 * @author ASUS
 */
public class UsuarioControlador {

    private MySQLUsuarioDAO dao;
    private Usuario usuarioModelo;

    public UsuarioControlador(LoginUser view, MySQLUsuarioDAO dao) {
        this.dao = dao;
    }

    public boolean login(String username, String password) {
        Usuario usuario = (Usuario) dao.log(username, password);

        if (usuario != null) {
            this.usuarioModelo = usuario;
           
            return true; // Devuelve true si la autenticación es exitosa
        } else {
            // Autenticación fallida
            return false; // Devuelve false si la autenticación falla
        }
    }
    public Usuario getUsuario() {
        return usuarioModelo;
    }
}
