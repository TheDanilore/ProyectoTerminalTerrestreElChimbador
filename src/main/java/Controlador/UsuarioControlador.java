/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.UsuarioDAO;
import Modelo.UsuarioModelo;
import Vista.LoginUser;

/**
 *
 * @author ASUS
 */
public class UsuarioControlador {

    private UsuarioDAO dao;
    private UsuarioModelo usuarioModelo;

    public UsuarioControlador(LoginUser view, UsuarioDAO dao) {
        this.dao = dao;
    }

    public boolean login(String username, String password) {
        UsuarioModelo usuarioModelo = (UsuarioModelo) dao.log(username, password);

        if (usuarioModelo != null) {
            this.usuarioModelo = usuarioModelo;
           
            return true; // Devuelve true si la autenticación es exitosa
        } else {
            // Autenticación fallida
            return false; // Devuelve false si la autenticación falla
        }
    }
    public UsuarioModelo getUsuario() {
        return usuarioModelo;
    }
}
