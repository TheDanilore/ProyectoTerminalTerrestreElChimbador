/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import Modelo.RegistroEntradaConPaga;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DAO.RegistroEntradaConPagaDAO;

/**
 *
 * @author Danilore
 */
public class MySQLRegistroEntradaConPagaDAO implements RegistroEntradaConPagaDAO{

    private Connection conn;

    public MySQLRegistroEntradaConPagaDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public void add(RegistroEntradaConPaga obj) throws DAOException {
        String sql = "INSERT INTO registro_entrada_paga (tipo_documento,numero_documento,conductor,placa,tipo_vehiculo,destino,pago) VALUES (?,?,?,?,?,?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getTipo_documento());
            ps.setLong(2, obj.getNumero_documento());
            ps.setString(3, obj.getConductor());
            ps.setString(4, obj.getVehiculo());
            ps.setString(5, obj.getTipo_vehiculo());
            ps.setString(6, obj.getDestino());
            ps.setDouble(7, obj.getPago());
            
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
    public void update(RegistroEntradaConPaga obj) throws DAOException {
        String sql = "UPDATE registro_entrada_paga SET tipo_documento=? numero_documento=? conductor=?, placa=?, tipo_vehiculo=?, destino=?,pago=? WHERE id_registro_entrada=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, obj.getTipo_documento());
            ps.setLong(2, obj.getNumero_documento());
            ps.setString(3, obj.getConductor());
            ps.setString(4, obj.getVehiculo());
            ps.setString(5, obj.getTipo_vehiculo());
            ps.setString(6, obj.getDestino());
            ps.setDouble(7, obj.getPago());
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
        String sql="DELETE FROM registro_entrada_paga WHERE id_registro_entrada=?";
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
    public List<RegistroEntradaConPaga> listAll() throws DAOException {
        List<RegistroEntradaConPaga> lista= new ArrayList();
        String sql="SELECT * FROM registro_entrada_paga";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                RegistroEntradaConPaga registroEntrada = new RegistroEntradaConPaga();
                registroEntrada.setId_registro_entrada(rs.getInt("id_registro_entrada"));
                registroEntrada.setTipo_documento(rs.getString("tipo_documento"));
                registroEntrada.setNumero_documento(rs.getLong("numero_documento"));
                registroEntrada.setConductor(rs.getString("conductor"));
                registroEntrada.setVehiculo(rs.getString("placa"));
                registroEntrada.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                registroEntrada.setDestino(rs.getString("destino"));
                registroEntrada.setFecha_hora_entrada(rs.getString("fecha_hora_entrada"));
                registroEntrada.setUsuario(rs.getString("usuario"));
                registroEntrada.setPago(rs.getDouble("pago"));
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
    public RegistroEntradaConPaga getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RegistroEntradaConPaga> getByPlaca(String placa) throws DAOException {
        List<RegistroEntradaConPaga> lista= new ArrayList();
        String sql = "SELECT * FROM registro_entrada_paga WHERE placa=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, placa);
            rs = ps.executeQuery();
            while(rs.next()){
                RegistroEntradaConPaga registroEntrada = new RegistroEntradaConPaga();
                registroEntrada.setId_registro_entrada(rs.getInt("id_registro_entrada"));
                registroEntrada.setTipo_documento(rs.getString("tipo_documento"));
                registroEntrada.setNumero_documento(rs.getLong("numero_documento"));
                registroEntrada.setConductor(rs.getString("conductor"));
                registroEntrada.setVehiculo(rs.getString("placa"));
                registroEntrada.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                registroEntrada.setDestino(rs.getString("destino"));
                registroEntrada.setFecha_hora_entrada(rs.getString("fecha_hora_entrada"));
                registroEntrada.setUsuario(rs.getString("usuario"));
                registroEntrada.setPago(rs.getDouble("pago"));
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
