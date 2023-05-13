package com.denovo.testscripts;

import org.testng.annotations.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

import static javax.mail.Transport.send;

public class SendEmailTest {

    @Test
    public void sendEmailTest() throws Exception {
        /*Properties props = new Properties();
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

        Transport.send(message);*/

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.transport.protocol", "smpt");


        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("bmurthy@denovosystem.com","xqzjdicmbsdwumnp");
            }
        });

        Message message = new MimeMessage(session);
        message.setSubject("IPOSPAYS MONITOR SYSTEM REPORT");

        Address addressTo = new InternetAddress("bhaskarmurthy215@gmail.com");
        message.setRecipient(Message.RecipientType.TO,addressTo);


        //To send Multiple people
        // Address address2To = new InternetAddress("bhaskarmurthy@gmail.com");
        // message.addRecipient(Message.RecipientType.TO,address2To);

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(new File("extent-test-output/ExtentReport.html"));

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("<h1>IPOSPAYS FAILED FAILED REPORT<h1>","text/html");

        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachment);
        messageBodyPart.setText("Hi Team, PFA ExtentReport Failed Details,Download the Extent Report and verify.");
        message.setContent(multipart);
        send(message);

    }
}