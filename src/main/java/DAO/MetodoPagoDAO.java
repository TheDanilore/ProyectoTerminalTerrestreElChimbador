
package DAO;

/**
 *
 * @author qtaxe
 */

import Modelo.MetodoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class MetodoPagoDAO {
    
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarMetodoPago(MetodoPago obj){
        String sql = "INSERT INTO metodo_pago (descripcion) VALUES (?)";
        
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
    
    public List<MetodoPago> listarMetodoPago(){
        List<MetodoPago> lista= new ArrayList();
        String sql="SELECT * FROM metodo_pago";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                MetodoPago metodoPago = new MetodoPago();
                metodoPago.setId_metodo_pago(rs.getInt("id_metodo_pago"));
                metodoPago.setDescripcion(rs.getString("descripcion"));
                lista.add(metodoPago);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarMetodoPago(MetodoPago obj){
        String sql="UPDATE metodo_pago SET descripcion WHERE id_metodo_pago=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.setInt(2, obj.getId_metodo_pago());
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
    
    public MetodoPago BuscarMetodoPago(int id){
        MetodoPago metodoPago = new MetodoPago();
        String sql ="SELECT * FROM metodo_pago WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                metodoPago.setId_metodo_pago(rs.getInt("id_metodo_pago"));
                metodoPago.setDescripcion(rs.getString("descripcion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return metodoPago;
    } 
    
    
    
}
