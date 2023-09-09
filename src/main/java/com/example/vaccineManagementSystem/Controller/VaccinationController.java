package com.example.vaccineManagementSystem.Controller;


import com.example.vaccineManagementSystem.Exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import com.example.vaccineManagementSystem.RequestDtos.VaccinationCentreDto;
import com.example.vaccineManagementSystem.Service.VaccinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationController {


    @Autowired
    VaccinationService vaccinationService;

    @PostMapping("/add")
    public ResponseEntity<String> addCenter(@RequestBody VaccinationCentreDto vaccinationCentreDto){
        try {
            String result = vaccinationService.addVaccinationCenter(vaccinationCentreDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (VaccinationAddressNotFound e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }









}
