package com.example.vaccineManagementSystem.Service;


import com.example.vaccineManagementSystem.Exceptions.EmailIsAlreadyPresent;
import com.example.vaccineManagementSystem.Exceptions.EmailShouldNotNullException;
import com.example.vaccineManagementSystem.Exceptions.UserNotFound;
import com.example.vaccineManagementSystem.Models.Dose;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import com.example.vaccineManagementSystem.RequestDtos.AddUserDto;
import com.example.vaccineManagementSystem.RequestDtos.updateEmailDto;
import com.example.vaccineManagementSystem.ResponseDtos.UserResponseDto;
import com.example.vaccineManagementSystem.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public String addUser(AddUserDto user) throws EmailShouldNotNullException,EmailIsAlreadyPresent{

    if(user.getEmailId()==null){
        throw new EmailShouldNotNullException("Email should not be null");
    }

//    Optional<User>optionalUser=  repository.findByEmailId(user.getEmailId());
//
//        if(optionalUser.isEmpty()) {
//        throw new EmailIsAlreadyPresent("Email is Already Present");
//    }

    User user1= UserTransformer.ConvertDtoToEntity(user);
    repository.save(user1);
    return "User Saved Successfully";
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
    return "email updated successfully "+emailDto.getNewEmailId();
    };

    public User getUser(String email) throws UserNotFound {

     Optional<User> optionalUser=repository.findByEmailId(email);
     if(optionalUser.isEmpty()){
         throw new UserNotFound("User is not Found");
     }
     return optionalUser.get();
    }

    public UserResponseDto getById(UserResponseDto userResponseDto) throws UserNotFound{


      Optional<User> optionalUserResponseDto=repository.findByEmailId(userResponseDto.getEmailId());
      if(optionalUserResponseDto.isEmpty()){
          throw new UserNotFound("User is not Presenet");
      }

      User user=optionalUserResponseDto.get();

      UserResponseDto userResponseDto1=UserTransformer.ConvertEntityToEntity(user);


     return userResponseDto1;

    }
}


