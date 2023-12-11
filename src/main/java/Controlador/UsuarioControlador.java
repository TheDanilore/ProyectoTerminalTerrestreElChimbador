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
import Vista.PrincipalAdmin;
import Vista.PrincipalUsuario;
import Vista.login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

/**
 *
 * @author ASUS
 */
public class UsuarioControlador implements MouseListener {

    private final DAOManager manager;
    login vista = new login();
    private Usuario modelo;

    public UsuarioControlador(login v, DAOManager manager) throws DAOException, SQLException {
        this.vista = v;
        this.manager = manager;
        this.vista = v;
        this.vista.lblLogin.addMouseListener(this);
        recuperarContraseña();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.lblLogin) {
            try {
                log();
                recordarContraseña();
            } catch (DAOException ex) {
                Logger.getLogger(CargoController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    public Usuario getUsuario() {
        return modelo;
    }

    public void log() throws DAOException, SQLException {

        if (camposValidos()) {
            String username = vista.txtUser.getText();
            char[] passwordChars = vista.txtPassword.getPassword();
            String password = new String(passwordChars);
            UsuarioDAO dao = manager.getUsuarioDAO();
            Usuario usuario = dao.log(username, password);

            if (usuario != null) {
                this.modelo = usuario;
                vista.dispose();
                int rol = this.getUsuario().getCargo();

                if (rol == 1) {
                    PrincipalAdmin principalAdmin = null;

                    principalAdmin = new PrincipalAdmin();

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
                System.err.println("Error: El usuario es nulo");
            }

            Arrays.fill(passwordChars, ' ');
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese su usuario y contraseña");

        }

    }

    public boolean camposValidos() {
        String username = vista.txtUser.getText();
        char[] passwordChars = vista.txtPassword.getPassword();
        String password = new String(passwordChars);

        boolean userValido = validarUsuario(username);
        boolean passValida = validarPassword(password);

        return userValido && passValida;
    }

    private boolean validarUsuario(String username) {
        return !username.isEmpty(); // lógica de validación para el usuario
    }

    private boolean validarPassword(String password) {

        return password.length() >= 6; //Se requiere al menos 6 caracteres para la contraseña
    }

    private void recordarContraseña() {
        if (vista.jCheckBox1.isSelected()) {
            // Si el checkbox está seleccionado, guarda la contraseña en las preferencias
            String password = new String(vista.txtPassword.getPassword());
            Preferences prefs = Preferences.userRoot().node("com.myapp.preferences");
            prefs.put("password", password);
        } else {
            // Si el checkbox no está seleccionado, elimina la contraseña de las preferencias
            Preferences prefs = Preferences.userRoot().node("com.myapp.preferences");
            prefs.remove("password");
        }

    }
    
    
    private void recuperarContraseña() {
        Preferences prefs = Preferences.userRoot().node("com.myapp.preferences");
        String savedPassword = prefs.get("password", "");
        if (!savedPassword.isEmpty()) {
            vista.txtPassword.setText(savedPassword);
            vista.jCheckBox1.setSelected(true); // Marcar el checkbox si se encuentra una contraseña guardada
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
