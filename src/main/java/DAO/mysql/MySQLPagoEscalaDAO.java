
package DAO.mysql;

/**
 *
 * @author qtaxe
 */

import DAO.Conexion;
import DAO.DAOException;
import DAO.PagoEscalaDAO;
import Modelo.PagoEscala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class MySQLPagoEscalaDAO implements PagoEscalaDAO{
    
    private Connection conn;

    public MySQLPagoEscalaDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    
     @Override
    public void add(PagoEscala obj) throws DAOException{
        String sql = "INSERT INTO pago_escala (id_pago_escala) VALUES (?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, obj.getId_pago_escala());
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
    public List<PagoEscala> listAll() throws DAOException{
        List<PagoEscala> lista= new ArrayList();
        String sql="SELECT * FROM pago_escala";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                PagoEscala pagoEscala = new PagoEscala();
                pagoEscala.setId_pago_escala(rs.getInt("id_pago_escala"));
               // pagoEscala.(rs.getInt(""));
                lista.add(pagoEscala);
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
    public void update(PagoEscala obj) throws DAOException{
        String sql="UPDATE pago_escala SET descripcion WHERE id_pago_escala=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, obj.getId_pago_escala());
          //  ps.setInt(2, obj.());
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
    public PagoEscala getById(Integer id) throws DAOException{
        PagoEscala pagoEscala = new PagoEscala();
        String sql ="SELECT * FROM pago_escala WHERE id=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                pagoEscala.setId_pago_escala(rs.getInt("id_pago_escala"));
                //pagoEscala.(rs.getInt(""));
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
        return pagoEscala;
    } 

    @Override
    public void disable(PagoEscala t) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  
    
    
    
    
    
    
    
    
    
    
    
    
}
