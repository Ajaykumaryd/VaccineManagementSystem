package com.example.vaccineManagementSystem.Transformer;

import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.RequestDtos.AddUserDto;
import com.example.vaccineManagementSystem.ResponseDtos.UserResponseDto;
import lombok.Builder;


public class UserTransformer {

    public static User ConvertDtoToEntity (AddUserDto addUserDto){

    User user= User.builder()
               .emailId(addUserDto.getEmailId()).name(addUserDto.getName())
               .age(addUserDto.getAge()).gender(addUserDto.getGender())
               .mobileNo(addUserDto.getMobileNo())
               .build();
    return user;

    }

    public static UserResponseDto ConvertEntityToEntity(User user){

    UserResponseDto userResponseDto=UserResponseDto.builder().
            gender(user.getGender())
            .age(user.getAge())
            .name(user.getName())
            .mobileNo(user.getMobileNo())
            .emailId(user.getEmailId())
            .build();

    return userResponseDto;


    }
}
