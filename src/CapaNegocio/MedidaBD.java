/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.conexion;
import CapaDatos.Medida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class MedidaBD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarMedida() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "PRESENTACION", "EQUIVALENCIA"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idmedida, mPresentacion, mEquivalencia FROM medida";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idmedida");
                registros[1] = rs.getString("mPresentacion");
                registros[2] = rs.getString("mEquivalencia");
                
                modelo.addRow(registros);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Error al reportar medida BD...",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }
    public boolean registrarMedida (Medida m){
        sql = "INSERT INTO medida (idmedida,mPresentacion,mEquivalencia) VALUES(0,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getmPresentacion());
            pst.setString(2, m.getmEquivalencia());
            
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar medida BD",JOptionPane.ERROR_MESSAGE);
            return false;
            
        }
        return  true;
    }
    public  boolean modificarMedida(Medida m){
        sql = "UPDATE medida SET mPresentacion=?, mEquivalencia=? WHERE idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, m.getmPresentacion());
            pst.setString(2, m.getmEquivalencia());
            pst.setInt(3, m.getIdmedida());
            
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e, "Error al modificar medida BD...",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    public  boolean eliminarMedida(int codigo){
        sql = "DELETE FROM medida WHERE idmedida=?";
        try {
            PreparedStatement pst= cn.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Problemas al eliminar medida BD",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
