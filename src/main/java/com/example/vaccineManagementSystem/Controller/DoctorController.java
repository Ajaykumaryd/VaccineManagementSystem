package com.example.vaccineManagementSystem.Controller;

import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.RequestDtos.AddDoctorDto;
import com.example.vaccineManagementSystem.RequestDtos.AssociateDocDto;
import com.example.vaccineManagementSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {


    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<String> addDoctor(@RequestBody AddDoctorDto addDoctorDto) {

        try {
            String response = doctorService.addDoctor(addDoctorDto);
            return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/associateWithCenter")
    public ResponseEntity<String> associateDoctor(@RequestBody AssociateDocDto associateDocDto){

        try{
            String result = doctorService.associateDoctor(associateDocDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



}
