package com.karya.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.multipart.MultipartFile;

import com.karya.model.Email001MB;
import com.karya.model.EmailAttachment001MB;

public class EmailConfig {
	
	final private static String emailFrom = "testkarya@gmail.com";  
    final private static String loginPassword = "Pass@12345";
	
    /**
     * 
     * @return
     */
	private static Session doEmailConfig() {
		
	    // Set Property
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		  
		Session emailSession = Session.getDefaultInstance(props,  
		   new javax.mail.Authenticator() {  
		   protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication(emailFrom, loginPassword);  
		   }  
		});
		return emailSession;
	}
	
	/**
	 * 
	 * @param email001mb
	 * @param emailattachment001mb
	 * @param attachfile
	 * @throws Exception
	 */
	public static void doComposeEmail(Email001MB email001mb, EmailAttachment001MB emailattachment001mb, MultipartFile attachfile) throws Exception {
		
		MimeMessage message = new MimeMessage(doEmailConfig());
	    message.setFrom(new InternetAddress(emailFrom));  
	    message.addRecipients(Message.RecipientType.TO, doFormatRecipient(email001mb.getEmailTo()));
	    if(email001mb.getEmailCc().length() > 0)
	    	message.addRecipients(Message.RecipientType.CC, doFormatRecipient(email001mb.getEmailCc()));
	    if(email001mb.getEmailBcc().length() > 0)
	    	message.addRecipients(Message.RecipientType.BCC, doFormatRecipient(email001mb.getEmailBcc()));
	    message.setSubject(email001mb.getEmailSubject());  
	      
	    // Email Attachment
	    MimeBodyPart emailAttachment = new MimeBodyPart();  
	    
	    MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(email001mb.getEmailBody(), "text/html");
	     
	    // Set Email Body
	    Multipart multipart = new MimeMultipart();  
	    multipart.addBodyPart(messageBodyPart);
	    
	    emailAttachment.attachFile(convertToFile(attachfile));
        multipart.addBodyPart(emailAttachment);
        
        message.setContent(multipart);
	    
        // Send Email
	    Transport.send(message);
	}
	
	/**
	 * 
	 * @param email001mb
	 * @throws Exception
	 */
	public static void doComposeEmail(Email001MB email001mb) throws Exception {
			
		MimeMessage message = new MimeMessage(doEmailConfig());
	    message.setFrom(new InternetAddress(emailFrom));  
	    message.addRecipients(Message.RecipientType.TO, doFormatRecipient(email001mb.getEmailTo()));
	    if(email001mb.getEmailCc().length() > 0)
	    	message.addRecipients(Message.RecipientType.CC, doFormatRecipient(email001mb.getEmailCc()));
	    if(email001mb.getEmailBcc().length() > 0)
	    	message.addRecipients(Message.RecipientType.BCC, doFormatRecipient(email001mb.getEmailBcc()));  
	    message.setSubject(email001mb.getEmailSubject());
	    message.setContent(email001mb.getEmailBody(), "text/html");
	    
	    // Send Email
	    Transport.send(message);
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	private static File convertToFile(MultipartFile file) throws Exception{    
	    File convFile = new File(file.getOriginalFilename());
	    convFile.createNewFile(); 
	    FileOutputStream fos = new FileOutputStream(convFile); 
	    fos.write(file.getBytes());
	    fos.close(); 
	    return convFile;
	}
	
	/**
	 * Format Email Address
	 * @param emailaddress
	 * @return
	 * @throws Exception
	 */
	private static Address[] doFormatRecipient(String emailaddress) throws Exception {
		Address[] formatedemailaddress;
		if(emailaddress.contains(";")) {
			String[] splitEmailAddress = emailaddress.split(";");
			formatedemailaddress = new Address[splitEmailAddress.length];
			for(int email = 0; email < splitEmailAddress.length; email ++)
				formatedemailaddress[email] = new InternetAddress(splitEmailAddress[email]);
		}
		else
			formatedemailaddress = new Address[]{new InternetAddress(emailaddress)};
		return formatedemailaddress;
	}
}
