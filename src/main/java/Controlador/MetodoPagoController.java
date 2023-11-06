/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.MetodoPagoDAO;
import Modelo.MetodoPago;
import Vista.MetodoPagoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilore
 */
public class MetodoPagoController implements ActionListener {

    MetodoPagoVista vista = new MetodoPagoVista();
    MetodoPago modelo = new MetodoPago();
    MetodoPagoDAO dao = new MetodoPagoDAO();
    DefaultTableModel clase = new DefaultTableModel();

    public MetodoPagoController(MetodoPagoVista v) {
        this.vista = v;
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
            guardarMetodoPago();
        }
        if (e.getSource() == vista.btnActualizar) {
            actualizarMetodoPago();
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoMetodoPago();
        }
        if (e.getSource() == vista.btnEliminarMetodoPago) {
            eliminarMetodoPago();
        }
    }

    public void guardarMetodoPago() {
        if (camposValidos()) {

            modelo.setDescripcion(vista.txtDescripcion.getText());

            //Conexion, consulta con la base de datos
            if (dao.registrarMetodoPago(modelo)) {
                JOptionPane.showMessageDialog(null, "Metodo de Pago Registrado");
                LimpiarTable();
                ListarMetodoPago(vista.tableMetodoPago);
                LimpiarMetodoPago();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Metodo de Pago");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarMetodoPago() {
        if ("".equals(vista.txtIdMetodoPago.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_metodo_pago(Integer.parseInt(vista.txtIdMetodoPago.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());

                //Conexion, consulta con la base de datos
                if (dao.modificarMetodoPago(modelo)) {
                    JOptionPane.showMessageDialog(null, "Metodo de pago Modificado");
                    LimpiarTable();
                    ListarMetodoPago(vista.tableMetodoPago);
                    LimpiarMetodoPago();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Metodo de Pago");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void eliminarMetodoPago() {
        if (!"".equals(vista.txtIdMetodoPago.getText())) {

            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar");

            if (pregunta == 0) {
                int ID = Integer.parseInt(vista.txtIdMetodoPago.getText());
                
                if (dao.eliminarMetodoPago(ID)) {

                    JOptionPane.showMessageDialog(null, "Se borro el metodo de pago");
                    LimpiarTable();
                    ListarMetodoPago(vista.tableMetodoPago);
                    LimpiarMetodoPago();
                } else {

                    JOptionPane.showMessageDialog(null, "Error al borrar metodo de pago");
                }
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

    public void ListarMetodoPago(JTable tabla) {
        clase = (DefaultTableModel) tabla.getModel();
        List<MetodoPago> lista = dao.listarMetodoPago();
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
