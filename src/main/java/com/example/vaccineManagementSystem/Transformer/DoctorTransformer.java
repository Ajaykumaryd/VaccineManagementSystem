package com.example.vaccineManagementSystem.Transformer;


import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.RequestDtos.AddDoctorDto;
import com.example.vaccineManagementSystem.ResponseDtos.DoctorDtoForCentre;

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

    public static DoctorDtoForCentre doctorToDoctorDtoForCentre(Doctor doctor) {
        DoctorDtoForCentre doctorDto = DoctorDtoForCentre.builder()
                .name(doctor.getName())
                .gender(doctor.getGender())
                .age(doctor.getAge())
                .build();
        return doctorDto;
    }

}
