/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ConductorDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.DepartamentoDAO;
import DAO.DistritoDAO;
import DAO.ProvinciaDAO;
import DAO.RegistroEntradaDAO;
import DAO.TipoVehiculoDAO;
import DAO.VehiculoDAO;
import Modelo.Conductor;
import Modelo.Departamento;
import Modelo.Distrito;
import Modelo.Provincia;
import Modelo.RegistroEntrada;
import Modelo.TipoVehiculo;
import Modelo.Vehiculo;
import Vista.ConductorVista;
import Vista.RegistroEntradaVista;
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
public class RegistroEntradaController implements ActionListener {

    private String departamentoActual;
    private String provinciaActual;
    private String tipoVehiculoActual;

    private DAOManager manager;
    RegistroEntradaVista vista = new RegistroEntradaVista();
    RegistroEntrada modelo = new RegistroEntrada();
    Conductor conductor = new Conductor();
    Vehiculo vehiculo = new Vehiculo();
    TipoVehiculo tipoVehiculo = new TipoVehiculo();
    Departamento departamento = new Departamento();
    Provincia provincia = new Provincia();

    DefaultTableModel clase = new DefaultTableModel();

    public RegistroEntradaController(RegistroEntradaVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.txtDni.addActionListener(this);
        this.vista.btnExcel1.addActionListener(this);
        this.vista.txtPlaca.addActionListener(this);
        this.vista.txtIdTipoVehiculo.addActionListener(this);
        this.vista.cbxDepartamento.addActionListener(this);
        this.vista.cbxProvincia.addActionListener(this);
        this.vista.btnCalcularTarifa.addActionListener(this);
        this.LimpiarTable();
        this.listar(vista.tableVehiculo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                guardar();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            // actualizar();
        }
        if (e.getSource() == vista.btnNuevo) {
            //nuevo();
        }
        if (e.getSource() == vista.txtDni) {
            try {
                obtenerConductorPorDni();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            //excel();
        }

        if (e.getSource() == vista.txtPlaca) {
            try {
                obtenerVehiculoPorPlaca();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.txtIdTipoVehiculo) {
            try {
                obtenerTipoVehiculo();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.cbxDepartamento) {
            try {
                obtenerIdDepartamento();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.cbxProvincia) {
            try {
                obtenerIdProvincia();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnCalcularTarifa) {
            try {
                calcularTarifaPago();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void guardar() throws DAOException {
        if (camposValidos()) {

            modelo.setConductor(vista.txtConductor.getText());
            modelo.setVehiculo(vista.txtPlaca.getText());
            modelo.setDestino(vista.cbxDepartamento.getSelectedItem().toString());
            modelo.setFecha_hora_entrada(vista.txtFechaActual.getText());
            modelo.setPago(vista.txtTarifaPago.getText());

            //Conexion, consulta con la base de datos
            RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
            dao.add(modelo);

            JOptionPane.showMessageDialog(null, "Metodo de Pago Registrado");
            LimpiarTable();
            listar(vista.tableVehiculo);
            LimpiarMetodoPago();

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    /*public void actualizarMetodoPago() throws DAOException {
        if ("".equals(vista.txtIdMetodoPago.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_metodo_pago(Integer.parseInt(vista.txtIdMetodoPago.getText()));
                modelo.setDescripcion(vista.txtDescripcion.getText());

                MetodoPagoDAO dao = manager.getMetodoPagoDAO();
                //Conexion, consulta con la base de datos
                dao.update(modelo);

                JOptionPane.showMessageDialog(null, "Metodo de pago Modificado");
                LimpiarTable();
                ListarMetodoPago(vista.tableMetodoPago);
                LimpiarMetodoPago();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }*/

 /*public void eliminarMetodoPago() throws DAOException {
        if (!"".equals(vista.txtIdMetodoPago.getText())) {

            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Eliminar");

            if (pregunta == 0) {
                int ID = Integer.parseInt(vista.txtIdMetodoPago.getText());
                MetodoPagoDAO dao = manager.getMetodoPagoDAO();
                dao.delete(ID);

                JOptionPane.showMessageDialog(null, "Se borro el metodo de pago");
                LimpiarTable();
                ListarMetodoPago(vista.tableMetodoPago);
                LimpiarMetodoPago();

            } else {
                LimpiarMetodoPago();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }*/
    public void obtenerConductorPorDni() throws DAOException {
        if (!"".equals(vista.txtDni.getText())) {

            long dni = Long.parseLong(vista.txtDni.getText());

            ConductorDAO dao = manager.getConductorDAO();

            // Obtener el conductor por su número de documento
            Conductor conductorEncontrado = dao.getByDniConductor(dni);

            // Verificar si se encontró un conductor
            if (conductorEncontrado != null) {
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

            // Obtener el conductor por su número de documento
            Vehiculo vehiculoEncontrado = dao.getByPlacaVehiculo(placa);

            // Verificar si se encontró un conductor
            if (vehiculoEncontrado != null) {
                // Asignar los valores al objeto conductor
                vehiculo = vehiculoEncontrado;
                vista.txtIdTipoVehiculo.setText("" + vehiculo.getTipo_vehiculo());

                //enviar tipo de vehiculo a metodo clacular tarifa
            } else {
                vista.txtDni.setText("");
                JOptionPane.showMessageDialog(null, "El Vehiculo no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la placa del vehiculo");
        }
    }

    public void obtenerTipoVehiculo() throws DAOException {
        if (!"".equals(vista.txtIdTipoVehiculo.getText())) {

            int id_tipoVehiculo = Integer.parseInt(vista.txtIdTipoVehiculo.getText());

            TipoVehiculoDAO dao = manager.getTipoVehiculoDAO();

            // Obtener el conductor por su número de documento
            TipoVehiculo tipoEncontrado = dao.getById(id_tipoVehiculo);

            // Verificar si se encontró un conductor
            if (tipoEncontrado != null) {
                // Asignar los valores al objeto conductor
                tipoVehiculo = tipoEncontrado;
                vista.txtTipoVehiculo.setText("" + tipoVehiculo.getDescripcion());
                tipoVehiculoActual = vista.txtTipoVehiculo.getText();
                System.out.println("Tipo Vehiculo actual seleccionado: " + tipoVehiculoActual); // Verifica si el departamento seleccionado es el esperado

                //
            } else {
                vista.txtDni.setText("");
                JOptionPane.showMessageDialog(null, "El Vehiculo no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la placa del vehiculo");
        }
    }

    //Metodo Para calcular el pago de Ingreso por el tipo de vehiculo y el lugar de destino
    public void calcularTarifaPago() throws DAOException {
        if (!"".equals(vista.txtTipoVehiculo.getText()) && !"".equals(vista.cbxDepartamento.getSelectedItem().toString())
                && !"".equals(vista.cbxProvincia.getSelectedItem().toString())
                && !"".equals(vista.cbxDistrito.getSelectedItem().toString())) {

            
                String id_departamento = vista.txtIdDepartamento.getText();

                DepartamentoDAO dao = manager.getDepartamentoDAO();

                // Obtener el conductor por su número de documento
                Departamento departamentoEncontrado = dao.getById(id_departamento);

                if (departamentoEncontrado != null) {
                    departamento = departamentoEncontrado;
                    Double tarifaDepartamento = departamentoEncontrado.getTarifa();
                    if (vista.txtTipoVehiculo.getText() == "Bus de Transporte") {
                        Double tarifaVehiculo = 10.00;
                        Double tarifaTotal = tarifaVehiculo * tarifaDepartamento;
                        vista.txtTarifaPago.setText("" + tarifaTotal);
                    }
                    if (vista.txtTipoVehiculo.getText() == "Camion de Carga") {
                        Double tarifaVehiculo = 10.00;
                        Double tarifaTotal = tarifaVehiculo * tarifaDepartamento;
                        vista.txtTarifaPago.setText("" + tarifaTotal);
                    }
                    if (vista.txtTipoVehiculo.getText() == "Vehiculo del Personal") {
                        Double tarifaVehiculo = 10.00;
                        Double tarifaTotal = tarifaVehiculo * tarifaDepartamento;
                        vista.txtTarifaPago.setText("" + tarifaTotal);
                    }
                    if (vista.txtTipoVehiculo.getText() == "Vehiculo Particular") {
                        Double tarifaVehiculo = 10.00;
                        Double tarifaTotal = tarifaVehiculo * tarifaDepartamento;
                        vista.txtTarifaPago.setText("" + tarifaTotal);
                    }
                    if (vista.txtTipoVehiculo.getText() == "Otro Vehiculo") {
                        Double tarifaVehiculo = 10.00;
                        Double tarifaTotal = tarifaVehiculo * tarifaDepartamento;
                        vista.txtTarifaPago.setText("" + tarifaTotal);
                    }
                    
                    
                    
                } else {
                    vista.txtIdDepartamento.setText("");
                    JOptionPane.showMessageDialog(null, "El Departamento no existe");
                }

            

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese los datos requeridos");
        }
    }

    public void nuevoMetodoPago() {
        LimpiarMetodoPago();
    }

    public void listar(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
        List<RegistroEntrada> lista = dao.listAll();
        Object[] ob = new Object[7];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_registro_entrada();
            ob[1] = lista.get(i).getConductor();
            ob[2] = lista.get(i).getVehiculo();
            ob[3] = lista.get(i).getDestino();
            ob[4] = lista.get(i).getFecha_hora_entrada();
            ob[5] = lista.get(i).getUsuario();
            ob[6] = lista.get(i).getPago();

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
        llenarDepartamento();
    }

    public void LimpiarMetodoPago() {
        vista.txtIdIngresoVehiculo.setText("");
        vista.txtDni.setText("");
        vista.txtPlaca.setText("");
        vista.txtTarifaPago.setText("");
        vista.cbxDepartamento.setSelectedItem(null);
        vista.txtFechaActual.setText("");
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
                && !vista.txtTarifaPago.getText().isEmpty()
                && vista.cbxDepartamento.getSelectedItem() != null
                && !vista.txtFechaActual.getText().isEmpty()
                && vista.txtTipoVehiculo.getText().isEmpty();
    }

    private void llenarDepartamento() throws DAOException {

        DepartamentoDAO dao = manager.getDepartamentoDAO();

        List<Departamento> lista = (ArrayList<Departamento>) dao.listAll();

        //int idselect = 1;
        vista.cbxDepartamento.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            vista.cbxDepartamento.addItem(lista.get(i).getNombre());
        }

    }

    private void obtenerIdDepartamento() throws DAOException {
        if (!"".equals(vista.cbxDepartamento.getSelectedItem())) {

            String nombreDepartamento = vista.cbxDepartamento.getSelectedItem().toString();

            DepartamentoDAO dao = manager.getDepartamentoDAO();

            // Obtener el conductor por su número de documento
            Departamento departamentoEncontrado = dao.getByNombreId(nombreDepartamento);

            // Verificar si se encontró un conductor
            if (departamentoEncontrado != null) {
                // Asignar los valores al objeto conductor
                departamento = departamentoEncontrado;
                vista.txtIdDepartamento.setText("" + departamento.getId());
                departamentoActual = vista.txtIdDepartamento.getText();
                System.out.println("Departamento actual seleccionado: " + departamentoActual); // Verifica si el departamento seleccionado es el esperado
                llenarProvincia(departamentoActual);
            } else {
                vista.txtDni.setText("");
                JOptionPane.showMessageDialog(null, "El Departamento no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione el departamento");
        }
    }

    private void llenarProvincia(String departamentoSeleccionado) throws DAOException {
        System.out.println("Departamento seleccionado en llenarProvincia: " + departamentoSeleccionado); // Verifica si el departamento llega correctamente

        ProvinciaDAO dao = manager.getProvinciaDAO();

        List<Provincia> listaProvincias = (List<Provincia>) dao.getByDepartamentoProvincia(departamentoSeleccionado);

        // Verificar si se encontró un conductor
        vista.cbxProvincia.removeAllItems(); // Limpiar el JComboBox de provincias

        if (!listaProvincias.isEmpty()) {
            for (Provincia provinci : listaProvincias) {
                vista.cbxProvincia.addItem(provinci.getNombre());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron provincias para el departamento seleccionado.");
        }
        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }

    private void obtenerIdProvincia() throws DAOException {
        if (!"".equals(vista.cbxProvincia.getSelectedItem())) {

            String nombreProvincia = vista.cbxProvincia.getSelectedItem().toString();

            ProvinciaDAO dao = manager.getProvinciaDAO();

            // Obtener el conductor por su número de documento
            Provincia provinciaEncontrada = dao.getByNombreId(nombreProvincia);

            // Verificar si se encontró un conductor
            if (provinciaEncontrada != null) {
                // Asignar los valores al objeto conductor
                provincia = provinciaEncontrada;
                vista.txtIdProvincia.setText("" + provincia.getId());
                provinciaActual = vista.txtIdProvincia.getText();
                System.out.println("Provincia actual seleccionada: " + provinciaActual); // Verifica si el departamento seleccionado es el esperado
                llenarDistritos(provinciaActual);
            } else {
                vista.txtDni.setText("");
                JOptionPane.showMessageDialog(null, "La Provincia no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la provincia");
        }
    }

    private void llenarDistritos(String provinciaSeleccionada) throws DAOException {

        System.out.println("Provincia seleccionada en llenarDistritos: " + provinciaSeleccionada); // Verifica si el departamento llega correctamente

        DistritoDAO dao = manager.getDistritoDAO();

        List<Distrito> listaDistritos = (List<Distrito>) dao.getByProvinciaDistrito(provinciaSeleccionada);

        // Verificar si se encontró un conductor
        vista.cbxDistrito.removeAllItems(); // Limpiar el JComboBox de provincias

        if (!listaDistritos.isEmpty()) {
            for (Distrito distri : listaDistritos) {
                vista.cbxDistrito.addItem(distri.getNombre());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron distritos para la provincia seleccionada");
        }

        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }
    

}
