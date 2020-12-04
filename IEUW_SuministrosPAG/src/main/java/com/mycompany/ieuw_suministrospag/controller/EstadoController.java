/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ieuw_suministrospag.controller;

import com.mycompany.ieuw_suministrospag.dao.VentasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "Estado", urlPatterns = {"/Estado"})
public class EstadoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Integer idpedido = Integer.parseInt(request.getParameter("pedido"));
        Integer estado = Integer.parseInt(request.getParameter("estado"));
        String volver = request.getParameter("ref");
        switch(estado){
            case 1:{
                int exito = VentasDAO.UpdateEstado(estado, idpedido);
                if(exito == 1){
                    System.out.println("Fue actualizado");
                }else{
                    System.out.println("No fue actualizado");
                }
                break;
            }
            case 2:{
                int exito = VentasDAO.UpdateEstado(estado, idpedido);
                if(exito == 1){
                    System.out.println("Fue actualizado");
                }else{
                    System.out.println("No fue actualizado");
                }
                break;
            }
            case 3:{
                int exito = VentasDAO.UpdateEstado(estado, idpedido);
                if(exito == 1){
                    System.out.println("Fue actualizado");
                }else{
                    System.out.println("No fue actualizado");
                }
                break;
            }
            case 4:{
                int exito = VentasDAO.UpdateEstado(estado, idpedido);
                if(exito == 1){
                    System.out.println("Fue actualizado");
                }else{
                    System.out.println("No fue actualizado");
                }
                break;
            }
        }
        if(volver.equals("pedidos")){
            response.sendRedirect(request.getContextPath() + "/Pedidos");
        }else{
            response.sendRedirect(request.getContextPath() + "/MisPedidos");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(EstadoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
