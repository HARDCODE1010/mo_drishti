package com.example.kavach.service;


import com.example.kavach.exception.ErrorDetails;
import com.example.kavach.model.Personnel;
import com.example.kavach.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonnelServiceImpl implements PersonnelService {

    @Autowired
    PersonnelRepository personnelRepository;

    @Override
    public String addPersonnel (Personnel personnel) {
        personnel.setJoining(LocalDateTime.now());
        if(!personnelRepository.existsByEmail(personnel.getEmail()) && !personnelRepository.existsByPhone(personnel.getPhone())) {
            personnelRepository.save(personnel);
        }
        return personnel.id;
    }

    @Override
    public List<Personnel> findPersonnelByName (String name) {
        return personnelRepository.findByName(name);
    }

    @Override
    public List<Personnel> findPersonnelByPosAndAvl (String position) {
        List<Personnel> availablePersonnel = new ArrayList<>();
        for(Personnel personnel: personnelRepository.findByPosition(position)){
            if (personnel.isAvailable()){
                availablePersonnel.add(personnel);
            }
        }
        return availablePersonnel;
    }

    @Override
    public List<Personnel> findPersonnelByPosition (String position) {
        return personnelRepository.findByPosition(position);
    }

}
