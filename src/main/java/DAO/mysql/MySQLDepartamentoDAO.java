/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.DepartamentoDAO;
import Modelo.Departamento;
import Modelo.Empresas;
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
public class MySQLDepartamentoDAO implements DepartamentoDAO{

    private Connection conn;

    public MySQLDepartamentoDAO(Connection conn) {
        this.conn = conn;
    }

    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void add(Departamento obj) throws DAOException {
        String sql = "INSERT INTO departamentos (id, nombre, poblacion_estimada) VALUES (?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getId());
            ps.setString(2, obj.getNombre());
            ps.setLong(3, obj.getPoblacion_estimada());
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
    public void update(Departamento t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void disable(Departamento t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Departamento> listAll() throws DAOException {
        List<Departamento> listarDepartamento = new ArrayList();
        String sql = "SELECT * FROM departamentos";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));
                departamento.setPoblacion_estimada(rs.getLong("poblacion_estimada"));
                listarDepartamento.add(departamento);
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
        return listarDepartamento;
    }

    @Override
    public Departamento getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
    
    
}
