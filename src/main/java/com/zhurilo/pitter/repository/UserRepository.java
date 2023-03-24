package com.zhurilo.pitter.repository;

import com.zhurilo.pitter.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    boolean existsUserByEmail(String email);
}
