/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.VehiculoEnTerminalDAO;
import Modelo.VehiculoEnTerminal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Danilore
 */
public class MySQLVehicoEnTerminalDAO implements VehiculoEnTerminalDAO{

    private Connection conn;

    public MySQLVehicoEnTerminalDAO(Connection conn) {
        this.conn = conn;
    }

    PreparedStatement ps = null;
    ResultSet rs;
    
    @Override
    public void add(VehiculoEnTerminal obj) throws DAOException {
        String sql = "INSERT INTO vehiculo_en_terminal (placa,id_estado) VALUES (?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getPlaca());
            ps.setInt(2, 1);
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
    public void update(VehiculoEnTerminal t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void disable(VehiculoEnTerminal t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VehiculoEnTerminal> listAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VehiculoEnTerminal getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
