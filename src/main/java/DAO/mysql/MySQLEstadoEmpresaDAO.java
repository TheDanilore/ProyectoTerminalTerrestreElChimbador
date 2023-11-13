package DAO.mysql;

/**
 *
 * @author qtaxe
 */
import DAO.Conexion;
import DAO.DAOException;
import DAO.EstadoEmpresaDAO;
import Modelo.EstadoEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MySQLEstadoEmpresaDAO implements EstadoEmpresaDAO {

    private Connection conn;

    public MySQLEstadoEmpresaDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void add(EstadoEmpresa obj) throws DAOException {
        String sql = "INSERT INTO estado_empresa (descripcion) VALUES (?)";

        try {
            ps = conn.prepareStatement(sql);
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
    public List<EstadoEmpresa> listAll() throws DAOException {
        List<EstadoEmpresa> lista = new ArrayList();
        String sql = "SELECT * FROM estado_empresa";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EstadoEmpresa estadoEmpresa = new EstadoEmpresa();
                estadoEmpresa.setId_estado(rs.getInt("id_estado"));
                estadoEmpresa.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoEmpresa);
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
        return lista;
    }

    @Override
    public void update(EstadoEmpresa obj) throws DAOException {
        String sql = "UPDATE estado_empresa SET descripcion WHERE id_estado=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_estado());
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
    public EstadoEmpresa getById(Integer id) throws DAOException{
        EstadoEmpresa estadoEmpresa = new EstadoEmpresa();
        String sql = "SELECT * FROM estado_empresa WHERE id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                estadoEmpresa.setId_estado(rs.getInt("id_estado"));
                estadoEmpresa.setDescripcion(rs.getString("descripcion"));
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
        return estadoEmpresa;
    }

    @Override
    public void delete(Integer id) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
