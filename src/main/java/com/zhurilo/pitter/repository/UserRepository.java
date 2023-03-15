package com.zhurilo.pitter.repository;

import com.zhurilo.pitter.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
