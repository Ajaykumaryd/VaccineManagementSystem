package com.example.vaccineManagementSystem.RequestDtos;

import lombok.Data;

import java.util.Date;

@Data
public class ChangeAppointmentDate {
    private Integer appointmentId;
    private Integer userId;
    private Date date;

}
