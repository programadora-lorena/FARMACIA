/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class conexion {
    private static  String clase ="com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/FARMACIA?serverTimezone=UTC";
    private static String usuario = "root";
    private static String clave = "123456";
    
    public conexion(){
  
}
    public Connection conectar(){
        Connection link = null;
        try {
            Class.forName(clase);
            link =DriverManager.getConnection(url,usuario,clave);
            
        } catch (Exception e) {
            
            JOptionPane.showConfirmDialog(null,e );
        }
       return link;
        }
}

