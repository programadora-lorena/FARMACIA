/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class Compra {

    private int idCompra;
    private String coFecha;
    private String coTipDoc;
    private String coNroDoc;
    private String coTipoPago;
    private String coFormaPago;
    private String coMoneda;
    private double coSubTotal;
    private double coFlete;
    private double coIgv;
    private double coTotal;
    private String provRuc;
    private String uDni;
    private String tienda;

    public Compra() {
    }

    public Compra(int idCompra, String coFecha, String coTipDoc, String coNroDoc, String coTipoPago, String coFormaPago, String coMoneda, double coSubTotal, double coFlete, double coIgv, double coTotal, String provRuc, String uDni, String tienda) {
        this.idCompra = idCompra;
        this.coFecha = coFecha;
        this.coTipDoc = coTipDoc;
        this.coNroDoc = coNroDoc;
        this.coTipoPago = coTipoPago;
        this.coFormaPago = coFormaPago;
        this.coMoneda = coMoneda;
        this.coSubTotal = coSubTotal;
        this.coFlete = coFlete;
        this.coIgv = coIgv;
        this.coTotal = coTotal;
        this.provRuc = provRuc;
        this.uDni = uDni;
        this.tienda = tienda;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getCoFecha() {
        return coFecha;
    }

    public void setCoFecha(String coFecha) {
        this.coFecha = coFecha;
    }

    public String getCoTipDoc() {
        return coTipDoc;
    }

    public void setCoTipDoc(String coTipDoc) {
        this.coTipDoc = coTipDoc;
    }

    public String getCoNroDoc() {
        return coNroDoc;
    }

    public void setCoNroDoc(String coNroDoc) {
        this.coNroDoc = coNroDoc;
    }

    public String getCoTipoPago() {
        return coTipoPago;
    }

    public void setCoTipoPago(String coTipoPago) {
        this.coTipoPago = coTipoPago;
    }

    public String getCoFormaPago() {
        return coFormaPago;
    }

    public void setCoFormaPago(String coFormaPago) {
        this.coFormaPago = coFormaPago;
    }

    public String getCoMoneda() {
        return coMoneda;
    }

    public void setCoMoneda(String coMoneda) {
        this.coMoneda = coMoneda;
    }

    public double getCoSubTotal() {
        return coSubTotal;
    }

    public void setCoSubTotal(double coSubTotal) {
        this.coSubTotal = coSubTotal;
    }

    public double getCoFlete() {
        return coFlete;
    }

    public void setCoFlete(double coFlete) {
        this.coFlete = coFlete;
    }

    public double getCoIgv() {
        return coIgv;
    }

    public void setCoIgv(double coIgv) {
        this.coIgv = coIgv;
    }

    public double getCoTotal() {
        return coTotal;
    }

    public void setCoTotal(double coTotal) {
        this.coTotal = coTotal;
    }

    public String getProvRuc() {
        return provRuc;
    }

    public void setProvRuc(String provRuc) {
        this.provRuc = provRuc;
    }

    public String getuDni() {
        return uDni;
    }

    public void setuDni(String uDni) {
        this.uDni = uDni;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
    
    
}
