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
public class VehiculosUsuario extends javax.swing.JInternalFrame {

    DefaultTableModel clase = new DefaultTableModel();
    Evento event = new Evento();
    VehiculoModelo vehiculoModelo = new VehiculoModelo();
    VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public VehiculosUsuario() {
        initComponents();
        LimpiarTable();
        ListarVehiculos();
    }

    public void ListarVehiculos() {
        List<VehiculoModelo> listarVehiculo = vehiculoDAO.ListarVehiculo();
        clase = (DefaultTableModel) tableVehiculo.getModel();
        Object[] ob = new Object[5];

        for (int i = 0; i < listarVehiculo.size(); i++) {
            ob[0] = listarVehiculo.get(i).getId_vehiculo();
            ob[1] = listarVehiculo.get(i).getPlaca_vehiculo();
            
            if (listarVehiculo.get(i).getId_tipo_vehiculo()==1) {
                ob[2] = "Bus de Transporte";
            }
            if (listarVehiculo.get(i).getId_tipo_vehiculo()==2) {
                ob[2] = "Camion de Carga";
            }
            if (listarVehiculo.get(i).getId_tipo_vehiculo()==3) {
                ob[2] = "Vehiculo del Personal";
            }
            if (listarVehiculo.get(i).getId_tipo_vehiculo()==4) {
                ob[2] = "Vehiculo Particular";
            }
            if (listarVehiculo.get(i).getId_tipo_vehiculo()==5) {
                ob[2] = "Otro Vehiculo";
            }
            
            ob[3] = listarVehiculo.get(i).getRuta_destino();
            
            if (listarVehiculo.get(i).getId_estado()==1) {
                ob[4] = "Activo"; 
            }
            if (listarVehiculo.get(i).getId_estado()==0) {
                ob[4] = "Deshabilitado"; 
            }
            clase.addRow(ob);
        }
        tableVehiculo.setModel(clase);
    }

    public void LimpiarVehiculo() {
        txtIdVehiculo.setText("");
        txtPlacaVehiculo.setText("");
        cbxTipoVehiculo.setSelectedItem(null);
        txtLugarDestino.setText("");

    }

    public void LimpiarTable() {
        for (int i = 0; i < clase.getRowCount(); i++) {
            clase.removeRow(i);
            i = i - 1;
        }
    }

