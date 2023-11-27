/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CargoController;
import Controlador.ConductorController;
import Controlador.EmpresaController;
import Controlador.MetodoPagoController;
import Controlador.TipoVehiculoController;
import Controlador.UsuarioControlador;
import Controlador.UsuarioController;
import Controlador.VehiculoController;
import DAO.DAOException;
import DAO.DAOManager;
import DAO.mysql.MySQLDaoManager;

import DAO.mysql.MySQLUsuarioDAO;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class PrincipalAdmin extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    
    private DAOManager manager;
    MySQLUsuarioDAO loginDAO = new MySQLUsuarioDAO();

    Usuario usuarioModelo = new Usuario();
    LoginUser loginUser;

    public PrincipalAdmin() throws SQLException, DAOException {
        this.loginUser = new LoginUser();
        initComponents();
        this.manager = new MySQLDaoManager();
        this.setExtendedState(MAXIMIZED_BOTH);

        lblNombre.setText(usuarioModelo.getNombres());

        if ("1".equals(String.valueOf(usuarioModelo.getCargo()))) {
            lblRol.setText("Administrador");
        } else if ("2".equals(String.valueOf(usuarioModelo.getCargo()))) {
            lblRol.setText("Vigilante");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblRol = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_EntradaSalida = new javax.swing.JMenu();
        menuEntrada = new javax.swing.JMenuItem();
        menuSalida = new javax.swing.JMenuItem();
        menuConsultarRegistro = new javax.swing.JMenuItem();
        menuRegistrarIncidente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuMetodoPago = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuConductor = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuVehiculo = new javax.swing.JMenuItem();
        menuTipoVehiculo = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuEmpresas = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuUsuario = new javax.swing.JMenuItem();
        menuCargo = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Principal Administrador");

        escritorio.setLayer(lblRol, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(lblNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(164, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(35, 35, 35)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        menu_EntradaSalida.setText("Registro de Entradas y Salidas");
        menu_EntradaSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuEntrada.setText("Registrar Entrada de Vehículos");
        menuEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEntradaActionPerformed(evt);
            }
        });
        menu_EntradaSalida.add(menuEntrada);

        menuSalida.setText("Registrar Salida de Vehículos");
        menu_EntradaSalida.add(menuSalida);

        menuConsultarRegistro.setText("Consultar Entrada o Salida");
        menuConsultarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConsultarRegistroActionPerformed(evt);
            }
        });
        menu_EntradaSalida.add(menuConsultarRegistro);

        menuRegistrarIncidente.setText("Registrar Incidente");
        menuRegistrarIncidente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegistrarIncidenteActionPerformed(evt);
            }
        });
        menu_EntradaSalida.add(menuRegistrarIncidente);

        jMenuBar1.add(menu_EntradaSalida);

        jMenu2.setText("Pagos");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem1.setText("Registrar Pago");
        jMenu2.add(jMenuItem1);

        menuMetodoPago.setText("Metodo de Pago");
        menuMetodoPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuMetodoPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMetodoPagoActionPerformed(evt);
            }
        });
        jMenu2.add(menuMetodoPago);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Conductores");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuConductor.setText("Conductor");
        menuConductor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuConductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConductorActionPerformed(evt);
            }
        });
        jMenu1.add(menuConductor);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Vehículos");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuVehiculo.setText("Vehiculo");
        menuVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVehiculoActionPerformed(evt);
            }
        });
        jMenu3.add(menuVehiculo);

        menuTipoVehiculo.setText("Tipos de Vehículos");
        menuTipoVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTipoVehiculoActionPerformed(evt);
            }
        });
        jMenu3.add(menuTipoVehiculo);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Empresas");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuEmpresas.setText("Empresas");
        menuEmpresas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmpresasActionPerformed(evt);
            }
        });
        jMenu5.add(menuEmpresas);

        jMenuBar1.add(jMenu5);

        jMenu4.setText("Usuarios");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuUsuario.setText("Usuarios");
        menuUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(menuUsuario);

        menuCargo.setText("Roles");
        menuCargo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCargoActionPerformed(evt);
            }
        });
        jMenu4.add(menuCargo);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEntradaActionPerformed
        RegistrarEntrada registrarEntrada = new RegistrarEntrada();
        escritorio.add(registrarEntrada);
        registrarEntrada.show();
    }//GEN-LAST:event_menuEntradaActionPerformed

    private void menuRegistrarIncidenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegistrarIncidenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuRegistrarIncidenteActionPerformed

    private void menuConsultarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConsultarRegistroActionPerformed

    }//GEN-LAST:event_menuConsultarRegistroActionPerformed

    private void menuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuUsuarioActionPerformed
        UsuariosAdminVista vistaUsuario = new UsuariosAdminVista();
        try {
            UsuarioController controller = new UsuarioController(vistaUsuario,manager);
        } catch (DAOException ex) {
            Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        escritorio.add(vistaUsuario);
        vistaUsuario.show();
    }//GEN-LAST:event_menuUsuarioActionPerformed

    private void menuEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmpresasActionPerformed
        EmpresasAdminVista vistaEmpresas = new EmpresasAdminVista();
        try {
            EmpresaController controller = new EmpresaController(vistaEmpresas,manager);
        } catch (DAOException ex) {
            Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        escritorio.add(vistaEmpresas);
        vistaEmpresas.show();
    }//GEN-LAST:event_menuEmpresasActionPerformed

    private void menuVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVehiculoActionPerformed
        VehiculosAdminVista vistaVehiculos = new VehiculosAdminVista();
        try {
            VehiculoController controller = new VehiculoController(vistaVehiculos,manager);
        } catch (DAOException ex) {
            Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        escritorio.add(vistaVehiculos);
        vistaVehiculos.show();
    }//GEN-LAST:event_menuVehiculoActionPerformed

    private void menuConductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConductorActionPerformed
        ConductorVista vista = new ConductorVista();
        try {
            ConductorController controller = new ConductorController(vista,manager);
        } catch (DAOException ex) {
            Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        escritorio.add(vista);
        vista.show();
    }//GEN-LAST:event_menuConductorActionPerformed

    private void menuCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCargoActionPerformed
        CargoVista vista = new CargoVista();
        
    try {
        CargoController controller = new CargoController(vista,manager);
    } catch (DAOException ex) {
        Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
    }
        escritorio.add(vista);
        vista.show();
    }//GEN-LAST:event_menuCargoActionPerformed

    private void menuMetodoPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMetodoPagoActionPerformed
        MetodoPagoVista vista = new MetodoPagoVista();
        try {
            MetodoPagoController controller = new MetodoPagoController(vista,manager);
        } catch (DAOException ex) {
            Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        escritorio.add(vista);
        vista.show();
    }//GEN-LAST:event_menuMetodoPagoActionPerformed

    private void menuTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTipoVehiculoActionPerformed
        TipoVehiculoVista vista = new TipoVehiculoVista();
        try {
            TipoVehiculoController controller = new TipoVehiculoController(vista,manager);
        } catch (DAOException ex) {
            Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        escritorio.add(vista);
        vista.show();
    }//GEN-LAST:event_menuTipoVehiculoActionPerformed

    /**
     * @param args the command line arguments
     */ 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new PrincipalAdmin().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DAOException ex) {
                Logger.getLogger(PrincipalAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private javax.swing.JMenuItem menuCargo;
    private javax.swing.JMenuItem menuConductor;
    private javax.swing.JMenuItem menuConsultarRegistro;
    private javax.swing.JMenuItem menuEmpresas;
    private javax.swing.JMenuItem menuEntrada;
    private javax.swing.JMenuItem menuMetodoPago;
    private javax.swing.JMenuItem menuRegistrarIncidente;
    private javax.swing.JMenuItem menuSalida;
    private javax.swing.JMenuItem menuTipoVehiculo;
    private javax.swing.JMenuItem menuUsuario;
    private javax.swing.JMenuItem menuVehiculo;
    private javax.swing.JMenu menu_EntradaSalida;
    // End of variables declaration//GEN-END:variables
}
