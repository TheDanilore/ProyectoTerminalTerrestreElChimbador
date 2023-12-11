
package DAO.mysql;

/**
 *
 * @author qtaxe
 */
import DAO.Conexion;
import DAO.DAOException;
import DAO.TipoVehiculoPagoDAO;
import Modelo.TipoVehiculoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class MySQLTipoVehiculoPagoDAO implements TipoVehiculoPagoDAO{
    
    private Connection conn;

    public MySQLTipoVehiculoPagoDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public void add(TipoVehiculoPago obj) throws DAOException{
        String sql = "INSERT INTO tipo_vehiculo_pago (descripcion,tarifa) VALUES (?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setDouble(2, obj.getTarifa());
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
    public List<TipoVehiculoPago> listAll() throws DAOException{
        List<TipoVehiculoPago> lista = new ArrayList();
        String sql="SELECT * FROM tipo_vehiculo_pago";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TipoVehiculoPago tipoVehiculoPago = new TipoVehiculoPago();
                tipoVehiculoPago.setId_tipo_vehiculo_pago(rs.getInt("id_tipo_vehiculo_pago"));
                tipoVehiculoPago.setDescripcion(rs.getString("descripcion"));
                tipoVehiculoPago.setTarifa(rs.getDouble("tarifa"));
                
                lista.add(tipoVehiculoPago);
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
    public void update(TipoVehiculoPago obj) throws DAOException{
        String sql="UPDATE tipo_vehiculo_pago SET descripcion=? , tarifa=? WHERE id_tipo_vehiculo_pago=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setDouble(2, obj.getTarifa());
            ps.setInt(3, obj.getId_tipo_vehiculo_pago());
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
    public TipoVehiculoPago getById(Integer id) throws DAOException{
        TipoVehiculoPago tipoVehiculoPago = new TipoVehiculoPago();
        String sql ="SELECT * FROM tipo_vehiculo_pago WHERE id_tipo_vehiculo_pago=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                tipoVehiculoPago.setId_tipo_vehiculo_pago(rs.getInt("id_tipo_vehiculo_pago"));
                tipoVehiculoPago.setDescripcion(rs.getString("descripcion"));
                tipoVehiculoPago.setTarifa(rs.getDouble("tarifa"));
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
        return tipoVehiculoPago;
    } 
    
    
    @Override
    public void delete(Integer id) throws DAOException{
        String sql="DELETE FROM tipo_vehiculo_pago WHERE id_tipo_vehiculo_pago=?";
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
    public TipoVehiculoPago getByNombreId(String nombre) throws DAOException{
        TipoVehiculoPago tipoVehiculoPago = new TipoVehiculoPago();
        String sql ="SELECT * FROM tipo_vehiculo_pago WHERE descripcion=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs=ps.executeQuery();
            if(rs.next()){
                tipoVehiculoPago.setId_tipo_vehiculo_pago(rs.getInt("id_tipo_vehiculo_pago"));
                tipoVehiculoPago.setDescripcion(rs.getString("descripcion"));
                tipoVehiculoPago.setTarifa(rs.getDouble("tarifa"));
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
        return tipoVehiculoPago;
    }
    
    
    
    
    
    
    
    
    
    
}
