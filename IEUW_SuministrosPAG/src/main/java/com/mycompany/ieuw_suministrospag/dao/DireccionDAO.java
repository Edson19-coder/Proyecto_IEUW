/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.dao;

import com.mycompany.ieuw_suministrospag.models.DireccionModel;
import com.mycompany.ieuw_suministrospag.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DireccionDAO {
    
    public static int InsertDireccion(DireccionModel direccion) throws SQLException{
         Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`direccion_procedure`(?, NULL, ?, ?, ?, ?, ?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setInt(2, direccion.getDireccionUsuario());
            statement.setString(3, direccion.getDireccionPais());
            statement.setString(4, direccion.getDireccionCalle());
            statement.setInt(5, direccion.getDireccionCp());
            statement.setString(6, direccion.getDireccionEstado());
            statement.setString(7, direccion.getDireccionCiudad());
            statement.setString(8, direccion.getDireccionColonia());
            statement.setString(9, direccion.getDireccionTelefono());
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
    
    public static int UpdateDireccion(DireccionModel direccion) throws SQLException{
         Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`direccion_procedure`(?, NULL, ?, ?, ?, ?, ?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "U");
            statement.setInt(2, direccion.getDireccionUsuario());
            statement.setString(3, direccion.getDireccionPais());
            statement.setString(4, direccion.getDireccionCalle());
            statement.setInt(5, direccion.getDireccionCp());
            statement.setString(6, direccion.getDireccionEstado());
            statement.setString(7, direccion.getDireccionCiudad());
            statement.setString(8, direccion.getDireccionColonia());
            statement.setString(9, direccion.getDireccionTelefono());
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
    
    public static DireccionModel GetDireccionByUser(int idUsuario) throws SQLException{
        Connection con = DbConnection.getConnection();
        try {
            String sql = "CALL `suministrosag_db`.`direccion_procedure`(?, NULL, ?, NULL, NULL, NULL, NULL, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "S");
            statement.setInt(2, idUsuario);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                Integer iddireccion = result.getInt("iddireccion");
                Integer direccionUsuario = result.getInt("direccionUsuario");
                String direccionPais = result.getString("direccionPais");
                String direccionCalle = result.getString("direccionCalle");
                Integer direccionCp = result.getInt("direccionCp");
                String direccionEstado = result.getString("direccionEstado");
                String direccionCiudad = result.getString("direccionCiudad");
                String direccionColonia = result.getString("direccionColonia");
                String direccionTelefono = result.getString("direccionTelefono");
                return new DireccionModel(iddireccion, direccionUsuario, direccionPais, direccionCalle, 
                        direccionCp, direccionEstado, direccionCiudad, direccionColonia, direccionTelefono);
                
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
