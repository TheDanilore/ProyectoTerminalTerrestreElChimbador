
package DAO;

/**
 *
 * @author qtaxe
 */

import Modelo.EstadoVehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EstadoVehiculoDAO {
    
  Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarEstado(EstadoVehiculo obj){
        String sql = "INSERT INTO estado_vehiculo (descripcion) VALUES (?)";
        
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
    
    public List<EstadoVehiculo> listarEstado(){
        List<EstadoVehiculo> lista= new ArrayList();
        String sql="SELECT * FROM estado_vehiculo";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                EstadoVehiculo estadoVehiculo = new EstadoVehiculo();
                estadoVehiculo.setId_estado_vehiculo(rs.getInt("id_estado"));
                estadoVehiculo.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoVehiculo);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarEstado(EstadoVehiculo obj){
        String sql="UPDATE estado_vehiculo SET descripcion WHERE id_estado=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_estado_vehiculo());
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
    
    public EstadoVehiculo BuscarEstado(int id){
        EstadoVehiculo estadoVehiculo = new EstadoVehiculo();
        String sql ="SELECT * FROM estado_vehiculo WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                estadoVehiculo.setId_estado_vehiculo(rs.getInt("id_estado"));
                estadoVehiculo.setDescripcion(rs.getString("descripcion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return estadoVehiculo;
    }  
    
    
    
    
    
    
    
    
}
