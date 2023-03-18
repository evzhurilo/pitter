package com.zhurilo.pitter.controller;

import com.zhurilo.pitter.model.User;
import com.zhurilo.pitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/home/signup")
    public String showAddUserForm(Model model) {
        model.addAttribute("title","Registration");
        return "sign-up";
    }

    @PostMapping("/home/signup")
    public String signupSubmit(@RequestParam String name, @RequestParam String surname, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfBirth,
                               @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setDateOfBirth(dateOfBirth);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/home";
    }


}