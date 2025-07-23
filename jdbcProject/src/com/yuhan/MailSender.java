package com.yuhan;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class MailSender
{
	public static void send(String mailbody, String toRecipt)
	{
		// 네이버 계정 정보
		String host = "smtp.naver.com";
		String port = "587";
		String username = "rhdbgks123@naver.com"; // 본인 네이버 메일 주소
		String password = "XJZHMKWPMTFU"; // 메일 비밀번호

		// 수신자 및 메일 내용
		String subject = "네이버 SMTP 메일 테스트";
		String body = mailbody;

		// SMTP 서버 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); // TLS

		// 인증 세션 생성
		Session session = Session.getInstance(props, new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(username, password);
			}
		});

		// 전송
		try
		{
			// 메일 메시지 구성
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toRecipt));
			
			message.setSubject(subject);
            message.setContent(mailbody, "text/html; charset=UTF-8");

			
			// 메일 전송	
			Transport.send(message);
			System.out.println("메일 전송 성공!");
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
}