
package Controlador;

import Clases.Excel;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.TipoVehiculoPagoDAO;
import DAO.VehiculoDAO;
import DAO.mysql.MySQLVehiculoDAO;
import Modelo.TipoVehiculoPago;
import Modelo.Vehiculo;
import Vista.VehiculosAdminVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public final class VehiculoController implements ActionListener {

    private DAOManager manager;
    
    Vehiculo modelo = new Vehiculo();
    VehiculosAdminVista vista = new VehiculosAdminVista();
    DefaultTableModel clase = new DefaultTableModel();

    public VehiculoController(VehiculosAdminVista v,DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager=manager;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActivar.addActionListener(this);
        this.vista.btnDarBaja.addActionListener(this);
        this.vista.btnExcel1.addActionListener(this);
        this.LimpiarTable();
        this.ListarVehiculos(vista.tableVehiculo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                guardarVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizarVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoVehiculo();
        }
        if (e.getSource() == vista.btnActivar) {
            try {
                activarVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnDarBaja) {
            try {
                bajaVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(VehiculoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
    }
    
    public void reporteExcel(){
        Excel.reporteVehiculo();
    }

    public void guardarVehiculo() throws DAOException {
        if (camposValidos()) {

            modelo.setPlaca_vehiculo(vista.txtPlacaVehiculo.getText());

            if ("Bus de Transporte".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setTipo_vehiculo(1);
            }
            if ("Camion de Carga".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setTipo_vehiculo(2);
            }
            if ("Vehiculo del Personal".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setTipo_vehiculo(3);
            }
            if ("Vehiculo Particular".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setTipo_vehiculo(4);
            }
            if ("Otro Vehiculo".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                modelo.setTipo_vehiculo(5);
            }

            //Conexion, consulta con la base de datos
            VehiculoDAO dao = manager.getVehiculoDAO();
            dao.add(modelo);
            
                JOptionPane.showMessageDialog(null, "Vehiculo Registrado");
                LimpiarTable();
                ListarVehiculos(vista.tableVehiculo);
                LimpiarVehiculo();
            
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarVehiculo() throws DAOException {
        if ("".equals(vista.txtIdVehiculo.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_vehiculo(Integer.parseInt(vista.txtIdVehiculo.getText()));
                modelo.setPlaca_vehiculo(vista.txtPlacaVehiculo.getText());

                modelo.setPlaca_vehiculo(vista.txtPlacaVehiculo.getText());

                if ("Bus de Transporte".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                    modelo.setTipo_vehiculo(1);
                }
                if ("Camion de Carga".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                    modelo.setTipo_vehiculo(2);
                }
                if ("Vehiculo del Personal".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                    modelo.setTipo_vehiculo(3);
                }
                if ("Vehiculo Particular".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                    modelo.setTipo_vehiculo(4);
                }
                if ("Otro Vehiculo".equals(vista.cbxTipoVehiculo.getSelectedItem().toString())) {
                    modelo.setTipo_vehiculo(5);
                }

                //Conexion, consulta con la base de datos
                VehiculoDAO dao = manager.getVehiculoDAO();
                dao.update(modelo);
                
                    JOptionPane.showMessageDialog(null, "Vehiculo Modificado");
                    LimpiarTable();
                    ListarVehiculos(vista.tableVehiculo);
                    LimpiarVehiculo();
                
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void bajaVehiculo() throws DAOException {
        if (!"".equals(vista.txtIdVehiculo.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja el Vehiculo");
            if (pregunta == 0) {
                modelo.setId_vehiculo(Integer.parseInt(vista.txtIdVehiculo.getText()));
                modelo.setEstado(0);
                VehiculoDAO dao = manager.getVehiculoDAO();
                dao.disable(modelo);
                

                    JOptionPane.showMessageDialog(null, "Se dio de baja el Vehiculo");
                    LimpiarTable();
                    ListarVehiculos(vista.tableVehiculo);
                    LimpiarVehiculo();
                
            } else {
                LimpiarVehiculo();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void activarVehiculo() throws DAOException {
        if (!"".equals(vista.txtIdVehiculo.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar el Vehiculo");
            if (pregunta == 0) {
                modelo.setId_vehiculo(Integer.parseInt(vista.txtIdVehiculo.getText()));
                modelo.setEstado(1);
                VehiculoDAO dao = manager.getVehiculoDAO();
                dao.disable(modelo);
                

                    JOptionPane.showMessageDialog(null, "Se Activo el Vehiculo");
                    LimpiarTable();
                    ListarVehiculos(vista.tableVehiculo);
                    LimpiarVehiculo();
                
            } else {
                LimpiarVehiculo();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void nuevoVehiculo() {
        LimpiarVehiculo();
    }

    public void ListarVehiculos(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        VehiculoDAO dao = manager.getVehiculoDAO();
        List<Vehiculo> lista = dao.listAll();
        Object[] ob = new Object[4];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_vehiculo();
            ob[1] = lista.get(i).getPlaca_vehiculo();
            ob[2] = lista.get(i).getTipo_vehiculo();

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

            ob[3] = lista.get(i).getEstado();
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
    
    private void llenarTipoVehiculo() throws DAOException{
        TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();
        
        ArrayList<TipoVehiculoPago> lista = (ArrayList<TipoVehiculoPago>) dao.listAll();
        
        
        //int idselect = 1;
        vista.cbxTipoVehiculo.removeAllItems();
        
        
        for (int i = 0; i < lista.size(); i++) {
            vista.cbxTipoVehiculo.addItem(lista.get(i).getDescripcion());
        }
        
        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }

}
