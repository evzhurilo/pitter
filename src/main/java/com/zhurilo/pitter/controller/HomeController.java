package com.zhurilo.pitter.controller;

import com.zhurilo.pitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    public String getToHome(Model model){
        model.addAttribute("title"
                ,"Pitter");
        return "home";
    }

    @GetMapping("home/signup")
    public String getToSignUp(Model model){
        model.addAttribute("title", "Sign UP");
        return "sign-up";
    }

    @GetMapping("home/login")
    public String getToLogin(Model model){
        model.addAttribute("title", "Log IN");
        return "login";
    }
    @GetMapping("home/about")
    public String getToAbout(Model model){
        model.addAttribute("title", "About");
        return "about";
    }
    @GetMapping("home/mypage")
    public String getToMyPage(Model model){
        model.addAttribute("title", "My Page");
        return "my-page";
    }

}
