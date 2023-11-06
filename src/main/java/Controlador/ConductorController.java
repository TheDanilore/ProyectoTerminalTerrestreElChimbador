/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ConductorDAO;
import DAO.EmpresasDAO;
import DAO.TipoDocumentoIdentidadDAO;
import Modelo.Conductor;
import Modelo.EmpresasModelo;
import Modelo.TipoDocumentoIdentidad;
import Vista.ConductorVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danilore
 */
public class ConductorController implements ActionListener {

    ConductorVista vista = new ConductorVista();
    Conductor modelo = new Conductor();
    ConductorDAO dao = new ConductorDAO();
    DefaultTableModel clase = new DefaultTableModel();

    public ConductorController(ConductorVista v) {
        this.vista = v;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActivar.addActionListener(this);
        this.vista.btnDarBaja.addActionListener(this);

        this.LimpiarTable();
        this.ListarConductor(vista.tableConductor);
        tabular();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            guardarConductor();
        }
        if (e.getSource() == vista.btnActualizar) {
            actualizarConductor();
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoConductor();
        }
        if (e.getSource() == vista.btnActivar) {
            activarconductor();
        }
        if (e.getSource() == vista.btnDarBaja) {
            bajaConductor();
        }
    }

    public void guardarConductor() {
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

            if ("No Pertenece a ninguna empresa".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                modelo.setEmpresa(1);
            }
            if ("Cruz del Sur".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                modelo.setEmpresa(2);
            }
            if ("Transportes Cruz del Norte".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                modelo.setEmpresa(3);
            }
            if ("Empresa VIA".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                modelo.setEmpresa(5);
            }
            if ("OROPEZA e".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                modelo.setEmpresa(7);
            }

            //Conexion, consulta con la base de datos
            if (dao.registrarConductor(modelo)) {
                JOptionPane.showMessageDialog(null, "Conductor Registrado");
                LimpiarTable();
                ListarConductor(vista.tableConductor);
                LimpiarConductor();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Conductor");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public void actualizarConductor() {
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

                if ("No Pertenece a ninguna empresa".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                    modelo.setEmpresa(1);
                }
                if ("Cruz del Sur".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                    modelo.setEmpresa(2);
                }
                if ("Transportes Cruz del Norte".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                    modelo.setEmpresa(3);
                }
                if ("Empresa VIA".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                    modelo.setEmpresa(5);
                }
                if ("OROPEZA e".equalsIgnoreCase(vista.cbxEmpresas.getSelectedItem().toString())) {
                    modelo.setEmpresa(7);
                }

                //Conexion, consulta con la base de datos
                if (dao.modificarConductor(modelo)) {
                    JOptionPane.showMessageDialog(null, "Conductor Modificado");
                    LimpiarTable();
                    ListarConductor(vista.tableConductor);
                    LimpiarConductor();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Conductor");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void bajaConductor() {
        if (!"".equals(vista.txtIdConductor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja al Conductor");
            if (pregunta == 0) {
                modelo.setId_conductor(Integer.parseInt(vista.txtIdConductor.getText()));
                modelo.setEstado(0);
                if (dao.bajaActivarConductor(modelo)) {

                    JOptionPane.showMessageDialog(null, "Se dio de baja el Conductor");
                    LimpiarTable();
                    ListarConductor(vista.tableConductor);
                    LimpiarConductor();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Dar de Baja el Conductor");
                }
            } else {
                LimpiarConductor();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void activarconductor() {
        if (!"".equals(vista.txtIdConductor.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar el Conductor");
            if (pregunta == 0) {
                modelo.setId_conductor(Integer.parseInt(vista.txtIdConductor.getText()));
                modelo.setEstado(1);
                if (dao.bajaActivarConductor(modelo)) {

                    JOptionPane.showMessageDialog(null, "Se Activo el Conductor");
                    LimpiarTable();
                    ListarConductor(vista.tableConductor);
                    LimpiarConductor();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al  Activar el Conductor");
                }
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

    public void ListarConductor(JTable tabla) {
        clase = (DefaultTableModel) tabla.getModel();
        List<Conductor> lista = dao.listarConductor();
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

            //ob[9] = lista.get(i).getEmpresa();

            
            if ("1".equals(lista.get(i).getEmpresa())) {
                ob[9] = "No Pertenece a ninguna empresa";
            }
            if ("2".equals(lista.get(i).getEmpresa())) {
                ob[9] = "Cruz del Sur";
            }
            if ("3".equals(lista.get(i).getEmpresa())) {
                ob[9] = "Transportes Cruz del Norte";
            }
            if ("5".equals(lista.get(i).getEmpresa())) {
                ob[9] = "Empresa VIA";
            }
            if ("7".equals(lista.get(i).getEmpresa())) {
                ob[9] = "OROPEZA e";
            }
            
            
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
        llenarEmpresas();
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
        vista.cbxEmpresas.setSelectedItem(null);
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
                &&  vista.cbxEmpresas.getSelectedItem() != null
                &&  vista.cbxTipoDocumentoIdentidad.getSelectedItem() != null;
    }

    private void tabular(){
        vista.txtPrimerNombreConductor.setNextFocusableComponent(vista.txtSegundoNombreConductor);
        vista.txtSegundoNombreConductor.setNextFocusableComponent(vista.txtApellidoPaternoConductor);
        vista.txtApellidoPaternoConductor.setNextFocusableComponent(vista.txtApellidoMaternoConductor);
    }
    private void llenarTipoDocumentoIdentidad(){
        TipoDocumentoIdentidadDAO dao = new TipoDocumentoIdentidadDAO();
        
        ArrayList<TipoDocumentoIdentidad> lista = dao.getTipoDocumentoIdentidad();
        
        
        //int idselect = 1;
        vista.cbxTipoDocumentoIdentidad.removeAllItems();
        
        
        for (int i = 0; i < lista.size(); i++) {
            vista.cbxTipoDocumentoIdentidad.addItem(lista.get(i).getDescripcion());
        }
        
        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }
    
    private void llenarEmpresas(){
        EmpresasDAO dao = new EmpresasDAO();
        
        ArrayList<EmpresasModelo> lista = (ArrayList<EmpresasModelo>) dao.ListarEmpresa();
        
        
        //int idselect = 1;
        vista.cbxEmpresas.removeAllItems();
        
        
        for (int i = 0; i < lista.size(); i++) {
            vista.cbxEmpresas.addItem(lista.get(i).getNombre_comercial());
        }
        
        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }
}
