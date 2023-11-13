/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author Danilore
 * @param <T>
 * @param <K>
 */
public interface CrudDeleteDAO<T,K> {
    public void add(T t) throws DAOException;
    public void update(T t) throws DAOException;
    public void delete(K id) throws DAOException;
    public List<T> listAll() throws DAOException;
    public T getById(K id) throws DAOException;
}
