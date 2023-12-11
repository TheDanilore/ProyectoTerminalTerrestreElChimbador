/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Evento;
import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.EmpresasDAO;
import DAO.mysql.MySQLEmpresasDAO;
import Modelo.Empresas;
import Vista.EmpresasAdminVista;
import java.awt.KeyEventDispatcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class EmpresaController implements MouseListener {

    Evento event = new Evento();

    private DAOManager manager;
    Empresas modelo = new Empresas();
    EmpresasAdminVista vista = new EmpresasAdminVista();
    DefaultTableModel clase = new DefaultTableModel();

    public EmpresaController(EmpresasAdminVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnListar.addMouseListener(this);
        this.vista.btnGuardarEmpre.addMouseListener(this);
        this.vista.btnActualizarEmpre.addMouseListener(this);
        this.vista.btnDarBajaEmpre.addMouseListener(this);
        this.vista.btnActivarEmpre.addMouseListener(this);
        this.vista.btnNuevoEmpre.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.tableEmpresa.addMouseListener(this);
        LimpiarTable();
        listarEmpresas(vista.tableEmpresa);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
        if (e.getSource() == vista.tableEmpresa) {
            int fila = vista.tableEmpresa.rowAtPoint(e.getPoint());

            vista.txtIdEmpresa.setText(vista.tableEmpresa.getValueAt(fila, 0).toString());
            vista.txtRucEmpresa.setText(vista.tableEmpresa.getValueAt(fila, 1).toString());
            vista.txtRazonEmpresa.setText(vista.tableEmpresa.getValueAt(fila, 2).toString());
            vista.txtNombreComercialEmpresa.setText(vista.tableEmpresa.getValueAt(fila, 3).toString());
        }
    }

    public void reporteExcel() {
        Excel.reporteEmpresa();
    }

    //Metodo para registar empresa
    public void guardarEmpresa() throws DAOException {
        if (camposValidos()) {

            modelo.setRuc(Long.parseLong(vista.txtRucEmpresa.getText()));
            modelo.setRazon_social(vista.txtRazonEmpresa.getText());
            modelo.setNombre_comercial(vista.txtNombreComercialEmpresa.getText());

            //Conexion, consulta con la base de datos
            EmpresasDAO dao = manager.getEmpresasDAO();
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

                EmpresasDAO dao = manager.getEmpresasDAO();
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

                EmpresasDAO dao = manager.getEmpresasDAO();
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

                EmpresasDAO dao = manager.getEmpresasDAO();
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
        EmpresasDAO dao = manager.getEmpresasDAO();
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

    public void marcaAgua() {
        TextPrompt ruc = new TextPrompt("Numero de RUC", vista.txtRucEmpresa);
        TextPrompt razon = new TextPrompt("Razon Social", vista.txtRazonEmpresa);
        TextPrompt nombreComercial = new TextPrompt("Nombre Comercial", vista.txtNombreComercialEmpresa);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
