
package DAO;

/**
 *
 * @author qtaxe
 */

import Modelo.PagoEscala;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class PagoEscalaDAO {
    
     Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarPagoEscala(PagoEscala obj){
        String sql = "INSERT INTO pago_escala (id_pago_escala) VALUES (?)";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, obj.getId_pago_escala());
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
    
    public List<PagoEscala> listarPagoEscala(){
        List<PagoEscala> lista= new ArrayList();
        String sql="SELECT * FROM pago_escala";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                PagoEscala pagoEscala = new PagoEscala();
                pagoEscala.setId_pago_escala(rs.getInt("id_pago_escala"));
               // pagoEscala.(rs.getInt(""));
                lista.add(pagoEscala);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    

    
    public boolean modificarPagoEscala(PagoEscala obj){
        String sql="UPDATE pago_escala SET descripcion WHERE id_pago_escala=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setInt(1, obj.getId_pago_escala());
          //  ps.setInt(2, obj.());
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
    
    public PagoEscala BuscarPagoEscala(int id){
        PagoEscala pagoEscala = new PagoEscala();
        String sql ="SELECT * FROM pago_escala WHERE id=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                pagoEscala.setId_pago_escala(rs.getInt("id_pago_escala"));
                //pagoEscala.(rs.getInt(""));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return pagoEscala;
    } 
    
  
    
    
    
    
    
    
    
    
    
    
    
    
}
