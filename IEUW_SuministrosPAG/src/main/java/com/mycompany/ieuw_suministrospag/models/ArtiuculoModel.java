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
public class ArtiuculoModel {
    private int idProducto;
    private int cantidad;
    private String comentario;

    public ArtiuculoModel(int idProducto, int cantidad, String comentario) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.comentario = comentario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
}
