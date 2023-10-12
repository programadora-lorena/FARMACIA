/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.conexion;
import CapaDatos.Compra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class CompraBD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public int registrarCompra(Compra c) {
        int idventa = 0;
        sql = "INSERT INTO compra (idCompra,coFecha,coTipDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,provRuc,uDni,tienda) "
                + "VALUES (0,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, c.getCoFecha());
            pst.setString(2, c.getCoTipDoc());
            pst.setString(3, c.getCoNroDoc());
            pst.setString(4, c.getCoTipoPago());
            pst.setString(5, c.getCoFormaPago());
            pst.setString(6, c.getCoMoneda());
            pst.setDouble(7, c.getCoSubTotal());
            pst.setDouble(8, c.getCoFlete());
            pst.setDouble(9, c.getCoIgv());
            pst.setDouble(10, c.getCoTotal());
            pst.setString(11, c.getProvRuc());
            pst.setString(12, c.getuDni());
            pst.setString(13, c.getTienda());

            pst.executeUpdate();
            ResultSet resultado = pst.getGeneratedKeys();
            if (resultado.next()) {
                idventa = resultado.getInt(1);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar Compras BD", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return idventa;
    }

    public DefaultTableModel reportarCompraFecha(String fechaInicio, String fechafinal) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "FECHA", "PROVEEDOR", "TIPO DOC", "NRO DOC", "TIPO PAGO", "FORMA PAGO", "MONEDA", "SUB TOTAL", "FLETE", "IGV", "RUC", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idCompra,coFecha,provRazonSocial,coTipDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,c.provRuc,uDni,tienda FROM compra AS c "
                + "INNER JOIN proveedor AS p ON c.provRuc=p.provRuc "
                + "WHERE coFecha BETWEEN ? AND ?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechafinal);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idCompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipoPago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("provRuc");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");

                modelo.addRow(registros);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar compra BD..", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;

    }

    public DefaultTableModel reportarCompraDocumento(String fechaInicio, String fechaFinal, String documento) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "FECHA", "PROVEEDOR", "TIPO DOC", "NRO DOC", "TIPO PAGO", "FORMA PAGO", "MONEDA", "SUB TOTAL", "FLETE", "IGV", "RUC", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idCompra,coFecha,provRazonSocial,coTipDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,C.provRuc,uDni,tienda FROM compra AS c "
                + "INNER JOIN proveedor AS p ON c.provRuc=p.provRuc "
                + "WHERE (coFecha BETWEEN ? AND ?) AND coTipDoc=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, documento);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idCompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipoPago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("provRuc");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");
                modelo.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar compra por documento BD..", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public DefaultTableModel reporteCompraProveedor(String fechaInicio, String fechaFinal, String proveedor) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "FECHA", "PROVEEDOR", "TIPO DOC", "NRO DOC", "TIPO PAGO", "FORMA PAGO", "MONEDA", "SUB TOTAL", "FLETE", "IGV", "RUC", "TOTAL", "RUC", "DNI", "TIENDA"};
        String[] registros = new String[15];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idCompra,coFecha,provRazonSocial,coTipDoc,coNroDoc,coTipoPago,coFormaPago,coMoneda,coSubTotal,coFlete,coIgv,coTotal,C.provRuc,uDni,tienda FROM compra AS c "
                + "INNER JOIN proveedor AS p ON c.provRuc=p.provRuc "
                + "WHERE (coFecha BETWEEN ? AND ?) AND provRazonSocial=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            pst.setString(3, proveedor);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idCompra");
                registros[1] = rs.getString("coFecha");
                registros[2] = rs.getString("provRazonSocial");
                registros[3] = rs.getString("coTipDoc");
                registros[4] = rs.getString("coNroDoc");
                registros[5] = rs.getString("coTipoPago");
                registros[6] = rs.getString("coFormaPago");
                registros[7] = rs.getString("coMoneda");
                registros[8] = rs.getString("coSubTotal");
                registros[9] = rs.getString("coFlete");
                registros[10] = rs.getString("coIgv");
                registros[11] = rs.getString("coTotal");
                registros[12] = rs.getString("provRuc");
                registros[13] = rs.getString("uDni");
                registros[14] = rs.getString("tienda");
                modelo.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar compra por proveedor BD..", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean eliminarCompra(int idcompra) {
        boolean rpta = false;
        try {
            sql = "DELETE FROM compra WHERE idCompra=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al eliminar BD..", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;

    }
}
