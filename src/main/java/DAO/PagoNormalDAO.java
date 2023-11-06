/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author qtaxe
 */


import Modelo.PagoNormal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PagoNormalDAO {
    
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarMetodoPago(PagoNormal obj){
        String sql = "INSERT INTO pago_normal (lugar_destino) VALUES (?)";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getLugar_destino());
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
    
    public List<PagoNormal> listarMetodoPago(){
        List<PagoNormal> lista= new ArrayList();
        String sql="SELECT * FROM pago_normal";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                PagoNormal pagoNormal = new PagoNormal();
                pagoNormal.setId_pago_normal(rs.getInt("id_pago_normal"));
                pagoNormal.setLugar_destino(rs.getString("lugar_destino"));
                lista.add(pagoNormal);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarMetodoPago(PagoNormal obj){
        String sql="UPDATE pago_normal SET lugar_destino WHERE id_pago_normal=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getLugar_destino());
            ps.setInt(2, obj.getId_pago_normal());
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
    
    public PagoNormal BuscarMetodoPago(int id){
        PagoNormal pagoNormal = new PagoNormal();
        String sql ="SELECT * FROM pago_normal WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                pagoNormal.setId_pago_normal(rs.getInt("id_pago_normal"));
                pagoNormal.setLugar_destino(rs.getString("lugar_destino"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return pagoNormal;
    } 
    
    
    
    
    
}
