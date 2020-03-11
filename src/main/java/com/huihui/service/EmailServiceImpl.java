package com.huihui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender ;

    @Async
    @Override
    public void send(String title, String email, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setSubject(title);
        mimeMessageHelper.setText(content+email,true);
        mimeMessageHelper.setTo("1640722136@qq.com");
        mimeMessageHelper.setFrom("1640722136@qq.com");
        javaMailSender.send(mimeMessage);
    }
}
