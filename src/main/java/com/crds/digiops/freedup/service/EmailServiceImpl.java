package com.crds.digiops.freedup.service;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

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
import com.crds.digiops.freedup.util.DateFormatterUtil;

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
	
	private  Email createEmailUser(File file1) {
		String fromEmail = "srahaiah14@gmail.com";
		String toBeth = "bethany.stutz@crossroads.net"; //Bethany Stutz <bethany.stutz@crossroads.net>
		String toShakila = "shakila.rajaiah@crossroads.net";
		String toNick = "nick.furnish@crossroads.net";
		String toLorri = "lori.gerred@crossroads.net";
	
		
		Email email = new Email();
		
		email.setCcRecepient1(toShakila);
//		email.setToRecepient1(toShakila); // for testing purposes only..
		email.setToRecepient1(toBeth);                                      
		email.setToRecepient2(toNick);
		email.setToRecepient3(toLorri);
		String prevMonth = DateFormatterUtil.getMonth();
		email.setSubject("*** WooCommerce FreedUp Orders Report for " + prevMonth + " ***");
		//"Testing attaching Multiple Citilink Files from Java Application"
		//rhyme = line1 + "\r\n" + line2;
		email.setMessageBody("This email was generated from the WooCommerce - FreedUp Report Application." +"\r\n" 
				+ "Enclosed is the FreedUp Orders Report File with Multiple tabs "+"\r\n" 
				+ " saved here: "
				+"\r\n" 
				 + file1);
		email.setFrom(fromEmail);	

		return email;
		
	}
	
	public  String sendEmailWithAttachments(File multiTabFile) {
		//authentication info for digiopsapps email
		final String username = "digiopsapps@crossroads.net";
		final String password = "wkpugrldfgcfssqs";
		
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
		// create the email object
	  	Email email = createEmailUser(multiTabFile);
	  	//System.out.println("***** created emaiUserl");
		//Start our mail message
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress(email.getFrom()));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient1()));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient2()));
//			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email.getToRecepient3()));
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(email.getCcRecepient1()));
			
			
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
			System.out.println("*** Sent message from email service for FreedUp***");
			logger.info("*** Sent message from email service ***");
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


}
