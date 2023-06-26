package com.example.vaccineManagementSystem.Controller;


import com.example.vaccineManagementSystem.RequestDtos.AppointmentReqDto;
import com.example.vaccineManagementSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;




    @PostMapping("/book")
    public String bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto){

        try {
            String result = appointmentService.bookAppointment(appointmentReqDto);
            return result;
        } catch (Exception e){
            return e.getMessage();
        }
    }


















}
