package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Exceptions.DoctorNotFound;
import com.example.vaccineManagementSystem.Exceptions.UserNotFound;
import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.AppointmentRepository;
import com.example.vaccineManagementSystem.Repository.DoctorRepository;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import com.example.vaccineManagementSystem.RequestDtos.AppointmentReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private UserRepository userRepository;
    public String bookAppointment(AppointmentReqDto appointmentReqDto) throws DoctorNotFound,   UserNotFound{

        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentReqDto.getDocId());
        Optional<Doctor> doctorOptional = doctorRepository.findById(appointmentReqDto.getDocId()); //null/0
        if(!doctorOptional.isPresent()){
            throw new DoctorNotFound("DoctorId not found");
        }
        Optional<User> userOptional = userRepository.findById(appointmentReqDto.getUserId());
        if(!userOptional.isPresent()){
            throw new UserNotFound("UserId not found");
        }

    }
}
