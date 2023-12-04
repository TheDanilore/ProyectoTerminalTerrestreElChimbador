/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import Modelo.Empresas;

/**
 *
 * @author Danilore
 */
public interface EmpresasDAO extends CrudDAO<Empresas,Integer>{
    public Empresas getByRucEmpresa(Long ruc) throws DAOException;
}
