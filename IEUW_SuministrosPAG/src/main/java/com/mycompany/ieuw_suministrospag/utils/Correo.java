/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ieuw_suministrospag.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Correo {

    public void mandarCorreo(String destinatario) {
        // El correo gmail de envío
        String correoEnvia = "edsonjuan19@gmail.com";
        String claveCorreo = "solido3808629";

        // La configuración para enviar correo
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.user", correoEnvia);
        properties.put("mail.password", claveCorreo);

        // Obtener la sesion
        Session session = Session.getInstance(properties, null);

        try {
            // Crear el cuerpo del mensaje
            MimeMessage mimeMessage = new MimeMessage(session);

            // Agregar quien envía el correo
            mimeMessage.setFrom(new InternetAddress(correoEnvia, "Suministros para las artes graficas."));

            // Los destinatarios
            InternetAddress[] internetAddresses = {new InternetAddress(destinatario)};

            // Agregar los destinatarios al mensaje
            mimeMessage.setRecipients(Message.RecipientType.TO,
                    internetAddresses);

            // Agregar el asunto al correo
            mimeMessage.setSubject("Bienvenido a Suministros para las artes graficas.");

            // Creo la parte del mensaje
            MimeBodyPart mimeBodyPart = new MimeBodyPart();

            mimeBodyPart.setText("Siguiendo el Tutorial de datojava.blogspot.com envío el correo.");

            mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("<html>\n"
                    + "    <body style=\"text-align: center;\">\n"
                    + "        <div style=\"background-color: #325ea0; padding: 10px;\">\n"
                    + "    \n"
                    + "            <img src='https://dv.secoweb.mx/uploads/logo_dist/6824538aa9289d39e884fd71a8f62a08.png'>\n"
                    + "            \n"
                    + "        </div>\n"
                    + "        <div style=\"width: auto; margin-left: 20%; margin-right: 20%;\">\n"
                    + "            <h1>Bienvenido a tu cuenta de Suministros para las artes gráficas!</h1>\n"
                    + "            <h3 style=\"text-align:justify\">Gracias por registrarte a Suminustros para las artes gráficas, de ahora en adelante este sera el contacto principal en el caso de tener alguna duda o problema con nuestro servicio.</h3>\n"
                    + "            <h3 style=\"text-align:justify\">Actualmente 26 años de experiencia en el ramo, nuestro equipo de trabajo se compone de 18 personas, distribuidas en los departamentos de ventas y asesoría, administración, crédito, compras, almacén, y reparto, 9 en la ciudad de Campeche y 9 en la sucursal de la ciudad de Mérida, Yuc. Misma que nos propusimos abrir, y hace casi ya de 6 años, la que en la actualidad tiene una importante expectativa de crecimiento.</h3>\n"
                    + "            <h4>Te damos una calidad bienvenida.</h4>\n"
                    + "            <div>\n"
                    + "                <h2>Contacto</h2>\n"
                    + "                <div style=\"text-align: justify; margin-left: 40%;\">\n"
                    + "                    <h4>✉ ventas@suministrosag.mx</h4>\n"
                    + "                    <h4>✆ +(52) 981 81 112 03</h4>\n"
                    + "                </div>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "        <div style=\"background-color: #325ea0; padding: 10px; height: 70px;\">\n"
                    + "\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>", "text/html");

            // Crear el multipart para agregar la parte del mensaje anterior
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);

            // Agregar el multipart al cuerpo del mensaje
            mimeMessage.setContent(multipart);

            // Enviar el mensaje
            Transport transport = session.getTransport("smtp");
            transport.connect(correoEnvia, claveCorreo);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            transport.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Correo enviado");
    }
}
