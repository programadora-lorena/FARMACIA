/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class DetalleCuentasBancarias {

    private int idcuentas;
    private String banco;
    private String cuenta;
    private String nroCuenta;
    private String provRuc;

    public DetalleCuentasBancarias() {
    }

    public DetalleCuentasBancarias(int idcuentas, String banco, String cuenta, String nroCuenta, String provRuc) {
        this.idcuentas = idcuentas;
        this.banco = banco;
        this.cuenta = cuenta;
        this.nroCuenta = nroCuenta;
        this.provRuc = provRuc;
    }

    public int getIdcuentas() {
        return idcuentas;
    }

    public void setIdcuentas(int idcuentas) {
        this.idcuentas = idcuentas;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(String nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getProvRuc() {
        return provRuc;
    }

    public void setProvRuc(String provRuc) {
        this.provRuc = provRuc;
    }
    
    
}
