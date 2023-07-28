package com.example.vaccineManagementSystem.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccination_center")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VaccinationCenter {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String centreName;

    private LocalTime openingTime;

    private LocalTime closingTime;

    private String address;

    private int doseCapacity;

     @JsonIgnore
    @OneToMany(mappedBy ="vaccinationCenter",cascade=CascadeType.ALL)
    private List<Doctor> doctorList = new ArrayList<>();



}
