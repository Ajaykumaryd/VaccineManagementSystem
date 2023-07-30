package com.example.vaccineManagementSystem.RequestDtos;

import com.example.vaccineManagementSystem.Enums.AppointmentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;

@Data
public class AppointmentReqDto {

    private Integer docId;

    private Integer userId;

    private Date appointmentDate;

    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    private AppointmentStatus AppointmentStatus;

}
