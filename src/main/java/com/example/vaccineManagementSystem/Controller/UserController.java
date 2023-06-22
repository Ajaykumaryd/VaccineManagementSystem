package com.example.vaccineManagementSystem.Controller;


import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {

     @Autowired
     UserService service;

     @PostMapping("/add")
     public User addUser(@RequestBody User user){
      return service.addUser(user);
     }


     @GetMapping("/date")
     public Date getDate (@RequestParam Integer userId){
      return service.getDate(userId);
     }






}
