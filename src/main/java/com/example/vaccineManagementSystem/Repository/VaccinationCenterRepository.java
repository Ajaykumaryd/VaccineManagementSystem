package com.example.vaccineManagementSystem.Repository;

import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {
}
