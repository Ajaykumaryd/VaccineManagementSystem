package com.example.vaccineManagementSystem.Controller;


import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

     @Autowired
     UserService service;

     @PostMapping("/add")
     public User addUser(@RequestBody User user){
      return service.addUser(user);
     }








}
