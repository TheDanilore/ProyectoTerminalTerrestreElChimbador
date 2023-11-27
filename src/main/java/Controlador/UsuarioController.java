/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.CargoDAO;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.UsuarioDAO;
import DAO.mysql.MySQLCargoDAO;
import DAO.mysql.MySQLDaoManager;
import DAO.mysql.MySQLUsuarioDAO;
import Modelo.Cargo;
import Modelo.Usuario;
import Vista.LoginUser;
import Vista.UsuariosAdminVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class UsuarioController implements ActionListener {
    private DAOManager manager;
    UsuariosAdminVista vista = new UsuariosAdminVista();
    
    LoginUser loginVista = new LoginUser();
    Usuario modelo = new Usuario();
    DefaultTableModel clase = new DefaultTableModel();

    

    public UsuarioController(UsuariosAdminVista v, DAOManager manager) throws DAOException {
        this.vista = v;
        this.manager=manager;
        this.vista.btnGuardarUsu.addActionListener(this);
        this.vista.btnActualizarUsu.addActionListener(this);
        this.vista.btnNuevoUsu.addActionListener(this);
        this.vista.btnBajaUsu.addActionListener(this);
        this.vista.btnActivarUsu.addActionListener(this);
        
        //this.loginVista = lv;
        
        
        //this.loginVista.btnLoginUser.addActionListener(this);
        LimpiarTable();
        ListarUsuarios(vista.tableUsuario);
    }





    @Override
    public void actionPerformed(ActionEvent e) {

        //Si da clic el boton login
        /*if (e.getSource() == loginVista.btnLoginUser) {
            login();
        }*/

        if (e.getSource() == vista.btnGuardarUsu) {
            try {
                guardarUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnActualizarUsu) {
            try {
                actualizarUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnNuevoUsu) {
            nuevoUsuario();
        }
        if (e.getSource() == vista.btnActivarUsu) {
            try {
                activarUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == vista.btnBajaUsu) {
            try {
                bajaUsuario();
            } catch (DAOException ex) {
                Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

    /*public void login() {
        if (loginVista.txtContra.getText().equals("") || loginVista.txtUser.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese su usuario y/o contraseña");
        } else {
            String username = loginVista.txtUser.getText();
            char[] passwordChars = loginVista.txtContra.getPassword();
            String password = new String(passwordChars);

            if(!"".equals(username) ||!"".equals(password) ){
            UsuarioModelo loginmodelo =new UsuarioModelo();
            UsuarioDAO dao = new UsuarioDAO();
            
            loginmodelo=dao.log(username, password);
            if(loginmodelo.getUsername()!=null && loginmodelo.getPassword()!=null){
                int rol = modelo.getId_rol();

                if (rol == 1) {
                    PrincipalAdmin principalAdmin = new PrincipalAdmin();
                    principalAdmin.show();
                    String nombrerol = "Administrador";
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso como " + modelo.getNombres_usuario()
                            + ", y tu rol es: " + nombrerol);
                    
                } else if (rol == 2) {

                    PrincipalUsuario principalUsuario = new PrincipalUsuario();
                    principalUsuario.show();
                    String nombrerol = "Usuario";
                    JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso como " + modelo.getNombres_usuario()
                            + ", y tu rol es: " + nombrerol);
                }
                loginVista.dispose();
            }else{
                JOptionPane.showMessageDialog(null, "El usuario y/o la contraseña es incorrecta");
            }
        }
            Arrays.fill(passwordChars, ' ');
        }
    }

    public UsuarioModelo getUsuario() {
        return modelo;
    }*/
    
    public void guardarUsuario() throws DAOException {
        if (camposValidos()) {
            modelo.setNombres(String.valueOf(vista.txtNombreUsuario.getText()));
            modelo.setUsuario(vista.txtUsernameUsuario.getText());
            modelo.setContra_usuarios(vista.txtContraUsuario.getText());
            
            if ("Administrador".equals(vista.cbxRolUser.getSelectedItem().toString())) {
                modelo.setCargo(1);
            }else{
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
            JOptionPane.showMessageDialog(null, "Rellene todos los campos");
        }
    }
    
    public void actualizarUsuario () throws DAOException{
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
            }else{
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

    
    public void nuevoUsuario(){
        LimpiarUsuario();
        
    }
    
    public void activarUsuario() throws DAOException{
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
                
            }else{
                LimpiarUsuario();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }
    
    public void bajaUsuario() throws DAOException{
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
                
            }else{
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
            if (lista.get(i).getCargo()== 1) {
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
    
    private void llenarCargos() throws DAOException{
        
        CargoDAO dao = manager.getCargoDAO();
        ArrayList<Cargo> lista = (ArrayList<Cargo>) dao.listAll();
        
        
        //int idselect = 1;
        vista.cbxRolUser.removeAllItems();
        
        
        for (int i = 0; i < lista.size(); i++) {
            vista.cbxRolUser.addItem(lista.get(i).getDescripcion());
        }
        
        //cbxTipoDocumentoIdentidad.setSelectedItem(new TipoDocumentoIdentidad(idselect));
    }

}
