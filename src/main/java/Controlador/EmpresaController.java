/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOException;
import DAO.mysql.MySQLEmpresasDAO;
import Modelo.Empresas;
import Vista.EmpresasAdminVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilore
 */
public class EmpresaController implements ActionListener {

    MySQLEmpresasDAO dao = new MySQLEmpresasDAO();
    Empresas modelo = new Empresas();
    EmpresasAdminVista vista = new EmpresasAdminVista();
    DefaultTableModel clase = new DefaultTableModel();

    public EmpresaController(EmpresasAdminVista v) throws DAOException {
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
            try {
                listarEmpresas(vista.tableEmpresa);
            } catch (DAOException ex) {
                Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnGuardarEmpre) {
            try {
                guardarEmpresa();
            } catch (DAOException ex) {
                Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizarEmpre) {
            try {
                actualizarEmpresa();
            } catch (DAOException ex) {
                Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnDarBajaEmpre) {
            try {
                bajaEmpresa();
            } catch (DAOException ex) {
                Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActivarEmpre) {
            try {
                activarEmpresa();
            } catch (DAOException ex) {
                Logger.getLogger(EmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevoEmpre) {
            nuevoEmpresa();
        }
    }

    //Metodo para registar empresa
    public void guardarEmpresa() throws DAOException {
        if (camposValidos()) {

            modelo.setRuc(Long.parseLong(vista.txtRucEmpresa.getText()));
            modelo.setRazon_social(vista.txtRazonEmpresa.getText());
            modelo.setNombre_comercial(vista.txtNombreComercialEmpresa.getText());

            //Conexion, consulta con la base de datos
            dao.add(modelo);

            JOptionPane.showMessageDialog(null, "Empresa Registrada");
            LimpiarTable();
            listarEmpresas(vista.tableEmpresa);
            LimpiarEmpresa();

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    //Metodo para actualizar empresa
    public void actualizarEmpresa() throws DAOException {
        if ("".equals(vista.txtIdEmpresa.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_empresa(Integer.parseInt(vista.txtIdEmpresa.getText()));
                modelo.setRuc(Long.parseLong(vista.txtRucEmpresa.getText()));
                modelo.setRazon_social(vista.txtRazonEmpresa.getText());
                modelo.setNombre_comercial(vista.txtNombreComercialEmpresa.getText());

                dao.update(modelo);
                //Conexion, consulta con la base de datos

                JOptionPane.showMessageDialog(null, "Empresa Modificada");
                LimpiarTable();
                listarEmpresas(vista.tableEmpresa);
                LimpiarEmpresa();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    //Metodo para dar de baja empresa (id_estado=0)
    public void bajaEmpresa() throws DAOException {
        if (!"".equals(vista.txtIdEmpresa.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja a la Empresa");
            if (pregunta == 0) {
                modelo.setId_empresa(Integer.parseInt(vista.txtIdEmpresa.getText()));
                modelo.setEstado(0);

                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se dio de baja a la empresa");
                LimpiarTable();
                listarEmpresas(vista.tableEmpresa);
                LimpiarEmpresa();

            } else {
                LimpiarEmpresa();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }

    }

    //Metodo para activar empresa (id_estado=1)
    public void activarEmpresa() throws DAOException {
        if (!"".equals(vista.txtIdEmpresa.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar a la Empresa");
            if (pregunta == 0) {
                modelo.setId_empresa(Integer.parseInt(vista.txtIdEmpresa.getText()));
                modelo.setEstado(1);

                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se Activo a la empresa");
                LimpiarTable();
                listarEmpresas(vista.tableEmpresa);
                LimpiarEmpresa();

            } else {
                LimpiarEmpresa();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    //Metodo para registar Nueva empresa (Limpia los campos)
    public void nuevoEmpresa() {
        LimpiarEmpresa();
    }

    //Metodo para Listar Empresas
    public void listarEmpresas(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        List<Empresas> lista = dao.listAll();
        Object[] object = new Object[5];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_empresa();
            object[1] = lista.get(i).getRuc();
            object[2] = lista.get(i).getRazon_social();
            object[3] = lista.get(i).getNombre_comercial();
            object[4] = lista.get(i).getEstado();

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
