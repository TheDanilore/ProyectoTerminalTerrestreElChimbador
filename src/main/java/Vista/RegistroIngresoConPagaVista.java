/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Clases.Evento;
import DAO.ConductorDAO;
import DAO.DAOException;
import DAO.DAOManager;
import Modelo.Conductor;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Danilore
 */
public class RegistroIngresoConPagaVista extends javax.swing.JInternalFrame {

    Evento event = new Evento();
    public RegistroIngresoConPagaVista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtIdIngresoVehiculo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVehiculo = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtConductor = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTarifaPago = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtTipoVehiculo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbxProvincia = new javax.swing.JComboBox<>();
        cbxDepartamento = new javax.swing.JComboBox<>();
        cbxDistrito = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        txtIdTipoVehiculo = new javax.swing.JTextField();
        txtIdDepartamento = new javax.swing.JTextField();
        txtIdProvincia = new javax.swing.JTextField();
        btnCalcularTarifa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 233, 233));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Ingreso de Vehiculos");

        jPanel1.setBackground(new java.awt.Color(236, 233, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("72", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("REGISTRAR INGRESO DE VEHICULO");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 680, 40));

        jLabel12.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel12.setText("DNI:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 60, 20));

        txtIdIngresoVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtIdIngresoVehiculo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdIngresoVehiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdIngresoVehiculo.setEnabled(false);
        jPanel1.add(txtIdIngresoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 20, 20));

        tableVehiculo.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        tableVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "Conductor", "Placa", "Tipo  de Vehiculo", "Destino", "Fecha", "Usuario", "Tarifa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 600, 500));

        jLabel7.setFont(new java.awt.Font("72", 3, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("LISTADO DE INGRESO DE VEHÍCULOS REGISTRADOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 290, -1));

        jLabel8.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("REGISTRA UN NUEVO INGRESO DE VEHÍCULO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 350, 30));

        txtConductor.setEditable(false);
        txtConductor.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtConductor.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtConductor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtConductor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConductorKeyTyped(evt);
            }
        });
        jPanel1.add(txtConductor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 260, 20));

        txtPlaca.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtPlaca.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPlaca.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaKeyTyped(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 140, 20));

        jLabel16.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel16.setText("Placa:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 70, 20));

        jLabel17.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel17.setText("Tarifa:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 70, 20));

        jLabel18.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel18.setText("Distrito:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, 20));

        txtTarifaPago.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtTarifaPago.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTarifaPago.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTarifaPago.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTarifaPagoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTarifaPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 130, 20));

        jLabel13.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel13.setText("Conductor:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 20));

        txtDni.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtDni.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDni.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 120, 20));

        txtTipoVehiculo.setEditable(false);
        txtTipoVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtTipoVehiculo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTipoVehiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTipoVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTipoVehiculoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 140, 20));

        jLabel19.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel19.setText("Tipo Vehiculo:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 80, 20));

        jLabel20.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel20.setText("Departamento:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 90, 20));

        jLabel21.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel21.setText("Provincia:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 90, 20));

        cbxProvincia.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaActionPerformed(evt);
            }
        });
        jPanel1.add(cbxProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, -1));

        cbxDepartamento.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        cbxDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDepartamentoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 140, -1));

        cbxDistrito.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        cbxDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDistritoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 140, -1));

        jLabel22.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel22.setText("Lugar de Destino:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 120, 20));

        txtIdTipoVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtIdTipoVehiculo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdTipoVehiculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdTipoVehiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdTipoVehiculoKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 30, 20));

        txtIdDepartamento.setEditable(false);
        txtIdDepartamento.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtIdDepartamento.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdDepartamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdDepartamentoKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 30, 20));

        txtIdProvincia.setEditable(false);
        txtIdProvincia.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtIdProvincia.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdProvincia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdProvinciaKeyTyped(evt);
            }
        });
        jPanel1.add(txtIdProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 30, 20));

        btnCalcularTarifa.setBackground(new java.awt.Color(51, 255, 51));
        btnCalcularTarifa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalcularTarifa.setForeground(new java.awt.Color(255, 255, 255));
        btnCalcularTarifa.setText("Calcular");
        btnCalcularTarifa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcularTarifa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularTarifaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCalcularTarifa, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 100, 30));

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, -1, -1));

        jPanel4.setBackground(new java.awt.Color(51, 255, 51));

        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 665, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiculoMouseClicked
        
        
    }//GEN-LAST:event_tableVehiculoMouseClicked

    private void txtConductorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConductorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConductorKeyTyped

    private void txtPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyTyped
        event.placaKeyPress(evt, txtPlaca);
    }//GEN-LAST:event_txtPlacaKeyTyped

    private void txtTarifaPagoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTarifaPagoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTarifaPagoKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtTipoVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTipoVehiculoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoVehiculoKeyTyped

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        // TODO add your handling code here:ss
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void cbxDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDepartamentoActionPerformed

    private void cbxDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDistritoActionPerformed

    private void txtIdTipoVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdTipoVehiculoKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtIdTipoVehiculoKeyTyped

    private void txtIdDepartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdDepartamentoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdDepartamentoKeyTyped

    private void txtIdProvinciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdProvinciaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProvinciaKeyTyped

    private void btnCalcularTarifaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularTarifaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularTarifaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnActualizar;
    public javax.swing.JButton btnCalcularTarifa;
    public javax.swing.JLabel btnEliminar;
    public javax.swing.JLabel btnGuardar;
    public javax.swing.JLabel btnNuevo;
    public javax.swing.JComboBox<String> cbxDepartamento;
    public javax.swing.JComboBox<String> cbxDistrito;
    public javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableVehiculo;
    public javax.swing.JTextField txtConductor;
    public javax.swing.JTextField txtDni;
    public javax.swing.JTextField txtIdDepartamento;
    public javax.swing.JTextField txtIdIngresoVehiculo;
    public javax.swing.JTextField txtIdProvincia;
    public javax.swing.JTextField txtIdTipoVehiculo;
    public javax.swing.JTextField txtPlaca;
    public javax.swing.JTextField txtTarifaPago;
    public javax.swing.JTextField txtTipoVehiculo;
    // End of variables declaration//GEN-END:variables
}
