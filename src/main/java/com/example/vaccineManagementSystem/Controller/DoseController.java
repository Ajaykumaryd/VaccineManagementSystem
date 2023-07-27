package com.example.vaccineManagementSystem.Controller;

import com.example.vaccineManagementSystem.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

    @PostMapping("/giveDose1")
    public ResponseEntity<String>  giveDose(@RequestParam("doseId")String doseId, @RequestParam("userId")Integer userId){
        String result= doseService.giveDose(doseId,userId);
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
    }


}
