/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.EstadoUsuario;
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
public class EstadoUsuarioDAO {
    
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarEstado(EstadoUsuario obj){
        String sql = "INSERT INTO estado_usuario (descripcion) VALUES (?)";
        
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
    
    public List<EstadoUsuario> listarEstado(){
        List<EstadoUsuario> lista= new ArrayList();
        String sql="SELECT * FROM estado_usuario";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                EstadoUsuario estadoUsuario = new EstadoUsuario();
                estadoUsuario.setId_estado(rs.getInt("id_estado"));
                estadoUsuario.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoUsuario);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarEstado(EstadoUsuario obj){
        String sql="UPDATE estado_usuario SET descripcion WHERE id_estado=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_estado());
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
    
    public EstadoUsuario BuscarEstado(int id){
        EstadoUsuario estadoUsuario = new EstadoUsuario();
        String sql ="SELECT * FROM estado_usuario WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                estadoUsuario.setId_estado(rs.getInt("id_estado"));
                estadoUsuario.setDescripcion(rs.getString("descripcion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return estadoUsuario;
    }
}
