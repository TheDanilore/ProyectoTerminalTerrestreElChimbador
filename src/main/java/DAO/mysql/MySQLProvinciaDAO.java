/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.ProvinciaDAO;
import Modelo.Provincia;
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
public class MySQLProvinciaDAO implements ProvinciaDAO {

    private Connection conn;

    public MySQLProvinciaDAO(Connection conn) {
        this.conn = conn;
    }

    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void add(Provincia t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Provincia t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void disable(Provincia t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Provincia> listAll() throws DAOException {
        List<Provincia> listarProvincia = new ArrayList();
        String sql = "SELECT * FROM provincias";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provincia provincia = new Provincia();
                provincia.setId(rs.getString("id"));
                provincia.setNombre(rs.getString("nombre"));
                provincia.setDepartamento_id(rs.getString("departamento_id"));
                listarProvincia.add(provincia);
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
        return listarProvincia;
    }

    @Override
    public Provincia getById(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Provincia> getByDepartamentoProvincia(String id) throws DAOException {
        List<Provincia> provincias = new ArrayList<>();
        String sql = "SELECT * FROM provincias WHERE departamento_id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Provincia provincia = new Provincia();
                provincia.setId(rs.getString("id"));
                provincia.setNombre(rs.getString("nombre"));
                provincia.setDepartamento_id(rs.getString("departamento_id"));
                provincias.add(provincia);
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
        return provincias;
    }

    @Override
    public Provincia getByNombreId(String nombre) throws DAOException {
        Provincia provincia = new Provincia();
        String sql = "SELECT * FROM provincias WHERE nombre=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                provincia.setId(rs.getString("id"));
                provincia.setNombre(rs.getString("nombre"));
                provincia.setDepartamento_id(rs.getString("departamento_id"));
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
        return provincia;
    }

}
