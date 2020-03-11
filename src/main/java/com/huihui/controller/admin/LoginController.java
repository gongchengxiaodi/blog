package com.huihui.controller.admin;

import com.huihui.domain.User;
import com.huihui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService ;

    @RequestMapping({"/toLogin","/"})
    public String toLogin(){
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.queryUserByName(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                session.setAttribute("user",user);
                return "admin/index";
            }else{
                session.setAttribute("flag","用户名密码有误");
                return "redirect:/admin/toLogin";

            }
        }else{
            session.setAttribute("flag","用户名密码有误");
            return "redirect:/admin/toLogin";
        }
    }


    @RequestMapping("/logout")
    public String logout(HttpSession session){
        if(session.getAttribute("flag") != null){
            session.removeAttribute("flag");
        }
        session.removeAttribute("user");
        return "redirect:/admin/toLogin";
    }

}