    public boolean camposValidos() {
        return !txtPlacaVehiculo.getText().isEmpty()
                && !txtLugarDestino.getText().isEmpty()
                && cbxTipoVehiculo.getSelectedItem() != null;
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
        txtLugarDestino = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btnNuevoVehiculo = new javax.swing.JLabel();
        btnEditarVehiculo = new javax.swing.JLabel();
        btnGuardarVehiculo = new javax.swing.JLabel();
        btnActivarVehiculo = new javax.swing.JLabel();
        cbxTipoVehiculo = new javax.swing.JComboBox<>();

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
                "ID", "Placa", "Tipo de Vehiculo", "Ruta de Destino", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        txtLugarDestino.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        txtLugarDestino.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtLugarDestino.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtLugarDestino.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLugarDestinoKeyTyped(evt);
            }
        });
        jPanel1.add(txtLugarDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 210, 20));

        jLabel15.setFont(new java.awt.Font("72", 0, 12)); // NOI18N
        jLabel15.setText("Ciudad de Destino:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 110, 20));

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
        jPanel1.add(btnGuardarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, 20));

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
        jPanel1.add(btnActivarVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 100, 40));

        cbxTipoVehiculo.setFont(new java.awt.Font("72", 0, 13)); // NOI18N
        cbxTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bus de Transporte", "Camion de Carga", "Vehiculo del Personal", "Vehiculo Particular", "Otro Vehiculo" }));
        cbxTipoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxTipoVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPlacaVehiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacaVehiculoKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtPlacaVehiculoKeyTyped

    private void tableVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiculoMouseClicked
        int fila = tableVehiculo.rowAtPoint(evt.getPoint());

        txtIdVehiculo.setText(tableVehiculo.getValueAt(fila, 0).toString());
        txtPlacaVehiculo.setText(tableVehiculo.getValueAt(fila, 1).toString());
        
        cbxTipoVehiculo.setSelectedItem(tableVehiculo.getValueAt(fila, 4).toString());
        txtLugarDestino.setText(tableVehiculo.getValueAt(fila, 3).toString());
    }//GEN-LAST:event_tableVehiculoMouseClicked

    private void txtLugarDestinoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLugarDestinoKeyTyped
        event.textKeyPress(evt);
    }//GEN-LAST:event_txtLugarDestinoKeyTyped

    private void btnNuevoVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevoVehiculoMouseClicked
        LimpiarVehiculo();
    }//GEN-LAST:event_btnNuevoVehiculoMouseClicked

    private void btnEditarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarVehiculoMouseClicked
        if ("".equals(txtIdVehiculo.getText())) {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        } else {
            if (camposValidos()) {
                vehiculoModelo.setId_vehiculo(Integer.parseInt(txtIdVehiculo.getText()));

                if ("Bus de Transporte".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                    vehiculoModelo.setId_tipo_vehiculo(1);
                }
                if ("Camion de Carga".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                    vehiculoModelo.setId_tipo_vehiculo(2);
                }
                if ("Vehiculo del Personal".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                    vehiculoModelo.setId_tipo_vehiculo(3);
                }
                if ("Vehiculo Particular".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                    vehiculoModelo.setId_tipo_vehiculo(4);
                }
                if ("Otro Vehiculo".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                    vehiculoModelo.setId_tipo_vehiculo(5);
                }

                vehiculoModelo.setPlaca_vehiculo(txtPlacaVehiculo.getText());

                //Conexion, consulta con la base de datos
                if (vehiculoDAO.ModificarVehiculo(vehiculoModelo)) {
                    JOptionPane.showMessageDialog(null, "Vehiculo Modificado");
                    LimpiarTable();
                    ListarVehiculos();
                    LimpiarVehiculo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Modificar Vehiculo");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene todos los campos");
            }
        }
    }//GEN-LAST:event_btnEditarVehiculoMouseClicked

    private void btnGuardarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarVehiculoMouseClicked
        if (camposValidos()) {

            vehiculoModelo.setPlaca_vehiculo(txtPlacaVehiculo.getText());
            vehiculoModelo.setRuta_destino(txtLugarDestino.getText());

            if ("Bus de Transporte".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                vehiculoModelo.setId_tipo_vehiculo(1);
            }
            if ("Camion de Carga".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                vehiculoModelo.setId_tipo_vehiculo(2);
            }
            if ("Vehiculo del Personal".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                vehiculoModelo.setId_tipo_vehiculo(3);
            }
            if ("Vehiculo Particular".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                vehiculoModelo.setId_tipo_vehiculo(4);
            }
            if ("Otro Vehiculo".equals(cbxTipoVehiculo.getSelectedItem().toString())) {
                vehiculoModelo.setId_tipo_vehiculo(5);
            }
            
            //Conexion, consulta con la base de datos
            if (vehiculoDAO.RegistrarVehiculo(vehiculoModelo)) {
                JOptionPane.showMessageDialog(null, "Vehiculo Registrado");
                LimpiarTable();
                ListarVehiculos();
                LimpiarVehiculo();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Registrar Vehiculo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }
    }//GEN-LAST:event_btnGuardarVehiculoMouseClicked

    private void btnActivarVehiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActivarVehiculoMouseClicked
        if (!"".equals(txtIdVehiculo.getText())) {
            int pregunta = JOptionPane.showConfirmDialog(null, "Esta seguro de Activar el Vehiculo");
            if (pregunta == 0) {
                vehiculoModelo.setId_vehiculo(Integer.parseInt(txtIdVehiculo.getText()));
                vehiculoModelo.setId_estado(1);
                if (vehiculoDAO.BajaActivarVehiculo(vehiculoModelo)) {

                    JOptionPane.showMessageDialog(null, "Se Activo el Vehiculo");
                    LimpiarTable();
                    ListarVehiculos();
                    LimpiarVehiculo();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al  Activar el Vehiculo");
                }
            } else {
                LimpiarVehiculo();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }
    }//GEN-LAST:event_btnActivarVehiculoMouseClicked

    private void cbxTipoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoVehiculoActionPerformed
        // TODO add your handling code here:ss
    }//GEN-LAST:event_cbxTipoVehiculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel btnActivarVehiculo;
    public javax.swing.JLabel btnEditarVehiculo;
    public javax.swing.JLabel btnGuardarVehiculo;
    public javax.swing.JLabel btnNuevoVehiculo;
    public javax.swing.JComboBox<String> cbxTipoVehiculo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableVehiculo;
    public javax.swing.JTextField txtIdVehiculo;
    public javax.swing.JTextField txtLugarDestino;
    public javax.swing.JTextField txtPlacaVehiculo;
    // End of variables declaration//GEN-END:variables
}
