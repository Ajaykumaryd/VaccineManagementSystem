package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Exceptions.DoctorAlreadyExistsException;
import com.example.vaccineManagementSystem.Exceptions.EmailIdEmptyException;
import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor) throws EmailIdEmptyException,DoctorAlreadyExistsException {


        if(doctor.getEmailId().equals(null)){
           throw new EmailIdEmptyException("Email id is mandatory") ;
        }

        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null){
            throw new DoctorAlreadyExistsException("Doctor with this emailId already exits.");
        }

        doctorRepository.save(doctor);
        return "Doctor has been added to the database";
    }
}
