/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.MetodoPagoDAO;
import DAO.mysql.MySQLMetodoPagoDAO;
import Modelo.MetodoPago;
import Vista.MetodoPagoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class MetodoPagoController implements ActionListener {

    private DAOManager manager;
    MetodoPagoVista vista = new MetodoPagoVista();
    MetodoPago modelo = new MetodoPago();

    DefaultTableModel clase = new DefaultTableModel();

    public MetodoPagoController(MetodoPagoVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnEliminarMetodoPago.addActionListener(this);
        this.LimpiarTable();
        this.ListarMetodoPago(vista.tableMetodoPago);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        if (e.getSource() == vista.btnEliminarMetodoPago) {
            try {
                eliminarMetodoPago();
            } catch (DAOException ex) {
                Logger.getLogger(MetodoPagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
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

}
