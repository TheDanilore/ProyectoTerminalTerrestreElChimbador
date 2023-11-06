
package DAO;

/**
 *
 * @author qtaxe
 */
import Modelo.TipoVehiculoPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;




public class TipoVehiculoPagoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean registrarTipoVehiculoPago(TipoVehiculoPago obj){
        String sql = "INSERT INTO tipo_vehiculo_pago (descripcion) VALUES (?)";
        
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
    
    public List<TipoVehiculoPago> listarTipoVehiculoPago(){
        List<TipoVehiculoPago> lista = new ArrayList();
        String sql="SELECT * FROM tipo_vehiculo_pago";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                TipoVehiculoPago tipoVehiculoPago = new TipoVehiculoPago();
                tipoVehiculoPago.setId_tipo_vehiculo_pago(rs.getInt("id_tipo_vehiculo_pago"));
                tipoVehiculoPago.setDescripcion(rs.getString("descripcion"));
                
                lista.add(tipoVehiculoPago);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return lista;
    }
    
    public boolean modificarTipoVehiculoPago(TipoVehiculoPago obj){
        String sql="UPDATE tipo_vehiculo_pago SET descripcion=? WHERE id_tipo_vehiculo_pago=?";
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
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
    
    public TipoVehiculoPago buscarTipoVehiculoPorID(int id){
        TipoVehiculoPago tipoVehiculoPago = new TipoVehiculoPago();
        String sql ="SELECT * FROM tipo_vehiculo_pago WHERE id_tipo_vehiculo_pago=?";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                tipoVehiculoPago.setId_tipo_vehiculo_pago(rs.getInt("id_tipo_vehiculo_pago"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return tipoVehiculoPago;
    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
}
