/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Distrito;
import java.util.List;

/**
 *
 * @author Danilore
 */
public interface DistritoDAO extends CrudDAO<Distrito, String>{
    public List<Distrito> getByProvinciaDistrito(String id) throws DAOException;
}
