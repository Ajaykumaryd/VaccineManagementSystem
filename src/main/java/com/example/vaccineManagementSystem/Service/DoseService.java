package com.example.vaccineManagementSystem.Service;

import com.example.vaccineManagementSystem.Models.Dose;
import com.example.vaccineManagementSystem.Models.User;
import com.example.vaccineManagementSystem.Repository.DoseRepository;
import com.example.vaccineManagementSystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    UserRepository userRepository;
    public String giveDose(String doseId, Integer userId) {

        User user = userRepository.findById(userId).get();
        //An Entity of that model has been created
        //This entity will be saved in the database
        Dose dose = new Dose();

        //setting its attributes
        dose.setDoseId(doseId);

        //setting primary key
        dose.setUser(user);

        //setting the child object in that corresponding
         user.setDose(dose);

        //Child will automatically get saved because of cascading effect.
        userRepository.save(user);

//        doseRepository.save(dose);

        return "Dose Given to user successfully";
    }
}
