/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.Conexion;
import DAO.DAOException;
import DAO.TipoVehiculoDAO;
import Modelo.TipoVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author Danilore
 */
public class MySQLTipoVehiculoDAO implements TipoVehiculoDAO{
    private Connection conn;

    public MySQLTipoVehiculoDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    public MySQLTipoVehiculoDAO() {
        
    }
    
    @Override
    public void add(TipoVehiculo obj) throws DAOException{
        String sql = "INSERT INTO tipo_vehiculo (descripcion) VALUES (?)";
        
        try{
            ps=conn.prepareStatement(sql);
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
    public List<TipoVehiculo> listAll() throws DAOException{
        List<TipoVehiculo> lista = new ArrayList();
        String sql="SELECT * FROM tipo_vehiculo";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TipoVehiculo tipoVehiculo = new TipoVehiculo();
                tipoVehiculo.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                tipoVehiculo.setDescripcion(rs.getString("descripcion"));
                
                lista.add(tipoVehiculo);
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
    public void delete(Integer id) throws DAOException{
        String sql="DELETE FROM tipo_vehiculo WHERE id_tipo_vehiculo=?";
        try{
            ps.setInt(1, id);
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
    public void update(TipoVehiculo obj) throws DAOException{
        String sql="UPDATE tipo_vehiculo SET descripcion=? WHERE id_tipo_vehiculo=?";
        try{
            ps=conn.prepareStatement(sql);
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
    public TipoVehiculo getById(Integer id) throws DAOException{
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        String sql ="SELECT * FROM tipo_vehiculo WHERE id_tipo_vehiculo=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                tipoVehiculo.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                tipoVehiculo.setDescripcion(rs.getString("descripcion"));
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
        return tipoVehiculo;
    }
}
