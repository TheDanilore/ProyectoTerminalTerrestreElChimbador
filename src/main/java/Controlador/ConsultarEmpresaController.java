package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.EmpresasDAO;
import Modelo.Empresas;
import Vista.ConsultarEmpresaVista;
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
public class ConsultarEmpresaController implements MouseListener {

    private DAOManager manager;
    ConsultarEmpresaVista vista = new ConsultarEmpresaVista();
    Empresas modelo = new Empresas();

    DefaultTableModel clase = new DefaultTableModel();

    public ConsultarEmpresaController(ConsultarEmpresaVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnBuscar.addMouseListener(this);
        this.vista.btnListar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.tableEmpresa.addMouseListener(this);
        this.LimpiarTable();
        this.listar(vista.tableEmpresa);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnBuscar) {

            LimpiarTable();

            try {
                listarByRuc(vista.tableEmpresa);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarEmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == vista.btnListar) {

            LimpiarTable();

            try {
                listar(vista.tableEmpresa);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarEmpresaController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
    }

    public void reporteExcel() {
        Excel.reporteEmpresa();
    }

    //Metodo para Listar Empresas
    public void listar(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        EmpresasDAO dao = manager.getEmpresasDAO();
        List<Empresas> lista = dao.listAll();
        Object[] object = new Object[5];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId_empresa();
            object[1] = lista.get(i).getRuc();
            object[2] = lista.get(i).getRazon_social();
            object[3] = lista.get(i).getNombre_comercial();
            if (lista.get(i).getEstado()==1) {
                object[4]="Activa";
            }
            if (lista.get(i).getEstado() ==0) {
                object[4]="Deshabilitada";
            }

            clase.addRow(object);
        }
        vista.tableEmpresa.setModel(clase);
    }
    
    //Metodo para Listar Empresas
    public void listarByRuc(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        EmpresasDAO dao = manager.getEmpresasDAO();
        
        long ruc = Long.parseLong(vista.txtRuc.getText());
                
        Empresas lista = dao.getByRucEmpresa(ruc);
        
        if (lista!=null) {
            Object[] object = new Object[5];

        for (int i = 0; i < 1; i++) {
            object[0] = lista.getId_empresa();
            object[1] = lista.getRuc();
            object[2] = lista.getRazon_social();
            object[3] = lista.getNombre_comercial();
            
            if (lista.getEstado() ==1) {
                object[4]="Activa";
            }
            if (lista.getEstado() ==0) {
                object[4]="Deshabilitada";
            }

            clase.addRow(object);
        }
        vista.tableEmpresa.setModel(clase);
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese un RUC valido");
            vista.txtRuc.setText("");
        }
        
    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }
    
    public void marcaAgua() {
        TextPrompt ruc = new TextPrompt("N° RUC", vista.txtRuc);
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
