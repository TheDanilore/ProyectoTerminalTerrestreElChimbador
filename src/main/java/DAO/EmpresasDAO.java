/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.EmpresasModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class EmpresasDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;


    public boolean RegistrarEmpresas(EmpresasModelo empresas) {
        String sql = "INSERT INTO empresa (ruc, razon_social, nombre_comercial) VALUES (?,?,?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setLong(1, empresas.getRuc());
            ps.setString(2, empresas.getRazonSocial());
            ps.setString(3, empresas.getNombreComercial());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarEmpresa() {
        List<EmpresasModelo> listarEmpresasModelos = new ArrayList();
        String sql = "SELECT * FROM empresa";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpresasModelo empresasModelo = new EmpresasModelo();
                empresasModelo.setId_empresa(rs.getInt("id_empresa"));
                empresasModelo.setRuc(rs.getLong("ruc"));
                empresasModelo.setRazonSocial(rs.getString("razon_social"));
                empresasModelo.setNombreComercial(rs.getString("nombre_comercial"));
                empresasModelo.setId_estado(rs.getInt("id_estado"));

                listarEmpresasModelos.add(empresasModelo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return listarEmpresasModelos;
    }

    public boolean BajaActivarEmpresa(EmpresasModelo empresasModelo) {
        String sql = "UPDATE empresa SET id_estado = ? WHERE id_empresa = ?;";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, empresasModelo.getId_estado());
            ps.setInt(2, empresasModelo.getId_empresa());
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
    }

    public boolean ModificarEmpresa(EmpresasModelo empresasModelo) {
        String sql = "UPDATE empresa SET ruc=?, razon_social=?, nombre_comercial=? WHERE id_empresa=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, empresasModelo.getRuc());
            ps.setString(2, empresasModelo.getRazonSocial());
            ps.setString(3, empresasModelo.getNombreComercial());
            ps.setInt(4, empresasModelo.getId_empresa());
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

    public EmpresasModelo BuscarEmpresa(int id) {
        EmpresasModelo empresasModelo = new EmpresasModelo();
        String sql = "SELECT * FROM empresa WHERE id_empresa=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empresasModelo.setId_empresa(rs.getInt("id_empresa"));
                empresasModelo.setRuc(rs.getInt("ruc"));
                empresasModelo.setRazonSocial(rs.getString("razon_social"));
                empresasModelo.setNombreComercial(rs.getString("nombre_comercial"));
                empresasModelo.setId_estado(rs.getInt("id_estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return empresasModelo;
    }

    

}
