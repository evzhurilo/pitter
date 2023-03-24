package com.zhurilo.pitter.service;

import com.zhurilo.pitter.entity.Pitt;
import com.zhurilo.pitter.entity.User;
import com.zhurilo.pitter.repository.PittRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PittService {
    @Autowired
    private PittRepository pittRepository;

    public void createPitt(String text, User user) {
        pittRepository.save(Pitt.builder().user(user).pitt(text).build());
    }

    /*Method for getting all the pitts from db to show them on the homepage
     *Question*/
    public List<String> getAllPitts() {
        //??? List <Pitt> pittList = pittRepository.findAll().iterator().next().getUser().getPittList();
        List<Pitt> pittList = new ArrayList<>();
        pittRepository.findAll().forEach(pittList::add);
        return pittList.stream().map(Pitt::getPitt).collect(Collectors.toList());
    }

    /*Method for getting all the user's pitts from db to show them on the mypage*/
    /*Necessary to make the method to add the new added Pitt on the first place of the list*/
    public List<String> getAllUsersPitts(Long id) {
        List<Pitt> userPittList = new ArrayList<>(pittRepository.findPittsByUserId(id));
        return userPittList.stream().map(Pitt::getPitt).collect(Collectors.toList());
    }

    /*This method get only one pitt from the database.
     * ??? Question*/
//    public String getAllPitts(){
//        return pitt Repository.findAll().iterator().next().getPitt();
//    }
}
