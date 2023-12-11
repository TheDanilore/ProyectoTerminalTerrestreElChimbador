/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.MetodoPagoDAO;
import DAO.mysql.MySQLMetodoPagoDAO;
import Modelo.MetodoPago;
import Vista.MetodoPagoVista;
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
public class MetodoPagoController implements MouseListener {

    private DAOManager manager;
    MetodoPagoVista vista = new MetodoPagoVista();
    MetodoPago modelo = new MetodoPago();

    DefaultTableModel clase = new DefaultTableModel();

    public MetodoPagoController(MetodoPagoVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnGuardar.addMouseListener(this);
        this.vista.btnActualizar.addMouseListener(this);
        this.vista.btnNuevo.addMouseListener(this);
        this.vista.btnEliminar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.tableMetodoPago.addMouseListener(this);
        this.LimpiarTable();
        this.ListarMetodoPago(vista.tableMetodoPago);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                guardarMetodoPago();
            } catch (DAOException ex) {
                Logger.getLogger(MetodoPagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizarMetodoPago();
            } catch (DAOException ex) {
                Logger.getLogger(MetodoPagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoMetodoPago();
        }
        if (e.getSource() == vista.btnEliminar) {
            try {
                eliminarMetodoPago();
            } catch (DAOException ex) {
                Logger.getLogger(MetodoPagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
        if (e.getSource() == vista.tableMetodoPago) {
            int fila = vista.tableMetodoPago.rowAtPoint(e.getPoint());

            vista.txtIdMetodoPago.setText(vista.tableMetodoPago.getValueAt(fila, 0).toString());
            vista.txtDescripcion.setText(vista.tableMetodoPago.getValueAt(fila, 1).toString());
        }
    }

    public void guardarMetodoPago() throws DAOException {
        if (camposValidos()) {

            modelo.setDescripcion(vista.txtDescripcion.getText());

            //Conexion, consulta con la base de datos
            MetodoPagoDAO dao = manager.getMetodoPagoDAO();
            dao.add(modelo);

            JOptionPane.showMessageDialog(null, "Metodo de Pago Registrado");
            LimpiarTable();
            ListarMetodoPago(vista.tableMetodoPago);
            LimpiarMetodoPago();

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarMetodoPago() throws DAOException {
        if ("".equals(vista.txtIdMetodoPago.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_metodo_pago(Integer.parseInt(vista.txtIdMetodoPago.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());

                MetodoPagoDAO dao = manager.getMetodoPagoDAO();
                //Conexion, consulta con la base de datos
                dao.update(modelo);

                JOptionPane.showMessageDialog(null, "Metodo de pago Modificado");
                LimpiarTable();
                ListarMetodoPago(vista.tableMetodoPago);
                LimpiarMetodoPago();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void eliminarMetodoPago() throws DAOException {
        if (!"".equals(vista.txtIdMetodoPago.getText())) {

            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar");

            if (pregunta == 0) {
                int ID = Integer.parseInt(vista.txtIdMetodoPago.getText());
                MetodoPagoDAO dao = manager.getMetodoPagoDAO();
                dao.delete(ID);

                JOptionPane.showMessageDialog(null, "Se borro el metodo de pago");
                LimpiarTable();
                ListarMetodoPago(vista.tableMetodoPago);
                LimpiarMetodoPago();

            } else {
                LimpiarMetodoPago();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void nuevoMetodoPago() {
        LimpiarMetodoPago();
    }

    public void reporteExcel() {
        Excel.reporteMetodoPago();
    }

    public void ListarMetodoPago(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        MetodoPagoDAO dao = manager.getMetodoPagoDAO();
        List<MetodoPago> lista = dao.listAll();
        Object[] ob = new Object[2];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_metodo_pago();
            ob[1] = lista.get(i).getDescripcion();

            clase.addRow(ob);
        }
        vista.tableMetodoPago.setModel(clase);
    }

    public void LimpiarMetodoPago() {
        vista.txtIdMetodoPago.setText("");
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
        TextPrompt descripcion = new TextPrompt("Metodo de Pago", vista.txtDescripcion);
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
