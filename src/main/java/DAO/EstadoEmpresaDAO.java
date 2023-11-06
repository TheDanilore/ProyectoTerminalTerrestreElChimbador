
package DAO;

/**
 *
 * @author qtaxe
 */

import Modelo.EstadoEmpresa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class EstadoEmpresaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarEstado(EstadoEmpresa obj){
        String sql = "INSERT INTO estado_empresa (descripcion) VALUES (?)";
        
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
    
    public List<EstadoEmpresa> listarEstado(){
        List<EstadoEmpresa> lista= new ArrayList();
        String sql="SELECT * FROM estado_empresa";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                EstadoEmpresa estadoEmpresa = new EstadoEmpresa();
                estadoEmpresa.setId_estado(rs.getInt("id_estado"));
                estadoEmpresa.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoEmpresa);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarEstado(EstadoEmpresa obj){
        String sql="UPDATE estado_empresa SET descripcion WHERE id_estado=?";
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
    
    public EstadoEmpresa BuscarEstado(int id){
        EstadoEmpresa estadoEmpresa = new EstadoEmpresa();
        String sql ="SELECT * FROM estado_empresa WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                estadoEmpresa.setId_estado(rs.getInt("id_estado"));
                estadoEmpresa.setDescripcion(rs.getString("descripcion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return estadoEmpresa;
    }
    
    
    
    
    
}
