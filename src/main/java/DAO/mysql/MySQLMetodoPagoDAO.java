
package DAO.mysql;

/**
 *
 * @author qtaxe
 */

import DAO.Conexion;
import DAO.DAOException;
import DAO.MetodoPagoDAO;
import Modelo.MetodoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class MySQLMetodoPagoDAO implements MetodoPagoDAO{
    
    
    private Connection conn;

    public MySQLMetodoPagoDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    public MySQLMetodoPagoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    @Override
    public void add(MetodoPago obj) throws DAOException{
        String sql = "INSERT INTO metodo_pago (descripcion) VALUES (?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            if (ps.executeUpdate() == 0) {
                throw new DAOException("Puede que no se haya guardado");
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
    }
    
    @Override
    public List<MetodoPago> listAll() throws DAOException{
        List<MetodoPago> lista= new ArrayList();
        String sql="SELECT * FROM metodo_pago";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                MetodoPago metodoPago = new MetodoPago();
                metodoPago.setId_metodo_pago(rs.getInt("id_metodo_pago"));
                metodoPago.setDescripcion(rs.getString("descripcion"));
                lista.add(metodoPago);
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
    public void update(MetodoPago obj) throws DAOException{
        String sql="UPDATE metodo_pago SET descripcion WHERE id_metodo_pago=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_metodo_pago());
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
    public void  delete(Integer id) throws DAOException{
        String sql="DELETE FROM metodo_pago WHERE id_metodo_pago=?";
        try{
            ps=conn.prepareStatement(sql);
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
    public MetodoPago getById(Integer id) throws DAOException{
        MetodoPago metodoPago = new MetodoPago();
        String sql ="SELECT * FROM metodo_pago WHERE id=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                metodoPago.setId_metodo_pago(rs.getInt("id_metodo_pago"));
                metodoPago.setDescripcion(rs.getString("descripcion"));
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
        return metodoPago;
    } 
    
    
    
}
