package com.penglecode.gulubala.common.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Authenticator;

import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.penglecode.gulubala.common.consts.AbstractConstants;
import com.penglecode.gulubala.common.consts.GlobalConstants;
import com.penglecode.gulubala.common.support.ConstValue;

/**
 * java邮件发送工具类
 * 
 * @author  pengpeng
 * @date 	 2015年8月8日 下午4:47:49
 * @version 1.0
 */
public class JavaMailUtils extends AbstractConstants {

	public static final String DEFAULT_CHARSET = GlobalConstants.SYSTEM_DEFAULT_ENCODING;
	
	public static final String DEFAULT_CONTENT_TYPE_HTML = "text/html;charset=" + DEFAULT_CHARSET;
	
	/** 发送邮件协议 */
	public static final String MAIL_TRANSPORT_PROTOCOL = valueOf("smtp");
	
	/** 设置验证机制 */
	@ConstValue("${mail.smtp.auth}")
	public static final boolean MAIL_SMTP_AUTH = valueOf(true);
	
	/** 设置邮箱服务器地址 */
	@ConstValue("${mail.smtp.host}")
	public static final String MAIL_SMTP_HOST = valueOf("smtp.163.com");
	
	/** 设置邮箱服务器端口号 */
	@ConstValue("${mail.smtp.port}")
	public static final String MAIL_SMTP_PORT = valueOf("25");
	
	/** 设置邮箱用户名 */
	@ConstValue("${mail.auth.username}")
	public static final String MAIL_AUTH_USERNAME = valueOf("gulubala@163.com");
	
	/** 设置邮箱密码 */
	@ConstValue("${mail.auth.password}")
	public static final String MAIL_AUTH_PASSWORD = valueOf("pcaxreamtgqxsbnn");
	
	private static final Properties mailConfigProperties = new Properties();
	
	protected static Properties getMailConfigProperties() {
		if(mailConfigProperties.isEmpty()){
			mailConfigProperties.put("mail.transport.protocol", MAIL_TRANSPORT_PROTOCOL);
			mailConfigProperties.put("mail.smtp.auth", MAIL_SMTP_AUTH);
			mailConfigProperties.put("mail.smtp.host", MAIL_SMTP_HOST);
			mailConfigProperties.put("mail.smtp.port", MAIL_SMTP_PORT);
		}
		return mailConfigProperties;
	}
	
	public static Session createSession(){
		return Session.getInstance(getMailConfigProperties(), new MailAuthenticator());
	}
	
	/**
	 * 发送简单文本邮件
	 * @param mailTo
	 * @param subject
	 */
	protected static MimeMessage buildMailMessage(String mailTo, String subject) {
		try {
			// 创建邮件消息
			Session session = createSession();
			//session.setDebug(true);
			MimeMessage message = new MimeMessage(session);
			// 设置发件人
			InternetAddress from = new InternetAddress(MAIL_AUTH_USERNAME);
			message.setFrom(from);
			// 设置收件人
			InternetAddress to = new InternetAddress(mailTo);
			message.setRecipient(RecipientType.TO, to);
			//设置邮件主题
			message.setSubject(subject, DEFAULT_CHARSET);
			//设置邮件发送时间
			message.setSentDate(new Date());
			return message;
		} catch (MessagingException e) {
			throw new JavaMailException(e.getMessage(), e);
		}
	}
	
	/**
	 * 发送简单文本邮件
	 * @param mailTo
	 * @param subject
	 * @param content	- 简单文本邮件
	 */
	public static void sendTextMail(String mailTo, String subject, String text) {
		try {
			MimeMessage message = buildMailMessage(mailTo, subject);
			//设置邮件内容
			message.setText(text, DEFAULT_CHARSET);
			//发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			throw new JavaMailException(e.getMessage(), e);
		}
	}
	
	/**
	 * 发送html邮件
	 * @param mailTo
	 * @param subject
	 * @param html	- html邮件
	 */
	public static void sendHtmlMail(String mailTo, String subject, String html) {
		try {
			MimeMessage message = buildMailMessage(mailTo, subject);
			//设置邮件内容
			message.setContent(html, DEFAULT_CONTENT_TYPE_HTML);
			//发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			throw new JavaMailException(e.getMessage(), e);
		}
	}
	
	public static class MailAuthenticator extends Authenticator {
		protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(MAIL_AUTH_USERNAME, MAIL_AUTH_PASSWORD);
        }
	}
	
	public static class JavaMailException extends RuntimeException {
		
		private static final long serialVersionUID = 1L;

		public JavaMailException(String message, Throwable cause) {
			super(message, cause);
		}

		public JavaMailException(String message) {
			super(message);
		}

		public JavaMailException(Throwable cause) {
			super(cause);
		}
		
	}
}
