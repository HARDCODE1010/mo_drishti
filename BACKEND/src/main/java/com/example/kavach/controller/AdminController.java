package com.example.kavach.controller;
import com.example.kavach.model.Coordinates;
import com.example.kavach.model.SiteLocation;
import com.example.kavach.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping("/passCoordinates")
    private String passCoordinates(@RequestBody SiteLocation adminParameters){

        return adminService.saveCoordinates(adminParameters);
    }

    @GetMapping("/getCoordinates/{id}")
    private SiteLocation getCoordinates(@PathVariable String id){
        return adminService.getCoordinates(id);
    }
}
