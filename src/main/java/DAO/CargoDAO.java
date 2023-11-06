/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.Conexion;
import Modelo.Cargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilore
 */
public class CargoDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
        
    public boolean registrarCargo(Cargo obj) {
        String sql = "INSERT INTO cargo (descripcion) VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
           
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.print(e.toString());
            return false;
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    public List<Cargo> listarCargo() {
        List<Cargo> lista = new ArrayList();
        String sql = "SELECT * FROM cargo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cargo cargo = new Cargo();
                cargo.setId_cargo(rs.getInt("id_cargo"));
                cargo.setDescripcion(rs.getString("descripcion"));
                
                lista.add(cargo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return lista;
    }

    /*public boolean bajaActivarCargo(Cargo obj) {
        String sql = "UPDATE cargo SET id_estado = ? WHERE id_cargo = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getEstado().getId_estado());
            ps.setInt(2, usuario.getId_usuarios());
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
    }*/

    public boolean modificarCargo(Cargo obj) {
        String sql = "UPDATE cargo SET descripcion=? WHERE id_cargo=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public Cargo obtenerCargoPorDescripcion(String descripcion) {
        Cargo cargo = new Cargo();
        String sql = "SELECT * FROM cargo WHERE descripcion=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, descripcion);
            rs = ps.executeQuery();
            if (rs.next()) {
                cargo.setId_cargo(rs.getInt("id_cargo"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return cargo;
    }

}
