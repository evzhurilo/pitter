package com.zhurilo.pitter.service;

import com.zhurilo.pitter.entity.User;
import com.zhurilo.pitter.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import java.util.Date;
@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
    }

    /* Can I use userDto in method createNewUser instead of
    creating a new object User?
     */
    public void createNewUser(String name, String surname, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                              String email, String password){
        if(!userRepository.existsUserByEmail(email)) {
            User user = new User(name, surname, dateOfBirth, email, password);
        /* why don't see information in console about the user when
        creating a new user?
        -It's necessary to use {}, if you want to see the entire information
         */
            log.info("Creating a new user:{}", user);
            userRepository.save(user);
        }
        else {
            throw new RuntimeException("User with following email already exists");
        }
    }
}
