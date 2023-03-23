package com.zhurilo.pitter.controller;

import com.zhurilo.pitter.entity.User;
import com.zhurilo.pitter.service.PittService;
import com.zhurilo.pitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PittController {

    @Autowired
    private final PittService pittService;

    @Autowired
    private final UserService userService;

    @PostMapping("/home/mypage/{id}")
    public String makePitt(@PathVariable Long id, @RequestParam String pitt) {
        User user = userService.getUserById(id);
        pittService.createPitt(pitt,user);
        return "redirect:/home";
    }


}
