package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.RegistroEntradaDAO;
import Modelo.RegistroEntrada;
import Vista.ConsultarEntradaVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Danilore
 */
public final class ConsultarIngresoController implements MouseListener {

    private final DAOManager manager;
    ConsultarEntradaVista vista = new ConsultarEntradaVista();

    DefaultTableModel clase = new DefaultTableModel();

    public ConsultarIngresoController(ConsultarEntradaVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnBuscar.addMouseListener(this);
        this.vista.btnListar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.LimpiarTable();
        this.listar(vista.tableVehiculo);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnBuscar) {
            try {
                LimpiarTable();
                listarByPlaca(vista.tableVehiculo);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarIngresoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnListar) {
            try {
                LimpiarTable();
                listar(vista.tableVehiculo);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarIngresoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
    }

    public void reporteExcel() {
        Excel.reporteRegistroEntrada();
    }
    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }
    
    public void listar(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
        List<RegistroEntrada> lista = dao.listAll();
        Object[] ob = new Object[10];

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

            ob[9] = lista.get(i).getEstado();
            //estado
            if (lista.get(i).getEstado() == 1) {
                ob[9] = "En el Terminal";
            }
            if (lista.get(i).getEstado() == 2) {
                ob[9] = "Salio del Terminal";
            }

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
    }

    public void listarByPlaca(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
        String placa = vista.txtPlaca.getText().toUpperCase();
        List<RegistroEntrada> lista = dao.getByPlaca(placa);
        Object[] ob = new Object[10];

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

            ob[9] = lista.get(i).getEstado();
            //estado
            if (lista.get(i).getEstado() == 1) {
                ob[9] = "En el Terminal";
            }
            if (lista.get(i).getEstado() == 2) {
                ob[9] = "Salio del Terminal";
            }

            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
    }

    public void marcaAgua() {
        TextPrompt placa = new TextPrompt("N° Placa", vista.txtPlaca);
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
