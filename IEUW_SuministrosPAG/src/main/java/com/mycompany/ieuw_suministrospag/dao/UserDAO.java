/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.dao;

import com.mycompany.ieuw_suministrospag.models.UserModel;
import com.mycompany.ieuw_suministrospag.utils.DbConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserDAO {
    
    public static int InsertUser(UserModel user) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`user_procedure`(?, NULL, ?, ?, ?, ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "I");
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserPassword());
            statement.setString(4, user.getUserMail());
            statement.setInt(5, user.getUserType());
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
    
    public static UserModel SelectUserLogin(UserModel user) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
        String sql = "CALL `suministrosag_db`.`user_procedure`(?, NULL, ?, ?, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "UL");
            statement.setString(2, user.getUserName());
            statement.setString(3, user.getUserPassword());
            ResultSet result = statement.executeQuery();
             while(result.next()){
                 Integer id = Integer.parseInt(result.getString("iduser"));
                 String name = result.getString("userName");
                 String password = result.getString("userPassword");
                 String email = result.getString("userMail");
                 Integer userType = Integer.parseInt(result.getString("userType"));
                 Integer userOnboarding = Integer.parseInt(result.getString("userOnboarding"));
                 return new UserModel(id, name, password, email, userType, userOnboarding);
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
        return null;
    }
    
    public static Boolean userExistsByName(String name) throws SQLException{
            Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`user_procedure`(?, NULL, ?, NULL, NULL, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "VU");
            statement.setString(2, name);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println("No se puede");
                return true;
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
        return false;
    }
    
     public static Boolean userExistsByEmail(String email) throws SQLException{
            Connection con = DbConnection.getConnection();
        try{
            String sql = "CALL `suministrosag_db`.`user_procedure`(?, NULL, NULL, NULL, ?, NULL);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setString(1, "E");
            statement.setString(2, email);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println("No se puede");
                return true;
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
        return false;
    }
     
     public static int UpdateOnboarding(int idUser) throws SQLException{
        Connection con = DbConnection.getConnection();
        try{
            String sql = "UPDATE `suministrosag_db`.`user` SET `userOnboarding` = '1' WHERE (`iduser` = ?);";
            CallableStatement statement = con.prepareCall(sql);
            statement.setInt(1, idUser);
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
}
