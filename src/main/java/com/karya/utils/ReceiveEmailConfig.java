package com.karya.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Flags.Flag;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.search.FlagTerm;

import com.karya.bean.EmailBean;

public class ReceiveEmailConfig {
	final private String emailAddress = "testkarya@gmail.com";  
    final private String emailPassword = "Pass@12345";
    final private String host = "imap.gmail.com"; // For GMAIL
    //final private String host = "imap.mail.yahoo.com"; // For Yahoo Mail
    private Properties properties = System.getProperties();
    
    public ReceiveEmailConfig() {
    	properties.setProperty("mail.store.protocol", "imaps");
    	properties.put("mail.smtp.host", "smtp.gmail.com");
    	properties.put("mail.smtp.socketFactory.port", "465");
    	properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	properties.put("mail.smtp.auth", "true");
    	properties.put("mail.smtp.port", "465");
    }
    
    private Store doConnect() throws Exception {
    	Session session = Session.getDefaultInstance(properties, null);
    	Store store = session.getStore("imaps");
    	store.connect(host, emailAddress, emailPassword);
    	return store;
    }
    
    private Folder getFolder(String place) throws Exception {
    	Folder folder = null;
    	if(place.equalsIgnoreCase("inbox"))
    		folder = doConnect().getFolder("Inbox");
    	if(place.equalsIgnoreCase("sent"))
    		folder = doConnect().getFolder("[Gmail]/Sent Mail");
    	if(place.equalsIgnoreCase("trash"))
    		folder = doConnect().getFolder("[Gmail]/Trash");
    	folder.open(Folder.READ_WRITE);
    	return folder;
    }
    
    public List<EmailBean> getAllEMail(String place) throws Exception {
    	Message messages[] = getFolder(place).getMessages();
    	List<EmailBean> emaildetails = new ArrayList<EmailBean>();
        for(Message message : messages) {
        	EmailBean bean = new EmailBean();
        	bean.setEmailId(message.getMessageNumber());
        	if(place.equalsIgnoreCase("inbox")) {
        		bean.setEmailDate(message.getReceivedDate().toString());
        		bean.setEmailCurrentPlace("inbox");
        	}
        	if(place.equalsIgnoreCase("sent")) {
        		bean.setEmailDate(message.getSentDate().toString());
        		bean.setEmailCurrentPlace("sent");
        	}
        	if(place.equalsIgnoreCase("trash")) {
        		bean.setEmailCurrentPlace("trash");
        		if(message.getReceivedDate() != null)
        			bean.setEmailDate(message.getReceivedDate().toString());
        		else
        			bean.setEmailDate(message.getSentDate().toString());
        	}
        	if(message.getSubject() != null)
        		bean.setEmailSubject(message.getSubject().toString());
        	else
        		bean.setEmailSubject("(no subject)");
        	
        	if(message.getFlags().contains(Flag.SEEN) == true)
        		bean.setIsEmailViewed("yes");
        	else
        		bean.setIsEmailViewed("no");
        	emaildetails.add(bean);
        }
        return emaildetails;
    }
    
    public EmailBean getEMail(int emailId, String place) throws Exception{
    	Message messages[] = getFolder(place).getMessages();
    	EmailBean bean = new EmailBean();
        for(Message message : messages) {
        	if(message.getMessageNumber() == emailId) {
        		bean.setEmailId(message.getMessageNumber());
            	if(place.equalsIgnoreCase("inbox"))
            		bean.setEmailDate(message.getReceivedDate().toString());
            	if(place.equalsIgnoreCase("sent"))
            		bean.setEmailDate(message.getSentDate().toString());
            	if(place.equalsIgnoreCase("trash")) {
            		if(message.getReceivedDate() != null)
            			bean.setEmailDate(message.getReceivedDate().toString());
            		else
            			bean.setEmailDate(message.getSentDate().toString());
            	}
            	bean.setEmailFrom(message.getFrom()[0].toString());
            	bean.setEmailTo(doFormatEmailRecipients(message, Message.RecipientType.TO));
            	bean.setEmailCc(doFormatEmailRecipients(message, Message.RecipientType.CC));
            	bean.setEmailBcc(doFormatEmailRecipients(message, Message.RecipientType.BCC));
            	doFormatEmailContents(message);
            	if(message.getSubject() != null)
            		bean.setEmailSubject(message.getSubject().toString());
            	else
            		bean.setEmailSubject("(no subject)");
            	if (message.getContent() instanceof String) {
                	bean.setEmailBody(message.getContent().toString());
                } else if (message.getContent() instanceof Multipart) {
                    Multipart multiPart = (Multipart) message.getContent();
                    bean.setEmailBody(procesMultiPart(multiPart));
                }
            	if(message.getFlags().contains(Flag.SEEN) == false)
            		message.setFlag(Flag.SEEN, true);	
            }
        }
        return bean;	
    }
    
