package com.microservices.task.userservice.service;

import com.microservices.task.userservice.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public interface UserService {

    public User createUser(User user);

//    public User getOneUser(int id);

    public User getOneUser(int id);

        public List<User> getAllUser();

    public User updateUser(int id, User updatedUser);

    public void deleteUser(int id);


}