package com.example.kavach.service;

import com.example.kavach.model.SiteLocation;

public interface AdminService {
    String saveCoordinates (SiteLocation adminParameters);

    SiteLocation getCoordinates(String id);
}
