/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.RegistroEntradaConPaga;
import java.util.List;

/**
 *
 * @author Danilore
 */
public interface RegistroEntradaConPagaDAO extends CrudDeleteDAO<RegistroEntradaConPaga,Integer>  {
    public List<RegistroEntradaConPaga> getByPlaca(String placa) throws DAOException;
}
