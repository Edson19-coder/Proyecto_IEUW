/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.ieuw_suministrospag.utils;

import java.util.Properties;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Correo {
    
    public static void enviarMail(){
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
        
        String myAccountEmail = "edsonjuan19@gmail.com";
        String password = "solido3808629";
    }
}
