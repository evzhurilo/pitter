package com.zhurilo.pitter.controller;

import com.zhurilo.pitter.convertor.UserConvertor;
import com.zhurilo.pitter.dto.UserDto;
import com.zhurilo.pitter.service.PittService;
import com.zhurilo.pitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final PittService pittService;

    @Autowired
    private final UserConvertor userConvertor;


    @GetMapping("/home/signup")
    public String showAddUserForm(Model model) {
        model.addAttribute("title", "Registration");
        return "sign-up";
    }

    @PostMapping("/home/signup")
    public String signupSubmit(@RequestParam String name, @RequestParam String surname, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                               @RequestParam String email, @RequestParam String password) {
        userService.createNewUser(name, surname, dateOfBirth, email, password);
        return "redirect:/home";
    }

    @GetMapping("/home/mypage/{id}")
    public String goToMyPage(@PathVariable Long id, Model model) {
        UserDto userDto = userConvertor.toUserDto(userService.getUserById(id));
        model.addAttribute("title", "User id: " + id);
        model.addAttribute("user", userDto);
        model.addAttribute("allUsersPitts", pittService.getAllUsersPitts(id));
        return "my-page";
    }

}