package com.crds.digiops.freedup.service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crds.digiops.freedup.model.Email;
//import com.crds.digiops.freedup.util.DateFormatterUtil;

/**
 * @author S RAJAIAH
 * @Date - July10, 2021
 * @Description - This class provides the email service..
 * @return 
 * @Params
 * @Called from : WriteExcelSheetsFile(List<OrderPOJOCSV> payouts, List<OrderPOJOCSV> couples, List<OrderPOJOCSV> individuals, List<OrderPOJOCSV> failed, String fileName) 
 */
public class EmailServiceImpl{

	/**
	 * 
	 */
	public EmailServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	
	/**
	 * @author Shakila Rajaiah
	 * @Date  October 12, 2023
	 * @Description: gets the host name and address for the server
	 *               
	 */	
    public String[] getHostAddress() throws UnknownHostException {
    	
    	String[] arr = new String[2];
//    	arr[0] = ans1;
//    	arr[1] = ans2;
//    	return arr;

        arr[0] = InetAddress.getLocalHost().getHostAddress();
		System.out.println(" HostAddress: " + arr[0]);
		logger.info(" HostAddress: " + arr[0]);
		arr[1] =InetAddress.getLocalHost().getHostName();
		System.out.println("HostName : " + arr[1]);
		logger.info(" HostName: " + arr[1]);
		
		return arr;		
    }
	
	private  Email createEmailUser(File file1, String[] arr) {
		String fromEmail = "srahaiah14@gmail.com";
		String toShakila = "shakila.rajaiah@crossroads.net";
		String toCrgs = "crgs.accountspayable@crossroads.net";
		
		Email email = new Email();
		
		email.setToRecepient1(toShakila); 
		email.setToRecepient2(toCrgs);  

		
		// updated to run weekly reports on 10/16/2023 per Nick & Bethany
		//email.setSubject("*** WooCommerce FreedUp Weekly Orders Report: " + arr[0] + " ***");
		
		//using underscores in the IP address so that MimeCast doesn't stop it sometime in the future if they make any changes.
		String replaceServer = arr[0].replace('.','_');//replaces all occurrences of '.' to '-'
		System.out.println("replaceServer : " + replaceServer);
		//email.setSubject("*** PAYCOR ACTIVE EMPLOYEES DATA FILE FOR 15Five ***** :  " + arr[1] + " (" + replaceServer + ")");
		
		if (arr[0].equals("10.2.48.17")) {
			email.setSubject("*** WooCommerce FreedUp Orders Report: " + arr[1] + " (" + replaceServer + ")");	

		}
		else {			
			email.setSubject("*** TESTING *** WooCommerce FreedUp Orders Report:  " + arr[1] + " (" + replaceServer + ")");	
		}
		//rhyme = line1 + "\r\n" + line2;
		email.setMessageBody("This email was generated from the WooCommerce FreedUp - ORDERS Report Application." +"\r\n" 
				+ "From Server : "+ arr[0] + "\r\n" 
				+ "From Computer name : " + arr[1] +"\r\n" 
				+ "Enclosed is the FreedUp Orders Report File with Multiple tabs "+"\r\n" 
				+ " saved here: "
				+"\r\n" 
				 + file1);
		email.setFrom(fromEmail);	

		return email;		
	}
	
	
	private  Email createEmailUser(String errorMessage, String[] arr) {
		String fromEmail = "srahaiah14@gmail.com";
		String toShakila = "shakila.rajaiah@crossroads.net";
		//String toCrgs = "crgs.accountspayable@crossroads.net";
	
		
		Email email = new Email();	
		email.setToRecepient1(toShakila); 
		
		//using underscores in the IP address so that MimeCast doesn't stop it sometime in the future if they make any changes.
		String replaceServer = arr[0].replace('.','_');//replaces all occurrences of '.' to '-'
		System.out.println(replaceServer);
		
		email.setSubject("*** ERROR **** Processing WooCommerce ORDERS Report for "  + arr[1] + " (" + replaceServer + ")");	

		if (arr[0].equals("10.2.48.17")) {
			email.setSubject("*** *** ERROR **** Processing WooCommerce ORDERS Report for " + arr[1] + " (" + replaceServer + ")");	

		}
		else {			
			email.setSubject("*** TESTING *** ERROR **** Processing WooCommerce ORDERS Report for " + arr[1] + " (" + replaceServer + ")");	
		}	
		
		email.setMessageBody("This email was generated from the WooCommerce - FreedUp Report Application." +"\r\n" 
				+ "Enclosed is the FreedUp Orders Report File  "+"\r\n" 
				+ "From Server : "+ arr[0] + "\r\n" 
				+ "From Computer name : " + arr[1] +"\r\n" 
				+ " Error Message Enclosed below: "
				+"\r\n" 
				 + errorMessage);
		email.setFrom(fromEmail);	

		return email;
		
	}
	
