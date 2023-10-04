/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package CapaPresentacion;

import CapaDatos.Turno;
import CapaNegocio.TurnoBD;
import CapaNegocio.UsuarioBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class Turno_IU extends javax.swing.JInternalFrame {

    int fila_seleccionada = -1;

    /**
     * Creates new form Turno_IU
     */
    public Turno_IU() {
        initComponents();
        reporteTurno();
    }

    private void reporteTurno() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            limpiar_tabla_formulario();
            DefaultTableModel tabla_temporal_turno = (DefaultTableModel) tabla_Reporte_Turno.getModel();
            DefaultTableModel tabla_temporal;
            TurnoBD oTurnoBD = new TurnoBD();
            tabla_temporal = oTurnoBD.reportarTurno();
            int cant = tabla_temporal.getRowCount();
            for (int i = 0; i < cant; i++) {
                int idturno = Integer.parseInt(tabla_temporal.getValueAt(i, 0).toString());
                String descripcion = tabla_temporal.getValueAt(i, 1).toString();
                String inicio = tabla_temporal.getValueAt(i, 2).toString();
                String fin = tabla_temporal.getValueAt(i, 3).toString();
                String dni = tabla_temporal.getValueAt(i, 4).toString();
                Object[] data = {idturno, descripcion, inicio, fin, dni};

                tabla_temporal_turno.addRow(data);

            }
            tabla_Reporte_Turno.setModel(tabla_temporal_turno);
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            e.printStackTrace();
        }
    }

    private void limpiar_tabla_formulario() {
        DefaultTableModel tabla_temporal_turno = (DefaultTableModel) tabla_Reporte_Turno.getModel();
        tabla_temporal_turno.setRowCount(0);
    }

    private void limpiar() {
        txtDni.setText("");
        txtUsuario.setText("");
        txtHoraInicio.setText("");
        txtHoraFinal.setText("");
        cmbTurno.setSelectedIndex(0);
        fila_seleccionada = -1;
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtHoraInicio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtHoraFinal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTurno = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_Reporte_Turno = new javax.swing.JTable();
        btnCerrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TURNO");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Usuario"));

        jLabel1.setText("DNI");

        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.gif"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        jLabel2.setText("USUARIO");

        txtUsuario.setEditable(false);
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtUsuario))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Turno"));

        jLabel3.setText("HORA DE INICIO");

        txtHoraInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraInicioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraInicioFocusLost(evt);
            }
        });
        txtHoraInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraInicioKeyPressed(evt);
            }
        });

        jLabel4.setText("HORA FINAL ");

        txtHoraFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoraFinalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoraFinalFocusLost(evt);
            }
        });
        txtHoraFinal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoraFinalKeyPressed(evt);
            }
        });

        jLabel5.setText("TURNO");

        cmbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar turno", "TURNO1", "TURNO2", "TURNO3", "TURNO4" }));
        cmbTurno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmbTurnoKeyPressed(evt);
            }
        });

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        btnRegistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnRegistrarKeyPressed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR ");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtHoraFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cmbTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        tabla_Reporte_Turno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "DESCRIPCION", "HORA INICIO", "HORA FINAL", "USUARIO"
            }
        ));
        tabla_Reporte_Turno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_Reporte_TurnoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_Reporte_Turno);
        if (tabla_Reporte_Turno.getColumnModel().getColumnCount() > 0) {
            tabla_Reporte_Turno.getColumnModel().getColumn(0).setMinWidth(50);
            tabla_Reporte_Turno.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabla_Reporte_Turno.getColumnModel().getColumn(0).setMaxWidth(150);
            tabla_Reporte_Turno.getColumnModel().getColumn(1).setMinWidth(50);
            tabla_Reporte_Turno.getColumnModel().getColumn(1).setPreferredWidth(555);
            tabla_Reporte_Turno.getColumnModel().getColumn(1).setMaxWidth(150);
            tabla_Reporte_Turno.getColumnModel().getColumn(2).setPreferredWidth(555);
            tabla_Reporte_Turno.getColumnModel().getColumn(2).setMaxWidth(150);
            tabla_Reporte_Turno.getColumnModel().getColumn(3).setMinWidth(50);
            tabla_Reporte_Turno.getColumnModel().getColumn(3).setPreferredWidth(555);
            tabla_Reporte_Turno.getColumnModel().getColumn(3).setMaxWidth(150);
        }

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCerrar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (txtDni.getText().length() > 0) {
            DefaultTableModel tabla_temporal;
            UsuarioBD oUsuarioBD = new UsuarioBD();
            tabla_temporal = oUsuarioBD.buscarUsuarioXdni(txtDni.getText());
            int cant = tabla_temporal.getRowCount();
            if (cant > 0) {
                String nombre = tabla_temporal.getValueAt(0, 1).toString();
                String Apellidos = tabla_temporal.getValueAt(0, 2).toString();
                txtUsuario.setText(Apellidos + " " + nombre);
            } else {
                error("No existe este usuario");
            }

        } else {
            advertencia("Tiene que ingresar un dni");
            txtDni.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (txtDni.getText().length() > 0) {
            if (txtHoraInicio.getText().length() > 0) {
                if (txtHoraFinal.getText().length() > 0) {
                    if (!cmbTurno.getSelectedItem().equals("Seleccionar turno")) {
                        Turno oTurno = new Turno();
                        TurnoBD oTurnoBD = new TurnoBD();

                        oTurno.setDescripcion(cmbTurno.getSelectedItem().toString());
                        oTurno.setInicio(txtHoraInicio.getText());
                        oTurno.setFin(txtHoraFinal.getText());
                        oTurno.setuDni(txtDni.getText());
                        boolean rpta = oTurnoBD.RegistrarTurno(oTurno);
                        if (rpta) {
                            exito("Se registro con exito");
                            reporteTurno();
                            limpiar();
                        } else {
                            error("Tienes problemas al registrar");
                        }
                    } else {
                        advertencia("Seleccionar un turno");

                    }
                } else {
                    advertencia("Ingrese la hora final");
                    txtHoraFinal.requestFocus();
                }
            } else {
                advertencia("Ingrese la hora de inicio");
                txtHoraInicio.requestFocus();
            }
        } else {
            advertencia("Ingrese dni");
            txtDni.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (fila_seleccionada > 0) {

            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar" + fila_seleccionada);
            if (aviso == 0) {
                TurnoBD oTurnoBD = new TurnoBD();
                int idturno = Integer.parseInt(tabla_Reporte_Turno.getValueAt(fila_seleccionada, 0).toString());
                boolean rpta = oTurnoBD.eliminarTurno(idturno);
                if (rpta) {
                    exito("Se elimino con exito");
                    reporteTurno();
                    limpiar();
                } else {
                    error("Tienes problemas al eliminar");
                }

            }
        } else {
            advertencia("Tienes que seleccionar una fila");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tabla_Reporte_TurnoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_Reporte_TurnoMousePressed
        // TODO add your handling code here:
        fila_seleccionada = tabla_Reporte_Turno.getSelectedRow();
    }//GEN-LAST:event_tabla_Reporte_TurnoMousePressed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtDni.getText().length() >= 8) {
            evt.consume();
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnBuscar.requestFocus();
            btnBuscar.doClick();
        }
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained
        // TODO add your handling code here:
        txtDni.setBackground(Color.yellow);
    }//GEN-LAST:event_txtDniFocusGained

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
        // TODO add your handling code here:
        txtDni.setBackground(Color.white);
    }//GEN-LAST:event_txtDniFocusLost

    private void txtHoraInicioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraInicioFocusLost
        // TODO add your handling code here:
        txtHoraInicio.setBackground(Color.white);
    }//GEN-LAST:event_txtHoraInicioFocusLost

    private void txtHoraInicioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraInicioFocusGained
        // TODO add your handling code here:
        txtHoraInicio.setBackground(Color.yellow);
    }//GEN-LAST:event_txtHoraInicioFocusGained

    private void txtHoraInicioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraInicioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtHoraFinal.requestFocus();
        }
    }//GEN-LAST:event_txtHoraInicioKeyPressed

    private void txtHoraFinalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraFinalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            cmbTurno.requestFocus();

        }
    }//GEN-LAST:event_txtHoraFinalKeyPressed

    private void txtHoraFinalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFinalFocusGained
        // TODO add your handling code here:
        txtHoraFinal.setBackground(Color.yellow);
    }//GEN-LAST:event_txtHoraFinalFocusGained

    private void txtHoraFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoraFinalFocusLost
        // TODO add your handling code here:
        txtHoraFinal.setBackground(Color.white);
    }//GEN-LAST:event_txtHoraFinalFocusLost

    private void btnRegistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnRegistrarKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnRegistrarKeyPressed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtHoraInicio.requestFocus();
        }
    }//GEN-LAST:event_btnBuscarKeyPressed

    private void cmbTurnoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmbTurnoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
        }

    }//GEN-LAST:event_cmbTurnoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_Reporte_Turno;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtHoraFinal;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void limpiar_tabla_formularios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
