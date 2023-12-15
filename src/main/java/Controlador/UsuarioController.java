/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Clases.Excel;
import Clases.TextPrompt;
import DAO.CargoDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.UsuarioDAO;
import DAO.mysql.MySQLCargoDAO;
import DAO.mysql.MySQLDaoManager;
import DAO.mysql.MySQLUsuarioDAO;
import Modelo.Cargo;
import Modelo.Usuario;
import Vista.UsuariosAdminVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
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
public class UsuarioController implements MouseListener {

    private DAOManager manager;
    UsuariosAdminVista vista = new UsuariosAdminVista();

    Usuario modelo = new Usuario();
    DefaultTableModel clase = new DefaultTableModel();

    public UsuarioController(UsuariosAdminVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager = manager;
        this.vista.btnGuardar.addMouseListener(this);
        this.vista.btnActualizar.addMouseListener(this);
        this.vista.btnNuevo.addMouseListener(this);
        this.vista.btnDarBaja.addMouseListener(this);
        this.vista.btnActivar.addMouseListener(this);
        this.vista.btnExcel1.addMouseListener(this);
        this.vista.tableUsuario.addMouseListener(this);
        this.vista.txtIdUsuario.setVisible(false);
        LimpiarTable();
        ListarUsuarios(vista.tableUsuario);
        marcaAgua();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vista.btnGuardar) {
            try {
                guardarUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizar) {
            try {
                actualizarUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevo) {
            nuevoUsuario();
        }
        if (e.getSource() == vista.btnActivar) {
            try {
                activarUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnDarBaja) {
            try {
                bajaUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnExcel1) {
            reporteExcel();
        }
        if (e.getSource() == vista.tableUsuario) {
            int fila = vista.tableUsuario.rowAtPoint(e.getPoint());

            vista.txtIdUsuario.setText(vista.tableUsuario.getValueAt(fila, 0).toString());
            vista.txtNombreUsuario.setText(vista.tableUsuario.getValueAt(fila, 1).toString());
            vista.txtUsernameUsuario.setText(vista.tableUsuario.getValueAt(fila, 2).toString());
            vista.txtContraUsuario.setText(vista.tableUsuario.getValueAt(fila, 3).toString());
            vista.cbxRolUser.setSelectedItem(vista.tableUsuario.getValueAt(fila, 4).toString());// Falta Implementar. si es 1 es admin, 2 vigilante de garita

        }

    }

    public void reporteExcel() {
        Excel.reporteUsuario();
    }

    private boolean validarPassword() {
        String passwordChars = vista.txtContraUsuario.getText();
        String password = new String(passwordChars);

        return password.length() >= 6; //Se requiere al menos 6 caracteres para la contraseña
    }

    public void guardarUsuario() throws DAOException {
        if (camposValidos()) {
            modelo.setNombres(String.valueOf(vista.txtNombreUsuario.getText()));
            modelo.setUsuario(vista.txtUsernameUsuario.getText());
            modelo.setContra_usuarios(vista.txtContraUsuario.getText());

            if (validarPassword()) {
                if ("Administrador".equals(vista.cbxRolUser.getSelectedItem().toString())) {
                    modelo.setCargo(1);
                } else {
                    modelo.setCargo(2);
                }

                //Conexion, consulta con la base de datos
                UsuarioDAO dao = manager.getUsuarioDAO();
                dao.add(modelo);

                JOptionPane.showMessageDialog(null, "Usuario Registrado");
                LimpiarTable();
                ListarUsuarios(vista.tableUsuario);
                LimpiarUsuario();
            } else {
                JOptionPane.showMessageDialog(null, "Su contraseña tiene que ser mayor a 5 caracteres ");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }
    }

    public void actualizarUsuario() throws DAOException {
        if ("".equals(vista.txtIdUsuario.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                modelo.setId_usuarios(Integer.parseInt(vista.txtIdUsuario.getText()));
                modelo.setNombres(String.valueOf(vista.txtNombreUsuario.getText()));
                modelo.setUsuario(vista.txtUsernameUsuario.getText());
                modelo.setContra_usuarios(vista.txtContraUsuario.getText());
                if ("Administrador".equals(vista.cbxRolUser.getSelectedItem().toString())) {
                    modelo.setCargo(1);
                } else {
                    modelo.setCargo(2);
                }

                //Conexion, consulta con la base de datos
                UsuarioDAO dao = manager.getUsuarioDAO();
                dao.update(modelo);

                JOptionPane.showMessageDialog(null, "Usuario Modificado");
                LimpiarTable();
                ListarUsuarios(vista.tableUsuario);
                LimpiarUsuario();

            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }

    public void nuevoUsuario() {
        LimpiarUsuario();

    }

    public void activarUsuario() throws DAOException {
        if (!"".equals(vista.txtIdUsuario.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar al Usuario");
            if (pregunta == 0) {
                modelo.setId_usuarios(Integer.parseInt(vista.txtIdUsuario.getText()));
                modelo.setEstado(1);

                UsuarioDAO dao = manager.getUsuarioDAO();
                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se Activo al Usuario");
                LimpiarTable();
                ListarUsuarios(vista.tableUsuario);
                LimpiarUsuario();

            } else {
                LimpiarUsuario();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    public void bajaUsuario() throws DAOException {
        if (!"".equals(vista.txtIdUsuario.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de dar de baja al Usuario");
            if (pregunta == 0) {
                modelo.setId_usuarios(Integer.parseInt(vista.txtIdUsuario.getText()));
                modelo.setEstado(0);
                UsuarioDAO dao = manager.getUsuarioDAO();
                dao.disable(modelo);

                JOptionPane.showMessageDialog(null, "Se dio de baja al Usuario");
                LimpiarTable();
                ListarUsuarios(vista.tableUsuario);
                LimpiarUsuario();

            } else {
                LimpiarUsuario();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }

    //Metodo para listar usuarios
    public void ListarUsuarios(JTable tabla) throws DAOException {
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
        llenarCargos();
    }

    public void LimpiarUsuario() {
        vista.txtIdUsuario.setText("");
        vista.txtContraUsuario.setText("");
        vista.txtNombreUsuario.setText("");
        vista.txtUsernameUsuario.setText("");
        vista.cbxRolUser.setSelectedItem(null);

    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public boolean camposValidos() {
        return !vista.txtContraUsuario.getText().isEmpty()
                && !vista.txtNombreUsuario.getText().isEmpty()
                && !vista.txtUsernameUsuario.getText().isEmpty()
                && vista.cbxRolUser.getSelectedItem() != null;
    }

    private void llenarCargos() throws DAOException {

        CargoDAO dao = manager.getCargoDAO();
        ArrayList<Cargo> lista = (ArrayList<Cargo>) dao.listAll();

        //int idselect = 1;
        vista.cbxRolUser.removeAllItems();

        for (int i = 0; i < lista.size(); i++) {
            vista.cbxRolUser.addItem(lista.get(i).getDescripcion());
        }

        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }

    public void marcaAgua() {
        TextPrompt nombreUser = new TextPrompt("Nombres del Usuario", vista.txtNombreUsuario);
        TextPrompt user = new TextPrompt("Username", vista.txtUsernameUsuario);
        TextPrompt contra = new TextPrompt("Contraseña", vista.txtContraUsuario);
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
