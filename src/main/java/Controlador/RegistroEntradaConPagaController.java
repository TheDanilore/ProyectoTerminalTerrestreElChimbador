/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.ConductorDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.DepartamentoDAO;
import DAO.DistritoDAO;
import DAO.ProvinciaDAO;
import DAO.TipoVehiculoPagoDAO;
import DAO.VehiculoDAO;
import Modelo.Conductor;
import Modelo.Departamento;
import Modelo.Distrito;
import Modelo.Provincia;
import Modelo.RegistroEntradaConPaga;
import Modelo.TipoVehiculoPago;
import Modelo.Vehiculo;
import Vista.ConductorVista;
import Vista.ConsultarPagoVista;
import Vista.PagoIngresoVista;
import Vista.RegistroIngresoConPagaVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.RegistroEntradaConPagaDAO;

/**
 *
 * @author Danilore
 */
public final class RegistroEntradaConPagaController implements MouseListener, ActionListener {

    private String departamentoActual;
    private String provinciaActual;
    private String tipoVehiculoDescripcion;

    private final DAOManager manager;
    RegistroIngresoConPagaVista vista = new RegistroIngresoConPagaVista();
    RegistroEntradaConPaga modelo = new RegistroEntradaConPaga();
    Conductor conductor = new Conductor();
    Vehiculo vehiculo = new Vehiculo();
    TipoVehiculoPago tipoVehiculo = new TipoVehiculoPago();
    Departamento departamento = new Departamento();
    Provincia provincia = new Provincia();

    DefaultTableModel clase = new DefaultTableModel();

