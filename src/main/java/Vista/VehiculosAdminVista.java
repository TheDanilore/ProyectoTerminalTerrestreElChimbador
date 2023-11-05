/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Clases.Evento;
import DAO.VehiculoDAO;
import Modelo.VehiculoModelo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class VehiculosAdminVista extends javax.swing.JInternalFrame {

    DefaultTableModel clase = new DefaultTableModel();
    Evento event = new Evento();
    VehiculoModelo vehiculoModelo = new VehiculoModelo();
    VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public VehiculosAdminVista() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPlacaVehiculo = new javax.swing.JTextField();
        txtIdVehiculo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVehiculo = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnNuevoVehiculo = new javax.swing.JLabel();
        btnEditarVehiculo = new javax.swing.JLabel();
        btnGuardarVehiculo = new javax.swing.JLabel();
        btnBajaVehiculo = new javax.swing.JLabel();
        btnActivarVehiculo = new javax.swing.JLabel();
        cbxTipoVehiculo = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnDarBaja = new javax.swing.JButton();
        btnActivar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Vehículos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("72", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("VEHÍCULOS");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 280, 40));

        jLabel12.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel12.setText("Placa:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 20));

        txtPlacaVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtPlacaVehiculo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPlacaVehiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPlacaVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaVehiculoKeyTyped(evt);
            }
        });
        jPanel1.add(txtPlacaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 130, 20));

        txtIdVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtIdVehiculo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdVehiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdVehiculo.setEnabled(false);
        jPanel1.add(txtIdVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 20, 20));

        tableVehiculo.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        tableVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Placa", "Tipo de Vehiculo", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVehiculoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableVehiculo);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 600, 500));

        jLabel7.setFont(new java.awt.Font("72", 3, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("LISTADO DE VEHÍCULOS REGISTRADOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 260, -1));

        jLabel8.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("REGISTRA UN NUEVO VEHÍCULO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 30));

        jLabel14.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel14.setText("Tipo de Vehiculo:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 20));

        btnNuevoVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevoVehiculo.setForeground(new java.awt.Color(0, 153, 0));
        btnNuevoVehiculo.setText("Nuevo");
        btnNuevoVehiculo.setToolTipText("");
        btnNuevoVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevoVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevoVehiculoMouseClicked(evt);
            }
        });
        jPanel1.add(btnNuevoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 40, 20));

        btnEditarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditarVehiculo.setForeground(new java.awt.Color(0, 153, 0));
        btnEditarVehiculo.setText("Actualizar");
        btnEditarVehiculo.setToolTipText("");
        btnEditarVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarVehiculoMouseClicked(evt);
            }
        });
        jPanel1.add(btnEditarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 60, 20));

        btnGuardarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardarVehiculo.setForeground(new java.awt.Color(0, 153, 0));
        btnGuardarVehiculo.setText("GUARDAR");
        btnGuardarVehiculo.setToolTipText("");
        btnGuardarVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarVehiculoMouseClicked(evt);
            }
        });
        jPanel1.add(btnGuardarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 60, 20));

        btnBajaVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBajaVehiculo.setForeground(new java.awt.Color(0, 153, 0));
        btnBajaVehiculo.setText("Dar de Baja");
        btnBajaVehiculo.setToolTipText("");
        btnBajaVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBajaVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBajaVehiculoMouseClicked(evt);
            }
        });
        jPanel1.add(btnBajaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 70, 20));

        btnActivarVehiculo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActivarVehiculo.setForeground(new java.awt.Color(0, 153, 0));
        btnActivarVehiculo.setText("Activar Vehículo");
        btnActivarVehiculo.setToolTipText("");
        btnActivarVehiculo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivarVehiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActivarVehiculoMouseClicked(evt);
            }
        });
        jPanel1.add(btnActivarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 100, 20));

        cbxTipoVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        cbxTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bus de Transporte", "Camion de Carga", "Vehiculo del Personal", "Vehiculo Particular", "Otro Vehiculo" }));
        cbxTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, -1));

        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        btnActualizar.setText("Actualizar");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        btnNuevo.setText("Nuevo");
        jPanel1.add(btnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        btnDarBaja.setText("Dar de Baja");
        jPanel1.add(btnDarBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        btnActivar.setText("Activar Vehiculo");
        jPanel1.add(btnActivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaVehiculoKeyTyped
        
    }//GEN-LAST:event_txtPlacaVehiculoKeyTyped

    private void tableVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiculoMouseClicked
        int fila = tableVehiculo.rowAtPoint(evt.getPoint());

        txtIdVehiculo.setText(tableVehiculo.getValueAt(fila, 0).toString());
        txtPlacaVehiculo.setText(tableVehiculo.getValueAt(fila, 1).toString());
        cbxTipoVehiculo.setSelectedItem(tableVehiculo.getValueAt(fila, 2).toString());
    }//GEN-LAST:event_tableVehiculoMouseClicked

    private void btnNuevoVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoVehiculoMouseClicked
        
    }//GEN-LAST:event_btnNuevoVehiculoMouseClicked

    private void btnEditarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarVehiculoMouseClicked
        
    }//GEN-LAST:event_btnEditarVehiculoMouseClicked

    private void btnGuardarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarVehiculoMouseClicked
        
    }//GEN-LAST:event_btnGuardarVehiculoMouseClicked

    private void btnBajaVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBajaVehiculoMouseClicked
        
    }//GEN-LAST:event_btnBajaVehiculoMouseClicked

    private void btnActivarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActivarVehiculoMouseClicked
        
    }//GEN-LAST:event_btnActivarVehiculoMouseClicked

    private void cbxTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoVehiculoActionPerformed
        // TODO add your handling code here:ss
    }//GEN-LAST:event_cbxTipoVehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActivar;
    public javax.swing.JLabel btnActivarVehiculo;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JLabel btnBajaVehiculo;
    public javax.swing.JButton btnDarBaja;
    public javax.swing.JLabel btnEditarVehiculo;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JLabel btnGuardarVehiculo;
    public javax.swing.JButton btnNuevo;
    public javax.swing.JLabel btnNuevoVehiculo;
    public javax.swing.JComboBox<String> cbxTipoVehiculo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableVehiculo;
    public javax.swing.JTextField txtIdVehiculo;
    public javax.swing.JTextField txtPlacaVehiculo;
    // End of variables declaration//GEN-END:variables
}
