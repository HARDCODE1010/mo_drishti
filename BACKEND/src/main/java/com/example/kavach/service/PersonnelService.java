package com.example.kavach.service;

import com.example.kavach.model.Personnel;

import java.util.List;

public interface PersonnelService {
    String addPersonnel(Personnel personnel);

    List<Personnel> findPersonnelByName(String name);

    List<Personnel> findPersonnelByPosAndAvl (String position);

    List<Personnel> findPersonnelByPosition (String position);

}
