package com.microservices.task.userservice.serviceImpl;

import com.microservices.task.userservice.entity.Patient;
import com.microservices.task.userservice.entity.User;
import com.microservices.task.userservice.repository.UserServiceRepo;
import com.microservices.task.userservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceRepo userServiceRepo;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User createUser(User user) {
        return userServiceRepo.save(user);
    }

    @Override
    public User getOneUser(int id) {
        User user=userServiceRepo.findById(id).get();
//        ArrayList<Patient> patientOfUser=restTemplate.getForObject("http://localhost:8082/patient/"+user.getUserId(), ArrayList.class);
//         logger.info("{} ",patientOfUser);
//         user.setPatients(patientOfUser);
        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userServiceRepo.findAll();
    }

    @Override
    public User updateUser(int id, User updatedUser) {
        User user=userServiceRepo.findById(id).get();
        if(updatedUser.getFirstName()!=null)
        {
            user.setFirstName(updatedUser.getFirstName());
        }
        if(updatedUser.getLastName()!=null)
        {
            user.setLastName(updatedUser.getLastName());
        }
        if(updatedUser.getEmailId()!=null)
        {
            user.setEmailId(updatedUser.getEmailId());
        }
        return userServiceRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userServiceRepo.deleteById(id);
    }
}

