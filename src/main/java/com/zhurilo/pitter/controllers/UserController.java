package com.zhurilo.pitter.controllers;

import com.zhurilo.pitter.repositories.UserRepository;
import com.zhurilo.pitter.services.PittService;
import com.zhurilo.pitter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
@Configuration
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PittService pittService;

    @GetMapping("/home/signup")
    public String showAddUserForm(Model model) {
        model.addAttribute("title","Registration");
        return "sign-up";
    }

    @PostMapping("/home/signup")
    public String signupSubmit(@RequestParam String name, @RequestParam String surname, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
                               @RequestParam String email, @RequestParam String password) {

        userService.createNewUser(name,surname,dateOfBirth,email,password);
        return "redirect:/home";
    }

    @GetMapping("/home/mypage/{id}")
    public String goToMyPage(@PathVariable Long id,Model model) {
        model.addAttribute("title","User id: "+id);
        model.addAttribute("user",userService.getUserById(id));
        return "my-page";
    }

    @PostMapping("/home/mypage/{id}")
    public String signupSubmit(@PathVariable Long id,@RequestParam String text) {
        pittService.createPitt(text,userService.getUserById(id));
        return "redirect:/home/mypage/{id}";
    }
}