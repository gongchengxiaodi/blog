package com.huihui.controller.view;

import com.huihui.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;

@Controller
public class EmailViewController {

    @Autowired
    private EmailService emailService ;

    @RequestMapping("/toEmail")
    public String toEmail(){
        return "view/email";
    }


    @RequestMapping("/sendEmail")
    public String sendEmail(@RequestParam("title") String title, @RequestParam("email") String email,
                            @RequestParam("content") String content) throws MessagingException {
        emailService.send(title,email,content);
        return "redirect:/index";
    }



}
