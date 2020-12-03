/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VentaModel {
    private int idventa;
    private int ventaUsuario;
    private float totalPagar;
    private String ventaFecha;
    private int ventaEstado;
    private String nombreUsuario;

    public VentaModel() {
    }

    public VentaModel(int idventa, int ventaUsuario, float totalPagar, String ventaFecha, int ventaEstado) {
        this.idventa = idventa;
        this.ventaUsuario = ventaUsuario;
        this.totalPagar = totalPagar;
        this.ventaFecha = ventaFecha;
        this.ventaEstado = ventaEstado;
    }

    public VentaModel(int ventaUsuario, float totalPagar, String ventaFecha, int ventaEstado) {
        this.ventaUsuario = ventaUsuario;
        this.totalPagar = totalPagar;
        this.ventaFecha = ventaFecha;
        this.ventaEstado = ventaEstado;
    }

    public VentaModel(int idventa, int ventaUsuario, float totalPagar, String ventaFecha, int ventaEstado, String nombreUsuario) {
        this.idventa = idventa;
        this.ventaUsuario = ventaUsuario;
        this.totalPagar = totalPagar;
        this.ventaFecha = ventaFecha;
        this.ventaEstado = ventaEstado;
        this.nombreUsuario = nombreUsuario;
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public int getVentaUsuario() {
        return ventaUsuario;
    }

    public void setVentaUsuario(int ventaUsuario) {
        this.ventaUsuario = ventaUsuario;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getVentaFecha() {
        return ventaFecha;
    }

    public void setVentaFecha(String ventaFecha) {
        this.ventaFecha = ventaFecha;
    }

    public int getVentaEstado() {
        return ventaEstado;
    }

    public void setVentaEstado(int ventaEstado) {
        this.ventaEstado = ventaEstado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
}
