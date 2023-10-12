/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.conexion;
import CapaDatos.DetalleCompra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class DetalleCompraBD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public boolean registrarDetalleCompra(DetalleCompra d) {
        sql = "INSERT INTO detallecompra(idCompra,pSerie,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, d.getIdCompra());
            pst.setString(2, d.getpSerie());
            pst.setDouble(3, d.getDcCantidad());
            pst.setDouble(4, d.getDcPrecio());
            pst.setDouble(5, d.getDcImporte());
            pst.setString(6, d.getDcLote());
            pst.setString(7, d.getDcPresentacion());

            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Problemas al registrar detalle de compra BD",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
        public DefaultTableModel buscarDetalleCompra(int idcompra) {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "PRODUCTO", "CANTIDAD", "PRECIO", "IMPORTE", "LOTE", "PRESENTACION"};
        String[] regsitros = new String[8];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idCompra,dc.pSerie,pDescripcion,dcCantidad,dcPrecio,dcImporte,dcLote,dcPresentacion FROM detallecompra AS dc "
                + "INNER JOIN producto AS p ON dc.pSerie=p.pSerie "
                + "WHERE idCompra=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcompra);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                regsitros[0] = rs.getString("idCompra");
                regsitros[1] = rs.getString("pSerie");
                regsitros[2] = rs.getString("pDescripcion");
                regsitros[3] = rs.getString("dcCantidad");
                regsitros[4] = rs.getString("dcPrecio");
                regsitros[5] = rs.getString("dcImporte");
                regsitros[6] = rs.getString("dcLote");
                regsitros[7] = rs.getString("dcPresentacion");

                modelo.addRow(regsitros);
            }
            pst.close();
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar detalle compra BD", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;

    }
    
}
