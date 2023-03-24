package com.zhurilo.pitter.controller;

import com.zhurilo.pitter.service.PittService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private final PittService pittService;

    @GetMapping("/home")
    public String getToTheHomePage(Model model) {
        model.addAttribute("title", "Home page");
        model.addAttribute("allPitts",pittService.getAllPitts());
        return "home";
    }

    @GetMapping("/home/login")
    public String getToTheLogin(Model model) {
        model.addAttribute("title", "Log IN");
        return "login";
    }
}