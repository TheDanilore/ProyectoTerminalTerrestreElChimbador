/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Conductor;
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
public class ConductorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarConductor(Conductor obj){
        String sql = "INSERT INTO conductor (primer_nombre, segundo_nombre, apellido_paterno, apellido_materno, "
                + "id_tipo_documento_identidad, numero_documento, telefono, direccion, id_empresa) VALUES (?,?,?,?,?,?,?,?,?)"; 
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getPrimer_nombre());
            ps.setString(2, obj.getSegundo_nombre());
            ps.setString(3, obj.getApellido_paterno());
            ps.setString(4, obj.getApellido_materno());
            ps.setString(5, obj.getTipo_documento_identidad());
            ps.setLong(6, obj.getNumero_documento());
            ps.setInt(7, obj.getTelefono());
            ps.setString(8, obj.getDireccion());
            ps.setInt(9, obj.getEmpresa());
            
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
    
    public List<Conductor> listarConductor(){
        List<Conductor> lista= new ArrayList();
        String sql="SELECT * FROM conductor";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Conductor conductor = new Conductor();
                conductor.setId_conductor(rs.getInt("id_conductor"));
                conductor.setPrimer_nombre(rs.getString("primer_nombre"));
                conductor.setSegundo_nombre(rs.getString("segundo_nombre"));
                conductor.setApellido_paterno(rs.getString("apellido_paterno"));
                conductor.setApellido_materno(rs.getString("apellido_materno"));
                conductor.setTipo_documento_identidad(rs.getString("id_tipo_documento_identidad"));
                conductor.setNumero_documento(rs.getLong("numero_documento"));
                conductor.setTelefono(rs.getInt("telefono"));
                conductor.setDireccion(rs.getString("direccion"));
                conductor.setEmpresa(rs.getInt("id_empresa"));
                conductor.setEstado(rs.getInt("id_estado"));
                lista.add(conductor);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public boolean bajaActivarConductor(Conductor obj) {
        String sql = "UPDATE conductor SET id_estado = ? WHERE id_conductor = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getEstado());
            ps.setInt(2, obj.getId_conductor());
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
    
    public boolean modificarConductor(Conductor obj){
        String sql="UPDATE conductor SET primer_nombre = ?, segundo_nombre = ?, apellido_paterno = ?, apellido_materno =?, "
                + "id_tipo_documento_identidad =?, numero_documento=?, telefono=?, direccion=?, id_empresa=? WHERE id_conductor=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getPrimer_nombre());
            ps.setString(2, obj.getSegundo_nombre());
            ps.setString(3, obj.getApellido_paterno());
            ps.setString(4, obj.getApellido_materno());
            ps.setString(5, obj.getTipo_documento_identidad());
            ps.setLong(6, obj.getNumero_documento());
            ps.setInt(7, obj.getTelefono());
            ps.setString(8, obj.getDireccion());
            ps.setInt(9, obj.getEmpresa());
            ps.setInt(10, obj.getId_conductor());
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
    
    public Conductor buscarConductorPorNumDoc(int num){
        Conductor conductor = new Conductor();
        String sql ="SELECT * FROM conductor WHERE numero_documento=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, num);
            rs=ps.executeQuery();
            if(rs.next()){
                conductor.setId_conductor(rs.getInt("id_conductor"));
                conductor.setPrimer_nombre(rs.getString("primer_nombre"));
                conductor.setSegundo_nombre(rs.getString("segundo_nombre"));
                conductor.setApellido_paterno(rs.getString("apellido_paterno"));
                conductor.setApellido_materno(rs.getString("apellido_materno"));
                conductor.setTipo_documento_identidad(rs.getString("id_tipo_documento_identidad"));
                conductor.setNumero_documento(rs.getLong("numero_documento"));
                conductor.setTelefono(rs.getInt("telefono"));
                conductor.setDireccion(rs.getString("direccion"));
                conductor.setEstado(rs.getInt("id_estado"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return conductor;
    }
}
