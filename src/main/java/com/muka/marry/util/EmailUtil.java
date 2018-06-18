package com.muka.marry.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

import com.muka.marry.model.UserModel;

public class EmailUtil {
private static final	Logger logger=Logger.getLogger(EmailUtil.class);
	private   static final String username = "wasimuka1@gmail.com";
	private  static  final String password = "SNwasimuka";
	static Properties props = new Properties();
	
	static {
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	}

	public static void sendEmail()
	   {    
		//final String username = "wasimuka1@gmail.com";
		//final String password = "SNwasimuka";

	/*	Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");*/

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("wasimuka1@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("munquasim4@gmail.com"));
			message.setSubject("Birthday wishes");
			message.setText("Dear User,"
				+ "\n\n Happy Birthday to you: ");
		

			Transport.send(message);
	        logger.info("User Registration Email sent successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} 
    }
	
	public static void sendRegistrationEmail(UserModel user)
	   {    
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		  });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("wasimuka1@gmail.com"));
			//message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("munquasim4@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(user.getEmail()));
			message.setSubject("Your MarryCall Profile Created Successfully");
			message.setText("Dear "+user.getFullName()+","+ 
			"\n\n Your ProfileId: "+user.getId()+
			"\n\n Your Username: "+user.getEmail());
			
		     Transport.send(message);
		     logger.info("User Registration Email sent successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} 
 }
	   
	   

}
