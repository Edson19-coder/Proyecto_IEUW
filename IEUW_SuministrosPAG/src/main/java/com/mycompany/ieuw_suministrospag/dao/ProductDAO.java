/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.dao;

import com.mycompany.ieuw_suministrospag.models.InStockModel;
import com.mycompany.ieuw_suministrospag.models.ProductModel;
import com.mycompany.ieuw_suministrospag.models.VentasMesModel;
import com.mycompany.ieuw_suministrospag.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ProductDAO {
    
    public static List<ProductModel> GetProductos() throws SQLException{
        List<ProductModel> productos = new ArrayList<>();
        Connection con = DbConnection.getConnection();
        try {
        String sql = "CALL `suministrosag_db`.`product_procedure`(?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "AS");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer id = result.getInt("idproduct");
                String name = result.getString("productName");
                Integer productCategory = result.getInt("productCategory");
                Integer productSubCategory = result.getInt("productSubCategory");
                Float productCosto = result.getFloat("productCosto");
                String productDescripcion = result.getString("productDescripcion");
                String productMaterial = result.getString("productMaterial");
                String productMedidas = result.getString("productMedidas");
                String productUnidadEmpaque = result.getString("productUnidadEmpaque");
                String productMedidaCaja = result.getString("productMedidaCaja");
                String productPesoCaja = result.getString("productPesoCaja");
                String productImgPath1 = result.getString("productImgPath1");
                String productImgPath2 = result.getString("productImgPath2");
                productos.add(new ProductModel(id, name, productCategory, productSubCategory, productCosto, productDescripcion, productMaterial, productMedidas, productUnidadEmpaque
                , productMedidaCaja, productPesoCaja, productImgPath1, productImgPath2));
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
        return productos;
    }
    
    public static ProductModel GetProducto(int idProducto) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `suministrosag_db`.`product_procedure`(?, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S");
            statement.setInt(2, idProducto);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer id = result.getInt("idproduct");
                String name = result.getString("productName");
                Integer productCategory = result.getInt("productCategory");
                Integer productSubCategory = result.getInt("productSubCategory");
                Float productCosto = result.getFloat("productCosto");
                String productDescripcion = result.getString("productDescripcion");
                String productMaterial = result.getString("productMaterial");
                String productMedidas = result.getString("productMedidas");
                String productUnidadEmpaque = result.getString("productUnidadEmpaque");
                String productMedidaCaja = result.getString("productMedidaCaja");
                String productPesoCaja = result.getString("productPesoCaja");
                String productImgPath1 = result.getString("productImgPath1");
                String productImgPath2 = result.getString("productImgPath2");
                return new ProductModel(id, name, productCategory, productSubCategory, productCosto, productDescripcion, productMaterial, productMedidas, productUnidadEmpaque
                , productMedidaCaja, productPesoCaja, productImgPath1, productImgPath2);
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
        return null;
    }
    
    public static InStockModel GetInStock() throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
        String sql = "CALL `suministrosag_db`.`product_procedure`(?, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "PA");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer TotalProductos = result.getInt("TotalProductos");
                Integer TotalProductosActivos = result.getInt("TotalProductosActivos");
                float porcentaje = (TotalProductosActivos * 100) /  TotalProductos;
                return new InStockModel(TotalProductos, TotalProductosActivos, porcentaje);
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
        return null;
    }
}
