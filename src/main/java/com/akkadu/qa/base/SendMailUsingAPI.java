package com.akkadu.qa.base;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMailUsingAPI {
	
	public  void JavaMail() 
	{
		  
		// Create object of Property file
		Properties props = new Properties();
 
		// this will set host of server- you can change based on your requirement 
		props.put("mail.smtp.host", "smtp.gmail.com");
         
		// set the port of socket factory 
		props.put("mail.smtp.socketFactory.port", "465");
 
		// set socket factory
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
 
		// set the authentication to true
		props.put("mail.smtp.auth", "true");
       
		// set the port of SMTP server
		props.put("mail.smtp.port", "465");
		
		//set transport protocol
		props.put("mail.transport.protocol", "smtp");
		
		//set TLS enabled
		props.put("mail.smtp.starttls.enable", "true");
		//Set Time out 
		props.put("mail.smtp.connectiontimeout", "2000");
		
		
		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
		{
 
					protected PasswordAuthentication getPasswordAuthentication() {
 
					return new PasswordAuthentication("rajubugreporter@gmail.com", "Updoer.17");
 
					}
 
				});
 
		try {
			
			
 
			// Create object of MimeMessage class
			Message message = new MimeMessage(session);
 
			// Set the from address
			message.setFrom(new InternetAddress("rajubugreporter@gmail.com"));

			// Set the recipient address
		
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("akash@updoertechnology.com"));
//			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse("nischal@updoertechnology.com"));


                        // Add the subject link
			message.setSubject("AUTOMATION REPORT || GENERATED AFTER SUITES");
 
			// Create object to add multimedia type content
			BodyPart messageBodyPart1 = new MimeBodyPart();
 
			// Set the body of email
			
			
			String EmailBody = "HI," +
					"\r\n"  +"   This Email is system Generated mail,after executing test script!!!,.\r\n" +
			   "\r\n"  +"    Please Find Attachment of Report which are generated after execution of script!! Please Review Report!!!,.\r\n" +
			   "\r\n"  +"Selenium provides inbuilt reports using frameworks such as JUnit and TestNG.\r\n" + 
	   		"\r\n" + 
	   		"Although the built-in reports provide information on the steps that are executed as part of the test case, they need more customization to be shared with all the major project stakeholders.\r\n" + 
	   		"\r\n" + 
	   		"Extent Reports is a customizable HTML report developed by Updoer Automation Team which can be integrated into Selenium WebDriver using JUnit and TestNG frameworks.\r\n"; 
		
			
			
			
			
			
			messageBodyPart1.setText(EmailBody);
 
			
			
			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//			MimeBodyPart messageBodyPart3 = new MimeBodyPart();
//			MimeBodyPart messageBodyPart4 = new MimeBodyPart();
//			// Mention the file which you want to send
			FilePathofExtent fp =  new FilePathofExtent();
			String path = null;
			try {
			   path = 	fp.Filepath();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String filename1 = path;
			System.out.println("Final Path: "+filename1);
//            String filename2 = ".//test-output//ExtentReport.html";
//            String filename3 = ".//test-output//custom-emailable-report.html";
            
			// Create data source and pass the filename
			DataSource source = new FileDataSource(filename1);
//			DataSource source2 = new FileDataSource(filename2);
//			DataSource source3 = new FileDataSource(filename3);
			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));
//			messageBodyPart3.setDataHandler(new DataHandler(source2));
//			messageBodyPart4.setDataHandler(new DataHandler(source3));
			// set the file
			messageBodyPart2.setFileName("Automation_Extent_Report.html");
//			messageBodyPart3.setFileName("Extent Report.html");
//			messageBodyPart4.setFileName("Customize Report.html");
			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();
 
			// add body part 1
			multipart.addBodyPart(messageBodyPart2);
//			multipart.addBodyPart(messageBodyPart3);
//			multipart.addBodyPart(messageBodyPart4);
			// add body part 2
			multipart.addBodyPart(messageBodyPart1);
 
			// set the content
			message.setContent(multipart);
 
			// finally send the email
			Transport.send(message);
 
			System.out.println("=====Email Sent=====");
 
		} catch (MessagingException e) {
 
			throw new RuntimeException(e);
 
		}
 
	}
	
	

}
