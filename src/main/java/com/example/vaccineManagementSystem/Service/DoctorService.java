package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Enums.Gender;
import com.example.vaccineManagementSystem.Exceptions.*;
import com.example.vaccineManagementSystem.Models.Doctor;
import com.example.vaccineManagementSystem.Models.VaccinationCenter;
import com.example.vaccineManagementSystem.Repository.DoctorRepository;
import com.example.vaccineManagementSystem.Repository.VaccinationCenterRepository;
import com.example.vaccineManagementSystem.RequestDtos.AddDoctorDto;
import com.example.vaccineManagementSystem.RequestDtos.AssociateDocDto;
import com.example.vaccineManagementSystem.ResponseDtos.DoctorDtoForCentre;
import com.example.vaccineManagementSystem.Transformer.DoctorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public String addDoctor(AddDoctorDto doctor) throws EmailIdEmptyException,DoctorAlreadyExistsException {

        if(doctor.getEmailId()==(null)){
           throw new EmailIdEmptyException("Email id is mandatory") ;
        }

        if(doctorRepository.findByEmailId(doctor.getEmailId())!=null){
            throw new DoctorAlreadyExistsException("Doctor with this emailId already exits.");
        }

        Doctor doctorNew= DoctorTransformer.convertDtoToEntity(doctor);
        doctorRepository.save(doctorNew);
        return "Doctor has been added to the database";
    }

    public String associateDoctor(AssociateDocDto associateDocDto) throws DoctorNotFound,CenterNotFound {

        Optional<Doctor> doctorOptional=doctorRepository.findById(associateDocDto.getDocId());
        if (!doctorOptional.isPresent()){
            throw new DoctorNotFound("Doctor id is wrong");
        }

        Optional<VaccinationCenter> optionalCenter = vaccinationCenterRepository.findById(associateDocDto.getCenterId());
        if(!optionalCenter.isPresent()){
            throw new CenterNotFound("Center Id entered is incorrect");
        }
        Doctor doctor = doctorOptional.get();
        VaccinationCenter vaccinationCenter = optionalCenter.get();

        doctor.setVaccinationCenter(vaccinationCenter); //Setting the foreign

        //Set the bidirectional map
        //Adding this doctor the list of doctors of that vaccination Center
        vaccinationCenter.getDoctorList().add(doctor);

        vaccinationCenterRepository.save(vaccinationCenter);

        return "Doctor has been associated to center";
    }


    public List<DoctorDtoForCentre> getDoctors(Integer centerId)throws VaccinationCentreNotFound {
    Optional<VaccinationCenter> vaccinationCenterOptional=vaccinationCenterRepository.findById(centerId);
    if(vaccinationCenterOptional.isEmpty()){
         throw new VaccinationCentreNotFound("Vaccination center is not Found");
    }
    List<Doctor> doctorList=vaccinationCenterOptional.get().getDoctorList();
    List<DoctorDtoForCentre> doctorList1 = new ArrayList<>();
    for(Doctor doctor: doctorList){
        doctorList1.add(DoctorTransformer.doctorToDoctorDtoForCentre(doctor));
    }
    return doctorList1;
    }

    public List<DoctorDtoForCentre> getMaleDoctors(Integer centerId) throws VaccinationCentreNotFound {

        Optional<VaccinationCenter> vaccinationCenterOptional=vaccinationCenterRepository.findById(centerId);
        if(vaccinationCenterOptional.isEmpty()){
            throw new VaccinationCentreNotFound("Vaccination center is not Found");
        }
        List<Doctor>doctorList=vaccinationCenterOptional.get().getDoctorList();
        List<DoctorDtoForCentre>doctorDtoForCentres=new ArrayList<>();
        for(Doctor doctor:doctorList){
            if(doctor.getGender().equals(Gender.MALE)){
               doctorDtoForCentres.add(DoctorTransformer.doctorToDoctorDtoForCentre(doctor));
            }
        }
        return doctorDtoForCentres;
    }

    public List<DoctorDtoForCentre> getAllFemaleDoctorsByCenterId(Integer centerId) throws VaccinationCentreNotFound {
        Optional<VaccinationCenter> centerOpt = vaccinationCenterRepository.findById(centerId);
        if(centerOpt.isEmpty()) {
            throw new VaccinationCentreNotFound("Centre is not present");
        }
        List<Doctor> doctors = centerOpt.get().getDoctorList();
        List<DoctorDtoForCentre> doctorList = new ArrayList<>();
        for (Doctor doctor : doctors) {
            if(doctor.getGender().equals(Gender.FEMALE)) {
                doctorList.add(DoctorTransformer.doctorToDoctorDtoForCentre(doctor));
            }
        }
        return doctorList;
    }
}

