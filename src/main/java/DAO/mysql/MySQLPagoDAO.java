/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.PagoDAO;
import Modelo.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Danilore
 */
public class MySQLPagoDAO implements PagoDAO{
    
    private Connection conn;

    public MySQLPagoDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void add(Pago obj) throws DAOException {
        String sql = "INSERT INTO pago (dni_conductor,conductor,placa,tipo_vehiculo,destino,monto,id_metodo_pago) VALUES (?,?,?,?,?,?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setLong(1, obj.getDni_conductor());
            ps.setString(2, obj.getConductor());
            ps.setString(3, obj.getPlaca());
            ps.setString(4, obj.getTipo_vehiculo());
            ps.setString(5, obj.getDestino());
            ps.setDouble(6, obj.getMonto());
            ps.setDouble(7, obj.getId_metodo_pago());
            
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
    public void update(Pago t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pago> listAll() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pago getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
