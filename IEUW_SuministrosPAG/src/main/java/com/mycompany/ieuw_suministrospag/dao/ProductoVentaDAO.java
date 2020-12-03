package com.mycompany.ieuw_suministrospag.dao;


import com.mycompany.ieuw_suministrospag.models.ProductosVentaModel;
import com.mycompany.ieuw_suministrospag.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProductoVentaDAO {
    
    public static int InsertVentaProductos(ProductosVentaModel producto) throws SQLException{
         Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`productosventas_procedure`(?, NULL, ?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setInt(2, producto.getProductosVenta());
            statement.setInt(3, producto.getProductosVentaProducto());
            statement.setInt(4, producto.getProductosVentaCantidad());
            statement.setString(5, producto.getProductosVentaObservacion());
            return statement.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            if(con != null){
                try{
                    con.close();
                } catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        }
        return 0;
    }
    
    public static List<ProductosVentaModel> GetProductosByVenta(int idUser) throws SQLException{
        List<ProductosVentaModel> listaProductosVenta = new ArrayList<>(); 
        Connection con = DbConnection.getConnection();
         try {
        String sql = "CALL `suministrosag_db`.`productosventas_procedure`(?, NULL, ?, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "SP");
            statement.setInt(2, idUser);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int idproductosVenta = result.getInt("idproductosVenta");
                int productosVenta = result.getInt("productosVenta");
                int productosVentaProducto = result.getInt("productosVentaProducto");
                int productosVentaCantidad = result.getInt("productosVentaCantidad");
                String productosVentaObservacion = result.getString("productosVentaObservacion");
                listaProductosVenta.add(new ProductosVentaModel(idproductosVenta, productosVenta, productosVentaProducto, productosVentaCantidad, productosVentaObservacion));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }finally{
            if(con != null){
                try{
                    con.close();
                } catch(SQLException ex){
                    System.out.println(ex);
                }
            }
        }
        return listaProductosVenta;
    }  
}
