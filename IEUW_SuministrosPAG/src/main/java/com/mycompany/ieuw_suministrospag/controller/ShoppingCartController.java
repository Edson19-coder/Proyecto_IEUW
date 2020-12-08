/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ieuw_suministrospag.controller;

import com.mycompany.ieuw_suministrospag.dao.ProductoVentaDAO;
import com.mycompany.ieuw_suministrospag.dao.DireccionDAO;
import com.mycompany.ieuw_suministrospag.dao.ProductDAO;
import com.mycompany.ieuw_suministrospag.dao.VentasDAO;
import com.mycompany.ieuw_suministrospag.models.ArtiuculoModel;
import com.mycompany.ieuw_suministrospag.models.DireccionModel;
import com.mycompany.ieuw_suministrospag.models.ProductModel;
import com.mycompany.ieuw_suministrospag.models.ProductosVentaModel;
import com.mycompany.ieuw_suministrospag.models.VentaModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ShoppingCart", urlPatterns = {"/ShoppingCart"})
public class ShoppingCartController extends HttpServlet {

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
            HttpSession session = request.getSession();
            Integer idUsuario = (Integer) session.getAttribute("id_user_session");
            DireccionModel direccion = DireccionDAO.GetDireccionByUser(idUsuario);
            request.setAttribute("direccion", direccion);
            request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
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
            HttpSession session = request.getSession();
            ArrayList<ArtiuculoModel> articulos = (ArrayList<ArtiuculoModel>) (session.getAttribute("carrito") == null ? new ArrayList<>() : (ArrayList<ArtiuculoModel>) session.getAttribute("carrito"));
            Integer idUsuario = (Integer) session.getAttribute("id_user_session");
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentTime = sdf.format(dt);
            DireccionModel direccion = DireccionDAO.GetDireccionByUser(idUsuario);
            Float total = Float.parseFloat(request.getParameter("total"));
            String numero_tarjeta = request.getParameter("numero_tarjeta");
            String mes_expString = request.getParameter("mes_exp");
            Integer mes_exp = Integer.parseInt(mes_expString);
            String año_expString = request.getParameter("año_exp");
            Integer año_exp = Integer.parseInt(año_expString);
            String ccvString = request.getParameter("ccv");
            Integer ccv = Integer.parseInt(ccvString);
            String titular = request.getParameter("titular");
            VentaModel venta = new VentaModel(idUsuario, total, currentTime, 0, direccion.getDireccionPais(), direccion.getDireccionCalle(), direccion.getDireccionCp(), direccion.getDireccionEstado(), direccion.getDireccionCiudad(), direccion.getDireccionColonia(), direccion.getDireccionTelefono(), numero_tarjeta, mes_exp, año_exp, ccv, titular);
            if (venta != null) {
                try {
                    if ((!numero_tarjeta.equals("") && numero_tarjeta != null) && (mes_exp != 0 && mes_exp != null) && (año_exp != 0 && año_exp != null) && (ccv != 0 && ccv != null) && (!titular.equals("") && titular != null)) {
                        if (articulos.size() > 0) {
                            VentasDAO.InsertVenta(venta);
                            int lastid = VentasDAO.GetLastId();
                            for (ArtiuculoModel a : articulos) {
                                System.out.println(a.getIdProducto());
                                ProductosVentaModel pv = new ProductosVentaModel(lastid, a.getIdProducto(), a.getCantidad(), a.getComentario());
                                ProductoVentaDAO.InsertVentaProductos(pv);
                            }
                            articulos.clear();
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ShoppingCartController.class.getName()).log(Level.SEVERE, null, ex);
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
