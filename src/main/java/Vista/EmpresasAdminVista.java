/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Clases.Evento;
import Modelo.Empresas;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class EmpresasAdminVista extends javax.swing.JInternalFrame {

    Evento event = new Evento();
    
    public EmpresasAdminVista() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRucEmpresa = new javax.swing.JTextField();
        txtRazonEmpresa = new javax.swing.JTextField();
        txtIdEmpresa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEmpresa = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNombreComercialEmpresa = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
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
        jPanel7 = new javax.swing.JPanel();
        btnExcel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro de Empresas");

        jPanel1.setBackground(new java.awt.Color(236, 233, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("72", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("EMPRESAS");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 280, 40));

        jLabel12.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel12.setText("RUC:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 60, 20));

        txtRucEmpresa.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtRucEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRucEmpresa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtRucEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucEmpresaKeyTyped(evt);
            }
        });
        jPanel1.add(txtRucEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 110, 20));

        txtRazonEmpresa.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtRazonEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRazonEmpresa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtRazonEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonEmpresaActionPerformed(evt);
            }
        });
        txtRazonEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRazonEmpresaKeyTyped(evt);
            }
        });
        jPanel1.add(txtRazonEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 290, 20));

        txtIdEmpresa.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtIdEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdEmpresa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdEmpresa.setEnabled(false);
        jPanel1.add(txtIdEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 20, 20));

        tableEmpresa.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        tableEmpresa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "RUC", "Razon Social", "Nombre Comercial", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpresaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableEmpresa);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 570, 500));

        jLabel7.setFont(new java.awt.Font("72", 3, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("LISTADO DE EMPRESAS REGISTRADAS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 260, -1));

        jLabel8.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("REGISTRA UNA NUEVA EMPRESA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 250, 30));

        jLabel14.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel14.setText("Razon Social:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 20));

        txtNombreComercialEmpresa.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtNombreComercialEmpresa.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNombreComercialEmpresa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNombreComercialEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreComercialEmpresaKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombreComercialEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 260, 20));

        jLabel15.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel15.setText("Nombre Comercial:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 20));

        jLabel10.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 153, 0));
        jLabel10.setText("Reportes");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 80, 30));

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

        jPanel7.setBackground(new java.awt.Color(51, 255, 51));

        btnExcel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel1.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExcel1.setText("Excel");
        btnExcel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtRucEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucEmpresaKeyTyped
        event.numberKeyPress(evt);
    }//GEN-LAST:event_txtRucEmpresaKeyTyped

    private void tableEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpresaMouseClicked
        
    }//GEN-LAST:event_tableEmpresaMouseClicked

    private void txtRazonEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRazonEmpresaKeyTyped
        // TODO add your handling code here:
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtRazonEmpresaKeyTyped

    private void txtRazonEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonEmpresaActionPerformed

    }//GEN-LAST:event_txtRazonEmpresaActionPerformed

    private void txtNombreComercialEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreComercialEmpresaKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtNombreComercialEmpresaKeyTyped
                                             


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnActivar;
    public javax.swing.JLabel btnActualizar;
    public javax.swing.JLabel btnDarBaja;
    public javax.swing.JLabel btnExcel1;
    public javax.swing.JLabel btnGuardar;
    public javax.swing.JLabel btnNuevo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableEmpresa;
    public javax.swing.JTextField txtIdEmpresa;
    public javax.swing.JTextField txtNombreComercialEmpresa;
    public javax.swing.JTextField txtRazonEmpresa;
    public javax.swing.JTextField txtRucEmpresa;
    // End of variables declaration//GEN-END:variables
}
