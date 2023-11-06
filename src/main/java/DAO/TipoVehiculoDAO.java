/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.TipoVehiculo;
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
public class TipoVehiculoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarTipoVehiculo(TipoVehiculo obj){
        String sql = "INSERT INTO tipo_vehiculo (descripcion) VALUES (?)";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List<TipoVehiculo> listarTipoVehiculo(){
        List<TipoVehiculo> lista = new ArrayList();
        String sql="SELECT * FROM tipo_vehiculo";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TipoVehiculo tipoVehiculo = new TipoVehiculo();
                tipoVehiculo.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                tipoVehiculo.setDescripcion(rs.getString("descripcion"));
                
                lista.add(tipoVehiculo);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    
    /*public boolean BajaActivarTipoVehiculo(TipoVehiculo vehiculoModelo) {
        String sql = "UPDATE vehiculo SET id_estado = ? WHERE id_vehiculo = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, vehiculoModelo.getId_estado());
            ps.setInt(2, vehiculoModelo.getId_vehiculo());
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
    }*/
    
    public boolean modificarTipoVehiculo(TipoVehiculo obj){
        String sql="UPDATE tipo_vehiculo SET descripcion=? WHERE id_tipo_vehiculo=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public TipoVehiculo buscarTipoVehiculoPorID(int id){
        TipoVehiculo tipoVehiculo = new TipoVehiculo();
        String sql ="SELECT * FROM tipo_vehiculo WHERE id_tipo_vehiculo=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                tipoVehiculo.setId_tipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return tipoVehiculo;
    }
}
