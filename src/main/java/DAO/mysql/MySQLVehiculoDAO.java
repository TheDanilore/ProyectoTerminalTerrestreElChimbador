/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.Conexion;
import DAO.DAOException;
import Modelo.Vehiculo;
import DAO.VehiculoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MySQLVehiculoDAO implements VehiculoDAO{
    private Connection conn;

    public MySQLVehiculoDAO(Connection conn) {
        this.conn = conn;
    }

    public MySQLVehiculoDAO() {
    }
    
    
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public void add(Vehiculo obj) throws DAOException{
        String sql = "INSERT INTO vehiculo (placa_vehiculo,id_tipo_vehiculo,id_estado) VALUES (?,?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getPlaca_vehiculo());
            ps.setInt(2, obj.getTipo_vehiculo());
            ps.setInt(3, 1);
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
    public List<Vehiculo> listAll() throws DAOException{
        List<Vehiculo> lista= new ArrayList();
        String sql="SELECT * FROM vehiculo";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Vehiculo vehiculoModelo = new Vehiculo();
                vehiculoModelo.setId_vehiculo(rs.getInt("id_vehiculo"));
                vehiculoModelo.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
                vehiculoModelo.setTipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                vehiculoModelo.setEstado(rs.getInt("id_estado"));
                lista.add(vehiculoModelo);
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
    public void disable(Vehiculo obj) throws DAOException{
        String sql = "UPDATE vehiculo SET id_estado = ? WHERE id_vehiculo = ?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getEstado());
            ps.setInt(2, obj.getId_vehiculo());
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
    public void update(Vehiculo obj) throws DAOException{
        String sql="UPDATE vehiculo SET placa_vehiculo=?, id_tipo_vehiculo=? WHERE id_vehiculo=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getPlaca_vehiculo());
            ps.setInt(2, obj.getTipo_vehiculo());
            ps.setInt(3, obj.getId_vehiculo());
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
    public Vehiculo getById(Integer placa) throws DAOException{
        Vehiculo obj = new Vehiculo();
        String sql ="SELECT * FROM vehiculo WHERE placa=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, placa);
            rs=ps.executeQuery();
            if(rs.next()){
                obj.setId_vehiculo(rs.getInt("id_vehiculo"));
                obj.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
                obj.setTipo_vehiculo(rs.getInt("tipo_vehiculo"));
                obj.setEstado(rs.getInt("id_estado"));
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
        return obj;
    }

    @Override
    public Vehiculo getByPlacaVehiculo(String placa) throws DAOException {
        Vehiculo vehiculo = new Vehiculo();
        String sql = "SELECT * FROM vehiculo WHERE placa_vehiculo=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            if (rs.next()) {
                vehiculo.setId_vehiculo(rs.getInt("id_vehiculo"));
                vehiculo.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
                vehiculo.setTipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                vehiculo.setEstado(rs.getInt("id_estado"));
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
        return vehiculo;
    }
}
