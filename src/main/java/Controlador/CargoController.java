/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import DAO.CargoDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.mysql.MySQLCargoDAO;
import Modelo.Cargo;
import Vista.CargoVista;
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
public class CargoController implements ActionListener {

    private final DAOManager manager;
    CargoVista vista = new CargoVista();
    Cargo modelo = new Cargo();
    DefaultTableModel clase = new DefaultTableModel();

    public CargoController(CargoVista v, DAOManager manager) throws DAOException {
        this.manager = manager;
        this.vista = v;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnExcel1.addActionListener(this);

        this.LimpiarTable();
        this.ListarCargo(vista.tableRolesUsuario);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                guardarCargo();
            } catch (DAOException ex) {
                Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizarCargo();
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
    }

    public void guardarCargo() throws DAOException {
        if (camposValidos()) {

            
                CargoDAO dao = manager.getCargoDAO();
                modelo.setDescripcion(vista.txtDescripcion.getText());

                dao.add(modelo);
                //Conexion, consulta con la base de datos

                JOptionPane.showMessageDialog(null, "Cargo Registrado");
                LimpiarTable();
                ListarCargo(vista.tableRolesUsuario);
                LimpiarCargo();
            

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }

    }

    public void actualizarCargo() throws DAOException {
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
                ListarCargo(vista.tableRolesUsuario);
                LimpiarCargo();

                JOptionPane.showMessageDialog(null, "Error al Modificar Cargo");

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }
    public void reporteExcel(){
        Excel.reporteCargo();
    }

    public void nuevoCargo() {
        LimpiarCargo();
    }

    public void ListarCargo(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        CargoDAO dao = manager.getCargoDAO();
        List<Cargo> lista = dao.listAll();
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
