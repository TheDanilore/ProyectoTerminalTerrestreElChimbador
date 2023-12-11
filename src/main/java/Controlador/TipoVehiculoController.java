/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.TipoVehiculoPagoDAO;
import Modelo.TipoVehiculoPago;
import Vista.TipoVehiculoVista;
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
public class TipoVehiculoController implements MouseListener {

    private DAOManager manager;

    TipoVehiculoVista vista = new TipoVehiculoVista();
    TipoVehiculoPago modelo = new TipoVehiculoPago();
    DefaultTableModel clase = new DefaultTableModel();

    public TipoVehiculoController(TipoVehiculoVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnGuardar.addMouseListener(this);
        this.vista.btnActualizar.addMouseListener(this);
        this.vista.btnNuevo.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.tableTipoVehiculo.addMouseListener(this);
        this.LimpiarTable();
        this.ListarTipoVehiculo(vista.tableTipoVehiculo);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                guardarTipoVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(TipoVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizarTipoVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(TipoVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoTipoVehiculo();
        }
        if (e.getSource() == vista.btnEliminar) {
            try {
                eliminarTipoVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(TipoVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }

        if (e.getSource() == vista.tableTipoVehiculo) {
            int fila = vista.tableTipoVehiculo.rowAtPoint(e.getPoint());

            vista.txtIdTipoVehiculo.setText(vista.tableTipoVehiculo.getValueAt(fila, 0).toString());
            vista.txtDescripcion.setText(vista.tableTipoVehiculo.getValueAt(fila, 1).toString());
            vista.txtTarifa.setText(vista.tableTipoVehiculo.getValueAt(fila, 2).toString());
        }
    }

    public void reporteExcel() {
        Excel.reporteTipoVehiculo();
    }

    public void guardarTipoVehiculo() throws DAOException {
        if (camposValidos()) {

            modelo.setDescripcion(vista.txtDescripcion.getText());

            //Conexion, consulta con la base de datos
            TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();
            dao.add(modelo);

            JOptionPane.showMessageDialog(null, "Tipo de Vehículo Registrado");
            LimpiarTable();
            ListarTipoVehiculo(vista.tableTipoVehiculo);
            LimpiarTipoVehiculo();

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarTipoVehiculo() throws DAOException {
        if ("".equals(vista.txtIdTipoVehiculo.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_tipo_vehiculo_pago(Integer.parseInt(vista.txtIdTipoVehiculo.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());
                modelo.setTarifa(Double.parseDouble(vista.txtTarifa.getText()));

                //Conexion, consulta con la base de datos
                TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();
                dao.update(modelo);

                JOptionPane.showMessageDialog(null, "Tipo de Vehículo Modificado");
                LimpiarTable();
                ListarTipoVehiculo(vista.tableTipoVehiculo);
                LimpiarTipoVehiculo();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void eliminarTipoVehiculo() throws DAOException {
        if (!"".equals(vista.txtIdTipoVehiculo.getText())) {

            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar");

            if (pregunta == 0) {
                int ID = Integer.parseInt(vista.txtIdTipoVehiculo.getText());

                TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();
                dao.delete(ID);

                JOptionPane.showMessageDialog(null, "Se borro el Tipo de Vehículo");
                LimpiarTable();
                ListarTipoVehiculo(vista.tableTipoVehiculo);
                LimpiarTipoVehiculo();

            } else {
                LimpiarTipoVehiculo();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void nuevoTipoVehiculo() {
        LimpiarTipoVehiculo();
    }

    public void ListarTipoVehiculo(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();
        List<TipoVehiculoPago> lista = dao.listAll();
        Object[] ob = new Object[3];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_tipo_vehiculo_pago();
            ob[1] = lista.get(i).getDescripcion();
            ob[2] = lista.get(i).getTarifa();
            clase.addRow(ob);
        }
        vista.tableTipoVehiculo.setModel(clase);
    }

    public void LimpiarTipoVehiculo() {
        vista.txtIdTipoVehiculo.setText("");
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
        TextPrompt descripcion = new TextPrompt("Tipo de Vehiculo", vista.txtDescripcion);
        TextPrompt tarifa = new TextPrompt("Tarifa de Pago", vista.txtTarifa);
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
