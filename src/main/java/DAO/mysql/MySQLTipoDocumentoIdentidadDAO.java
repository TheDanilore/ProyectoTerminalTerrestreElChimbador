/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.Conexion;
import DAO.DAOException;
import DAO.TipoDocumentoIdentidadDAO;
import Modelo.TipoDocumentoIdentidad;
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
public class MySQLTipoDocumentoIdentidadDAO implements TipoDocumentoIdentidadDAO{
       
    private final Connection conn;

    public MySQLTipoDocumentoIdentidadDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    
    
    @Override
    public void add(TipoDocumentoIdentidad obj) throws DAOException{
        String sql = "INSERT INTO tipo_documento_identidad (descripcion,abreviatura) VALUES (?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setString(2, obj.getAbreviatura());
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
    public List<TipoDocumentoIdentidad> listAll() throws DAOException{
        List<TipoDocumentoIdentidad> lista = new ArrayList<>();
        
        String sql="SELECT * FROM tipo_documento_identidad";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TipoDocumentoIdentidad tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
                tipoDocumentoIdentidad.setId_tipo_documento_identidad(rs.getString("id_tipo_documento_identidad"));
                tipoDocumentoIdentidad.setDescripcion(rs.getString("descripcion"));
                tipoDocumentoIdentidad.setAbreviatura(rs.getString("abreviatura"));
                lista.add(tipoDocumentoIdentidad);
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
    public void update(TipoDocumentoIdentidad obj) throws DAOException{
        String sql="UPDATE tipo_documento_identidad SET descripcion=?, abreviatura=?   WHERE id_tipo_documento_identidad=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setString(2, obj.getAbreviatura());
            ps.setString(4, obj.getId_tipo_documento_identidad());
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
    public TipoDocumentoIdentidad getById(String id) throws DAOException{
        TipoDocumentoIdentidad tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
        String sql ="SELECT * FROM tipo_documento_identidad WHERE id_tipo_documento_identidad=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                tipoDocumentoIdentidad.setId_tipo_documento_identidad(rs.getString("id_tipo_documento_identidad"));
                tipoDocumentoIdentidad.setDescripcion(rs.getString("descripcion"));
                tipoDocumentoIdentidad.setAbreviatura(rs.getString("abreviatura"));
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
        return tipoDocumentoIdentidad;
    }

    @Override
    public void delete(String id) throws DAOException{
        String sql="DELETE FROM tipo_documento_identidad WHERE id_tipo_documento_identidad=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
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
}
