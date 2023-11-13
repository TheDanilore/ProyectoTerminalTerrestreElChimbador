/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.Conexion;
import DAO.DAOException;
import DAO.UsuarioDAO;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class MySQLUsuarioDAO implements UsuarioDAO{

    private Connection conn;

    public MySQLUsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    public MySQLUsuarioDAO() {
        
    }
    
    @Override
    public Usuario log(String username, String password){
        Usuario login = null; 

        String sql = "SELECT * FROM usuarios WHERE usuario=? AND contra_usuarios=? AND id_estado=1";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                login = new Usuario();
                login.setId_usuarios(rs.getInt("id_usuarios"));
                login.setNombres(rs.getString("nombres"));
                login.setUsuario(rs.getString("usuario"));
                login.setContra_usuarios(rs.getString("contra_usuarios"));
                login.setCargo(rs.getInt("id_cargo"));
            }
        } catch (SQLException e) {
            System.err.println("Error de la base de datos: " + e.getMessage());
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return login;
    }

    
    @Override
    public void add(Usuario reg) throws DAOException{
        String sql = "INSERT INTO usuarios (nombres,usuario, contra_usuarios, id_cargo) VALUES (?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, reg.getNombres());
            ps.setString(2, reg.getUsuario());
            ps.setString(3, reg.getContra_usuarios());
            ps.setInt(4, reg.getCargo());
            
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
        List<Usuario> listarUsuarios = new ArrayList();
        String sql = "SELECT * FROM usuarios";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuarioModelo = new Usuario();
                usuarioModelo.setId_usuarios(rs.getInt("id_usuarios"));
                usuarioModelo.setNombres(rs.getString("nombres"));
                usuarioModelo.setUsuario(rs.getString("usuario"));
                usuarioModelo.setContra_usuarios(rs.getString("contra_usuarios"));
                usuarioModelo.setCargo(rs.getInt("id_cargo"));
                usuarioModelo.setEstado(rs.getInt("id_estado"));
                
                listarUsuarios.add(usuarioModelo);
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
        return listarUsuarios;
    }

    @Override
    public void disable(Usuario usuario) throws DAOException{
        String sql = "UPDATE usuarios SET id_estado = ? WHERE id_usuarios = ?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, usuario.getEstado());
            ps.setInt(2, usuario.getId_usuarios());
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
    public void update(Usuario usuario) throws DAOException{
        String sql = "UPDATE usuarios SET nombres=?,usuario=?, contra_usuarios=?, id_cargo=? WHERE id_usuarios=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombres());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getContra_usuarios());
            ps.setInt(4, usuario.getCargo());
            ps.setInt(5, usuario.getId_usuarios());
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
    public Usuario getById(Integer ID) throws DAOException{
        Usuario usuarioModelo = new Usuario();
        String sql = "SELECT * FROM usuarios WHERE id_usuarios=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuarioModelo.setNombres(rs.getString("nombres_usuario"));
                usuarioModelo.setUsuario(rs.getString("usuario"));
                usuarioModelo.setContra_usuarios(rs.getString("contra_usuarios"));
                usuarioModelo.setCargo(rs.getInt("id_cargo"));
                usuarioModelo.setEstado(rs.getInt("id_estado"));
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
        return usuarioModelo;
    }

}
