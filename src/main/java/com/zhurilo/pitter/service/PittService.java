package com.zhurilo.pitter.service;

import com.zhurilo.pitter.entity.Pitt;
import com.zhurilo.pitter.entity.User;
import com.zhurilo.pitter.repository.PittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PittService {
    @Autowired
    private PittRepository pittRepository;

    public Pitt createPitt(String text, User user){
        return pittRepository.save(Pitt.builder().user(user).pitt(text).build());
    }

}
