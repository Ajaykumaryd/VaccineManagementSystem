package com.example.vaccineManagementSystem.Service;


import com.example.vaccineManagementSystem.Models.Dose;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import com.example.vaccineManagementSystem.RequestDtos.updateEmailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User addUser(User user) {
    return repository.save(user);
    }

    public Date getDate(Integer userId) {
        User user = repository.findById(userId).get();
        Dose dose = user.getDose();
        return dose.getVaccinationDate();
    }

    public String updateEmail(updateEmailDto emailDto) {
    int userId=emailDto.getUserId();
    User user=repository.findById(userId).get();
    user.setEmailId(emailDto.getNewEmailId());
    repository.save(user);
    return "email updated sucessfully"+emailDto.getNewEmailId();
    };
}


