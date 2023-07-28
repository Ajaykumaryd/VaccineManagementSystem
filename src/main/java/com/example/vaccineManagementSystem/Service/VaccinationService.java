package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Exceptions.VaccinationAddressNotFound;
import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import com.example.vaccineManagementSystem.Repository.VaccinationCenterRepository;
import com.example.vaccineManagementSystem.RequestDtos.VaccinationCentreDto;
import com.example.vaccineManagementSystem.Transformer.VaccinationCentreTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {


    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public String addVaccinationCenter(VaccinationCentreDto vaccinationCenter) throws VaccinationAddressNotFound {

      if(vaccinationCenter.getAddress()==null){
          throw new VaccinationAddressNotFound("Vaccination Address not found");
      }

        VaccinationCenter vaccinationCenterNew= VaccinationCentreTransformer.ConvertDtoToEntity(vaccinationCenter);
        vaccinationCenterRepository.save(vaccinationCenterNew);
      return "Vaccination center added at a location "+vaccinationCenter.getAddress();
    }
}
