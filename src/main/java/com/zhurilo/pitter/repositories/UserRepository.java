package com.zhurilo.pitter.repositories;

import com.zhurilo.pitter.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    boolean existsUserByEmail(String email);

}
