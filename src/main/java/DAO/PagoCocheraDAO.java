
package DAO;

/**
 *
 * @author qtaxe
 */

import Modelo.PagoCochera;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PagoCocheraDAO {
    
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarPagoCochera(PagoCochera obj){
        String sql = "INSERT INTO pago_cochera (dias_estancia) VALUES (?)";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, obj.getDias_estancia());
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
    
    public List<PagoCochera> listarPagoCochera(){
        List<PagoCochera> lista= new ArrayList();
        String sql="SELECT * FROM pago_cochera";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                PagoCochera pagoCochera = new PagoCochera();
                pagoCochera.setId_pago_cochera(rs.getInt("id_pago_cochera"));
                pagoCochera.setDias_estancia(rs.getInt("dias_estancia"));
                lista.add(pagoCochera);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarPagoCochera(PagoCochera obj){
        String sql="UPDATE pago_cochera SET dias_estancia WHERE id_pago_cochera=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, obj.getDias_estancia());
            ps.setInt(2, obj.getId_pago_cochera());
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
    
    public PagoCochera BuscarPagoCochera(int id){
        PagoCochera pagoCochera = new PagoCochera();
        String sql ="SELECT * FROM pago_cochera WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                pagoCochera.setId_pago_cochera(rs.getInt("id_pago_cochera"));
                pagoCochera.setDias_estancia(rs.getInt("dias_estancia"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return pagoCochera;
    } 
    
  
    
    
}
