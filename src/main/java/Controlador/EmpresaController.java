/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.EmpresasDAO;
import Modelo.EmpresasModelo;
import Vista.EmpresasAdminVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilore
 */
public class EmpresaController implements ActionListener {

    EmpresasDAO dao = new EmpresasDAO();
    EmpresasModelo modelo = new EmpresasModelo();
    EmpresasAdminVista vista = new EmpresasAdminVista();
    DefaultTableModel clase = new DefaultTableModel();

    public EmpresaController(EmpresasAdminVista v) {
        this.vista = v;
        this.vista.btnListar.addActionListener(this);
        this.vista.btnGuardarEmpre.addActionListener(this);
        this.vista.btnActualizarEmpre.addActionListener(this);
        this.vista.btnDarBajaEmpre.addActionListener(this);
        this.vista.btnActivarEmpre.addActionListener(this);
        this.vista.btnNuevoEmpre.addActionListener(this);
        
        LimpiarTable();
        listarEmpresas(vista.tableEmpresa);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnListar) {
            
        LimpiarTable();
            listarEmpresas(vista.tableEmpresa);
        }
        if (e.getSource() == vista.btnGuardarEmpre) {
            guardarEmpresa();
        }
        if (e.getSource() == vista.btnActualizarEmpre) {
            actualizarEmpresa();
        }
        if (e.getSource() == vista.btnDarBajaEmpre) {
            bajaEmpresa();
        }
        if (e.getSource() == vista.btnActivarEmpre) {
            activarEmpresa();
        }
        if (e.getSource() == vista.btnNuevoEmpre) {
            nuevoEmpresa();
        }
    }
    
    
    //Metodo para registar empresa
    public void guardarEmpresa(){
        if (camposValidos()) {

                modelo.setRuc(Long.parseLong(vista.txtRucEmpresa.getText()));
                modelo.setRazon_social(vista.txtRazonEmpresa.getText());
                modelo.setNombre_comercial(vista.txtNombreComercialEmpresa.getText());

                //Conexion, consulta con la base de datos
                if (dao.RegistrarEmpresas(modelo)) {
                    JOptionPane.showMessageDialog(null, "Empresa Registrada");
                    LimpiarTable();
                    listarEmpresas(vista.tableEmpresa);
                    LimpiarEmpresa();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Registrar Empresa");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");
            }
    }
    
    //Metodo para actualizar empresa
    public void actualizarEmpresa(){
        if ("".equals(vista.txtIdEmpresa.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_empresa(Integer.parseInt(vista.txtIdEmpresa.getText()));
                modelo.setRuc(Long.parseLong(vista.txtRucEmpresa.getText()));
                modelo.setRazon_social(vista.txtRazonEmpresa.getText());
                modelo.setNombre_comercial(vista.txtNombreComercialEmpresa.getText());
                
                //Conexion, consulta con la base de datos
                if (dao.ModificarEmpresa(modelo)) {
                    JOptionPane.showMessageDialog(null, "Empresa Modificada");
                    LimpiarTable();
                    listarEmpresas(vista.tableEmpresa);
                    LimpiarEmpresa();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Empresa");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }
    
    //Metodo para dar de baja empresa (id_estado=0)
    public void bajaEmpresa(){
        if (!"".equals(vista.txtIdEmpresa.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja a la Empresa");
            if (pregunta == 0) {
                modelo.setId_empresa(Integer.parseInt(vista.txtIdEmpresa.getText()));
                //modelo.setEstado(0,"Deshabilitada");
                if (dao.BajaActivarEmpresa(modelo)) {
                    
                    JOptionPane.showMessageDialog(null, "Se dio de baja a la empresa");
                    LimpiarTable();
                    listarEmpresas(vista.tableEmpresa);
                    LimpiarEmpresa();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Dar de Baja a la Empresa");
                }
            }else{
                LimpiarEmpresa();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
        
    }
    
    //Metodo para activar empresa (id_estado=1)
    public void activarEmpresa(){
        if (!"".equals(vista.txtIdEmpresa.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar a la Empresa");
            if (pregunta == 0) {
                modelo.setId_empresa(Integer.parseInt(vista.txtIdEmpresa.getText()));
                //modelo.setEstado(1, "Activa");
                if (dao.BajaActivarEmpresa(modelo)) {
                    
                    JOptionPane.showMessageDialog(null, "Se Activo a la empresa");
                    LimpiarTable();
                    listarEmpresas(vista.tableEmpresa);
                    LimpiarEmpresa();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Activar la Empresa");
                }
            }else{
                LimpiarEmpresa();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
    //Metodo para registar Nueva empresa (Limpia los campos)
    public void nuevoEmpresa(){
        LimpiarEmpresa();
    }
    

    
    
    //Metodo para Listar Empresas
    public void listarEmpresas(JTable tabla) {
        clase = (DefaultTableModel) tabla.getModel();
        List<EmpresasModelo> lista = dao.ListarEmpresa();
        Object[] object = new Object[5];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_empresa();
            object[1] = lista.get(i).getRuc();
            object[2] = lista.get(i).getRazon_social();
            object[3] = lista.get(i).getNombre_comercial();
            object[4] = lista.get(i).getEstado().getDescripcion();
            
            clase.addRow(object);
        }
        vista.tableEmpresa.setModel(clase);
    }

    //Valida si los campos no estan vacios
    public boolean camposValidos() {
        return !vista.txtRucEmpresa.getText().isEmpty()
                && !vista.txtRazonEmpresa.getText().isEmpty()
                && !vista.txtNombreComercialEmpresa.getText().isEmpty();
    }

    public void LimpiarEmpresa() {
        vista.txtIdEmpresa.setText("");
        vista.txtRucEmpresa.setText("");
        vista.txtRazonEmpresa.setText("");
        vista.txtNombreComercialEmpresa.setText("");

    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }
}
