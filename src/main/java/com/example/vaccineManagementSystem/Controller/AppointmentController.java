package com.example.vaccineManagementSystem.Controller;


import com.example.vaccineManagementSystem.RequestDtos.AppointmentReqDto;
import com.example.vaccineManagementSystem.RequestDtos.CancelAppointmentRequestDto;
import com.example.vaccineManagementSystem.RequestDtos.ChangeAppointmentDate;
import com.example.vaccineManagementSystem.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;


    @PostMapping("/book")
    public ResponseEntity<String> bookAppointment(@RequestBody AppointmentReqDto appointmentReqDto){
        try {
            String result = appointmentService.bookAppointment(appointmentReqDto);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAppointment(@RequestBody CancelAppointmentRequestDto cancelAppointmentRequestDto){

    try{
        String result=appointmentService.deleteAppointment(cancelAppointmentRequestDto);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }catch (Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
    }


    @PutMapping("/changeDate")
    public ResponseEntity<String> changeDate(@RequestBody ChangeAppointmentDate changeAppointmentDate){

     try{
         String res=appointmentService.changeDate(changeAppointmentDate);
         return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
     }catch (Exception e){
          return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
     }
    }

}
