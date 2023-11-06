/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.VehiculoDAO;
import Modelo.VehiculoModelo;
import Vista.VehiculosAdminVista;
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
public class VehiculoController implements ActionListener {
    
    VehiculoModelo modelo = new VehiculoModelo();
    VehiculosAdminVista vista = new VehiculosAdminVista();
    VehiculoDAO dao = new VehiculoDAO();
    DefaultTableModel clase = new DefaultTableModel();

    public VehiculoController(VehiculosAdminVista v) {
        this.vista=v;
        this.vista.btnGuardar.addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista.btnGuardar) {
            guardarVehiculo();
        }
        if (e.getSource()==vista.btnDarBaja) {
            guardarVehiculo();
        }
    }
    
    
    public void guardarVehiculo(){
        if (camposValidos()) {

            modelo.setPlaca_vehiculo(vista.txtPlacaVehiculo.getText());

            /*if ("Bus de Transporte".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setTipo_vehiculo;
            }
            if ("Camion de Carga".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setId_tipo_vehiculo(2);
            }
            if ("Vehiculo del Personal".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setId_tipo_vehiculo(3);
            }
            if ("Vehiculo Particular".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setId_tipo_vehiculo(4);
            }
            if ("Otro Vehiculo".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setId_tipo_vehiculo(5);
            }*/
            
            //Conexion, consulta con la base de datos
            if (dao.RegistrarVehiculo(modelo)) {
                JOptionPane.showMessageDialog(null, "Vehiculo Registrado");
                LimpiarTable();
                ListarVehiculos(vista.tableVehiculo);
                LimpiarVehiculo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Vehiculo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }
    
    public void actualizarVehiculo(){
        if ("".equals(vista.txtIdVehiculo.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_vehiculo(Integer.parseInt(vista.txtIdVehiculo.getText()));
                modelo.setPlaca_vehiculo(vista.txtPlacaVehiculo.getText());
                

                
                //Conexion, consulta con la base de datos
                if (dao.ModificarVehiculo(modelo)) {
                    JOptionPane.showMessageDialog(null, "Vehiculo Modificado");
                    LimpiarTable();
                    ListarVehiculos(vista.tableVehiculo);
                    LimpiarVehiculo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Vehiculo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    } 
    
    
    public void bajaVehiculo(){
        if (!"".equals(vista.txtIdVehiculo.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja el Vehiculo");
            if (pregunta == 0) {
                modelo.setId_vehiculo(Integer.parseInt(vista.txtIdVehiculo.getText()));
                //modelo.setId_estado(0);
                if (dao.BajaActivarVehiculo(modelo)) {

                    JOptionPane.showMessageDialog(null, "Se dio de baja el Vehiculo");
                    LimpiarTable();
                    ListarVehiculos(vista.tableVehiculo);
                    LimpiarVehiculo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Dar de Baja el Vehiculo");
                }
            } else {
                LimpiarVehiculo();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
    public void activarVehiculo(){
        if (!"".equals(vista.txtIdVehiculo.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar el Vehiculo");
            if (pregunta == 0) {
                modelo.setId_vehiculo(Integer.parseInt(vista.txtIdVehiculo.getText()));
                //modelo.setId_estado(1);
                if (dao.BajaActivarVehiculo(modelo)) {

                    JOptionPane.showMessageDialog(null, "Se Activo el Vehiculo");
                    LimpiarTable();
                    ListarVehiculos(vista.tableVehiculo);
                    LimpiarVehiculo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al  Activar el Vehiculo");
                }
            } else {
                LimpiarVehiculo();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
    public void nuevoVehiculo(){
        LimpiarVehiculo();
    }
    
    public void ListarVehiculos(JTable tabla) {
        clase = (DefaultTableModel) tabla.getModel();
        List<VehiculoModelo> lista = dao.ListarVehiculo();
        Object[] ob = new Object[4];
        

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_vehiculo();
            ob[1] = lista.get(i).getPlaca_vehiculo();
            ob[2] = lista.get(i).getTipo_vehiculo().getDescripcion();
            ob[3] = lista.get(i).getEstado().getDescripcion();
            
            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
    }

    public void LimpiarVehiculo() {
        vista.txtIdVehiculo.setText("");
        vista.txtPlacaVehiculo.setText("");
        vista.cbxTipoVehiculo.setSelectedItem(null);

    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public boolean camposValidos() {
        return !vista.txtPlacaVehiculo.getText().isEmpty()
                && vista.cbxTipoVehiculo.getSelectedItem() != null;
    }


}
