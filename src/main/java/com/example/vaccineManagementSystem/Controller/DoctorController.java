package com.example.vaccineManagementSystem.Controller;

import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.RequestDtos.AddDoctorDto;
import com.example.vaccineManagementSystem.RequestDtos.AssociateDocDto;
import com.example.vaccineManagementSystem.ResponseDtos.DoctorDtoForCentre;
import com.example.vaccineManagementSystem.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

      @GetMapping("/getAllDoctors/{CenterId}")
       public ResponseEntity<List<DoctorDtoForCentre>> getAllDoctorsByCenterId(@PathVariable Integer CenterId) {
        try {
            List<DoctorDtoForCentre> doctorList=doctorService.getDoctors(CenterId);
            return new ResponseEntity<>(doctorList,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
      }

    @GetMapping("/allMaleDoctors/{centerId}")
    public ResponseEntity<List<DoctorDtoForCentre>> getAllMaleDoctors(@PathVariable Integer centerId){
    try{
        List<DoctorDtoForCentre>doctorDtoForCentres=doctorService.getMaleDoctors(centerId);
        return new ResponseEntity<>(doctorDtoForCentres,HttpStatus.FOUND);
    }catch (Exception e){
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping("/allFemaleDoctors/{centerId}")
    public ResponseEntity<List<DoctorDtoForCentre>> getAllFemaleDoctorsByCenterId(@PathVariable Integer centerId) {
        try {
            List<DoctorDtoForCentre> list = doctorService.getAllFemaleDoctorsByCenterId(centerId);
            return new ResponseEntity<>(list, HttpStatus.FOUND);
        } catch (Exception re) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



}
