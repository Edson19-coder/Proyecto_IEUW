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
public class DireccionModel {
    private int iddireccion;
    private int direccionUsuario;
    private String direccionPais;
    private String direccionCalle;
    private int direccionCp;
    private String direccionEstado;
    private String direccionCiudad;
    private String direccionColonia;
    private String direccionTelefono;

    public DireccionModel() {
    }

    public DireccionModel(int iddireccion, int direccionUsuario, String direccionPais, String direccionCalle, int direccionCp, String direccionEstado, String direccionCiudad, String direccionColonia, String direccionTelefono) {
        this.iddireccion = iddireccion;
        this.direccionUsuario = direccionUsuario;
        this.direccionPais = direccionPais;
        this.direccionCalle = direccionCalle;
        this.direccionCp = direccionCp;
        this.direccionEstado = direccionEstado;
        this.direccionCiudad = direccionCiudad;
        this.direccionColonia = direccionColonia;
        this.direccionTelefono = direccionTelefono;
    }

    public DireccionModel(int direccionUsuario, String direccionPais, String direccionCalle, int direccionCp, String direccionEstado, String direccionCiudad, String direccionColonia, String direccionTelefono) {
        this.direccionUsuario = direccionUsuario;
        this.direccionPais = direccionPais;
        this.direccionCalle = direccionCalle;
        this.direccionCp = direccionCp;
        this.direccionEstado = direccionEstado;
        this.direccionCiudad = direccionCiudad;
        this.direccionColonia = direccionColonia;
        this.direccionTelefono = direccionTelefono;
    }

    public int getIddireccion() {
        return iddireccion;
    }

    public void setIddireccion(int iddireccion) {
        this.iddireccion = iddireccion;
    }

    public int getDireccionUsuario() {
        return direccionUsuario;
    }

    public void setDireccionUsuario(int direccionUsuario) {
        this.direccionUsuario = direccionUsuario;
    }

    public String getDireccionPais() {
        return direccionPais;
    }

    public void setDireccionPais(String direccionPais) {
        this.direccionPais = direccionPais;
    }

    public String getDireccionCalle() {
        return direccionCalle;
    }

    public void setDireccionCalle(String direccionCalle) {
        this.direccionCalle = direccionCalle;
    }

    public int getDireccionCp() {
        return direccionCp;
    }

    public void setDireccionCp(int direccionCp) {
        this.direccionCp = direccionCp;
    }

    public String getDireccionEstado() {
        return direccionEstado;
    }

    public void setDireccionEstado(String direccionEstado) {
        this.direccionEstado = direccionEstado;
    }

    public String getDireccionCiudad() {
        return direccionCiudad;
    }

    public void setDireccionCiudad(String direccionCiudad) {
        this.direccionCiudad = direccionCiudad;
    }

    public String getDireccionColonia() {
        return direccionColonia;
    }

    public void setDireccionColonia(String direccionColonia) {
        this.direccionColonia = direccionColonia;
    }

    public String getDireccionTelefono() {
        return direccionTelefono;
    }

    public void setDireccionTelefono(String direccionTelefono) {
        this.direccionTelefono = direccionTelefono;
    }
    
    
}
