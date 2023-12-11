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
import DAO.VehiculoDAO;
import Modelo.TipoVehiculoPago;
import Modelo.Vehiculo;
import Vista.ConsultarVehiculoVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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
public class ConsultarVehiculoController implements MouseListener,ActionListener {

    private String tipoVehiculoActual;

    TipoVehiculoPago tipoVehiculoPago = new TipoVehiculoPago();

    private DAOManager manager;

    Vehiculo modelo = new Vehiculo();
    ConsultarVehiculoVista vista = new ConsultarVehiculoVista();
    DefaultTableModel clase = new DefaultTableModel();

    public ConsultarVehiculoController(ConsultarVehiculoVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnBuscar.addMouseListener(this);
        this.vista.btnBuscarTipoVehiculo.addMouseListener(this);
        this.vista.btnListar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.cbxTipoVehiculo.addActionListener(this);
        this.LimpiarTable();
        this.ListarVehiculos(vista.tableVehiculo);
        marcaAgua();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.cbxTipoVehiculo) {
            try {
                obtenerIdTipoVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
        if (e.getSource() == vista.btnBuscarTipoVehiculo) {

            try {
                LimpiarTable();
                ListarByTipovehiculo(vista.tableVehiculo);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnBuscar) {
            try {
                LimpiarTable();
                ListarByPlaca(vista.tableVehiculo);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnListar) {
            try {
                LimpiarTable();
                ListarVehiculos(vista.tableVehiculo);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarVehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    public void reporteExcel() {
        Excel.reporteVehiculo();
    }

    public void ListarVehiculos(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        VehiculoDAO dao = manager.getVehiculoDAO();
        List<Vehiculo> lista = dao.listAll();
        Object[] ob = new Object[4];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_vehiculo();
            ob[1] = lista.get(i).getPlaca_vehiculo();
            //ob[2] = lista.get(i).getTipo_vehiculo();

            if (lista.get(i).getTipo_vehiculo() == 1) {
                ob[2] = "Bus de Transporte";
            }
            if (lista.get(i).getTipo_vehiculo() == 2) {
                ob[2] = "Camion de Carga";
            }
            if (lista.get(i).getTipo_vehiculo() == 3) {
                ob[2] = "Vehiculo del Personal";
            }
            if (lista.get(i).getTipo_vehiculo() == 4) {
                ob[2] = "Vehiculo Particular";
            }
            if (lista.get(i).getTipo_vehiculo() == 5) {
                ob[2] = "Otro Vehiculo";
            }

            //ob[3] = lista.get(i).getEstado();
            //estado
            if (lista.get(i).getEstado() == 1) {
                ob[3] = "Activo";
            }
            if (lista.get(i).getEstado() == 0) {
                ob[3] = "Deshabilitado";
            }

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
        llenarTipoVehiculo();
    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public void ListarByPlaca(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        VehiculoDAO dao = manager.getVehiculoDAO();
        String placa = vista.txtPlaca.getText();
        Vehiculo lista = dao.getByPlacaVehiculo(placa);
        
        if (lista!=null) {
            Object[] ob = new Object[4];

        for (int i = 0; i < 1; i++) {
            ob[0] = lista.getId_vehiculo();
            ob[1] = lista.getPlaca_vehiculo();
            //ob[2] = lista.get(i).getTipo_vehiculo();

            if (lista.getTipo_vehiculo() == 1) {
                ob[2] = "Bus de Transporte";
            }
            if (lista.getTipo_vehiculo() == 2) {
                ob[2] = "Camion de Carga";
            }
            if (lista.getTipo_vehiculo() == 3) {
                ob[2] = "Vehiculo del Personal";
            }
            if (lista.getTipo_vehiculo() == 4) {
                ob[2] = "Vehiculo Particular";
            }
            if (lista.getTipo_vehiculo() == 5) {
                ob[2] = "Otro Vehiculo";
            }

            //ob[3] = lista.get(i).getEstado();
            //estado
            if (lista.getEstado() == 1) {
                ob[3] = "Activo";
            }
            if (lista.getEstado() == 0) {
                ob[3] = "Deshabilitado";
            }

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
        }
        
        
    }

    private void obtenerIdTipoVehiculo() throws DAOException {
        if (!"".equals(vista.cbxTipoVehiculo.getSelectedItem())) {

            String nombre = vista.cbxTipoVehiculo.getSelectedItem().toString();

            TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();

            // Obtener el conductor por su número de documento
            TipoVehiculoPago tipoEncontrado = dao.getByNombreId(nombre);

            // Verificar si se encontró un conductor
            if (tipoEncontrado != null) {
                // Asignar los valores al objeto conductor
                tipoVehiculoPago = tipoEncontrado;
                vista.txtTipo.setText("" + tipoVehiculoPago.getId_tipo_vehiculo_pago());
                tipoVehiculoActual = vista.txtTipo.getText();
                System.out.println("Tipo de Vehiculo actual seleccionado: " + tipoVehiculoActual); // Verifica si el departamento seleccionado es el esperado

            } else {
                vista.txtTipo.setText("");
                JOptionPane.showMessageDialog(null, "El tipo de vehiculo no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un Tipo de Vehiculo");
        }
    }

    public void ListarByTipovehiculo(JTable tabla) throws DAOException {

        clase = (DefaultTableModel) tabla.getModel();
        VehiculoDAO dao = manager.getVehiculoDAO();

        int tipo = Integer.parseInt(vista.txtTipo.getText());

        List<Vehiculo> lista = (List<Vehiculo>) dao.getByTipoVehiculo(tipo);

        Object[] ob = new Object[4];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_vehiculo();
            ob[1] = lista.get(i).getPlaca_vehiculo();
            //ob[2] = lista.get(i).getTipo_vehiculo();

            if (lista.get(i).getTipo_vehiculo() == 1) {
                ob[2] = "Bus de Transporte";
            }
            if (lista.get(i).getTipo_vehiculo() == 2) {
                ob[2] = "Camion de Carga";
            }
            if (lista.get(i).getTipo_vehiculo() == 3) {
                ob[2] = "Vehiculo del Personal";
            }
            if (lista.get(i).getTipo_vehiculo() == 4) {
                ob[2] = "Vehiculo Particular";
            }
            if (lista.get(i).getTipo_vehiculo() == 5) {
                ob[2] = "Otro Vehiculo";
            }

            //ob[3] = lista.get(i).getEstado();
            //estado
            if (lista.get(i).getEstado() == 1) {
                ob[3] = "Activo";
            }
            if (lista.get(i).getEstado() == 0) {
                ob[3] = "Deshabilitado";
            }

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
    }

    private void llenarTipoVehiculo() throws DAOException {
        TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();

        ArrayList<TipoVehiculoPago> lista = (ArrayList<TipoVehiculoPago>) dao.listAll();

        //int idselect = 1;
        vista.cbxTipoVehiculo.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            vista.cbxTipoVehiculo.addItem(lista.get(i).getDescripcion());
        }

        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }

    public void marcaAgua() {
        TextPrompt placa = new TextPrompt("N° Placa", vista.txtPlaca);
        TextPrompt tipoVehiculo = new TextPrompt("ID", vista.txtTipo);
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
