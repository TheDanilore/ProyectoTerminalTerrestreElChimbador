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
public class ConsultarIngresoVista extends javax.swing.JInternalFrame {

    Evento event = new Evento();
    public ConsultarIngresoVista() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVehiculo = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnBuscarByPlaca = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnListar = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnExcel1 = new javax.swing.JLabel();
        txtPlaca1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnBuscarByDNI = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Ingresos");

        jPanel1.setBackground(new java.awt.Color(236, 233, 233));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("72", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 153, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("VEHÍCULOS REGISTRADOS");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 500, 40));

        tableVehiculo.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        tableVehiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo de Documento", "N° de Documento", "Conductor", "Placa", "Tipo  de Vehiculo", "Fecha", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 960, 460));

        jLabel7.setFont(new java.awt.Font("72", 3, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 153, 0));
        jLabel7.setText("LISTADO DE INGRESO DE VEHÍCULOS REGISTRADOS");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 290, -1));

        jLabel10.setFont(new java.awt.Font("72", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 153, 0));
        jLabel10.setText("Reportes");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 80, 30));

        txtPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacaKeyTyped(evt);
            }
        });
        jPanel1.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 100, -1));

        jLabel1.setText("N° de Documento:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 100, -1));

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));

        btnBuscarByPlaca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarByPlaca.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarByPlaca.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarByPlaca.setText("Buscar");
        btnBuscarByPlaca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarByPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarByPlaca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 80, 30));

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        btnListar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnListar.setForeground(new java.awt.Color(255, 255, 255));
        btnListar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnListar.setText("Listar");
        btnListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnListar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 30));

        jPanel5.setBackground(new java.awt.Color(51, 255, 51));

        btnExcel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel1.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExcel1.setText("Excel");
        btnExcel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExcel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 70, 30));

        txtPlaca1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlaca1KeyTyped(evt);
            }
        });
        jPanel1.add(txtPlaca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 100, -1));

        jPanel4.setBackground(new java.awt.Color(51, 255, 51));

        btnBuscarByDNI.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarByDNI.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarByDNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarByDNI.setText("Buscar");
        btnBuscarByDNI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarByDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarByDNI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        jLabel2.setText("N° Placa:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiculoMouseClicked
        

    }//GEN-LAST:event_tableVehiculoMouseClicked

    private void txtPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaKeyTyped
        event.placaKeyPress(evt, txtPlaca);
    }//GEN-LAST:event_txtPlacaKeyTyped

    private void txtPlaca1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlaca1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlaca1KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnBuscarByDNI;
    public javax.swing.JLabel btnBuscarByPlaca;
    public javax.swing.JLabel btnExcel1;
    public javax.swing.JLabel btnListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableVehiculo;
    public javax.swing.JTextField txtPlaca;
    public javax.swing.JTextField txtPlaca1;
    // End of variables declaration//GEN-END:variables
}
