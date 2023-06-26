package com.example.vaccineManagementSystem.Models;


import com.example.vaccineManagementSystem.Enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String name;

    private int age;

    @Column(unique = true)
    private String emailId;


    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
     private Dose dose;


    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Appointment> appointmentList = new ArrayList<>();



     }