	private  Email createEmailUserSystemStatus( String[] arr) {
		String fromEmail = "srahaiah14@gmail.com";
		String toShakila = "shakila.rajaiah@crossroads.net";
		//String toCrgs = "crgs.accountspayable@crossroads.net";
		LocalDateTime now = LocalDateTime.now();
	
		
		Email email = new Email();	
		email.setToRecepient1(toShakila); 
		
		//using underscores in the IP address so that MimeCast doesn't stop it sometime in the future if they make any changes.
		String replaceServer = arr[0].replace('.','_');//replaces all occurrences of '.' to '-'
		System.out.println(replaceServer);
		
		//email.setSubject("*** SYSTEM SERVERS UP AND RUNNING  for  "  + arr[1] + " (" + replaceServer + ")");	

		if (arr[0].equals("10.2.48.17")) {
			email.setSubject("*** SYSTEM SERVERS UP And Running for WooCommerce " + arr[1] + " (" + replaceServer + ")");	

		}
		else {			
			email.setSubject("*** TESTING **** SYSTEM SERVERS Running for WooCommerce " + arr[1] + " (" + replaceServer + ")");		
		}	
		
		email.setMessageBody("This email was generated from the WooCommerce - FreedUp Report Application." +"\r\n" 
				+ "Enclosed is the FreedUp Orders Report File  " 
				+ "\r\n" 
				+ "From Server : "+ arr[0] 
				+ "\r\n" 
				+ "From Computer name : " + arr[1] 
				+ "\r\n" 
				+ " for date & Time " + now 
				+ "\r\n");
		
		email.setFrom(fromEmail);	

		return email;
		
	}
	
	public  String sendEmailWithAttachments(File multiTabFile) throws UnknownHostException {
		//authentication info for digiopsapps email
		final String username = "digiopsapps@crossroads.net";
		//final String password = "wkpugrldfgcfssqs";
		// changed on 3/28/2024 due to password reset due to jump cloud changes
		//dgrqfmthmdcysimr
		final String password = "dgrqfmthmdcysimr";
		
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username,password);
			}
		});
		String[]arr = getHostAddress();
		// create the email object
	  	Email email = createEmailUser(multiTabFile, arr);
	  	//System.out.println("***** created emaiUserl");
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(email.getFrom()));
			
			// if it is ITProd1 - accounts payable & shakila.
			if (arr[0].equals("10.2.48.17")) {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient1()));
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient2()));
			}
			// ITDev1 and Shakila's
			else {
				msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient1()));
			}
			
			msg.setSubject(email.getSubject());
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(email.getMessageBody());			

			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();

			pdfAttachment.attachFile(multiTabFile);
		
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			emailContent.addBodyPart(pdfAttachment);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("*** Sent message from email service for FreedUp ***");
			logger.info("*** Sent message from email service for FreedUp ***");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.error("Error Sending Email" + e);
			return "Error Sending Email";

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error Sending Email" +e);
			return "Error Sending Email";
		}
		return "Email was sent Successfully";
	}

	public  String sendEmailWithError(String errorMessage) throws UnknownHostException {
		//authentication info for digiopsapps email
		final String username = "digiopsapps@crossroads.net";
		final String password = "dgrqfmthmdcysimr";
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username,password);
			}
		});
		
		String [] arr = getHostAddress();
		// create the email object
	  	Email email = createEmailUser(errorMessage, arr);
	  	//System.out.println("***** created emaiUserl");
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(email.getFrom()));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient1()));			
			msg.setSubject(email.getSubject());
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(email.getMessageBody());
			

			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();

//			pdfAttachment.attachFile(multiTabFile);
		
			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			//emailContent.addBodyPart(pdfAttachment);

			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("*** Sent message from email service for FreedUp***");
			logger.info("*** Sent message from email service for FreedUp ***");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.error("Error Sending Email" + e);
			return "Error Sending Email";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error Sending Email" +e);
			return "Error Sending Email";
		}
		return "Email was sent Successfully";
	}
	
	
	public  String sendEmailWithSystemStatus() throws UnknownHostException {
		//authentication info for digiopsapps email
		final String username = "digiopsapps@crossroads.net";
		final String password = "dgrqfmthmdcysimr";
		
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username,password);
			}
		});
		
		String [] arr = getHostAddress();
		// create the email object
	  	Email email = createEmailUserSystemStatus( arr);
	  	//System.out.println("***** created emaiUserl");
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(email.getFrom()));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient1()));			
			msg.setSubject(email.getSubject());
			
			Multipart emailContent = new MimeMultipart();
			
			//Text body part
			MimeBodyPart textBodyPart = new MimeBodyPart();
			textBodyPart.setText(email.getMessageBody());
			

			//Attachment body part.
			MimeBodyPart pdfAttachment = new MimeBodyPart();

			//Attach body parts
			emailContent.addBodyPart(textBodyPart);
			
			//Attach multipart to message
			msg.setContent(emailContent);
			
			Transport.send(msg);
			System.out.println("*** Sent message from emailservice for FreedUp  SERVER STATUS***");
			logger.info("*** Sent message from emailservice FOR FREEDUP SERVER STATUS***");
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.error("Error Sending Email FOR FREEDUP SERVER STATUS " + e);
			return "Error Sending Email FOR FREEDUP SERVER STATUS";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("Error Sending Email FOR FREEDUP SERVER STATUS" +e);
			return "Error Sending Email FOR FREEDUP SERVER STATUS ";
		}
		return "Email was sent Successfully FOR FREEDUP SERVER STATUS";
	} 

	

}
