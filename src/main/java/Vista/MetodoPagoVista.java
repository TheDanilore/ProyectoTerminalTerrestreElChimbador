/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Clases.Evento;

/**
 *
 * @author Danilore
 */
public class MetodoPagoVista extends javax.swing.JInternalFrame {

    Evento event = new Evento();
    public MetodoPagoVista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        txtIdMetodoPago = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMetodoPago = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btnExcel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listado de Metodos de Pago");

        jPanel1.setBackground(new java.awt.Color(236, 233, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("72", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("METODOS DE PAGO");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 420, 40));

        jLabel12.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel12.setText("DESCRIPCION:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 20));

        txtDescripcion.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtDescripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 210, 20));

        txtIdMetodoPago.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtIdMetodoPago.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdMetodoPago.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIdMetodoPago.setEnabled(false);
        jPanel1.add(txtIdMetodoPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 20, 20));

        tableMetodoPago.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        tableMetodoPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DESCRIPCION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMetodoPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMetodoPagoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMetodoPago);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 520, 280));

        jLabel7.setFont(new java.awt.Font("72", 3, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("LISTADO DE TIPOS DE METODOS DE PAGO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 260, -1));

        jLabel8.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 153, 0));
        jLabel8.setText("REGISTRA UN NUEVO METODO DE PAGO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 300, 30));

        jLabel10.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 153, 0));
        jLabel10.setText("Reportes");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 80, 30));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, 30));

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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

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

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

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

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

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

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 70, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void tableMetodoPagoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMetodoPagoMouseClicked
        
    }//GEN-LAST:event_tableMetodoPagoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnActualizar;
    public javax.swing.JLabel btnEliminar;
    public javax.swing.JLabel btnExcel1;
    public javax.swing.JLabel btnGuardar;
    public javax.swing.JLabel btnNuevo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableMetodoPago;
    public javax.swing.JTextField txtDescripcion;
    public javax.swing.JTextField txtIdMetodoPago;
    // End of variables declaration//GEN-END:variables
}
