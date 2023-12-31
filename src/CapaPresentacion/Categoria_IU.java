/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package CapaPresentacion;

import CapaDatos.Categoria;
import CapaNegocio.CategoriaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class Categoria_IU extends javax.swing.JInternalFrame {

    /**
     * Creates new form Categoria_IU
     */
    public Categoria_IU() {
        initComponents();
        reporte_categoria();
    }
    
    private void reporte_categoria() {
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        try {
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal = (DefaultTableModel) this.Tabla_Reporte_Categoria.getModel();
            CategoriaBD oCategoriaBD = new CategoriaBD();
            
            List<Categoria> lista_categorias = oCategoriaBD.reportarCategoria();
            for (int i = 0; i < lista_categorias.size(); i++) {
                int idcategoria = lista_categorias.get(i).getIdcategoria();
                String maNombre = lista_categorias.get(i).getCatNombre();
                Object[] data = {idcategoria, maNombre};
                tabla_temporal.addRow(data);
                
            }
            Tabla_Reporte_Categoria.setModel(tabla_temporal);
            int cant = tabla_temporal.getRowCount();
            txtCantidad.setText(""+cant);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
    }
    
    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_categorias = (DefaultTableModel) Tabla_Reporte_Categoria.getModel();
        tabla_temporal_categorias.setRowCount(0);
        
    }
    
    private void limpiar() {
        txtId.setText("");
        txtCantidad.setText("");
        txtNombre.setText("");
        reporte_categoria();
        
    }
    
    private void exito(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "MENSAJE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtBuscarCategoria = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_Reporte_Categoria = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CATEGORIA");

        jLabel1.setText("ID");

        jLabel2.setText("CANTIDAD");

        txtId.setEditable(false);

        txtCantidad.setEditable(false);

        jLabel3.setText("NOMBRE");

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Categoria"));

        jLabel4.setText("CATEGORIA");

        txtBuscarCategoria.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarCategoriaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarCategoriaFocusLost(evt);
            }
        });
        txtBuscarCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarCategoriaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarCategoria)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBuscarCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabla_Reporte_Categoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOMBRE"
            }
        ));
        Tabla_Reporte_Categoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Tabla_Reporte_CategoriaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla_Reporte_Categoria);
        if (Tabla_Reporte_Categoria.getColumnModel().getColumnCount() > 0) {
            Tabla_Reporte_Categoria.getColumnModel().getColumn(0).setMinWidth(150);
            Tabla_Reporte_Categoria.getColumnModel().getColumn(0).setPreferredWidth(50);
            Tabla_Reporte_Categoria.getColumnModel().getColumn(0).setMaxWidth(500);
        }

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNombre))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCerrar))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().length() == 0) {
            if (txtNombre.getText().length() > 0) {
                Categoria oCategoria = new Categoria();
                CategoriaBD oCategoriaBD = new CategoriaBD();
                
                oCategoria.setCatNombre(txtNombre.getText().toUpperCase().trim());
                
                boolean rpta = oCategoriaBD.registarCategoria(oCategoria);
                
                if (rpta) {
                    exito("Se registro con exito");
                    reporte_categoria();
                    limpiar();
                    txtNombre.requestFocus();
                } else {
                    advertencia("Ingrese el nombre");
                    txtNombre.requestFocus();
                }
            } else {
                advertencia("Ingrese el nombre");
                txtNombre.requestFocus();
            }
        } else {
            advertencia("No puedes registrar por que ya existe...");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void Tabla_Reporte_CategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_Reporte_CategoriaMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            
            int fila_seleccionada = Tabla_Reporte_Categoria.getSelectedRow();
            txtId.setText(Tabla_Reporte_Categoria.getValueAt(fila_seleccionada, 0).toString());
            txtNombre.setText(Tabla_Reporte_Categoria.getValueAt(fila_seleccionada, 1).toString());
        }
    }//GEN-LAST:event_Tabla_Reporte_CategoriaMousePressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
                if (txtId.getText().length() > 0) {
            if (txtNombre.getText().length() > 0) {
                Categoria oCategoria = new Categoria();
                CategoriaBD oCategoriaBD = new CategoriaBD();
                
                oCategoria.setIdcategoria(Integer.parseInt(txtId.getText().toUpperCase().trim()));
                oCategoria.setCatNombre(txtNombre.getText().toUpperCase().trim());
                
                boolean rpta = oCategoriaBD.modificarCategoria(oCategoria);
                
                if (rpta) {
                    exito("Se modifico con exito");
                    reporte_categoria();
                    limpiar();
                    txtNombre.requestFocus();
                } else {
                    error("Tienes problemas al modificar");
                }
                
            } else {
                advertencia("Ingrese el nombre");
                txtNombre.requestFocus();
            }
        } else {
            advertencia("No puedes modificar por que ya existe...");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtId.getText().length()>0) {
            int aviso= JOptionPane.showConfirmDialog(rootPane, "Estas seguro de elimininar");
            if (aviso== 0) {
                int idmarca = Integer.parseInt(txtId.getText().trim());
                Categoria oCategoria = new Categoria();
                CategoriaBD oCategoriaBD = new CategoriaBD();
                oCategoria.setIdcategoria(idmarca);
                
                boolean rpta= oCategoriaBD.eliminarCategoria(oCategoria);
                if (rpta) {
                    exito("Se elimino con exito");
                    reporte_categoria();
                    limpiar();
                } else {
                    error("Tienes problemas al eliminar");
                }
                
            }
                    
        } else {
            advertencia("Ingrese un codigo para eliminar una categoria...");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaKeyPressed
        // TODO add your handling code here:
        try {
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal = (DefaultTableModel)this.Tabla_Reporte_Categoria.getModel();
            CategoriaBD oCategoriaBD = new CategoriaBD();
            
            String valor = txtBuscarCategoria.getText().trim();
            List<Categoria> lista_Categorias = oCategoriaBD.buscarCategoria(valor);
            for (int i = 0; i < lista_Categorias.size(); i++) {
                int idcategoria = lista_Categorias.get(i).getIdcategoria();
                String maNombre = lista_Categorias.get(i).getCatNombre();
                Object[]data = {idcategoria, maNombre};
                tabla_temporal.addRow(data);
                
                
            }
            Tabla_Reporte_Categoria.setModel(tabla_temporal);
            
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
         
        } catch (Exception ex) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            ex.printStackTrace();
        }
    }//GEN-LAST:event_txtBuscarCategoriaKeyPressed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
          char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtBuscarCategoriaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarCategoriaKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
           
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // TODO add your handling code here:
        txtNombre.setBackground(Color.yellow);
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        // TODO add your handling code here:
        txtNombre.setBackground(Color.white);
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtBuscarCategoriaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaFocusGained
        // TODO add your handling code here:
        txtBuscarCategoria.setBackground(Color.yellow);
    }//GEN-LAST:event_txtBuscarCategoriaFocusGained

    private void txtBuscarCategoriaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarCategoriaFocusLost
        // TODO add your handling code here:
        txtBuscarCategoria.setBackground(Color.white);
    }//GEN-LAST:event_txtBuscarCategoriaFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_Reporte_Categoria;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscarCategoria;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
