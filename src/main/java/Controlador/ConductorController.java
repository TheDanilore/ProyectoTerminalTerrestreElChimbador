/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import DAO.ConductorDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.EmpresasDAO;
import DAO.TipoDocumentoIdentidadDAO;
import DAO.mysql.MySQLConductorDAO;
import DAO.mysql.MySQLEmpresasDAO;
import DAO.mysql.MySQLTipoDocumentoIdentidadDAO;
import Modelo.Conductor;
import Modelo.Empresas;
import Modelo.TipoDocumentoIdentidad;
import Vista.ConductorVista;
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
public class ConductorController implements ActionListener {

    private DAOManager manager;
    ConductorVista vista = new ConductorVista();
    Conductor modelo = new Conductor();
    Empresas empresas = new Empresas();
    
    DefaultTableModel clase = new DefaultTableModel();

    public ConductorController(ConductorVista v,DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager=manager;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActivar.addActionListener(this);
        this.vista.btnDarBaja.addActionListener(this);
        this.vista.btnObtener.addActionListener(this);
        this.LimpiarTable();
        this.ListarConductor(vista.tableConductor);
        tabular();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            try {
                guardarConductor();
            } catch (DAOException ex) {
                Logger.getLogger(ConductorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizarConductor();
            } catch (DAOException ex) {
                Logger.getLogger(ConductorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoConductor();
        }
        if (e.getSource() == vista.btnActivar) {
            try {
                activarconductor();
            } catch (DAOException ex) {
                Logger.getLogger(ConductorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnDarBaja) {
            try {
                bajaConductor();
            } catch (DAOException ex) {
                Logger.getLogger(ConductorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnObtener) {
            try {
                obtenerEmpresaPorRuc();
            } catch (DAOException ex) {
                Logger.getLogger(ConductorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
    }

    public void reporteExcel(){
        Excel.reporteConductor();
    }
    public void guardarConductor() throws DAOException {
        if (camposValidos()) {

            modelo.setPrimer_nombre(vista.txtPrimerNombreConductor.getText());
            modelo.setSegundo_nombre(vista.txtSegundoNombreConductor.getText());
            modelo.setApellido_paterno(vista.txtApellidoPaternoConductor.getText());
            modelo.setApellido_materno(vista.txtApellidoMaternoConductor.getText());

            if ("OTROS TIPOS DE DOCUMENTOS".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                modelo.setTipo_documento_identidad("0");
            }
            if ("DOCUMENTO NACIONAL DE IDENTIDAD (DNI)".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                modelo.setTipo_documento_identidad("1");
            }
            if ("CARNET DE EXTRANJERÍA".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                modelo.setTipo_documento_identidad("4");
            }
            if ("REGISTRO ÚNICO DE CONTRIBUYENTES".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                modelo.setTipo_documento_identidad("6");
            }
            if ("PASAPORTE".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                modelo.setTipo_documento_identidad("7");
            }
            if ("CÉDULA DIPLOMÁTICA DE IDENTIDAD".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                modelo.setTipo_documento_identidad("A");
            }

            modelo.setNumero_documento(Long.parseLong(vista.txtNumeroDocumento.getText()));
            modelo.setTelefono(Integer.parseInt(vista.txtTelefonoConductor.getText()));
            modelo.setDireccion(vista.txtDireccionConductor.getText());
            modelo.setEmpresa(Long.parseLong(vista.txtRucEmpresa.getText()));
            
            //Conexion, consulta con la base de datos
            ConductorDAO dao = manager.getConductorDAO();
            dao.add(modelo);
            
            
            JOptionPane.showMessageDialog(null, "Conductor Registrado");
            LimpiarTable();
            ListarConductor(vista.tableConductor);
            LimpiarConductor();

        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarConductor() throws DAOException {
        if ("".equals(vista.txtIdConductor.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_conductor(Integer.parseInt(vista.txtIdConductor.getText()));
                modelo.setPrimer_nombre(vista.txtPrimerNombreConductor.getText());
                modelo.setSegundo_nombre(vista.txtSegundoNombreConductor.getText());
                modelo.setApellido_paterno(vista.txtApellidoPaternoConductor.getText());
                modelo.setApellido_materno(vista.txtApellidoMaternoConductor.getText());

                if ("OTROS TIPOS DE DOCUMENTOS".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                    modelo.setTipo_documento_identidad("0");
                }
                if ("DOCUMENTO NACIONAL DE IDENTIDAD (DNI)".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                    modelo.setTipo_documento_identidad("1");
                }
                if ("CARNET DE EXTRANJERÍA".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                    modelo.setTipo_documento_identidad("4");
                }
                if ("REGISTRO ÚNICO DE CONTRIBUYENTES".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                    modelo.setTipo_documento_identidad("6");
                }
                if ("PASAPORTE".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                    modelo.setTipo_documento_identidad("7");
                }
                if ("CÉDULA DIPLOMÁTICA DE IDENTIDAD".equals(vista.cbxTipoDocumentoIdentidad.getSelectedItem().toString())) {
                    modelo.setTipo_documento_identidad("A");
                }

                modelo.setNumero_documento(Long.parseLong(vista.txtNumeroDocumento.getText()));
                modelo.setTelefono(Integer.parseInt(vista.txtTelefonoConductor.getText()));
                modelo.setDireccion(vista.txtDireccionConductor.getText());
                modelo.setEmpresa(Long.parseLong(vista.txtRucEmpresa.getText()));
                

                ConductorDAO dao = manager.getConductorDAO();
                dao.update(modelo);
                //Conexion, consulta con la base de datos

                JOptionPane.showMessageDialog(null, "Conductor Modificado");
                LimpiarTable();
                ListarConductor(vista.tableConductor);
                LimpiarConductor();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void bajaConductor() throws DAOException {
        if (!"".equals(vista.txtIdConductor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja al Conductor");
            if (pregunta == 0) {
                modelo.setId_conductor(Integer.parseInt(vista.txtIdConductor.getText()));
                modelo.setEstado(0);

                ConductorDAO dao = manager.getConductorDAO();
                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se dio de baja el Conductor");
                LimpiarTable();
                ListarConductor(vista.tableConductor);
                LimpiarConductor();

            } else {
                LimpiarConductor();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void activarconductor() throws DAOException {
        if (!"".equals(vista.txtIdConductor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar el Conductor");
            if (pregunta == 0) {
                modelo.setId_conductor(Integer.parseInt(vista.txtIdConductor.getText()));
                modelo.setEstado(1);
                
                ConductorDAO dao = manager.getConductorDAO();
                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se Activo el Conductor");
                LimpiarTable();
                ListarConductor(vista.tableConductor);
                LimpiarConductor();

            } else {
                LimpiarConductor();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void nuevoConductor() {
        LimpiarConductor();
    }

    public void ListarConductor(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        ConductorDAO dao = manager.getConductorDAO();
        List<Conductor> lista = dao.listAll();
        Object[] ob = new Object[11];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_conductor();
            ob[1] = lista.get(i).getPrimer_nombre();
            ob[2] = lista.get(i).getSegundo_nombre();
            ob[3] = lista.get(i).getApellido_paterno();
            ob[4] = lista.get(i).getApellido_materno();

            //ob[5] = lista.get(i).getTipo_documento_identidad();
            if ("0".equals(lista.get(i).getTipo_documento_identidad())) {
                ob[5] = "OTROS TIPOS DE DOCUMENTOS";
            }
            if ("1".equals(lista.get(i).getTipo_documento_identidad())) {
                ob[5] = "DOCUMENTO NACIONAL DE IDENTIDAD (DNI)";
            }
            if ("4".equals(lista.get(i).getTipo_documento_identidad())) {
                ob[5] = "CARNET DE EXTRANJERÍA";
            }
            if ("6".equals(lista.get(i).getTipo_documento_identidad())) {
                ob[5] = "REGISTRO ÚNICO DE CONTRIBUYENTES";
            }
            if ("7".equals(lista.get(i).getTipo_documento_identidad())) {
                ob[5] = "PASAPORTE";
            }
            if ("A".equals(lista.get(i).getTipo_documento_identidad())) {
                ob[5] = "CÉDULA DIPLOMÁTICA DE IDENTIDAD";
            }

            ob[6] = lista.get(i).getNumero_documento();
            ob[7] = lista.get(i).getTelefono();
            ob[8] = lista.get(i).getDireccion();

            ob[9] = lista.get(i).getEmpresa();


            //ob[10] = lista.get(i).getEstado();
            //estado
            if (lista.get(i).getEstado() == 1) {
                ob[10] = "Activo";
            }
            if (lista.get(i).getEstado() == 0) {
                ob[10] = "Deshabilitado";
            }

            clase.addRow(ob);
        }
        vista.tableConductor.setModel(clase);
        llenarTipoDocumentoIdentidad();
    }
    
        public void obtenerEmpresaPorRuc() throws DAOException {
        if (!"".equals(vista.txtRucEmpresa.getText())) {

            long ruc = Long.parseLong(vista.txtRucEmpresa.getText());

            EmpresasDAO dao = manager.getEmpresasDAO();

            // Obtener el conductor por su número de documento
            Empresas empresaEncontrada = dao.getByRucEmpresa(ruc);

            // Verificar si se encontró un conductor
            if (empresaEncontrada != null) {
                // Asignar los valores al objeto conductor
                empresas = empresaEncontrada;
                vista.txtEmpresa.setText("" + empresas.getRazon_social());
            } else {
                vista.txtRucEmpresa.setText("");
                JOptionPane.showMessageDialog(null, "La Empresa no existe");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese el ruc de la Empresa");
        }
    }

    public void LimpiarConductor() {
        vista.txtIdConductor.setText("");
        vista.txtPrimerNombreConductor.setText("");
        vista.txtSegundoNombreConductor.setText("");
        vista.txtApellidoPaternoConductor.setText("");
        vista.txtApellidoMaternoConductor.setText("");
        vista.txtDireccionConductor.setText("");
        vista.txtNumeroDocumento.setText("");
        vista.txtTelefonoConductor.setText("");
        vista.txtRucEmpresa.setText("");
        vista.txtEmpresa.setText("");
        vista.cbxTipoDocumentoIdentidad.setSelectedItem(null);
    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public boolean camposValidos() {
        return !vista.txtPrimerNombreConductor.getText().isEmpty()
                && !vista.txtSegundoNombreConductor.getText().isEmpty()
                && !vista.txtApellidoPaternoConductor.getText().isEmpty()
                && !vista.txtApellidoMaternoConductor.getText().isEmpty()
                && !vista.txtDireccionConductor.getText().isEmpty()
                && !vista.txtNumeroDocumento.getText().isEmpty()
                && !vista.txtTelefonoConductor.getText().isEmpty()
                && !vista.txtEmpresa.getText().isEmpty()
                && vista.cbxTipoDocumentoIdentidad.getSelectedItem() != null                ;
    }

    private void tabular() {
        vista.txtPrimerNombreConductor.setNextFocusableComponent(vista.txtSegundoNombreConductor);
        vista.txtSegundoNombreConductor.setNextFocusableComponent(vista.txtApellidoPaternoConductor);
        vista.txtApellidoPaternoConductor.setNextFocusableComponent(vista.txtApellidoMaternoConductor);
    }

    private void llenarTipoDocumentoIdentidad() throws DAOException {
        
        TipoDocumentoIdentidadDAO dao = manager.getTipoDocumentoIdentidadDAO();
        

        List<TipoDocumentoIdentidad> lista = (ArrayList<TipoDocumentoIdentidad>) dao.listAll();

        //int idselect = 1;
        vista.cbxTipoDocumentoIdentidad.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            vista.cbxTipoDocumentoIdentidad.addItem(lista.get(i).getDescripcion());
        }

        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }


}
