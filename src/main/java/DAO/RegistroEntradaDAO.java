/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.RegistroEntrada;
import java.util.List;

/**
 *
 * @author Danilore
 */
public interface RegistroEntradaDAO extends CrudDeleteDAO<RegistroEntrada,Integer>  {
    public List<RegistroEntrada> getByPlaca(String placa) throws DAOException;
}
