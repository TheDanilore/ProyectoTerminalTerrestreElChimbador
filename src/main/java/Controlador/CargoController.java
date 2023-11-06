/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CargoDAO;
import Modelo.Cargo;
import Vista.CargoVista;
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
public class CargoController implements ActionListener{

    CargoVista vista = new CargoVista();
    Cargo modelo = new Cargo();
    CargoDAO dao = new CargoDAO();
    DefaultTableModel clase = new DefaultTableModel();
    
    
    public CargoController(CargoVista v) {
        this.vista = v;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);

        this.LimpiarTable();
        this.ListarCargo(vista.tableRolesUsuario);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardarCargo();
        }
        if (e.getSource() == vista.btnActualizar) {
            actualizarCargo();
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoCargo();
        }
    }
    
       public void guardarCargo() {
        if (camposValidos()) {

            modelo.setDescripcion(vista.txtDescripcion.getText());

            //Conexion, consulta con la base de datos
            if (dao.registrarCargo(modelo)) {
                JOptionPane.showMessageDialog(null, "Cargo Registrado");
                LimpiarTable();
                ListarCargo(vista.tableRolesUsuario);
                LimpiarCargo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Cargo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarCargo() {
        if ("".equals(vista.txtIdRolesUsuario.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_cargo(Integer.parseInt(vista.txtIdRolesUsuario.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());
                

                //Conexion, consulta con la base de datos
                if (dao.modificarCargo(modelo)) {
                    JOptionPane.showMessageDialog(null, "Cargo Modificado");
                    LimpiarTable();
                    ListarCargo(vista.tableRolesUsuario);
                    LimpiarCargo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Cargo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }
    
       public void nuevoCargo() {
        LimpiarCargo();
    }

    public void ListarCargo(JTable tabla) {
        clase = (DefaultTableModel) tabla.getModel();
        List<Cargo> lista = dao.listarCargo();
        Object[] ob = new Object[2];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_cargo();
            ob[1] = lista.get(i).getDescripcion();

            clase.addRow(ob);
        }
        vista.tableRolesUsuario.setModel(clase);
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

    
}
