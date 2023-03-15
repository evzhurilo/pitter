package com.zhurilo.pitter.controller;

import com.zhurilo.pitter.model.User;
import com.zhurilo.pitter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String signupSubmit(@RequestParam String name, @RequestParam String surname, @RequestParam Integer age,
                               @RequestParam String email, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setAge(age);
        user.setPassword(password);
        userRepository.save(user);
        return "registration";
    }

}