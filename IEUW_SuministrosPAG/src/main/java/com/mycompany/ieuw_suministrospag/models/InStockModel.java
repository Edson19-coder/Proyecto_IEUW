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
public class InStockModel {
    private int productosTotales;
    private int productoActivos;
    private float porcentaje;

    public InStockModel(int productosTotales, int productoActivos, float porcentaje) {
        this.productosTotales = productosTotales;
        this.productoActivos = productoActivos;
        this.porcentaje = porcentaje;
    }

    public int getProductosTotales() {
        return productosTotales;
    }

    public void setProductosTotales(int productosTotales) {
        this.productosTotales = productosTotales;
    }

    public int getProductoActivos() {
        return productoActivos;
    }

    public void setProductoActivos(int productoActivos) {
        this.productoActivos = productoActivos;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
