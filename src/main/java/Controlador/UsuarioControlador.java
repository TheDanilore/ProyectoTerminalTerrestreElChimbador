/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.DAOException;
import DAO.DAOManager;
import DAO.UsuarioDAO;
import DAO.mysql.MySQLUsuarioDAO;
import Modelo.Usuario;
import Vista.LoginUser;
import Vista.PrincipalAdmin;
import Vista.PrincipalUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class UsuarioControlador implements ActionListener {

    private final DAOManager manager;

    LoginUser vista;
    private Usuario modelo;

    public UsuarioControlador(LoginUser v, DAOManager manager) throws DAOException, SQLException {
        this.vista = new LoginUser();
        this.manager = manager;
        this.vista = v;
        this.vista.btnLog.addActionListener(this);

    }

    public Usuario getUsuario() {
        return modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnLog) {
            try {
                log();
            } catch (DAOException ex) {
                Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public void log() throws DAOException, SQLException {
        if (camposValidos()) {

            String username = vista.txtUser.getText();
            char[] passwordChars = vista.txtContra.getPassword();
            String password = new String(passwordChars);
            UsuarioDAO dao = manager.getUsuarioDAO();
            Usuario usuario = (Usuario) dao.log(username, password);

            if (usuario != null) {
                this.modelo = usuario;
                vista.dispose();
                int rol = this.getUsuario().getCargo();

                if (rol == 1) {
                    PrincipalAdmin principalAdmin = null;
                    try {
                        principalAdmin = new PrincipalAdmin();
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    principalAdmin.show();
                    String nombrerol = "Administrador";
                    JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso como " + this.getUsuario().getNombres()
                            + ", y tu rol es: " + nombrerol, "Inicio de sesión exitoso", JOptionPane.INFORMATION_MESSAGE);
                } else if (rol == 2) {

                    PrincipalUsuario principalUsuario = new PrincipalUsuario();
                    principalUsuario.show();
                    String nombrerol = "Usuario";
                    JOptionPane.showMessageDialog(vista, "Inicio de sesión exitoso como " + this.getUsuario().getNombres()
                            + ", y tu rol es: " + nombrerol, "Inicio de sesión exitoso", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                // Autenticación fallida
                JOptionPane.showMessageDialog(null, "Inicio sesion fallida");
            }


            Arrays.fill(passwordChars, ' ');


        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }

    public boolean camposValidos() {
        return !vista.txtUser.getText().isEmpty()
                && !vista.txtContra.getText().isEmpty();
    }

}
