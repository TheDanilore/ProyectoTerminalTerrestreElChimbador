package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.RegistroEntradaConPagaDAO;
import DAO.RegistroEntradaDAO;
import Modelo.RegistroEntrada;
import Vista.ConsultarIngresoVista;

public final class ConsultarIngresoController implements MouseListener {

    private final DAOManager manager;
    ConsultarIngresoVista vista = new ConsultarIngresoVista();

    DefaultTableModel clase = new DefaultTableModel();

    public ConsultarIngresoController(ConsultarIngresoVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnBuscarByPlaca.addMouseListener(this);
        this.vista.btnListar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.LimpiarTable();
        this.listar(vista.tableVehiculo);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnBuscarByPlaca) {
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
        Object[] ob = new Object[8];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_registro_entrada();
            ob[1] = lista.get(i).getTipo_documento();
            ob[2] = lista.get(i).getNumero_documento();
            ob[3] = lista.get(i).getConductor();
            ob[4] = lista.get(i).getVehiculo();
            ob[5] = lista.get(i).getTipo_vehiculo();
            ob[6] = lista.get(i).getFecha_hora_entrada();
            ob[7] = lista.get(i).getUsuario();
            clase.addRow(ob);
        }
        vista.tableVehiculo.setModel(clase);
    }

    public void listarByPlaca(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        RegistroEntradaDAO dao = manager.getRegistroEntradaDAO();
        String placa = vista.txtPlaca.getText().toUpperCase();
        List<RegistroEntrada> lista = dao.getByPlaca(placa);

        if (lista != null) {
            Object[] ob = new Object[8];

            for (int i = 0; i < lista.size(); i++) {
                ob[0] = lista.get(i).getId_registro_entrada();
                ob[1] = lista.get(i).getNumero_documento();
                ob[2] = lista.get(i).getNumero_documento();
                ob[3] = lista.get(i).getConductor();
                ob[4] = lista.get(i).getVehiculo();
                ob[5] = lista.get(i).getTipo_vehiculo();
                ob[6] = lista.get(i).getFecha_hora_entrada();
                ob[7] = lista.get(i).getUsuario();

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
