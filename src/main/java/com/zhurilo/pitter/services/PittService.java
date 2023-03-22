package com.zhurilo.pitter.services;

import com.zhurilo.pitter.models.Pitt;
import com.zhurilo.pitter.models.User;
import com.zhurilo.pitter.repositories.PittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PittService {
    @Autowired
    PittRepository pittRepository;

    public void createPitt(String text,User user){
        user.addPittToList(pittRepository.save(new Pitt(text)));
    }
}
