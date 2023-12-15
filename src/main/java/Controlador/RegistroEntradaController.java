/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.TextPrompt;
import DAO.ConductorDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.TipoVehiculoPagoDAO;
import DAO.VehiculoDAO;
import Modelo.Conductor;
import Modelo.RegistroEntrada;
import Modelo.TipoVehiculoPago;
import Modelo.Vehiculo;
import Vista.RegistroIngresoVista;
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
import DAO.RegistroEntradaDAO;

/**
 *
 * @author Danilore
 */
public final class RegistroEntradaController implements MouseListener, ActionListener {

    private String tipoVehiculoDescripcion;

    private final DAOManager manager;
    RegistroIngresoVista vista = new RegistroIngresoVista();
    RegistroEntrada modelo = new RegistroEntrada();
    Conductor conductor = new Conductor();
    Vehiculo vehiculo = new Vehiculo();
    TipoVehiculoPago tipoVehiculo = new TipoVehiculoPago();

    DefaultTableModel clase = new DefaultTableModel();

    public RegistroEntradaController(RegistroIngresoVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnGuardar.addMouseListener(this);
        this.vista.btnActualizar.addMouseListener(this);
        this.vista.btnNuevo.addMouseListener(this);
        this.vista.btnEliminar.addMouseListener(this);
        this.vista.txtDni.addActionListener(this);
        this.vista.txtPlaca.addActionListener(this);
        this.vista.tableVehiculo.addMouseListener(this);
        this.vista.txtIdIngresoVehiculo.setVisible(false);
        this.vista.txtIdTipoVehiculo.setVisible(false);
        this.LimpiarTable();
        this.listar(vista.tableVehiculo);
        marcaAgua();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.txtDni) {
            try {
                obtenerConductorPorDni();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == vista.txtPlaca) {
            try {
                obtenerVehiculoPorPlaca();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.btnGuardar) {

            try {
                guardar();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizar();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {

            nuevo();

        }

        if (e.getSource() == vista.btnEliminar) {
            try {
                eliminar();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.tableVehiculo) {
            int fila = vista.tableVehiculo.rowAtPoint(e.getPoint());

            vista.txtIdIngresoVehiculo.setText(vista.tableVehiculo.getValueAt(fila, 0).toString());
            vista.txtDni.setText(vista.tableVehiculo.getValueAt(fila, 1).toString());
            vista.txtConductor.setText(vista.tableVehiculo.getValueAt(fila, 2).toString());
            vista.txtPlaca.setText(vista.tableVehiculo.getValueAt(fila, 3).toString());
            vista.txtTipoVehiculo.setText(vista.tableVehiculo.getValueAt(fila, 4).toString());
        }

    }

    public void guardar() throws DAOException {
        if (camposValidos()) {

            modelo.setDni(Long.parseLong(vista.txtDni.getText()));
            modelo.setConductor(vista.txtConductor.getText());
            modelo.setVehiculo(vista.txtPlaca.getText());
            modelo.setTipo_vehiculo(vista.txtTipoVehiculo.getText());

            //Conexion, consulta con la base de datos
            RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
            dao.add(modelo);

            JOptionPane.showMessageDialog(null, "Se registró con Exito");
            LimpiarTable();
            listar(vista.tableVehiculo);
            Limpiar();

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");

        }
    }

    public void actualizar() throws DAOException {
        if ("".equals(vista.txtIdIngresoVehiculo.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setDni(Long.parseLong(vista.txtDni.getText()));
                modelo.setConductor(vista.txtConductor.getText());
                modelo.setVehiculo(vista.txtPlaca.getText());
                modelo.setTipo_vehiculo(vista.txtTipoVehiculo.getText());

                //Conexion, consulta con la base de datos
                RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
                dao.update(modelo);

                JOptionPane.showMessageDialog(null, "Ingreso Actualizado con Exito");
                LimpiarTable();
                listar(vista.tableVehiculo);
                Limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void eliminar() throws DAOException {
        if (!"".equals(vista.txtIdIngresoVehiculo.getText())) {

            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar");

            if (pregunta == 0) {
                int ID = Integer.parseInt(vista.txtIdIngresoVehiculo.getText());
                RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
                dao.delete(ID);

                JOptionPane.showMessageDialog(null, "Se borro el registro de entrada");
                LimpiarTable();
                listar(vista.tableVehiculo);
                Limpiar();

            } else {
                Limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void obtenerConductorPorDni() throws DAOException {
        if (!"".equals(vista.txtDni.getText())) {

            long dni = Long.parseLong(vista.txtDni.getText());

            ConductorDAO dao = manager.getConductorDAO();

            // Obtener el conductor por su número de documento
            Conductor conductorEncontrado = dao.getByDniConductor(dni);

            // Verificar si se encontró un conductor
            if (conductorEncontrado.getPrimer_nombre() != null) {
                // Asignar los valores al objeto conductor
                conductor = conductorEncontrado;
                vista.txtConductor.setText("" + conductor.getPrimer_nombre() + " " + conductor.getSegundo_nombre() + " " + conductor.getApellido_paterno() + " " + conductor.getApellido_materno());
            } else {
                vista.txtDni.setText("");
                JOptionPane.showMessageDialog(null, "El Conductor no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el numero de documento");
        }
    }

    public void obtenerVehiculoPorPlaca() throws DAOException {
        if (!"".equals(vista.txtPlaca.getText())) {

            String placa = vista.txtPlaca.getText();

            VehiculoDAO dao = manager.getVehiculoDAO();

            // Obtener el VEHICULO POR SU PLACA
            Vehiculo vehiculoEncontrado = dao.getByPlacaVehiculo(placa);

            // Verificar si se encontró un VEHICULO
            if (vehiculoEncontrado.getId_vehiculo() > 0) {
                // Asignar los valores al objeto VEHICULO
                vehiculo = vehiculoEncontrado;
                vista.txtIdTipoVehiculo.setText("" + vehiculo.getTipo_vehiculo());

                int id = Integer.parseInt(vista.txtIdTipoVehiculo.getText());
                obtenerTipoVehiculo(id);

                //enviar tipo de vehiculo a metodo clacular tarifa
            } else {
                vista.txtDni.setText("");
                JOptionPane.showMessageDialog(null, "El Vehiculo no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la placa del vehiculo");
        }
    }

    public void obtenerTipoVehiculo(int id) throws DAOException {
        if (!"".equals(vista.txtIdTipoVehiculo.getText())) {

            int id_tipoVehiculo = Integer.parseInt(vista.txtIdTipoVehiculo.getText());

            TipoVehiculoPagoDAO dao = manager.getTipoVehiculoPagoDAO();

            // Obtener el conductor por su número de documento
            TipoVehiculoPago tipoEncontrado = dao.getById(id_tipoVehiculo);

            // Verificar si se encontró un conductor
            if (tipoEncontrado != null) {
                // Asignar los valores al objeto conductor
                tipoVehiculo = tipoEncontrado;
                vista.txtTipoVehiculo.setText("" + tipoVehiculo.getDescripcion());
                tipoVehiculoDescripcion = vista.txtTipoVehiculo.getText();
                System.out.println("Tipo Vehiculo actual seleccionado: " + tipoVehiculoDescripcion);

                //
            } else {
                vista.txtDni.setText("");
                JOptionPane.showMessageDialog(null, "El Vehiculo no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la placa del vehiculo");
        }
    }

    public void nuevo() {
        Limpiar();

    }

    public void listar(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
        List<RegistroEntrada> lista = dao.listAll();
        Object[] ob = new Object[7];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_registro_entrada();
            ob[1] = lista.get(i).getDni();
            ob[2] = lista.get(i).getConductor();
            ob[3] = lista.get(i).getVehiculo();
            ob[4] = lista.get(i).getTipo_vehiculo();
            ob[5] = lista.get(i).getFecha_hora_entrada();
            ob[6] = lista.get(i).getUsuario();

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
    }

    public void Limpiar() {
        vista.txtIdIngresoVehiculo.setText("");
        vista.txtDni.setText("");
        vista.txtConductor.setText("");
        vista.txtPlaca.setText("");
        vista.txtIdTipoVehiculo.setText("");
        vista.txtTipoVehiculo.setText("");

    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public boolean camposValidos() {
        return !vista.txtDni.getText().isEmpty()
                && !vista.txtConductor.getText().isEmpty()
                && !vista.txtPlaca.getText().isEmpty()
                && !vista.txtTipoVehiculo.getText().isEmpty();
    }

    public void marcaAgua() {
        TextPrompt dni = new TextPrompt("N° DNI", vista.txtDni);
        TextPrompt conductor = new TextPrompt("Nombre del Conductor", vista.txtConductor);
        TextPrompt placa = new TextPrompt("N° Placa", vista.txtPlaca);
        TextPrompt idTipoVehiculo = new TextPrompt("ID tipo", vista.txtIdTipoVehiculo);
        TextPrompt tipoVehiculo = new TextPrompt("Tipo de Vehiculo", vista.txtTipoVehiculo);
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
