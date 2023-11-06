
package DAO;

/**
 *
 * @author qtaxe
 */

import Modelo.EstadoConductor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EstadoConductorDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarEstado(EstadoConductor obj){
        String sql = "INSERT INTO estado_conductor (descripcion) VALUES (?)";
        
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
    
    public List<EstadoConductor> listarEstado(){
        List<EstadoConductor> lista= new ArrayList();
        String sql="SELECT * FROM estado_conductor";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                EstadoConductor estadoConductor = new EstadoConductor();
                estadoConductor.setId_estado(rs.getInt("id_estado"));
                estadoConductor.setDescripcion(rs.getString("descripcion"));
                lista.add(estadoConductor);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarEstado(EstadoConductor obj){
        String sql="UPDATE estado_conductor SET descripcion WHERE id_estado=?";
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
    
    public EstadoConductor BuscarEstado(int id){
        EstadoConductor estadoConductor = new EstadoConductor();
        String sql ="SELECT * FROM estado_conductor WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                estadoConductor.setId_estado(rs.getInt("id_estado"));
                estadoConductor.setDescripcion(rs.getString("descripcion"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return estadoConductor;
    }
    
    
    
    
    
    
    
    
}
