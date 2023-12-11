/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.CargoDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.mysql.MySQLCargoDAO;
import Modelo.Cargo;
import Vista.CargoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilore
 */
public class CargoController implements MouseListener {

    private final DAOManager manager;
    CargoVista vista = new CargoVista();
    Cargo modelo = new Cargo();
    DefaultTableModel clase = new DefaultTableModel();

    public CargoController(CargoVista v, DAOManager manager) throws DAOException {
        this.manager = manager;
        this.vista = v;
        this.vista.btnGuardar.addMouseListener(this);
        this.vista.btnActualizar.addMouseListener(this);
        this.vista.btnNuevo.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.btnDarBaja.addMouseListener(this);
        this.vista.btnActivar.addMouseListener(this);
        this.vista.tableCargo.addMouseListener(this);
        this.LimpiarTable();
        this.ListarCargo(vista.tableCargo);
        
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                guardar();
            } catch (DAOException ex) {
                Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizar();
            } catch (DAOException ex) {
                Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoCargo();
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
        if (e.getSource() == vista.tableCargo) {
            int fila = vista.tableCargo.rowAtPoint(e.getPoint());

            vista.txtIdRolesUsuario.setText(vista.tableCargo.getValueAt(fila, 0).toString());
            vista.txtDescripcion.setText(vista.tableCargo.getValueAt(fila, 1).toString());
        }
    }

    public void guardar() throws DAOException {
        if (camposValidos()) {

            CargoDAO dao = manager.getCargoDAO();
            modelo.setDescripcion(vista.txtDescripcion.getText());

            dao.add(modelo);
            //Conexion, consulta con la base de datos

            JOptionPane.showMessageDialog(null, "Cargo Registrado");
            LimpiarTable();
            ListarCargo(vista.tableCargo);
            LimpiarCargo();

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }

    }

    public void actualizar() throws DAOException {
        if ("".equals(vista.txtIdRolesUsuario.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_cargo(Integer.parseInt(vista.txtIdRolesUsuario.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());

                CargoDAO dao = manager.getCargoDAO();

                dao.update(modelo);
                //Conexion, consulta con la base de datos

                JOptionPane.showMessageDialog(null, "Cargo Modificado");
                LimpiarTable();
                ListarCargo(vista.tableCargo);
                LimpiarCargo();

                JOptionPane.showMessageDialog(null, "Error al Modificar Cargo");

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void activar() throws DAOException {
        if (!"".equals(vista.txtIdRolesUsuario.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar el Cargo");
            if (pregunta == 0) {
                modelo.setId_cargo(Integer.parseInt(vista.txtIdRolesUsuario.getText()));
                modelo.setId_estado(1);

                CargoDAO dao = manager.getCargoDAO();
                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se Activo al Usuario");
                LimpiarTable();
                ListarCargo(vista.tableCargo);
                LimpiarCargo();

            } else {
                LimpiarCargo();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void baja() throws DAOException {
        if (!"".equals(vista.txtIdRolesUsuario.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Dar de Baja el Cargo");
            if (pregunta == 0) {
                modelo.setId_cargo(Integer.parseInt(vista.txtIdRolesUsuario.getText()));
                modelo.setId_estado(0);

                CargoDAO dao = manager.getCargoDAO();
                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se Activo al Usuario");
                LimpiarTable();
                ListarCargo(vista.tableCargo);
                LimpiarCargo();

            } else {
                LimpiarCargo();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void reporteExcel() {
        Excel.reporteCargo();
    }

    public void nuevoCargo() {
        LimpiarCargo();
    }

    public void ListarCargo(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        CargoDAO dao = manager.getCargoDAO();
        List<Cargo> lista = dao.listAll();
        Object[] ob = new Object[3];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_cargo();
            ob[1] = lista.get(i).getDescripcion();
            
            //ob[2] = lista.get(i).getId_estado();
            if (lista.get(i).getId_estado() == 1) {
                ob[2] = "Activo";
            }
            if (lista.get(i).getId_estado() == 0) {
                ob[2] = "Deshabilitado";
            }

            clase.addRow(ob);
        }
        vista.tableCargo.setModel(clase);
    }

    public void LimpiarCargo() {
        vista.txtIdRolesUsuario.setText("");
        vista.txtDescripcion.setText("");
    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public boolean camposValidos() {
        return !vista.txtDescripcion.getText().isEmpty();
    }

    public void marcaAgua() {
        TextPrompt descripcion = new TextPrompt("Nombre del cargo", vista.txtDescripcion);
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
