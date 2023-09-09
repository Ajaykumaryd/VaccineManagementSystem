package com.example.vaccineManagementSystem.Controller;


import com.example.vaccineManagementSystem.Exceptions.EmailIsAlreadyPresent;
import com.example.vaccineManagementSystem.Exceptions.EmailShouldNotNullException;
import com.example.vaccineManagementSystem.Exceptions.UserNotFound;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.RequestDtos.AddUserDto;
import com.example.vaccineManagementSystem.RequestDtos.updateEmailDto;
import com.example.vaccineManagementSystem.ResponseDtos.UserResponseDto;
import com.example.vaccineManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

     @Autowired
     UserService service;

     @PostMapping("/add")
     public ResponseEntity<String> addUser(@RequestBody AddUserDto addUserDto) throws EmailShouldNotNullException,EmailIsAlreadyPresent
     {
       try {
           String result=service.addUser(addUserDto);
           return new ResponseEntity<>(result,HttpStatus.CREATED);
       }catch (Exception E){
           return new ResponseEntity<>(E.getMessage(),HttpStatus.NOT_FOUND);
       }
     }


     @GetMapping("/date")
     public Date getDate (@RequestParam Integer userId){
      return service.getDate(userId);
     }



    @PutMapping("/updateEmail")
    public String updateEmail(@RequestBody updateEmailDto emailDto){

        return service.updateEmail(emailDto);
    }

    @GetMapping("/getByEmail/{emailId}")
     public ResponseEntity<User> getUserById(@PathVariable("emailId")String email) throws UserNotFound {

      try {
          User user=service.getUser(email);
          return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
      }catch (Exception e){
          return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
      }
    }

//      @GetMapping("/getByEmail")
//      public ResponseEntity<UserResponseDto> getUserById(@RequestBody UserResponseDto userResponseDto){
//
//      try{
//      UserResponseDto userResponseDtoNew=service.getById(userResponseDto);
//      userResponseDtoNew.setStatusMessage("SUCCESS");
//      userResponseDtoNew.setStatusCode("200");
//      return new ResponseEntity<>(userResponseDtoNew,HttpStatus.FOUND);
//
//      }catch (Exception e){
//         userResponseDto.setStatusCode("500");
//         userResponseDto.setStatusMessage("Failure");
//         return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
//      }
//
//      }

        @GetMapping("/getVaccinatedDate")
        public ResponseEntity<String> getVaccinationDate(@RequestParam("userId") Integer userId){
        try{
           Date date=service.getVacDate(userId);
            return new ResponseEntity<>(date.toString(),HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
     }
}
