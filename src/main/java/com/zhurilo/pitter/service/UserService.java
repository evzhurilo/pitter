package com.zhurilo.pitter.service;

import com.zhurilo.pitter.entity.User;
import com.zhurilo.pitter.entity.enums.Role;
import com.zhurilo.pitter.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(8);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    /* Can I use userDto in method createNewUser instead of
    creating a new object User?
     */
    public void createNewUser(String name, String surname, @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOfBirth,
                              String email, String password) {
        if (!userRepository.existsUserByEmail(email)) {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            User user = new User(name, surname, dateOfBirth, email, password);
            //Setting role for the user
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.getRoles().add(Role.ROLE_USER);
        /* why don't see information in console about the user when
        creating a new user?
        -It's necessary to use {}, if you want to see the entire information
         */
            log.info("Creating a new user:{}", user.getEmail());
            userRepository.save(user);
        } else {
            throw new RuntimeException("User with following email already exists");
        }
    }


    //Spring security
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }
}
