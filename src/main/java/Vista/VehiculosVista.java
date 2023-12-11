/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Clases.Evento;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author ASUS
 */
public class VehiculosVista extends javax.swing.JInternalFrame {

    
    Evento event = new Evento();
    public VehiculosVista() {
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
        cbxTipoVehiculo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnDarBaja = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnActivar = new javax.swing.JLabel();

        setBackground(new java.awt.Color(236, 233, 233));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Vehículos");

        jPanel1.setBackground(new java.awt.Color(236, 233, 233));
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 580, 500));

        jLabel7.setFont(new java.awt.Font("72", 3, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("LISTADO DE VEHÍCULOS REGISTRADOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 260, -1));

        jLabel8.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("REGISTRA UN NUEVO VEHÍCULO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 30));

        jLabel14.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel14.setText("Tipo de Vehiculo:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 20));

        cbxTipoVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        cbxTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, -1));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 100, 30));

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, -1, -1));

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        btnDarBaja.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDarBaja.setForeground(new java.awt.Color(255, 255, 255));
        btnDarBaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDarBaja.setText("Dar de Baja");
        btnDarBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDarBaja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 153, 255));

        btnActivar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActivar.setForeground(new java.awt.Color(255, 255, 255));
        btnActivar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActivar.setText("Activar");
        btnActivar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnActivar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActivar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 420, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaVehiculoKeyTyped
        event.placaKeyPress(evt, txtPlacaVehiculo);
    }//GEN-LAST:event_txtPlacaVehiculoKeyTyped

    private void tableVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiculoMouseClicked
        
    }//GEN-LAST:event_tableVehiculoMouseClicked

    private void cbxTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoVehiculoActionPerformed
        // TODO add your handling code here:ss
    }//GEN-LAST:event_cbxTipoVehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnActivar;
    public javax.swing.JLabel btnActualizar;
    public javax.swing.JLabel btnDarBaja;
    public javax.swing.JLabel btnGuardar;
    public javax.swing.JLabel btnNuevo;
    public javax.swing.JComboBox<String> cbxTipoVehiculo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableVehiculo;
    public javax.swing.JTextField txtIdVehiculo;
    public javax.swing.JTextField txtPlacaVehiculo;
    // End of variables declaration//GEN-END:variables
}
