/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ieuw_suministrospag.controller;

import com.mycompany.ieuw_suministrospag.dao.DireccionDAO;
import com.mycompany.ieuw_suministrospag.models.DireccionModel;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "Configuracion", urlPatterns = {"/Configuracion"})
public class ConfiguracionController extends HttpServlet {

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
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            Integer idUsuario = (Integer) session.getAttribute("id_user_session");
            DireccionModel direccion = DireccionDAO.GetDireccionByUser(idUsuario);
            request.setAttribute("direccion", direccion);
            request.getRequestDispatcher("configuracion.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ConfiguracionController.class.getName()).log(Level.SEVERE, null, ex);
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
         processRequest(request, response);
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
        HttpSession session = request.getSession();
        Integer idUsuario = (Integer) session.getAttribute("id_user_session");
        String acc = request.getParameter("accion");
        String pais = request.getParameter("Pais");
        String calle = request.getParameter("Calle");
        Integer cp = Integer.parseInt(request.getParameter("cp"));
        String estado = request.getParameter("Estado");
        String ciudad = request.getParameter("Ciudad");
        String colonia = request.getParameter("Colonia");
        String telefono = request.getParameter("Telefono");
        switch(acc){
            case "Insertar":{
                if((!pais.equals("") && pais != null) && (!calle.equals("") && calle != null) && (cp != null) && (!estado.equals("") && 
                        estado != null) && (!ciudad.equals("") && ciudad != null) && (!pais.equals("") && pais != null) && (!colonia.equals("") && 
                        colonia != null) && (!telefono.equals("") && telefono != null)){
                    try {
                        DireccionModel direccion = new DireccionModel(idUsuario, pais, calle, cp, estado, ciudad, colonia, telefono);
                        DireccionDAO.InsertDireccion(direccion);
                    } catch (SQLException ex) {
                        Logger.getLogger(ConfiguracionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
            
            case "Actualizar":{
                 if((!pais.equals("") && pais != null) && (!calle.equals("") && calle != null) && (cp != null) && (!estado.equals("") && 
                        estado != null) && (!ciudad.equals("") && ciudad != null) && (!pais.equals("") && pais != null) && (!colonia.equals("") && 
                        colonia != null) && (!telefono.equals("") && telefono != null)){
                    try {
                        DireccionModel direccion = new DireccionModel(idUsuario, pais, calle, cp, estado, ciudad, colonia, telefono);
                        DireccionDAO.UpdateDireccion(direccion);
                    } catch (SQLException ex) {
                        Logger.getLogger(ConfiguracionController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            }
        }
        response.sendRedirect(request.getContextPath() + "/Configuracion");
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
