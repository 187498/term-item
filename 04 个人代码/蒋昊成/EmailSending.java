package com.scu03.email;

import java.net.URL;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Address;  
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.net.ssl.internal.ssl.Provider;


public class EmailSending {
	/*public static void main(String args[]){
		String email = "402376637@qq.com";
		EmailSending e = new EmailSending();
		e.sendingemail(email);
	}*/

    public void sendingemail(String email) {  

    	String message = "������Ϣ�ѷ������";
    	

        try {  

 //��һ��������QQ�������������ͬ�������ǲ�ͬ�ķ����������ڶ����������ʼ������ߣ����������ʼ����������룬���ĸ��������ʼ������ߣ�����������Ƿ��͵��ʼ���Ϣ

            sendMail("smtp.qq.com", "942562029@qq.com", "feteutwgdlxtbdbe", email, message);  

        } catch (Exception e) {  

            e.printStackTrace();  

        }  

    }  

    /** 

     * @param args add by zxx ,Feb 5, 2009 

     */  

    public static void sendMail(String smtpHost, String from,String password, String to,String message) throws Exception{  

        // TODO Auto-generated method stub  

        Properties props = new Properties();  

        props.setProperty("mail.smtp.auth", "true");  

        props.setProperty("mail.transport.protocol", "smtp");  

        Session session = Session.getInstance(props);  

        session.setDebug(true);  

          

        Message msg = new MimeMessage(session);  

        msg.setText(message);  

        msg.setFrom(new InternetAddress(from));  

      

        Transport transport = session.getTransport();  

        transport.connect(smtpHost, 25, from.split("@")[0], password);  

        transport.sendMessage(msg,  

                new Address[]{new InternetAddress(to)});  

        transport.close();  

    }  

}   
