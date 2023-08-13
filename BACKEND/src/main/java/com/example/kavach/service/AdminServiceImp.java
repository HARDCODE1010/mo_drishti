package com.example.kavach.service;
import com.example.kavach.model.Coordinates;
import com.example.kavach.model.SiteLocation;
import com.example.kavach.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public String saveCoordinates (SiteLocation adminParameters) {
        adminRepository.save(adminParameters);
        return adminParameters.getId();
        
    }

    @Override
    public SiteLocation getCoordinates(String id) {
        return adminRepository.findById(id).get();
    }
}
