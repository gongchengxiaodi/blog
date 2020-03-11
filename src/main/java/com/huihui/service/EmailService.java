package com.huihui.service;

import javax.mail.MessagingException;

public interface EmailService {
    public void send(String title,String email,String content) throws MessagingException;
}
