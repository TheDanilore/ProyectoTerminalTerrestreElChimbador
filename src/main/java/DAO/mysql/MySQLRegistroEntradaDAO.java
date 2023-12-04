/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.RegistroEntradaDAO;
import Modelo.RegistroEntrada;
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
public class MySQLRegistroEntradaDAO implements RegistroEntradaDAO{

    private Connection conn;

    public MySQLRegistroEntradaDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public void add(RegistroEntrada obj) throws DAOException {
        String sql = "INSERT INTO registro_entrada (lugar_destino) VALUES (?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getConductor());
            ps.setString(1, obj.getVehiculo());
            ps.setString(1, obj.getDestino());
            ps.setString(1, obj.getPago());
            ps.setString(1, obj.getFecha_hora_entrada());
            
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
    public void update(RegistroEntrada t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RegistroEntrada> listAll() throws DAOException {
        List<RegistroEntrada> lista= new ArrayList();
        String sql="SELECT * FROM registro_entrada";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                RegistroEntrada registroEntrada = new RegistroEntrada();
                registroEntrada.setId_registro_entrada(rs.getInt("id_registro_entrada"));
                registroEntrada.setConductor(rs.getString("conductor"));
                registroEntrada.setVehiculo(rs.getString("placa"));
                registroEntrada.setDestino(rs.getString("destino"));
                registroEntrada.setFecha_hora_entrada(rs.getString("fecha_hora_entrada"));
                registroEntrada.setUsuario(rs.getString("usuario"));
                registroEntrada.setPago(rs.getString("pago"));
                lista.add(registroEntrada);
            }
        }catch (SQLException e) {
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
    public RegistroEntrada getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
