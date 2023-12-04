/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Conductor;

/**
 *
 * @author Danilore
 */
public interface ConductorDAO extends CrudDAO<Conductor,Integer>{
    public Conductor getByDniConductor(Long dni) throws DAOException;
}
