package com.denovo.Pages;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSenderfile {

    public static void main(String[] args) throws Exception {

       /* String to = "recipient@example.com"; // recipient email address
        String from = "sender@example.com"; // sender email address
        String host = "smtp.example.com"; // SMTP server host

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject("Subject of the email");

        // Set the content of the message
        message.setText("This is the message body");

        // Send the message
        Transport.send(message);
        System.out.println("Message sent successfully.");*/
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


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