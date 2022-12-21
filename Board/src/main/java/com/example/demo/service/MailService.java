package com.example.demo.service;


import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.search.RecipientTerm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	// 개발 주소
	@Value("${EMAIL.URL}")
	private String HOST;
	
	public void sendEmail_CRTFC_NMBR(String toEmail,String token) throws Exception{
		MimeMessage message = javaMailSender.createMimeMessage();
		
		try {
			message.addRecipients(RecipientType.TO, toEmail); // 보내는 대상
			message.setSubject("[Moim] 비밀번호 변경 링크"); // 제목
			
	        String contenst = "<h1>비밀번호 변경 링크입니다.</h1>";
	        contenst += "<p>비밀번호 변경 링크입니다.<br>비밀번호 변경하기 버튼을 눌러 비밀번호를 변경해주세요.</p><br><br>";
	        // 개발
	        contenst += "<p><a href = '"+HOST+"/password/%s/%s' style = 'margin-top:30px;text-decoration:none;padding : 15px 15px;color : white;background-color : green; width : 150px;'>비밀번호 변경하기</a></p>";
	        // 
	        message.setText(String.format(contenst, toEmail,token),"utf-8","html");
	        
	        message.setFrom(new InternetAddress("pipiya2@naver.com","Moim_Admin"));
	        javaMailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
