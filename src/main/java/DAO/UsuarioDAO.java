/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Usuario;

/**
 *
 * @author Danilore
 */
public interface UsuarioDAO extends CrudDAO<Usuario,Integer>{
    public Usuario log(String username, String password);
}
