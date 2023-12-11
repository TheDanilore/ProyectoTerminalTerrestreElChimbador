/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Cargo;

/**
 *
 * @author Danilore
 */
public interface CargoDAO extends CrudDAO<Cargo,Integer>{
    public Cargo obtenerCargoPorDescripcion(String descripcion);
}
