package com.example.vaccineManagementSystem.Models;

import com.example.vaccineManagementSystem.Enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name ="appointments")
@Data
public class Appointment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date appointmentDate;

    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus= AppointmentStatus.PENDING;

    @ManyToOne
    @JoinColumn
    private Doctor doctor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn
    private User user;






}
