/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;


import Modelo.Provincia;
import java.util.List;

/**
 *
 * @author Danilore
 */
public interface ProvinciaDAO extends CrudDAO<Provincia, String>{
    public List<Provincia> getByDepartamentoProvincia(String id) throws DAOException;
    public Provincia getByNombreId(String id) throws DAOException;
}
