/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.conexion;
import CapaDatos.Composicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class ComposicionBD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public List<Composicion> reportarComposicion() {
        List<Composicion> lista = new ArrayList<>();
        sql = "SELECT idcomposicion,coNombre,pSerie FROM composicion ORDER BY idcomposicion ASC";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Composicion oCorrelativo = new Composicion();

                oCorrelativo.setIdcomposicion(rs.getInt(1));
                oCorrelativo.setCoNombre(rs.getString(2));
                oCorrelativo.setpSerie(rs.getString(3));
             
               lista.add(oCorrelativo);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Correlativo...",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
        return lista;
    }
    public boolean registrarComposicion(Composicion cp) {
        boolean rpta = false;
        sql = "INSERT INTO composicion(idComposicion,coNombre,pSerie) VALUES (0,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, cp.getCoNombre());
            pst.setString(2, cp.getpSerie());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e, "Problemas al registrar composicion", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
    public boolean eliminarComposicion(int idcomposicion) {
        boolean rpta = false;
        sql = "DELETE FROM composicion WHERE idComposicion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcomposicion);

            rpta = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar ", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }
}
