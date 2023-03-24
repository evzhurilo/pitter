package com.zhurilo.pitter.repository;

import com.zhurilo.pitter.entity.Pitt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PittRepository extends CrudRepository<Pitt,Long> {
    List<Pitt> findPittsByUserId(Long user_id);
}
