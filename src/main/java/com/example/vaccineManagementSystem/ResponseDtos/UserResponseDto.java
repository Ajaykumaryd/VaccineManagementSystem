package com.example.vaccineManagementSystem.ResponseDtos;

import com.example.vaccineManagementSystem.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDto {
    private String name;
    private int age;
    private String emailId;
    private Gender gender;
    private String mobileNo;
    private String statusCode;
    private String statusMessage;
}
