/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.conexion;
import CapaDatos.DetalleCuentasBancarias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class DetalleCuentasBancariasBD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel buscarDetalleCuentasBancarias(String ruc) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "BANCO", "CUENTA", "NRO_CUENTA", "RUC"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idcuentas,banco,cuenta,nroCuenta,provRuc FROM detallecuentasbancarias "
                + "WHERE provRuc=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, ruc);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("idcuentas");
                registros[1] = rs.getString("banco");
                registros[2] = rs.getString("cuenta");
                registros[3] = rs.getString("nroCuenta");
                registros[4] = rs.getString("provRuc");

                modelo.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar detallecuentasbancarias BD...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean resgistrarDetalleCuentasBancarias(DetalleCuentasBancarias d) {
        boolean rpta = false;
        sql = " INSERT INTO detallecuentasbancarias(idcuentas,banco,cuenta,nroCuenta,provRuc) VALUES (NULL,?,?,?,? )";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, d.getBanco());
            pst.setString(2, d.getCuenta());
            pst.setString(3, d.getNroCuenta());
            pst.setString(4, d.getProvRuc());

            rpta = pst.executeUpdate() == 1 ? true : false;

            pst.close();
            cn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar detalleCuentasBancarias BD", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
public boolean eliminarDetalleCuentasBancarias(int idcuentas){
    boolean rpta = false;
    try {
        sql = "DELETE FROM detallecuentasbancarias WHERE idcuentas=?";
        PreparedStatement pst = cn.prepareStatement(sql);
        pst.setInt(1, idcuentas);
        
        rpta = pst.executeUpdate() == 1 ? true : false;
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e,"Problemas al eliminar cuentas bancarias BD",JOptionPane.ERROR_MESSAGE);
        return rpta;
    }
    return rpta;
}
}
