/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.UsuarioDAO;
import Modelo.Usuario;
import Vista.ConsultarUsuarioVista;
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
public class ConsultarUsuarioController implements MouseListener {

    private DAOManager manager;
    ConsultarUsuarioVista vista = new ConsultarUsuarioVista();
    Usuario modelo = new Usuario();

    DefaultTableModel clase = new DefaultTableModel();

    public ConsultarUsuarioController(ConsultarUsuarioVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnBuscar.addMouseListener(this);
        this.vista.btnListar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.tableUsuario.addMouseListener(this);
        this.LimpiarTable();
        this.listar(vista.tableUsuario);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnBuscar) {

            try {
                LimpiarTable();
                listarById(vista.tableUsuario);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == vista.btnListar) {

            try {
                LimpiarTable();
                listar(vista.tableUsuario);
            } catch (DAOException ex) {
                Logger.getLogger(ConsultarUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
    }

    public void reporteExcel() {
        Excel.reporteUsuario();
    }

    //Metodo para listar usuarios
    public void listar(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        UsuarioDAO dao = manager.getUsuarioDAO();
        List<Usuario> lista = dao.listAll();
        Object[] ob = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getId_usuarios();
            ob[1] = lista.get(i).getNombres();
            ob[2] = lista.get(i).getUsuario();
            ob[3] = lista.get(i).getContra_usuarios();
            ob[4] = lista.get(i).getCargo();

            //rol
            if (lista.get(i).getCargo() == 1) {
                ob[4] = "Administrador";
            }
            if (lista.get(i).getCargo() == 2) {
                ob[4] = "Vigilante de Garita";
            }

            ob[5] = lista.get(i).getEstado();
            //estado
            if (lista.get(i).getEstado() == 1) {
                ob[5] = "Activo";
            }
            if (lista.get(i).getEstado() == 0) {
                ob[5] = "Deshabilitado";
            }
            clase.addRow(ob);
        }
        vista.tableUsuario.setModel(clase);

    }

    public void listarById(JTable tabla) throws DAOException {
        clase = (DefaultTableModel) tabla.getModel();
        UsuarioDAO dao = manager.getUsuarioDAO();

        int id = Integer.parseInt(vista.txtId.getText());

        Usuario lista = dao.getById(id);

        if (lista != null) {
            Object[] ob = new Object[6];

            for (int i = 0; i < 1; i++) {
                ob[0] = lista.getId_usuarios();
                ob[1] = lista.getNombres();
                ob[2] = lista.getUsuario();
                ob[3] = lista.getContra_usuarios();

                //rol
                if (lista.getCargo() == 1) {
                    ob[4] = "Administrador";
                }
                if (lista.getCargo() == 2) {
                    ob[4] = "Vigilante de Garita";
                }

                //estado
                if (lista.getEstado() == 1) {
                    ob[5] = "Activo";
                }
                if (lista.getEstado() == 0) {
                    ob[5] = "Deshabilitado";
                }
                clase.addRow(ob);
            }
            vista.tableUsuario.setModel(clase);

        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un id valido");
        }

    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public void marcaAgua() {
        TextPrompt id = new TextPrompt("Id del Usuario", vista.txtId);
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
