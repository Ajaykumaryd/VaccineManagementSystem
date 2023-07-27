package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import com.example.vaccineManagementSystem.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {


    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public String addVaccinationCenter(VaccinationCenter vaccinationCenter) throws VaccinationAddressNotFound {

      if(vaccinationCenter.getAddress()==null){
          throw new VaccinationAddressNotFound("Vaccination Adress not found");
      }
      vaccinationCenterRepository.save(vaccinationCenter);

      return "Vaccination center added at a location "+vaccinationCenter.getAddress();
    }
}
