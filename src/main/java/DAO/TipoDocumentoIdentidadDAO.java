/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.TipoDocumentoIdentidad;
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
public class TipoDocumentoIdentidadDAO {
       
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarTipoDocumentoIdentidad(TipoDocumentoIdentidad obj){
        String sql = "INSERT INTO tipo_documento_identidad (descripcion) VALUES (?)";
        
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
    
    public ArrayList<TipoDocumentoIdentidad> getTipoDocumentoIdentidad(){
        ArrayList<TipoDocumentoIdentidad> lista = new ArrayList<>();
        
        String sql="SELECT * FROM tipo_documento_identidad";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TipoDocumentoIdentidad tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
                tipoDocumentoIdentidad.setId_tipo_documento_identidad(rs.getInt("id_tipo_documento_identidad"));
                tipoDocumentoIdentidad.setDescripcion(rs.getString("descripcion"));
                lista.add(tipoDocumentoIdentidad);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
        
    }
    
    public List<TipoDocumentoIdentidad> listarTipoDocumentoIdentidad(){
        List<TipoDocumentoIdentidad> lista= new ArrayList();
        String sql="SELECT * FROM tipo_documento_identidad";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TipoDocumentoIdentidad tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
                tipoDocumentoIdentidad.setId_tipo_documento_identidad(rs.getInt("id_tipo_documento_identidad"));
                tipoDocumentoIdentidad.setDescripcion(rs.getString("descripcion"));
                lista.add(tipoDocumentoIdentidad);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarTipoDocumentoIdentidad(TipoDocumentoIdentidad obj){
        String sql="UPDATE tipo_documento_identidad SET descripcion WHERE id_tipo_documento_identidad=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_tipo_documento_identidad());
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
    
    public TipoDocumentoIdentidad buscarTipoDocumentoIdentidad(int id){
        TipoDocumentoIdentidad tipoDocumentoIdentidad = new TipoDocumentoIdentidad();
        String sql ="SELECT * FROM tipo_documento_identidad WHERE id_tipo_documento_identidad=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                tipoDocumentoIdentidad.setId_tipo_documento_identidad(rs.getInt("id_tipo_documento_identidad"));
                tipoDocumentoIdentidad.setDescripcion(rs.getString("descripcion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return tipoDocumentoIdentidad;
    }
}
