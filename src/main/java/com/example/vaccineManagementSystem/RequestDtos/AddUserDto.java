package com.example.vaccineManagementSystem.RequestDtos;

import com.example.vaccineManagementSystem.Enums.Gender;
import lombok.Data;

@Data
public class AddUserDto {

    private String name;
    private int age;
    private String emailId;
    private Gender gender;
    private String mobileNo;

}
