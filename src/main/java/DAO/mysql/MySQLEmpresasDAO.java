/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.Conexion;
import DAO.DAOException;
import DAO.EmpresasDAO;
import Modelo.Empresas;
import Modelo.EstadoEmpresa;
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
public class MySQLEmpresasDAO implements EmpresasDAO {

    private Connection conn;

    public MySQLEmpresasDAO(Connection conn) {
        this.conn = conn;
    }

    PreparedStatement ps;
    ResultSet rs;

    public MySQLEmpresasDAO() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Empresas empresas) throws DAOException {
        String sql = "INSERT INTO empresa (ruc, razon_social, nombre_comercial) VALUES (?,?,?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, empresas.getRuc());
            ps.setString(2, empresas.getRazon_social());
            ps.setString(3, empresas.getNombre_comercial());
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
    public List listAll() throws DAOException{
        List<Empresas> listarEmpresasModelos = new ArrayList();
        String sql = "SELECT * FROM empresa";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empresas empresasModelo = new Empresas();
                empresasModelo.setId_empresa(rs.getInt("id_empresa"));
                empresasModelo.setRuc(rs.getLong("ruc"));
                empresasModelo.setRazon_social(rs.getString("razon_social"));
                empresasModelo.setNombre_comercial(rs.getString("nombre_comercial"));
                empresasModelo.setEstado(rs.getInt("id_estado"));
                listarEmpresasModelos.add(empresasModelo);
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
        return listarEmpresasModelos;
    }

    @Override
    public void disable(Empresas empresasModelo) throws DAOException{
        String sql = "UPDATE empresa SET id_estado = ? WHERE id_empresa = ?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, empresasModelo.getEstado());
            ps.setInt(2, empresasModelo.getId_empresa());
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
    public void update(Empresas empresasModelo) throws DAOException{
        String sql = "UPDATE empresa SET ruc=?, razon_social=?, nombre_comercial=? WHERE id_empresa=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, empresasModelo.getRuc());
            ps.setString(2, empresasModelo.getRazon_social());
            ps.setString(3, empresasModelo.getNombre_comercial());
            ps.setInt(4, empresasModelo.getId_empresa());
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
    public Empresas getById(Integer id) throws DAOException{
        Empresas empresasModelo = new Empresas();
        String sql = "SELECT * FROM empresa WHERE id_empresa=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if (rs.next()) {
                empresasModelo.setId_empresa(rs.getInt("id_empresa"));
                empresasModelo.setRuc(rs.getInt("ruc"));
                empresasModelo.setRazon_social(rs.getString("razon_social"));
                empresasModelo.setNombre_comercial(rs.getString("nombre_comercial"));
                empresasModelo.setEstado(rs.getInt("id_estado"));
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

        return empresasModelo;
    }

}
