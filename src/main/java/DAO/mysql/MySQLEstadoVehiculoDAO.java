
package DAO.mysql;

/**
 *
 * @author qtaxe
 */

import DAO.Conexion;
import DAO.DAOException;
import DAO.EstadoVehiculoDAO;
import Modelo.EstadoVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MySQLEstadoVehiculoDAO implements EstadoVehiculoDAO{
    
    private Connection conn;

    public MySQLEstadoVehiculoDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    
  @Override
    public void add(EstadoVehiculo obj) throws DAOException{
        String sql = "INSERT INTO estado_vehiculo (descripcion) VALUES (?)";
        
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
    public List<EstadoVehiculo> listAll() throws DAOException{
        List<EstadoVehiculo> lista= new ArrayList();
        String sql="SELECT * FROM estado_vehiculo";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                EstadoVehiculo estadoVehiculo = new EstadoVehiculo();
                estadoVehiculo.setId_estado_vehiculo(rs.getInt("id_estado"));
                estadoVehiculo.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoVehiculo);
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
    public void update(EstadoVehiculo obj) throws DAOException{
        String sql="UPDATE estado_vehiculo SET descripcion WHERE id_estado=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_estado_vehiculo());
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
    public EstadoVehiculo getById(Integer id) throws DAOException{
        EstadoVehiculo estadoVehiculo = new EstadoVehiculo();
        String sql ="SELECT * FROM estado_vehiculo WHERE id=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                estadoVehiculo.setId_estado_vehiculo(rs.getInt("id_estado"));
                estadoVehiculo.setDescripcion(rs.getString("descripcion"));
            }
        }catch (SQLException e) {
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
        return estadoVehiculo;
    }  

    @Override
    public void delete(Integer id) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
    
    
    
}