    public RegistroEntradaConPagaController(RegistroIngresoConPagaVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnGuardar.addMouseListener(this);
        this.vista.btnActualizar.addMouseListener(this);
        this.vista.btnNuevo.addMouseListener(this);
        this.vista.btnEliminar.addMouseListener(this);
        this.vista.txtDni.addActionListener(this);
        this.vista.txtPlaca.addActionListener(this);
        this.vista.cbxDepartamento.addActionListener(this);
        this.vista.cbxProvincia.addActionListener(this);
        this.vista.btnCalcularTarifa.addMouseListener(this);
        this.vista.tableVehiculo.addMouseListener(this);
        this.vista.txtIdIngresoVehiculo.setVisible(false);
        this.vista.txtIdTipoVehiculo.setVisible(false);
        this.vista.txtIdDepartamento.setVisible(false);
        this.vista.txtIdProvincia.setVisible(false);
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
                Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == vista.txtPlaca) {
            try {
                obtenerVehiculoPorPlaca();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.cbxDepartamento) {
            try {
                obtenerIdDepartamento();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.cbxProvincia) {
            try {
                obtenerIdProvincia();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.btnGuardar) {
            if (camposValidos()) {
                PagoIngresoVista pagoVista = new PagoIngresoVista();
                ConsultarPagoVista consultarPago = new ConsultarPagoVista();
                PagoIngresoController pago = null;
                try {
                    pago = new PagoIngresoController(pagoVista, consultarPago, manager);
                } catch (DAOException ex) {
                    Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Obtén el texto
                String dnie = vista.txtDni.getText();
                String conductore = vista.txtConductor.getText();
                String placae = vista.txtPlaca.getText();
                String tipovehiculoe = vista.txtTipoVehiculo.getText();
                String destinoe = vista.cbxDepartamento.getSelectedItem().toString() + " - " + vista.cbxProvincia.getSelectedItem().toString() + " - "
                        + vista.cbxDistrito.getSelectedItem().toString();

                String pagoe = vista.txtTarifaPago.getText();

                try {
                    pago.setTextosEnTextFieldB(dnie, conductore, placae, tipovehiculoe, destinoe, pagoe);
                } catch (DAOException ex) {
                    Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
                }

                pagoVista.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Llene todos los campos");

            }

        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizar();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {

            nuevo();

        }

        if (e.getSource() == vista.btnEliminar) {
            try {
                eliminar();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == vista.btnCalcularTarifa) {
            try {
                calcularTarifaPago();
            } catch (DAOException ex) {
                Logger.getLogger(RegistroEntradaConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.tableVehiculo) {
            int fila = vista.tableVehiculo.rowAtPoint(e.getPoint());

            vista.txtIdIngresoVehiculo.setText(vista.tableVehiculo.getValueAt(fila, 0).toString());
            vista.txtDni.setText(vista.tableVehiculo.getValueAt(fila, 1).toString());
            vista.txtConductor.setText(vista.tableVehiculo.getValueAt(fila, 2).toString());
            vista.txtPlaca.setText(vista.tableVehiculo.getValueAt(fila, 3).toString());
            vista.txtTipoVehiculo.setText(vista.tableVehiculo.getValueAt(fila, 4).toString());
            vista.txtTarifaPago.setText(vista.tableVehiculo.getValueAt(fila, 8).toString());

            vista.cbxDepartamento.setSelectedItem(vista.tableVehiculo.getValueAt(fila, 5).toString());

            // Obtener la cadena completa de la columna 5
            String cadenaCompleta = vista.tableVehiculo.getValueAt(fila, 5).toString();

            // Dividir la cadena utilizando el carácter '-' como separador
            String[] partes = cadenaCompleta.split(" - ");

            // Verificar si hay al menos una parte después del split
            if (partes.length > 0) {
                // Obtener la primera parte, que es la palabra antes del primer '-'
                String departamentoParte = partes[0];

                // Asignar a los JComboBox los valores recuperados
                vista.cbxDepartamento.setSelectedItem(departamentoParte);
                
                // Obtener la segunda parte, que es la palabra antes del primer '-'
                String provinciaParte = partes[1];

                // Asignar a los JComboBox los valores recuperados
                vista.cbxProvincia.setSelectedItem(provinciaParte);
                
                // Obtener la segunda parte, que es la palabra antes del primer '-'
                String distritoParte = partes[2];

                // Asignar a los JComboBox los valores recuperados
                vista.cbxDistrito.setSelectedItem(distritoParte);
            }

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
                modelo.setDestino(vista.cbxDepartamento.getSelectedItem().toString() + " - " + vista.cbxProvincia.getSelectedItem().toString() + " - "
                        + vista.cbxDistrito.getSelectedItem().toString());
                modelo.setPago(Double.parseDouble(vista.txtTarifaPago.getText()));

                //Conexion, consulta con la base de datos
                RegistroEntradaConPagaDAO dao = manager.getRegistroEntradaConPagaDAO();
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
                RegistroEntradaConPagaDAO dao = manager.getRegistroEntradaConPagaDAO();
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
                System.out.println("Tipo Vehiculo actual seleccionado: " + tipoVehiculoDescripcion); // Verifica si el departamento seleccionado es el esperado

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

            //Para conseguir departamento por su id
            String id_departamento = vista.txtIdDepartamento.getText();

            DepartamentoDAO dao = manager.getDepartamentoDAO();

            // Obtener el conductor por su número de documento
            Departamento departamentoEncontrado = dao.getById(id_departamento);

            //Para conseguir tipo de vehiculo por su descipcion
            int id_tipo = Integer.parseInt(vista.txtIdTipoVehiculo.getText());

            TipoVehiculoPagoDAO daotipo = manager.getTipoVehiculoPagoDAO();

            // Obtener el conductor por su número de documento
            TipoVehiculoPago tipoVe = daotipo.getById(id_tipo);

            if (tipoVe.getDescripcion() != null) {
                if (departamentoEncontrado != null) {

                    double tipoVehiculotarifa = tipoVe.getTarifa();
                    Double tarifaDepartamento = departamentoEncontrado.getTarifa();

                    Double tarifaTotal = tipoVehiculotarifa + tarifaDepartamento;
                    vista.txtTarifaPago.setText("" + tarifaTotal);

                } else {
                    vista.txtIdDepartamento.setText("");
                    JOptionPane.showMessageDialog(null, "El Departamento no existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El tipo de vehiculo no existe");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        }
    }

    public void nuevo() {
        Limpiar();

    }

    public void listar(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        RegistroEntradaConPagaDAO dao = manager.getRegistroEntradaConPagaDAO();
        List<RegistroEntradaConPaga> lista = dao.listAll();
        Object[] ob = new Object[9];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_registro_entrada();
            ob[1] = lista.get(i).getDni();
            ob[2] = lista.get(i).getConductor();
            ob[3] = lista.get(i).getVehiculo();
            ob[4] = lista.get(i).getTipo_vehiculo();
            ob[5] = lista.get(i).getDestino();
            ob[6] = lista.get(i).getFecha_hora_entrada();
            ob[7] = lista.get(i).getUsuario();
            ob[8] = lista.get(i).getPago();

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
        llenarDepartamento();
    }

    public void Limpiar() {
        vista.txtIdIngresoVehiculo.setText("");
        vista.txtDni.setText("");
        vista.txtConductor.setText("");
        vista.txtPlaca.setText("");
        vista.txtIdTipoVehiculo.setText("");
        vista.txtTipoVehiculo.setText("");
        vista.cbxDepartamento.setSelectedItem(null);
        vista.txtIdDepartamento.setText("");
        vista.cbxProvincia.setSelectedItem(null);
        vista.txtIdProvincia.setText("");
        vista.cbxDistrito.setSelectedItem(null);
        vista.txtTarifaPago.setText("");

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
                && !vista.txtTipoVehiculo.getText().isEmpty();
    }

    //Combobox automaticos
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

    public void marcaAgua() {
        TextPrompt dni = new TextPrompt("N° DNI", vista.txtDni);
        TextPrompt conductor = new TextPrompt("Nombre del Conductor", vista.txtConductor);
        TextPrompt placa = new TextPrompt("N° Placa", vista.txtPlaca);
        TextPrompt idTipoVehiculo = new TextPrompt("ID tipo", vista.txtIdTipoVehiculo);
        TextPrompt tipoVehiculo = new TextPrompt("Tipo de Vehiculo", vista.txtTipoVehiculo);
        TextPrompt tarifa = new TextPrompt("Tarifa a calcular", vista.txtTarifaPago);
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
