/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.mysql;

/**
 *
 * @author qtaxe
 */


import DAO.Conexion;
import DAO.DAOException;
import DAO.PagoNormalDAO;
import Modelo.PagoNormal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MySQLPagoNormalDAO implements PagoNormalDAO{
    
    
    private Connection conn;

    public MySQLPagoNormalDAO(Connection conn) {
        this.conn = conn;
    }
    PreparedStatement ps;
    ResultSet rs;
    
    public int IDVenta(){
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
    public void add(PagoNormal obj) throws DAOException{
        String sql = "INSERT INTO pago_normal (lugar_destino) VALUES (?)";
        
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getLugar_destino());
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
    public List<PagoNormal> listAll() throws DAOException{
        List<PagoNormal> lista= new ArrayList();
        String sql="SELECT * FROM pago_normal";
        try{
            ps=conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                PagoNormal pagoNormal = new PagoNormal();
                pagoNormal.setId_pago_normal(rs.getInt("id_pago_normal"));
                pagoNormal.setLugar_destino(rs.getString("lugar_destino"));
                lista.add(pagoNormal);
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
    public void update(PagoNormal obj) throws DAOException{
        String sql="UPDATE pago_normal SET lugar_destino WHERE id_pago_normal=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1, obj.getLugar_destino());
            ps.setInt(2, obj.getId_pago_normal());
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
    public PagoNormal getById(Integer id) throws DAOException{
        PagoNormal pagoNormal = new PagoNormal();
        String sql ="SELECT * FROM pago_normal WHERE id=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                pagoNormal.setId_pago_normal(rs.getInt("id_pago_normal"));
                pagoNormal.setLugar_destino(rs.getString("lugar_destino"));
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
        return pagoNormal;
    } 

    @Override
    public void disable(PagoNormal t) throws DAOException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
