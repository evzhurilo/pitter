package com.zhurilo.pitter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/home")
    public String getToTheHomePage(Model model) {
        model.addAttribute("title", "Home page");
        return "home";

    }

    @GetMapping("/home/login")
    public String getToTheLogin(Model model) {
        model.addAttribute("title", "Log IN");
        return "login";
    }
}