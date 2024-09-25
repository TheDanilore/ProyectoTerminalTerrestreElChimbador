/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

import DAO.DAOException;
import DAO.PagoDAO;
import Modelo.Pago;
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
public class MySQLPagoDAO implements PagoDAO{
    
    private Connection conn;

    public MySQLPagoDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public int IDPago(){
        int ID=0;
        String sql="SELECT MAX(id_pago) FROM pago";
        try{
            ps=conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                ID=rs.getInt(1);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return ID;
    }
    
    @Override
    public void add(Pago obj) throws DAOException {
        String sql = "INSERT INTO pago (tipo_documento,numero_documento,conductor,placa,tipo_vehiculo,destino,monto,id_metodo_pago) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getTipo_documento());
            ps.setLong(2, obj.getNumero_documento());
            ps.setString(3, obj.getConductor());
            ps.setString(4, obj.getPlaca());
            ps.setString(5, obj.getTipo_vehiculo());
            ps.setString(6, obj.getDestino());
            ps.setDouble(7, obj.getMonto());
            ps.setDouble(8, obj.getId_metodo_pago());
            
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
    public void update(Pago t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pago> listAll() throws DAOException {
        List<Pago> lista= new ArrayList();
        String sql="SELECT * FROM pago";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Pago pago = new Pago();
                pago.setId_pago(rs.getInt("id_pago"));
                pago.setTipo_documento(rs.getString("tipo_documento"));
                pago.setNumero_documento(rs.getLong("numero_documento"));
                pago.setConductor(rs.getString("conductor"));
                pago.setPlaca(rs.getString("placa"));
                pago.setTipo_vehiculo(rs.getString("tipo_vehiculo"));
                pago.setDestino(rs.getString("destino"));
                pago.setFecha_pago(rs.getString("fecha_pago"));
                pago.setMonto(rs.getDouble("monto"));
                pago.setId_metodo_pago(rs.getInt("id_metodo_pago"));
                lista.add(pago);
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
    public Pago getById(Integer id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
