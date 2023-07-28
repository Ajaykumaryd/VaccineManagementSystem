package com.example.vaccineManagementSystem.Transformer;

import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import com.example.vaccineManagementSystem.RequestDtos.VaccinationCentreDto;

public class VaccinationCentreTransformer {

    public static VaccinationCenter ConvertDtoToEntity(VaccinationCentreDto vaccinationCentreDto){

      VaccinationCenter vaccinationCenter=VaccinationCenter.builder()
              .doseCapacity(vaccinationCentreDto.getDoseCapacity())
              .centreName(vaccinationCentreDto.getCentreName())
              .closingTime(vaccinationCentreDto.getClosingTime())
              .openingTime(vaccinationCentreDto.getOpeningTime())
              .address(vaccinationCentreDto.getAddress())
              .build();

      return vaccinationCenter;
    }
}
