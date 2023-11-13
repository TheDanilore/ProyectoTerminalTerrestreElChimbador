
package DAO.mysql;

/**
 *
 * @author qtaxe
 */

import DAO.Conexion;
import DAO.DAOException;
import DAO.PagoCocheraDAO;
import Modelo.PagoCochera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MySQLPagoCocheraDAO implements PagoCocheraDAO{
    
    
    private Connection conn;

    public MySQLPagoCocheraDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public void add(PagoCochera obj) throws DAOException{
        String sql = "INSERT INTO pago_cochera (dias_estancia) VALUES (?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, obj.getDias_estancia());
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
    public List<PagoCochera> listAll() throws DAOException{
        List<PagoCochera> lista= new ArrayList();
        String sql="SELECT * FROM pago_cochera";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                PagoCochera pagoCochera = new PagoCochera();
                pagoCochera.setId_pago_cochera(rs.getInt("id_pago_cochera"));
                pagoCochera.setDias_estancia(rs.getInt("dias_estancia"));
                lista.add(pagoCochera);
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
    public void update(PagoCochera obj) throws DAOException{
        String sql="UPDATE pago_cochera SET dias_estancia WHERE id_pago_cochera=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, obj.getDias_estancia());
            ps.setInt(2, obj.getId_pago_cochera());
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
    public PagoCochera getById(Integer id) throws DAOException{
        PagoCochera pagoCochera = new PagoCochera();
        String sql ="SELECT * FROM pago_cochera WHERE id=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                pagoCochera.setId_pago_cochera(rs.getInt("id_pago_cochera"));
                pagoCochera.setDias_estancia(rs.getInt("dias_estancia"));
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
        return pagoCochera;
    } 

    @Override
    public void disable(PagoCochera t) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
    
    
}
