/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ieuw_suministrospag.controller;

import com.google.gson.Gson;
import com.mycompany.ieuw_suministrospag.dao.VentasDAO;
import com.mycompany.ieuw_suministrospag.models.VentaModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "BuscarVenta", urlPatterns = {"/BuscarVenta"})
public class BuscarVentaController extends HttpServlet {

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
        System.out.println("lol");
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
            String consulta = request.getParameter("consulta");
            String accion = request.getParameter("acc");
            Integer idUsuario = null;
            List<VentaModel> search_ventas = null;
            if (accion.equals("SU")) {
                String idUsuarioString = request.getParameter("id");
                idUsuario = Integer.parseInt(idUsuarioString);
                search_ventas = VentasDAO.GetVentasSearch(consulta, idUsuario);
            } else if (accion.equals("SA")) {
                search_ventas = VentasDAO.GetVentasSearchAll(consulta);
            }
            if (search_ventas.size() != 0 && !consulta.equals("")) {
                String json = new Gson().toJson(search_ventas);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            } else if (accion.equals("SU")) {
                search_ventas = VentasDAO.GetVentasByUser(idUsuario);
                String json = new Gson().toJson(search_ventas);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            } else if (accion.equals("SA")) {
                search_ventas = VentasDAO.GetVentas();
                String json = new Gson().toJson(search_ventas);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscarVentaController.class.getName()).log(Level.SEVERE, null, ex);
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
