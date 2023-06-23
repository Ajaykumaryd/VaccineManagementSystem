package com.example.vaccineManagementSystem.RequestDtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class updateEmailDto {

    private int userId;
    private String newEmailId;
}
