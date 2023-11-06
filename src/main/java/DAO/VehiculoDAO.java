/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.TipoVehiculo;
import Modelo.VehiculoModelo;
import DAO.TipoVehiculoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class VehiculoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarVehiculo(VehiculoModelo vehiculo){
        String sql = "INSERT INTO vehiculo (placa_vehiculo,id_tipo_vehiculo) VALUES (?,?)";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, vehiculo.getPlaca_vehiculo());
            ps.setInt(2, vehiculo.getTipo_vehiculo());
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
    
    public List<VehiculoModelo> ListarVehiculo(){
        List<VehiculoModelo> lista= new ArrayList();
        String sql="SELECT * FROM vehiculo";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                VehiculoModelo vehiculoModelo = new VehiculoModelo();
                vehiculoModelo.setId_vehiculo(rs.getInt("id_vehiculo"));
                vehiculoModelo.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
                vehiculoModelo.setTipo_vehiculo(rs.getInt("id_tipo_vehiculo"));
                vehiculoModelo.setEstado(rs.getInt("id_estado"));
                lista.add(vehiculoModelo);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public boolean BajaActivarVehiculo(VehiculoModelo vehiculoModelo) {
        String sql = "UPDATE vehiculo SET id_estado = ? WHERE id_vehiculo = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, vehiculoModelo.getEstado());
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
    }
    
    public boolean ModificarVehiculo(VehiculoModelo vehiculoModelo){
        String sql="UPDATE vehiculo SET placa_vehiculo=?, id_tipo_vehiculo=? WHERE id_vehiculo=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, vehiculoModelo.getPlaca_vehiculo());
            ps.setInt(2, vehiculoModelo.getTipo_vehiculo());
            ps.setInt(3, vehiculoModelo.getId_vehiculo());
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
    
    public VehiculoModelo BuscarVehiculo(int placa){
        VehiculoModelo vehiculo = new VehiculoModelo();
        String sql ="SELECT * FROM vehiculo WHERE placa=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, placa);
            rs=ps.executeQuery();
            if(rs.next()){
                vehiculo.setId_vehiculo(rs.getInt("id_vehiculo"));
                vehiculo.setPlaca_vehiculo(rs.getString("placa_vehiculo"));
                vehiculo.setTipo_vehiculo(rs.getInt("tipo_vehiculo"));
                vehiculo.setEstado(rs.getInt("id_estado"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return vehiculo;
    }
}
