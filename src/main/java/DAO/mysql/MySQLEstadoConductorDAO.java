package DAO.mysql;

/**
 *
 * @author qtaxe
 */
import DAO.Conexion;
import DAO.DAOException;
import DAO.EstadoConductorDAO;
import Modelo.EstadoConductor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MySQLEstadoConductorDAO implements EstadoConductorDAO {

    private Connection conn;

    public MySQLEstadoConductorDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void add(EstadoConductor obj) throws DAOException {
        String sql = "INSERT INTO estado_conductor (descripcion) VALUES (?)";

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
    public List<EstadoConductor> listAll() throws DAOException {
        List<EstadoConductor> lista = new ArrayList();
        String sql = "SELECT * FROM estado_conductor";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EstadoConductor estadoConductor = new EstadoConductor();
                estadoConductor.setId_estado(rs.getInt("id_estado"));
                estadoConductor.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoConductor);
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
    public void update(EstadoConductor obj) throws DAOException {
        String sql = "UPDATE estado_conductor SET descripcion WHERE id_estado=?";
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
    public EstadoConductor getById(Integer id) throws DAOException {
        EstadoConductor estadoConductor = new EstadoConductor();
        String sql = "SELECT * FROM estado_conductor WHERE id=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                estadoConductor.setId_estado(rs.getInt("id_estado"));
                estadoConductor.setDescripcion(rs.getString("descripcion"));
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

        return estadoConductor;
    }

    @Override
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
