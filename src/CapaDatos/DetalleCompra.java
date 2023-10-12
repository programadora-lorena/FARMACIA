/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

/**
 *
 * @author MAYRA PEÑA ROMAN
 */
public class DetalleCompra {

    private int idCompra;
    private String pSerie;
    private double dcCantidad;
    private double dcPrecio;
    private double dcImporte;
    private String dcLote;
    private String dcPresentacion;

    public DetalleCompra() {
    }

    public DetalleCompra(int idCompra, String pSerie, double dcCantidad, double dcPrecio, double dcImporte, String dcLote, String dcPresentacion) {
        this.idCompra = idCompra;
        this.pSerie = pSerie;
        this.dcCantidad = dcCantidad;
        this.dcPrecio = dcPrecio;
        this.dcImporte = dcImporte;
        this.dcLote = dcLote;
        this.dcPresentacion = dcPresentacion;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getpSerie() {
        return pSerie;
    }

    public void setpSerie(String pSerie) {
        this.pSerie = pSerie;
    }

    public double getDcCantidad() {
        return dcCantidad;
    }

    public void setDcCantidad(double dcCantidad) {
        this.dcCantidad = dcCantidad;
    }

    public double getDcPrecio() {
        return dcPrecio;
    }

    public void setDcPrecio(double dcPrecio) {
        this.dcPrecio = dcPrecio;
    }

    public double getDcImporte() {
        return dcImporte;
    }

    public void setDcImporte(double dcImporte) {
        this.dcImporte = dcImporte;
    }

    public String getDcLote() {
        return dcLote;
    }

    public void setDcLote(String dcLote) {
        this.dcLote = dcLote;
    }

    public String getDcPresentacion() {
        return dcPresentacion;
    }

    public void setDcPresentacion(String dcPresentacion) {
        this.dcPresentacion = dcPresentacion;
    }

}
