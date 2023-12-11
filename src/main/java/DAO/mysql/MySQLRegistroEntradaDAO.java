/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.RegistroEntradaDAO;
import Modelo.RegistroEntrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        String sql = "INSERT INTO registro_entrada (dni_conductor,conductor,placa,tipo_vehiculo,destino,pago) VALUES (?,?,?,?,?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setLong(1, obj.getDni());
            ps.setString(2, obj.getConductor());
            ps.setString(3, obj.getVehiculo());
            ps.setString(4, obj.getTipo_vehiculo());
            ps.setString(5, obj.getDestino());
            ps.setDouble(6, obj.getPago());
            
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
        String sql = "UPDATE registro_entrada SET dni_conductor=? conductor=?, placa=?, tipo_vehiculo=?, destino=?,pago=? WHERE id_registro_entrada=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, obj.getDni());
            ps.setString(2, obj.getConductor());
            ps.setString(3, obj.getVehiculo());
            ps.setString(4, obj.getTipo_vehiculo());
            ps.setString(5, obj.getDestino());
            ps.setDouble(6, obj.getPago());
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
                registroEntrada.setDni(rs.getLong("dni_conductor"));
                registroEntrada.setConductor(rs.getString("conductor"));
                registroEntrada.setVehiculo(rs.getString("placa"));
                registroEntrada.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                registroEntrada.setDestino(rs.getString("destino"));
                registroEntrada.setFecha_hora_entrada(rs.getString("fecha_hora_entrada"));
                registroEntrada.setUsuario(rs.getString("usuario"));
                registroEntrada.setPago(rs.getDouble("pago"));
                registroEntrada.setEstado(rs.getInt("id_estado_terminal"));
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
                registroEntrada.setDni(rs.getLong("dni_conductor"));
                registroEntrada.setConductor(rs.getString("conductor"));
                registroEntrada.setVehiculo(rs.getString("placa"));
                registroEntrada.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                registroEntrada.setDestino(rs.getString("destino"));
                registroEntrada.setFecha_hora_entrada(rs.getString("fecha_hora_entrada"));
                registroEntrada.setUsuario(rs.getString("usuario"));
                registroEntrada.setPago(rs.getDouble("pago"));
                registroEntrada.setEstado(rs.getInt("id_estado_terminal"));
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
