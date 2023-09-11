package com.example.vaccineManagementSystem.RequestDtos;

import lombok.*;

import java.time.LocalTime;

@Data
@Getter
@Setter

public class VaccinationCentreDto {

    private String centreName;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private String address;

    private int doseCapacity;

}
