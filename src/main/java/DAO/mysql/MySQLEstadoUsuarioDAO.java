/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.Conexion;
import DAO.DAOException;
import DAO.EstadoUsuarioDAO;
import Modelo.EstadoUsuario;
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
public class MySQLEstadoUsuarioDAO implements EstadoUsuarioDAO{
    
    private Connection conn;

    public MySQLEstadoUsuarioDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public void add(EstadoUsuario obj) throws DAOException{
        String sql = "INSERT INTO estado_usuario (descripcion) VALUES (?)";
        
        try{
            ps=conn.prepareStatement(sql);
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
    public List<EstadoUsuario> listAll() throws DAOException{
        List<EstadoUsuario> lista= new ArrayList();
        String sql="SELECT * FROM estado_usuario";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                EstadoUsuario estadoUsuario = new EstadoUsuario();
                estadoUsuario.setId_estado(rs.getInt("id_estado"));
                estadoUsuario.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoUsuario);
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
    public void update(EstadoUsuario obj) throws DAOException{
        String sql="UPDATE estado_usuario SET descripcion WHERE id_estado=?";
        try{
            ps=conn.prepareStatement(sql);
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
    public EstadoUsuario getById(Integer id) throws DAOException{
        EstadoUsuario estadoUsuario = new EstadoUsuario();
        String sql ="SELECT * FROM estado_usuario WHERE id=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                estadoUsuario.setId_estado(rs.getInt("id_estado"));
                estadoUsuario.setDescripcion(rs.getString("descripcion"));
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
        return estadoUsuario;
    }



    @Override
    public void delete(Integer id) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}
