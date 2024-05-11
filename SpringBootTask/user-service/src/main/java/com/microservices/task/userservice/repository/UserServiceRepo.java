package com.microservices.task.userservice.repository;

import com.microservices.task.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepo extends JpaRepository<User,Integer> {

}