    public void moveSingleMailToTrash(int emailId, String place) throws Exception {
    	Message messages[] = getFolder(place).getMessages();
        for(Message message : messages) {
        	if(message.getMessageNumber() == emailId)
        		getFolder(place).copyMessages(new Message[] { message }, getFolder("trash"));
        }
    }
    
    public void moveMultipleMailToTrash(List<Integer> emailIdList, String place) throws Exception {
		Message messages[] = getFolder(place).getMessages();
    	for(int index = 0; index < emailIdList.size(); index ++) {
    		 for(Message message : messages) {
        		if(message.getMessageNumber() == emailIdList.get(index))
            		getFolder(place).copyMessages(new Message[] { message }, getFolder("trash"));
    		 }
    	}
    }
    
    public void deleteSingleEmail(int emailId) throws Exception {
    	Message messages[] = getFolder("trash").getMessages();
        for(Message message : messages) {
        	if(message.getMessageNumber() == emailId) {
        		message.setFlag(Flag.DELETED, true);
        		getFolder("trash").expunge();
        	}
        }
    }
    
    public void deleteMultipleEmails(List<Integer> emailIdList) throws Exception {
    	Message messages[] = getFolder("trash").getMessages();
        for(int index = 0; index < emailIdList.size(); index ++) {
        	for(Message message : messages) {
            	if(message.getMessageNumber() == emailIdList.get(index)) {
            		message.setFlag(Flag.DELETED, true);
            		getFolder("trash").expunge();
            	}
            }
        }
    }
    
    public int getCountUnreadEMail(String place) throws Exception{
    	FlagTerm flagterm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
        Message messages[] = getFolder(place).search(flagterm);
        return messages.length;
    }
    
    public List<EmailBean> getUnReadEMail(String place) throws Exception {
    	FlagTerm flagterm = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
        Message messages[] = getFolder(place).search(flagterm);
    	EmailBean bean = new EmailBean();
    	List<EmailBean> emaildetails = new ArrayList<EmailBean>();
        for(Message message : messages) {
        	bean.setEmailId(message.getMessageNumber());
        	if(place.equalsIgnoreCase("inbox"))
        		bean.setEmailDate(message.getReceivedDate().toString());
        	if(place.equalsIgnoreCase("sent"))
        		bean.setEmailDate(message.getSentDate().toString());
        	if(place.equalsIgnoreCase("trash")) {
        		if(message.getReceivedDate() != null)
        			bean.setEmailDate(message.getReceivedDate().toString());
        		else
        			bean.setEmailDate(message.getSentDate().toString());
        	}
        	if(message.getSubject() != null)
        		bean.setEmailSubject(message.getSubject().toString());
        	else
        		bean.setEmailSubject("(no subject)");
        	emaildetails.add(bean);
        }
        return emaildetails;
    }
    
    private String procesMultiPart(Multipart content) throws Exception {
        int multiPartCount = content.getCount();
        String mailbody = null;
        for (int count = 0; count < multiPartCount; count++) {
            BodyPart bodyPart = content.getBodyPart(count);
            Object object;
            object = bodyPart.getContent();
            if (object instanceof String) {
                mailbody = object.toString();
            } else if (object instanceof Multipart) {
                procesMultiPart((Multipart) object);
            }
        }
        return mailbody;
    }
    
    private String doFormatEmailRecipients(Message message, Message.RecipientType type) throws MessagingException {
		String receipient = InternetAddress.toString(message.getRecipients(type));
		if(receipient != null)
			return receipient;
		else
			return "";
    }
    
    private void doFormatEmailContents(Message message) throws Exception{
    	String contentType = message.getContentType();
        String messageContent = "";

        // store attachment file name, separated by comma
        String attachFiles = "";

        if (contentType.contains("multipart")) {
            // content may contain attachments
            Multipart multiPart = (Multipart) message.getContent();
            int numberOfParts = multiPart.getCount();
            for (int partCount = 0; partCount < numberOfParts; partCount++) {
                MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                    // this part is attachment
                    String fileName = part.getFileName();
                    attachFiles += fileName + ", ";
                    //part.saveFile(saveDirectory + File.separator + fileName);
                } else {
                    // this part may be the message content
                    messageContent = part.getContent().toString();
                }
            }

            if (attachFiles.length() > 1) {
                attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
            }
        } else if (contentType.contains("text/plain")
                || contentType.contains("text/html")) {
            Object content = message.getContent();
            if (content != null) {
                messageContent = content.toString();
            }
        }

        // print out details of each message
        System.out.println("\t Message: " + messageContent);
        System.out.println("\t Attachments: " + attachFiles);
    }
    
	public static void main(String a[]) throws Exception {
		ReceiveEmailConfig ob = new ReceiveEmailConfig();
		System.out.println(ob.getAllEMail("inbox").get(0).getEmailDate());
	}

}
