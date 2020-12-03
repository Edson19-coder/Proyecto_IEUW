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
public class ProductosVentaModel {
    private int idproductosVenta;
    private int productosVenta;
    private int productosVentaProducto;
    private int productosVentaCantidad;
    private String productosVentaObservacion;

    public ProductosVentaModel() {
    }

    public ProductosVentaModel(int idproductosVenta, int productosVenta, int productosVentaProducto, int productosVentaCantidad, String productosVentaObservacion) {
        this.idproductosVenta = idproductosVenta;
        this.productosVenta = productosVenta;
        this.productosVentaProducto = productosVentaProducto;
        this.productosVentaCantidad = productosVentaCantidad;
        this.productosVentaObservacion = productosVentaObservacion;
    }

    public ProductosVentaModel(int productosVenta, int productosVentaProducto, int productosVentaCantidad, String productosVentaObservacion) {
        this.productosVenta = productosVenta;
        this.productosVentaProducto = productosVentaProducto;
        this.productosVentaCantidad = productosVentaCantidad;
        this.productosVentaObservacion = productosVentaObservacion;
    }

    public int getIdproductosVenta() {
        return idproductosVenta;
    }

    public void setIdproductosVenta(int idproductosVenta) {
        this.idproductosVenta = idproductosVenta;
    }

    public int getProductosVenta() {
        return productosVenta;
    }

    public void setProductosVenta(int productosVenta) {
        this.productosVenta = productosVenta;
    }

    public int getProductosVentaProducto() {
        return productosVentaProducto;
    }

    public void setProductosVentaProducto(int productosVentaProducto) {
        this.productosVentaProducto = productosVentaProducto;
    }

    public int getProductosVentaCantidad() {
        return productosVentaCantidad;
    }

    public void setProductosVentaCantidad(int productosVentaCantidad) {
        this.productosVentaCantidad = productosVentaCantidad;
    }

    public String getProductosVentaObservacion() {
        return productosVentaObservacion;
    }

    public void setProductosVentaObservacion(String productosVentaObservacion) {
        this.productosVentaObservacion = productosVentaObservacion;
    }
    
    
}
