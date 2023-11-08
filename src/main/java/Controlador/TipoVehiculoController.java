/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.MetodoPagoDAO;
import DAO.TipoVehiculoDAO;
import Modelo.MetodoPago;
import Modelo.TipoVehiculo;
import Vista.MetodoPagoVista;
import Vista.TipoVehiculoVista;
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
public class TipoVehiculoController implements ActionListener{
    TipoVehiculoVista vista = new TipoVehiculoVista();
    TipoVehiculo modelo = new TipoVehiculo();
    TipoVehiculoDAO dao = new TipoVehiculoDAO();
    DefaultTableModel clase = new DefaultTableModel();

    public TipoVehiculoController(TipoVehiculoVista v) {
        this.vista = v;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        //this.vista.btnEliminarMetodoPago.addActionListener(this);
        this.LimpiarTable();
        this.ListarTipoVehiculo(vista.tableTipoVehiculo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardarTipoVehiculo();
        }
        if (e.getSource() == vista.btnActualizar) {
            actualizarTipoVehiculo();
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoTipoVehiculo();
        }
        if (e.getSource() == vista.btnEliminar) {
            eliminarTipoVehiculo();
        }
    }

    public void guardarTipoVehiculo() {
        if (camposValidos()) {

            modelo.setDescripcion(vista.txtDescripcion.getText());

            //Conexion, consulta con la base de datos
            if (dao.registrarTipoVehiculo(modelo)) {
                JOptionPane.showMessageDialog(null, "Tipo de Vehículo Registrado");
                LimpiarTable();
                ListarTipoVehiculo(vista.tableTipoVehiculo);
                LimpiarTipoVehiculo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Tipo de Vehículo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarTipoVehiculo() {
        if ("".equals(vista.txtIdTipoVehiculo.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_tipo_vehiculo(Integer.parseInt(vista.txtIdTipoVehiculo.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());

                //Conexion, consulta con la base de datos
                if (dao.modificarTipoVehiculo(modelo)) {
                    JOptionPane.showMessageDialog(null, "Tipo de Vehículo Modificado");
                    LimpiarTable();
                    ListarTipoVehiculo(vista.tableTipoVehiculo);
                    LimpiarTipoVehiculo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Metodo de Pago");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void eliminarTipoVehiculo() {
        if (!"".equals(vista.txtIdTipoVehiculo.getText())) {

            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar");

            if (pregunta == 0) {
                int ID = Integer.parseInt(vista.txtIdTipoVehiculo.getText());
                
                if (dao.eliminarTipoVehiculo(ID)) {

                    JOptionPane.showMessageDialog(null, "Se borro el Tipo de Vehículo");
                    LimpiarTable();
                    ListarTipoVehiculo(vista.tableTipoVehiculo);
                    LimpiarTipoVehiculo();
                } else {

                    JOptionPane.showMessageDialog(null, "Error al borrar Tipo de Vehículo");
                }
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

    public void ListarTipoVehiculo(JTable tabla) {
        clase = (DefaultTableModel) tabla.getModel();
        List<TipoVehiculo> lista = dao.listarTipoVehiculo();
        Object[] ob = new Object[2];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_tipo_vehiculo();
            ob[1] = lista.get(i).getDescripcion();

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
}
