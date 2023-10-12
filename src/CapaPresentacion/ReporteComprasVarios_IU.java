
package CapaPresentacion;

import CapaNegocio.CompraBD;
import CapaNegocio.DetalleCompraBD;
import CapaNegocio.ProveedorBD;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReporteComprasVarios_IU extends javax.swing.JInternalFrame {
 DefaultTableModel tabla_temporal_compras, tabla_temporal_detalle_compras;
    public ReporteComprasVarios_IU() {
        initComponents();
        cargarProveedores();
    }
           private void cargarProveedores() {
        try {
            cmbProveedor.removeAllItems();
            ProveedorBD o_ProveedorBD = new ProveedorBD();
            DefaultTableModel tabla_temporal;
            tabla_temporal = o_ProveedorBD.reportarProveedor();
            cmbProveedor.addItem("Seleccionar");

            for (int i = 0; i < tabla_temporal.getRowCount(); i++) {
                String proveedor = String.valueOf(tabla_temporal.getValueAt(i, 1));
                cmbProveedor.addItem(proveedor);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al cargar proveedor", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar_tabla_formulario() {
        tabla_temporal_compras = (DefaultTableModel) tabla_reporte_compras.getModel();
        tabla_temporal_compras.setRowCount(0);

        tabla_temporal_detalle_compras = (DefaultTableModel) tabla_reporte_detalle_compas.getModel();
        tabla_temporal_detalle_compras.setRowCount(0);
    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }

    private double dineroGastado() {
        tabla_temporal_compras = (DefaultTableModel) tabla_reporte_compras.getModel();
        int maxPedidos = tabla_temporal_compras.getRowCount();
        double total = 0;
        for (int i = 0; i < maxPedidos; i++) {
            total = total + Double.parseDouble(tabla_temporal_compras.getValueAt(i, 8).toString());
        }
        return total;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dcFecha_inicio_fecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dcFecha_final_fecha = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnImprimir = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        dcFecha_final_documento = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        dcFecha_inicio_documento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cmbDocumento = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtTotalCompra_doc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dcFecha_inicio_proveedor = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dcFecha_final_proveedor = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        btnBuscar1 = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        txtTotalCompras_proveedor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_detalle_compas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_reporte_compras = new javax.swing.JTable();

        jLabel1.setText("FECHA INICIO");

        jLabel2.setText("FECHA FINAL");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("MPRIMIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dcFecha_inicio_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(dcFecha_final_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(432, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addComponent(dcFecha_final_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(dcFecha_inicio_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REPORTE X FECHA", jPanel1);

        btnImprimir.setText("MPRIMIR");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("FECHA FINAL");

        jLabel4.setText("FECHA INICIO");

        cmbDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BOLETA", "FACTURA" }));
        cmbDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDocumentoActionPerformed(evt);
            }
        });

        jLabel5.setText("TOTAL COMPRAS");

        txtTotalCompra_doc.setEditable(false);
        txtTotalCompra_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCompra_docActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(dcFecha_inicio_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(dcFecha_final_documento, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotalCompra_doc, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnImprimir)
                        .addComponent(jLabel5)
                        .addComponent(txtTotalCompra_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dcFecha_final_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(dcFecha_inicio_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("REPORTE X DOCUMENTO", jPanel2);

        jLabel6.setText("FECHA INICIO");

        jLabel7.setText("FECHA FINAL");

        jLabel8.setText("TOTAL COMPRAS");

        jLabel9.setText("PROVEEDOR");

        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnImprimir1.setText("MPRIMIR");
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });

        txtTotalCompras_proveedor.setEditable(false);
        txtTotalCompras_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalCompras_proveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcFecha_inicio_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFecha_final_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImprimir1)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTotalCompras_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscar1)
                        .addComponent(jLabel8)
                        .addComponent(btnImprimir1)
                        .addComponent(txtTotalCompras_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dcFecha_final_proveedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcFecha_inicio_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(78, 78, 78))
        );

        jTabbedPane1.addTab("REPORTE X PROVEEDOR", jPanel3);

        tabla_reporte_detalle_compas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla_reporte_detalle_compas);

        jLabel10.setText("Detelle");

        tabla_reporte_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIFO", "FECHA", "RUC", "PROVEEDOR", "DOCUMENTO", "CORRELATIVO", "TIPO PAGO", "FORMA PAGO", "TOTAL", "USUARIO", "TIENDA"
            }
        ));
        tabla_reporte_compras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_comprasMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_reporte_compras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTabbedPane1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(92, 92, 92)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(266, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            limpiar_tabla_formulario();
            CompraBD o_CompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            if (dcFecha_inicio_documento.getDate() != null) {
                if (dcFecha_final_documento.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    String fechaInicio = dcn.format(dcFecha_inicio_documento.getDate());
                    String fechaFinal = dcn.format(dcFecha_final_documento.getDate());
                    String documento = cmbDocumento.getSelectedItem().toString();
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = o_CompraBD.reportarCompraDocumento(fechaInicio, fechaFinal, documento);
                    int cant = tabla_temporal.getRowCount();

                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        String proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        documento = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String tipo_pago = tabla_temporal.getValueAt(i, 5).toString();
                        String forma_pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, documento, correlativo, tipo_pago, forma_pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                        tabla_reporte_compras.setModel(tabla_temporal_compras);
                        double total_compras_documento = dineroGastado();
                        BigDecimal numero = new BigDecimal(total_compras_documento);
                        BigDecimal decimal_compras = numero.setScale(2, RoundingMode.DOWN);

                        txtTotalCompra_doc.setText("" + decimal_compras);
                        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    }
                } else {
                    advertencia("Ingrese la fecha final");
                    dcFecha_final_documento.requestFocus();
                }
            } else {
                advertencia("Ingrese la fecha final");
                dcFecha_inicio_documento.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar compra por documento", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
 try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            limpiar_tabla_formulario();
            CompraBD o_CompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
            if (dcFecha_inicio_proveedor.getDate() != null) {
                if (dcFecha_final_proveedor.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    String fechaInicio = dcn.format(dcFecha_inicio_proveedor.getDate());
                    String fechaFinal = dcn.format(dcFecha_final_proveedor.getDate());
                    String proveedor = cmbProveedor.getSelectedItem().toString();
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = o_CompraBD.reporteCompraProveedor(fechaInicio, fechaFinal, proveedor);
                    int cant = tabla_temporal.getRowCount();

                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        String documento = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String tipo_pago = tabla_temporal.getValueAt(i, 5).toString();
                        String forma_pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, documento, correlativo, tipo_pago, forma_pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                        tabla_reporte_compras.setModel(tabla_temporal_compras);
                        double total_compras_proveedor = dineroGastado();
                        BigDecimal numero = new BigDecimal(total_compras_proveedor);
                        BigDecimal decimal_compras = numero.setScale(2, RoundingMode.DOWN);

                        txtTotalCompras_proveedor.setText("" + decimal_compras);
                        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    }
                } else {
                    advertencia("Ingrese la fecha final");
                  dcFecha_final_proveedor.requestFocus();
                }
            } else {
                advertencia("Ingrese la fecha inicio");
                dcFecha_inicio_proveedor.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar compra por proveedor", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void txtTotalCompras_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCompras_proveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCompras_proveedorActionPerformed

    private void txtTotalCompra_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalCompra_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalCompra_docActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   try {
            limpiar_tabla_formulario();
            CompraBD o_CompraBD = new CompraBD();
            SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");

            if (dcFecha_final_fecha.getDate() != null) {
                if (dcFecha_inicio_fecha.getDate() != null) {
                    setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
                    String fechaInicio = dcn.format(dcFecha_inicio_fecha.getDate());
                    String fechaFinal = dcn.format(dcFecha_final_fecha.getDate());
                    DefaultTableModel tabla_temporal;
                    tabla_temporal = o_CompraBD.reportarCompraFecha(fechaInicio, fechaFinal);
                    int cant = tabla_temporal.getRowCount();
                    for (int i = 0; i < cant; i++) {
                        String idcompra = tabla_temporal.getValueAt(i, 0).toString();
                        String fecha = tabla_temporal.getValueAt(i, 1).toString();
                        String ruc = tabla_temporal.getValueAt(i, 12).toString();
                        String proveedor = tabla_temporal.getValueAt(i, 2).toString();
                        String documento = tabla_temporal.getValueAt(i, 3).toString();
                        String correlativo = tabla_temporal.getValueAt(i, 4).toString();
                        String tipo_pago = tabla_temporal.getValueAt(i, 5).toString();
                        String forma_pago = tabla_temporal.getValueAt(i, 6).toString();
                        String total = tabla_temporal.getValueAt(i, 11).toString();
                        String tienda = Login_IU.tienda;
                        String uDni = Login_IU.dni_publico;
                        Object[] data = {idcompra, fecha, ruc, proveedor, documento, correlativo, tipo_pago, forma_pago, total, uDni, tienda};
                        tabla_temporal_compras.addRow(data);
                    }
                    tabla_reporte_compras.setModel(tabla_temporal_compras);
                    setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                } else {
                    advertencia("Ingrese la fecha final");
                    dcFecha_inicio_fecha.requestFocus();
                }
            } else {
                advertencia("Ingrese la fecha inicio");
                dcFecha_final_fecha.requestFocus();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar compras por fecha", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDocumentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDocumentoActionPerformed

    private void tabla_reporte_comprasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_comprasMousePressed
        int fila_seleccionada = tabla_reporte_compras.getSelectedRow();
        DetalleCompraBD o_DetalleCompraBD = new DetalleCompraBD();
        int idcompra = Integer.parseInt(tabla_temporal_compras.getValueAt(fila_seleccionada, 0).toString());
        tabla_temporal_detalle_compras = o_DetalleCompraBD.buscarDetalleCompra(idcompra);
        tabla_reporte_detalle_compas.setModel(tabla_temporal_detalle_compras);        // TODO add your handling code here:
    }//GEN-LAST:event_tabla_reporte_comprasMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JComboBox<String> cmbDocumento;
    private javax.swing.JComboBox<String> cmbProveedor;
    private com.toedter.calendar.JDateChooser dcFecha_final_documento;
    private com.toedter.calendar.JDateChooser dcFecha_final_fecha;
    private com.toedter.calendar.JDateChooser dcFecha_final_proveedor;
    private com.toedter.calendar.JDateChooser dcFecha_inicio_documento;
    private com.toedter.calendar.JDateChooser dcFecha_inicio_fecha;
    private com.toedter.calendar.JDateChooser dcFecha_inicio_proveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabla_reporte_compras;
    private javax.swing.JTable tabla_reporte_detalle_compas;
    private javax.swing.JTextField txtTotalCompra_doc;
    private javax.swing.JTextField txtTotalCompras_proveedor;
    // End of variables declaration//GEN-END:variables
}
