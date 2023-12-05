/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOException;
import DAO.DAOManager;
import DAO.MetodoPagoDAO;
import DAO.PagoDAO;
import DAO.RegistroEntradaDAO;
import Modelo.MetodoPago;
import Modelo.Pago;
import Modelo.RegistroEntrada;
import Vista.PagoIngreso;
import Vista.RegistroEntradaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilore
 */
public class PagoIngresoController implements ActionListener{

    private DAOManager manager;
    PagoIngreso vista = new PagoIngreso();
    Pago modelo = new Pago();
    RegistroEntrada modeloEntrada = new RegistroEntrada();
    
    public PagoIngresoController(PagoIngreso v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnPago.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        llenarMetodoPago();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnPago) {
            try {
                guardar();
                guardarRegistroEntrada();
                this.vista.setVisible(false);
            } catch (DAOException ex) {
                Logger.getLogger(MetodoPagoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnCancelar) {
            try {
                cancelar();
            } catch (DAOException ex) {
                Logger.getLogger(PagoIngresoController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    

    public void setTextosEnTextFieldB(String texto1, String texto2, String texto3,String texto4,String texto5,String texto6) throws DAOException {
        vista.txtDni.setText(texto1);
        vista.txtConductor.setText(texto2);
        vista.txtPlaca.setText(texto3);
        vista.txtTipoVehiculo.setText(texto4);
        vista.txtDestino.setText(texto5);
        vista.txtMontoPago.setText(texto6);
    }
    
    public void guardarRegistroEntrada() throws DAOException {
        if (camposValidos()) {

            modeloEntrada.setDni(Long.parseLong(vista.txtDni.getText()));
            modeloEntrada.setConductor(vista.txtConductor.getText());
            modeloEntrada.setVehiculo(vista.txtPlaca.getText());
            modeloEntrada.setTipo_vehiculo(vista.txtTipoVehiculo.getText());
            modeloEntrada.setDestino(vista.txtDestino.getText());
            modeloEntrada.setPago(Double.parseDouble(vista.txtMontoPago.getText()));

            
            
            //Conexion, consulta con la base de datos
            RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
            dao.add(modeloEntrada);

            JOptionPane.showMessageDialog(null, "Ingreso Registrado con Exito");
            

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }
    
    public void guardar() throws DAOException {
        if (camposValidos()) {

            
            modelo.setDni_conductor(Long.parseLong(vista.txtDni.getText()));
            modelo.setConductor(vista.txtConductor.getText());
            modelo.setPlaca(vista.txtPlaca.getText());
            modelo.setTipo_vehiculo(vista.txtTipoVehiculo.getText());
            modelo.setDestino(vista.txtTipoVehiculo.getText());
            modelo.setMonto(Double.parseDouble(vista.txtMontoPago.getText()));
            
            String metodo=vista.cbxMetodoPago.getSelectedItem().toString();
            if ("Pago Efectivo".equalsIgnoreCase(metodo)) {
                modelo.setId_metodo_pago(1);
            }
            
            //Conexion, consulta con la base de datos
            PagoDAO dao = manager.getPagoDAO();
            dao.add(modelo);

            JOptionPane.showMessageDialog(null, "Pago Registrado");
            

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }
    
    public void cancelar() throws DAOException {
        

            vista.setVisible(false);
        
    }
    
    public boolean camposValidos() {
        return !vista.txtConductor.getText().isEmpty()
                && !vista.txtDni.getText().isEmpty()
                && !vista.txtPlaca.getText().isEmpty()
                && !vista.txtMontoPago.getText().isEmpty()
                && !vista.txtConductor.getText().isEmpty();
    }
    
    
    private void llenarMetodoPago() throws DAOException {

        MetodoPagoDAO dao = manager.getMetodoPagoDAO();

        List<MetodoPago> lista = (ArrayList<MetodoPago>) dao.listAll();

        //int idselect = 1;
        vista.cbxMetodoPago.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            vista.cbxMetodoPago.addItem(lista.get(i).getDescripcion());
        }

    }
    
    
}
