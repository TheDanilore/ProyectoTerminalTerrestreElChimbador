/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.ConductorDAO;
import DAO.Conexion;
import DAO.DAOException;
import Modelo.Conductor;
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
public class MySQLConductorDAO implements ConductorDAO {

    private Connection conn;

    public MySQLConductorDAO() {
    }

    
    public MySQLConductorDAO(Connection conn) {
        this.conn = conn;
    }
    
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public void add(Conductor obj) throws DAOException {
        String sql = "INSERT INTO conductor (primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, "
                + "id_tipo_documento_identidad, numero_documento, telefono, direccion, ruc_empresa,id_estado) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getPrimer_nombre());
            ps.setString(2, obj.getSegundo_nombre());
            ps.setString(3, obj.getApellido_paterno());
            ps.setString(4, obj.getApellido_materno());
            ps.setString(5, obj.getTipo_documento_identidad());
            ps.setLong(6, obj.getNumero_documento());
            ps.setInt(7, obj.getTelefono());
            ps.setString(8, obj.getDireccion());
            ps.setLong(9, obj.getEmpresa());
            ps.setInt(10, 1);
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
    public List<Conductor> listAll() throws DAOException {
        List<Conductor> lista = new ArrayList();
        String sql = "SELECT * FROM conductor";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Conductor conductor = new Conductor();
                conductor.setId_conductor(rs.getInt("id_conductor"));
                conductor.setPrimer_nombre(rs.getString("primer_nombre"));
                conductor.setSegundo_nombre(rs.getString("segundo_nombre"));
                conductor.setApellido_paterno(rs.getString("apellido_paterno"));
                conductor.setApellido_materno(rs.getString("apellido_materno"));
                conductor.setTipo_documento_identidad(rs.getString("id_tipo_documento_identidad"));
                conductor.setNumero_documento(rs.getLong("numero_documento"));
                conductor.setTelefono(rs.getInt("telefono"));
                conductor.setDireccion(rs.getString("direccion"));
                conductor.setEmpresa(rs.getLong("ruc_empresa"));
                conductor.setEstado(rs.getInt("id_estado"));
                lista.add(conductor);
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
    public void disable(Conductor obj) throws DAOException {
        String sql = "UPDATE conductor SET id_estado = ? WHERE id_conductor = ?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, obj.getEstado());
            ps.setInt(2, obj.getId_conductor());
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
    public void update(Conductor obj) throws DAOException {
        String sql = "UPDATE conductor SET primer_nombre = ?, segundo_nombre = ?, apellido_paterno = ?, apellido_materno =?, "
                + "id_tipo_documento_identidad =?, numero_documento=?, telefono=?, direccion=?, ruc_empresa=? WHERE id_conductor=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getPrimer_nombre());
            ps.setString(2, obj.getSegundo_nombre());
            ps.setString(3, obj.getApellido_paterno());
            ps.setString(4, obj.getApellido_materno());
            ps.setString(5, obj.getTipo_documento_identidad());
            ps.setLong(6, obj.getNumero_documento());
            ps.setInt(7, obj.getTelefono());
            ps.setString(8, obj.getDireccion());
            ps.setLong(9, obj.getEmpresa());
            ps.setInt(10, obj.getId_conductor());
            ps.execute();
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
    public Conductor getById(Integer id) throws DAOException {
        Conductor conductor = new Conductor();
        String sql = "SELECT * FROM conductor WHERE id_conductor=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                conductor.setId_conductor(rs.getInt("id_conductor"));
                conductor.setPrimer_nombre(rs.getString("primer_nombre"));
                conductor.setSegundo_nombre(rs.getString("segundo_nombre"));
                conductor.setApellido_paterno(rs.getString("apellido_paterno"));
                conductor.setApellido_materno(rs.getString("apellido_materno"));
                conductor.setTipo_documento_identidad(rs.getString("id_tipo_documento_identidad"));
                conductor.setNumero_documento(rs.getLong("numero_documento"));
                conductor.setTelefono(rs.getInt("telefono"));
                conductor.setDireccion(rs.getString("direccion"));
                conductor.setEmpresa(rs.getLong("ruc_empresa"));
                conductor.setEstado(rs.getInt("id_estado"));
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
        return conductor;
    }

    @Override
    public Conductor getByDniConductor(Long dni) throws DAOException {
        Conductor conductor = new Conductor();
        String sql = "SELECT * FROM conductor WHERE numero_documento=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, dni);
            rs = ps.executeQuery();
            if (rs.next()) {
                conductor.setId_conductor(rs.getInt("id_conductor"));
                conductor.setPrimer_nombre(rs.getString("primer_nombre"));
                conductor.setSegundo_nombre(rs.getString("segundo_nombre"));
                conductor.setApellido_paterno(rs.getString("apellido_paterno"));
                conductor.setApellido_materno(rs.getString("apellido_materno"));
                conductor.setTipo_documento_identidad(rs.getString("id_tipo_documento_identidad"));
                conductor.setNumero_documento(rs.getLong("numero_documento"));
                conductor.setTelefono(rs.getInt("telefono"));
                conductor.setDireccion(rs.getString("direccion"));
                conductor.setEmpresa(rs.getLong("ruc_empresa"));
                conductor.setEstado(rs.getInt("id_estado"));
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
        return conductor;
    }

}
