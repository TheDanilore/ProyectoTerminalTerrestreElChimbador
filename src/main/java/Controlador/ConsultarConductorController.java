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
import Modelo.Conductor;
import Vista.ConsultarConductorVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class ConsultarConductorController implements MouseListener {

    private DAOManager manager;
    ConsultarConductorVista vista = new ConsultarConductorVista();
    Conductor modelo = new Conductor();

    DefaultTableModel clase = new DefaultTableModel();

    public ConsultarConductorController(ConsultarConductorVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnBuscar.addMouseListener(this);
        this.vista.btnListar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.tableConductor.addMouseListener(this);
        this.LimpiarTable();
        this.ListarConductor(vista.tableConductor);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnBuscar) {
            try {
                camposValidos();
                LimpiarTable();
                ListarByDni(vista.tableConductor);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarConductorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnListar) {
            try {
                LimpiarTable();
                ListarConductor(vista.tableConductor);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarConductorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
    }

    public void reporteExcel() {
        Excel.reporteConductor();
    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
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
    }

    public void ListarByDni(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        ConductorDAO dao = manager.getConductorDAO();
        Conductor lista = dao.getByDniConductor(Long.valueOf(vista.txtNumeroDocumento.getText()));

        if (lista != null) {
            Object[] ob = new Object[11];

            for (int i = 0; i < 1; i++) {
                ob[0] = lista.getId_conductor();
                ob[1] = lista.getPrimer_nombre();
                ob[2] = lista.getSegundo_nombre();
                ob[3] = lista.getApellido_paterno();
                ob[4] = lista.getApellido_materno();

                //ob[5] = lista.get(i).getTipo_documento_identidad();
                if ("0".equals(lista.getTipo_documento_identidad())) {
                    ob[5] = "OTROS TIPOS DE DOCUMENTOS";
                }
                if ("1".equals(lista.getTipo_documento_identidad())) {
                    ob[5] = "DOCUMENTO NACIONAL DE IDENTIDAD (DNI)";
                }
                if ("4".equals(lista.getTipo_documento_identidad())) {
                    ob[5] = "CARNET DE EXTRANJERÍA";
                }
                if ("6".equals(lista.getTipo_documento_identidad())) {
                    ob[5] = "REGISTRO ÚNICO DE CONTRIBUYENTES";
                }
                if ("7".equals(lista.getTipo_documento_identidad())) {
                    ob[5] = "PASAPORTE";
                }
                if ("A".equals(lista.getTipo_documento_identidad())) {
                    ob[5] = "CÉDULA DIPLOMÁTICA DE IDENTIDAD";
                }

                ob[6] = lista.getNumero_documento();
                ob[7] = lista.getTelefono();
                ob[8] = lista.getDireccion();

                ob[9] = lista.getEmpresa();

                //ob[10] = lista.get(i).getEstado();
                //estado
                if (lista.getEstado() == 1) {
                    ob[10] = "Activo";
                }
                if (lista.getEstado() == 0) {
                    ob[10] = "Deshabilitado";
                }

                clase.addRow(ob);
            }
            vista.tableConductor.setModel(clase);
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un numero de documento valido");
            vista.txtNumeroDocumento.setText("");
        }

    }
    public boolean camposValidos(){
        return !vista.txtNumeroDocumento.getText().isEmpty();
    }

    public void marcaAgua() {
        TextPrompt placa = new TextPrompt("N° de Documento", vista.txtNumeroDocumento);
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
