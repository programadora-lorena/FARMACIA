/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.conexion;
import CapaDatos.Usuario;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class UsuarioBD {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarUsuarios() {

        DefaultTableModel tabla_Temporal;
        String[] titulos = {"DNI", "NOMBRES", "APELLIDOS", "DIRECCION", "CLAVE", "CELULAR", "TIPO_USUARIO", "TIENDA"};
        String[] registros = new String[8];
        tabla_Temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda FROM usuario AS u "
                + "INNER JOIN tipousuario AS tp ON u.idtipousuario=tp.idtipousuario";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");

                tabla_Temporal.addRow(registros);

            }
            return tabla_Temporal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar usuario BD...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    public boolean registrarUsuario(Usuario u){
        boolean rpta = false;
        sql = "INSERT INTO usuario(uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,idtipousuario,tienda) VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u.getuDni());
            pst.setString(2, u.getuNombre());
            pst.setString(3, u.getuApellidos());
            pst.setString(4, u.getuDireccion());
            pst.setString(5, u.getuClave());
            pst.setString(6, u.getuCelular());
            pst.setInt(7, u.getuTipo());
            pst.setString(8, u.getTienda());
            
            rpta = pst.executeUpdate() ==1? true : false;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Problemas al registrar usuario BD",JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
       return rpta;
    }
    public  boolean modificarUsuario(Usuario u){
         boolean rpta = false;
         sql = "UPDATE usuario SET uNombre=?,uApellidos=?,uDireccion=?,uClave=?,uCelular=?,idtipousuario=?,tienda=? WHERE uDni=?";
         try {
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, u.getuNombre());
            pst.setString(2, u.getuApellidos());
            pst.setString(3, u.getuDireccion());
            pst.setString(4, u.getuClave());
            pst.setString(5, u.getuCelular());
            pst.setInt(6, u.getuTipo());
            pst.setString(7, u.getTienda());
            pst.setString(8, u.getuDni());
            
            rpta = pst.executeUpdate()== 1 ? true : false;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return rpta;
        }
         return rpta;
    }
    public  boolean eliminarUsuario(String dni){
        boolean rpta = false;
        try {
            sql = "DELETE FROM usuario WHERE uDni=?";
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, dni);
            
            rpta = pst.executeUpdate() ==1 ? true : false;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e,"Problemas al eliminar usuario BD",JOptionPane.ERROR_MESSAGE );
            return rpta;
        }
        return rpta;
    }
    public DefaultTableModel buscarUsuarioXdni(String dni){
        
        DefaultTableModel tabla_temporal;
        String[] titulos = { "DNI", "NOMBRES","APELLIDOS","DIRECCION","CLAVE","CELULAR","TIPO_USUARIO","TIENDA"};
        String[] registros = new String[8];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "SELECT uDni,uNombre,uApellidos,uDireccion,uClave,uCelular,tuNombre,tienda FROM usuario AS u "
                + "INNER JOIN tipousuario AS tp ON u.idtipousuario=tp.idtipousuario "
                + "WHERE uDni=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst .setString(1, dni);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("uDni");
                registros[1] = rs.getString("uNombre");
                registros[2] = rs.getString("uApellidos");
                registros[3] = rs.getString("uDireccion");
                registros[4] = rs.getString("uClave");
                registros[5] = rs.getString("uCelular");
                registros[6] = rs.getString("tuNombre");
                registros[7] = rs.getString("tienda");
                
            tabla_temporal.addRow(registros);
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Error al buscar usuario BD...",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }
}