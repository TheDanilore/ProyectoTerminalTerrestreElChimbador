/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.UsuarioModelo;
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
public class UsuarioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public UsuarioModelo log(String username, String password) {
        UsuarioModelo login = null; 

        String sql = "SELECT * FROM usuarios WHERE usuario=? AND contra_usuarios=? AND id_estado=1";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                login = new UsuarioModelo();
                login.setId_usuarios(rs.getInt("id_usuarios"));
                login.setNombres_usuario(rs.getString("nombres"));
                login.setUsername(rs.getString("usuario"));
                login.setPassword(rs.getString("contra_usuarios"));
                login.setId_rol(rs.getInt("id_cargo"));
                login.setId_estado(rs.getInt("id_estado"));
            }
        } catch (SQLException e) {
            System.err.println("Error de la base de datos: " + e.getMessage());
        } finally {
            
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
        return login;
    }

    
    public boolean Registrar(UsuarioModelo reg) {
        String sql = "INSERT INTO usuarios (nombres,usuario, contra_usuarios, id_cargo) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, reg.getNombres_usuario());
            ps.setString(2, reg.getUsername());
            ps.setString(3, reg.getPassword());
            ps.setInt(4, reg.getId_rol()); 
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.print(e.toString());
            return false;
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    public List ListarUsuario() {
        List<UsuarioModelo> listarUsuarios = new ArrayList();
        String sql = "SELECT * FROM usuarios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioModelo usuarioModelo = new UsuarioModelo();
                usuarioModelo.setId_usuarios(rs.getInt("id_usuarios"));
                usuarioModelo.setNombres_usuario(rs.getString("nombres"));
                usuarioModelo.setUsername(rs.getString("usuario"));
                usuarioModelo.setPassword(rs.getString("contra_usuarios"));
                usuarioModelo.setId_rol(rs.getInt("id_cargo"));
                usuarioModelo.setId_estado(rs.getInt("id_estado"));
                
                listarUsuarios.add(usuarioModelo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listarUsuarios;
    }

    public boolean BajaActivarUsuario(UsuarioModelo usuario) {
        String sql = "UPDATE usuarios SET id_estado = ? WHERE id_usuarios = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId_estado());
            ps.setInt(2, usuario.getId_usuarios());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }

    public boolean ModificarUsuario(UsuarioModelo usuario) {
        String sql = "UPDATE usuarios SET nombres=?,usuario=?, contra_usuarios=?, id_cargo=? WHERE id_usuarios=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombres_usuario());
            ps.setString(2, usuario.getUsername());
            ps.setString(3, usuario.getPassword());
            ps.setInt(4, usuario.getId_rol());
            ps.setInt(5, usuario.getId_usuarios());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public UsuarioModelo BuscarUsuario(int ID) {
        UsuarioModelo usuarioModelo = new UsuarioModelo();
        String sql = "SELECT * FROM usuarios WHERE id_usuarios=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuarioModelo.setNombres_usuario(rs.getString("nombres_usuario"));
                usuarioModelo.setUsername(rs.getString("usuario"));
                usuarioModelo.setPassword(rs.getString("contra_usuarios"));
                usuarioModelo.setId_rol(rs.getInt("id_cargo"));
                usuarioModelo.setId_estado(rs.getInt("id_estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return usuarioModelo;
    }

}
