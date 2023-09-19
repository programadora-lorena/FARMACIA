/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.conexion;
import CapaDatos.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class TurnoBD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTurno() {
        DefaultTableModel modelo;
        String[] titulos = {"ID", "DESCRIPCION", "INICIO", "FIN", "USUARIO"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idturno,descripcion,inicio,fin,CONCAT(uApellidos,'',uNombre) AS usuario FROM turno AS t "
                + "INNER JOIN usuario AS u ON t.uDni=u.uDni ";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idturno");
                registros[1] = rs.getString("descripcion");
                registros[2] = rs.getString("inicio");
                registros[3] = rs.getString("fin");
                registros[4] = rs.getString("usuario");

                modelo.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar turno... ,", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean RegistrarTurno(Turno t) {
        boolean rpta = false;
        sql = "INSERT INTO turno (idturno,descripcion,inicio,fin,uDni) VALUES (0,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, t.getDescripcion());
            pst.setString(2, t.getInicio());
            pst.setString(3, t.getFin());
            pst.setString(4, t.getuDni());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al registrar turno BD...", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public Boolean eliminarTurno(int idturno) {
        boolean rpta = false;
        sql = "DELETE FROM turno WHERE idturno=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idturno);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar turno BD...", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}
