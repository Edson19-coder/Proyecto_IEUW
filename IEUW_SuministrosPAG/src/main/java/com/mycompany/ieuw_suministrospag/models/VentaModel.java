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
    private String ventaPais;
    private String ventaCalle;
    private int ventaCp;
    private String ventaEstadoD;
    private String ventaCiudad;
    private String ventaColonia;
    private String ventaTelefono;
    private String ventaNumeroTarjeta;
    private int ventaMes;
    private int ventaAño;
    private int ventaCcv;
    private String ventaTitular;
    
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

    public VentaModel(int ventaUsuario, float totalPagar, String ventaFecha, int ventaEstado, String ventaPais, String ventaCalle, int ventaCp, String ventaEstadoD, String ventaCiudad, String ventaColonia, String ventaTelefono, String ventaNumeroTarjeta, int ventaMes, int ventaAño, int ventaCcv, String ventaTitular) {
        this.ventaUsuario = ventaUsuario;
        this.totalPagar = totalPagar;
        this.ventaFecha = ventaFecha;
        this.ventaEstado = ventaEstado;
        this.ventaPais = ventaPais;
        this.ventaCalle = ventaCalle;
        this.ventaCp = ventaCp;
        this.ventaEstadoD = ventaEstadoD;
        this.ventaCiudad = ventaCiudad;
        this.ventaColonia = ventaColonia;
        this.ventaTelefono = ventaTelefono;
        this.ventaNumeroTarjeta = ventaNumeroTarjeta;
        this.ventaMes = ventaMes;
        this.ventaAño = ventaAño;
        this.ventaCcv = ventaCcv;
        this.ventaTitular = ventaTitular;
    }

    public VentaModel(int idventa, int ventaUsuario, float totalPagar, String ventaFecha, int ventaEstado, String ventaPais, String ventaCalle, int ventaCp, String ventaEstadoD, String ventaCiudad, String ventaColonia, String ventaTelefono, String ventaNumeroTarjeta, int ventaMes, int ventaAño, int ventaCcv, String ventaTitular) {
        this.idventa = idventa;
        this.ventaUsuario = ventaUsuario;
        this.totalPagar = totalPagar;
        this.ventaFecha = ventaFecha;
        this.ventaEstado = ventaEstado;
        this.ventaPais = ventaPais;
        this.ventaCalle = ventaCalle;
        this.ventaCp = ventaCp;
        this.ventaEstadoD = ventaEstadoD;
        this.ventaCiudad = ventaCiudad;
        this.ventaColonia = ventaColonia;
        this.ventaTelefono = ventaTelefono;
        this.ventaNumeroTarjeta = ventaNumeroTarjeta;
        this.ventaMes = ventaMes;
        this.ventaAño = ventaAño;
        this.ventaCcv = ventaCcv;
        this.ventaTitular = ventaTitular;
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

    public String getVentaPais() {
        return ventaPais;
    }

    public void setVentaPais(String ventaPais) {
        this.ventaPais = ventaPais;
    }

    public String getVentaCalle() {
        return ventaCalle;
    }

    public void setVentaCalle(String ventaCalle) {
        this.ventaCalle = ventaCalle;
    }

    public int getVentaCp() {
        return ventaCp;
    }

    public void setVentaCp(int ventaCp) {
        this.ventaCp = ventaCp;
    }

    public String getVentaCiudad() {
        return ventaCiudad;
    }

    public void setVentaCiudad(String ventaCiudad) {
        this.ventaCiudad = ventaCiudad;
    }

    public String getVentaColonia() {
        return ventaColonia;
    }

    public void setVentaColonia(String ventaColonia) {
        this.ventaColonia = ventaColonia;
    }

    public String getVentaTelefono() {
        return ventaTelefono;
    }

    public void setVentaTelefono(String ventaTelefono) {
        this.ventaTelefono = ventaTelefono;
    }

    public String getVentaNumeroTarjeta() {
        return ventaNumeroTarjeta;
    }

    public void setVentaNumeroTarjeta(String ventaNumeroTarjeta) {
        this.ventaNumeroTarjeta = ventaNumeroTarjeta;
    }

    public int getVentaMes() {
        return ventaMes;
    }

    public void setVentaMes(int ventaMes) {
        this.ventaMes = ventaMes;
    }

    public int getVentaAño() {
        return ventaAño;
    }

    public void setVentaAño(int ventaAño) {
        this.ventaAño = ventaAño;
    }

    public int getVentaCcv() {
        return ventaCcv;
    }

    public void setVentaCcv(int ventaCcv) {
        this.ventaCcv = ventaCcv;
    }

    public String getVentaTitular() {
        return ventaTitular;
    }

    public void setVentaTitular(String ventaTitular) {
        this.ventaTitular = ventaTitular;
    }

    public String getVentaEstadoD() {
        return ventaEstadoD;
    }

    public void setVentaEstadoD(String ventaEstadoD) {
        this.ventaEstadoD = ventaEstadoD;
    }
}
