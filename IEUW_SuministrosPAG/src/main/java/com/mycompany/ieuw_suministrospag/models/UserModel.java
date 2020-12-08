/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.models;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class UserModel {
    private int iduser;
    private String userName;
    private String userPassword;
    private String userMail;
    private int userType;
    private int userOnboarding;

    public UserModel(int iduser, String userName, String userPassword, String userMail, int userType) {
        this.iduser = iduser;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userType = userType;
    }

    public UserModel(int iduser, String userName, String userPassword, String userMail, int userType, int userOnboarding) {
        this.iduser = iduser;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userType = userType;
        this.userOnboarding = userOnboarding;
    }
    
    public UserModel(String userName, String userPassword, String userMail, int userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userMail = userMail;
        this.userType = userType;
    }

    public UserModel(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }
    
    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserOnboarding() {
        return userOnboarding;
    }

    public void setUserOnboarding(int userOnboarding) {
        this.userOnboarding = userOnboarding;
    }
    
    
}
