/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import Modelo.RegistroEntrada;
import Modelo.RegistroEntradaConPaga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.RegistroEntradaDAO;

/**
 *
 * @author Danilore
 */
public class MySQLRegistroEntradaDAO implements RegistroEntradaDAO{

    private Connection conn;

    public MySQLRegistroEntradaDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public void add(RegistroEntrada obj) throws DAOException {
        String sql = "INSERT INTO registro_entrada (tipo_documento,numero_documento,conductor,placa,tipo_vehiculo) VALUES (?,?,?,?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getTipo_documento());
            ps.setLong(2, obj.getNumero_documento());
            ps.setString(3, obj.getConductor());
            ps.setString(4, obj.getVehiculo());
            ps.setString(5, obj.getTipo_vehiculo());
            
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
    public void update(RegistroEntrada obj) throws DAOException {
        String sql = "UPDATE registro_entrada SET tipo_documento=?  numero_documento=? conductor=?, placa=?, tipo_vehiculo=? WHERE id_registro_entrada=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getTipo_documento());
            ps.setLong(2, obj.getNumero_documento());
            ps.setString(3, obj.getConductor());
            ps.setString(4, obj.getVehiculo());
            ps.setString(5, obj.getTipo_vehiculo());
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
    public void delete(Integer id) throws DAOException {
        String sql="DELETE FROM registro_entrada WHERE id_registro_entrada=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
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
    public List<RegistroEntrada> listAll() throws DAOException {
        List<RegistroEntrada> lista= new ArrayList();
        String sql="SELECT * FROM registro_entrada";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                RegistroEntrada registroEntrada = new RegistroEntrada();
                registroEntrada.setId_registro_entrada(rs.getInt("id_registro_entrada"));
                registroEntrada.setTipo_documento(rs.getString("tipo_documento"));
                registroEntrada.setNumero_documento(rs.getLong("numero_documento"));
                registroEntrada.setConductor(rs.getString("conductor"));
                registroEntrada.setVehiculo(rs.getString("placa"));
                registroEntrada.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                registroEntrada.setFecha_hora_entrada(rs.getString("fecha_hora_entrada"));
                registroEntrada.setUsuario(rs.getString("usuario"));
                lista.add(registroEntrada);
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
    public RegistroEntrada getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RegistroEntrada> getByPlaca(String placa) throws DAOException {
        List<RegistroEntrada> lista= new ArrayList();
        String sql = "SELECT * FROM registro_entrada WHERE placa=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            while(rs.next()){
                RegistroEntrada registroEntrada = new RegistroEntrada();
                registroEntrada.setId_registro_entrada(rs.getInt("id_registro_entrada"));
                registroEntrada.setTipo_documento(rs.getString("tipo_documento"));
                registroEntrada.setNumero_documento(rs.getLong("numero_documento"));
                registroEntrada.setConductor(rs.getString("conductor"));
                registroEntrada.setVehiculo(rs.getString("placa"));
                registroEntrada.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                registroEntrada.setFecha_hora_entrada(rs.getString("fecha_hora_entrada"));
                registroEntrada.setUsuario(rs.getString("usuario"));
                lista.add(registroEntrada);
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
    
}
