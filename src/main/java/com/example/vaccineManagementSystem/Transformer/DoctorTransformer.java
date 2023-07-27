package com.example.vaccineManagementSystem.Transformer;


import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.RequestDtos.AddDoctorDto;

public class DoctorTransformer {

    public static Doctor convertDtoToEntity(AddDoctorDto addDoctorDto){

     Doctor doctor=Doctor.builder().
                   name(addDoctorDto.getName()).
                   age(addDoctorDto.getAge()).
                   emailId(addDoctorDto.getEmailId())
                  .gender(addDoctorDto.getGender())
                  .build();
     return doctor;
    }


}
