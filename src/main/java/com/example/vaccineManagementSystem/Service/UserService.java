package com.example.vaccineManagementSystem.Service;


import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User addUser(User user) {
    return repository.save(user);
    }
}
