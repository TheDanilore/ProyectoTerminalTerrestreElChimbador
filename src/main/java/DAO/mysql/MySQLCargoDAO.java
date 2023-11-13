/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.CargoDAO;
import DAO.Conexion;
import DAO.Conexion;
import DAO.DAOException;
import Modelo.Cargo;
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
public class MySQLCargoDAO implements CargoDAO {

    private Connection conn;

    public MySQLCargoDAO(Connection conn) {
        this.conn = conn;
    }

    PreparedStatement ps = null;
    ResultSet rs;

    @Override
    public void add(Cargo obj) throws DAOException {
        String sql = "INSERT INTO cargo (descripcion) VALUES (?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());

            if (ps.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya guardado");
            }

        } catch (SQLException e) {
            throw new DAOException("Error en Sql", e);

        } finally {

            if (ps != null) {
                try {
                    ps.close();

                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }

        }
    }

    @Override
    public void update(Cargo obj) throws DAOException {
        String sql = "UPDATE cargo SET descripcion=? WHERE id_cargo=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_cargo());
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya guardado");
            }
        } catch (SQLException e) {
            throw new DAOException("Error en Sql", e);
        } finally {

            if (ps != null) {
                try {
                    ps.close();

                } catch (SQLException e) {
                    throw new DAOException("Error en SQL", e);
                }
            }

        }
    }

    @Override
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cargo> listAll() throws DAOException {
        List<Cargo> lista = new ArrayList();
        String sql = "SELECT * FROM cargo";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId_cargo(rs.getInt("id_cargo"));
                cargo.setDescripcion(rs.getString("descripcion"));

                lista.add(cargo);
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
        return lista;
    }

    @Override
    public Cargo obtenerCargoPorDescripcion(String descripcion) {
        Cargo cargo = new Cargo();
        String sql = "SELECT * FROM cargo WHERE descripcion=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, descripcion);
            rs = ps.executeQuery();
            if (rs.next()) {
                cargo.setId_cargo(rs.getInt("id_cargo"));

            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cargo;
    }

    @Override
    public Cargo getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
