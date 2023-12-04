/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.DistritoDAO;
import Modelo.Distrito;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilore
 */
public class MySQLDistritoDAO implements DistritoDAO{

    private Connection conn;

    public MySQLDistritoDAO(Connection conn) {
        this.conn = conn;
    }

    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public void add(Distrito t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Distrito t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void disable(Distrito t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Distrito> listAll() throws DAOException {
        List<Distrito> listarDistrito = new ArrayList();
        String sql = "SELECT * FROM distritos";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Distrito distrito = new Distrito();
                distrito.setId(rs.getString("id"));
                distrito.setNombre(rs.getString("nombre"));
                distrito.setProvincia_id(rs.getString("provincia_id"));
                distrito.setDepartamento_id(rs.getString("departamento_id"));
                
                listarDistrito.add(distrito);
            }
        } catch (SQLException e) {
            throw new DAOException("Error en Sql", e);

        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();

                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
        }
        return listarDistrito;
    }

    @Override
    public Distrito getById(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Distrito> getByProvinciaDistrito(String id) throws DAOException {
        List<Distrito> distritos = new ArrayList<>();
        String sql = "SELECT * FROM distritos WHERE provincia_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Distrito distrito = new Distrito();
                distrito.setId(rs.getString("id"));
                distrito.setNombre(rs.getString("nombre"));
                distrito.setProvincia_id(rs.getString("provincia_id"));
                distrito.setDepartamento_id(rs.getString("departamento_id"));
                
                distritos.add(distrito);
            }
        } catch (SQLException e) {
            throw new DAOException("Error en Sql", e);
        } finally {

            if (rs != null) {
                try {
                    rs.close();

                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }
            if (ps != null) {
                try {
                    ps.close();

                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }

        }
        return distritos;
    }
    
}
