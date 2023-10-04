/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class Asistencia {
    private int idasistencia;
    private String aFechaE;
    private String aHoraE;
    private String aHoraS;
    private String uDni;
    private String uTurno;
    private String aEstado;
    private String aTienda;

    public Asistencia() {
    }

    public Asistencia(int idasistencia, String aFechaE, String aHoraE, String aHoraS, String uDni, String uTurno, String aEstado, String aTienda) {
        this.idasistencia = idasistencia;
        this.aFechaE = aFechaE;
        this.aHoraE = aHoraE;
        this.aHoraS = aHoraS;
        this.uDni = uDni;
        this.uTurno = uTurno;
        this.aEstado = aEstado;
        this.aTienda = aTienda;
    }

    public int getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(int idasistencia) {
        this.idasistencia = idasistencia;
    }

    public String getaFechaE() {
        return aFechaE;
    }

    public void setaFechaE(String aFechaE) {
        this.aFechaE = aFechaE;
    }

    public String getaHoraE() {
        return aHoraE;
    }

    public void setaHoraE(String aHoraE) {
        this.aHoraE = aHoraE;
    }

    public String getaHoraS() {
        return aHoraS;
    }

    public void setaHoraS(String aHoraS) {
        this.aHoraS = aHoraS;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getuTurno() {
        return uTurno;
    }

    public void setuTurno(String uTurno) {
        this.uTurno = uTurno;
    }

    public String getaEstado() {
        return aEstado;
    }

    public void setaEstado(String aEstado) {
        this.aEstado = aEstado;
    }

    public String getaTienda() {
        return aTienda;
    }

    public void setaTienda(String aTienda) {
        this.aTienda = aTienda;
    }
    
    
    
}
