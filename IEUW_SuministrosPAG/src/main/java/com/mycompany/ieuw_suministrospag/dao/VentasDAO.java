/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.dao;

import com.mycompany.ieuw_suministrospag.models.VentaModel;
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
public class VentasDAO {
    
    public static int InsertVenta(VentaModel venta) throws SQLException{
         Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`venta_procedure`(?, NULL, ?, ?, ?, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setInt(2, venta.getVentaUsuario());
            statement.setFloat(3, venta.getTotalPagar());
            statement.setString(4, venta.getVentaFecha());
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
    
    public static List<VentasMesModel> GetVentasMes() throws SQLException{
        List<VentasMesModel> listaVentasMes = new ArrayList<>(); 
        Connection con = DbConnection.getConnection();
         try {
        String sql = "CALL `suministrosag_db`.`venta_procedure`(?, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "VM");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer mes = result.getInt("Mes");
                Integer cantidad = result.getInt("Total");
                listaVentasMes.add(new VentasMesModel(mes, cantidad));
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
        return listaVentasMes;
    }  
    
     public static float GetVentasTotal() throws SQLException{
        Connection con = DbConnection.getConnection();
        float total = 0;
         try {
        String sql = "CALL `suministrosag_db`.`venta_procedure`(?, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "TM");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                total = result.getFloat("Total");
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
         return total;
    }  
     
     public static float GetVentasTotalAño() throws SQLException{
        Connection con = DbConnection.getConnection();
        float total = 0;
         try {
        String sql = "CALL `suministrosag_db`.`venta_procedure`(?, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "TA");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                total = result.getFloat("TotalAño");
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
         return total;
    }  
     
     public static int GetLastId() throws SQLException{
         Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`venta_procedure`(?, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "UI");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                return id;
            }
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
     
     public static List<VentaModel> GetVentas() throws SQLException{
        List<VentaModel> listaVentas = new ArrayList<>(); 
        Connection con = DbConnection.getConnection();
         try {
        String sql = "CALL `suministrosag_db`.`venta_procedure`(?, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "SA");
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int idventa = result.getInt("idventa");
                int ventaUsuario = result.getInt("ventaUsuario");
                String userName = result.getString("userName");
                Float totalPagar = result.getFloat("totalPagar");
                String ventaFecha = result.getString("ventaFecha");
                int ventaEstado = result.getInt("ventaEstado");
                listaVentas.add(new VentaModel(idventa, ventaUsuario, totalPagar, ventaFecha, ventaEstado, userName));
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
        return listaVentas;
    }  
     
     public static List<VentaModel> GetVentasByUser(int idUser) throws SQLException{
        List<VentaModel> listaVentas = new ArrayList<>(); 
        Connection con = DbConnection.getConnection();
         try {
        String sql = "CALL `suministrosag_db`.`venta_procedure`(?, NULL, ?, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "SU");
            statement.setInt(2, idUser);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int idventa = result.getInt("idventa");
                int ventaUsuario = result.getInt("ventaUsuario");
                Float totalPagar = result.getFloat("totalPagar");
                String ventaFecha = result.getString("ventaFecha");
                int ventaEstado = result.getInt("ventaEstado");
                listaVentas.add(new VentaModel(idventa, ventaUsuario, totalPagar, ventaFecha, ventaEstado));
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
        return listaVentas;
    }  
     
     public static VentaModel GetVenta(int idVenta) throws SQLException{
        Connection con = DbConnection.getConnection();
         try {
        String sql = "CALL `suministrosag_db`.`venta_procedure`(?, ?, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S");
            statement.setInt(2, idVenta);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                int idventa = result.getInt("idventa");
                int ventaUsuario = result.getInt("ventaUsuario");
                Float totalPagar = result.getFloat("totalPagar");
                String ventaFecha = result.getString("ventaFecha");
                int ventaEstado = result.getInt("ventaEstado");
                return new VentaModel(idventa, ventaUsuario, totalPagar, ventaFecha, ventaEstado);
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
