/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.utils;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Type {
    public static String EstadoPedido(int estado){
        
        switch(estado){
            case 0:{
                return "Esperando confirmacion";
            }
            case 1:{
                return "En proceso";
            }
            case 2:{
                return "En camino";
            }
            case 3:{
                return "Entregado";
            }
            case 4:{
                return "Cancelado";
            }
        }
        
        return null;
    }
}
