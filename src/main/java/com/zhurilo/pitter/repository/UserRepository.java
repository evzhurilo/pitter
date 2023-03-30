package com.zhurilo.pitter.repository;

import com.zhurilo.pitter.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends CrudRepository<User,Long>{
    boolean existsUserByEmail(String email);

    User findUserByEmail(String email);

}
