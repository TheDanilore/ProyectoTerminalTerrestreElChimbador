package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import Modelo.RegistroEntradaConPaga;
import Vista.ConsultarIngresoConPagaVista;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.RegistroEntradaConPagaDAO;

public final class ConsultarIngresoConPagaController implements MouseListener {

    private final DAOManager manager;
    ConsultarIngresoConPagaVista vista = new ConsultarIngresoConPagaVista();

    DefaultTableModel clase = new DefaultTableModel();

    public ConsultarIngresoConPagaController(ConsultarIngresoConPagaVista v, DAOManager manager) throws DAOException {
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
                Logger.getLogger(ConsultarIngresoConPagaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnListar) {
            try {
                LimpiarTable();
                listar(vista.tableVehiculo);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarIngresoConPagaController.class.getName()).log(Level.SEVERE, null, ex);
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
    }

    public void listarByPlaca(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        RegistroEntradaConPagaDAO dao = manager.getRegistroEntradaConPagaDAO();
        String placa = vista.txtPlaca.getText().toUpperCase();
        List<RegistroEntradaConPaga> lista = dao.getByPlaca(placa);

        if (lista != null) {
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
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese una placa valida");
            vista.txtPlaca.setText("");
        }

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
