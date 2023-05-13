package com.denovo.Pages;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSenderfile {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocl","smpt");


        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("bmurthy@denovosystem.com", "xqzjdicmbsdwumnp");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("bmurthy@denovosystem.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("bhaskarmurthy215@gmail.com"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("bmurthy@denovosystem.com"));
        message.setSubject("Build failed");
        message.setText("The build failed. Please check the logs.");

        Transport.send(message);
    }
}